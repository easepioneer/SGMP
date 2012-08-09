function getArchivesManagementFunctions() {
    var required = '<span style="color:red;font-weight:bold" data-qtip="Required">*</span>';
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
                    margins: '5 5 0 5',
                    bodyStyle: 'padding: 7px 7px 0 7px;',
                    split: true,
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
                                fieldLabel: '台区编号',
                                allowBlank: false,
                                afterLabelTextTpl: required,
                                name: 'tgNo'
                            }, {
                                xtype: 'textfield',
                                fieldLabel: '台区容量',
                                name: 'tgCap'
                            }]
                        }, {
                            xtype: 'container',
                            flex: 1,
                            layout: 'anchor',
                            items: [{
                                xtype: 'textfield',
                                fieldLabel: '台区名称',
                                afterLabelTextTpl: required,
                                allowBlank: false,
                                name: 'tgName'
                            }, {
                                xtype: 'combobox',
                                fieldLabel: '台区状态',
                                afterLabelTextTpl: required,
                                allowBlank: false,
                                name: 'tgStatus',
                                store: Ext.create('Ext.data.ArrayStore', {
                                    fields: ['statusCode', 'statusName'],
                                    data: [
                                           ['01', '运行'],
                                           ['02', '停运'],
                                           ['03', '拆除']
                                    ]
                                }),
                                valueField: 'statusCode',
                                displayField: 'statusName',
                                queryMode: 'local',
                                emptyText: '请选择台区状态...'
                            }]
                        }, {
                            xtype: 'container',
                            flex: 1,
                            layout: 'anchor',
                            items: [{
                                xtype: 'combobox',
                                fieldLabel: '所属机构',
                                afterLabelTextTpl: required,
                                allowBlank: false,
                                name: 'orgId',
                                store: Ext.create('Ext.data.ArrayStore', {
                                    fields: ['orgId', 'orgName'],
                                    data: [
                                           ['1', '豪顿电气托管'],
                                           ['2', '-- 豪顿电气功能演示'],
                                           ['3', '-- 豪顿电气功能检测']
                                    ]
                                }),
                                valueField: 'orgId',
                                displayField: 'orgName',
                                typeAhead: true,
                                queryMode: 'local',
                                emptyText: '请选择所属机构...'
                            }, {
                                xtype: 'textfield',
                                fieldLabel: '台区地址',
                                name: 'tgAddr'
                            }]
                        }]
                    }],
                    buttons: [{
                        text: '新增',
                        handler: function() {
                            this.up('form').getForm().reset();
                        }
                    }, {
                        text: '保存',
                        handler: function() {
                            this.up('form').getForm().isValid();
                        }
                    }, {
                        text: '取消',
                        handler: function() {
                            this.up('form').getForm().reset();
                        }
                    }]
                }, {
                    xtype: 'tabpanel',
                    plain: true,
                    region: 'center',
                    margins: '5 5 5 5',
                    activeTab: 0,
                    items: [{
                        title: '变压器信息',
                        layout: 'border',
                        hideMode: Ext.isIE ? 'offsets' : 'display',
                        items: [{
                            xtype: 'grid',
                            id: 'transformerGrid',
                            region: 'north',
                            height: 100,
                            minSize: 75,
                            maxSize: 150,
                            margins: '5 5 0 5',
                            columns: [
                                { id: 'tranId', text: '变压器标识', flex: 1, sortable: true, dataIndex: 'tranId' },
                                { text: '变压器名称', width: 100, sortable: true, dataIndex: 'tranName' },
                                { text: '变压器型号', width: 100, sortable: true, dataIndex: 'tranModel' },
                                { text: '高压侧电压', width: 75, sortable : true, dataIndex: 'highVolt' },
                                { text: '低压侧电压', width: 75, sortable : true, dataIndex: 'lowVolt' },
                                { text: '安装地址', width: 150, sortable : true, dataIndex: 'instAddr' }
                            ],
                            listeners: {
                                selectionchange: function(model, records) {
                                    if(records[0]) {
                                        this.up('form').getForm().loadRecord(records[0]);
                                    }
                                }
                            }
                        }, {
                            xtype: 'form',
                            id: 'tranInfoForm',
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
                                        fieldLabel: '变压器标识',
                                        allowBlank: false,
                                        afterLabelTextTpl: required,
                                        name: 'tranId'
                                    }, {
                                        xtype: 'combobox',
                                        fieldLabel: '高压侧电压',
                                        afterLabelTextTpl: required,
                                        allowBlank: false,
                                        name: 'highVolt',
                                        store: Ext.create('Ext.data.ArrayStore', {
                                            fields: ['voltCode', 'voltName'],
                                            data: [
                                                   ['500', '500kV'],
                                                   ['220', '220kV'],
                                                   ['110', '110kV'],
                                                   ['35', '35kV'],
                                                   ['10', '10kV'],
                                                   ['0.38', '380V'],
                                                   ['0.22', '220V']
                                            ]
                                        }),
                                        valueField: 'voltCode',
                                        displayField: 'voltName',
                                        queryMode: 'local',
                                        emptyText: '请选择电压等级...'
                                    }]
                                }, {
                                    xtype: 'container',
                                    flex: 1,
                                    layout: 'anchor',
                                    items: [{
                                        xtype: 'textfield',
                                        fieldLabel: '变压器名称',
                                        allowBlank: false,
                                        afterLabelTextTpl: required,
                                        name: 'tranName'
                                    }, {
                                        xtype: 'combobox',
                                        fieldLabel: '低压侧电压',
                                        afterLabelTextTpl: required,
                                        allowBlank: false,
                                        name: 'lowVolt',
                                        store: Ext.create('Ext.data.ArrayStore', {
                                            fields: ['voltCode', 'voltName'],
                                            data: [
                                                   ['500', '500kV'],
                                                   ['220', '220kV'],
                                                   ['110', '110kV'],
                                                   ['35', '35kV'],
                                                   ['10', '10kV'],
                                                   ['0.38', '380V'],
                                                   ['0.22', '220V']
                                            ]
                                        }),
                                        valueField: 'voltCode',
                                        displayField: 'voltName',
                                        queryMode: 'local',
                                        emptyText: '请选择电压等级...'
                                    }]
                                }, {
                                    xtype: 'container',
                                    flex: 1,
                                    layout: 'anchor',
                                    items: [{
                                        xtype: 'combobox',
                                        fieldLabel: '变压器型号',
                                        afterLabelTextTpl: required,
                                        allowBlank: false,
                                        name: 'orgId',
                                        store: Ext.create('Ext.data.ArrayStore', {
                                            fields: ['modelCode', 'modelName'],
                                            data: []
                                        }),
                                        valueField: 'modelCode',
                                        displayField: 'modelName',
                                        typeAhead: true,
                                        queryMode: 'local',
                                        emptyText: '请选择变压器型号...'
                                    }, {
                                        xtype: 'textfield',
                                        fieldLabel: '安装地址',
                                        name: 'instAddr'
                                    }]
                                }]
                            }],
                            buttons: [{
                                text: '新增',
                                handler: function() {
                                    this.up('form').getForm().reset();
                                }
                            }, {
                                text: '保存',
                                handler: function() {
                                    this.up('form').getForm().isValid();
                                }
                            }, {
                                text: '取消',
                                handler: function() {
                                    this.up('form').getForm().reset();
                                }
                            }]
                        }]
                    }, {
                        title: '集中器信息',
                        html: '<p>集中器信息</p>'
                    }, {
                        title: '考核表信息',
                        html: '<p>考核表信息</p>'
                    }, {
                        title: '保护器信息',
                        html: '<p>保护器信息</p>'
                    }, {
                        title: '操作员信息',
                        html: '<p>操作员信息</p>'
                    }]
                }]
            }]
        }
    };
}