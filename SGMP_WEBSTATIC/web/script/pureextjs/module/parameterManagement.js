function initTpsFilterForm() {
    Ext.getCmp('tps-filter-formfield-org').setValue(1);
}

function initPpsFilterForm() {
    Ext.getCmp('pps-filter-formfield-org').setValue(1);
}

function initPccsFilterForm() {
    Ext.getCmp('pccs-filter-formfield-org').setValue(1);
}

function rendererProtectorControlCommand(code, value) {
    if(code == '0710') {            // 预约远程分断控制
        
    }
    else if(code == '0711') {       // 取消远程分断控制
        
    }
    else if(code == '0720') {       // 预约远程合闸控制
        
    }
    else if(code == '0721') {       // 取消远程合闸控制
        
    }
    else if(code == '0730') {       // 预约模拟试跳控制
        
    }
    else if(code == '0731') {       // 取消模拟试跳控制
        
    }
    return value;
}

var totalReceiveCount = 20;
function receiveProtectorControlCommandResult(taskId) {
    totalReceiveCount--;
    Ext.Ajax.request({
        url: ctx_webapp + '/pm/pccs!receive.do',
        params: {
            mtoType: '100',
            meterType: '100',
            type: 'protector-control',
            action: 'write',
            taskId: taskId
        },
        method: 'POST',
        success: function(response) {
            //alert(response.responseText);
            var r = response.responseText;
            if(totalReceiveCount > 0) {
                if(r == '......') {
                    setTimeout('receiveProtectorControlCommandResult(' + taskId + ')', 3000)
                }
                else if(r == '1') {
                    alert('投入成功');
                }
                else {
                    alert('投入失败');
                }
            }
            else {
                alert('超时');
            }
        },
        failure: function(response) {
            //alert(response.responseText);
        }
    });
}

