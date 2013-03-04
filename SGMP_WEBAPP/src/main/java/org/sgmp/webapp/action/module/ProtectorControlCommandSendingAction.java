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
 * 保护器控制命令下发
 * 
 * @author Nick
 *
 */
@Component
public class ProtectorControlCommandSendingAction extends AbstractSimpleInteractionAction {

    /**
     * 
     */
    private static final long serialVersionUID = 288101067967162582L;

    private static final Logger logger = LoggerFactory.getLogger(ProtectorControlCommandSendingAction.class);

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
        cot.setFuncode((byte) 27);
        cot.setPort((byte) Integer.parseInt(psInfo.getPort()));
        SerialPortPara spp = new SerialPortPara();
        try {
            //spp.setBaudrate(Integer.toBinaryString(Integer.parseInt(psInfo.getBaudrate())));
            String baudrate = psInfo.getBaudrate();
            if(StringUtils.equals(baudrate, "0")) {
                spp.setBaudrate("000");
            }
            else if(StringUtils.equals(baudrate, "1")) {
                spp.setBaudrate("001");
            }
            else if(StringUtils.equals(baudrate, "2")) {
                spp.setBaudrate("010");
            }
            else if(StringUtils.equals(baudrate, "3")) {
                spp.setBaudrate("011");
            }
            else if(StringUtils.equals(baudrate, "4")) {
                spp.setBaudrate("100");
            }
            else if(StringUtils.equals(baudrate, "5")) {
                spp.setBaudrate("101");
            }
            else if(StringUtils.equals(baudrate, "6")) {
                spp.setBaudrate("110");
            }
            else if(StringUtils.equals(baudrate, "7")) {
                spp.setBaudrate("111");
            }
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
            if(StringUtils.equals(param, "0710")) {
                // 预约远程分断控制
                CommandItem ci = new CommandItem();
                ci.setIdentifier("80000710");
                Map<String, String> dcp = new HashMap<String, String>();
                if(StringUtils.isNotBlank(value)) {
                    String[] pvItems = value.split(";");
                    for(int i = 0; i < pvItems.length; i++) {
                        if(i == 0) {
                            dcp.put("0710", pvItems[i]);
                        }
                    }
                }
                ci.setDatacellParam(dcp);
                ciList.add(ci);
            }
            else if(StringUtils.equals(param, "0711")) {
                // 取消远程分断控制
                CommandItem ci = new CommandItem();
                ci.setIdentifier("80000711");
                ciList.add(ci);
            }
            else if(StringUtils.equals(param, "0720")) {
                // 预约远程合闸控制
                CommandItem ci = new CommandItem();
                ci.setIdentifier("80000720");
                Map<String, String> dcp = new HashMap<String, String>();
                if(StringUtils.isNotBlank(value)) {
                    String[] pvItems = value.split(";");
                    for(int i = 0; i < pvItems.length; i++) {
                        if(i == 0) {
                            dcp.put("0720", pvItems[i]);
                        }
                    }
                }
                ci.setDatacellParam(dcp);
                ciList.add(ci);
            }
            else if(StringUtils.equals(param, "0721")) {
                // 取消远程合闸控制
                CommandItem ci = new CommandItem();
                ci.setIdentifier("80000721");
                ciList.add(ci);
            }
            else if(StringUtils.equals(param, "0730")) {
                // 预约模拟试跳控制
                CommandItem ci = new CommandItem();
                ci.setIdentifier("80000730");
                Map<String, String> dcp = new HashMap<String, String>();
                if(StringUtils.isNotBlank(value)) {
                    String[] pvItems = value.split(";");
                    for(int i = 0; i < pvItems.length; i++) {
                        if(i == 0) {
                            dcp.put("0730", pvItems[i]);
                        }
                    }
                }
                ci.setDatacellParam(dcp);
                ciList.add(ci);
            }
            else if(StringUtils.equals(param, "0731")) {
                // 取消模拟试跳控制
                CommandItem ci = new CommandItem();
                ci.setIdentifier("80000731");
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

                if(key instanceof String) {
                    logger.info(key.toString());
                    String[] ks = ((String) key).split("#");
                    if(ks.length == 3) {
                        p = ks[2];
                    }
                }

                if(value instanceof String) {
                    logger.info(value.toString());
                    if(StringUtils.equals(p, "80000710")) {
                        p = "0710";
                        r = (String) value;
                    }
                    else if(StringUtils.equals(p, "80000711")) {
                        p = "0711";
                        r = (String) value;
                    }
                    else if(StringUtils.equals(p, "80000720")) {
                        p = "0720";
                        r = (String) value;
                    }
                    else if(StringUtils.equals(p, "80000721")) {
                        p = "0721";
                        r = (String) value;
                    }
                    else if(StringUtils.equals(p, "80000730")) {
                        p = "0730";
                        r = (String) value;
                    }
                    else if(StringUtils.equals(p, "80000731")) {
                        p = "0731";
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

            Map<String, Object> pv10 = new HashMap<String, Object>();
            pv10.put("P_CODE", "0710");
            pv10.put("P_VALUE", "0200;");
            pvList.add(pv10);

            Map<String, Object> pv20 = new HashMap<String, Object>();
            pv20.put("P_CODE", "0720");
            pv20.put("P_VALUE", "0200;");
            pvList.add(pv20);

            Map<String, Object> pv30 = new HashMap<String, Object>();
            pv30.put("P_CODE", "0730");
            pv30.put("P_VALUE", "0200;");
            pvList.add(pv30);
        }

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("records", pvList);
        responseJson(result);
    }

}
