package org.sgmp.webapp.action.module;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.sgmp.webapp.ActionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import fep.bp.realinterface.mto.CollectObject_TransMit;
import fep.bp.realinterface.mto.CommandItem;
import fep.bp.realinterface.mto.MTO_376;
import fep.bp.utils.BaudRate;
import fep.bp.utils.MeterType;
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

    @Override
    public void beforeSend() throws ActionException {
        logger.info("soType             : " + getSoType());
        logger.info("soId               : " + getSoId());
        logger.info("soName             : " + getSoName());
        logger.info("soOrgId            : " + getSoOrgId());
        logger.info("soTgId             : " + getSoTgId());
        logger.info("soTermId           : " + getSoTermId());
        logger.info("soGpId             : " + getSoGpId());
        logger.info("type               : " + getType());
        logger.info("action             : " + getAction());
        logger.info("paramsAndValues    : " + getParamsAndValues());
        MTO_376 mto = new MTO_376();
        List<CollectObject_TransMit> cotList = new ArrayList<CollectObject_TransMit>();
        CollectObject_TransMit cot = new CollectObject_TransMit();
        if(StringUtils.equals(getSoGpId(), "11") || StringUtils.equals(getSoGpId(), "12") 
                || StringUtils.equals(getSoGpId(), "13") || StringUtils.equals(getSoGpId(), "14") 
                || StringUtils.equals(getSoGpId(), "15") || StringUtils.equals(getSoGpId(), "16")) {
            cot.setTerminalAddr("96123456");
            if(StringUtils.equals(getSoGpId(), "11")) {
                cot.setMeterAddr("000000000001");
            }
            else if(StringUtils.equals(getSoGpId(), "12")) {
                cot.setMeterAddr("000000000002");
            }
            else if(StringUtils.equals(getSoGpId(), "13")) {
                cot.setMeterAddr("000000000003");
            }
            else if(StringUtils.equals(getSoGpId(), "14")) {
                cot.setMeterAddr("000000000004");
            }
            else if(StringUtils.equals(getSoGpId(), "15")) {
                cot.setMeterAddr("000000000005");
            }
            else if(StringUtils.equals(getSoGpId(), "16")) {
                cot.setMeterAddr("000000000006");
            }
        }
        else if(StringUtils.equals(getSoGpId(), "17") || StringUtils.equals(getSoGpId(), "18") 
                || StringUtils.equals(getSoGpId(), "19") || StringUtils.equals(getSoGpId(), "20") 
                || StringUtils.equals(getSoGpId(), "21") || StringUtils.equals(getSoGpId(), "22")) {
            cot.setTerminalAddr("96123457");
            if(StringUtils.equals(getSoGpId(), "17")) {
                cot.setMeterAddr("000000000001");
            }
            else if(StringUtils.equals(getSoGpId(), "18")) {
                cot.setMeterAddr("000000000002");
            }
            else if(StringUtils.equals(getSoGpId(), "19")) {
                cot.setMeterAddr("000000000003");
            }
            else if(StringUtils.equals(getSoGpId(), "20")) {
                cot.setMeterAddr("000000000004");
            }
            else if(StringUtils.equals(getSoGpId(), "21")) {
                cot.setMeterAddr("000000000005");
            }
            else if(StringUtils.equals(getSoGpId(), "22")) {
                cot.setMeterAddr("000000000006");
            }
        }
        else if(StringUtils.equals(getSoGpId(), "23") || StringUtils.equals(getSoGpId(), "24") 
                || StringUtils.equals(getSoGpId(), "25") || StringUtils.equals(getSoGpId(), "26") 
                || StringUtils.equals(getSoGpId(), "27") || StringUtils.equals(getSoGpId(), "28")) {
            cot.setTerminalAddr("96123458");
            if(StringUtils.equals(getSoGpId(), "23")) {
                cot.setMeterAddr("000000000001");
            }
            else if(StringUtils.equals(getSoGpId(), "24")) {
                cot.setMeterAddr("000000000002");
            }
            else if(StringUtils.equals(getSoGpId(), "25")) {
                cot.setMeterAddr("000000000003");
            }
            else if(StringUtils.equals(getSoGpId(), "26")) {
                cot.setMeterAddr("000000000004");
            }
            else if(StringUtils.equals(getSoGpId(), "27")) {
                cot.setMeterAddr("000000000005");
            }
            else if(StringUtils.equals(getSoGpId(), "28")) {
                cot.setMeterAddr("000000000006");
            }
        }
        else if(StringUtils.equals(getSoGpId(), "121") || StringUtils.equals(getSoGpId(), "122") 
                || StringUtils.equals(getSoGpId(), "144") || StringUtils.equals(getSoGpId(), "145") 
                || StringUtils.equals(getSoGpId(), "146") || StringUtils.equals(getSoGpId(), "147")) {
            cot.setTerminalAddr("96123459");
            if(StringUtils.equals(getSoGpId(), "121")) {
                cot.setMeterAddr("000000000001");
            }
            else if(StringUtils.equals(getSoGpId(), "122")) {
                cot.setMeterAddr("000000000002");
            }
            else if(StringUtils.equals(getSoGpId(), "144")) {
                cot.setMeterAddr("000000000003");
            }
            else if(StringUtils.equals(getSoGpId(), "145")) {
                cot.setMeterAddr("000000000004");
            }
            else if(StringUtils.equals(getSoGpId(), "146")) {
                cot.setMeterAddr("000000000005");
            }
            else if(StringUtils.equals(getSoGpId(), "147")) {
                cot.setMeterAddr("000000000006");
            }
        }
        cot.setEquipProtocol("100");
        cot.setMeterType(MeterType.Meter645);
        cot.setFuncode((byte) 27);
        cot.setPort((byte) 1);
        SerialPortPara spp = new SerialPortPara();
        spp.setBaudrate(BaudRate.bps_2400);
        try {
            spp.setStopbit(1);
            spp.setCheckbit(0);
            spp.setOdd_even_bit(1);
            spp.setDatabit(8);
        }
        catch(BPException _bpe) {
            logger.error("send error", _bpe);
        }
        cot.setSerialPortPara(spp);
        try {
            cot.setWaitforPacket((byte) 10);
        }
        catch(BPException _bpe) {
            logger.error("send error", _bpe);
        }
        cot.setWaitforByte((byte) 5);
        String param = getParamsAndValues().substring(0, 4);
        List<CommandItem> ciList = new ArrayList<CommandItem>();
        CommandItem ci = new CommandItem();
        ci.setIdentifier("8000" +  param);
        if(StringUtils.equals(param, "0710") || StringUtils.equals(param, "0720") || StringUtils.equals(param, "0730")) {
            Map<String, String> datacellParam = new HashMap<String, String>();
            datacellParam.put(param, "0200");
            ci.setDatacellParam(datacellParam);
        }
        ciList.add(ci);
        cot.setCommandItems(ciList);
        cotList.add(cot);
        mto.setCollectObjects_Transmit(cotList);
        setMto376(mto);
    }

    @Override
    public void beforeReceive() throws ActionException {
        logger.info("taskId             : " + getTaskId());
        logger.info("type               : " + getType());
        logger.info("action             : " + getAction());
        logger.info("paramsAndValues    : " + getParamsAndValues());
    }

    @Override
    public void afterSend() throws ActionException {
        // TODO Auto-generated method stub
        super.afterSend();
    }

    @Override
    public void afterReceive() throws ActionException {
        if(resultMap != null && !resultMap.isEmpty()) {
            Iterator<?> iterator = resultMap.keySet().iterator();
            if(iterator != null && iterator.hasNext()) {
                String key = (String) iterator.next();
                String value = (String) resultMap.get(key);
                responseText(value);
            }
            else {
                responseText("......");
            }
        }
        else {
            responseText("......");
        }
    }

    /*public void send() throws ActionException {
        logger.info("soType             : " + getSoType());
        logger.info("soId               : " + getSoId());
        logger.info("soName             : " + getSoName());
        logger.info("soOrgId            : " + getSoOrgId());
        logger.info("soTgId             : " + getSoTgId());
        logger.info("soTgId             : " + getSoTgId());
        logger.info("soTermId           : " + getSoTermId());
        logger.info("soGpId             : " + getSoGpId());
        logger.info("action             : " + action);
        logger.info("paramsAndValues    : " + paramsAndValues);
        MTO_376 mto = new MTO_376();
        List<CollectObject_TransMit> cotList = new ArrayList<CollectObject_TransMit>();
        CollectObject_TransMit cot = new CollectObject_TransMit();
        cot.setTerminalAddr("96123458");
        cot.setEquipProtocol("100");
        cot.setMeterAddr("000000000002");
        cot.setMeterType(MeterType.Meter645);
        cot.setFuncode((byte) 27);
        cot.setPort((byte) 1);
        SerialPortPara spp = new SerialPortPara();
        spp.setBaudrate(BaudRate.bps_2400);
        try {
            spp.setStopbit(1);
            spp.setCheckbit(0);
            spp.setOdd_even_bit(1);
            spp.setDatabit(8);
        }
        catch(BPException _bpe) {
            logger.error("send error", _bpe);
            throw new ActionException("ActionException", _bpe.getCause());
        }
        cot.setSerialPortPara(spp);
        try {
            cot.setWaitforPacket((byte) 10);
        }
        catch(BPException _bpe) {
            logger.error("send error", _bpe);
            throw new ActionException("ActionException", _bpe.getCause());
        }
        cot.setWaitforByte((byte) 5);
        List<CommandItem> ciList = new ArrayList<CommandItem>();
        CommandItem ci = new CommandItem();
        ci.setIdentifier("80000710");
        Map<String, String> datacellParam = new HashMap<String, String>();
        datacellParam.put("0710", "0200");
        ci.setDatacellParam(datacellParam);
        ciList.add(ci);
        cot.setCommandItems(ciList);
        cotList.add(cot);
        mto.setCollectObjects_Transmit(cotList);
        long collectId = 0L;
        try {
            collectId = realTimeProxy376.transmitMsg(mto);
        }
        catch(Exception _e) {
            logger.error("send error", _e);
            throw new ActionException("ActionException", _e.getCause());
        }

        try {
            Thread.sleep(10000);
        }
        catch(InterruptedException _ie) {
            _ie.printStackTrace();
        }

        try {
            Map<String, String> resultMap = realTimeProxy376.getReturnByControl_TransMit(collectId);
            logger.info("getReturnByControl_TransMit : " + resultMap.toString());
        }
        catch(Exception _e) {
            logger.error("send error", _e);
            throw new ActionException("ActionException", _e.getCause());
        }

        responseText(String.valueOf(collectId));
    }*/

}
