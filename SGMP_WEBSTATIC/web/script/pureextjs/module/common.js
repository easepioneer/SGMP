Ext.define('code-liststore-model', {
    extend: 'Ext.data.Model',
    fields: [
        {name: 'code', type: 'string'},                                         /* 编码 */
        {name: 'name', type: 'string'}                                          /* 名称 */
    ],
    idProperty: 'code'
});

// 台区状态
var codeListStore_TgStatus = Ext.create('Ext.data.Store', {
    model: 'code-liststore-model',
    remoteSort: false,
    data: [ 
            {"code": "1", "name": "运行"},
            {"code": "2", "name": "停运"},
            {"code": "3", "name": "拆除"}
    ]
});
function getNameByCode_TgStatus(value) {
    if(!Ext.isEmpty(value)) {
        return codeListStore_TgStatus.getById(value).get('name');
    }
    else {
        return '';
    }
}

// 集中器规约
var codeListStore_TermProtocol = Ext.create('Ext.data.Store', {
    model: 'code-liststore-model',
    remoteSort: false,
    data: [ 
            {"code": "100", "name": "376规约"}
    ]
});
function getNameByCode_TermProtocol(value) {
    if(!Ext.isEmpty(value)) {
        return codeListStore_TermProtocol.getById(value).get('name');
    }
    else {
        return '';
    }
}

// 表规约
var codeListStore_MeterProtocol = Ext.create('Ext.data.Store', {
    model: 'code-liststore-model',
    remoteSort: false,
    data: [ 
            {"code": "1", "name": "DL/T 645—1997"},
            {"code": "30", "name": "DL/T 645—2007"}
    ]
});
function getNameByCode_MeterProtocol(value) {
    if(!Ext.isEmpty(value)) {
        return codeListStore_MeterProtocol.getById(value).get('name');
    }
    else {
        return '';
    }
}

// 保护器规约
var codeListStore_ProtectorProtocol = Ext.create('Ext.data.Store', {
    model: 'code-liststore-model',
    remoteSort: false,
    data: [ 
            {"code": "101", "name": "DL/T 645—1997扩展规约"}
    ]
});
function getNameByCode_ProtectorProtocol(value) {
    if(!Ext.isEmpty(value)) {
        return codeListStore_ProtectorProtocol.getById(value).get('name');
    }
    else {
        return '';
    }
}

// 集中器当前状态
var codeListStore_TermCurStatus = Ext.create('Ext.data.Store', {
    model: 'code-liststore-model',
    remoteSort: false,
    data: [ 
            {"code": "1", "name": "运行"},
            {"code": "2", "name": "待调"},
            {"code": "6", "name": "故障"},
            {"code": "7", "name": "停运"}
    ]
});
function getNameByCode_TermCurStatus(value) {
    if(!Ext.isEmpty(value)) {
        return codeListStore_TermCurStatus.getById(value).get('name');
    }
    else {
        return '';
    }
}

// 集中器运行状态
var codeListStore_TermRunStatus = Ext.create('Ext.data.Store', {
    model: 'code-liststore-model',
    remoteSort: false,
    data: [ 
            {"code": "1", "name": "在线"},
            {"code": "2", "name": "不在线"},
            {"code": "3", "name": "停电"}
    ]
});
function getNameByCode_TermRunStatus(value) {
    if(!Ext.isEmpty(value)) {
        return codeListStore_TermRunStatus.getById(value).get('name');
    }
    else {
        return '';
    }
}

// 集中器通讯方式
var codeListStore_TermCommMode = Ext.create('Ext.data.Store', {
    model: 'code-liststore-model',
    remoteSort: false,
    data: [ 
            {"code": "1", "name": "GPRS"},
            {"code": "2", "name": "CDMA"},
            {"code": "3", "name": "230M"},
            {"code": "4", "name": "232串口"},
            {"code": "5", "name": "有线网络"},
            {"code": "6", "name": "短信"},
            {"code": "7", "name": "电力专线"}
    ]
});
function getNameByCode_TermCommMode(value) {
    if(!Ext.isEmpty(value)) {
        return codeListStore_TermCommMode.getById(value).get('name');
    }
    else {
        return '';
    }
}

