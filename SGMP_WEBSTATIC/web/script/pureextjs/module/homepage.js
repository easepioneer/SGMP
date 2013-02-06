function getHomepageFunctions() {
    return {
        /*
         * ================  首页  =======================
         */
        actionHomepage: {
            xtype: 'tabpanel',
            id: 'actionHomepageContentPanel',
            activeTab: 0,
            defaults: {bodyStyle: 'padding: 0'},
            items: [{
                title: '首页',
                layout: 'border',
                items: [/*{
                    region: 'north',
                    title: '企业介绍',
                    margins: '5 5 5 5',
                    bodyStyle: 'padding: 10px;',
                    split: false,
                    html: '<p>浙江豪顿电气有限公司位于杭州临安，是一家以电力电子产品为先导，集科研开发、生产经营、技术服务、系统集成为一体的科技型企业，以推动电气行业迈入智能新时代为己任。</p>' 
                        + '<p>豪顿电气具有一支经验丰富、高素质的技术管理队伍和员工，拥有标准化厂房、先进的制造和检测设备，采用计算机辅助设计及管理。</p>' 
                        + '<p>企业通过ISO9001:2000质量体系认证和"3C"强制认证，确保产品质量。并不断探索研发高品质产品，满足国内外客户需求。</p>' 
                        + '<p>公司在武汉、上海、宁波等大中小城市都设立了销售网点，能快捷、周到地为客户提供产品全方位服务。</p>' 
                        + '<p>豪顿电气将积极信奉“诚信为本，合作共赢”的人本文化，让我们携手共同创造辉煌的明天。</p>'
                }, {
                    region: 'center',
                    title: '系统介绍',
                    margins: '0 5 5 5',
                    bodyStyle: 'padding: 10px;',
                    html: '<p>低压配电网络信息一体化平台</p>'
                }*/]
            }]
        }
    };
}