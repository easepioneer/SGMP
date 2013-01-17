function getArchivesManagementFunctions() {
    var required = '<span style="color: red; font-weight: bold;" data-qtip="Required">*</span>';
    var unitCap = '<span style="color: blue; font-weight: bold;">kVA</span>';
    // 
    Ext.define('am-orgnization-liststore-model', {
        extend: 'Ext.data.Model',
        fields: [
            {name: 'id', type: 'int'},                                          /* 机构ID */
            {name: 'orgName', type: 'string'},                                  /* 机构名称 */
            {name: 'orgType', type: 'string'},                                  /* 机构类型 */
            {name: 'parentId', type: 'int'},                                    /* 上级机构 */
            {name: 'sortNo', type: 'int'}                                       /* 排序 */
        ],
        idProperty: 'id'
    });
    var amOrgnizationListStore = Ext.create('Ext.data.Store', {
        // destroy the store if the grid is destroyed
        autoDestroy: true,
        model: 'am-orgnization-liststore-model',
        remoteSort: false,
        proxy: {
            // load using script tags for cross domain, if the data in on the same domain as
            // this page, an HttpProxy would be better
            type: 'ajax',
            url: ctx_webapp + '/sm/orgm!getList.do',
            reader: {
                type: 'json',
                root: 'list'
            }
        },
        // 
        autoLoad: true
    });

    /**
     * ================  台区档案管理  =======================
     */
    // 集中器列表
    Ext.define('tam-term-gridstore-model', {
        extend: 'Ext.data.Model',
        fields: [
            {name: 'id', type: 'int'},                                          /* 集中器标识 */
            {name: 'assetNo', type: 'string'},                                  /* 资产编号 */
            {name: 'logicalAddr', type: 'string'},                              /* 逻辑地址 */
            {name: 'runStatus', type: 'string'},                                /* 运行状态 */
            {name: 'curStatus', type: 'string'},                                /* 当前状态 */
            {name: 'simNo', type: 'string'},                                    /* SIM卡号 */
            {name: 'wiringMode', type: 'string'},                               /* 接线方式 */
            {name: 'instDate', type: 'date', dateFormat: 'Y-m-d H:i:s'},        /* 安装日期 */
            {name: 'commMode', type: 'string'},                                 /* 通讯方式 */
            {name: 'channelType', type: 'string'},                              /* 通道类型 */
            {name: 'protocolNo', type: 'string'},                               /* 集中器规约 */
            {name: 'pr', type: 'string'},                                       /* 产权 */
            {name: 'isAc', type: 'string'}                                      /* 是否接交采 */
        ],
        idProperty: 'id'
    });
    var tam_term_gridstore = Ext.create('Ext.data.Store', {
        // destroy the store if the grid is destroyed
        autoDestroy: true,
        model: 'tam-term-gridstore-model',
        remoteSort: false,
        proxy: {
            // load using script tags for cross domain, if the data in on the same domain as
            // this page, an HttpProxy would be better
            type: 'ajax',
            url: ctx_webapp + '/am/tam!getTermListByTgId.do',
            reader: {
                type: 'json',
                root: 'records',
                totalProperty: 'totalCount'
            },
            // sends single sort as multi parameter
            simpleSortMode: true
        },
        // 
        autoLoad: false
    });
    var tam_term_gridpanel = Ext.create('Ext.grid.Panel', {
        id: 'tam-term-grid',
        xtype: 'grid',
        region: 'north',
        height: 151,
        margins: '5 5 0 5',
        store: tam_term_gridstore,
        loadMask: true,
        columns: [
            {text: "集中器标识", dataIndex: 'id', sortable: false, hideable: true, hidden: true},
            {text: "资产编号", dataIndex: 'assetNo', width: 100, sortable: true},
            {text: "逻辑地址", dataIndex: 'logicalAddr', width: 100, sortable: true},
            {text: "集中器规约", dataIndex: 'protocolNo', width: 100, sortable: true, renderer: getNameByCode_TermProtocol},
            {text: "运行状态", dataIndex: 'runStatus', width: 80, sortable: true, renderer: getNameByCode_TermRunStatus},
            {text: "当前状态", dataIndex: 'curStatus', width: 80, sortable: true, renderer: getNameByCode_TermCurStatus},
            {text: "SIM卡号", dataIndex: 'simNo', width: 100, sortable: true},
            {text: "安装日期", dataIndex: 'instDate', width: 100, sortable: true, xtype: 'datecolumn', format:'Y-m-d'},
            {text: "通讯方式", dataIndex: 'commMode', width: 100, sortable: true, renderer: getNameByCode_TermCommMode},
            {text: "通道类型", dataIndex: 'channelType', width: 100, sortable: true, renderer: getNameByCode_TermChannelType},
            {text: "接线方式", dataIndex: 'wiringMode', width: 80, sortable: true, renderer: getNameByCode_WiringMode}
        ],
        columnLines: true
    });
    tam_term_gridpanel.getSelectionModel().on('select', function(selModel, record) {
        if(record) {
            Ext.getCmp('termInfoForm').getForm().setValues({id: record.getId()});
        }
    });

    // 考核表列表
    Ext.define('tam-meter-gridstore-model', {
        extend: 'Ext.data.Model',
        fields: [
            {name: 'id', type: 'int'},                                          /* 考核表标识 */
            {name: 'assetNo', type: 'string'},                                  /* 资产编号 */
            {name: 'mpName', type: 'string'},                                   /* 考核表名称 */
            {name: 'gpSn', type: 'int'},                                        /* 测量点序号 */
            {name: 'termId', type: 'int'},                                      /* 集中器标识 */
            {name: 'instDate', type: 'date', dateFormat: 'Y-m-d'},              /* 安装日期 */
            {name: 'mpStatus', type: 'string'},                                 /* 电表状态 */
            {name: 'gpAddr', type: 'string'},                                   /* 表地址 */
            {name: 'commMode', type: 'string'},                                 /* 通讯方式 */
            {name: 'protocolNo', type: 'string'},                               /* 表规约 */
            {name: 'totalFactor', type: 'number', defaultValue: ' '},           /* 总倍率 */
            {name: 'ctTimes', type: 'int', defaultValue: ' '},                  /* CT变比 */
            {name: 'ptTimes', type: 'int', defaultValue: ' '}                   /* PT变比 */
        ],
        idProperty: 'id'
    });
    var tam_meter_gridstore = Ext.create('Ext.data.Store', {
        // destroy the store if the grid is destroyed
        autoDestroy: true,
        model: 'tam-meter-gridstore-model',
        remoteSort: false,
        proxy: {
            // load using script tags for cross domain, if the data in on the same domain as
            // this page, an HttpProxy would be better
            type: 'ajax',
            url: ctx_webapp + '/am/tam!getMeterListByTgId.do',
            reader: {
                type: 'json',
                root: 'records',
                totalProperty: 'totalCount'
            },
            // sends single sort as multi parameter
            simpleSortMode: true
        },
        // 
        autoLoad: false
    });
    var tam_meter_gridpanel = Ext.create('Ext.grid.Panel', {
        id: 'tam-meter-grid',
        xtype: 'grid',
        region: 'north',
        height: 151,
        margins: '5 5 0 5',
        store: tam_meter_gridstore,
        loadMask: true,
        columns: [
            {text: "考核表标识", dataIndex: 'id', sortable: false, hideable: true, hidden: true},
            {text: "资产编号", dataIndex: 'assetNo', width: 100, sortable: true},
            {text: "考核表名称", dataIndex: 'mpName', width: 100, sortable: true},
            {text: "电表地址", dataIndex: 'gpAddr', width: 100, sortable: true},
            {text: "测量点序号", dataIndex: 'gpSn', width: 100, sortable: true},
            {text: "采集集中器", dataIndex: 'termId', width: 100, sortable: true/*, renderer: getLogicalAddrByTermId*/},
            {text: "电表规约", dataIndex: 'protocolNo', width: 100, sortable: true/*, renderer: getNameByCode_MeterProtocol*/},
            {text: "电表状态", dataIndex: 'mpStatus', width: 80, sortable: true/*, renderer: getNameByCode_MeterStatus*/},
            {text: "总倍率", dataIndex: 'totalFactor', width: 100, sortable: true, xtype: 'numbercolumn', format: '0.00'},
            {text: "安装日期", dataIndex: 'instDate', width: 100, sortable: true, xtype: 'datecolumn', format:'Y-m-d'},
            {text: "通讯方式", dataIndex: 'commMode', width: 100, sortable: true/*, renderer: getNameByCode_MeterCommMode*/}
        ],
        columnLines: true
    });
    tam_meter_gridpanel.getSelectionModel().on('select', function(selModel, record) {
        if(record) {
            //alert(record.getId());
        }
    });

    // 保护器列表
    Ext.define('tam-ps-gridstore-model', {
        extend: 'Ext.data.Model',
        fields: [
            {name: 'id', type: 'int'},                                          /* 考核表标识 */
            {name: 'assetNo', type: 'string'},                                  /* 资产编号 */
            {name: 'psName', type: 'string'},                                   /* 保护器名称 */
            {name: 'gpSn', type: 'int'},                                        /* 测量点序号 */
            {name: 'termId', type: 'int'},                                      /* 集中器标识 */
            {name: 'gpAddr', type: 'string'},                                   /* 通信地址 */
            {name: 'commMode', type: 'string'},                                 /* 通讯方式 */
            {name: 'protocolNo', type: 'string'},                               /* 保护器规约 */
            {name: 'psModel', type: 'string'}                                   /* 保护器型号 */
        ],
        idProperty: 'id'
    });
    var tam_ps_gridstore = Ext.create('Ext.data.Store', {
        // destroy the store if the grid is destroyed
        autoDestroy: true,
        model: 'tam-ps-gridstore-model',
        remoteSort: false,
        proxy: {
            // load using script tags for cross domain, if the data in on the same domain as
            // this page, an HttpProxy would be better
            type: 'ajax',
            url: ctx_webapp + '/am/tam!getPsListByTgId.do',
            reader: {
                type: 'json',
                root: 'records',
                totalProperty: 'totalCount'
            },
            // sends single sort as multi parameter
            simpleSortMode: true
        },
        // 
        autoLoad: false
    });
    var tam_ps_gridpanel = Ext.create('Ext.grid.Panel', {
        id: 'tam-ps-grid',
        xtype: 'grid',
        region: 'north',
        height: 151,
        margins: '5 5 0 5',
        store: tam_ps_gridstore,
        loadMask: true,
        columns: [
            {text: "保护器标识", dataIndex: 'id', sortable: false, hideable: true, hidden: true},
            {text: "资产编号", dataIndex: 'assetNo', width: 150, sortable: true},
            {text: "保护器名称", dataIndex: 'psName', width: 200, sortable: true},
            {text: "通信地址", dataIndex: 'gpAddr', width: 150, sortable: true},
            {text: "测量点序号", dataIndex: 'gpSn', width: 100, sortable: true},
            {text: "采集集中器", dataIndex: 'termId', width: 100, sortable: true, renderer: getLogicalAddrByTermId},
            {text: "保护器规约", dataIndex: 'protocolNo', width: 150, sortable: true, renderer: getNameByCode_ProtectorProtocol},
            {text: "通讯方式", dataIndex: 'commMode', width: 100, sortable: true, renderer: getNameByCode_MeterCommMode}
        ],
        columnLines: true
    });
    tam_ps_gridpanel.getSelectionModel().on('select', function(selModel, record) {
        if(record) {
            Ext.getCmp('psInfoForm').getForm().setValues({id: record.getId()});
        }
    });

    return {
        /*
         * ================  台区档案管理  =======================
         */
        actionTgArchivesManagement: {
            xtype: 'tabpanel',
            id: 'actionTgArchivesManagementContentPanel',
            activeTab: 0,
            defaults: {bodyStyle: 'padding: 0'},
            items: [{
                title: '台区档案管理',
                layout: 'border',
                items: [{
                    xtype: 'form',
                    id: 'tgInfoForm',
                    region: 'north',
                    title: '台区信息',
                    frame: true,
                    collapsible: false,
                    margins: '5 5 0 5',
                    bodyStyle: 'padding: 7px 7px 0 7px;',
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
                                xtype: 'textfield',
                                fieldLabel: '台区编号',
                                labelWidth: 77,
                                allowBlank: false,
                                afterLabelTextTpl: required,
                                name: 'tgNo'
                            }, {
                                xtype: 'textfield',
                                fieldLabel: '台区容量',
                                labelWidth: 77,
                                afterLabelTextTpl: unitCap,
                                maskRe: /[\d]/,
                                name: 'tgCap'
                            }, {
                                xtype: 'hiddenfield',
                                name: 'id',
                                listeners: {
                                    change: function(field, newValue, oldValue, eOpts) {
                                        //alert(oldValue);
                                        //alert(newValue);
                                        //alert(Ext.JSON.encode(eOpts));
                                        //alert(Ext.isString(newValue));
                                        if(!Ext.isEmpty(newValue) && newValue != '0' && newValue != '-1') {
                                            this.up('form').down('#am-tginfo-new-button').setDisabled(false);
                                            // 加载台区信息
                                            Ext.Ajax.request({
                                                url: ctx_webapp + '/am/tam!getTgById.do',
                                                params: {id: newValue},
                                                method: 'POST',
                                                success: function(response) {
                                                    //alert(response.responseText);
                                                    Ext.getCmp('tgInfoForm').getForm().setValues(Ext.JSON.decode(response.responseText));
                                                    // 加载集中器列表
                                                    tam_term_gridstore.load({
                                                        params: {id: newValue},
                                                        callback: function(records, operation, success) {
                                                            // 加载考核表列表
                                                            tam_meter_gridstore.load({
                                                                params: {id: newValue},
                                                                callback: function(records, operation, success) {
                                                                    // 加载保护器列表
                                                                    tam_ps_gridstore.load({
                                                                        params: {id: newValue},
                                                                        scope: this
                                                                    });
                                                                },
                                                                scope: this
                                                            });
                                                        },
                                                        scope: this
                                                    });
                                                },
                                                failure: function(response) {
                                                    //alert(response.responseText);
                                                }
                                            });
                                        }
                                        else {
                                            this.up('form').down('#am-tginfo-new-button').setDisabled(true);
                                            // 清空台区信息
                                            this.up('form').getForm().reset();
                                            // 清空集中器列表
                                            tam_term_gridstore.removeAll();
                                            // 清空考核表列表
                                            tam_meter_gridstore.removeAll();
                                            // 清空保护器列表
                                            tam_ps_gridstore.removeAll();
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
                                xtype: 'textfield',
                                fieldLabel: '台区名称',
                                labelWidth: 77,
                                allowBlank: false,
                                afterLabelTextTpl: required,
                                name: 'tgName'
                            }, {
                                xtype: 'combobox',
                                fieldLabel: '台区状态',
                                labelWidth: 77,
                                allowBlank: false,
                                afterLabelTextTpl: required,
                                name: 'runStatus',
                                store: Ext.create('Ext.data.ArrayStore', {
                                    fields: ['code', 'name'],
                                    data: [
                                           ['1', '运行'],
                                           ['2', '停运'],
                                           ['3', '拆除']
                                    ]
                                }),
                                valueField: 'code',
                                displayField: 'name',
                                queryMode: 'local',
                                emptyText: '请选择台区状态...'
                            }]
                        }, {
                            xtype: 'container',
                            layout: 'anchor',
                            flex: 1,
                            width: 240,
                            items: [{
                                xtype: 'combobox',
                                fieldLabel: '所属机构',
                                labelWidth: 77,
                                allowBlank: false,
                                afterLabelTextTpl: required,
                                name: 'orgId',
                                store: amOrgnizationListStore,
                                valueField: 'id',
                                displayField: 'orgName',
                                typeAhead: true,
                                queryMode: 'local',
                                emptyText: '请选择所属机构...'
                            }, {
                                xtype: 'textfield',
                                fieldLabel: '台区地址',
                                labelWidth: 77,
                                name: 'instAddr'
                            }]
                        }]
                    }],
                    buttonAlign: 'right',
                    buttons: [{
                        itemId: 'am-tginfo-new-button',
                        text: '新增',
                        disabled: true,
                        handler: function() {
                            Ext.Msg.confirm('提示', '确认要新增台区？', function(btn) {
                                if(btn == 'yes') {
                                    Ext.getCmp('tgInfoForm').getForm().setValues({id: '0'});
                                }
                            });
                        }
                    }, {
                        itemId: 'am-tginfo-save-button',
                        text: '保存',
                        disabled: false,
                        handler: function() {
                            if(this.up('form').getForm().isValid()) {
                                //alert(Ext.JSON.encode(this.up('form').getForm().getValues(false)));
                                Ext.Ajax.request({
                                    url: ctx_webapp + '/am/tam!saveTg.do',
                                    params: {tg: Ext.JSON.encode(this.up('form').getForm().getValues(false))},
                                    method: 'POST',
                                    success: function(response) {
                                        //alert(response.responseText);
                                        var tgId = parseInt(response.responseText);
                                        if(Ext.isNumber(tgId) && tgId > 0) {
                                            Ext.Msg.alert('提示', '保存成功！', function(btn) {
                                                Ext.getCmp('tgInfoForm').getForm().setValues({id: tgId});
                                                if(selectionObjectTreeStore) {
                                                    selectionObjectTreeStore.load(selectionObjectTreeStore.root);
                                                }
                                            });
                                        }
                                        else {
                                            Ext.Msg.alert('提示', '保存失败！', function(btn) {
                                            });
                                        }
                                    },
                                    failure: function(response) {
                                        //alert(response.responseText);
                                        Ext.Msg.alert('提示', '保存失败！', function(btn) {
                                        });
                                    }
                                });
                            }
                        }
                    }/*, {
                        text: '取消',
                        handler: function() {
                            this.up('form').getForm().reset();
                        }
                    }*/]
                }, {
                    xtype: 'tabpanel',
                    plain: true,
                    region: 'center',
                    margins: '5 5 5 5',
                    activeTab: 0,
                    items: [{
                        title: '集中器信息',
                        layout: 'border',
                        hideMode: Ext.isIE ? 'offsets' : 'display',
                        items: [tam_term_gridpanel, {
                            xtype: 'form',
                            id: 'termInfoForm',
                            region: 'center',
                            frame: true,
                            margins: '5 5 5 5',
                            bodyStyle: 'padding: 7px 7px 0 7px;',
                            //split: true,
                            items: [{
                                xtype: 'container',
                                anchor: '100%',
                                layout: 'hbox',
                                items: [{
                                    xtype: 'container',
                                    flex: 1,
                                    layout: 'anchor',
                                    items: [{
                                        xtype: 'textfield',
                                        fieldLabel: '资产编号',
                                        labelWidth: 77,
                                        allowBlank: false,
                                        afterLabelTextTpl: required,
                                        name: 'assetNo'
                                    }, {
                                        xtype: 'combobox',
                                        fieldLabel: '当前状态',
                                        labelWidth: 77,
                                        allowBlank: false,
                                        afterLabelTextTpl: required,
                                        name: 'curStatus',
                                        store: codeListStore_TermCurStatus,
                                        valueField: 'code',
                                        displayField: 'name',
                                        queryMode: 'local',
                                        emptyText: '请选择当前状态...'
                                    }, {
                                        xtype: 'combobox',
                                        fieldLabel: '集中器规约',
                                        labelWidth: 77,
                                        allowBlank: false,
                                        afterLabelTextTpl: required,
                                        name: 'protocolNo',
                                        store: codeListStore_TermProtocol,
                                        valueField: 'code',
                                        displayField: 'name',
                                        queryMode: 'local',
                                        emptyText: '请选择集中器规约...'
                                    }]
                                }, {
                                    xtype: 'container',
                                    flex: 1,
                                    layout: 'anchor',
                                    items: [{
                                        xtype: 'textfield',
                                        fieldLabel: '逻辑地址',
                                        labelWidth: 77,
                                        allowBlank: false,
                                        afterLabelTextTpl: required,
                                        name: 'logicalAddr'
                                    }, {
                                        xtype: 'combobox',
                                        fieldLabel: '接线方式',
                                        labelWidth: 77,
                                        allowBlank: false,
                                        afterLabelTextTpl: required,
                                        name: 'wiringMode',
                                        store: codeListStore_WiringMode,
                                        valueField: 'code',
                                        displayField: 'name',
                                        queryMode: 'local',
                                        emptyText: '请选择接线方式...'
                                    }, {
                                        xtype: 'combobox',
                                        fieldLabel: '通讯方式',
                                        labelWidth: 77,
                                        allowBlank: false,
                                        afterLabelTextTpl: required,
                                        name: 'commMode',
                                        store: codeListStore_TermCommMode,
                                        valueField: 'code',
                                        displayField: 'name',
                                        queryMode: 'local',
                                        emptyText: '请选择通讯方式...'
                                    }]
                                }, {
                                    xtype: 'container',
                                    flex: 1,
                                    layout: 'anchor',
                                    items: [{
                                        xtype: 'textfield',
                                        fieldLabel: 'SIM卡号',
                                        labelWidth: 77,
                                        allowBlank: false,
                                        afterLabelTextTpl: required,
                                        name: 'simNo'
                                    }, {
                                        xtype: 'datefield',
                                        fieldLabel: '安装日期',
                                        labelWidth: 77,
                                        name: 'instDate',
                                        format: 'Y-m-d'
                                    }, {
                                        xtype: 'combobox',
                                        fieldLabel: '通道类型',
                                        labelWidth: 77,
                                        allowBlank: false,
                                        afterLabelTextTpl: required,
                                        name: 'channelType',
                                        store: codeListStore_TermChannelType,
                                        valueField: 'code',
                                        displayField: 'name',
                                        queryMode: 'local',
                                        emptyText: '请选择通道类型...'
                                    }, {
                                        xtype: 'hiddenfield',
                                        name: 'id',
                                        listeners: {
                                            change: function(field, newValue, oldValue, eOpts) {
                                                //alert(oldValue);
                                                //alert(newValue);
                                                //alert(Ext.JSON.encode(eOpts));
                                                //alert(Ext.isString(newValue));
                                                if(!Ext.isEmpty(newValue) && newValue != '0' && newValue != '-1') {
                                                    this.up('form').down('#am-terminfo-new-button').setDisabled(false);
                                                    // 加载集中器信息
                                                    Ext.Ajax.request({
                                                        url: ctx_webapp + '/am/tam!getTermById.do',
                                                        params: {id: newValue},
                                                        method: 'POST',
                                                        success: function(response) {
                                                            //alert(Ext.JSON.decode(response.responseText));
                                                            Ext.getCmp('termInfoForm').getForm().setValues(Ext.JSON.decode(response.responseText));
                                                        },
                                                        failure: function(response) {
                                                            //alert(response.responseText);
                                                        }
                                                    });
                                                }
                                                else {
                                                    this.up('form').down('#am-terminfo-new-button').setDisabled(true);
                                                    // 清空集中器信息
                                                    this.up('form').getForm().reset();
                                                }
                                            }
                                        }
                                    }]
                                }]
                            }],
                            buttons: [{
                                itemId: 'am-terminfo-new-button',
                                text: '新增',
                                disabled: true,
                                handler: function() {
                                    //this.up('form').getForm().reset();
                                    Ext.Msg.confirm('提示', '确认要新增集中器？', function(btn) {
                                        if(btn == 'yes') {
                                            Ext.getCmp('termInfoForm').getForm().setValues({id: '0'});
                                        }
                                    });
                                }
                            }, {
                                itemId: 'am-terminfo-save-button',
                                text: '保存',
                                disabled: false,
                                handler: function() {
                                    if(this.up('form').getForm().isValid()) {
                                        //alert(Ext.JSON.encode(this.up('form').getForm().getValues(false)));
                                        var _term = Ext.JSON.encode(this.up('form').getForm().getValues(false));
                                        var _tgId = Ext.getCmp('tgInfoForm').getForm().getValues(false).id;
                                        Ext.Ajax.request({
                                            url: ctx_webapp + '/am/tam!saveTerm.do',
                                            params: {term: _term, tgId: _tgId},
                                            method: 'POST',
                                            success: function(response) {
                                                //alert(response.responseText);
                                                var termId = parseInt(response.responseText);
                                                if(Ext.isNumber(termId) && termId > 0) {
                                                    Ext.Msg.alert('提示', '保存成功！', function(btn) {
                                                        // 重新加载集中器列表
                                                        tam_term_gridstore.load({
                                                            params: {id: _tgId},
                                                            callback: function(records, operation, success) {
                                                                Ext.getCmp('termInfoForm').getForm().setValues({id: termId});
                                                                if(selectionObjectTreeStore) {
                                                                    selectionObjectTreeStore.load(selectionObjectTreeStore.root);
                                                                }
                                                            },
                                                            scope: this
                                                        });
                                                    });
                                                }
                                                else {
                                                    Ext.Msg.alert('提示', '保存失败！', function(btn) {
                                                    });
                                                }
                                            },
                                            failure: function(response) {
                                                //alert(response.responseText);
                                                Ext.Msg.alert('提示', '保存失败！', function(btn) {
                                                });
                                            }
                                        });
                                    }
                                }
                            }]
                        }]
                    }, {
                        title: '考核表信息',
                        layout: 'border',
                        hideMode: Ext.isIE ? 'offsets' : 'display',
                        items: [tam_meter_gridpanel, {
                            xtype: 'form',
                            id: 'meterInfoForm',
                            region: 'center',
                            frame: true,
                            margins: '5 5 5 5',
                            bodyStyle: 'padding: 7px 7px 0 7px;',
                            //split: true,
                            items: [{
                                xtype: 'container',
                                anchor: '100%',
                                layout: 'hbox',
                                items: [{
                                    xtype: 'container',
                                    flex: 1,
                                    layout: 'anchor',
                                    items: [{
                                        xtype: 'textfield',
                                        fieldLabel: '资产编号',
                                        labelWidth: 77,
                                        allowBlank: false,
                                        afterLabelTextTpl: required,
                                        name: 'assetNo'
                                    }, {
                                        xtype: 'numberfield',
                                        fieldLabel: '测量点序号',
                                        labelWidth: 77,
                                        allowBlank: false,
                                        afterLabelTextTpl: required,
                                        name: 'gpSn'
                                    }]
                                }, {
                                    xtype: 'container',
                                    flex: 1,
                                    layout: 'anchor',
                                    items: [{
                                        xtype: 'textfield',
                                        fieldLabel: '考核表名称',
                                        labelWidth: 77,
                                        allowBlank: false,
                                        afterLabelTextTpl: required,
                                        name: 'mpName'
                                    }, {
                                        xtype: 'combobox',
                                        fieldLabel: '表规约',
                                        labelWidth: 77,
                                        allowBlank: false,
                                        afterLabelTextTpl: required,
                                        name: 'protocolNo',
                                        store: codeListStore_MeterProtocol,
                                        valueField: 'code',
                                        displayField: 'name',
                                        queryMode: 'local',
                                        emptyText: '请选择表规约...'
                                    }]
                                }, {
                                    xtype: 'container',
                                    flex: 1,
                                    layout: 'anchor',
                                    items: [{
                                        xtype: 'textfield',
                                        fieldLabel: '通信地址',
                                        labelWidth: 77,
                                        allowBlank: false,
                                        afterLabelTextTpl: required,
                                        name: 'gpAddr'
                                    }, {
                                        xtype: 'combobox',
                                        fieldLabel: '通讯方式',
                                        labelWidth: 77,
                                        allowBlank: false,
                                        afterLabelTextTpl: required,
                                        name: 'commMode',
                                        store: codeListStore_MeterCommMode,
                                        valueField: 'code',
                                        displayField: 'name',
                                        queryMode: 'local',
                                        emptyText: '请选择通讯方式...'
                                    }, {
                                        xtype: 'hiddenfield',
                                        name: 'id',
                                        listeners: {
                                            change: function(field, newValue, oldValue, eOpts) {
                                                //alert(oldValue);
                                                //alert(newValue);
                                                //alert(Ext.JSON.encode(eOpts));
                                                //alert(Ext.isString(newValue));
                                                if(!Ext.isEmpty(newValue) && newValue != '0' && newValue != '-1') {
                                                    this.up('form').down('#am-meterinfo-new-button').setDisabled(false);
                                                    // 加载考核表信息
                                                    Ext.Ajax.request({
                                                        url: ctx_webapp + '/am/tam!getMeterById.do',
                                                        params: {id: newValue},
                                                        method: 'POST',
                                                        success: function(response) {
                                                            //alert(Ext.JSON.decode(response.responseText));
                                                            Ext.getCmp('meterInfoForm').getForm().setValues(Ext.JSON.decode(response.responseText));
                                                        },
                                                        failure: function(response) {
                                                            //alert(response.responseText);
                                                        }
                                                    });
                                                }
                                                else {
                                                    this.up('form').down('#am-meterinfo-new-button').setDisabled(true);
                                                    // 清空考核表信息
                                                    this.up('form').getForm().reset();
                                                }
                                            }
                                        }
                                    }]
                                }]
                            }],
                            buttons: [{
                                itemId: 'am-meterinfo-new-button',
                                text: '新增',
                                disabled: true,
                                handler: function() {
                                    //this.up('form').getForm().reset();
                                }
                            }, {
                                itemId: 'am-meterinfo-save-button',
                                text: '保存',
                                disabled: false,
                                handler: function() {
                                    //this.up('form').getForm().isValid();
                                }
                            }]
                        }]
                    }, {
                        title: '保护器信息',
                        layout: 'border',
                        hideMode: Ext.isIE ? 'offsets' : 'display',
                        items: [tam_ps_gridpanel, {
                            xtype: 'form',
                            id: 'psInfoForm',
                            region: 'center',
                            frame: true,
                            margins: '5 5 5 5',
                            bodyStyle: 'padding: 7px 7px 0 7px;',
                            //split: true,
                            items: [{
                                xtype: 'container',
                                anchor: '100%',
                                layout: 'hbox',
                                items: [{
                                    xtype: 'container',
                                    flex: 1,
                                    layout: 'anchor',
                                    items: [{
                                        xtype: 'textfield',
                                        fieldLabel: '资产编号',
                                        labelWidth: 77,
                                        allowBlank: false,
                                        afterLabelTextTpl: required,
                                        name: 'assetNo'
                                    }, {
                                        xtype: 'numberfield',
                                        fieldLabel: '测量点序号',
                                        labelWidth: 77,
                                        allowBlank: false,
                                        afterLabelTextTpl: required,
                                        name: 'gpSn'
                                    }]
                                }, {
                                    xtype: 'container',
                                    flex: 1,
                                    layout: 'anchor',
                                    items: [{
                                        xtype: 'textfield',
                                        fieldLabel: '保护器名称',
                                        labelWidth: 77,
                                        allowBlank: false,
                                        afterLabelTextTpl: required,
                                        name: 'psName'
                                    }, {
                                        xtype: 'combobox',
                                        fieldLabel: '保护器规约',
                                        labelWidth: 77,
                                        allowBlank: false,
                                        afterLabelTextTpl: required,
                                        name: 'protocolNo',
                                        store: codeListStore_ProtectorProtocol,
                                        valueField: 'code',
                                        displayField: 'name',
                                        queryMode: 'local',
                                        emptyText: '请选择保护器规约...'
                                    }]
                                }, {
                                    xtype: 'container',
                                    flex: 1,
                                    layout: 'anchor',
                                    items: [{
                                        xtype: 'textfield',
                                        fieldLabel: '通信地址',
                                        labelWidth: 77,
                                        allowBlank: false,
                                        afterLabelTextTpl: required,
                                        name: 'gpAddr'
                                    }, {
                                        xtype: 'combobox',
                                        fieldLabel: '通讯方式',
                                        labelWidth: 77,
                                        allowBlank: false,
                                        afterLabelTextTpl: required,
                                        name: 'commMode',
                                        store: codeListStore_MeterCommMode,
                                        valueField: 'code',
                                        displayField: 'name',
                                        queryMode: 'local',
                                        emptyText: '请选择通讯方式...'
                                    }, {
                                        xtype: 'hiddenfield',
                                        name: 'id',
                                        listeners: {
                                            change: function(field, newValue, oldValue, eOpts) {
                                                //alert(oldValue);
                                                //alert(newValue);
                                                //alert(Ext.JSON.encode(eOpts));
                                                //alert(Ext.isString(newValue));
                                                if(!Ext.isEmpty(newValue) && newValue != '0' && newValue != '-1') {
                                                    this.up('form').down('#am-psinfo-new-button').setDisabled(false);
                                                    // 加载保护器信息
                                                    Ext.Ajax.request({
                                                        url: ctx_webapp + '/am/tam!getPsById.do',
                                                        params: {id: newValue},
                                                        method: 'POST',
                                                        success: function(response) {
                                                            //alert(Ext.JSON.decode(response.responseText));
                                                            Ext.getCmp('psInfoForm').getForm().setValues(Ext.JSON.decode(response.responseText));
                                                        },
                                                        failure: function(response) {
                                                            //alert(response.responseText);
                                                        }
                                                    });
                                                }
                                                else {
                                                    this.up('form').down('#am-psinfo-new-button').setDisabled(true);
                                                    // 清空保护器信息
                                                    this.up('form').getForm().reset();
                                                }
                                            }
                                        }
                                    }]
                                }]
                            }],
                            buttons: [{
                                itemId: 'am-psinfo-new-button',
                                text: '新增',
                                disabled: true,
                                handler: function() {
                                    //this.up('form').getForm().reset();
                                }
                            }, {
                                itemId: 'am-psinfo-save-button',
                                text: '保存',
                                disabled: false,
                                handler: function() {
                                    //this.up('form').getForm().isValid();
                                }
                            }]
                        }]
                    }]
                }]
            }]
        }
    };
}