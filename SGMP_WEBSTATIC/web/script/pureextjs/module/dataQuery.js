function getDataQueryFunctions() {
    var defaultPageSize = 20;
    /**
     * ================  台区考核表数据查询  =======================
     */
    // 查询条件表单
    var tmdq_filter_formpanel = Ext.create('Ext.form.Panel', {
        id: 'tmdq-filter-form',
        region: 'north',
        title: '查询条件',
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
                    name: 'soOrgId',
                    fieldLabel: '所属机构',
                    labelWidth: 60,
                    allowBlank: false,
                    store: Ext.create('Ext.data.Store', {
                        fields: ['orgId', 'orgName'],
                        data: [
                                {"orgId": "0", "orgName": "请选择所属机构"},
                                {"orgId": "1", "orgName": "豪顿电气"},
                                {"orgId": "2", "orgName": "豪顿电气测试部"},
                                {"orgId": "3", "orgName": "豪顿电气演示部"}
                        ]
                    }),
                    valueField: 'orgId',
                    displayField: 'orgName',
                    queryMode: 'local',
                    forceSelection : true,
                    triggerAction : 'all',
                    editable: false,
                    value: '0',
                    listeners: {
                        change: function(combo, newValue, oldValue, eOpts) {
                            //alert(newValue);
                        }
                    }
                }, {
                    xtype: 'datefield',
                    fieldLabel: '开始日期',
                    labelWidth: 60,
                    name: 'startDate',
                    format: 'Y-m-d',
                    value: new Date()
                }]
            }, {
                xtype: 'container',
                layout: 'anchor',
                flex: 1,
                width: 240,
                items: [{
                    xtype: 'combobox',
                    name: 'soTgId',
                    fieldLabel: '台区名称',
                    labelWidth: 60,
                    allowBlank: false,
                    store: Ext.create('Ext.data.Store', {
                        fields: ['tgId', 'tgName'],
                        data: [ 
                                {"tgId": "0", "tgName": "--- 所有台区 ---"},
                                {"tgId": "102", "tgName": "测试台区（96123456）"}
                        ]
                    }),
                    valueField: 'tgId',
                    displayField: 'tgName',
                    queryMode: 'local',
                    forceSelection : true,
                    triggerAction : 'all',
                    editable: false,
                    value: '0',
                    listeners: {
                        change: function(combo, newValue, oldValue, eOpts) {
                            //alert(newValue);
                        }
                    }
                }, {
                    xtype: 'datefield',
                    fieldLabel: '结束日期',
                    labelWidth: 60,
                    name: 'endDate',
                    format: 'Y-m-d',
                    value: new Date()
                }]
            }, {
                xtype: 'container',
                layout: 'anchor',
                flex: 1,
                width: 240,
                items: [{
                    xtype: 'combobox',
                    name: 'soGpId',
                    fieldLabel: '考核表名称',
                    labelWidth: 66,
                    allowBlank: false,
                    store: Ext.create('Ext.data.Store', {
                        fields: ['gpId', 'mpName'],
                        data: [ 
                                {"gpId": "0", "mpName": "--- 所有考核表 ---"},
                                {"gpId": "1201", "mpName": "测试台区考核表"}
                        ]
                    }),
                    valueField: 'gpId',
                    displayField: 'mpName',
                    queryMode: 'local',
                    forceSelection : true,
                    triggerAction : 'all',
                    editable: false,
                    value: '0',
                    listeners: {
                        change: function(combo, newValue, oldValue, eOpts) {
                            //alert(newValue);
                        }
                    }
                }]
            }]
        }],
        buttonAlign: 'center',
        buttons: [{
            text: '查询',
            handler: function() {
                tmdq_eicurve_gridstore.load({
                    params: tmdq_filter_formpanel.getForm().getValues(false)
                });
            }
        }]
    });
    // 表码数据数据源
    Ext.define('tmdq-eicurve-gridstore-model', {
        extend: 'Ext.data.Model',
        fields: [
            {name: 'SN', type: 'int'},                                          /* 序号 */
            {name: 'ORG_NAME', type: 'string'},                                 /* 所属机构 */
            {name: 'TG_NAME', type: 'string'},                                  /* 台区名称 */
            {name: 'MP_NAME', type: 'string'},                                  /* 考核表名称 */
            {name: 'ASSET_NO', type: 'string'},                                 /* 资产编号 */
            {name: 'CT_TIMES', type: 'float'},                                  /* CT倍率 */
            {name: 'PT_TIMES', type: 'float'},                                  /* PT倍率 */
            {name: 'TOTAL_TIMES', type: 'float'},                               /* 总倍率 */
            {name: 'DATA_TIME', type: 'date', dateFormat: 'Y-m-d H:i:s'},       /* 数据时间 */
            {name: 'P_ACT_TOTAL', type: 'float'},                               /* 正向有功总电能示值 */
            {name: 'I_ACT_TOTAL', type: 'float'},                               /* 反向有功总电能示值 */
            {name: 'P_REACT_TOTAL', type: 'float'},                             /* 正向无功总电能示值 */
            {name: 'I_REACT_TOTAL', type: 'float'}                              /* 反向无功总电能示值 */
        ],
        idProperty: 'SN'
    });
    var tmdq_eicurve_gridstore = Ext.create('Ext.data.Store', {
        pageSize: defaultPageSize,
        // destroy the store if the grid is destroyed
        autoDestroy: true,
        model: 'tmdq-eicurve-gridstore-model',
        remoteSort: true,
        proxy: {
            // load using script tags for cross domain, if the data in on the same domain as
            // this page, an HttpProxy would be better
            type: 'ajax',
            url: ctx_webapp + '/dq/tmdq!getGrid.do',
            reader: {
                type: 'json',
                root: 'records',
                totalProperty: 'count'
            },
            // sends single sort as multi parameter
            simpleSortMode: true
        },
        sorters: [{
            property: 'DATA_TIME',
            direction: 'DESC'
        }],
        // 
        autoLoad: false
    });
    // 表码数据列表
    var tmdq_eicurve_grid_pc = Ext.create('Ext.form.ComboBox', {
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
        value: tmdq_eicurve_gridstore.pageSize,
        listeners: {
            beforeselect: function(combo, record, index, eOpts) {
                if(tmdq_eicurve_gridstore.pageSize != record.data.value) {
                    tmdq_eicurve_gridstore.pageSize = record.data.value;
                    tmdq_eicurve_gridstore.load();
                }
            }
        }
    });
    var tmdq_eicurve_grid_pt = Ext.create('Ext.PagingToolbar', {
        store: tmdq_eicurve_gridstore,
        displayInfo: true,
        displayMsg: '显示第&nbsp;{0}&nbsp;条到&nbsp;{1}&nbsp;条记录,共&nbsp;{2}&nbsp;条记录',
        emptyMsg: '查询无记录',
        items: ['-', tmdq_eicurve_grid_pc]
    });
    var tmdq_eicurve_gridpanel = Ext.create('Ext.grid.Panel', {
        id: 'tmdq-eicurve-grid',
        title: '表码数据',
        xtype: 'grid',
        layout: 'fit',
        store: tmdq_eicurve_gridstore,
        loadMask: true,
        columns: [
            {text: "序号", width: 50, sortable: false, dataIndex: 'SN'},
            {text: "所属机构", width: 120, sortable: true, dataIndex: 'ORG_NAME'},
            {text: "台区名称", width: 120, sortable: true, dataIndex: 'TG_NAME'},
            {text: "数据时间", width: 150, sortable: true, dataIndex: 'DATA_TIME'},
            {text: "正向有功总电能示值", width: 135, sortable: true, dataIndex: 'P_ACT_TOTAL'},
            {text: "反向有功总电能示值", width: 135, sortable: true, dataIndex: 'I_ACT_TOTAL'},
            {text: "正向无功总电能示值", width: 135, sortable: true, dataIndex: 'P_REACT_TOTAL'},
            {text: "反向无功总电能示值", width: 135, sortable: true, dataIndex: 'I_REACT_TOTAL'},
            {text: "考核表名称", width: 100, sortable: true, dataIndex: 'MP_NAME'},
            {text: "资产编号", width: 100, sortable: true, dataIndex: 'ASSET_NO'},
            {text: "CT倍率", width: 80, sortable: true, dataIndex: 'CT_TIMES'},
            {text: "PT倍率", width: 80, sortable: true, dataIndex: 'PT_TIMES'},
            {text: "总倍率", width: 80, sortable: true, dataIndex: 'TOTAL_TIMES'}
        ],
        columnLines: true,
        // paging bar on the bottom
        bbar: tmdq_eicurve_grid_pt,
        // inline buttons
        dockedItems: [{
            xtype: 'toolbar',
            dock: 'top',
            items: ['->', '单位：kWh（有功电能示值），kvarh（无功电能示值）']
        }]
    });

    return {
        /*
         * ================  台区考核表数据查询  =======================
         */
        actionTgMeterDataQuery: {
            xtype: 'tabpanel',
            id: 'actionTgMeterDataQueryContentPanel',
            activeTab: 0,
            defaults: {bodyStyle: 'padding: 0'},
            items: [{
                title: '台区考核表数据查询',
                layout: 'border',
                items: [tmdq_filter_formpanel, {
                    xtype: 'tabpanel',
                    plain: true,
                    region: 'center',
                    margins: '0 5 5 5',
                    activeTab: 0,
                    items: [tmdq_eicurve_gridpanel]
                }]
            }]
        }/*,

        
         * ================  保护器数据查询  =======================
         
        actionProtectorDataQuery: {
            xtype: 'tabpanel',
            id: 'actionProtectorDataQueryContentPanel',
            activeTab: 0,
            defaults: {bodyStyle: 'padding: 0'},
            items: [{
                title: '保护器数据查询',
                layout: 'border',
                items: [pdq_filter_formpanel, {
                    xtype: 'tabpanel',
                    plain: true,
                    region: 'center',
                    margins: '0 5 5 5',
                    activeTab: 0,
                    items: [pdq_data_gridpanel]
                }]
            }]
        },

        
         * ================  台区用电量查询  =======================
         
        actionTgPowerConsumptionQuery: {
            xtype: 'tabpanel',
            id: 'actionTgPowerConsumptionQueryContentPanel',
            activeTab: 0,
            defaults: {bodyStyle: 'padding: 0'},
            items: [{
                title: '台区用电量查询',
                layout: 'border',
                items: [tpcq_filter_formpanel, {
                    xtype: 'tabpanel',
                    plain: true,
                    region: 'center',
                    margins: '0 5 5 5',
                    activeTab: 0,
                    items: [tpcq_data_gridpanel]
                }]
            }]
        },

        
         * ================  集中器事件查询  =======================
         
        actionTerminalEventsQuery: {
            xtype: 'tabpanel',
            id: 'actionTerminalEventsQueryContentPanel',
            activeTab: 0,
            defaults: {bodyStyle: 'padding: 0'},
            items: [{
                title: '集中器事件查询',
                layout: 'border',
                items: [teq_filter_formpanel, {
                    xtype: 'tabpanel',
                    plain: true,
                    region: 'center',
                    margins: '0 5 5 5',
                    activeTab: 0,
                    items: [teq_data_gridpanel]
                }]
            }]
        },

        
         * ================  保护器跳闸事件查询  =======================
         
        actionProtectorTripEventsQuery: {
            xtype: 'tabpanel',
            id: 'actionProtectorTripEventsQueryContentPanel',
            activeTab: 0,
            defaults: {bodyStyle: 'padding: 0'},
            items: [{
                title: '保护器跳闸事件查询',
                layout: 'border',
                items: [pteq_filter_formpanel, {
                    xtype: 'tabpanel',
                    plain: true,
                    region: 'center',
                    margins: '0 5 5 5',
                    activeTab: 0,
                    items: [pteq_data_gridpanel]
                }]
            }]
        }*/
    };
}