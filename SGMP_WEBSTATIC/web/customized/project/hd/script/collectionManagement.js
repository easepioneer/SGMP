function getCollectionManagementFunctions() {
    return {
        /**
         * ================  采集任务管理  =======================
         */
        actionCollectionTaskManagement: {
            xtype: 'tabpanel',
            id: 'actionCollectionTaskManagementContentPanel',
            activeTab: 0,
            defaults: {bodyStyle: 'padding: 0'},
            items: [{
                title: '台区考核表数据召测',
                layout: 'border',
                items: []
            }]
        },
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
                items: [{
                    xtype: 'form',
                    id: 'filterForm31',
                    region: 'north',
                    title: '筛选条件',
                    frame: true,
                    height: 66,
                    minHeight: 66,
                    maxHeight: 66,
                    margins: '5 5 0 5',
                    bodyStyle: 'padding: 5px;',
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
                                xtype: 'combobox',
                                fieldLabel: '所属机构',
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
                            }]
                        }, {
                            xtype: 'container',
                            flex: 1,
                            layout: 'anchor',
                            items: [{
                                xtype: 'combobox',
                                fieldLabel: '所属台区',
                                allowBlank: false,
                                name: 'tgId',
                                store: Ext.create('Ext.data.ArrayStore', {
                                    fields: ['tgId', 'tgName'],
                                    data: [
                                           ['1', '豪顿电气演示台区1'],
                                           ['2', '豪顿电气演示台区2']
                                    ]
                                }),
                                valueField: 'tgId',
                                displayField: 'tgName',
                                typeAhead: true,
                                queryMode: 'local',
                                emptyText: '请选择所属台区...'
                            }]
                        }, {
                            xtype: 'container',
                            flex: 1,
                            layout: 'anchor',
                            items: [{
                                xtype: 'textfield',
                                fieldLabel: '逻辑地址',
                                name: 'termAddr'
                            }]
                        }]
                    }],
                    dockedItems: {
                        xtype: 'toolbar',
                        dock: 'right',
                        ui: 'footer',
                        items: ['->', {
                            text: ' 查 询 ',
                            handler: function() {
                            }
                        }]
                    }/*,
                    buttons: [{
                        text: '查询',
                        handler: function() {
                            //this.up('form').getForm().reset();
                        }
                    }]*/
                }, {
                    xtype: 'tabpanel',
                    plain: true,
                    region: 'center',
                    margins: '0 5 5 5',
                    activeTab: 0,
                    items: [{
                        title: '台区考核表列表',
                        xtype: 'grid',
                        layout: 'fit',
                        store: Ext.create('Ext.data.ArrayStore', {
                            fields: [
                               {name: 'SN'},
                               {name: 'ORG_NAME', type: 'string'},
                               {name: 'TG_NAME', type: 'string'},
                               {name: 'TERM_ADDR', type: 'string'},
                               {name: 'METER_NO', type: 'string'},
                               {name: 'GP_SN', type: 'int'},
                               {name: 'TOTAL_RATIO', type: 'float'},
                               {name: 'CT_RATIO', type: 'float'},
                               {name: 'PT_RATIO', type: 'float'}
                            ]/*,
                            data: myData*/
                        }),
                        columns: [
                            {
                                text     : '序号',
                                width    : 40, 
                                flex     : 1,
                                sortable : true, 
                                dataIndex: 'SN'
                            },
                            {
                                text     : '所属机构', 
                                width    : 150, 
                                sortable : true, 
                                dataIndex: 'ORG_NAME'
                            },
                            {
                                text     : '台区名称', 
                                width    : 200, 
                                sortable : true, 
                                dataIndex: 'TG_NAME'
                            },
                            {
                                text     : '逻辑地址', 
                                width    : 100, 
                                sortable : true, 
                                dataIndex: 'TERM_ADDR'
                            },
                            {
                                text     : '考核表局号', 
                                width    : 100, 
                                sortable : true, 
                                dataIndex: 'METER_NO'
                            },
                            {
                                text     : '测量点序号', 
                                width    : 100, 
                                sortable : true, 
                                dataIndex: 'GP_SN'
                            },
                            {
                                text     : '总倍率', 
                                width    : 100, 
                                sortable : true, 
                                dataIndex: 'TOTAL_RATIO'
                            },
                            {
                                text     : 'CT变比', 
                                width    : 100, 
                                sortable : true, 
                                dataIndex: 'CT_RATIO'
                            },
                            {
                                text     : 'PT变比', 
                                width    : 100, 
                                sortable : true, 
                                dataIndex: 'PT_RATIO'
                            }
                        ],
                        stripeRows: true,
                        tbar: [{
                            text: '表码数据召测',
                            handler: function() {
                                //this.up('form').getForm().reset();
                            }
                        }, {
                            text: '负荷数据召测',
                            handler: function() {
                                //this.up('form').getForm().reset();
                            }
                        }, {
                            text: '综合数据召测',
                            handler: function() {
                                //this.up('form').getForm().reset();
                            }
                        }]
                    }]
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
                items: [{
                    xtype: 'form',
                    id: 'filterForm32',
                    region: 'north',
                    title: '筛选条件',
                    frame: true,
                    height: 66,
                    minHeight: 66,
                    maxHeight: 66,
                    margins: '5 5 0 5',
                    bodyStyle: 'padding: 5px;',
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
                                xtype: 'combobox',
                                fieldLabel: '所属机构',
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
                            }]
                        }, {
                            xtype: 'container',
                            flex: 1,
                            layout: 'anchor',
                            items: [{
                                xtype: 'combobox',
                                fieldLabel: '所属台区',
                                allowBlank: false,
                                name: 'tgId',
                                store: Ext.create('Ext.data.ArrayStore', {
                                    fields: ['tgId', 'tgName'],
                                    data: [
                                           ['1', '豪顿电气演示台区1'],
                                           ['2', '豪顿电气演示台区2']
                                    ]
                                }),
                                valueField: 'tgId',
                                displayField: 'tgName',
                                typeAhead: true,
                                queryMode: 'local',
                                emptyText: '请选择所属台区...'
                            }]
                        }, {
                            xtype: 'container',
                            flex: 1,
                            layout: 'anchor',
                            items: [{
                                xtype: 'textfield',
                                fieldLabel: '逻辑地址',
                                name: 'termAddr'
                            }]
                        }]
                    }],
                    dockedItems: {
                        xtype: 'toolbar',
                        dock: 'right',
                        ui: 'footer',
                        items: ['->', {
                            text: ' 查 询 ',
                            handler: function() {
                            }
                        }]
                    }/*,
                    buttons: [{
                        text: '查询',
                        handler: function() {
                            //this.up('form').getForm().reset();
                        }
                    }]*/
                }, {
                    xtype: 'tabpanel',
                    plain: true,
                    region: 'center',
                    margins: '0 5 5 5',
                    activeTab: 0,
                    items: [{
                        title: '保护器列表',
                        xtype: 'grid',
                        layout: 'fit',
                        store: Ext.create('Ext.data.ArrayStore', {
                            fields: [
                               {name: 'SN'},
                               {name: 'ORG_NAME', type: 'string'},
                               {name: 'TG_NAME', type: 'string'},
                               {name: 'TERM_ADDR', type: 'string'},
                               {name: 'PS_NAME', type: 'string'},
                               {name: 'GP_SN', type: 'int'},
                               {name: 'TOTAL_RATIO', type: 'float'},
                               {name: 'CT_RATIO', type: 'float'},
                               {name: 'PT_RATIO', type: 'float'}
                            ]/*,
                            data: myData*/
                        }),
                        columns: [
                            {
                                text     : '序号',
                                width    : 40, 
                                flex     : 1,
                                sortable : true, 
                                dataIndex: 'SN'
                            },
                            {
                                text     : '所属机构', 
                                width    : 150, 
                                sortable : true, 
                                dataIndex: 'ORG_NAME'
                            },
                            {
                                text     : '台区名称', 
                                width    : 200, 
                                sortable : true, 
                                dataIndex: 'TG_NAME'
                            },
                            {
                                text     : '逻辑地址', 
                                width    : 100, 
                                sortable : true, 
                                dataIndex: 'TERM_ADDR'
                            },
                            {
                                text     : '保护器名称', 
                                width    : 150, 
                                sortable : true, 
                                dataIndex: 'PS_NAME'
                            },
                            {
                                text     : '测量点序号', 
                                width    : 100, 
                                sortable : true, 
                                dataIndex: 'GP_SN'
                            },
                            {
                                text     : '总倍率', 
                                width    : 100, 
                                sortable : true, 
                                dataIndex: 'TOTAL_RATIO'
                            },
                            {
                                text     : 'CT变比', 
                                width    : 100, 
                                sortable : true, 
                                dataIndex: 'CT_RATIO'
                            },
                            {
                                text     : 'PT变比', 
                                width    : 100, 
                                sortable : true, 
                                dataIndex: 'PT_RATIO'
                            }
                        ],
                        stripeRows: true,
                        tbar: [{
                            text: '电压电流数据召测',
                            handler: function() {
                                //this.up('form').getForm().reset();
                            }
                        }, {
                            text: '保护器信息召测',
                            handler: function() {
                                //this.up('form').getForm().reset();
                            }
                        }]
                    }]
                }]
            }]
        }
    };
}