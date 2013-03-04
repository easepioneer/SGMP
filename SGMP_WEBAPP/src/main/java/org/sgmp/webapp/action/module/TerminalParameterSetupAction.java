package org.sgmp.webapp.action.module;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.sgmp.webapp.ActionException;
import org.sgmp.webapp.ServiceException;
import org.sgmp.webapp.mapper.module.TerminalMapper;
import org.sgmp.webapp.pojo.module.Terminal;
import org.sgmp.webapp.service.module.SimpleCURDService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fep.bp.realinterface.mto.CollectObject;
import fep.bp.realinterface.mto.CommandItem;
import fep.bp.realinterface.mto.MTO_376;

/**
 * 集中器参数设置
 * 
 * @author Nick
 *
 */
@Component
public class TerminalParameterSetupAction extends AbstractSimpleInteractionAction {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 5227015749661420465L;

    private static final Logger logger = LoggerFactory.getLogger(TerminalParameterSetupAction.class);

    @Autowired
    private SimpleCURDService<Terminal> termService;

    private Terminal terminal;

    private Integer gpSn;
    private Integer port;

    @Override
    public void beforeSend() {
        logger.info("soType             : " + soType);
        logger.info("soId               : " + soId);
        logger.info("soName             : " + soName);
        logger.info("soOrgId            : " + soOrgId);
        logger.info("soTgId             : " + soTgId);
        logger.info("soTermId           : " + soTermId);
        logger.info("soGpId             : " + soGpId);
        logger.info("gpSn               : " + gpSn);
        logger.info("port               : " + port);
        logger.info("type               : " + type);
        logger.info("action             : " + action);
        logger.info("paramsAndValues    : " + paramsAndValues);
        if(StringUtils.equals(type, TYPE_TERMINAL_PARAMETER)) {
            // 集中器参数
            Long termId = Long.parseLong(soTermId);
            try {
                terminal = termService.getById(TerminalMapper.class, termId);
            }
            catch(ServiceException _se) {
                logger.error("send error", _se);
            }

            MTO_376 mto = new MTO_376();
            List<CollectObject> coList = new ArrayList<CollectObject>();
            CollectObject co = new CollectObject();
            co.setLogicalAddr(terminal.getLogicalAddr());
            co.setEquipProtocol(terminal.getProtocolNo());
            co.setChannelType(terminal.getChannelType());
            co.setPwAlgorith("0");
            co.setPwContent("8888");
            co.setMpExpressMode(3);
            int[] mpSn = {0};
            co.setMpSn(mpSn);

            int p = paramsAndValues.indexOf(":");
            int q = paramsAndValues.indexOf("||");
            String param = paramsAndValues.substring(0, p);
            String value = paramsAndValues.substring(p + 1, q);
            logger.info("param : " + param);
            logger.info("value : " + value);

            if(StringUtils.equals(action, "write") && terminal != null) {
                if(StringUtils.equals(param, "F1")) {
                    // 终端上行通信口通信参数设置
                    CommandItem ci = new CommandItem();
                    ci.setIdentifier("10040001");
                    Map<String, String> dcp = new HashMap<String, String>();
                    if(StringUtils.isNotBlank(value)) {
                        String[] pvItems = value.split(";");
                        for(int i = 0; i < pvItems.length; i++) {
                            if(i == 0) {
                                dcp.put("1004000101", pvItems[i]);          // 终端数传机延时时间RTS
                            }
                            else if(i == 1) {
                                dcp.put("1004000102", pvItems[i]);          // 终端作为启动站允许发送传输延时时间
                            }
                            else if(i == 2) {
                                dcp.put("1004000103", pvItems[i]);          // 终端等待从动站响应的超时时间
                            }
                            else if(i == 3) {
                                dcp.put("1004000104", pvItems[i]);          // 终端等待从动站响应的重发次数
                            }
                            else if(i == 4) {
                                dcp.put("1004000106", pvItems[i]);          // 需要主站确认的通信服务（CON=1）的标志
                            }
                            else if(i == 5) {
                                dcp.put("1004000107", pvItems[i]);          // 心跳周期
                            }
                        }
                    }
                    ci.setDatacellParam(dcp);
                    co.AddCommandItem(ci);
                }
                else if(StringUtils.equals(param, "F3")) {
                    // 主站IP地址和端口
                    CommandItem ci = new CommandItem();
                    ci.setIdentifier("10040003");
                    Map<String, String> dcp = new HashMap<String, String>();
                    if(StringUtils.isNotBlank(value)) {
                        String[] pvItems = value.split(";");
                        for(int i = 0; i < pvItems.length; i++) {
                            if(i == 0) {
                                dcp.put("1004000301", pvItems[i]);          // 主用IP地址和端口
                            }
                            else if(i == 1) {
                                dcp.put("1004000302", pvItems[i]);          // 备用IP地址和端口
                            }
                            else if(i == 2) {
                                dcp.put("1004000303", pvItems[i]);          // APN
                            }
                        }
                    }
                    ci.setDatacellParam(dcp);
                    co.AddCommandItem(ci);
                }
                else if(StringUtils.equals(param, "F12")) {
                    // 终端状态量输入参数
                    CommandItem ci = new CommandItem();
                    ci.setIdentifier("10040012");
                    Map<String, String> dcp = new HashMap<String, String>();
                    if(StringUtils.isNotBlank(value)) {
                        String[] pvItems = value.split(";");
                        for(int i = 0; i < pvItems.length; i++) {
                            if(i == 0) {
                                dcp.put("1004001201", pvItems[i]);          // 状态量接入标志位
                            }
                            else if(i == 1) {
                                dcp.put("1004001202", pvItems[i]);          // 状态量属性标志位
                            }
                        }
                    }
                    ci.setDatacellParam(dcp);
                    co.AddCommandItem(ci);
                }
                else if(StringUtils.equals(param, "F61")) {
                    // 直流模拟量接入参数
                    CommandItem ci = new CommandItem();
                    ci.setIdentifier("10040061");
                    Map<String, String> dcp = new HashMap<String, String>();
                    if(StringUtils.isNotBlank(value)) {
                        String[] pvItems = value.split(";");
                        for(int i = 0; i < pvItems.length; i++) {
                            if(i == 0) {
                                dcp.put("1004006101", pvItems[i]);          // 直流模拟量接入标志位
                            }
                        }
                    }
                    ci.setDatacellParam(dcp);
                    co.AddCommandItem(ci);
                }
            }
            else if(StringUtils.equals(action, "read") && terminal != null) {
                if(StringUtils.equals(param, "F1")) {
                    // 终端上行通信口通信参数设置
                    CommandItem ci = new CommandItem();
                    ci.setIdentifier("10040001");
                    co.AddCommandItem(ci);
                }
                else if(StringUtils.equals(param, "F3")) {
                    // 主站IP地址和端口
                    CommandItem ci = new CommandItem();
                    ci.setIdentifier("10040003");
                    co.AddCommandItem(ci);
                }
                else if(StringUtils.equals(param, "F12")) {
                    // 终端状态量输入参数
                    CommandItem ci = new CommandItem();
                    ci.setIdentifier("10040012");
                    co.AddCommandItem(ci);
                }
                else if(StringUtils.equals(param, "F61")) {
                    // 直流模拟量接入参数
                    CommandItem ci = new CommandItem();
                    ci.setIdentifier("10040061");
                    co.AddCommandItem(ci);
                }
            }
            coList.add(co);
            mto.setCollectObjects(coList);
            setMto376(mto);
        }
        else if(StringUtils.equals(type, TYPE_GATHERPOINT_PARAMETER)) {
            // 测量点参数
            Long termId = Long.parseLong(soTermId);
            try {
                terminal = termService.getById(TerminalMapper.class, termId);
            }
            catch(ServiceException _se) {
                logger.error("send error", _se);
            }

            MTO_376 mto = new MTO_376();
            List<CollectObject> coList = new ArrayList<CollectObject>();
            CollectObject co = new CollectObject();
            co.setLogicalAddr(terminal.getLogicalAddr());
            co.setEquipProtocol(terminal.getProtocolNo());
            co.setChannelType(terminal.getChannelType());
            co.setPwAlgorith("0");
            co.setPwContent("8888");
            co.setMpExpressMode(3);
            int[] mpSn = new int[1];
            mpSn[0] = gpSn;
            co.setMpSn(mpSn);

            int p = paramsAndValues.indexOf(":");
            int q = paramsAndValues.indexOf("||");
            String param = paramsAndValues.substring(0, p);
            String value = paramsAndValues.substring(p + 1, q);
            logger.info("param : " + param);
            logger.info("value : " + value);

            if(StringUtils.equals(action, "write") && terminal != null) {
                if(StringUtils.equals(param, "F25")) {
                    // 测量点基本参数
                    CommandItem ci = new CommandItem();
                    ci.setIdentifier("10040025");
                    Map<String, String> dcp = new HashMap<String, String>();
                    if(StringUtils.isNotBlank(value)) {
                        String[] pvItems = value.split(";");
                        for(int i = 0; i < pvItems.length; i++) {
                            if(i == 0) {
                                dcp.put("1004002501", pvItems[i]);          // 电压互感器倍率
                            }
                            else if(i == 1) {
                                dcp.put("1004002502", pvItems[i]);          // 电流互感器倍率
                            }
                            else if(i == 2) {
                                dcp.put("1004002503", pvItems[i]);          // 额定电压
                            }
                            else if(i == 3) {
                                dcp.put("1004002504", pvItems[i]);          // 额定电流
                            }
                            else if(i == 4) {
                                dcp.put("1004002505", pvItems[i]);          // 额定负荷
                            }
                            else if(i == 5) {
                                dcp.put("1004002507", pvItems[i]);          // 单相表接线相
                            }
                            else if(i == 6) {
                                dcp.put("1004002508", pvItems[i]);          // 电源接线方式
                            }
                        }
                    }
                    ci.setDatacellParam(dcp);
                    co.AddCommandItem(ci);
                }
                else if(StringUtils.equals(param, "F26")) {
                    // 测量点限值参数
                    CommandItem ci = new CommandItem();
                    ci.setIdentifier("10040026");
                    Map<String, String> dcp = new HashMap<String, String>();
                    if(StringUtils.isNotBlank(value)) {
                        String[] pvItems = value.split(";");
                        for(int i = 0; i < pvItems.length; i++) {
                            if(i == 0) {
                                dcp.put("1004002601", pvItems[i]);          // 电压合格上限
                            }
                            else if(i == 1) {
                                dcp.put("1004002602", pvItems[i]);          // 电压合格下限
                            }
                            else if(i == 2) {
                                dcp.put("1004002603", pvItems[i]);          // 电压断相门限
                            }
                            else if(i == 3) {
                                dcp.put("1004002604", pvItems[i]);          // 电压上上限（过压门限）
                            }
                            else if(i == 4) {
                                dcp.put("1004002605", pvItems[i]);          // 越限持续时间
                            }
                            else if(i == 5) {
                                dcp.put("1004002606", pvItems[i]);          // 越限恢复系数
                            }
                            else if(i == 6) {
                                dcp.put("1004002607", pvItems[i]);          // 电压下下限（欠压门限）
                            }
                            else if(i == 7) {
                                dcp.put("1004002608", pvItems[i]);          // 
                            }
                            else if(i == 8) {
                                dcp.put("1004002609", pvItems[i]);          // 
                            }
                            else if(i == 9) {
                                dcp.put("1004002610", pvItems[i]);          // 
                            }
                            else if(i == 10) {
                                dcp.put("1004002611", pvItems[i]);          // 
                            }
                            else if(i == 11) {
                                dcp.put("1004002612", pvItems[i]);          // 
                            }
                            else if(i == 12) {
                                dcp.put("1004002613", pvItems[i]);          // 
                            }
                            else if(i == 13) {
                                dcp.put("1004002614", pvItems[i]);          // 
                            }
                            else if(i == 14) {
                                dcp.put("1004002615", pvItems[i]);          // 
                            }
                            else if(i == 15) {
                                dcp.put("1004002616", pvItems[i]);          // 
                            }
                            else if(i == 16) {
                                dcp.put("1004002617", pvItems[i]);          // 
                            }
                            else if(i == 17) {
                                dcp.put("1004002618", pvItems[i]);          // 
                            }
                            else if(i == 18) {
                                dcp.put("1004002619", pvItems[i]);          // 
                            }
                            else if(i == 19) {
                                dcp.put("1004002620", pvItems[i]);          // 
                            }
                            else if(i == 20) {
                                dcp.put("1004002621", pvItems[i]);          // 
                            }
                            else if(i == 21) {
                                dcp.put("1004002622", pvItems[i]);          // 
                            }
                            else if(i == 22) {
                                dcp.put("1004002623", pvItems[i]);          // 
                            }
                            else if(i == 23) {
                                dcp.put("1004002624", pvItems[i]);          // 
                            }
                            else if(i == 24) {
                                dcp.put("1004002625", pvItems[i]);          // 
                            }
                            else if(i == 25) {
                                dcp.put("1004002626", pvItems[i]);          // 
                            }
                            else if(i == 26) {
                                dcp.put("1004002627", pvItems[i]);          // 
                            }
                            else if(i == 27) {
                                dcp.put("1004002628", pvItems[i]);          // 
                            }
                            else if(i == 28) {
                                dcp.put("1004002629", pvItems[i]);          // 
                            }
                            else if(i == 29) {
                                dcp.put("1004002630", pvItems[i]);          // 
                            }
                            else if(i == 30) {
                                dcp.put("1004002631", pvItems[i]);          // 
                            }
                        }
                    }
                    ci.setDatacellParam(dcp);
                    co.AddCommandItem(ci);
                }
            }
            else if(StringUtils.equals(action, "read") && terminal != null) {
                if(StringUtils.equals(param, "F25")) {
                    // 测量点基本参数
                    CommandItem ci = new CommandItem();
                    ci.setIdentifier("10040025");
                    co.AddCommandItem(ci);
                }
                else if(StringUtils.equals(param, "F26")) {
                    // 测量点限值参数
                    CommandItem ci = new CommandItem();
                    ci.setIdentifier("10040026");
                    co.AddCommandItem(ci);
                }
            }
            coList.add(co);
            mto.setCollectObjects(coList);
            setMto376(mto);
        }
        else if(StringUtils.equals(type, TYPE_ANALOGUE_PARAMETER)) {
            // 模拟量参数
            Long termId = Long.parseLong(soTermId);
            try {
                terminal = termService.getById(TerminalMapper.class, termId);
            }
            catch(ServiceException _se) {
                logger.error("send error", _se);
            }

            MTO_376 mto = new MTO_376();
            List<CollectObject> coList = new ArrayList<CollectObject>();
            CollectObject co = new CollectObject();
            co.setLogicalAddr(terminal.getLogicalAddr());
            co.setEquipProtocol(terminal.getProtocolNo());
            co.setChannelType(terminal.getChannelType());
            co.setPwAlgorith("0");
            co.setPwContent("8888");
            co.setMpExpressMode(3);
            int[] mpSn = new int[1];
            mpSn[0] = port;
            co.setMpSn(mpSn);

            int p = paramsAndValues.indexOf(":");
            int q = paramsAndValues.indexOf("||");
            String param = paramsAndValues.substring(0, p);
            String value = paramsAndValues.substring(p + 1, q);
            logger.info("param : " + param);
            logger.info("value : " + value);

            if(StringUtils.equals(action, "write") && terminal != null) {
                if(StringUtils.equals(param, "F81")) {
                    // 直流模拟量变比
                    CommandItem ci = new CommandItem();
                    ci.setIdentifier("10040081");
                    Map<String, String> dcp = new HashMap<String, String>();
                    if(StringUtils.isNotBlank(value)) {
                        String[] pvItems = value.split(";");
                        for(int i = 0; i < pvItems.length; i++) {
                            if(i == 0) {
                                dcp.put("1004008101", pvItems[i]);          // 直流模拟量量程起始值
                            }
                            else if(i == 1) {
                                dcp.put("1004008102", pvItems[i]);          // 直流模拟量量程终止值
                            }
                        }
                    }
                    ci.setDatacellParam(dcp);
                    co.AddCommandItem(ci);
                }
                else if(StringUtils.equals(param, "F82")) {
                    // 直流模拟量限值
                    CommandItem ci = new CommandItem();
                    ci.setIdentifier("10040082");
                    Map<String, String> dcp = new HashMap<String, String>();
                    if(StringUtils.isNotBlank(value)) {
                        String[] pvItems = value.split(";");
                        for(int i = 0; i < pvItems.length; i++) {
                            if(i == 0) {
                                dcp.put("1004008201", pvItems[i]);          // 直流模拟量上限
                            }
                            else if(i == 1) {
                                dcp.put("1004008202", pvItems[i]);          // 直流模拟量下限
                            }
                        }
                    }
                    ci.setDatacellParam(dcp);
                    co.AddCommandItem(ci);
                }
                else if(StringUtils.equals(param, "F83")) {
                    // 直流模拟量冻结参数
                    CommandItem ci = new CommandItem();
                    ci.setIdentifier("10040083");
                    Map<String, String> dcp = new HashMap<String, String>();
                    if(StringUtils.isNotBlank(value)) {
                        String[] pvItems = value.split(";");
                        for(int i = 0; i < pvItems.length; i++) {
                            if(i == 0) {
                                dcp.put("1004008301", pvItems[i]);          // 直流模拟量冻结密度
                            }
                        }
                    }
                    ci.setDatacellParam(dcp);
                    co.AddCommandItem(ci);
                }
            }
            else if(StringUtils.equals(action, "read") && terminal != null) {
                if(StringUtils.equals(param, "F81")) {
                    // 直流模拟量变比
                    CommandItem ci = new CommandItem();
                    ci.setIdentifier("10040081");
                    co.AddCommandItem(ci);
                }
                else if(StringUtils.equals(param, "F82")) {
                    // 直流模拟量限值
                    CommandItem ci = new CommandItem();
                    ci.setIdentifier("10040082");
                    co.AddCommandItem(ci);
                }
                else if(StringUtils.equals(param, "F83")) {
                    // 直流模拟量冻结参数
                    CommandItem ci = new CommandItem();
                    ci.setIdentifier("10040083");
                    co.AddCommandItem(ci);
                }
            }
            coList.add(co);
            mto.setCollectObjects(coList);
            setMto376(mto);
        }
    }

