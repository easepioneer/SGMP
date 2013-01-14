Ext.define('code-liststore-model', {
    extend: 'Ext.data.Model',
    fields: [
        {name: 'code', type: 'string'},                                         /* 编码 */
        {name: 'name', type: 'string'}                                          /* 名称 */
    ],
    idProperty: 'code'
});

// 集中器规约
var codeListStore_TermProtocol = Ext.create('Ext.data.Store', {
    model: 'code-liststore-model',
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
    data: [ 
            {"code": "101", "name": "嘉兴保护器通信规约"}
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

// 产权
var codeListStore_Pr = Ext.create('Ext.data.Store', {
    model: 'code-liststore-model',
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

/**
 * 
 * @param termId
 * @returns
 */
function getLogicalAddrByTermId(termId) {
    return termId;
}


////////////////////////////////////////////////////////////////////////////////
var filterOrgnizationListStore = Ext.create('Ext.data.Store', {
    fields: ['orgId', 'orgName'],
    data: [
            {"orgId": "1", "orgName": "豪顿电气"},
            {"orgId": "2", "orgName": "豪顿电气测试部"},
            {"orgId": "3", "orgName": "豪顿电气演示部"},
            {"orgId": "4", "orgName": "福建省电力有限公司"},
            {"orgId": "5", "orgName": "福州市电力局"},
            {"orgId": "6", "orgName": "永泰县供电局"},
            {"orgId": "7", "orgName": "葛岭供电所"}
    ]
});

var filterTgListStore = Ext.create('Ext.data.Store', {
    fields: ['tgId', 'tgName'],
    data: [ 
            {"tgId": "11", "tgName": "葛岭变"},
            {"tgId": "12", "tgName": "东兴变"},
            {"tgId": "13", "tgName": "赤锡变"}
    ]
});

var filterTgListStoreWithAll = Ext.create('Ext.data.Store', {
    fields: ['tgId', 'tgName'],
    data: [ 
            {"tgId": "0", "tgName": "--- 所有台区 ---"},
            {"tgId": "11", "tgName": "葛岭变"},
            {"tgId": "12", "tgName": "东兴变"},
            {"tgId": "13", "tgName": "赤锡变"}
    ]
});

var filterTerminalListStore = Ext.create('Ext.data.Store', {
    fields: ['termId', 'logicalAddr'],
    data: [ 
            {"termId": "11", "logicalAddr": "96123456"},
            {"termId": "12", "logicalAddr": "96123457"},
            {"termId": "13", "logicalAddr": "96123458"}
    ]
});

var filterTerminalListStoreWithAll = Ext.create('Ext.data.Store', {
    fields: ['termId', 'logicalAddr'],
    data: [ 
            {"termId": "0", "logicalAddr": "--- 所有集中器 ---"},
            {"termId": "11", "logicalAddr": "96123456"},
            {"termId": "12", "logicalAddr": "96123457"},
            {"termId": "13", "logicalAddr": "96123458"}
    ]
});

var filterMeterListStore = Ext.create('Ext.data.Store', {
    fields: ['gpId', 'mpName'],
    data: []
});

var filterMeterListStoreWithAll = Ext.create('Ext.data.Store', {
    fields: ['gpId', 'mpName'],
    data: [ 
            {"gpId": "0", "mpName": "--- 所有考核表 ---"}
    ]
});

var filterProtectorListStore = Ext.create('Ext.data.Store', {
    fields: ['gpId', 'psName'],
    data: [ 
            {"gpId": "11", "psName": "葛岭变总保1"},
            {"gpId": "12", "psName": "葛岭变二级保2"},
            {"gpId": "13", "psName": "葛岭变二级保3"},
            {"gpId": "14", "psName": "葛岭变二级保4"},
            {"gpId": "15", "psName": "葛岭变二级保5"},
            {"gpId": "16", "psName": "葛岭变二级保6"},
            {"gpId": "17", "psName": "东兴变总保1"},
            {"gpId": "18", "psName": "东兴变二级保2"},
            {"gpId": "19", "psName": "东兴变二级保3"},
            {"gpId": "20", "psName": "东兴变二级保4"},
            {"gpId": "21", "psName": "东兴变二级保5"},
            {"gpId": "22", "psName": "东兴变二级保6"},
            {"gpId": "23", "psName": "赤锡变总保1"},
            {"gpId": "24", "psName": "赤锡变二级保2"},
            {"gpId": "25", "psName": "赤锡变二级保3"},
            {"gpId": "26", "psName": "赤锡变二级保4"},
            {"gpId": "27", "psName": "赤锡变二级保5"},
            {"gpId": "28", "psName": "赤锡变二级保6"}
    ]
});

var filterProtectorListStoreWithAll = Ext.create('Ext.data.Store', {
    fields: ['gpId', 'psName'],
    data: [ 
            {"gpId": "0", "psName": "--- 所有保护器 ---"},
            {"gpId": "11", "psName": "葛岭变总保1"},
            {"gpId": "12", "psName": "葛岭变二级保2"},
            {"gpId": "13", "psName": "葛岭变二级保3"},
            {"gpId": "14", "psName": "葛岭变二级保4"},
            {"gpId": "15", "psName": "葛岭变二级保5"},
            {"gpId": "16", "psName": "葛岭变二级保6"},
            {"gpId": "17", "psName": "东兴变总保1"},
            {"gpId": "18", "psName": "东兴变二级保2"},
            {"gpId": "19", "psName": "东兴变二级保3"},
            {"gpId": "20", "psName": "东兴变二级保4"},
            {"gpId": "21", "psName": "东兴变二级保5"},
            {"gpId": "22", "psName": "东兴变二级保6"},
            {"gpId": "23", "psName": "赤锡变总保1"},
            {"gpId": "24", "psName": "赤锡变二级保2"},
            {"gpId": "25", "psName": "赤锡变二级保3"},
            {"gpId": "26", "psName": "赤锡变二级保4"},
            {"gpId": "27", "psName": "赤锡变二级保5"},
            {"gpId": "28", "psName": "赤锡变二级保6"}
    ]
});