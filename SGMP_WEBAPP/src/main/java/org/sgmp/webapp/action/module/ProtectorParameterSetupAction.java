package org.sgmp.webapp.action.module;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.sgmp.webapp.ActionException;
import org.sgmp.webapp.ServiceException;
import org.sgmp.webapp.mapper.module.ProtectorInfoQueryMapper;
import org.sgmp.webapp.mapper.module.TerminalMapper;
import org.sgmp.webapp.pojo.module.ProtectorInfo;
import org.sgmp.webapp.pojo.module.Terminal;
import org.sgmp.webapp.service.module.SimpleCURDService;
import org.sgmp.webapp.service.module.SimpleQueryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fep.bp.realinterface.mto.CollectObject_TransMit;
import fep.bp.realinterface.mto.CommandItem;
import fep.bp.realinterface.mto.MTO_376;
import fep.bp.utils.SerialPortPara;
import fep.common.exception.BPException;

/**
 * 保护器参数设置
 * 
 * @author Nick
 *
 */
@Component
public class ProtectorParameterSetupAction extends AbstractSimpleInteractionAction {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 5599841793997443814L;

    private static final Logger logger = LoggerFactory.getLogger(ProtectorParameterSetupAction.class);

    @Autowired
    private SimpleCURDService<Terminal> termService;
    @Autowired
    private SimpleQueryService simpleQueryService;

    private Terminal terminal;
    private ProtectorInfo psInfo;

