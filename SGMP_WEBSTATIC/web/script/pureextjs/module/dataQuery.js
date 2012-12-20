function getDataQueryFunctions() {
    var defaultPageSize = 20;
    var defaultDataTable = 'D_EI_CURV_C';
    var currentDataTable = defaultDataTable;
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
                                {"tgId": "1", "tgName": "测试台区（96123456）"},
                                {"tgId": "2", "tgName": "测试台区（96123458）"}
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
                                {"gpId": "1", "mpName": "测试台区考核表"}
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
                if(currentDataTable == 'D_EI_CURV_C') {
                    var query_eicurve_params = {
                            dataTable: currentDataTable
                    };
                    Ext.apply(query_eicurve_params, tmdq_filter_formpanel.getForm().getValues(false));
                    tmdq_eicurve_gridstore.currentPage = 1;
                    tmdq_eicurve_gridstore.load({
                        params: query_eicurve_params
                    });
                }
                else if(currentDataTable == 'D_POWER_CRUV_C') {
                    var query_powercurve_params = {
                            dataTable: currentDataTable
                    };
                    Ext.apply(query_powercurve_params, tmdq_filter_formpanel.getForm().getValues(false));
                    tmdq_powercurve_gridstore.currentPage = 1;
                    tmdq_powercurve_gridstore.load({
                        params: query_powercurve_params
                    });
                }
                else if(currentDataTable == 'D_PF_CRUV_C') {
                    var query_pfcurve_params = {
                            dataTable: currentDataTable
                    };
                    Ext.apply(query_pfcurve_params, tmdq_filter_formpanel.getForm().getValues(false));
                    tmdq_pfcurve_gridstore.currentPage = 1;
                    tmdq_pfcurve_gridstore.load({
                        params: query_pfcurve_params
                    });
                }
                else if(currentDataTable == 'D_EC_CURV_C') {
                    var query_eccurve_params = {
                            dataTable: currentDataTable
                    };
                    Ext.apply(query_eccurve_params, tmdq_filter_formpanel.getForm().getValues(false));
                    tmdq_eccurve_gridstore.currentPage = 1;
                    tmdq_eccurve_gridstore.load({
                        params: query_eccurve_params
                    });
                }
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
            {name: 'CT_TIMES', type: 'number', defaultValue: ' '},              /* CT倍率 */
            {name: 'PT_TIMES', type: 'number', defaultValue: ' '},              /* PT倍率 */
            {name: 'TOTAL_TIMES', type: 'number', defaultValue: ' '},           /* 总倍率 */
            {name: 'DATA_TIME', type: 'date', dateFormat: 'Y-m-d H:i:s'},       /* 数据时间 */
            {name: 'P_ACT_TOTAL', type: 'number', defaultValue: ' '},           /* 正向有功总电能示值 */
            {name: 'I_ACT_TOTAL', type: 'number', defaultValue: ' '},           /* 反向有功总电能示值 */
            {name: 'P_REACT_TOTAL', type: 'number', defaultValue: ' '},         /* 正向无功总电能示值 */
            {name: 'I_REACT_TOTAL', type: 'number', defaultValue: ' '}          /* 反向无功总电能示值 */
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
                totalProperty: 'totalCount'
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
                    tmdq_eicurve_gridstore.currentPage = 1;
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
            {text: "序号", dataIndex: 'SN', width: 50, sortable: false},
            {text: "所属机构", dataIndex: 'ORG_NAME', width: 120, sortable: true},
            {text: "台区名称", dataIndex: 'TG_NAME', width: 120, sortable: true},
            {text: "数据时间", dataIndex: 'DATA_TIME', width: 135, sortable: true, xtype: 'datecolumn', format:'Y-m-d H:i:s'},
            {text: "正向有功总电能示值", dataIndex: 'P_ACT_TOTAL', width: 135, sortable: true, xtype: 'numbercolumn', format: '0.00'},
            {text: "反向有功总电能示值", dataIndex: 'I_ACT_TOTAL', width: 135, sortable: true, xtype: 'numbercolumn', format: '0.00'},
            {text: "正向无功总电能示值", dataIndex: 'P_REACT_TOTAL', width: 135, sortable: true, xtype: 'numbercolumn', format: '0.00'},
            {text: "反向无功总电能示值", dataIndex: 'I_REACT_TOTAL', width: 135, sortable: true, xtype: 'numbercolumn', format: '0.00'},
            {text: "考核表名称", dataIndex: 'MP_NAME', width: 100, sortable: true},
            {text: "资产编号", dataIndex: 'ASSET_NO', width: 80, sortable: true},
            {text: "CT倍率", dataIndex: 'CT_TIMES', width: 60, sortable: true},
            {text: "PT倍率", dataIndex: 'PT_TIMES', width: 60, sortable: true},
            {text: "总倍率", dataIndex: 'TOTAL_TIMES', width: 60, sortable: true}
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
    // 功率数据数据源
    Ext.define('tmdq-powercurve-gridstore-model', {
        extend: 'Ext.data.Model',
        fields: [
            {name: 'SN', type: 'int'},                                          /* 序号 */
            {name: 'ORG_NAME', type: 'string'},                                 /* 所属机构 */
            {name: 'TG_NAME', type: 'string'},                                  /* 台区名称 */
            {name: 'MP_NAME', type: 'string'},                                  /* 考核表名称 */
            {name: 'ASSET_NO', type: 'string'},                                 /* 资产编号 */
            {name: 'CT_TIMES', type: 'number', defaultValue: ' '},              /* CT倍率 */
            {name: 'PT_TIMES', type: 'number', defaultValue: ' '},              /* PT倍率 */
            {name: 'TOTAL_TIMES', type: 'number', defaultValue: ' '},           /* 总倍率 */
            {name: 'DATA_TIME', type: 'date', dateFormat: 'Y-m-d H:i:s'},       /* 数据时间 */
            {name: 'ACT_POWER', type: 'number', defaultValue: ' '},             /* 有功功率 */
            {name: 'ACT_POWER_A', type: 'number', defaultValue: ' '},           /* A相有功功率 */
            {name: 'ACT_POWER_B', type: 'number', defaultValue: ' '},           /* B相有功功率 */
            {name: 'ACT_POWER_C', type: 'number', defaultValue: ' '},           /* C相有功功率 */
            {name: 'REACT_POWER', type: 'number', defaultValue: ' '},           /* 无功功率 */
            {name: 'REACT_POWER_A', type: 'number', defaultValue: ' '},         /* A相无功功率 */
            {name: 'REACT_POWER_B', type: 'number', defaultValue: ' '},         /* B相无功功率 */
            {name: 'REACT_POWER_C', type: 'number', defaultValue: ' '}          /* C相无功功率 */
        ],
        idProperty: 'SN'
    });
    var tmdq_powercurve_gridstore = Ext.create('Ext.data.Store', {
        pageSize: defaultPageSize,
        // destroy the store if the grid is destroyed
        autoDestroy: true,
        model: 'tmdq-powercurve-gridstore-model',
        remoteSort: true,
        proxy: {
            // load using script tags for cross domain, if the data in on the same domain as
            // this page, an HttpProxy would be better
            type: 'ajax',
            url: ctx_webapp + '/dq/tmdq!getGrid.do',
            reader: {
                type: 'json',
                root: 'records',
                totalProperty: 'totalCount'
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
    // 功率数据列表
    var tmdq_powercurve_grid_pc = Ext.create('Ext.form.ComboBox', {
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
        value: tmdq_powercurve_gridstore.pageSize,
        listeners: {
            beforeselect: function(combo, record, index, eOpts) {
                if(tmdq_powercurve_gridstore.pageSize != record.data.value) {
                    tmdq_powercurve_gridstore.currentPage = 1;
                    tmdq_powercurve_gridstore.pageSize = record.data.value;
                    tmdq_powercurve_gridstore.load();
                }
            }
        }
    });
    var tmdq_powercurve_grid_pt = Ext.create('Ext.PagingToolbar', {
        store: tmdq_powercurve_gridstore,
        displayInfo: true,
        displayMsg: '显示第&nbsp;{0}&nbsp;条到&nbsp;{1}&nbsp;条记录,共&nbsp;{2}&nbsp;条记录',
        emptyMsg: '查询无记录',
        items: ['-', tmdq_powercurve_grid_pc]
    });
    var tmdq_powercurve_gridpanel = Ext.create('Ext.grid.Panel', {
        id: 'tmdq-powercurve-grid',
        title: '功率数据',
        xtype: 'grid',
        layout: 'fit',
        store: tmdq_powercurve_gridstore,
        loadMask: true,
        columns: [
            {text: "序号", dataIndex: 'SN', width: 50, sortable: false},
            {text: "所属机构", dataIndex: 'ORG_NAME', width: 120, sortable: true},
            {text: "台区名称", dataIndex: 'TG_NAME', width: 120, sortable: true},
            {text: "数据时间", dataIndex: 'DATA_TIME', width: 135, sortable: true, xtype: 'datecolumn', format:'Y-m-d H:i:s'},
            {text: "有功功率", dataIndex: 'ACT_POWER', width: 80, sortable: true, xtype: 'numbercolumn', format: '0.00'},
            {text: "A相有功功率", dataIndex: 'ACT_POWER_A', width: 80, sortable: true, xtype: 'numbercolumn', format: '0.00'},
            {text: "B相有功功率", dataIndex: 'ACT_POWER_B', width: 80, sortable: true, xtype: 'numbercolumn', format: '0.00'},
            {text: "C相有功功率", dataIndex: 'ACT_POWER_C', width: 80, sortable: true, xtype: 'numbercolumn', format: '0.00'},
            {text: "无功功率", dataIndex: 'REACT_POWER', width: 80, sortable: true, xtype: 'numbercolumn', format: '0.00'},
            {text: "A相无功功率", dataIndex: 'REACT_POWER_A', width: 80, sortable: true, xtype: 'numbercolumn', format: '0.00'},
            {text: "B相无功功率", dataIndex: 'REACT_POWER_B', width: 80, sortable: true, xtype: 'numbercolumn', format: '0.00'},
            {text: "C相无功功率", dataIndex: 'REACT_POWER_C', width: 80, sortable: true, xtype: 'numbercolumn', format: '0.00'},
            {text: "考核表名称", dataIndex: 'MP_NAME', width: 100, sortable: true},
            {text: "资产编号", dataIndex: 'ASSET_NO', width: 80, sortable: true},
            {text: "CT倍率", dataIndex: 'CT_TIMES', width: 60, sortable: true},
            {text: "PT倍率", dataIndex: 'PT_TIMES', width: 60, sortable: true},
            {text: "总倍率", dataIndex: 'TOTAL_TIMES', width: 60, sortable: true}
        ],
        columnLines: true,
        // paging bar on the bottom
        bbar: tmdq_powercurve_grid_pt,
        // inline buttons
        dockedItems: [{
            xtype: 'toolbar',
            dock: 'top',
            items: ['->', '单位：kW（有功功率），kvar（无功功率）']
        }]
    });
    // 功率因数数据数据源
    Ext.define('tmdq-pfcurve-gridstore-model', {
        extend: 'Ext.data.Model',
        fields: [
            {name: 'SN', type: 'int'},                                          /* 序号 */
            {name: 'ORG_NAME', type: 'string'},                                 /* 所属机构 */
            {name: 'TG_NAME', type: 'string'},                                  /* 台区名称 */
            {name: 'MP_NAME', type: 'string'},                                  /* 考核表名称 */
            {name: 'ASSET_NO', type: 'string'},                                 /* 资产编号 */
            {name: 'CT_TIMES', type: 'number', defaultValue: ' '},              /* CT倍率 */
            {name: 'PT_TIMES', type: 'number', defaultValue: ' '},              /* PT倍率 */
            {name: 'TOTAL_TIMES', type: 'number', defaultValue: ' '},           /* 总倍率 */
            {name: 'DATA_TIME', type: 'date', dateFormat: 'Y-m-d H:i:s'},       /* 数据时间 */
            {name: 'POWER_FACTOR', type: 'number', defaultValue: ' '},          /* 功率因数 */
            {name: 'POWER_FACTOR_A', type: 'number', defaultValue: ' '},        /* A相功率因数 */
            {name: 'POWER_FACTOR_B', type: 'number', defaultValue: ' '},        /* B相功率因数 */
            {name: 'POWER_FACTOR_C', type: 'number', defaultValue: ' '}         /* C相功率因数 */
        ],
        idProperty: 'SN'
    });
    var tmdq_pfcurve_gridstore = Ext.create('Ext.data.Store', {
        pageSize: defaultPageSize,
        // destroy the store if the grid is destroyed
        autoDestroy: true,
        model: 'tmdq-pfcurve-gridstore-model',
        remoteSort: true,
        proxy: {
            // load using script tags for cross domain, if the data in on the same domain as
            // this page, an HttpProxy would be better
            type: 'ajax',
            url: ctx_webapp + '/dq/tmdq!getGrid.do',
            reader: {
                type: 'json',
                root: 'records',
                totalProperty: 'totalCount'
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
    // 功率因数数据列表
    var tmdq_pfcurve_grid_pc = Ext.create('Ext.form.ComboBox', {
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
        value: tmdq_pfcurve_gridstore.pageSize,
        listeners: {
            beforeselect: function(combo, record, index, eOpts) {
                if(tmdq_pfcurve_gridstore.pageSize != record.data.value) {
                    tmdq_pfcurve_gridstore.currentPage = 1;
                    tmdq_pfcurve_gridstore.pageSize = record.data.value;
                    tmdq_pfcurve_gridstore.load();
                }
            }
        }
    });
    var tmdq_pfcurve_grid_pt = Ext.create('Ext.PagingToolbar', {
        store: tmdq_pfcurve_gridstore,
        displayInfo: true,
        displayMsg: '显示第&nbsp;{0}&nbsp;条到&nbsp;{1}&nbsp;条记录,共&nbsp;{2}&nbsp;条记录',
        emptyMsg: '查询无记录',
        items: ['-', tmdq_pfcurve_grid_pc]
    });
    var tmdq_pfcurve_gridpanel = Ext.create('Ext.grid.Panel', {
        id: 'tmdq-pfcurve-grid',
        title: '功率因数数据',
        xtype: 'grid',
        layout: 'fit',
        store: tmdq_pfcurve_gridstore,
        loadMask: true,
        columns: [
            {text: "序号", dataIndex: 'SN', width: 50, sortable: false},
            {text: "所属机构", dataIndex: 'ORG_NAME', width: 120, sortable: true},
            {text: "台区名称", dataIndex: 'TG_NAME', width: 120, sortable: true},
            {text: "数据时间", dataIndex: 'DATA_TIME', width: 135, sortable: true, xtype: 'datecolumn', format:'Y-m-d H:i:s'},
            {text: "功率因数", dataIndex: 'POWER_FACTOR', width: 80, sortable: true, xtype: 'numbercolumn', format: '0.00'},
            {text: "A相功率因数", dataIndex: 'POWER_FACTOR_A', width: 80, sortable: true, xtype: 'numbercolumn', format: '0.00'},
            {text: "B相功率因数", dataIndex: 'POWER_FACTOR_B', width: 80, sortable: true, xtype: 'numbercolumn', format: '0.00'},
            {text: "C相功率因数", dataIndex: 'POWER_FACTOR_C', width: 80, sortable: true, xtype: 'numbercolumn', format: '0.00'},
            {text: "考核表名称", dataIndex: 'MP_NAME', width: 100, sortable: true},
            {text: "资产编号", dataIndex: 'ASSET_NO', width: 80, sortable: true},
            {text: "CT倍率", dataIndex: 'CT_TIMES', width: 60, sortable: true},
            {text: "PT倍率", dataIndex: 'PT_TIMES', width: 60, sortable: true},
            {text: "总倍率", dataIndex: 'TOTAL_TIMES', width: 60, sortable: true}
        ],
        columnLines: true,
        // paging bar on the bottom
        bbar: tmdq_pfcurve_grid_pt,
        // inline buttons
        dockedItems: [{
            xtype: 'toolbar',
            dock: 'top',
            items: ['->', '单位：%（功率因数）']
        }]
    });
    // 电压电流数据数据源
    Ext.define('tmdq-eccurve-gridstore-model', {
        extend: 'Ext.data.Model',
        fields: [
            {name: 'SN', type: 'int'},                                          /* 序号 */
            {name: 'ORG_NAME', type: 'string'},                                 /* 所属机构 */
            {name: 'TG_NAME', type: 'string'},                                  /* 台区名称 */
            {name: 'MP_NAME', type: 'string'},                                  /* 考核表名称 */
            {name: 'ASSET_NO', type: 'string'},                                 /* 资产编号 */
            {name: 'CT_TIMES', type: 'number', defaultValue: ' '},              /* CT倍率 */
            {name: 'PT_TIMES', type: 'number', defaultValue: ' '},              /* PT倍率 */
            {name: 'TOTAL_TIMES', type: 'number', defaultValue: ' '},           /* 总倍率 */
            {name: 'DATA_TIME', type: 'date', dateFormat: 'Y-m-d H:i:s'},       /* 数据时间 */
            {name: 'VOLT_A', type: 'number', defaultValue: ' '},                /* A相电压 */
            {name: 'VOLT_B', type: 'number', defaultValue: ' '},                /* B相电压 */
            {name: 'VOLT_C', type: 'number', defaultValue: ' '},                /* C相电压 */
            {name: 'ECUR_A', type: 'number', defaultValue: ' '},                /* A相电流 */
            {name: 'ECUR_B', type: 'number', defaultValue: ' '},                /* B相电流 */
            {name: 'ECUR_C', type: 'number', defaultValue: ' '}                 /* C相电流 */
        ],
        idProperty: 'SN'
    });
    var tmdq_eccurve_gridstore = Ext.create('Ext.data.Store', {
        pageSize: defaultPageSize,
        // destroy the store if the grid is destroyed
        autoDestroy: true,
        model: 'tmdq-eccurve-gridstore-model',
        remoteSort: true,
        proxy: {
            // load using script tags for cross domain, if the data in on the same domain as
            // this page, an HttpProxy would be better
            type: 'ajax',
            url: ctx_webapp + '/dq/tmdq!getGrid.do',
            reader: {
                type: 'json',
                root: 'records',
                totalProperty: 'totalCount'
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
    // 电压电流数据列表
    var tmdq_eccurve_grid_pc = Ext.create('Ext.form.ComboBox', {
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
        value: tmdq_eccurve_gridstore.pageSize,
        listeners: {
            beforeselect: function(combo, record, index, eOpts) {
                if(tmdq_eccurve_gridstore.pageSize != record.data.value) {
                    tmdq_eccurve_gridstore.currentPage = 1;
                    tmdq_eccurve_gridstore.pageSize = record.data.value;
                    tmdq_eccurve_gridstore.load();
                }
            }
        }
    });
    var tmdq_eccurve_grid_pt = Ext.create('Ext.PagingToolbar', {
        store: tmdq_eccurve_gridstore,
        displayInfo: true,
        displayMsg: '显示第&nbsp;{0}&nbsp;条到&nbsp;{1}&nbsp;条记录,共&nbsp;{2}&nbsp;条记录',
        emptyMsg: '查询无记录',
        items: ['-', tmdq_eccurve_grid_pc]
    });
    var tmdq_eccurve_gridpanel = Ext.create('Ext.grid.Panel', {
        id: 'tmdq-eccurve-grid',
        title: '电压电流数据',
        xtype: 'grid',
        layout: 'fit',
        store: tmdq_eccurve_gridstore,
        loadMask: true,
        columns: [
            {text: "序号", dataIndex: 'SN', width: 50, sortable: false},
            {text: "所属机构", dataIndex: 'ORG_NAME', width: 120, sortable: true},
            {text: "台区名称", dataIndex: 'TG_NAME', width: 120, sortable: true},
            {text: "数据时间", dataIndex: 'DATA_TIME', width: 135, sortable: true, xtype: 'datecolumn', format:'Y-m-d H:i:s'},
            {text: "A相电压", dataIndex: 'VOLT_A', width: 80, sortable: true, xtype: 'numbercolumn', format: '0.00'},
            {text: "B相电压", dataIndex: 'VOLT_B', width: 80, sortable: true, xtype: 'numbercolumn', format: '0.00'},
            {text: "C相电压", dataIndex: 'VOLT_C', width: 80, sortable: true, xtype: 'numbercolumn', format: '0.00'},
            {text: "A相电流", dataIndex: 'ECUR_A', width: 80, sortable: true, xtype: 'numbercolumn', format: '0.00'},
            {text: "B相电流", dataIndex: 'ECUR_B', width: 80, sortable: true, xtype: 'numbercolumn', format: '0.00'},
            {text: "C相电流", dataIndex: 'ECUR_C', width: 80, sortable: true, xtype: 'numbercolumn', format: '0.00'},
            {text: "考核表名称", dataIndex: 'MP_NAME', width: 100, sortable: true},
            {text: "资产编号", dataIndex: 'ASSET_NO', width: 80, sortable: true},
            {text: "CT倍率", dataIndex: 'CT_TIMES', width: 60, sortable: true},
            {text: "PT倍率", dataIndex: 'PT_TIMES', width: 60, sortable: true},
            {text: "总倍率", dataIndex: 'TOTAL_TIMES', width: 60, sortable: true}
        ],
        columnLines: true,
        // paging bar on the bottom
        bbar: tmdq_eccurve_grid_pt,
        // inline buttons
        dockedItems: [{
            xtype: 'toolbar',
            dock: 'top',
            items: ['->', '单位：V（电压），A（电流）']
        }]
    });

    /**
     * ================  保护器数据查询  =======================
     */
    // 查询条件表单
    var pdq_filter_formpanel = Ext.create('Ext.form.Panel', {
        id: 'pdq-filter-form',
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
                                {"tgId": "1", "tgName": "测试台区（96123456）"},
                                {"tgId": "2", "tgName": "测试台区（96123458）"}
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
                    fieldLabel: '保护器名称',
                    labelWidth: 66,
                    allowBlank: false,
                    store: Ext.create('Ext.data.Store', {
                        fields: ['gpId', 'mpName'],
                        data: [ 
                                {"gpId": "0", "mpName": "--- 所有保护器 ---"},
                                {"gpId": "2", "mpName": "总保1"},
                                {"gpId": "3", "mpName": "支路保1"},
                                {"gpId": "4", "mpName": "总保2"},
                                {"gpId": "5", "mpName": "支路保2"}
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
                var query_data_params = {};
                Ext.apply(query_data_params, pdq_filter_formpanel.getForm().getValues(false));
                pdq_data_gridstore.currentPage = 1;
                pdq_data_gridstore.load({
                    params: query_data_params
                });
            }
        }]
    });
    // 保护器数据数据源
    Ext.define('pdq-data-gridstore-model', {
        extend: 'Ext.data.Model',
        fields: [
            {name: 'SN', type: 'int'},                                          /* 序号 */
            {name: 'ORG_NAME', type: 'string'},                                 /* 所属机构 */
            {name: 'TG_NAME', type: 'string'},                                  /* 台区名称 */
            {name: 'PS_NAME', type: 'string'},                                  /* 保护器名称 */
            {name: 'ASSET_NO', type: 'string'},                                 /* 资产编号 */
            {name: 'DATA_TIME', type: 'date', dateFormat: 'Y-m-d H:i:s'},       /* 数据时间 */
            {name: 'VOLT_A', type: 'number', defaultValue: ' '},                /* A相电压 */
            {name: 'VOLT_B', type: 'number', defaultValue: ' '},                /* B相电压 */
            {name: 'VOLT_C', type: 'number', defaultValue: ' '},                /* C相电压 */
            {name: 'ECUR_A', type: 'number', defaultValue: ' '},                /* A相电流 */
            {name: 'ECUR_B', type: 'number', defaultValue: ' '},                /* B相电流 */
            {name: 'ECUR_C', type: 'number', defaultValue: ' '},                /* C相电流 */
            {name: 'ECUR_S', type: 'number', defaultValue: ' '}                 /* 剩余电流 */
        ],
        idProperty: 'SN'
    });
    var pdq_data_gridstore = Ext.create('Ext.data.Store', {
        pageSize: defaultPageSize,
        // destroy the store if the grid is destroyed
        autoDestroy: true,
        model: 'pdq-data-gridstore-model',
        remoteSort: true,
        proxy: {
            // load using script tags for cross domain, if the data in on the same domain as
            // this page, an HttpProxy would be better
            type: 'ajax',
            url: ctx_webapp + '/dq/pdq!getGrid.do',
            reader: {
                type: 'json',
                root: 'records',
                totalProperty: 'totalCount'
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
    // 保护器数据列表
    var pdq_data_grid_pc = Ext.create('Ext.form.ComboBox', {
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
        value: pdq_data_gridstore.pageSize,
        listeners: {
            beforeselect: function(combo, record, index, eOpts) {
                if(pdq_data_gridstore.pageSize != record.data.value) {
                    pdq_data_gridstore.currentPage = 1;
                    pdq_data_gridstore.pageSize = record.data.value;
                    pdq_data_gridstore.load();
                }
            }
        }
    });
    var pdq_data_grid_pt = Ext.create('Ext.PagingToolbar', {
        store: pdq_data_gridstore,
        displayInfo: true,
        displayMsg: '显示第&nbsp;{0}&nbsp;条到&nbsp;{1}&nbsp;条记录,共&nbsp;{2}&nbsp;条记录',
        emptyMsg: '查询无记录',
        items: ['-', pdq_data_grid_pc]
    });
    var pdq_data_gridpanel = Ext.create('Ext.grid.Panel', {
        id: 'pdq-data-grid',
        title: '保护器数据',
        xtype: 'grid',
        layout: 'fit',
        store: pdq_data_gridstore,
        loadMask: true,
        columns: [
            {text: "序号", dataIndex: 'SN', width: 50, sortable: false},
            {text: "所属机构", dataIndex: 'ORG_NAME', width: 120, sortable: true},
            {text: "台区名称", dataIndex: 'TG_NAME', width: 120, sortable: true},
            {text: "数据时间", dataIndex: 'DATA_TIME', width: 135, sortable: true, xtype: 'datecolumn', format:'Y-m-d H:i:s'},
            {text: "A相电压", dataIndex: 'VOLT_A', width: 80, sortable: true, xtype: 'numbercolumn', format: '0.00'},
            {text: "B相电压", dataIndex: 'VOLT_B', width: 80, sortable: true, xtype: 'numbercolumn', format: '0.00'},
            {text: "C相电压", dataIndex: 'VOLT_C', width: 80, sortable: true, xtype: 'numbercolumn', format: '0.00'},
            {text: "A相电流", dataIndex: 'ECUR_A', width: 80, sortable: true, xtype: 'numbercolumn', format: '0.00'},
            {text: "B相电流", dataIndex: 'ECUR_B', width: 80, sortable: true, xtype: 'numbercolumn', format: '0.00'},
            {text: "C相电流", dataIndex: 'ECUR_C', width: 80, sortable: true, xtype: 'numbercolumn', format: '0.00'},
            {text: "剩余电流", dataIndex: 'ECUR_S', width: 80, sortable: true, xtype: 'numbercolumn', format: '0.00'},
            {text: "保护器名称", dataIndex: 'PS_NAME', width: 100, sortable: true},
            {text: "资产编号", dataIndex: 'ASSET_NO', width: 80, sortable: true}
        ],
        columnLines: true,
        // paging bar on the bottom
        bbar: pdq_data_grid_pt,
        // inline buttons
        dockedItems: [{
            xtype: 'toolbar',
            dock: 'top',
            items: ['->', '单位：V（电压），A（电流），mA（剩余电流）']
        }]
    });

    /**
     * ================  台区用电量查询  =======================
     */
    // 查询条件表单
    var tpcq_filter_formpanel = Ext.create('Ext.form.Panel', {
        id: 'tpcq-filter-form',
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
                                {"tgId": "1", "tgName": "测试台区（96123456）"},
                                {"tgId": "2", "tgName": "测试台区（96123458）"}
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
                                {"gpId": "1", "mpName": "测试台区考核表"}
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
                var query_data_params = {};
                Ext.apply(query_data_params, tpcq_filter_formpanel.getForm().getValues(false));
                tpcq_data_gridstore.currentPage = 1;
                tpcq_data_gridstore.load({
                    params: query_data_params
                });
            }
        }]
    });
    // 台区用电量数据源
    Ext.define('tpcq-data-gridstore-model', {
        extend: 'Ext.data.Model',
        fields: [
            {name: 'SN', type: 'int'},                                          /* 序号 */
            {name: 'ORG_NAME', type: 'string'},                                 /* 所属机构 */
            {name: 'TG_NAME', type: 'string'},                                  /* 台区名称 */
            {name: 'MP_NAME', type: 'string'},                                  /* 考核表名称 */
            {name: 'ASSET_NO', type: 'string'},                                 /* 资产编号 */
            {name: 'CT_TIMES', type: 'number', defaultValue: ' '},              /* CT倍率 */
            {name: 'PT_TIMES', type: 'number', defaultValue: ' '},              /* PT倍率 */
            {name: 'TOTAL_TIMES', type: 'number', defaultValue: ' '},           /* 总倍率 */
            {name: 'DATA_TIME', type: 'date', dateFormat: 'Y-m-d H:i:s'},       /* 数据时间 */
            {name: 'P_ACT_TOTAL_LAST', type: 'number', defaultValue: ' '},      /* 正向有功总起度 */
            {name: 'P_ACT_TOTAL', type: 'number', defaultValue: ' '},           /* 正向有功总止度 */
            {name: 'P_ACT_DL', type: 'number', defaultValue: ' '}               /* 正向有功总电量 */
        ],
        idProperty: 'SN'
    });
    var tpcq_data_gridstore = Ext.create('Ext.data.Store', {
        pageSize: defaultPageSize,
        // destroy the store if the grid is destroyed
        autoDestroy: true,
        model: 'tpcq-data-gridstore-model',
        remoteSort: true,
        proxy: {
            // load using script tags for cross domain, if the data in on the same domain as
            // this page, an HttpProxy would be better
            type: 'ajax',
            url: ctx_webapp + '/dq/tpcq!getGrid.do',
            reader: {
                type: 'json',
                root: 'records',
                totalProperty: 'totalCount'
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
    // 台区用电量列表
    var tpcq_data_grid_pc = Ext.create('Ext.form.ComboBox', {
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
        value: tpcq_data_gridstore.pageSize,
        listeners: {
            beforeselect: function(combo, record, index, eOpts) {
                if(tpcq_data_gridstore.pageSize != record.data.value) {
                    tpcq_data_gridstore.currentPage = 1;
                    tpcq_data_gridstore.pageSize = record.data.value;
                    tpcq_data_gridstore.load();
                }
            }
        }
    });
    var tpcq_data_grid_pt = Ext.create('Ext.PagingToolbar', {
        store: tpcq_data_gridstore,
        displayInfo: true,
        displayMsg: '显示第&nbsp;{0}&nbsp;条到&nbsp;{1}&nbsp;条记录,共&nbsp;{2}&nbsp;条记录',
        emptyMsg: '查询无记录',
        items: ['-', tpcq_data_grid_pc]
    });
    var tpcq_data_gridpanel = Ext.create('Ext.grid.Panel', {
        id: 'tpcq-data-grid',
        title: '台区用电量',
        xtype: 'grid',
        layout: 'fit',
        store: tpcq_data_gridstore,
        loadMask: true,
        columns: [
            {text: "序号", dataIndex: 'SN', width: 50, sortable: false},
            {text: "所属机构", dataIndex: 'ORG_NAME', width: 120, sortable: true},
            {text: "台区名称", dataIndex: 'TG_NAME', width: 120, sortable: true},
            {text: "数据时间", dataIndex: 'DATA_TIME', width: 120, sortable: true, xtype: 'datecolumn', format:'Y-m-d H:i'},
            {text: "正向有功总起度", dataIndex: 'P_ACT_TOTAL_LAST', width: 120, sortable: true, xtype: 'numbercolumn', format: '0.00'},
            {text: "正向有功总止度", dataIndex: 'P_ACT_TOTAL', width: 120, sortable: true, xtype: 'numbercolumn', format: '0.00'},
            {text: "正向有功总电量", dataIndex: 'P_ACT_DL', width: 120, sortable: true, xtype: 'numbercolumn', format: '0.00'},
            {text: "考核表名称", dataIndex: 'MP_NAME', width: 100, sortable: true},
            {text: "资产编号", dataIndex: 'ASSET_NO', width: 80, sortable: true},
            {text: "CT倍率", dataIndex: 'CT_TIMES', width: 60, sortable: true},
            {text: "PT倍率", dataIndex: 'PT_TIMES', width: 60, sortable: true},
            {text: "总倍率", dataIndex: 'TOTAL_TIMES', width: 60, sortable: true}
        ],
        columnLines: true,
        // paging bar on the bottom
        bbar: tpcq_data_grid_pt,
        // inline buttons
        dockedItems: [{
            xtype: 'toolbar',
            dock: 'top',
            items: ['->', '单位：kWh（有功起度、有功止度），kWh（有功电量）']
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
                    items: [tmdq_eicurve_gridpanel, tmdq_powercurve_gridpanel, tmdq_pfcurve_gridpanel, tmdq_eccurve_gridpanel],
                    listeners: {
                        tabchange: function(tabPanel, newCard, oldCard, eOpts) {
                            if(newCard.id == 'tmdq-eicurve-grid') {
                                currentDataTable = 'D_EI_CURV_C';
                            }
                            else if(newCard.id == 'tmdq-powercurve-grid') {
                                currentDataTable = 'D_POWER_CRUV_C';
                            }
                            else if(newCard.id == 'tmdq-pfcurve-grid') {
                                currentDataTable = 'D_PF_CRUV_C';
                            }
                            else if(newCard.id == 'tmdq-eccurve-grid') {
                                currentDataTable = 'D_EC_CURV_C';
                            }

                            if(currentDataTable == 'D_EI_CURV_C') {
                                var query_eicurve_params = {
                                        dataTable: currentDataTable
                                };
                                Ext.apply(query_eicurve_params, tmdq_filter_formpanel.getForm().getValues(false));
                                tmdq_eicurve_gridstore.currentPage = 1;
                                tmdq_eicurve_gridstore.load({
                                    params: query_eicurve_params
                                });
                            }
                            else if(currentDataTable == 'D_POWER_CRUV_C') {
                                var query_powercurve_params = {
                                        dataTable: currentDataTable
                                };
                                Ext.apply(query_powercurve_params, tmdq_filter_formpanel.getForm().getValues(false));
                                tmdq_powercurve_gridstore.currentPage = 1;
                                tmdq_powercurve_gridstore.load({
                                    params: query_powercurve_params
                                });
                            }
                            else if(currentDataTable == 'D_PF_CRUV_C') {
                                var query_pfcurve_params = {
                                        dataTable: currentDataTable
                                };
                                Ext.apply(query_pfcurve_params, tmdq_filter_formpanel.getForm().getValues(false));
                                tmdq_pfcurve_gridstore.currentPage = 1;
                                tmdq_pfcurve_gridstore.load({
                                    params: query_pfcurve_params
                                });
                            }
                            else if(currentDataTable == 'D_EC_CURV_C') {
                                var query_eccurve_params = {
                                        dataTable: currentDataTable
                                };
                                Ext.apply(query_eccurve_params, tmdq_filter_formpanel.getForm().getValues(false));
                                tmdq_eccurve_gridstore.currentPage = 1;
                                tmdq_eccurve_gridstore.load({
                                    params: query_eccurve_params
                                });
                            }
                        }
                    }
                }]
            }]
        },

        /**
         * ================  保护器数据查询  =======================
         */
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

        /**
         * ================  台区用电量查询  =======================
         */
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
        }/*,

        *//**
         * ================  集中器事件查询  =======================
         *//*
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

        *//**
         * ================  保护器跳闸事件查询  =======================
         *//*
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