// 表通讯方式
var codeListStore_MeterCommMode = Ext.create('Ext.data.Store', {
    model: 'code-liststore-model',
    remoteSort: false,
    data: [ 
            {"code": "1", "name": "485"},
            {"code": "2", "name": "载波"},
            {"code": "3", "name": "小无线"},
            {"code": "4", "name": "ZIGBEE"}
    ]
});
function getNameByCode_MeterCommMode(value) {
    if(!Ext.isEmpty(value)) {
        return codeListStore_MeterCommMode.getById(value).get('name');
    }
    else {
        return '';
    }
}

// 集中器通道类型
var codeListStore_TermChannelType = Ext.create('Ext.data.Store', {
    model: 'code-liststore-model',
    remoteSort: false,
    data: [ 
            {"code": "1", "name": "TCP"},
            {"code": "2", "name": "UDP"}
    ]
});
function getNameByCode_TermChannelType(value) {
    if(!Ext.isEmpty(value)) {
        return codeListStore_TermChannelType.getById(value).get('name');
    }
    else {
        return '';
    }
}

// 接线方式
var codeListStore_WiringMode = Ext.create('Ext.data.Store', {
    model: 'code-liststore-model',
    remoteSort: false,
    data: [ 
            {"code": "1", "name": "单相"},
            {"code": "3", "name": "三相三线"},
            {"code": "4", "name": "三相四线"}
    ]
});
function getNameByCode_WiringMode(value) {
    if(!Ext.isEmpty(value)) {
        return codeListStore_WiringMode.getById(value).get('name');
    }
    else {
        return '';
    }
}

// 计量方式
var codeListStore_MeasMode = Ext.create('Ext.data.Store', {
    model: 'code-liststore-model',
    remoteSort: false,
    data: [ 
            {"code": "1", "name": "高供高计"},
            {"code": "2", "name": "高供低计"},
            {"code": "3", "name": "低供低计"}
    ]
});
function getNameByCode_MeasMode(value) {
    if(!Ext.isEmpty(value)) {
        return codeListStore_MeasMode.getById(value).get('name');
    }
    else {
        return '';
    }
}

// 产权
var codeListStore_Pr = Ext.create('Ext.data.Store', {
    model: 'code-liststore-model',
    remoteSort: false,
    data: [ 
            {"code": "1", "name": "局方"},
            {"code": "2", "name": "用户"}
    ]
});
function getNameByCode_Pr(value) {
    if(!Ext.isEmpty(value)) {
        return codeListStore_Pr.getById(value).get('name');
    }
    else {
        return '';
    }
}

