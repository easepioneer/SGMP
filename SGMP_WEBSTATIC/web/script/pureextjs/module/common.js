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
            {"tgId": "13", "tgName": "台区三（96123458）"}
    ]
});

var filterTgListStoreWithAll = Ext.create('Ext.data.Store', {
    fields: ['tgId', 'tgName'],
    data: [ 
            {"tgId": "0", "tgName": "--- 所有台区 ---"},
            {"tgId": "11", "tgName": "葛岭变"},
            {"tgId": "12", "tgName": "东兴变"},
            {"tgId": "13", "tgName": "台区三（96123458）"}
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
            {"gpId": "23", "psName": "台区三总保1"},
            {"gpId": "24", "psName": "台区三二级保2"},
            {"gpId": "25", "psName": "台区三二级保3"},
            {"gpId": "26", "psName": "台区三二级保4"},
            {"gpId": "27", "psName": "台区三二级保5"},
            {"gpId": "28", "psName": "台区三二级保6"}
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
            {"gpId": "23", "psName": "台区三总保1"},
            {"gpId": "24", "psName": "台区三二级保2"},
            {"gpId": "25", "psName": "台区三二级保3"},
            {"gpId": "26", "psName": "台区三二级保4"},
            {"gpId": "27", "psName": "台区三二级保5"},
            {"gpId": "28", "psName": "台区三二级保6"}
    ]
});