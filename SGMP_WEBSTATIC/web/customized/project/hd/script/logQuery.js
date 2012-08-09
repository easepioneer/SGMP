function getLogQueryFunctions() {
    return {
        /*
         * ================  系统日志查询  =======================
         */
        actionSystemLogQuery: {
            xtype: 'tabpanel',
            id: 'actionSystemLogQueryContentPanel',
            activeTab: 0,
            defaults: {bodyStyle: 'padding: 0'},
            items: [{
                title: '系统日志',
                layout: 'border',
                items: [{
                    region: 'north',
                    title: '筛选条件',
                    height: 100,
                    maxSize: 150,
                    margins: '5 5 0 5',
                    bodyStyle: 'padding: 10px;',
                    split: true,
                    html: '<p>筛选条件</p>'
                }, {
                    xtype: 'tabpanel',
                    plain: true,
                    region: 'center',
                    margins: '0 5 5 5',
                    activeTab: 0,
                    items: [{
                        title: '系统日志',
                        html: '<p>系统日志</p>'
                    }]
                }]
            }]
        },

        /*
         * ================  操作日志  =======================
         */
        actionOperationLogQuery: {
            xtype: 'tabpanel',
            id: 'actionOperationLogQueryContentPanel',
            activeTab: 0,
            defaults: {bodyStyle: 'padding: 0'},
            items: [{
                title: '操作日志',
                layout: 'border',
                items: [{
                    region: 'north',
                    title: '筛选条件',
                    height: 100,
                    maxSize: 150,
                    margins: '5 5 0 5',
                    bodyStyle: 'padding: 10px;',
                    split: true,
                    html: '<p>筛选条件</p>'
                }, {
                    xtype: 'tabpanel',
                    plain: true,
                    region: 'center',
                    margins: '0 5 5 5',
                    activeTab: 0,
                    items: [{
                        title: '操作日志',
                        html: '<p>操作日志</p>'
                    }]
                }]
            }]
        },

        /*
         * ================  通信日志  =======================
         */
        actionCommunicationLogQuery: {
            xtype: 'tabpanel',
            id: 'actionCommunicationLogQueryContentPanel',
            activeTab: 0,
            defaults: {bodyStyle: 'padding: 0'},
            items: [{
                title: '通信日志',
                layout: 'border',
                items: [{
                    region: 'north',
                    title: '筛选条件',
                    height: 100,
                    maxSize: 150,
                    margins: '5 5 0 5',
                    bodyStyle: 'padding: 10px;',
                    split: true,
                    html: '<p>筛选条件</p>'
                }, {
                    xtype: 'tabpanel',
                    plain: true,
                    region: 'center',
                    margins: '0 5 5 5',
                    activeTab: 0,
                    items: [{
                        title: '通信日志',
                        html: '<p>通信日志</p>'
                    }]
                }]
            }]
        },

        /*
         * ================  接口日志  =======================
         */
        actionInterfaceLogQuery: {
            xtype: 'tabpanel',
            id: 'actionInterfaceLogQueryContentPanel',
            activeTab: 0,
            defaults: {bodyStyle: 'padding: 0'},
            items: [{
                title: '接口日志',
                layout: 'border',
                items: [{
                    region: 'north',
                    title: '筛选条件',
                    height: 100,
                    maxSize: 150,
                    margins: '5 5 0 5',
                    bodyStyle: 'padding: 10px;',
                    split: true,
                    html: '<p>筛选条件</p>'
                }, {
                    xtype: 'tabpanel',
                    plain: true,
                    region: 'center',
                    margins: '0 5 5 5',
                    activeTab: 0,
                    items: [{
                        title: '接口日志',
                        html: '<p>接口日志</p>'
                    }]
                }]
            }]
        }
    };
}