    @Override
    public void beforeReceive() {
        logger.info("taskId             : " + taskId);
        logger.info("type               : " + type);
        logger.info("action             : " + action);
        logger.info("paramsAndValues    : " + paramsAndValues);
    }

    @Override
    public void afterSend() throws ActionException {
        // TODO Auto-generated method stub
        super.afterSend();
    }

    @SuppressWarnings("rawtypes")
    @Override
    public void afterReceive() throws ActionException {
        if(resultMap != null && !resultMap.isEmpty()) {
            logger.info("resultMap : " + resultMap.toString());
            Iterator<?> iterator = resultMap.keySet().iterator();
            if(iterator != null && iterator.hasNext()) {
                Object key = iterator.next();
                Object value = resultMap.get(key);
                //logger.info("receive result [" + key.toString() + ":" + value.toString() + "]");
                String p = null;
                String r = null;
                Map<String, String> m = new HashMap<String, String>();
                if(StringUtils.equals(type, TYPE_TERMINAL_PARAMETER)) {
                    // 集中器参数
                    if(StringUtils.equals(action, "write")) {
                        // 设置
                        if(key instanceof String) {
                            logger.info(key.toString());
                            String[] ks = ((String) key).split("#");
                            if(ks.length == 3) {
                                p = ks[2];
                            }
                        }

                        if(value instanceof String) {
                            logger.info(value.toString());
                            if(StringUtils.equals(p, "10040001")) {
                                p = "F1";
                                r = (String) value;
                            }
                            else if(StringUtils.equals(p, "10040003")) {
                                p = "F3";
                                r = (String) value;
                            }
                            else if(StringUtils.equals(p, "10040012")) {
                                p = "F12";
                                r = (String) value;
                            }
                            else if(StringUtils.equals(p, "10040061")) {
                                p = "F61";
                                r = (String) value;
                            }
                        }
                    }
                    else if(StringUtils.equals(action, "read")) {
                        // 读取
                        if(key instanceof String) {
                            logger.info(key.toString());
                            String[] ks = ((String) key).split("#");
                            if(ks.length == 3) {
                                p = ks[2];
                            }
                        }

                        if(value instanceof Map) {
                            logger.info(value.toString());
                            if(StringUtils.equals(p, "10040001")) {
                                p = "F1";
                                Object r1 = ((Map) value).get("1004000101");        // 终端数传机延时时间RTS
                                Object r2 = ((Map) value).get("1004000102");        // 终端作为启动站允许发送传输延时时间
                                Object r3 = ((Map) value).get("1004000103");        // 终端等待从动站响应的超时时间
                                Object r4 = ((Map) value).get("1004000104");        // 终端等待从动站响应的重发次数
                                Object r6 = ((Map) value).get("1004000106");        // 需要主站确认的通信服务（CON=1）的标志
                                Object r7 = ((Map) value).get("1004000107");        // 心跳周期
                                r = r1.toString() + ";" + r2.toString() + ";" + r3.toString() + ";" + r4.toString() + ";" + r6.toString() + ";" + r7.toString() + ";";
                            }
                            else if(StringUtils.equals(p, "10040003")) {
                                p = "F3";
                                Object r1 = ((Map) value).get("1004000301");        // 主用IP地址和端口
                                Object r2 = ((Map) value).get("1004000302");        // 备用IP地址和端口
                                Object r3 = ((Map) value).get("1004000303");        // APN
                                r = r1.toString() + ";" + r2.toString() + ";" + r3.toString() + ";";
                            }
                            else if(StringUtils.equals(p, "10040012")) {
                                p = "F12";
                                Object r1 = ((Map) value).get("1004001201");        // 状态量接入标志位
                                Object r2 = ((Map) value).get("1004001202");        // 状态量属性标志位
                                r = r1.toString() + ";" + r2.toString() + ";";
                            }
                            else if(StringUtils.equals(p, "10040061")) {
                                p = "F61";
                                Object r1 = ((Map) value).get("1004006101");        // 直流模拟量接入标志位
                                r = r1.toString() + ";";
                            }
                        }

                        if(StringUtils.isNotBlank(p) && StringUtils.isNotBlank(r)) {
                            m.put("P_CODE", p);
                            m.put("OP_RESULT", r);
                            responseJson(m);
                        }
                        else {
                            responseText("......");
                        }
                    }
                }
                else if(StringUtils.equals(type, TYPE_GATHERPOINT_PARAMETER)) {
                    // 测量点参数
                    if(StringUtils.equals(action, "write")) {
                        // 设置
                        if(key instanceof String) {
                            logger.info(key.toString());
                            String[] ks = ((String) key).split("#");
                            if(ks.length == 3) {
                                p = ks[2];
                            }
                        }

                        if(value instanceof String) {
                            logger.info(value.toString());
                            if(StringUtils.equals(p, "10040025")) {
                                p = "F25";
                                r = (String) value;
                            }
                            else if(StringUtils.equals(p, "10040026")) {
                                p = "F26";
                                r = (String) value;
                            }
                        }
                    }
                    else if(StringUtils.equals(action, "read")) {
                        // 读取
                        if(key instanceof String) {
                            logger.info(key.toString());
                            String[] ks = ((String) key).split("#");
                            if(ks.length == 3) {
                                p = ks[2];
                            }
                        }

                        if(value instanceof Map) {
                            logger.info(value.toString());
                            if(StringUtils.equals(p, "10040025")) {
                                p = "F25";
                                Object r1 = ((Map) value).get("1004002501");        // 电压互感器倍率
                                Object r2 = ((Map) value).get("1004002502");        // 电流互感器倍率
                                Object r3 = ((Map) value).get("1004002503");        // 额定电压
                                Object r4 = ((Map) value).get("1004002504");        // 额定电流
                                Object r5 = ((Map) value).get("1004002505");        // 额定负荷
                                Object r7 = ((Map) value).get("1004002507");        // 单相表接线相
                                Object r8 = ((Map) value).get("1004002508");        // 电源接线方式
                                r = r1.toString() + ";" + r2.toString() + ";" + r3.toString() + ";" + r4.toString() + ";" + r5.toString() + ";" + r7.toString() + ";" + r8.toString() + ";";
                            }
                            else if(StringUtils.equals(p, "10040026")) {
                                p = "F26";
                                Object r1 = ((Map) value).get("1004002601");        // 
                                Object r2 = ((Map) value).get("1004002602");        // 
                                Object r3 = ((Map) value).get("1004002603");        // 
                                Object r4 = ((Map) value).get("1004002604");        // 
                                Object r5 = ((Map) value).get("1004002605");        // 
                                Object r6 = ((Map) value).get("1004002606");        // 
                                Object r7 = ((Map) value).get("1004002607");        // 
                                Object r8 = ((Map) value).get("1004002608");        // 
                                Object r9 = ((Map) value).get("1004002609");        // 
                                Object r10 = ((Map) value).get("1004002610");       // 
                                Object r11 = ((Map) value).get("1004002611");       // 
                                Object r12 = ((Map) value).get("1004002612");       // 
                                Object r13 = ((Map) value).get("1004002613");       // 
                                Object r14 = ((Map) value).get("1004002614");       // 
                                Object r15 = ((Map) value).get("1004002615");       // 
                                Object r16 = ((Map) value).get("1004002616");       // 
                                Object r17 = ((Map) value).get("1004002617");       // 
                                Object r18 = ((Map) value).get("1004002618");       // 
                                Object r19 = ((Map) value).get("1004002619");       // 
                                Object r20 = ((Map) value).get("1004002620");       // 
                                Object r21 = ((Map) value).get("1004002621");       // 
                                Object r22 = ((Map) value).get("1004002622");       // 
                                Object r23 = ((Map) value).get("1004002623");       // 
                                Object r24 = ((Map) value).get("1004002624");       // 
                                Object r25 = ((Map) value).get("1004002625");       // 
                                Object r26 = ((Map) value).get("1004002626");       // 
                                Object r27 = ((Map) value).get("1004002627");       // 
                                Object r28 = ((Map) value).get("1004002628");       // 
                                Object r29 = ((Map) value).get("1004002629");       // 
                                Object r30 = ((Map) value).get("1004002630");       // 
                                r = r1.toString() + ";" + r2.toString() + ";" + r3.toString() + ";" + r4.toString() + ";" + r5.toString() + ";";
                                r += r6.toString() + ";" + r7.toString() + ";" + r8.toString() + ";" + r9.toString() + ";" + r10.toString() + ";";
                                r += r11.toString() + ";" + r12.toString() + ";" + r13.toString() + ";" + r14.toString() + ";" + r15.toString() + ";";
                                r += r16.toString() + ";" + r17.toString() + ";" + r18.toString() + ";" + r19.toString() + ";" + r20.toString() + ";";
                                r += r21.toString() + ";" + r22.toString() + ";" + r23.toString() + ";" + r24.toString() + ";" + r25.toString() + ";";
                                r += r26.toString() + ";" + r27.toString() + ";" + r28.toString() + ";" + r29.toString() + ";" + r30.toString() + ";";
                            }
                        }

                        if(StringUtils.isNotBlank(p) && StringUtils.isNotBlank(r)) {
                            m.put("P_CODE", p);
                            m.put("OP_RESULT", r);
                            responseJson(m);
                        }
                        else {
                            responseText("......");
                        }
                    }
                }
                else if(StringUtils.equals(type, TYPE_ANALOGUE_PARAMETER)) {
                    // 模拟量参数
                    if(StringUtils.equals(action, "write")) {
                        // 设置
                        if(key instanceof String) {
                            logger.info(key.toString());
                            String[] ks = ((String) key).split("#");
                            if(ks.length == 3) {
                                p = ks[2];
                            }
                        }

                        if(value instanceof String) {
                            logger.info(value.toString());
                            if(StringUtils.equals(p, "10040081")) {
                                p = "F81";
                                r = (String) value;
                            }
                            else if(StringUtils.equals(p, "10040082")) {
                                p = "F82";
                                r = (String) value;
                            }
                            else if(StringUtils.equals(p, "10040083")) {
                                p = "F83";
                                r = (String) value;
                            }
                        }
                    }
                    else if(StringUtils.equals(action, "read")) {
                        // 读取
                        if(key instanceof String) {
                            logger.info(key.toString());
                            String[] ks = ((String) key).split("#");
                            if(ks.length == 3) {
                                p = ks[2];
                            }
                        }

                        if(value instanceof Map) {
                            logger.info(value.toString());
                            if(StringUtils.equals(p, "10040081")) {
                                p = "F81";
                                Object r1 = ((Map) value).get("1004008101");        // 直流模拟量量程起始值
                                Object r2 = ((Map) value).get("1004008102");        // 直流模拟量量程终止值
                                r = r1.toString() + ";" + r2.toString() + ";";
                            }
                            else if(StringUtils.equals(p, "10040082")) {
                                p = "F82";
                                Object r1 = ((Map) value).get("1004008201");        // 直流模拟量上限
                                Object r2 = ((Map) value).get("1004008202");        // 直流模拟量下限
                                r = r1.toString() + ";" + r2.toString() + ";";
                            }
                            else if(StringUtils.equals(p, "10040083")) {
                                p = "F83";
                                Object r1 = ((Map) value).get("1004008301");        // 直流模拟量冻结密度
                                r = r1.toString() + ";";
                            }
                        }

                        if(StringUtils.isNotBlank(p) && StringUtils.isNotBlank(r)) {
                            m.put("P_CODE", p);
                            m.put("OP_RESULT", r);
                            responseJson(m);
                        }
                        else {
                            responseText("......");
                        }
                    }
                }
                //responseText(value.toString());
            }
            else {
                responseText("......");
            }
        }
        else {
            responseText("......");
        }
    }