    @SuppressWarnings("unchecked")
    @Override
    public void beforeSend() throws ActionException {
        logger.info("soType             : " + soType);
        logger.info("soId               : " + soId);
        logger.info("soName             : " + soName);
        logger.info("soOrgId            : " + soOrgId);
        logger.info("soTgId             : " + soTgId);
        logger.info("soTermId           : " + soTermId);
        logger.info("soGpId             : " + soGpId);
        logger.info("type               : " + type);
        logger.info("action             : " + action);
        logger.info("paramsAndValues    : " + paramsAndValues);

        Long gpId = Long.parseLong(soGpId);
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("gpId", gpId);
        try {
            List<ProtectorInfo> psInfoList = (List<ProtectorInfo>) simpleQueryService.getList(ProtectorInfoQueryMapper.class, params, "0", String.valueOf(Integer.MAX_VALUE), null, null);
            if(psInfoList != null && psInfoList.size() > 0) {
                psInfo = psInfoList.get(0);
            }
        }
        catch(ServiceException _se) {
            logger.error("send error", _se);
        }

        try {
            terminal = termService.getById(TerminalMapper.class, psInfo.getTermId());
        }
        catch(ServiceException _se) {
            logger.error("send error", _se);
        }

        MTO_376 mto = new MTO_376();
        List<CollectObject_TransMit> cotList = new ArrayList<CollectObject_TransMit>();
        CollectObject_TransMit cot = new CollectObject_TransMit();
        cot.setTerminalAddr(terminal.getLogicalAddr());
        cot.setEquipProtocol(terminal.getProtocolNo());
        cot.setMeterAddr(psInfo.getGpAddr());
        cot.setMeterProtocol(psInfo.getProtocolNo());
        cot.setMeterType(Integer.parseInt(psInfo.getProtocolNo()));
        if(StringUtils.equals(action, "write")) {
            cot.setFuncode((byte) 04);
        }
        else if(StringUtils.equals(action, "read")) {
            cot.setFuncode((byte) 01);
        }
        cot.setPort((byte) Integer.parseInt(psInfo.getPort()));
        SerialPortPara spp = new SerialPortPara();
        try {
            spp.setBaudrate(Integer.toBinaryString(Integer.parseInt(psInfo.getBaudrate())));
            spp.setStopbit(1);
            spp.setCheckbit(1);
            spp.setOdd_even_bit(0);
            spp.setDatabit(8);
        }
        catch(BPException _bpe) {
            logger.error("send error", _bpe);
        }
        cot.setSerialPortPara(spp);
        try {
            cot.setWaitforPacket((byte) 10);
            cot.setWaitforByte((byte) 5);
        }
        catch(BPException _bpe) {
            logger.error("send error", _bpe);
        }

        int p = paramsAndValues.indexOf(":");
        int q = paramsAndValues.indexOf("||");
        String param = paramsAndValues.substring(0, p);
        String value = paramsAndValues.substring(p + 1, q);
        logger.info("param : " + param);
        logger.info("value : " + value);

        List<CommandItem> ciList = new ArrayList<CommandItem>();
        if(StringUtils.equals(action, "write") && terminal != null) {
            if(StringUtils.equals(param, "011F")) {
                // 设备控制字
                CommandItem ci = new CommandItem();
                ci.setIdentifier("8000011F");
                Map<String, String> dcp = new HashMap<String, String>();
                if(StringUtils.isNotBlank(value)) {
                    String[] pvItems = value.split(";");
                    for(int i = 0; i < pvItems.length; i++) {
                        if(i == 0) {
                            dcp.put("011F01", pvItems[i]);
                        }
                        else if(i == 1) {
                            dcp.put("011F02", pvItems[i]);
                        }
                        else if(i == 2) {
                            dcp.put("011F03", pvItems[i]);
                        }
                        else if(i == 3) {
                            dcp.put("011F04", pvItems[i]);
                        }
                        else if(i == 4) {
                            dcp.put("011F05", pvItems[i]);
                        }
                        else if(i == 5) {
                            dcp.put("011F06", pvItems[i]);
                        }
                        else if(i == 6) {
                            dcp.put("011F07", pvItems[i]);
                        }
                        else if(i == 7) {
                            dcp.put("011F09", pvItems[i]);
                        }
                        else if(i == 8) {
                            dcp.put("011F10", pvItems[i]);
                        }
                        else if(i == 9) {
                            dcp.put("011F11", pvItems[i]);
                        }
                        else if(i == 10) {
                            dcp.put("011F12", pvItems[i]);
                        }
                        else if(i == 11) {
                            dcp.put("011F13", pvItems[i]);
                        }
                        else if(i == 12) {
                            dcp.put("011F14", pvItems[i]);
                        }
                        else if(i == 13) {
                            dcp.put("011F15", pvItems[i]);
                        }
                        else if(i == 14) {
                            dcp.put("011F16", pvItems[i]);
                        }
                        else if(i == 15) {
                            dcp.put("011F18", pvItems[i]);
                        }
                        else if(i == 16) {
                            dcp.put("011F19", pvItems[i]);
                        }
                        else if(i == 17) {
                            dcp.put("011F20", pvItems[i]);
                        }
                        else if(i == 18) {
                            dcp.put("011F21", pvItems[i]);
                        }
                        else if(i == 19) {
                            dcp.put("011F22", pvItems[i]);
                        }
                        else if(i == 20) {
                            dcp.put("011F23", pvItems[i]);
                        }
                        else if(i == 21) {
                            dcp.put("011F24", pvItems[i]);
                        }
                        else if(i == 22) {
                            dcp.put("011F25", pvItems[i]);
                        }
                        else if(i == 23) {
                            dcp.put("011F26", pvItems[i]);
                        }
                    }
                }
                ci.setDatacellParam(dcp);
                ciList.add(ci);
            }
            else if(StringUtils.equals(param, "0121")) {
                // 漏电流超限报警值
                CommandItem ci = new CommandItem();
                ci.setIdentifier("80000121");
                Map<String, String> dcp = new HashMap<String, String>();
                if(StringUtils.isNotBlank(value)) {
                    String[] pvItems = value.split(";");
                    for(int i = 0; i < pvItems.length; i++) {
                        if(i == 0) {
                            dcp.put("012101", pvItems[i]);
                        }
                    }
                }
                ci.setDatacellParam(dcp);
                ciList.add(ci);
            }
            else if(StringUtils.equals(param, "0151")) {
                // 过压超限电压值
                CommandItem ci = new CommandItem();
                ci.setIdentifier("80000151");
                Map<String, String> dcp = new HashMap<String, String>();
                if(StringUtils.isNotBlank(value)) {
                    String[] pvItems = value.split(";");
                    for(int i = 0; i < pvItems.length; i++) {
                        if(i == 0) {
                            dcp.put("015F01", pvItems[i]);
                        }
                    }
                }
                ci.setDatacellParam(dcp);
                ciList.add(ci);
            }
            else if(StringUtils.equals(param, "0152")) {
                // 欠压超限欠压值
                CommandItem ci = new CommandItem();
                ci.setIdentifier("80000152");
                Map<String, String> dcp = new HashMap<String, String>();
                if(StringUtils.isNotBlank(value)) {
                    String[] pvItems = value.split(";");
                    for(int i = 0; i < pvItems.length; i++) {
                        if(i == 0) {
                            dcp.put("015F02", pvItems[i]);
                        }
                    }
                }
                ci.setDatacellParam(dcp);
                ciList.add(ci);
            }
            else if(StringUtils.equals(param, "0153")) {
                // 缺相超限电压值
                CommandItem ci = new CommandItem();
                ci.setIdentifier("80000153");
                Map<String, String> dcp = new HashMap<String, String>();
                if(StringUtils.isNotBlank(value)) {
                    String[] pvItems = value.split(";");
                    for(int i = 0; i < pvItems.length; i++) {
                        if(i == 0) {
                            dcp.put("015F03", pvItems[i]);
                        }
                    }
                }
                ci.setDatacellParam(dcp);
                ciList.add(ci);
            }
            else if(StringUtils.equals(param, "0161")) {
                // 电流超限告警值
                CommandItem ci = new CommandItem();
                ci.setIdentifier("80000161");
                Map<String, String> dcp = new HashMap<String, String>();
                if(StringUtils.isNotBlank(value)) {
                    String[] pvItems = value.split(";");
                    for(int i = 0; i < pvItems.length; i++) {
                        if(i == 0) {
                            dcp.put("016F01", pvItems[i]);
                        }
                    }
                }
                ci.setDatacellParam(dcp);
                ciList.add(ci);
            }
            else if(StringUtils.equals(param, "0162")) {
                // 过载长延时时间
                CommandItem ci = new CommandItem();
                ci.setIdentifier("80000162");
                Map<String, String> dcp = new HashMap<String, String>();
                if(StringUtils.isNotBlank(value)) {
                    String[] pvItems = value.split(";");
                    for(int i = 0; i < pvItems.length; i++) {
                        if(i == 0) {
                            dcp.put("016F02", pvItems[i]);
                        }
                    }
                }
                ci.setDatacellParam(dcp);
                ciList.add(ci);
            }
            else if(StringUtils.equals(param, "0163")) {
                // 额定电流
                CommandItem ci = new CommandItem();
                ci.setIdentifier("80000163");
                Map<String, String> dcp = new HashMap<String, String>();
                if(StringUtils.isNotBlank(value)) {
                    String[] pvItems = value.split(";");
                    for(int i = 0; i < pvItems.length; i++) {
                        if(i == 0) {
                            dcp.put("016F03", pvItems[i]);
                        }
                    }
                }
                ci.setDatacellParam(dcp);
                ciList.add(ci);
            }
        }
        else if(StringUtils.equals(action, "read") && terminal != null) {
            if(StringUtils.equals(param, "011F")) {
                // 设备控制字
                CommandItem ci = new CommandItem();
                ci.setIdentifier("8000011F");
                ciList.add(ci);
            }
            else if(StringUtils.equals(param, "0121")) {
                // 漏电流超限报警值
                CommandItem ci = new CommandItem();
                ci.setIdentifier("80000121");
                ciList.add(ci);
            }
            else if(StringUtils.equals(param, "0151")) {
                // 过压超限电压值
                CommandItem ci = new CommandItem();
                ci.setIdentifier("80000151");
                ciList.add(ci);
            }
            else if(StringUtils.equals(param, "0152")) {
                // 欠压超限欠压值
                CommandItem ci = new CommandItem();
                ci.setIdentifier("80000152");
                ciList.add(ci);
            }
            else if(StringUtils.equals(param, "0153")) {
                // 缺相超限电压值
                CommandItem ci = new CommandItem();
                ci.setIdentifier("80000153");
                ciList.add(ci);
            }
            else if(StringUtils.equals(param, "0161")) {
                // 电流超限告警值
                CommandItem ci = new CommandItem();
                ci.setIdentifier("80000161");
                ciList.add(ci);
            }
            else if(StringUtils.equals(param, "0162")) {
                // 过载长延时时间
                CommandItem ci = new CommandItem();
                ci.setIdentifier("80000162");
                ciList.add(ci);
            }
            else if(StringUtils.equals(param, "0163")) {
                // 额定电流
                CommandItem ci = new CommandItem();
                ci.setIdentifier("80000163");
                ciList.add(ci);
            }
        }
        cot.setCommandItems(ciList);
        cotList.add(cot);
        mto.setCollectObjects_Transmit(cotList);
        setMto376(mto);
    }

