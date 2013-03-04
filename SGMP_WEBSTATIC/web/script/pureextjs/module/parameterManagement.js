var tps_termparam_grid_selections;
var tps_termparam_grid_selmodel;
var tps_termparam_gridstore;
var tps_gpparam_grid_selections;
var tps_gpparam_grid_selmodel;
var tps_gpparam_gridstore;
var tps_agparam_grid_selections;
var tps_agparam_grid_selmodel;
var tps_agparam_gridstore;
var pps_param_grid_selections;
var pps_param_grid_selmodel;
var pps_param_gridstore;
var pccs_control_grid_selections;
var pccs_control_grid_selmodel;
var pccs_control_gridstore;

function initTpsFilterForm() {
    Ext.getCmp('tps-filter-formfield-org').setValue(1);
}

function initPpsFilterForm() {
    Ext.getCmp('pps-filter-formfield-org').setValue(1);
}

function initPccsFilterForm() {
    Ext.getCmp('pccs-filter-formfield-org').setValue(1);
}

var totalReceiveCount = 20;

function receiveTerminalParameterSetupResult(type, action, taskId) {
    totalReceiveCount--;
    Ext.Ajax.request({
        url: ctx_webapp + '/pm/tps!receive.do',
        params: {
            type: type,
            action: action,
            taskId: taskId
        },
        method: 'POST',
        success: function(response) {
            var r = response.responseText;
            if(totalReceiveCount > 0) {
                if(r == '......') {
                    setTimeout("receiveTerminalParameterSetupResult('" + type + "','" + action + "'," + taskId + ")", 3000);
                }
                else {
                    Ext.MessageBox.hide();
                    var o = Ext.JSON.decode(r);
                    if(Ext.isObject(o)) {
                        var code = o.P_CODE;
                        var result = o.OP_RESULT;
                        if(action == 'write') {
                            if(result == '1') {
                                result = '设置成功';
                            }
                            else {
                                result = '设置失败';
                            }
                        }
                        if(type == 'terminal-parameter' && tps_termparam_gridstore) {
                            if(tps_termparam_grid_selmodel) {
                                tps_termparam_grid_selmodel.deselectAll(true);
                            }
                            tps_termparam_gridstore.getById(code).set("OP_RESULT", result);
                        }
                        else if(type == 'gatherpoint-parameter' && tps_gpparam_gridstore) {
                            if(tps_gpparam_grid_selmodel) {
                                tps_gpparam_grid_selmodel.deselectAll(true);
                            }
                            tps_gpparam_gridstore.getById(code).set("OP_RESULT", result);
                        }
                        else if(type == 'analogue-parameter' && tps_agparam_gridstore) {
                            if(tps_agparam_grid_selmodel) {
                                tps_agparam_grid_selmodel.deselectAll(true);
                            }
                            tps_agparam_gridstore.getById(code).set("OP_RESULT", result);
                        }
                    }
                }
            }
            else {
                Ext.MessageBox.hide();
                //alert('超时');
                Ext.MessageBox.alert('提示', '超时', function(btn) {
                    return;
                });
            }
        },
        failure: function(response) {
            if(totalReceiveCount > 0) {
                setTimeout("receiveTerminalParameterSetupResult('" + type + "','" + action + "'," + taskId + ")", 3000);
            }
            else {
                Ext.MessageBox.hide();
                //alert('超时');
                Ext.MessageBox.alert('提示', '超时', function(btn) {
                    return;
                });
            }
        }
    });
}

function receiveProtectorParameterSetupResult(type, action, taskId) {
    totalReceiveCount--;
    Ext.Ajax.request({
        url: ctx_webapp + '/pm/pps!receive.do',
        params: {
            type: type,
            action: action,
            taskId: taskId
        },
        method: 'POST',
        success: function(response) {
            //alert(response.responseText);
            var r = response.responseText;
            if(totalReceiveCount > 0) {
                if(r == '......') {
                    setTimeout("receiveProtectorParameterSetupResult('" + type + "','" + action + "'," + taskId + ")", 3000);
                }
                else {
                    Ext.MessageBox.hide();
                    var o = Ext.JSON.decode(r);
                    if(Ext.isObject(o)) {
                        var code = o.P_CODE;
                        var result = o.OP_RESULT;
                        if(action == 'write') {
                            if(result == '1') {
                                result = '设置成功';
                            }
                            else {
                                result = '设置失败';
                            }
                        }
                        if(type == 'protector-parameter' && pps_param_gridstore) {
                            if(pps_param_grid_selmodel) {
                                pps_param_grid_selmodel.deselectAll(true);
                            }
                            pps_param_gridstore.getById(code).set("OP_RESULT", result);
                        }
                    }
                }
            }
            else {
                Ext.MessageBox.hide();
                //alert('超时');
                Ext.MessageBox.alert('提示', '超时', function(btn) {
                    return;
                });
            }
        },
        failure: function(response) {
            //alert(response.responseText);
            if(totalReceiveCount > 0) {
                setTimeout("receiveProtectorParameterSetupResult('" + type + "','" + action + "'," + taskId + ")", 3000);
            }
            else {
                Ext.MessageBox.hide();
                //alert('超时');
                Ext.MessageBox.alert('提示', '超时', function(btn) {
                    return;
                });
            }
        }
    });
}