    /**
     * 
     * @throws ActionException
     */
    public void loadTermParamsValuesByTermId() throws ActionException {
        String stermid = request.getParameter("termId");
        List<Map<String, Object>> pvList = new ArrayList<Map<String, Object>>();
        if(StringUtils.isNotBlank(stermid)) {
            Long termId = Long.parseLong(stermid);
            logger.info("termId : " + termId);

            Map<String, Object> pv1 = new HashMap<String, Object>();
            pv1.put("P_CODE", "F1");
            pv1.put("P_VALUE", "1;1;10;5;00100000;30;");                                // 01;02;03;04;06;07;
            pvList.add(pv1);

            Map<String, Object> pv3 = new HashMap<String, Object>();
            pv3.put("P_CODE", "F3");
            pv3.put("P_VALUE", "183.129.186.78:10086;183.129.186.78:10086;CMNET;");     // 01;02;03;
            pvList.add(pv3);

            Map<String, Object> pv12 = new HashMap<String, Object>();
            pv12.put("P_CODE", "F12");
            pv12.put("P_VALUE", "11111111;00000000;");                                  // 01;02;
            pvList.add(pv12);

            Map<String, Object> pv61 = new HashMap<String, Object>();
            pv61.put("P_CODE", "F61");
            pv61.put("P_VALUE", "11111111;");                                           // 01;
            pvList.add(pv61);
        }

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("records", pvList);
        responseJson(result);
    }