// CT变比
var codeListStore_CtRatio = Ext.create('Ext.data.Store', {
    model: 'code-liststore-model',
    remoteSort: false,
    data: [ 
            {"code": "1", "name": "5/5"},
            {"code": "2", "name": "10/5"},
            {"code": "3", "name": "15/5"},
            {"code": "4", "name": "20/5"},
            {"code": "5", "name": "25/5"},
            {"code": "6", "name": "30/5"},
            {"code": "7", "name": "35/5"},
            {"code": "8", "name": "40/5"},
            {"code": "9", "name": "45/5"},
            {"code": "10", "name": "50/5"},
            {"code": "11", "name": "55/5"},
            {"code": "12", "name": "60/5"},
            {"code": "13", "name": "65/5"},
            {"code": "14", "name": "70/5"},
            {"code": "15", "name": "75/5"},
            {"code": "16", "name": "80/5"},
            {"code": "17", "name": "85/5"},
            {"code": "18", "name": "90/5"},
            {"code": "19", "name": "95/5"},
            {"code": "20", "name": "100/5"},
            {"code": "30", "name": "150/5"},
            {"code": "40", "name": "200/5"},
            {"code": "50", "name": "250/5"},
            {"code": "60", "name": "300/5"},
            {"code": "70", "name": "350/5"},
            {"code": "80", "name": "400/5"},
            {"code": "90", "name": "450/5"},
            {"code": "100", "name": "500/5"},
            {"code": "110", "name": "550/5"},
            {"code": "120", "name": "600/5"},
            {"code": "130", "name": "650/5"},
            {"code": "140", "name": "700/5"},
            {"code": "150", "name": "750/5"},
            {"code": "160", "name": "800/5"},
            {"code": "200", "name": "1000/5"},
            {"code": "240", "name": "1200/5"},
            {"code": "250", "name": "1250/5"},
            {"code": "300", "name": "1500/5"},
            {"code": "400", "name": "2000/5"},
            {"code": "500", "name": "2500/5"},
            {"code": "600", "name": "3000/5"},
            {"code": "700", "name": "3500/5"},
            {"code": "800", "name": "4000/5"},
            {"code": "900", "name": "4500/5"},
            {"code": "1000", "name": "5000/5"},
            {"code": "1200", "name": "6000/5"},
            {"code": "1500", "name": "7500/5"},
            {"code": "2000", "name": "10000/5"},
            {"code": "3000", "name": "15000/5"}
    ]
});
function getNameByCode_CtRatio(value) {
    if(!Ext.isEmpty(value)) {
        return codeListStore_CtRatio.getById(value).get('name');
    }
    else {
        return '';
    }
}

// PT变比
var codeListStore_PtRatio = Ext.create('Ext.data.Store', {
    model: 'code-liststore-model',
    remoteSort: false,
    data: [ 
            {"code": "1", "name": "220/220"},
            {"code": "2", "name": "10/5"},
            {"code": "10", "name": "50/5"},
            {"code": "11", "name": "1100/100"},
            {"code": "20", "name": "100/5"},
            {"code": "40", "name": "200/5"},
            {"code": "60", "name": "6kV/100V"},
            {"code": "100", "name": "10kV/100V"},
            {"code": "110", "name": "11kV/100V"}
    ]
});
function getNameByCode_PtRatio(value) {
    if(!Ext.isEmpty(value)) {
        return codeListStore_PtRatio.getById(value).get('name');
    }
    else {
        return '';
    }
}

// 波特率
var codeListStore_Baudrate = Ext.create('Ext.data.Store', {
    model: 'code-liststore-model',
    remoteSort: false,
    data: [ 
            {"code": "0", "name": "300"},
            {"code": "1", "name": "600"},
            {"code": "2", "name": "1200"},
            {"code": "3", "name": "2400"},
            {"code": "4", "name": "4800"},
            {"code": "5", "name": "7200"},
            {"code": "6", "name": "9600"},
            {"code": "7", "name": "19200"}
    ]
});
function getNameByCode_Baudrate(value) {
    if(!Ext.isEmpty(value)) {
        return codeListStore_Baudrate.getById(value).get('name');
    }
    else {
        return '';
    }
}

// 冻结密度
var codeListStore_FreezeDensity = Ext.create('Ext.data.Store', {
    model: 'code-liststore-model',
    remoteSort: false,
    data: [ 
            {"code": "0", "name": "不冻结"},
            {"code": "1", "name": "15分钟"},
            {"code": "2", "name": "30分钟"},
            {"code": "3", "name": "60分钟"}
    ]
});
function getNameByCode_FreezeDensity(value) {
    if(!Ext.isEmpty(value)) {
        return codeListStore_FreezeDensity.getById(value).get('name');
    }
    else {
        return '';
    }
}

// 开关量属性
var codeListStore_SwitchType = Ext.create('Ext.data.Store', {
    model: 'code-liststore-model',
    remoteSort: false,
    data: [ 
            {"code": "0", "name": "常闭触点"},
            {"code": "1", "name": "常开触点"}
    ]
});
function getNameByCode_SwitchType(value) {
    if(!Ext.isEmpty(value)) {
        return codeListStore_SwitchType.getById(value).get('name');
    }
    else {
        return '';
    }
}

