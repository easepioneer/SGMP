var tmdr_gridstore;
var tmdr_grid_selections;
var tmdr_grid_selmodel;
var pdr_gridstore;
var pdr_grid_selections;
var pdr_grid_selmodel;
var adr_gridstore;
var adr_grid_selections;
var adr_grid_selmodel;

function initTmdrFilterForm() {
    Ext.getCmp('tmdr-filter-formfield-org').setValue(1);
}

function initPdrFilterForm() {
    Ext.getCmp('pdr-filter-formfield-org').setValue(1);
}

function initAdrFilterForm() {
    Ext.getCmp('adr-filter-formfield-org').setValue(1);
}

function getCollectionManagementFunctions() {
    var defaultPageSize = 100;
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////// 台区考核表数据召测 ///////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    var tmdrFilterTgListStoreWithAll = Ext.create('Ext.data.Store', {
        // destroy the store if the grid is destroyed
        autoDestroy: true,
        model: 'tg-liststore-model',
        remoteSort: false,
        proxy: {
            // load using script tags for cross domain, if the data in on the same domain as
            // this page, an HttpProxy would be better
            type: 'ajax',
            url: ctx_webapp + '/am/tam!getTgList.do',
            reader: {
                type: 'json',
                root: 'records'
            }
        },
        // 
        autoLoad: false
    });

    var tmdrFilterMeterListStoreWithAll = Ext.create('Ext.data.Store', {
        // destroy the store if the grid is destroyed
        autoDestroy: true,
        model: 'meter-liststore-model',
        remoteSort: false,
        proxy: {
            // load using script tags for cross domain, if the data in on the same domain as
            // this page, an HttpProxy would be better
            type: 'ajax',
            url: ctx_webapp + '/am/tam!getMeterList.do',
            reader: {
                type: 'json',
                root: 'records'
            }
        },
        // 
        autoLoad: false
    });

    // 筛选条件表单
    var tmdr_filter_formpanel = Ext.create('Ext.form.Panel', {
        id: 'tmdr-filter-form',
        region: 'north',
        title: '筛选条件',
        frame: true,
        collapsible: true,
        margins: '5 5 5 5',
        bodyStyle: 'padding: 5px 5px 0 5px;',
        split: false,
        items: [{
            xtype: 'container',
            anchor: '100%',
            layout: 'hbox',
            items: [{
                xtype: 'container',
                layout: 'anchor',
                flex: 1,
                width: 240,
                items: [{
                    xtype: 'combobox',
                    id: 'tmdr-filter-formfield-org',
                    name: 'soOrgId',
                    fieldLabel: '所属机构',
                    labelWidth: 60,
                    allowBlank: false,
                    store: filterOrgnizationListStore,
                    valueField: 'id',
                    displayField: 'orgName',
                    emptyText: '请选择所属机构...',
                    queryMode: 'local',
                    forceSelection : true,
                    triggerAction : 'all',
                    editable: false,
                    listeners: {
                        change: function(combo, newValue, oldValue, eOpts) {
                            //alert("soOrgId : " + newValue);
                            if(!Ext.isEmpty(newValue)) {
                                Ext.getCmp('tmdr-filter-formfield-tg').reset();
                                Ext.getCmp('tmdr-filter-formfield-tg').getStore().removeAll();
                                Ext.getCmp('tmdr-filter-formfield-tg').getStore().load({
                                    params: {orgId: newValue, withAll: true},
                                    callback: function(records, operation, success) {
                                        Ext.getCmp('tmdr-filter-formfield-tg').setValue(0);
                                    },
                                    scope: this
                                });
                            }
                        }
                    }
                }]
            }, {
                xtype: 'container',
                layout: 'anchor',
                flex: 1,
                width: 240,
                items: [{
                    xtype: 'combobox',
                    id: 'tmdr-filter-formfield-tg',
                    name: 'soTgId',
                    fieldLabel: '台区名称',
                    labelWidth: 60,
                    allowBlank: false,
                    store: tmdrFilterTgListStoreWithAll,
                    valueField: 'id',
                    displayField: 'tgName',
                    emptyText: '请选择台区...',
                    queryMode: 'local',
                    forceSelection : true,
                    triggerAction : 'all',
                    editable: false,
                    listeners: {
                        change: function(combo, newValue, oldValue, eOpts) {
                            //alert("soTgId : " + newValue);
                            if(!Ext.isEmpty(newValue)) {
                                Ext.getCmp('tmdr-filter-formfield-meter').reset();
                                Ext.getCmp('tmdr-filter-formfield-meter').getStore().removeAll();
                                Ext.getCmp('tmdr-filter-formfield-meter').getStore().load({
                                    params: {orgId: Ext.getCmp('tmdr-filter-formfield-org').getValue(), tgId: newValue, withAll: true},
                                    callback: function(records, operation, success) {
                                        Ext.getCmp('tmdr-filter-formfield-meter').setValue(0);
                                    },
                                    scope: this
                                });
                            }
                        }
                    }
                }]
            }, {
                xtype: 'container',
                layout: 'anchor',
                flex: 1,
                width: 240,
                items: [{
                    xtype: 'combobox',
                    id: 'tmdr-filter-formfield-meter',
                    name: 'soGpId',
                    fieldLabel: '考核表名称',
                    labelWidth: 66,
                    allowBlank: false,
                    store: tmdrFilterMeterListStoreWithAll,
                    valueField: 'gpId',
                    displayField: 'mpName',
                    emptyText: '请选择考核表...',
                    queryMode: 'local',
                    forceSelection : true,
                    triggerAction : 'all',
                    editable: false,
                    value: '0',
                    listeners: {
                        change: function(combo, newValue, oldValue, eOpts) {
                            //alert("soGpId : " + newValue);
                        }
                    }
                }]
            }]
        }],
        buttonAlign: 'center',
        buttons: [{
            text: '查询',
            handler: function() {
                if(this.up('form').getForm().isValid()) {
                    var query_params = {
                    };
                    Ext.apply(query_params, tmdr_filter_formpanel.getForm().getValues(false));
                    tmdr_gridstore.currentPage = 1;
                    tmdr_gridstore.load({
                        params: query_params
                    });
                }
            }
        }]
    });
    // 考核表数据源
    Ext.define('tmdr-gridstore-model', {
        extend: 'Ext.data.Model',
        fields: [
            {name: 'GP_ID', type: 'int'},                                       /*  */
            {name: 'ORG_NAME', type: 'string'},                                 /* 所属机构 */
            {name: 'TG_NAME', type: 'string'},                                  /* 台区名称 */
            {name: 'MP_NAME', type: 'string'},                                  /* 考核表名称 */
            {name: 'ASSET_NO', type: 'string'},                                 /* 资产编号 */
            {name: 'LOGICAL_ADDR', type: 'string'},                             /* 集中器逻辑地址 */
            {name: 'GP_SN', type: 'int'},                                       /* 测量点序号 */
            {name: 'GP_ADDR', type: 'string'},                                  /* 通信地址 */
            {name: 'CT_TIMES', type: 'number', defaultValue: ' '},              /* CT倍率 */
            {name: 'PT_TIMES', type: 'number', defaultValue: ' '},              /* PT倍率 */
            {name: 'TOTAL_TIMES', type: 'number', defaultValue: ' '}            /* 总倍率 */
        ],
        idProperty: 'GP_ID'
    });
    tmdr_gridstore = Ext.create('Ext.data.Store', {
        pageSize: defaultPageSize,
        // destroy the store if the grid is destroyed
        autoDestroy: true,
        model: 'tmdr-gridstore-model',
        remoteSort: true,
        proxy: {
            // load using script tags for cross domain, if the data in on the same domain as
            // this page, an HttpProxy would be better
            type: 'ajax',
            url: ctx_webapp + '/cm/tmdr!getGrid.do',
            reader: {
                type: 'json',
                root: 'records',
                totalProperty: 'totalCount'
            },
            // sends single sort as multi parameter
            simpleSortMode: true
        },
        sorters: [{
            property: 'LOGICAL_ADDR',
            direction: 'ASC'
        }],
        // 
        autoLoad: false
    });
    // 考核表列表
    var tmdr_grid_pc = Ext.create('Ext.form.ComboBox', {
        fieldLabel: '每页记录数',
        store: Ext.create('Ext.data.Store', {
            fields: ['value', 'label'],
            data: [
                {"value": 10, "label": "10"},
                {"value": 20, "label": "20"},
                {"value": 50, "label": "50"},
                {"value": 100, "label": "100"},
                {"value": 200, "label": "200"},
                {"value": 500, "label": "500"}
            ]
        }),
        valueField: 'value',
        displayField: 'label',
        queryMode: 'local',
        forceSelection : true,
        triggerAction : 'all',
        editable: false,
        labelWidth: 70,
        width: 125,
        minWidth: 125,
        maxWidth: 125,
        value: tmdr_gridstore.pageSize,
        listeners: {
            beforeselect: function(combo, record, index, eOpts) {
                if(tmdr_gridstore.pageSize != record.data.value) {
                    tmdr_gridstore.currentPage = 1;
                    tmdr_gridstore.pageSize = record.data.value;
                    tmdr_gridstore.load();
                }
            }
        }
    });
    var tmdr_grid_pt = Ext.create('Ext.PagingToolbar', {
        store: tmdr_gridstore,
        displayInfo: true,
        displayMsg: '显示第&nbsp;{0}&nbsp;条到&nbsp;{1}&nbsp;条记录,共&nbsp;{2}&nbsp;条记录',
        emptyMsg: '查询无记录',
        items: ['-', tmdr_grid_pc]
    });
    tmdr_grid_selections = '';
    tmdr_grid_selmodel = Ext.create('Ext.selection.CheckboxModel', {
        listeners: {
            selectionchange: function(sm, selections) {
                tmdr_gridpanel.down('#tmdr-bmdata-reading-button').setDisabled(selections.length == 0);
                tmdr_gridpanel.down('#tmdr-fhdata-reading-button').setDisabled(selections.length == 0);
                tmdr_grid_selections = selections;
            }
        }
    });
    var tmdr_gridpanel = Ext.create('Ext.grid.Panel', {
        id: 'tmdr-grid',
        title: '考核表数据召测',
        xtype: 'grid',
        layout: 'fit',
        store: tmdr_gridstore,
        loadMask: true,
        columns: [
            /*{text: "序号", xtype: 'rownumberer', width: 50},*/
            {text: "测量点标识", dataIndex: 'GP_ID', sortable: false, hideable: true, hidden: true},
            {text: "所属机构", dataIndex: 'ORG_NAME', width: 120, sortable: true},
            {text: "台区名称", dataIndex: 'TG_NAME', width: 120, sortable: true},
            {text: "考核表名称", dataIndex: 'MP_NAME', width: 120, sortable: true},
            {text: "资产编号", dataIndex: 'ASSET_NO', width: 100, sortable: true},
            {text: "集中器逻辑地址", dataIndex: 'LOGICAL_ADDR', width: 120, sortable: true},
            {text: "测量点序号", dataIndex: 'GP_SN', width: 100, sortable: true},
            {text: "通信地址", dataIndex: 'GP_ADDR', width: 120, sortable: true},
            {text: "CT倍率", dataIndex: 'CT_TIMES', width: 60, sortable: true},
            {text: "PT倍率", dataIndex: 'PT_TIMES', width: 60, sortable: true},
            {text: "总倍率", dataIndex: 'TOTAL_TIMES', width: 60, sortable: true}
        ],
        plugins: [{
            ptype: 'rowexpander',
            rowBodyTpl : [
                '<p>&nbsp;　　　&nbsp;<b>召测状态：</b> <span id="cm_tmdr_rt_{GP_ID}"></span></p>',
                '<p>&nbsp;　　　&nbsp;<b>召测结果：</b> <span id="cm_tmdr_re_{GP_ID}"></span></p>'
            ]
        }],
        columnLines: false,
        selModel: tmdr_grid_selmodel,
        // paging bar on the bottom
        bbar: tmdr_grid_pt,
        // inline buttons
        dockedItems: [{
            xtype: 'toolbar',
            dock: 'top',
            items: [{
                itemId: 'tmdr-bmdata-reading-button',
                text: '表码数据召测',
                tooltip: '召测考核表表码数据',
                iconCls: 'reading',
                disabled: true,
                handler: function() {
                    //alert('召测考核表表码数据');
                    //Ext.get('cm_tmdr_rt_146').setHTML('召测成功');
                    //Ext.get('cm_tmdr_re_146').setHTML('12345678');
                }
            }, '-', {
                itemId: 'tmdr-fhdata-reading-button',
                text: '负荷数据召测',
                tooltip: '召测考核表负荷数据',
                iconCls: 'reading',
                disabled: true,
                handler: function() {
                    //alert('召测考核表负荷数据');
                }
            }, '->', '']
        }]
    });

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////// 保护器数据召测 /////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    var pdrFilterTgListStoreWithAll = Ext.create('Ext.data.Store', {
        // destroy the store if the grid is destroyed
        autoDestroy: true,
        model: 'tg-liststore-model',
        remoteSort: false,
        proxy: {
            // load using script tags for cross domain, if the data in on the same domain as
            // this page, an HttpProxy would be better
            type: 'ajax',
            url: ctx_webapp + '/am/tam!getTgList.do',
            reader: {
                type: 'json',
                root: 'records'
            }
        },
        // 
        autoLoad: false
    });

    var pdrFilterPsListStoreWithAll = Ext.create('Ext.data.Store', {
        // destroy the store if the grid is destroyed
        autoDestroy: true,
        model: 'ps-liststore-model',
        remoteSort: false,
        proxy: {
            // load using script tags for cross domain, if the data in on the same domain as
            // this page, an HttpProxy would be better
            type: 'ajax',
            url: ctx_webapp + '/am/tam!getPsList.do',
            reader: {
                type: 'json',
                root: 'records'
            }
        },
        // 
        autoLoad: false
    });

    // 筛选条件表单
    var pdr_filter_formpanel = Ext.create('Ext.form.Panel', {
        id: 'pdr-filter-form',
        region: 'north',
        title: '筛选条件',
        frame: true,
        collapsible: true,
        margins: '5 5 5 5',
        bodyStyle: 'padding: 5px 5px 0 5px;',
        split: false,
        items: [{
            xtype: 'container',
            anchor: '100%',
            layout: 'hbox',
            items: [{
                xtype: 'container',
                layout: 'anchor',
                flex: 1,
                width: 240,
                items: [{
                    xtype: 'combobox',
                    id: 'pdr-filter-formfield-org',
                    name: 'soOrgId',
                    fieldLabel: '所属机构',
                    labelWidth: 60,
                    allowBlank: false,
                    store: filterOrgnizationListStore,
                    valueField: 'id',
                    displayField: 'orgName',
                    emptyText: '请选择所属机构...',
                    queryMode: 'local',
                    forceSelection : true,
                    triggerAction : 'all',
                    editable: false,
                    listeners: {
                        change: function(combo, newValue, oldValue, eOpts) {
                            //alert("soOrgId : " + newValue);
                            if(!Ext.isEmpty(newValue)) {
                                Ext.getCmp('pdr-filter-formfield-tg').reset();
                                Ext.getCmp('pdr-filter-formfield-tg').getStore().removeAll();
                                Ext.getCmp('pdr-filter-formfield-tg').getStore().load({
                                    params: {orgId: newValue, withAll: true},
                                    callback: function(records, operation, success) {
                                        Ext.getCmp('pdr-filter-formfield-tg').setValue(0);
                                    },
                                    scope: this
                                });
                            }
                        }
                    }
                }]
            }, {
                xtype: 'container',
                layout: 'anchor',
                flex: 1,
                width: 240,
                items: [{
                    xtype: 'combobox',
                    id: 'pdr-filter-formfield-tg',
                    name: 'soTgId',
                    fieldLabel: '台区名称',
                    labelWidth: 60,
                    allowBlank: false,
                    store: pdrFilterTgListStoreWithAll,
                    valueField: 'id',
                    displayField: 'tgName',
                    emptyText: '请选择台区...',
                    queryMode: 'local',
                    forceSelection : true,
                    triggerAction : 'all',
                    editable: false,
                    value: '0',
                    listeners: {
                        change: function(combo, newValue, oldValue, eOpts) {
                            //alert("soTgId : " + newValue);
                            if(!Ext.isEmpty(newValue)) {
                                Ext.getCmp('pdr-filter-formfield-ps').reset();
                                Ext.getCmp('pdr-filter-formfield-ps').getStore().removeAll();
                                Ext.getCmp('pdr-filter-formfield-ps').getStore().load({
                                    params: {orgId: Ext.getCmp('pdr-filter-formfield-org').getValue(), tgId: newValue, withAll: true},
                                    callback: function(records, operation, success) {
                                        Ext.getCmp('pdr-filter-formfield-ps').setValue(0);
                                    },
                                    scope: this
                                });
                            }
                        }
                    }
                }]
            }, {
                xtype: 'container',
                layout: 'anchor',
                flex: 1,
                width: 240,
                items: [{
                    xtype: 'combobox',
                    id: 'pdr-filter-formfield-ps',
                    name: 'soGpId',
                    fieldLabel: '保护器名称',
                    labelWidth: 66,
                    allowBlank: false,
                    store: pdrFilterPsListStoreWithAll,
                    valueField: 'gpId',
                    displayField: 'psName',
                    emptyText: '请选择保护器...',
                    queryMode: 'local',
                    forceSelection : true,
                    triggerAction : 'all',
                    editable: false,
                    value: '0',
                    listeners: {
                        change: function(combo, newValue, oldValue, eOpts) {
                            //alert("soGpId : " + newValue);
                        }
                    }
                }]
            }]
        }],
        buttonAlign: 'center',
        buttons: [{
            text: '查询',
            handler: function() {
                var query_params = {};
                Ext.apply(query_params, pdr_filter_formpanel.getForm().getValues(false));
                pdr_gridstore.currentPage = 1;
                pdr_gridstore.load({
                    params: query_params
                });
            }
        }]
    });
    // 保护器数据源
    Ext.define('pdr-gridstore-model', {
        extend: 'Ext.data.Model',
        fields: [
            {name: 'GP_ID', type: 'int'},                                       /*  */
            {name: 'ORG_NAME', type: 'string'},                                 /* 所属机构 */
            {name: 'TG_NAME', type: 'string'},                                  /* 台区名称 */
            {name: 'PS_NAME', type: 'string'},                                  /* 保护器名称 */
            {name: 'ASSET_NO', type: 'string'},                                 /* 资产编号 */
            {name: 'LOGICAL_ADDR', type: 'string'},                             /* 集中器逻辑地址 */
            {name: 'GP_SN', type: 'int'},                                       /* 测量点序号 */
            {name: 'GP_ADDR', type: 'string'}                                   /* 通信地址 */
        ],
        idProperty: 'GP_ID'
    });
    pdr_gridstore = Ext.create('Ext.data.Store', {
        pageSize: defaultPageSize,
        // destroy the store if the grid is destroyed
        autoDestroy: true,
        model: 'pdr-gridstore-model',
        remoteSort: true,
        proxy: {
            // load using script tags for cross domain, if the data in on the same domain as
            // this page, an HttpProxy would be better
            type: 'ajax',
            url: ctx_webapp + '/cm/pdr!getGrid.do',
            reader: {
                type: 'json',
                root: 'records',
                totalProperty: 'totalCount'
            },
            // sends single sort as multi parameter
            simpleSortMode: true
        },
        sorters: [{
            property: 'LOGICAL_ADDR',
            direction: 'ASC'
        }],
        // 
        autoLoad: false
    });
    // 保护器列表
    var pdr_grid_pc = Ext.create('Ext.form.ComboBox', {
        fieldLabel: '每页记录数',
        store: Ext.create('Ext.data.Store', {
            fields: ['value', 'label'],
            data: [
                {"value": 10, "label": "10"},
                {"value": 20, "label": "20"},
                {"value": 50, "label": "50"},
                {"value": 100, "label": "100"},
                {"value": 200, "label": "200"},
                {"value": 500, "label": "500"}
            ]
        }),
        valueField: 'value',
        displayField: 'label',
        queryMode: 'local',
        forceSelection : true,
        triggerAction : 'all',
        editable: false,
        labelWidth: 70,
        width: 125,
        minWidth: 125,
        maxWidth: 125,
        value: pdr_gridstore.pageSize,
        listeners: {
            beforeselect: function(combo, record, index, eOpts) {
                if(pdr_gridstore.pageSize != record.data.value) {
                    pdr_gridstore.currentPage = 1;
                    pdr_gridstore.pageSize = record.data.value;
                    pdr_gridstore.load();
                }
            }
        }
    });
    var pdr_grid_pt = Ext.create('Ext.PagingToolbar', {
        store: pdr_gridstore,
        displayInfo: true,
        displayMsg: '显示第&nbsp;{0}&nbsp;条到&nbsp;{1}&nbsp;条记录,共&nbsp;{2}&nbsp;条记录',
        emptyMsg: '查询无记录',
        items: ['-', pdr_grid_pc]
    });
    pdr_grid_selections = '';
    pdr_grid_selmodel = Ext.create('Ext.selection.CheckboxModel', {
        listeners: {
            selectionchange: function(sm, selections) {
                pdr_gridpanel.down('#pdr-dydata-reading-button').setDisabled(selections.length == 0);
                pdr_gridpanel.down('#pdr-dldata-reading-button').setDisabled(selections.length == 0);
                pdr_gridpanel.down('#pdr-sydldata-reading-button').setDisabled(selections.length == 0);
                pdr_grid_selections = selections;
            }
        }
    });
    var pdr_gridpanel = Ext.create('Ext.grid.Panel', {
        id: 'pdr-grid',
        title: '保护器数据召测',
        xtype: 'grid',
        layout: 'fit',
        store: pdr_gridstore,
        loadMask: true,
        columns: [
            /*{text: "序号", xtype: 'rownumberer', width: 50},*/
            {text: "测量点标识", dataIndex: 'GP_ID', sortable: false, hideable: true, hidden: true},
            {text: "所属机构", dataIndex: 'ORG_NAME', width: 120, sortable: true},
            {text: "台区名称", dataIndex: 'TG_NAME', width: 120, sortable: true},
            {text: "保护器名称", dataIndex: 'PS_NAME', width: 100, sortable: true},
            {text: "资产编号", dataIndex: 'ASSET_NO', width: 80, sortable: true},
            {text: "集中器逻辑地址", dataIndex: 'LOGICAL_ADDR', width: 120, sortable: true},
            {text: "测量点序号", dataIndex: 'GP_SN', width: 100, sortable: true},
            {text: "通信地址", dataIndex: 'GP_ADDR', width: 120, sortable: true}
        ],
        plugins: [{
            ptype: 'rowexpander',
            rowBodyTpl : [
                '<p>&nbsp;　　　&nbsp;<b>召测状态：</b> <span id="cm_pdr_rt_{GP_ID}"></span></p>',
                '<p>&nbsp;　　　&nbsp;<b>召测结果：</b> <span id="cm_pdr_re_{GP_ID}"></span></p>'
            ]
        }],
        columnLines: true,
        selModel: pdr_grid_selmodel,
        // paging bar on the bottom
        bbar: pdr_grid_pt,
        // inline buttons
        dockedItems: [{
            xtype: 'toolbar',
            dock: 'top',
            items: [{
                itemId: 'pdr-dydata-reading-button',
                text: '电压数据召测',
                tooltip: '召测保护器电压数据',
                iconCls: 'reading',
                disabled: true,
                handler: function() {
                    //alert('召测保护器电压数据');
                }
            }, '-', {
                itemId: 'pdr-dldata-reading-button',
                text: '电流数据召测',
                tooltip: '召测保护器电流数据',
                iconCls: 'reading',
                disabled: true,
                handler: function() {
                    //alert('召测保护器电流数据');
                }
            }, '-', {
                itemId: 'pdr-sydldata-reading-button',
                text: '漏电数据召测',
                tooltip: '召测保护器漏电数据',
                iconCls: 'reading',
                disabled: true,
                handler: function() {
                    //alert('召测保护器漏电数据');
                }
            }, '->', '']
        }]
    });

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////// 模拟量数据召测 /////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    var adrFilterTgListStoreWithAll = Ext.create('Ext.data.Store', {
        // destroy the store if the grid is destroyed
        autoDestroy: true,
        model: 'tg-liststore-model',
        remoteSort: false,
        proxy: {
            // load using script tags for cross domain, if the data in on the same domain as
            // this page, an HttpProxy would be better
            type: 'ajax',
            url: ctx_webapp + '/am/tam!getTgList.do',
            reader: {
                type: 'json',
                root: 'records'
            }
        },
        // 
        autoLoad: false
    });

    var adrFilterAgListStoreWithAll = Ext.create('Ext.data.Store', {
        // destroy the store if the grid is destroyed
        autoDestroy: true,
        model: 'ag-liststore-model',
        remoteSort: false,
        proxy: {
            // load using script tags for cross domain, if the data in on the same domain as
            // this page, an HttpProxy would be better
            type: 'ajax',
            url: ctx_webapp + '/am/tam!getAgList.do',
            reader: {
                type: 'json',
                root: 'records'
            }
        },
        // 
        autoLoad: false
    });

    // 筛选条件表单
    var adr_filter_formpanel = Ext.create('Ext.form.Panel', {
        id: 'adr-filter-form',
        region: 'north',
        title: '筛选条件',
        frame: true,
        collapsible: true,
        margins: '5 5 5 5',
        bodyStyle: 'padding: 5px 5px 0 5px;',
        split: false,
        items: [{
            xtype: 'container',
            anchor: '100%',
            layout: 'hbox',
            items: [{
                xtype: 'container',
                layout: 'anchor',
                flex: 1,
                width: 240,
                items: [{
                    xtype: 'combobox',
                    id: 'adr-filter-formfield-org',
                    name: 'soOrgId',
                    fieldLabel: '所属机构',
                    labelWidth: 60,
                    allowBlank: false,
                    store: filterOrgnizationListStore,
                    valueField: 'id',
                    displayField: 'orgName',
                    emptyText: '请选择所属机构...',
                    queryMode: 'local',
                    forceSelection : true,
                    triggerAction : 'all',
                    editable: false,
                    listeners: {
                        change: function(combo, newValue, oldValue, eOpts) {
                            //alert("soOrgId : " + newValue);
                            if(!Ext.isEmpty(newValue)) {
                                Ext.getCmp('adr-filter-formfield-tg').reset();
                                Ext.getCmp('adr-filter-formfield-tg').getStore().removeAll();
                                Ext.getCmp('adr-filter-formfield-tg').getStore().load({
                                    params: {orgId: newValue, withAll: true},
                                    callback: function(records, operation, success) {
                                        Ext.getCmp('adr-filter-formfield-tg').setValue(0);
                                    },
                                    scope: this
                                });
                            }
                        }
                    }
                }]
            }, {
                xtype: 'container',
                layout: 'anchor',
                flex: 1,
                width: 240,
                items: [{
                    xtype: 'combobox',
                    id: 'adr-filter-formfield-tg',
                    name: 'soTgId',
                    fieldLabel: '台区名称',
                    labelWidth: 60,
                    allowBlank: false,
                    store: adrFilterTgListStoreWithAll,
                    valueField: 'id',
                    displayField: 'tgName',
                    emptyText: '请选择台区...',
                    queryMode: 'local',
                    forceSelection : true,
                    triggerAction : 'all',
                    editable: false,
                    value: '0',
                    listeners: {
                        change: function(combo, newValue, oldValue, eOpts) {
                            //alert("soTgId : " + newValue);
                            if(!Ext.isEmpty(newValue)) {
                                Ext.getCmp('adr-filter-formfield-ag').reset();
                                Ext.getCmp('adr-filter-formfield-ag').getStore().removeAll();
                                Ext.getCmp('adr-filter-formfield-ag').getStore().load({
                                    params: {orgId: Ext.getCmp('adr-filter-formfield-org').getValue(), tgId: newValue, withAll: true},
                                    callback: function(records, operation, success) {
                                        Ext.getCmp('adr-filter-formfield-ag').setValue(0);
                                    },
                                    scope: this
                                });
                            }
                        }
                    }
                }]
            }, {
                xtype: 'container',
                layout: 'anchor',
                flex: 1,
                width: 240,
                items: [{
                    xtype: 'combobox',
                    id: 'adr-filter-formfield-ag',
                    name: 'soGpId',
                    fieldLabel: '模拟量名称',
                    labelWidth: 66,
                    allowBlank: false,
                    store: adrFilterAgListStoreWithAll,
                    valueField: 'gpId',
                    displayField: 'analogueName',
                    emptyText: '请选择模拟量...',
                    queryMode: 'local',
                    forceSelection : true,
                    triggerAction : 'all',
                    editable: false,
                    value: '0',
                    listeners: {
                        change: function(combo, newValue, oldValue, eOpts) {
                            //alert("soGpId : " + newValue);
                        }
                    }
                }]
            }]
        }],
        buttonAlign: 'center',
        buttons: [{
            text: '查询',
            handler: function() {
                var query_params = {};
                Ext.apply(query_params, adr_filter_formpanel.getForm().getValues(false));
                adr_gridstore.currentPage = 1;
                adr_gridstore.load({
                    params: query_params
                });
            }
        }]
    });
    // 模拟量数据源
    Ext.define('adr-gridstore-model', {
        extend: 'Ext.data.Model',
        fields: [
            {name: 'GP_ID', type: 'int'},                                       /*  */
            {name: 'ORG_NAME', type: 'string'},                                 /* 所属机构 */
            {name: 'TG_NAME', type: 'string'},                                  /* 台区名称 */
            {name: 'ANALOGUE_NAME', type: 'string'},                            /* 模拟量名称 */
            {name: 'LOGICAL_ADDR', type: 'string'},                             /* 集中器逻辑地址 */
            {name: 'PORT', type: 'int'}                                         /* 模拟量端口 */
        ],
        idProperty: 'GP_ID'
    });
    adr_gridstore = Ext.create('Ext.data.Store', {
        pageSize: defaultPageSize,
        // destroy the store if the grid is destroyed
        autoDestroy: true,
        model: 'adr-gridstore-model',
        remoteSort: true,
        proxy: {
            // load using script tags for cross domain, if the data in on the same domain as
            // this page, an HttpProxy would be better
            type: 'ajax',
            url: ctx_webapp + '/cm/adr!getGrid.do',
            reader: {
                type: 'json',
                root: 'records',
                totalProperty: 'totalCount'
            },
            // sends single sort as multi parameter
            simpleSortMode: true
        },
        sorters: [{
            property: 'LOGICAL_ADDR',
            direction: 'ASC'
        }],
        // 
        autoLoad: false
    });
    // 模拟量列表
    var adr_grid_pc = Ext.create('Ext.form.ComboBox', {
        fieldLabel: '每页记录数',
        store: Ext.create('Ext.data.Store', {
            fields: ['value', 'label'],
            data: [
                {"value": 10, "label": "10"},
                {"value": 20, "label": "20"},
                {"value": 50, "label": "50"},
                {"value": 100, "label": "100"},
                {"value": 200, "label": "200"},
                {"value": 500, "label": "500"}
            ]
        }),
        valueField: 'value',
        displayField: 'label',
        queryMode: 'local',
        forceSelection : true,
        triggerAction : 'all',
        editable: false,
        labelWidth: 70,
        width: 125,
        minWidth: 125,
        maxWidth: 125,
        value: adr_gridstore.pageSize,
        listeners: {
            beforeselect: function(combo, record, index, eOpts) {
                if(adr_gridstore.pageSize != record.data.value) {
                    adr_gridstore.currentPage = 1;
                    adr_gridstore.pageSize = record.data.value;
                    adr_gridstore.load();
                }
            }
        }
    });
    var adr_grid_pt = Ext.create('Ext.PagingToolbar', {
        store: adr_gridstore,
        displayInfo: true,
        displayMsg: '显示第&nbsp;{0}&nbsp;条到&nbsp;{1}&nbsp;条记录,共&nbsp;{2}&nbsp;条记录',
        emptyMsg: '查询无记录',
        items: ['-', adr_grid_pc]
    });
    adr_grid_selections = '';
    adr_grid_selmodel = Ext.create('Ext.selection.CheckboxModel', {
        listeners: {
            selectionchange: function(sm, selections) {
                adr_gridpanel.down('#adr-data-reading-button').setDisabled(selections.length == 0);
                adr_grid_selections = selections;
            }
        }
    });
    var adr_gridpanel = Ext.create('Ext.grid.Panel', {
        id: 'adr-grid',
        title: '模拟量数据召测',
        xtype: 'grid',
        layout: 'fit',
        store: adr_gridstore,
        loadMask: true,
        columns: [
            /*{text: "序号", xtype: 'rownumberer', width: 50},*/
            {text: "测量点标识", dataIndex: 'GP_ID', sortable: false, hideable: true, hidden: true},
            {text: "所属机构", dataIndex: 'ORG_NAME', width: 120, sortable: true},
            {text: "台区名称", dataIndex: 'TG_NAME', width: 120, sortable: true},
            {text: "模拟量名称", dataIndex: 'ANALOGUE_NAME', width: 100, sortable: true},
            {text: "集中器逻辑地址", dataIndex: 'LOGICAL_ADDR', width: 120, sortable: true},
            {text: "模拟量端口", dataIndex: 'PORT', width: 100, sortable: true}
        ],
        plugins: [{
            ptype: 'rowexpander',
            rowBodyTpl: [
                '<p>&nbsp;　　　&nbsp;<b>召测状态：</b> <span id="cm_adr_rt_{GP_ID}"></span></p>',
                '<p>&nbsp;　　　&nbsp;<b>召测结果：</b> <span id="cm_adr_re_{GP_ID}"></span></p>'
            ]
        }],
        columnLines: true,
        selModel: adr_grid_selmodel,
        // paging bar on the bottom
        bbar: adr_grid_pt,
        // inline buttons
        dockedItems: [{
            xtype: 'toolbar',
            dock: 'top',
            items: [{
                itemId: 'adr-data-reading-button',
                text: '当前数据召测',
                tooltip: '召测模拟量当前数据',
                iconCls: 'reading',
                disabled: true,
                handler: function() {
                    // alert('召测模拟量当前数据');
                }
            }, '->', '']
        }]
    });

    return {
        /*
         * ================  台区考核表数据召测  =======================
         */
        actionTgMeterDataReading: {
            xtype: 'tabpanel',
            id: 'actionTgMeterDataReadingContentPanel',
            activeTab: 0,
            defaults: {bodyStyle: 'padding: 0'},
            items: [{
                title: '台区考核表数据召测',
                layout: 'border',
                items: [tmdr_filter_formpanel, {
                    xtype: 'tabpanel',
                    plain: true,
                    region: 'center',
                    margins: '0 5 5 5',
                    activeTab: 0,
                    items: [tmdr_gridpanel]
                }]
            }]
        },

        /*
         * ================  保护器数据召测  =======================
         */
        actionProtectorDataReading: {
            xtype: 'tabpanel',
            id: 'actionProtectorDataReadingContentPanel',
            activeTab: 0,
            defaults: {bodyStyle: 'padding: 0'},
            items: [{
                title: '保护器数据召测',
                layout: 'border',
                items: [pdr_filter_formpanel, {
                    xtype: 'tabpanel',
                    plain: true,
                    region: 'center',
                    margins: '0 5 5 5',
                    activeTab: 0,
                    items: [pdr_gridpanel]
                }]
            }]
        },

        /*
         * ================  模拟量数据召测  =======================
         */
        actionAnalogueDataReading: {
            xtype: 'tabpanel',
            id: 'actionAnalogueDataReadingContentPanel',
            activeTab: 0,
            defaults: {bodyStyle: 'padding: 0'},
            items: [{
                title: '模拟量数据召测',
                layout: 'border',
                items: [adr_filter_formpanel, {
                    xtype: 'tabpanel',
                    plain: true,
                    region: 'center',
                    margins: '0 5 5 5',
                    activeTab: 0,
                    items: [adr_gridpanel]
                }]
            }]
        }
    };
}