    /**
     * 
     * @throws ActionException
     */
    public void loadGpParamsValuesByTermId() throws ActionException {
        String stermid = request.getParameter("termId");
        String sgpsn = request.getParameter("gpSn");
        List<Map<String, Object>> pvList = new ArrayList<Map<String, Object>>();
        if(StringUtils.isNotBlank(stermid)) {
            Long termId = Long.parseLong(stermid);
            Integer gpSn = Integer.parseInt(sgpsn);
            logger.info("termId : " + termId);
            logger.info("gpSn   : " + gpSn);

            Map<String, Object> pv25 = new HashMap<String, Object>();
            pv25.put("P_CODE", "F25");
            pv25.put("P_VALUE", "1;1;220.0;5.0;50.0000;00;00;");                        // 01;02;03;04;05;07;08;
            pvList.add(pv25);

            Map<String, Object> pv26 = new HashMap<String, Object>();
            pv26.put("P_CODE", "F26");
            pv26.put("P_VALUE", "300.00;150.00;100.00;360.00;10;150.00;120.00;10;50.0;8.000;10;120.00;6.000;10;110.00;2.000;10;120.00;60.0000;10;150.00;50.0000;10;120.00;120.00;10;120.00;120.00;10;120.00;20;");
            pvList.add(pv26);
        }

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("records", pvList);
        responseJson(result);
    }