/**
 * 
 */
Ext.define('orgnization-liststore-model', {
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
var orgnizationListStore = Ext.create('Ext.data.Store', {
    // destroy the store if the grid is destroyed
    autoDestroy: true,
    model: 'orgnization-liststore-model',
    remoteSort: false,
    proxy: {
        // load using script tags for cross domain, if the data in on the same domain as
        // this page, an HttpProxy would be better
        type: 'ajax',
        url: ctx_webapp + '/sm/orgm!getList.do',
        timeout: 600000,
        reader: {
            type: 'json',
            root: 'list'
        }
    },
    // 
    autoLoad: true
});


/**
 * 
 */
Ext.define('tg-liststore-model', {
    extend: 'Ext.data.Model',
    fields: [
        {name: 'id', type: 'int'},                                          /* 台区ID */
        {name: 'tgNo', type: 'string'},                                     /* 台区编号 */
        {name: 'tgName', type: 'string'}                                    /* 台区名称 */
    ],
    idProperty: 'id'
});

/**
 * 
 */
Ext.define('term-liststore-model', {
    extend: 'Ext.data.Model',
    fields: [
        {name: 'id', type: 'int'},                                          /* 集中器ID */
        {name: 'assetNo', type: 'string'},                                  /* 资产编号 */
        {name: 'logicalAddr', type: 'string'}                               /* 逻辑地址 */
    ],
    idProperty: 'id'
});

/**
 * 
 */
Ext.define('meter-liststore-model', {
    extend: 'Ext.data.Model',
    fields: [
        {name: 'id', type: 'int'},                                          /* 考核表ID */
        {name: 'assetNo', type: 'string'},                                  /* 资产编号 */
        {name: 'mpName', type: 'string'},                                   /* 考核表名称 */
        {name: 'mpId', type: 'int'},                                        /* 计量点ID */
        {name: 'gpId', type: 'int'}                                         /* 测量点ID */
    ],
    idProperty: 'id'
});

/**
 * 
 */
Ext.define('ps-liststore-model', {
    extend: 'Ext.data.Model',
    fields: [
        {name: 'id', type: 'int'},                                          /* 保护器ID */
        {name: 'assetNo', type: 'string'},                                  /* 资产编号 */
        {name: 'psName', type: 'string'},                                   /* 保护器名称 */
        {name: 'gpId', type: 'int'}                                         /* 测量点ID */
    ],
    idProperty: 'id'
});

/**
 * 
 */
Ext.define('ag-liststore-model', {
    extend: 'Ext.data.Model',
    fields: [
        {name: 'analogueName', type: 'string'},                             /* 模拟量名称 */
        {name: 'gpId', type: 'int'}                                         /* 测量点ID */
    ],
    idProperty: 'id'
});


////////////////////////////////////////////////////////////////////////////////

var tgListStore = Ext.create('Ext.data.Store', {
    // destroy the store if the grid is destroyed
    autoDestroy: true,
    model: 'tg-liststore-model',
    remoteSort: false,
    proxy: {
        // load using script tags for cross domain, if the data in on the same domain as
        // this page, an HttpProxy would be better
        type: 'ajax',
        url: ctx_webapp + '/am/tam!getTgList.do',
        timeout: 600000,
        reader: {
            type: 'json',
            root: 'records'
        }
    },
    // 
    autoLoad: false
});

var tgListStoreWithAll = Ext.create('Ext.data.Store', {
    // destroy the store if the grid is destroyed
    autoDestroy: true,
    model: 'tg-liststore-model',
    remoteSort: false,
    proxy: {
        // load using script tags for cross domain, if the data in on the same domain as
        // this page, an HttpProxy would be better
        type: 'ajax',
        url: ctx_webapp + '/am/tam!getTgList.do',
        timeout: 600000,
        reader: {
            type: 'json',
            root: 'records'
        }
    },
    // 
    autoLoad: false
});


////////////////////////////////////////////////////////////////////////////////
var filterOrgnizationListStore = orgnizationListStore;