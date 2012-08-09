function getDataQueryFunctions() {
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
                title: '台区考核表数据',
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
                        title: '表码数据',
                        html: '<p>表码数据</p>'
                    }, {
                        title: '负荷数据',
                        html: '<p>负荷数据</p>'
                    }]
                }]
            }]
        },

        /*
         * ================  保护器数据查询  =======================
         */
        actionProtectorDataQuery: {
            xtype: 'tabpanel',
            id: 'actionProtectorDataQueryContentPanel',
            activeTab: 0,
            defaults: {bodyStyle: 'padding: 0'},
            items: [{
                title: '保护器数据',
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
                        title: '保护器数据',
                        html: '<p>保护器数据</p>'
                    }]
                }]
            }]
        }
    };
}