    @Override
    public void beforeReceive() throws ActionException {
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
                //String key = (String) iterator.next();
                //String value = (String) resultMap.get(key);
                //responseText(value);
                Object key = iterator.next();
                Object value = resultMap.get(key);
                String p = null;
                String r = null;
                Map<String, String> m = new HashMap<String, String>();

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
                        if(StringUtils.equals(p, "8000011F")) {
                            p = "011F";
                            r = (String) value;
                        }
                        else if(StringUtils.equals(p, "80000121")) {
                            p = "0121";
                            r = (String) value;
                        }
                        else if(StringUtils.equals(p, "80000151")) {
                            p = "0151";
                            r = (String) value;
                        }
                        else if(StringUtils.equals(p, "80000152")) {
                            p = "0152";
                            r = (String) value;
                        }
                        else if(StringUtils.equals(p, "80000153")) {
                            p = "0153";
                            r = (String) value;
                        }
                        else if(StringUtils.equals(p, "80000161")) {
                            p = "0161";
                            r = (String) value;
                        }
                        else if(StringUtils.equals(p, "80000162")) {
                            p = "0162";
                            r = (String) value;
                        }
                        else if(StringUtils.equals(p, "80000163")) {
                            p = "0163";
                            r = (String) value;
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
                        if(StringUtils.equals(p, "8000011F")) {
                            p = "011F";
                            Object r1 = ((Map) value).get("011F01");
                            Object r2 = ((Map) value).get("011F02");
                            Object r3 = ((Map) value).get("011F03");
                            Object r4 = ((Map) value).get("011F04");
                            Object r5 = ((Map) value).get("011F05");
                            Object r6 = ((Map) value).get("011F06");
                            Object r7 = ((Map) value).get("011F07");
                            Object r9 = ((Map) value).get("011F09");
                            Object r10 = ((Map) value).get("011F010");
                            Object r11 = ((Map) value).get("011F011");
                            Object r12 = ((Map) value).get("011F012");
                            Object r13 = ((Map) value).get("011F013");
                            Object r14 = ((Map) value).get("011F014");
                            Object r15 = ((Map) value).get("011F015");
                            Object r16 = ((Map) value).get("011F016");
                            Object r18 = ((Map) value).get("011F018");
                            Object r19 = ((Map) value).get("011F019");
                            Object r20 = ((Map) value).get("011F020");
                            Object r21 = ((Map) value).get("011F021");
                            Object r22 = ((Map) value).get("011F022");
                            Object r23 = ((Map) value).get("011F023");
                            Object r24 = ((Map) value).get("011F024");
                            Object r25 = ((Map) value).get("011F025");
                            Object r26 = ((Map) value).get("011F026");
                            r = r1.toString() + ";" + r2.toString() + ";" + r3.toString() + ";" + r4.toString() + ";" + r5.toString() + ";" + r6.toString() + ";" + r7.toString() + ";";
                            r += r9.toString() + ";" + r10.toString() + ";" + r11.toString() + ";" + r12.toString() + ";" + r13.toString() + ";" + r14.toString() + ";" + r15.toString() + ";" + ";" + r16.toString() + ";";
                            r += r18.toString() + ";" + r19.toString() + ";" + r20.toString() + ";" + r21.toString() + ";" + r22.toString() + ";";
                            r += r23.toString() + ";" + r24.toString() + ";" + r25.toString() + ";" + r26.toString() + ";";
                        }
                        else if(StringUtils.equals(p, "80000121")) {
                            p = "0121";
                            Object r1 = ((Map) value).get("012101");
                            r = r1.toString() + ";";
                        }
                        else if(StringUtils.equals(p, "80000151")) {
                            p = "0151";
                            Object r1 = ((Map) value).get("015F01");
                            r = r1.toString() + ";";
                        }
                        else if(StringUtils.equals(p, "80000152")) {
                            p = "0152";
                            Object r1 = ((Map) value).get("015F02");
                            r = r1.toString() + ";";
                        }
                        else if(StringUtils.equals(p, "80000153")) {
                            p = "0153";
                            Object r1 = ((Map) value).get("015F03");
                            r = r1.toString() + ";";
                        }
                        else if(StringUtils.equals(p, "80000161")) {
                            p = "0161";
                            Object r1 = ((Map) value).get("016F01");
                            r = r1.toString() + ";";
                        }
                        else if(StringUtils.equals(p, "80000162")) {
                            p = "0162";
                            Object r1 = ((Map) value).get("016F02");
                            r = r1.toString() + ";";
                        }
                        else if(StringUtils.equals(p, "80000163")) {
                            p = "0163";
                            Object r1 = ((Map) value).get("016F03");
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
    public void loadPsParamsValuesByGpId() throws ActionException {
        String sgpid = request.getParameter("gpId");
        List<Map<String, Object>> pvList = new ArrayList<Map<String, Object>>();
        if(StringUtils.isNotBlank(sgpid)) {
            Long gpId = Long.parseLong(sgpid);
            logger.info("gpId : " + gpId);

            Map<String, Object> pv011F = new HashMap<String, Object>();
            pv011F.put("P_CODE", "011F");
            pv011F.put("P_VALUE", "1;1;1;1;1;1;1;1;1;1;1;1;1;1;1;0;1;1;1;1;01;01;01;10;");              // 01;02;03;04;05;06;07;09;10;11;12;13;14;15;16;18;19;20;21;22;23;24;25;26;
            pvList.add(pv011F);

            Map<String, Object> pv0121 = new HashMap<String, Object>();
            pv0121.put("P_CODE", "0121");
            pv0121.put("P_VALUE", "1000;");
            pvList.add(pv0121);

            Map<String, Object> pv0151 = new HashMap<String, Object>();
            pv0151.put("P_CODE", "0151");
            pv0151.put("P_VALUE", "285;");
            pvList.add(pv0151);

            Map<String, Object> pv0152 = new HashMap<String, Object>();
            pv0152.put("P_CODE", "0152");
            pv0152.put("P_VALUE", "165;");
            pvList.add(pv0152);

            Map<String, Object> pv0153 = new HashMap<String, Object>();
            pv0153.put("P_CODE", "0153");
            pv0153.put("P_VALUE", "120;");
            pvList.add(pv0153);

            Map<String, Object> pv0161 = new HashMap<String, Object>();
            pv0161.put("P_CODE", "0161");
            pv0161.put("P_VALUE", "1;");
            pvList.add(pv0161);

            Map<String, Object> pv0162 = new HashMap<String, Object>();
            pv0162.put("P_CODE", "0162");
            pv0162.put("P_VALUE", "60;");
            pvList.add(pv0162);

            Map<String, Object> pv0163 = new HashMap<String, Object>();
            pv0163.put("P_CODE", "0163");
            pv0163.put("P_VALUE", "100;");
            pvList.add(pv0163);
        }

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("records", pvList);
        responseJson(result);
    }

}