function receiveProtectorControlCommandResult(type, action, taskId) {
    totalReceiveCount--;
    Ext.Ajax.request({
        url: ctx_webapp + '/pm/pccs!receive.do',
        params: {
            type: type,
            action: action,
            taskId: taskId
        },
        method: 'POST',
        success: function(response) {
            //alert(response.responseText);
            var r = response.responseText;
            if(totalReceiveCount > 0) {
                if(r == '......') {
                    setTimeout("receiveProtectorControlCommandResult('" + type + "','" + action + "'," + taskId + ")", 3000);
                }
                else {
                    Ext.MessageBox.hide();
                    var o = Ext.JSON.decode(r);
                    if(Ext.isObject(o)) {
                        var code = o.P_CODE;
                        var result = o.OP_RESULT;
                        if(action == 'write') {
                            if(result == '1') {
                                result = '投入成功';
                            }
                            else {
                                result = '投入失败';
                            }
                        }
                        if(type == 'protector-control' && pccs_control_gridstore) {
                            if(pccs_control_grid_selmodel) {
                                pccs_control_grid_selmodel.deselectAll(true);
                            }
                            pccs_control_gridstore.getById(code).set("OP_RESULT", result);
                        }
                    }
                }
            }
            else {
                Ext.MessageBox.hide();
                //alert('超时');
                Ext.MessageBox.alert('提示', '超时', function(btn) {
                    return;
                });
            }
        },
        failure: function(response) {
            //alert(response.responseText);
            if(totalReceiveCount > 0) {
                setTimeout("receiveProtectorControlCommandResult('" + type + "','" + action + "'," + taskId + ")", 3000);
            }
            else {
                Ext.MessageBox.hide();
                //alert('超时');
                Ext.MessageBox.alert('提示', '超时', function(btn) {
                    return;
                });
            }
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
                            //alert(Ext.getCmp('tps-tabpanel').getActiveTab().id);
                            //Ext.getCmp('tps-tabpanel').getActiveTab().id;
                            var apid = Ext.getCmp('tps-tabpanel').getActiveTab().id;
                            if(!Ext.isEmpty(newValue) && newValue > 0) {
                                //alert("加载集中器：" + newValue);
                                if(apid == 'tps-termparam-grid') {
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
                                                        //alert(code + " : " + value);
                                                        if(tps_termparam_grid_selmodel) {
                                                            tps_termparam_grid_selmodel.deselectAll(true);
                                                        }
                                                        if(tps_termparam_gridstore) {
                                                            tps_termparam_gridstore.getById(code).set("P_VALUE", value);
                                                            tps_termparam_gridstore.getById(code).set("OP_RESULT", "");
                                                        }
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
                                else if(apid == 'tps-gpparam-grid') {
                                    Ext.Ajax.request({
                                        url: ctx_webapp + '/pm/tps!loadGpParamsValuesByTermId.do',
                                        params: {
                                            termId: newValue,
                                            gpSn: Ext.getCmp('tps-gpparam-formfield-gpsn').getValue()
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
                                                        //alert(code + " : " + value);
                                                        if(tps_gpparam_grid_selmodel) {
                                                            tps_gpparam_grid_selmodel.deselectAll(true);
                                                        }
                                                        if(tps_gpparam_gridstore) {
                                                            tps_gpparam_gridstore.getById(code).set("P_VALUE", value);
                                                            tps_gpparam_gridstore.getById(code).set("OP_RESULT", "");
                                                        }
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
                                else if(apid == 'tps-agparam-grid') {
                                    Ext.Ajax.request({
                                        url: ctx_webapp + '/pm/tps!loadAgParamsValuesByTermId.do',
                                        params: {
                                            termId: newValue,
                                            port: Ext.getCmp('tps-agparam-formfield-port').getValue()
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
                                                        //alert(code + " : " + value);
                                                        if(tps_agparam_grid_selmodel) {
                                                            tps_agparam_grid_selmodel.deselectAll(true);
                                                        }
                                                        if(tps_agparam_gridstore) {
                                                            tps_agparam_gridstore.getById(code).set("P_VALUE", value);
                                                            tps_agparam_gridstore.getById(code).set("OP_RESULT", "");
                                                        }
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
                    }
                }]
            }]
        }]
    });
    // 集中器参数列表数据源
    Ext.define('tps-termparam-gridstore-model', {
        extend: 'Ext.data.Model',
        fields: [
            {name: 'P_CODE', type: 'string'},                   /* 参数编码 */
            {name: 'P_NAME', type: 'string'},                   /* 参数名称 */
            {name: 'P_VALUE', type: 'string'},                  /* 参数值 */
            {name: 'OP_RESULT', type: 'string'}                 /* 操作结果 */
        ],
        idProperty: 'P_CODE'
    });
    tps_termparam_gridstore = Ext.create('Ext.data.Store', {
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
    tps_termparam_grid_selmodel = Ext.create('Ext.selection.CheckboxModel', {
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
            Ext.create('Ext.grid.RowNumberer'),
            {text: "参数编码", dataIndex: 'P_CODE', width: 100, sortable: true},
            {text: "参数名称", dataIndex: 'P_NAME', width: 200, sortable: true},
            {text: "参数值", dataIndex: 'P_VALUE', width: 300, sortable: true},
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
                                paramsAndValues += records[i].get("P_CODE") + ':' + records[i].get("P_VALUE") + '||';
                            }
                            var params = {
                                    type: 'terminal-parameter',
                                    action: 'write',
                                    paramsAndValues: paramsAndValues
                            };
                            Ext.apply(params, tps_filter_formpanel.getForm().getValues(false));
                            //alert(Ext.JSON.encode(params))
                            Ext.Ajax.request({
                                url: ctx_webapp + '/pm/tps!send.do',
                                params: params,
                                method: 'POST',
                                success: function(response) {
                                    //alert(response.responseText);
                                    totalReceiveCount = 20;
                                    Ext.MessageBox.show({
                                        msg: '正在设置集中器参数, 请等待...',
                                        progressText: '设置中...',
                                        width: 300,
                                        wait: true,
                                        waitConfig: {interval: 200}
                                    });
                                    setTimeout("receiveTerminalParameterSetupResult('terminal-parameter','write'," + response.responseText + ")", 3000);
                                },
                                failure: function(response) {
                                    //alert(response.responseText);
                                }
                            });
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
                    var termId = Ext.getCmp('tps-filter-formfield-term').getValue();
                    if(Ext.isEmpty(termId)) {
                        Ext.MessageBox.alert('提示', '请选择要读取的集中器', function(btn) {
                            return;
                        });
                    }
                    else {
                        var records = tps_termparam_grid_selections;
                        if(typeof(records) == "undefined" || records.length == 0) {
                            Ext.MessageBox.alert('提示', '请选择要读取的参数项', function(btn) {
                                return;
                            });
                        }
                        else {
                            var paramsAndValues = '';
                            for(var i = 0; i < records.length; i++) {
                                paramsAndValues += records[i].get("P_CODE") + ":" + '||';
                            }
                            var params = {
                                    type: 'terminal-parameter',
                                    action: 'read',
                                    paramsAndValues: paramsAndValues
                            };
                            Ext.apply(params, tps_filter_formpanel.getForm().getValues(false));
                            //alert(Ext.JSON.encode(params));
                            Ext.Ajax.request({
                                url: ctx_webapp + '/pm/tps!send.do',
                                params: params,
                                method: 'POST',
                                success: function(response) {
                                    //alert(response.responseText);
                                    totalReceiveCount = 20;
                                    Ext.MessageBox.show({
                                        msg: '正在读取集中器参数, 请等待...',
                                        progressText: '读取中...',
                                        width: 300,
                                        wait: true,
                                        waitConfig: {interval: 200}
                                    });
                                    setTimeout("receiveTerminalParameterSetupResult('terminal-parameter','read'," + response.responseText + ")", 3000);
                                },
                                failure: function(response) {
                                    //alert(response.responseText);
                                }
                            });
                        }
                    }
                }
            }]
        }]
    });
    // 测量点参数列表数据源
    Ext.define('tps-gpparam-gridstore-model', {
        extend: 'Ext.data.Model',
        fields: [
            {name: 'P_CODE', type: 'string'},                   /* 参数编码 */
            {name: 'P_NAME', type: 'string'},                   /* 参数名称 */
            {name: 'P_VALUE', type: 'string'},                  /* 参数值 */
            {name: 'OP_RESULT', type: 'string'}                 /* 操作结果 */
        ],
        idProperty: 'P_CODE'
    });
    tps_gpparam_gridstore = Ext.create('Ext.data.Store', {
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
    tps_gpparam_grid_selmodel = Ext.create('Ext.selection.CheckboxModel', {
        checkOnly: true,
        mode: 'SINGLE',
        showHeaderCheckbox: false,
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
            Ext.create('Ext.grid.RowNumberer'),
            {text: "参数编码", dataIndex: 'P_CODE', width: 100, sortable: true},
            {text: "参数名称", dataIndex: 'P_NAME', width: 200, sortable: true},
            {text: "参数值", dataIndex: 'P_VALUE', width: 300, sortable: true},
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
                    var termId = Ext.getCmp('tps-filter-formfield-term').getValue();
                    if(Ext.isEmpty(termId)) {
                        Ext.MessageBox.alert('提示', '请选择要设置的集中器', function(btn) {
                            return;
                        });
                    }
                    else {
                        var records = tps_gpparam_grid_selections;
                        if(typeof(records) == "undefined" || records.length == 0) {
                            Ext.MessageBox.alert('提示', '请选择要设置的参数项', function(btn) {
                                return;
                            });
                        }
                        else {
                            var paramsAndValues = '';
                            for(var i = 0; i < records.length; i++) {
                                paramsAndValues += records[i].get("P_CODE") + ':' + records[i].get("P_VALUE") + '||';
                            }
                            var params = {
                                    gpSn: Ext.getCmp('tps-gpparam-formfield-gpsn').getValue(),
                                    type: 'gatherpoint-parameter',
                                    action: 'write',
                                    paramsAndValues: paramsAndValues
                            };
                            Ext.apply(params, tps_filter_formpanel.getForm().getValues(false));
                            //alert(Ext.JSON.encode(params));
                            Ext.Ajax.request({
                                url: ctx_webapp + '/pm/tps!send.do',
                                params: params,
                                method: 'POST',
                                success: function(response) {
                                    //alert(response.responseText);
                                    totalReceiveCount = 20;
                                    Ext.MessageBox.show({
                                        msg: '正在设置测量点参数, 请等待...',
                                        progressText: '设置中...',
                                        width: 300,
                                        wait: true,
                                        waitConfig: {interval: 200}
                                    });
                                    setTimeout("receiveTerminalParameterSetupResult('gatherpoint-parameter','write'," + response.responseText + ")", 3000);
                                },
                                failure: function(response) {
                                    //alert(response.responseText);
                                }
                            });
                        }
                    }
                }
            }, '-', {
                itemId: 'tps-gpparam-reading-button',
                text: '读取',
                tooltip: '读取测量点参数',
                iconCls: 'reading',
                disabled: true,
                handler: function() {
                    //alert('读取测量点参数');
                    var termId = Ext.getCmp('tps-filter-formfield-term').getValue();
                    if(Ext.isEmpty(termId)) {
                        Ext.MessageBox.alert('提示', '请选择要读取的集中器', function(btn) {
                            return;
                        });
                    }
                    else {
                        var records = tps_gpparam_grid_selections;
                        if(typeof(records) == "undefined" || records.length == 0) {
                            Ext.MessageBox.alert('提示', '请选择要读取的参数项', function(btn) {
                                return;
                            });
                        }
                        else {
                            var paramsAndValues = '';
                            for(var i = 0; i < records.length; i++) {
                                paramsAndValues += records[i].get("P_CODE") + ":" + '||';
                            }
                            var params = {
                                    gpSn: Ext.getCmp('tps-gpparam-formfield-gpsn').getValue(),
                                    type: 'gatherpoint-parameter',
                                    action: 'read',
                                    paramsAndValues: paramsAndValues
                            };
                            Ext.apply(params, tps_filter_formpanel.getForm().getValues(false));
                            //alert(Ext.JSON.encode(params));
                            Ext.Ajax.request({
                                url: ctx_webapp + '/pm/tps!send.do',
                                params: params,
                                method: 'POST',
                                success: function(response) {
                                    //alert(response.responseText);
                                    totalReceiveCount = 20;
                                    Ext.MessageBox.show({
                                        msg: '正在读取测量点参数, 请等待...',
                                        progressText: '读取中...',
                                        width: 300,
                                        wait: true,
                                        waitConfig: {interval: 200}
                                    });
                                    setTimeout("receiveTerminalParameterSetupResult('gatherpoint-parameter','read'," + response.responseText + ")", 3000);
                                },
                                failure: function(response) {
                                    //alert(response.responseText);
                                }
                            });
                        }
                    }
                }
            }, '->', {
                xtype: 'combobox',
                id: 'tps-gpparam-formfield-gpsn',
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
                width: 150,
                minWidth: 150,
                maxWidth: 150,
                value: 1,
                listeners: {
                    change: function(combo, newValue, oldValue, eOpts) {
                        //alert(newValue);
                        var termId = Ext.getCmp('tps-filter-formfield-term').getValue();
                        if(!Ext.isEmpty(termId) && termId > 0) {
                            //alert("加载集中器：" + termId);
                            Ext.Ajax.request({
                                url: ctx_webapp + '/pm/tps!loadGpParamsValuesByTermId.do',
                                params: {
                                    termId: termId,
                                    gpSn: Ext.getCmp('tps-gpparam-formfield-gpsn').getValue()
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
                                                //alert(code + " : " + value);
                                                if(tps_gpparam_grid_selmodel) {
                                                    tps_gpparam_grid_selmodel.deselectAll(true);
                                                }
                                                if(tps_gpparam_gridstore) {
                                                    tps_gpparam_gridstore.getById(code).set("P_VALUE", value);
                                                    tps_gpparam_gridstore.getById(code).set("OP_RESULT", "");
                                                }
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
    });
    // 模拟量参数列表数据源
    Ext.define('tps-agparam-gridstore-model', {
        extend: 'Ext.data.Model',
        fields: [
            {name: 'P_CODE', type: 'string'},                   /* 参数编码 */
            {name: 'P_NAME', type: 'string'},                   /* 参数名称 */
            {name: 'P_VALUE', type: 'string'},                  /* 参数值 */
            {name: 'OP_RESULT', type: 'string'}                 /* 操作结果 */
        ],
        idProperty: 'P_CODE'
    });
    tps_agparam_gridstore = Ext.create('Ext.data.Store', {
        // destroy the store if the grid is destroyed
        autoDestroy: true,
        model: 'tps-agparam-gridstore-model',
        proxy: {
            // load using script tags for cross domain, if the data in on the same domain as
            // this page, an HttpProxy would be better
            type: 'ajax',
            url: ctx_webstatic + '/customized/project/hd/data/tps-agparam-grid-data.json',
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
    // 模拟量参数列表
    tps_agparam_grid_selmodel = Ext.create('Ext.selection.CheckboxModel', {
        checkOnly: true,
        mode: 'SINGLE',
        showHeaderCheckbox: false,
        listeners: {
            selectionchange: function(sm, selections) {
                tps_agparam_gridpanel.down('#tps-agparam-setting-button').setDisabled(selections.length == 0);
                tps_agparam_gridpanel.down('#tps-agparam-reading-button').setDisabled(selections.length == 0);
                tps_agparam_grid_selections = selections;
            }
        }
    });
    var tps_agparam_gridpanel = Ext.create('Ext.grid.Panel', {
        id: 'tps-agparam-grid',
        title: '模拟量参数',
        xtype: 'grid',
        layout: 'fit',
        store: tps_agparam_gridstore,
        loadMask: true,
        columns: [
            Ext.create('Ext.grid.RowNumberer'),
            {text: "参数编码", dataIndex: 'P_CODE', width: 100, sortable: true},
            {text: "参数名称", dataIndex: 'P_NAME', width: 200, sortable: true},
            {text: "参数值", dataIndex: 'P_VALUE', width: 300, sortable: true},
            {text: "操作结果", dataIndex: 'OP_RESULT', flex: 1, sortable: true}
        ],
        columnLines: true,
        selModel: tps_agparam_grid_selmodel,
        // inline buttons
        dockedItems: [{
            xtype: 'toolbar',
            dock: 'top',
            items: [{
                itemId: 'tps-agparam-setting-button',
                text: '设置',
                tooltip: '设置模拟量参数',
                iconCls: 'setting',
                disabled: true,
                handler: function() {
                    //alert('设置模拟量参数');
                    var termId = Ext.getCmp('tps-filter-formfield-term').getValue();
                    if(Ext.isEmpty(termId)) {
                        Ext.MessageBox.alert('提示', '请选择要设置的集中器', function(btn) {
                            return;
                        });
                    }
                    else {
                        var records = tps_agparam_grid_selections;
                        if(typeof(records) == "undefined" || records.length == 0) {
                            Ext.MessageBox.alert('提示', '请选择要设置的参数项', function(btn) {
                                return;
                            });
                        }
                        else {
                            var paramsAndValues = '';
                            for(var i = 0; i < records.length; i++) {
                                paramsAndValues += records[i].get("P_CODE") + ':' + records[i].get("P_VALUE") + '||';
                            }
                            var params = {
                                    port: Ext.getCmp('tps-agparam-formfield-port').getValue(),
                                    type: 'analogue-parameter',
                                    action: 'write',
                                    paramsAndValues: paramsAndValues
                            };
                            Ext.apply(params, tps_filter_formpanel.getForm().getValues(false));
                            //alert(Ext.JSON.encode(params));
                            Ext.Ajax.request({
                                url: ctx_webapp + '/pm/tps!send.do',
                                params: params,
                                method: 'POST',
                                success: function(response) {
                                    //alert(response.responseText);
                                    totalReceiveCount = 20;
                                    Ext.MessageBox.show({
                                        msg: '正在设置模拟量参数, 请等待...',
                                        progressText: '设置中...',
                                        width: 300,
                                        wait: true,
                                        waitConfig: {interval: 200}
                                    });
                                    setTimeout("receiveTerminalParameterSetupResult('analogue-parameter','write'," + response.responseText + ")", 3000);
                                },
                                failure: function(response) {
                                    //alert(response.responseText);
                                }
                            });
                        }
                    }
                }
            }, '-', {
                itemId: 'tps-agparam-reading-button',
                text: '读取',
                tooltip: '读取模拟量参数',
                iconCls: 'reading',
                disabled: true,
                handler: function() {
                    //alert('读取模拟量参数');
                    var termId = Ext.getCmp('tps-filter-formfield-term').getValue();
                    if(Ext.isEmpty(termId)) {
                        Ext.MessageBox.alert('提示', '请选择要读取的集中器', function(btn) {
                            return;
                        });
                    }
                    else {
                        var records = tps_agparam_grid_selections;
                        if(typeof(records) == "undefined" || records.length == 0) {
                            Ext.MessageBox.alert('提示', '请选择要读取的参数项', function(btn) {
                                return;
                            });
                        }
                        else {
                            var paramsAndValues = '';
                            for(var i = 0; i < records.length; i++) {
                                paramsAndValues += records[i].get("P_CODE") + ":" + '||';
                            }
                            var params = {
                                    port: Ext.getCmp('tps-agparam-formfield-port').getValue(),
                                    type: 'analogue-parameter',
                                    action: 'read',
                                    paramsAndValues: paramsAndValues
                            };
                            Ext.apply(params, tps_filter_formpanel.getForm().getValues(false));
                            //alert(Ext.JSON.encode(params));
                            Ext.Ajax.request({
                                url: ctx_webapp + '/pm/tps!send.do',
                                params: params,
                                method: 'POST',
                                success: function(response) {
                                    //alert(response.responseText);
                                    totalReceiveCount = 20;
                                    Ext.MessageBox.show({
                                        msg: '正在读取模拟量参数, 请等待...',
                                        progressText: '读取中...',
                                        width: 300,
                                        wait: true,
                                        waitConfig: {interval: 200}
                                    });
                                    setTimeout("receiveTerminalParameterSetupResult('analogue-parameter','read'," + response.responseText + ")", 3000);
                                },
                                failure: function(response) {
                                    //alert(response.responseText);
                                }
                            });
                        }
                    }
                }
            }, '->', {
                xtype: 'combobox',
                id: 'tps-agparam-formfield-port',
                name: 'port',
                fieldLabel: '模拟量',
                store: Ext.create('Ext.data.Store', {
                    fields: ['value', 'label'],
                    data: [
                        {"value": 1, "label": "模拟量 1"},
                        {"value": 2, "label": "模拟量 2"},
                        {"value": 3, "label": "模拟量 3"},
                        {"value": 4, "label": "模拟量 4"},
                        {"value": 5, "label": "模拟量 5"},
                        {"value": 6, "label": "模拟量 6"},
                        {"value": 7, "label": "模拟量 7"},
                        {"value": 8, "label": "模拟量 8"}
                    ]
                }),
                valueField: 'value',
                displayField: 'label',
                queryMode: 'local',
                forceSelection : true,
                triggerAction : 'all',
                editable: false,
                labelWidth: 50,
                width: 150,
                minWidth: 150,
                maxWidth: 150,
                value: 1,
                listeners: {
                    change: function(combo, newValue, oldValue, eOpts) {
                        //alert(newValue);
                        var termId = Ext.getCmp('tps-filter-formfield-term').getValue();
                        if(!Ext.isEmpty(termId) && termId > 0) {
                            //alert("加载集中器：" + termId);
                            Ext.Ajax.request({
                                url: ctx_webapp + '/pm/tps!loadAgParamsValuesByTermId.do',
                                params: {
                                    termId: termId,
                                    port: Ext.getCmp('tps-agparam-formfield-port').getValue()
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
                                                //alert(code + " : " + value);
                                                if(tps_agparam_grid_selmodel) {
                                                    tps_agparam_grid_selmodel.deselectAll(true);
                                                }
                                                if(tps_agparam_gridstore) {
                                                    tps_agparam_gridstore.getById(code).set("P_VALUE", value);
                                                    tps_agparam_gridstore.getById(code).set("OP_RESULT", "");
                                                }
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

    var ppsFilterPsListStore = Ext.create('Ext.data.Store', {
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
                                    params: {orgId: Ext.getCmp('pps-filter-formfield-org').getValue(), tgId: newValue},
                                    callback: function(records, operation, success) {
                                        //Ext.getCmp('pps-filter-formfield-ps').setValue(null);
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
                    store: ppsFilterPsListStore,
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
                            if(!Ext.isEmpty(newValue) && newValue > 0) {
                                //alert("加载保护器：" + newValue);
                                Ext.Ajax.request({
                                    url: ctx_webapp + '/pm/pps!loadPsParamsValuesByGpId.do',
                                    params: {
                                        gpId: newValue
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
                                                    //alert(code + " : " + value);
                                                    if(pps_param_grid_selmodel) {
                                                        pps_param_grid_selmodel.deselectAll(true);
                                                    }
                                                    if(pps_param_gridstore) {
                                                        pps_param_gridstore.getById(code).set("P_VALUE", value);
                                                        pps_param_gridstore.getById(code).set("OP_RESULT", "");
                                                    }
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
    // 保护器参数列表数据源
    Ext.define('pps-param-gridstore-model', {
        extend: 'Ext.data.Model',
        fields: [
            {name: 'P_CODE', type: 'string'},                   /* 参数编码 */
            {name: 'P_NAME', type: 'string'},                   /* 参数名称 */
            {name: 'P_VALUE', type: 'string'},                  /* 参数值 */
            {name: 'OP_RESULT', type: 'string'}                 /* 操作结果 */
        ],
        idProperty: 'P_CODE'
    });
    pps_param_gridstore = Ext.create('Ext.data.Store', {
        // destroy the store if the grid is destroyed
        autoDestroy: true,
        model: 'pps-param-gridstore-model',
        proxy: {
            // load using script tags for cross domain, if the data in on the same domain as
            // this page, an HttpProxy would be better
            type: 'ajax',
            url: ctx_webstatic + '/customized/project/hd/data/pps-param-grid-data.json',
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
    // 保护器参数列表
    pps_param_grid_selmodel = Ext.create('Ext.selection.CheckboxModel', {
        checkOnly: true,
        mode: 'SINGLE',
        showHeaderCheckbox: false,
        listeners: {
            selectionchange: function(sm, selections) {
                pps_param_gridpanel.down('#pps-param-setting-button').setDisabled(selections.length == 0);
                pps_param_gridpanel.down('#pps-param-reading-button').setDisabled(selections.length == 0);
                pps_param_grid_selections = selections;
            }
        }
    });
    var pps_param_gridpanel = Ext.create('Ext.grid.Panel', {
        id: 'pps-param-grid',
        title: '保护器参数',
        xtype: 'grid',
        layout: 'fit',
        store: pps_param_gridstore,
        loadMask: true,
        columns: [
            Ext.create('Ext.grid.RowNumberer'),
            {text: "参数编码", dataIndex: 'P_CODE', width: 100, sortable: true},
            {text: "参数名称", dataIndex: 'P_NAME', width: 200, sortable: true},
            {text: "参数值", dataIndex: 'P_VALUE', width: 300, sortable: true},
            {text: "操作结果", dataIndex: 'OP_RESULT', flex: 1, sortable: true}
        ],
        columnLines: true,
        selModel: pps_param_grid_selmodel,
        // inline buttons
        dockedItems: [{
            xtype: 'toolbar',
            dock: 'top',
            items: [{
                itemId: 'pps-param-setting-button',
                text: '设置',
                tooltip: '设置保护器参数',
                iconCls: 'setting',
                disabled: true,
                handler: function() {
                    //alert('设置保护器参数');
                    var gpId = Ext.getCmp('pps-filter-formfield-ps').getValue();
                    if(Ext.isEmpty(gpId)) {
                        Ext.MessageBox.alert('提示', '请选择要设置的保护器', function(btn) {
                            return;
                        });
                    }
                    else {
                        var records = pps_param_grid_selections;
                        //alert(records.length);
                        if(typeof(records) == "undefined" || records.length == 0) {
                            Ext.MessageBox.alert('提示', '请选择要设置的参数项', function(btn) {
                                return;
                            });
                        }
                        else {
                            var paramsAndValues = '';
                            for(var i = 0; i < records.length; i++) {
                                paramsAndValues += records[i].get("P_CODE") + ':' + records[i].get("P_VALUE") + '||';
                            }
                            var params = {
                                    type: 'protector-parameter',
                                    action: 'write',
                                    paramsAndValues: paramsAndValues
                            };
                            Ext.apply(params, pps_filter_formpanel.getForm().getValues(false));
                            Ext.Ajax.request({
                                url: ctx_webapp + '/pm/pps!send.do',
                                params: params,
                                method: 'POST',
                                success: function(response) {
                                    //alert(response.responseText);
                                    totalReceiveCount = 20;
                                    Ext.MessageBox.show({
                                        msg: '正在设置保护器参数, 请等待...',
                                        progressText: '设置中...',
                                        width: 300,
                                        wait: true,
                                        waitConfig: {interval: 200}
                                    });
                                    setTimeout("receiveProtectorParameterSetupResult('protector-parameter','write'," + response.responseText + ")", 3000);
                                },
                                failure: function(response) {
                                    //alert(response.responseText);
                                }
                            });
                        }
                    }
                }
            }, '-', {
                itemId: 'pps-param-reading-button',
                text: '读取',
                tooltip: '读取保护器参数',
                iconCls: 'reading',
                disabled: true,
                handler: function() {
                    //alert('读取保护器参数');
                    var gpId = Ext.getCmp('pps-filter-formfield-ps').getValue();
                    if(Ext.isEmpty(gpId)) {
                        Ext.MessageBox.alert('提示', '请选择要读取的保护器', function(btn) {
                            return;
                        });
                    }
                    else {
                        var records = pps_param_grid_selections;
                        if(typeof(records) == "undefined" || records.length == 0) {
                            Ext.MessageBox.alert('提示', '请选择要读取的参数项', function(btn) {
                                return;
                            });
                        }
                        else {
                            var paramsAndValues = '';
                            for(var i = 0; i < records.length; i++) {
                                paramsAndValues += records[i].get("P_CODE") + ":" + '||';
                            }
                            var params = {
                                    type: 'protector-parameter',
                                    action: 'read',
                                    paramsAndValues: paramsAndValues
                            };
                            Ext.apply(params, pps_filter_formpanel.getForm().getValues(false));
                            //alert(Ext.JSON.encode(params));
                            Ext.Ajax.request({
                                url: ctx_webapp + '/pm/pps!send.do',
                                params: params,
                                method: 'POST',
                                success: function(response) {
                                    //alert(response.responseText);
                                    totalReceiveCount = 20;
                                    Ext.MessageBox.show({
                                        msg: '正在读取保护器参数, 请等待...',
                                        progressText: '读取中...',
                                        width: 300,
                                        wait: true,
                                        waitConfig: {interval: 200}
                                    });
                                    setTimeout("receiveProtectorParameterSetupResult('protector-parameter','read'," + response.responseText + ")", 3000);
                                },
                                failure: function(response) {
                                    //alert(response.responseText);
                                }
                            });
                        }
                    }
                }
            }]
        }]
    });

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

    var pccsFilterPsListStore = Ext.create('Ext.data.Store', {
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
                                    params: {orgId: Ext.getCmp('pccs-filter-formfield-org').getValue(), tgId: newValue},
                                    callback: function(records, operation, success) {
                                        //Ext.getCmp('pccs-filter-formfield-ps').setValue(null);
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
                    store: pccsFilterPsListStore,
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
                            if(!Ext.isEmpty(newValue) && newValue > 0) {
                                //alert("加载保护器：" + newValue);
                                Ext.Ajax.request({
                                    url: ctx_webapp + '/pm/pccs!loadPsParamsValuesByGpId.do',
                                    params: {
                                        gpId: newValue
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
                                                    //alert(code + " : " + value);
                                                    if(pccs_control_grid_selmodel) {
                                                        pccs_control_grid_selmodel.deselectAll(true);
                                                    }
                                                    if(pccs_control_gridstore) {
                                                        pccs_control_gridstore.getById(code).set("P_VALUE", value);
                                                        pccs_control_gridstore.getById(code).set("OP_RESULT", "");
                                                    }
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
    // 保护器控制命令列表数据源
    Ext.define('pccs-control-gridstore-model', {
        extend: 'Ext.data.Model',
        fields: [
            {name: 'P_CODE', type: 'string'},                   /* 控制命令编码 */
            {name: 'P_NAME', type: 'string'},                   /* 控制命令名称 */
            {name: 'P_VALUE', type: 'string'},                  /* 控制命令参数值 */
            {name: 'OP_RESULT', type: 'string'}                 /* 操作结果 */
        ],
        idProperty: 'P_CODE'
    });
    pccs_control_gridstore = Ext.create('Ext.data.Store', {
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
    pccs_control_grid_selmodel = Ext.create('Ext.selection.CheckboxModel', {
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
    var pccs_control_gridpanel = Ext.create('Ext.grid.Panel', {
        id: 'pccs-control-grid',
        title: '保护器控制命令',
        xtype: 'grid',
        layout: 'fit',
        store: pccs_control_gridstore,
        loadMask: true,
        columns: [
            Ext.create('Ext.grid.RowNumberer'),
            {text: "控制命令编码", dataIndex: 'P_CODE', width: 100, sortable: true},
            {text: "控制命令名称", dataIndex: 'P_NAME', width: 200, sortable: true},
            {text: "控制命令参数值", dataIndex: 'P_VALUE', width: 300, sortable: true},
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
                    var gpId = Ext.getCmp('pccs-filter-formfield-ps').getValue();
                    if(Ext.isEmpty(gpId)) {
                        Ext.MessageBox.alert('提示', '请选择要投入的保护器', function(btn) {
                            return;
                        });
                    }
                    else {
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
                                paramsAndValues += records[i].get("P_CODE") + ':' + records[i].get("P_VALUE") + '||';
                            }
                            var params = {
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
                                    totalReceiveCount = 20;
                                    Ext.MessageBox.show({
                                        msg: '正在投入保护器控制命令, 请等待...',
                                        progressText: '下发中...',
                                        width: 300,
                                        wait: true,
                                        waitConfig: {interval: 200}
                                    });
                                    setTimeout("receiveProtectorControlCommandResult('protector-control','write'," + response.responseText + ")", 3000);
                                },
                                failure: function(response) {
                                    //alert(response.responseText);
                                }
                            });
                        }
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
                    id: 'tps-tabpanel',
                    plain: true,
                    region: 'center',
                    margins: '0 5 5 5',
                    activeTab: 0,
                    items: [tps_termparam_gridpanel, tps_gpparam_gridpanel, tps_agparam_gridpanel],
                    listeners: {
                        tabchange: function(tabPanel, newCard, oldCard, eOpts) {
                            //alert(newCard.id);
                            var apid = newCard.id;
                            var termId = Ext.getCmp('tps-filter-formfield-term').getValue();
                            if(!Ext.isEmpty(termId) && termId > 0) {
                                //alert("加载集中器：" + termId);
                                if(apid == 'tps-termparam-grid') {
                                    Ext.Ajax.request({
                                        url: ctx_webapp + '/pm/tps!loadTermParamsValuesByTermId.do',
                                        params: {
                                            termId: termId
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
                                                        //alert(code + " : " + value);
                                                        if(tps_termparam_grid_selmodel) {
                                                            tps_termparam_grid_selmodel.deselectAll(true);
                                                        }
                                                        if(tps_termparam_gridstore) {
                                                            tps_termparam_gridstore.getById(code).set("P_VALUE", value);
                                                            tps_termparam_gridstore.getById(code).set("OP_RESULT", "");
                                                        }
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
                                else if(apid == 'tps-gpparam-grid') {
                                    Ext.Ajax.request({
                                        url: ctx_webapp + '/pm/tps!loadGpParamsValuesByTermId.do',
                                        params: {
                                            termId: termId,
                                            gpSn: Ext.getCmp('tps-gpparam-formfield-gpsn').getValue()
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
                                                        //alert(code + " : " + value);
                                                        if(tps_gpparam_grid_selmodel) {
                                                            tps_gpparam_grid_selmodel.deselectAll(true);
                                                        }
                                                        if(tps_gpparam_gridstore) {
                                                            tps_gpparam_gridstore.getById(code).set("P_VALUE", value);
                                                            tps_gpparam_gridstore.getById(code).set("OP_RESULT", "");
                                                        }
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
                                else if(apid == 'tps-agparam-grid') {
                                    Ext.Ajax.request({
                                        url: ctx_webapp + '/pm/tps!loadAgParamsValuesByTermId.do',
                                        params: {
                                            termId: termId,
                                            port: Ext.getCmp('tps-agparam-formfield-port').getValue()
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
                                                        //alert(code + " : " + value);
                                                        if(tps_agparam_grid_selmodel) {
                                                            tps_agparam_grid_selmodel.deselectAll(true);
                                                        }
                                                        if(tps_agparam_gridstore) {
                                                            tps_agparam_gridstore.getById(code).set("P_VALUE", value);
                                                            tps_agparam_gridstore.getById(code).set("OP_RESULT", "");
                                                        }
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
                    }
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