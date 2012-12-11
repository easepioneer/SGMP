function getSystemManagementFunctions() {
    return {
        /*
         * ================  组织机构管理  =======================
         */
        actionOrgnizationManagement: {
            xtype: 'tabpanel',
            id: 'actionOrgnizationManagementContentPanel',
            activeTab: 0,
            defaults: {bodyStyle: 'padding: 0'},
            items: [{
                title: '组织机构管理',
                layout: 'border',
                items: [{
                    region: 'center',
                    title: '组织机构管理',
                    margins: '0 5 5 5',
                    bodyStyle: 'padding: 10px;',
                    split: true,
                    html: '<p>组织机构管理</p>'
                }]
            }]
        },

        /*
         * ================  操作员管理  =======================
         */
        actionOperatorManagement: {
            xtype: 'tabpanel',
            id: 'actionOperatorManagementContentPanel',
            activeTab: 0,
            defaults: {bodyStyle: 'padding: 0'},
            items: [{
                title: '操作员管理',
                layout: 'border',
                items: [{
                    region: 'center',
                    title: '操作员管理',
                    margins: '0 5 5 5',
                    bodyStyle: 'padding: 10px;',
                    split: true,
                    html: '<p>操作员管理</p>'
                }]
            }]
        },

        /*
         * ================  角色管理  =======================
         */
        actionRoleManagement: {
            xtype: 'tabpanel',
            id: 'actionRoleManagementContentPanel',
            activeTab: 0,
            defaults: {bodyStyle: 'padding: 0'},
            items: [{
                title: '角色管理',
                layout: 'border',
                items: [{
                    region: 'center',
                    title: '角色管理',
                    margins: '0 5 5 5',
                    bodyStyle: 'padding: 10px;',
                    split: true,
                    html: '<p>角色管理</p>'
                }]
            }]
        }
    };
}