    /**
     * 
     * @throws ActionException
     */
    public void loadAgParamsValuesByTermId() throws ActionException {
        String stermid = request.getParameter("termId");
        String port = request.getParameter("port");
        List<Map<String, Object>> pvList = new ArrayList<Map<String, Object>>();
        if(StringUtils.isNotBlank(stermid)) {
            Long termId = Long.parseLong(stermid);
            logger.info("termId : " + termId);
            logger.info("port   : " + port);

            Map<String, Object> pv81 = new HashMap<String, Object>();
            pv81.put("P_CODE", "F81");
            pv81.put("P_VALUE", "0.00;200.00;");                            // 01;02;
            pvList.add(pv81);

            Map<String, Object> pv82 = new HashMap<String, Object>();
            pv82.put("P_CODE", "F82");
            pv82.put("P_VALUE", "0.00;50.00;");                             // 01;02;
            pvList.add(pv82);

            Map<String, Object> pv83 = new HashMap<String, Object>();
            pv83.put("P_CODE", "F83");
            pv83.put("P_VALUE", "2;");                                      // 01;
            pvList.add(pv83);
        }

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("records", pvList);
        responseJson(result);
    }

    public Integer getGpSn() {
        return gpSn;
    }

    public void setGpSn(Integer gpSn) {
        this.gpSn = gpSn;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

}
