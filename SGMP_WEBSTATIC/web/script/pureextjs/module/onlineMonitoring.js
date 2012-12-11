function getOnlineMonitoringFunctions() {
    return {
        /*
         * ================  台区监测  =======================
         */
        actionTgMonitoring: {
            xtype: 'tabpanel',
            id: 'actionTgMonitoringContentPanel',
            activeTab: 0,
            defaults: {bodyStyle: 'padding: 0'},
            items: [{
                title: '台区监测',
                layout: 'border',
                items: [{
                    region: 'north',
                    title: '台区资料',
                    height: 100,
                    maxSize: 150,
                    margins: '5 5 0 5',
                    bodyStyle: 'padding: 10px;',
                    split: true,
                    html: '<p>台区资料</p>'
                }, {
                    xtype: 'tabpanel',
                    plain: true,
                    region: 'center',
                    margins: '0 5 5 5',
                    activeTab: 0,
                    items: [{
                        title: '考核表数据监测',
                        html: '<p>考核表数据监测</p>'
                    }, {
                        title: '保护器数据监测',
                        html: '<p>保护器数据监测</p>'
                    }]
                }]
            }]
        },

        /*
         * ================  保护器监测  =======================
         */
        actionProtectorMonitoring: {
            xtype: 'tabpanel',
            id: 'actionProtectorMonitoringContentPanel',
            activeTab: 0,
            defaults: {bodyStyle: 'padding: 0'},
            items: [{
                title: '保护器监测',
                layout: 'border',
                items: [{
                    region: 'north',
                    title: '保护器资料',
                    height: 100,
                    maxSize: 150,
                    margins: '5 5 0 5',
                    bodyStyle: 'padding: 10px;',
                    split: true,
                    html: '<p>保护器资料</p>'
                }, {
                    xtype: 'tabpanel',
                    plain: true,
                    region: 'center',
                    margins: '0 5 5 5',
                    activeTab: 0,
                    items: [{
                        title: '实时数据监测',
                        html: '<p>实时数据监测</p>'
                    }]
                }]
            }]
        }
    };
}