function getParameterManagementFunctions() {
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////// 集中器参数设置 ////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    var tpsFilterTgListStoreWithAll = Ext.create('Ext.data.Store', {
        // destroy the store if the grid is destroyed
        autoDestroy: true,
        model: 'tg-liststore-model',
        remoteSort: false,
        proxy: {
            // load using script tags for cross domain, if the data in on the same domain as
            // this page, an HttpProxy would be better
            type: 'ajax',
            url: ctx_webapp + '/am/tam!getTgList.do',
            reader: {
                type: 'json',
                root: 'records'
            }
        },
        // 
        autoLoad: false
    });

    var tpsFilterTermListStore = Ext.create('Ext.data.Store', {
        // destroy the store if the grid is destroyed
        autoDestroy: true,
        model: 'term-liststore-model',
        remoteSort: false,
        proxy: {
            // load using script tags for cross domain, if the data in on the same domain as
            // this page, an HttpProxy would be better
            type: 'ajax',
            url: ctx_webapp + '/am/tam!getTermList.do',
            reader: {
                type: 'json',
                root: 'records'
            }
        },
        // 
        autoLoad: false
    });

    // 集中器信息表单
    var tps_filter_formpanel = Ext.create('Ext.form.Panel', {
        id: 'tps-filter-form',
        region: 'north',
        title: '集中器信息',
        frame: true,
        margins: '5 5 5 5',
        bodyStyle: 'padding: 5px 5px 0 5px;',
        split: false,
        items: [{
            xtype: 'container',
            anchor: '100%',
            layout: 'hbox',
            items: [{
                xtype: 'container',
                layout: 'anchor',
                flex: 1,
                width: 240,
                items: [{
                    xtype: 'combobox',
                    id: 'tps-filter-formfield-org',
                    name: 'soOrgId',
                    fieldLabel: '所属机构',
                    labelWidth: 60,
                    allowBlank: false,
                    store: filterOrgnizationListStore,
                    valueField: 'id',
                    displayField: 'orgName',
                    emptyText: '请选择所属机构...',
                    queryMode: 'local',
                    forceSelection : true,
                    triggerAction : 'all',
                    editable: false,
                    listeners: {
                        change: function(combo, newValue, oldValue, eOpts) {
                            //alert("soOrgId : " + newValue);
                            if(!Ext.isEmpty(newValue)) {
                                Ext.getCmp('tps-filter-formfield-tg').reset();
                                Ext.getCmp('tps-filter-formfield-tg').getStore().removeAll();
                                Ext.getCmp('tps-filter-formfield-tg').getStore().load({
                                    params: {orgId: newValue, withAll: true},
                                    callback: function(records, operation, success) {
                                        Ext.getCmp('tps-filter-formfield-tg').setValue(0);
                                    },
                                    scope: this
                                });
                            }
                        }
                    }
                }]
            }, {
                xtype: 'container',
                layout: 'anchor',
                flex: 1,
                width: 240,
                items: [{
                    xtype: 'combobox',
                    id: 'tps-filter-formfield-tg',
                    name: 'soTgId',
                    fieldLabel: '台区名称',
                    labelWidth: 60,
                    allowBlank: false,
                    store: tpsFilterTgListStoreWithAll,
                    valueField: 'id',
                    displayField: 'tgName',
                    emptyText: '请选择台区...',
                    queryMode: 'local',
                    forceSelection : true,
                    triggerAction : 'all',
                    editable: false,
                    value: '0',
                    listeners: {
                        change: function(combo, newValue, oldValue, eOpts) {
                            //alert("soTgId : " + newValue);
                            if(!Ext.isEmpty(newValue)) {
                                Ext.getCmp('tps-filter-formfield-term').reset();
                                Ext.getCmp('tps-filter-formfield-term').getStore().removeAll();
                                Ext.getCmp('tps-filter-formfield-term').getStore().load({
                                    params: {orgId: Ext.getCmp('tps-filter-formfield-org').getValue(), tgId: newValue, withAll: false},
                                    callback: function(records, operation, success) {
                                        //Ext.getCmp('tps-filter-formfield-term').setValue(null);
                                    },
                                    scope: this
                                });
                            }
                        }
                    }
                }]
            }, {
                xtype: 'container',
                layout: 'anchor',
                flex: 1,
                width: 240,
                items: [{
                    xtype: 'combobox',
                    id: 'tps-filter-formfield-term',
                    name: 'soTermId',
                    fieldLabel: '集 中 器',
                    labelWidth: 60,
                    allowBlank: false,
                    store: tpsFilterTermListStore,
                    emptyText: '请选择集中器...',
                    valueField: 'id',
                    displayField: 'logicalAddr',
                    queryMode: 'local',
                    forceSelection : true,
                    triggerAction : 'all',
                    editable: false,
                    listeners: {
                        change: function(combo, newValue, oldValue, eOpts) {
                            //alert("soTermId : " + newValue);
                            if(!Ext.isEmpty(newValue) && newValue > 0) {
                                //alert("加载集中器：" + newValue);
                                Ext.Ajax.request({
                                    url: ctx_webapp + '/pm/tps!loadTermParamsValuesByTermId.do',
                                    params: {
                                        termId: newValue
                                    },
                                    method: 'POST',
                                    timeout: 30000,
                                    success: function(response){
                                        //alert(response.responseText);
                                        var result = Ext.JSON.decode(response.responseText);
                                        if(Ext.isObject(result)) {
                                            //alert("isObject");
                                            var records = result.records;
                                            //alert(records);
                                            if(Ext.isArray(records)) {
                                                //alert("isArray");
                                                for(var i = 0; i < records.length; i++) {
                                                    var code = records[i].P_CODE;
                                                    var value = records[i].P_VALUE;
                                                    alert(code + " : " + value);
                                                    tps_termparam_gridstore.getById(code).set("P_VALUE", value);
                                                }
                                            }
                                            else {
                                                //alert("notArray");
                                            }
                                        }
                                        else {
                                            //alert("notObject");
                                        }
                                        // process server response here
                                    }
                                });
                            }
                        }
                    }
                }]
            }]
        }]/*,
        buttonAlign: 'center',
        buttons: [{
            text: '查询',
            handler: function() {
                
            }
        }]*/
    });
    // 集中器参数列表数据源
    Ext.define('tps-termparam-gridstore-model', {
        extend: 'Ext.data.Model',
        fields: [
            {name: 'SN', type: 'int'},                          /* 序号 */
            {name: 'P_CODE', type: 'string'},                   /* 参数编码 */
            {name: 'P_NAME', type: 'string'},                   /* 参数名称 */
            {name: 'P_VALUE', type: 'string'},                  /* 参数值 */
            {name: 'OP_RESULT', type: 'string'}                 /* 操作结果 */
        ],
        idProperty: 'P_CODE'
    });
    var tps_termparam_gridstore = Ext.create('Ext.data.Store', {
        // destroy the store if the grid is destroyed
        autoDestroy: true,
        model: 'tps-termparam-gridstore-model',
        proxy: {
            // load using script tags for cross domain, if the data in on the same domain as
            // this page, an HttpProxy would be better
            type: 'ajax',
            url: ctx_webstatic + '/customized/project/hd/data/tps-termparam-grid-data.json',
            reader: {
                type: 'json',
                root: 'records'
            },
            // sends single sort as multi parameter
            simpleSortMode: true
        },
        /*sorters: [{
            property: 'P_CODE',
            direction: 'ACS'
        }],*/
        // 
        autoLoad: true
    });
    // 集中器参数列表
    var tps_termparam_grid_selections = '';
    var tps_termparam_grid_selmodel = Ext.create('Ext.selection.CheckboxModel', {
        checkOnly: true,
        mode: 'SINGLE',
        showHeaderCheckbox: false,
        listeners: {
            selectionchange: function(sm, selections) {
                tps_termparam_gridpanel.down('#tps-termparam-setting-button').setDisabled(selections.length == 0);
                tps_termparam_gridpanel.down('#tps-termparam-reading-button').setDisabled(selections.length == 0);
                tps_termparam_grid_selections = selections;
            }
        }
    });
    var tps_termparam_gridpanel = Ext.create('Ext.grid.Panel', {
        id: 'tps-termparam-grid',
        title: '集中器参数',
        xtype: 'grid',
        layout: 'fit',
        store: tps_termparam_gridstore,
        loadMask: true,
        columns: [
            {text: "序号", dataIndex: 'SN', width: 50, sortable: true},
            {text: "参数编码", dataIndex: 'P_CODE', width: 80, sortable: true},
            {text: "参数名称", dataIndex: 'P_NAME', width: 200, sortable: true},
            {text: "参数值", dataIndex: 'P_VALUE', width: 320, sortable: true},
            {text: "操作结果", dataIndex: 'OP_RESULT', flex: 1, sortable: true}
        ],
        columnLines: true,
        selModel: tps_termparam_grid_selmodel,
        // inline buttons
        dockedItems: [{
            xtype: 'toolbar',
            dock: 'top',
            items: [{
                itemId: 'tps-termparam-setting-button',
                text: '设置',
                tooltip: '设置集中器参数',
                iconCls: 'setting',
                disabled: true,
                handler: function() {
                    //alert('设置集中器参数');
                    var termId = Ext.getCmp('tps-filter-formfield-term').getValue();
                    if(Ext.isEmpty(termId)) {
                        Ext.MessageBox.alert('提示', '请选择要设置的集中器', function(btn) {
                            return;
                        });
                    }
                    else {
                        var records = tps_termparam_grid_selections;
                        if(typeof(records) == "undefined" || records.length == 0) {
                            Ext.MessageBox.alert('提示', '请选择要设置的参数项', function(btn) {
                                return;
                            });
                        }
                        else {
                            var paramsAndValues = '';
                            for(var i = 0; i < records.length; i++) {
                                paramsAndValues += records[i].get("P_CODE") + ':' + records[i].get("P_VALUE") + ';';
                            }
                            var params = {
                                    type: 'terminal-parameter',
                                    action: 'write',
                                    paramsAndValues: paramsAndValues
                            };
                            Ext.apply(params, tps_filter_formpanel.getForm().getValues(false));
                            alert(Ext.JSON.encode(params))
                            Ext.Ajax.request({
                                url: ctx_webapp + '/pm/tps!send.do',
                                params: params,
                                method: 'POST',
                                success: function(response) {
                                    //alert(response.responseText);
                                    // 
                                    Ext.Ajax.request({
                                        url: ctx_webapp + '/pm/tps!receive.do',
                                        params: {
                                            type: 'terminal-parameter',
                                            action: 'write',
                                            taskId: response.responseText
                                        },
                                        method: 'POST',
                                        success: function(response) {
                                            //alert(response.responseText);
                                        },
                                        failure: function(response) {
                                            //alert(response.responseText);
                                        }
                                    });
                                },
                                failure: function(response) {
                                    //alert(response.responseText);
                                }
                            });
                            //alert(paramsAndValues);
                            /*Ext.MessageBox.show({
                                title: '正在等待',
                                msg: 'Loading items...',
                                progressText: 'Initializing...',
                                width:300,
                                progress:true,
                                closable:false,
                                animateTarget: 'mb6'
                            });

                            // this hideous block creates the bogus progress
                            var f = function(v){
                                 return function(){
                                     if(v == 12){
                                         Ext.MessageBox.hide();
                                         Ext.example.msg('Done', 'Your fake items were loaded!');
                                     }else{
                                         var i = v/11;
                                         Ext.MessageBox.updateProgress(i, Math.round(100*i)+'% completed');
                                     }
                                };
                            };
                            for(var i = 1; i < 13; i++){
                                setTimeout(f(i), i*500);
                            }*/
                        }
                    }
                }
            }, '-', {
                itemId: 'tps-termparam-reading-button',
                text: '读取',
                tooltip: '读取集中器参数',
                iconCls: 'reading',
                disabled: true,
                handler: function() {
                    //alert('读取集中器参数');
                    var records = tps_termparam_grid_selections;
                    if(typeof(records) == "undefined" || records.length == 0) {
                        Ext.MessageBox.alert('提示', '请选择要设置的参数项', function(btn) {
                            return;
                        });
                    }
                    else {
                        var paramsAndValues = '';
                        for(var i = 0; i < records.length; i++) {
                            paramsAndValues += records[i].get("P_CODE") + ":" + ';';
                        }
                        var params = {
                                mtoType: '100',
                                meterType: '100',
                                type: 'terminal-parameter',
                                action: 'read',
                                paramsAndValues: paramsAndValues
                        };
                        Ext.apply(params, tps_filter_formpanel.getForm().getValues(false));
                        Ext.Ajax.request({
                            url: ctx_webapp + '/pm/tps!send.do',
                            params: params,
                            method: 'POST',
                            success: function(response) {
                                //alert(response.responseText);
                                // 
                                Ext.Ajax.request({
                                    url: ctx_webapp + '/pm/tps!receive.do',
                                    params: {
                                        mtoType: '100',
                                        meterType: '100',
                                        type: 'terminal-parameter',
                                        action: 'read',
                                        taskId: response.responseText
                                    },
                                    method: 'POST',
                                    success: function(response) {
                                        //alert(response.responseText);
                                    },
                                    failure: function(response) {
                                        //alert(response.responseText);
                                    }
                                });
                            },
                            failure: function(response) {
                                //alert(response.responseText);
                            }
                        });
                        //alert(paramsAndValues);
                        /*Ext.MessageBox.show({
                            title: '正在等待',
                            msg: 'Loading items...',
                            progressText: 'Initializing...',
                            width:300,
                            progress:true,
                            closable:false,
                            animateTarget: 'mb6'
                        });

                        // this hideous block creates the bogus progress
                        var f = function(v) {
                             return function() {
                                 if(v == 12) {
                                     Ext.MessageBox.hide();
                                     Ext.example.msg('Done', 'Your fake items were loaded!');
                                 }
                                 else {
                                     var i = v/11;
                                     Ext.MessageBox.updateProgress(i, Math.round(100*i)+'% completed');
                                 }
                            };
                        };
                        for(var i = 1; i < 13; i++) {
                            setTimeout(f(i), i*500);
                        }*/
                    }
                }
            }]
        }]
    });
    // 测量点参数列表数据源
    Ext.define('tps-gpparam-gridstore-model', {
        extend: 'Ext.data.Model',
        fields: [
            {name: 'SN', type: 'int'},                          /* 序号 */
            {name: 'P_CODE', type: 'string'},                   /* 参数编码 */
            {name: 'P_NAME', type: 'string'},                   /* 参数名称 */
            {name: 'P_VALUE', type: 'string'},                  /* 参数值 */
            {name: 'OP_RESULT', type: 'string'}                 /* 操作结果 */
        ],
        idProperty: 'P_CODE'
    });
    var tps_gpparam_gridstore = Ext.create('Ext.data.Store', {
        // destroy the store if the grid is destroyed
        autoDestroy: true,
        model: 'tps-gpparam-gridstore-model',
        proxy: {
            // load using script tags for cross domain, if the data in on the same domain as
            // this page, an HttpProxy would be better
            type: 'ajax',
            url: ctx_webstatic + '/customized/project/hd/data/tps-gpparam-grid-data.json',
            reader: {
                type: 'json',
                root: 'records'
            },
            method: 'POST',
            // sends single sort as multi parameter
            simpleSortMode: true
        }/*,
        sorters: [{
            property: 'P_CODE',
            direction: 'ACS'
        }]*/,
        autoLoad: true
    });
    // 测量点参数列表
    var tps_gpparam_grid_selections = '';
    var tps_gpparam_grid_selmodel = Ext.create('Ext.selection.CheckboxModel', {
        listeners: {
            selectionchange: function(sm, selections) {
                tps_gpparam_gridpanel.down('#tps-gpparam-setting-button').setDisabled(selections.length == 0);
                tps_gpparam_gridpanel.down('#tps-gpparam-reading-button').setDisabled(selections.length == 0);
                tps_gpparam_grid_selections = selections;
            }
        }
    });
    var tps_gpparam_gridpanel = Ext.create('Ext.grid.Panel', {
        id: 'tps-gpparam-grid',
        title: '测量点参数',
        xtype: 'grid',
        layout: 'fit',
        store: tps_gpparam_gridstore,
        loadMask: true,
        columns: [
            {text: "序号", dataIndex: 'SN', width: 50, sortable: true},
            {text: "参数编码", dataIndex: 'P_CODE', width: 80, sortable: true},
            {text: "参数名称", dataIndex: 'P_NAME', width: 200, sortable: true},
            {text: "参数值", dataIndex: 'P_VALUE', width: 320, sortable: true},
            {text: "操作结果", dataIndex: 'OP_RESULT', flex: 1, sortable: true}
        ],
        columnLines: true,
        selModel: tps_gpparam_grid_selmodel,
        // inline buttons
        dockedItems: [{
            xtype: 'toolbar',
            dock: 'top',
            items: [{
                itemId: 'tps-gpparam-setting-button',
                text: '设置',
                tooltip: '设置测量点参数',
                iconCls: 'setting',
                disabled: true,
                handler: function() {
                    //alert('设置测量点参数');
                }
            }, '-', {
                itemId: 'tps-gpparam-reading-button',
                text: '读取',
                tooltip: '读取测量点参数',
                iconCls: 'reading',
                disabled: true,
                handler: function() {
                    //alert('读取测量点参数');
                }
            }, '->', {
                xtype: 'combobox',
                name: 'gpsn',
                fieldLabel: '测量点',
                store: Ext.create('Ext.data.Store', {
                    fields: ['value', 'label'],
                    data: [
                        {"value": 1, "label": "测量点 1"},
                        {"value": 2, "label": "测量点 2"},
                        {"value": 3, "label": "测量点 3"},
                        {"value": 4, "label": "测量点 4"},
                        {"value": 5, "label": "测量点 5"},
                        {"value": 6, "label": "测量点 6"},
                        {"value": 7, "label": "测量点 7"},
                        {"value": 8, "label": "测量点 8"},
                        {"value": 9, "label": "测量点 9"},
                        {"value": 10, "label": "测量点 10"},
                        {"value": 11, "label": "测量点 11"},
                        {"value": 12, "label": "测量点 12"},
                        {"value": 13, "label": "测量点 13"},
                        {"value": 14, "label": "测量点 14"},
                        {"value": 15, "label": "测量点 15"},
                        {"value": 16, "label": "测量点 16"}
                    ]
                }),
                valueField: 'value',
                displayField: 'label',
                queryMode: 'local',
                forceSelection : true,
                triggerAction : 'all',
                editable: false,
                labelWidth: 50,
                width: 130,
                minWidth: 130,
                maxWidth: 130,
                value: 1,
                listeners: {
                    change: function(combo, newValue, oldValue, eOpts) {
                        //alert(newValue);
                    }
                }
            }]
        }]
    });

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////// 保护器参数设置 ////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    var ppsFilterTgListStoreWithAll = Ext.create('Ext.data.Store', {
        // destroy the store if the grid is destroyed
        autoDestroy: true,
        model: 'tg-liststore-model',
        remoteSort: false,
        proxy: {
            // load using script tags for cross domain, if the data in on the same domain as
            // this page, an HttpProxy would be better
            type: 'ajax',
            url: ctx_webapp + '/am/tam!getTgList.do',
            reader: {
                type: 'json',
                root: 'records'
            }
        },
        // 
        autoLoad: false
    });

    var ppsFilterPsListStoreWithAll = Ext.create('Ext.data.Store', {
        // destroy the store if the grid is destroyed
        autoDestroy: true,
        model: 'ps-liststore-model',
        remoteSort: false,
        proxy: {
            // load using script tags for cross domain, if the data in on the same domain as
            // this page, an HttpProxy would be better
            type: 'ajax',
            url: ctx_webapp + '/am/tam!getPsList.do',
            reader: {
                type: 'json',
                root: 'records'
            }
        },
        // 
        autoLoad: false
    });

    // 保护器信息表单
    var pps_filter_formpanel = Ext.create('Ext.form.Panel', {
        id: 'pps-filter-form',
        region: 'north',
        title: '保护器信息',
        frame: true,
        margins: '5 5 5 5',
        bodyStyle: 'padding: 5px 5px 0 5px;',
        split: false,
        items: [{
            xtype: 'container',
            anchor: '100%',
            layout: 'hbox',
            items: [{
                xtype: 'container',
                layout: 'anchor',
                flex: 1,
                width: 240,
                items: [{
                    xtype: 'combobox',
                    id: 'pps-filter-formfield-org',
                    name: 'soOrgId',
                    fieldLabel: '所属机构',
                    labelWidth: 60,
                    allowBlank: false,
                    store: filterOrgnizationListStore,
                    valueField: 'id',
                    displayField: 'orgName',
                    emptyText: '请选择所属机构...',
                    queryMode: 'local',
                    forceSelection : true,
                    triggerAction : 'all',
                    editable: false,
                    listeners: {
                        change: function(combo, newValue, oldValue, eOpts) {
                            //alert("soOrgId : " + newValue);
                            if(!Ext.isEmpty(newValue)) {
                                Ext.getCmp('pps-filter-formfield-tg').reset();
                                Ext.getCmp('pps-filter-formfield-tg').getStore().removeAll();
                                Ext.getCmp('pps-filter-formfield-tg').getStore().load({
                                    params: {orgId: newValue, withAll: true},
                                    callback: function(records, operation, success) {
                                        Ext.getCmp('pps-filter-formfield-tg').setValue(0);
                                    },
                                    scope: this
                                });
                            }
                        }
                    }
                }]
            }, {
                xtype: 'container',
                layout: 'anchor',
                flex: 1,
                width: 240,
                items: [{
                    xtype: 'combobox',
                    id: 'pps-filter-formfield-tg',
                    name: 'soTgId',
                    fieldLabel: '台区名称',
                    labelWidth: 60,
                    allowBlank: false,
                    store: ppsFilterTgListStoreWithAll,
                    valueField: 'id',
                    displayField: 'tgName',
                    queryMode: 'local',
                    emptyText: '请选择台区...',
                    forceSelection : true,
                    triggerAction : 'all',
                    editable: false,
                    value: '0',
                    listeners: {
                        change: function(combo, newValue, oldValue, eOpts) {
                            //alert("soTgId : " + newValue);
                            if(!Ext.isEmpty(newValue)) {
                                Ext.getCmp('pps-filter-formfield-ps').reset();
                                Ext.getCmp('pps-filter-formfield-ps').getStore().removeAll();
                                Ext.getCmp('pps-filter-formfield-ps').getStore().load({
                                    params: {orgId: Ext.getCmp('pps-filter-formfield-org').getValue(), tgId: newValue, withAll: true},
                                    callback: function(records, operation, success) {
                                        Ext.getCmp('pps-filter-formfield-ps').setValue(0);
                                    },
                                    scope: this
                                });
                            }
                        }
                    }
                }]
            }, {
                xtype: 'container',
                layout: 'anchor',
                flex: 1,
                width: 240,
                items: [{
                    xtype: 'combobox',
                    id: 'pps-filter-formfield-ps',
                    name: 'soGpId',
                    fieldLabel: '保护器名称',
                    labelWidth: 66,
                    allowBlank: false,
                    store: ppsFilterPsListStoreWithAll,
                    valueField: 'gpId',
                    displayField: 'psName',
                    emptyText: '请选择保护器...',
                    queryMode: 'local',
                    forceSelection : true,
                    triggerAction : 'all',
                    editable: false,
                    listeners: {
                        change: function(combo, newValue, oldValue, eOpts) {
                            //alert("soGpId : " + newValue);
                        }
                    }
                }]
            }]
        }]/*,
        buttonAlign: 'center',
        buttons: [{
            text: '查询',
            handler: function() {
                
            }
        }]*/
    });
    //
    var pps_param_gridpanel = {
        title: '保护器参数',
        html: '<p>保护器参数</p>'
    };

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////// 保护器控制命令下发 //////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    var pccsFilterTgListStoreWithAll = Ext.create('Ext.data.Store', {
        // destroy the store if the grid is destroyed
        autoDestroy: true,
        model: 'tg-liststore-model',
        remoteSort: false,
        proxy: {
            // load using script tags for cross domain, if the data in on the same domain as
            // this page, an HttpProxy would be better
            type: 'ajax',
            url: ctx_webapp + '/am/tam!getTgList.do',
            reader: {
                type: 'json',
                root: 'records'
            }
        },
        // 
        autoLoad: false
    });

    var pccsFilterPsListStoreWithAll = Ext.create('Ext.data.Store', {
        // destroy the store if the grid is destroyed
        autoDestroy: true,
        model: 'ps-liststore-model',
        remoteSort: false,
        proxy: {
            // load using script tags for cross domain, if the data in on the same domain as
            // this page, an HttpProxy would be better
            type: 'ajax',
            url: ctx_webapp + '/am/tam!getPsList.do',
            reader: {
                type: 'json',
                root: 'records'
            }
        },
        // 
        autoLoad: false
    });

    // 保护器信息表单
    var pccs_filter_formpanel = Ext.create('Ext.form.Panel', {
        id: 'pccs-filter-form',
        region: 'north',
        title: '保护器信息',
        frame: true,
        margins: '5 5 5 5',
        bodyStyle: 'padding: 5px 5px 0 5px;',
        split: false,
        items: [{
            xtype: 'container',
            anchor: '100%',
            layout: 'hbox',
            items: [{
                xtype: 'container',
                layout: 'anchor',
                flex: 1,
                width: 240,
                items: [{
                    xtype: 'combobox',
                    id: 'pccs-filter-formfield-org',
                    name: 'soOrgId',
                    fieldLabel: '所属机构',
                    labelWidth: 60,
                    allowBlank: false,
                    store: filterOrgnizationListStore,
                    valueField: 'id',
                    displayField: 'orgName',
                    emptyText: '请选择所属机构...',
                    queryMode: 'local',
                    forceSelection : true,
                    triggerAction : 'all',
                    editable: false,
                    listeners: {
                        change: function(combo, newValue, oldValue, eOpts) {
                            //alert("soOrgId : " + newValue);
                            if(!Ext.isEmpty(newValue)) {
                                Ext.getCmp('pccs-filter-formfield-tg').reset();
                                Ext.getCmp('pccs-filter-formfield-tg').getStore().removeAll();
                                Ext.getCmp('pccs-filter-formfield-tg').getStore().load({
                                    params: {orgId: newValue, withAll: true},
                                    callback: function(records, operation, success) {
                                        Ext.getCmp('pccs-filter-formfield-tg').setValue(0);
                                    },
                                    scope: this
                                });
                            }
                        }
                    }
                }]
            }, {
                xtype: 'container',
                layout: 'anchor',
                flex: 1,
                width: 240,
                items: [{
                    xtype: 'combobox',
                    id: 'pccs-filter-formfield-tg',
                    name: 'soTgId',
                    fieldLabel: '台区名称',
                    labelWidth: 60,
                    allowBlank: false,
                    store: pccsFilterTgListStoreWithAll,
                    valueField: 'id',
                    displayField: 'tgName',
                    emptyText: '请选择台区...',
                    queryMode: 'local',
                    forceSelection : true,
                    triggerAction : 'all',
                    editable: false,
                    value: '0',
                    listeners: {
                        change: function(combo, newValue, oldValue, eOpts) {
                            //alert("soTgId : " + newValue);
                            if(!Ext.isEmpty(newValue)) {
                                Ext.getCmp('pccs-filter-formfield-ps').reset();
                                Ext.getCmp('pccs-filter-formfield-ps').getStore().removeAll();
                                Ext.getCmp('pccs-filter-formfield-ps').getStore().load({
                                    params: {orgId: Ext.getCmp('pccs-filter-formfield-org').getValue(), tgId: newValue, withAll: true},
                                    callback: function(records, operation, success) {
                                        Ext.getCmp('pccs-filter-formfield-ps').setValue(0);
                                    },
                                    scope: this
                                });
                            }
                        }
                    }
                }]
            }, {
                xtype: 'container',
                layout: 'anchor',
                flex: 1,
                width: 240,
                items: [{
                    xtype: 'combobox',
                    id: 'pccs-filter-formfield-ps',
                    name: 'soGpId',
                    fieldLabel: '保护器名称',
                    labelWidth: 66,
                    allowBlank: false,
                    store: pccsFilterPsListStoreWithAll,
                    valueField: 'gpId',
                    displayField: 'psName',
                    emptyText: '请选择保护器...',
                    queryMode: 'local',
                    forceSelection : true,
                    triggerAction : 'all',
                    editable: false,
                    value: '0',
                    listeners: {
                        change: function(combo, newValue, oldValue, eOpts) {
                            //alert("soGpId : " + newValue);
                        }
                    }
                }]
            }]
        }]/*,
        buttonAlign: 'center',
        buttons: [{
            text: '查询',
            handler: function() {
                
            }
        }]*/
    });
    // 保护器控制命令列表数据源
    Ext.define('pccs-control-gridstore-model', {
        extend: 'Ext.data.Model',
        fields: [
            {name: 'SN', type: 'int'},                          /* 序号 */
            {name: 'P_CODE', type: 'string'},                   /* 控制命令编码 */
            {name: 'P_NAME', type: 'string'},                   /* 控制命令名称 */
            {name: 'P_VALUE', type: 'string'},                  /* 控制命令参数值 */
            {name: 'OP_RESULT', type: 'string'}                 /* 操作结果 */
        ],
        idProperty: 'P_CODE'
    });
    var pccs_control_gridstore = Ext.create('Ext.data.Store', {
        // destroy the store if the grid is destroyed
        //autoDestroy: true,
        model: 'pccs-control-gridstore-model',
        //remoteSort: true,
        proxy: {
            // load using script tags for cross domain, if the data in on the same domain as
            // this page, an HttpProxy would be better
            type: 'ajax',
            url: ctx_webstatic + '/customized/project/hd/data/pccs-control-grid-data.json',
            reader: {
                type: 'json',
                root: 'records',
                totalProperty: 'count'
            },
            // sends single sort as multi parameter
            simpleSortMode: true
        },
        /*sorters: [{
            property: 'P_CODE',
            direction: 'ACS'
        }],*/
        // 
        autoLoad: true
    });
    // 保护器控制命令列表
    var pccs_control_grid_selections = '';
    var pccs_control_grid_selmodel = Ext.create('Ext.selection.CheckboxModel', {
        checkOnly: true,
        mode: 'SINGLE',
        showHeaderCheckbox: false,
        listeners: {
            selectionchange: function(sm, selections) {
                //alert(selections.length);
                pccs_control_gridpanel.down('#pccs-control-setting-button').setDisabled(selections.length == 0);
                pccs_control_grid_selections = selections;
            }
        }
    });
    var tplPValue = new Ext.XTemplate(
        rendererProtectorControlCommand('{P_CODE}', '{P_VALUE}')
    );
    var pccs_control_gridpanel = Ext.create('Ext.grid.Panel', {
        id: 'pccs-control-grid',
        title: '保护器控制命令',
        xtype: 'grid',
        layout: 'fit',
        store: pccs_control_gridstore,
        loadMask: true,
        columns: [
            {text: "序号", dataIndex: 'SN', width: 50, sortable: false},
            {text: "控制命令编码", dataIndex: 'P_CODE', width: 160, sortable: true},
            {text: "控制命令名称", dataIndex: 'P_NAME', width: 200, sortable: true},
            {text: "控制命令参数值", dataIndex: 'P_VALUE', width: 240, sortable: true, xtype: 'templatecolumn', tpl: tplPValue},
            {text: "操作结果", dataIndex: 'OP_RESULT', flex: 1, sortable: true}
        ],
        columnLines: true,
        selModel: pccs_control_grid_selmodel,
        // inline buttons
        dockedItems: [{
            xtype: 'toolbar',
            dock: 'top',
            items: [{
                itemId: 'pccs-control-setting-button',
                text: '投入',
                tooltip: '投入保护器控制命令',
                iconCls: 'setting',
                disabled: true,
                handler: function() {
                    //alert('投入保护器控制命令');
                    var records = pccs_control_grid_selections;
                    //alert(records.length);
                    if(typeof(records) == "undefined" || records.length == 0) {
                        Ext.MessageBox.alert('提示', '请选择要投入的控制命令', function(btn) {
                            return;
                        });
                    }
                    else {
                        var paramsAndValues = '';
                        for(var i = 0; i < records.length; i++) {
                            paramsAndValues += records[i].get("P_CODE") + ':' + records[i].get("P_VALUE") + ';';
                        }
                        var params = {
                                mtoType: '100',
                                meterType: '100',
                                type: 'protector-control',
                                action: 'write',
                                paramsAndValues: paramsAndValues
                        };
                        Ext.apply(params, pccs_filter_formpanel.getForm().getValues(false));
                        Ext.Ajax.request({
                            url: ctx_webapp + '/pm/pccs!send.do',
                            params: params,
                            method: 'POST',
                            success: function(response) {
                                //alert(response.responseText);
                                // 
                                totalReceiveCount = 10;
                                setTimeout('receiveProtectorControlCommandResult(' + response.responseText + ')', 3000)
                            },
                            failure: function(response) {
                                //alert(response.responseText);
                            }
                        });
                        /*Ext.MessageBox.show({
                            title: '正在等待',
                            msg: 'Loading items...',
                            progressText: 'Initializing...',
                            width:300,
                            progress:true,
                            closable:false,
                            animateTarget: 'mb6'
                        });

                        // this hideous block creates the bogus progress
                        var f = function(v){
                             return function(){
                                 if(v == 12){
                                     Ext.MessageBox.hide();
                                     Ext.example.msg('Done', 'Your fake items were loaded!');
                                 }else{
                                     var i = v/11;
                                     Ext.MessageBox.updateProgress(i, Math.round(100*i)+'% completed');
                                 }
                            };
                        };
                        for(var i = 1; i < 13; i++){
                            setTimeout(f(i), i*500);
                        }*/
                    }
                }
            }]
        }]
    });

    return {
        /*
         * ==================== |集中器参数设置| ====================
         */
        actionTerminalParameterSetup: {
            xtype: 'tabpanel',
            id: 'actionTerminalParameterSetupContentPanel',
            activeTab: 0,
            defaults: {bodyStyle: 'padding: 0'},
            items: [{
                title: '集中器参数设置',
                layout: 'border',
                items: [tps_filter_formpanel, {
                    xtype: 'tabpanel',
                    plain: true,
                    region: 'center',
                    margins: '0 5 5 5',
                    activeTab: 0,
                    items: [tps_termparam_gridpanel, tps_gpparam_gridpanel]
                }]
            }]
        },

        /*
         * ================  保护器参数设置  =======================
         */
        actionProtectorParameterSetup: {
            xtype: 'tabpanel',
            id: 'actionProtectorParameterSetupContentPanel',
            activeTab: 0,
            defaults: {bodyStyle: 'padding: 0'},
            items: [{
                title: '保护器参数设置',
                layout: 'border',
                items: [pps_filter_formpanel, {
                    xtype: 'tabpanel',
                    plain: true,
                    region: 'center',
                    margins: '0 5 5 5',
                    activeTab: 0,
                    items: [pps_param_gridpanel]
                }]
            }]
        },

        /*
         * ================  保护器控制命令下发  =======================
         */
        actionProtectorControlCommandSending: {
            xtype: 'tabpanel',
            id: 'actionProtectorControlCommandSendingContentPanel',
            activeTab: 0,
            defaults: {bodyStyle: 'padding: 0'},
            items: [{
                title: '保护器控制命令下发',
                layout: 'border',
                items: [pccs_filter_formpanel, {
                    xtype: 'tabpanel',
                    plain: true,
                    region: 'center',
                    margins: '0 5 5 5',
                    activeTab: 0,
                    items: [pccs_control_gridpanel]
                }]
            }]
        }
    };
}