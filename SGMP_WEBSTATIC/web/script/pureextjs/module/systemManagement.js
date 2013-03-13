function getSystemManagementFunctions() {
    // 组织机构管理
    Ext.define('sm-orgnization-treestore-model', {
        extend: 'Ext.data.Model',
        fields: [
            {name: 'id', type: 'int'},                                          /* 机构ID */
            {name: 'orgNo', type: 'string'},                                    /* 机构编码 */
            {name: 'orgName', type: 'string'},                                  /* 机构名称 */
            {name: 'orgType', type: 'string'},                                  /* 机构类型 */
            {name: 'parentId', type: 'int'},                                    /* 上级机构 */
            {name: 'sortNo', type: 'int'}                                       /* 排序 */
        ],
        idProperty: 'id'
    });
    var smOrgnizationTreeStore = Ext.create('Ext.data.TreeStore', {
        // destroy the store if the grid is destroyed
        autoDestroy: true,
        model: 'sm-orgnization-treestore-model',
        proxy: {
            // load using script tags for cross domain, if the data in on the same domain as
            // this page, an HttpProxy would be better
            type: 'ajax',
            url: ctx_webapp + '/sm/orgm!getTree.do',
            timeout: 600000,
            reader: {
                type: 'json',
                root: 'tree'
            }
        },
        // 
        autoLoad: false
    });

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