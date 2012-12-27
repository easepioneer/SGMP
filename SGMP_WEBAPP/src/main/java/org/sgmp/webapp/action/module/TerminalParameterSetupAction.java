package org.sgmp.webapp.action.module;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.sgmp.webapp.ActionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import fep.bp.realinterface.mto.CircleDataItems;
import fep.bp.realinterface.mto.CollectObject;
import fep.bp.realinterface.mto.CommandItem;
import fep.bp.realinterface.mto.DataItem;
import fep.bp.realinterface.mto.DataItemGroup;
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

    @Override
    public void beforeSend() {
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
        if(StringUtils.equals(getType(), TYPE_TERMINAL_PARAMETER)) {
            if(StringUtils.equals(getAction(), "write")) {
                MTO_376 mto = new MTO_376();
                List<CollectObject> coList = new ArrayList<CollectObject>();
                CollectObject co = new CollectObject();
                if(StringUtils.equals(soTermId, "11")) {
                    co.setLogicalAddr("96123456");
                }
                else if(StringUtils.equals(soTermId, "12")) {
                    co.setLogicalAddr("96123457");
                }
                else if(StringUtils.equals(soTermId, "13")) {
                    co.setLogicalAddr("96123458");
                }
                co.setEquipProtocol("100");
                co.setChannelType("1");
                co.setPwAlgorith("0");
                co.setPwContent("8888");
                co.setMpExpressMode(3);
                int[] mpSn = {0};
                co.setMpSn(mpSn);
                int p = paramsAndValues.indexOf(":");
                String param = paramsAndValues.substring(0, p);
                logger.info("param : " + param);
                if(StringUtils.equals(param, "F10")) {
                    List<CommandItem> ciList = new ArrayList<CommandItem>();
                    CommandItem ci = new CommandItem();
                    ci.setIdentifier("10040010");
                    ci.setCircleLevel(1);
                    Map<String, String> datacellParam = new HashMap<String, String>();
                    datacellParam.put("1004001001", "1");
                    ci.setDatacellParam(datacellParam);
                    CircleDataItems circleDataItems = new CircleDataItems();
                    List<DataItemGroup> digList = new ArrayList<DataItemGroup>();
                    DataItemGroup dig = new DataItemGroup();
                    List<DataItem> diList = new ArrayList<DataItem>();
                    DataItem di1 = new DataItem();
                    di1.setDataItemCode("10040010020001");      // 本次配置第XXXX块电能表/交流采样装置序号
                    di1.setDataItemValue("2");
                    diList.add(di1);
                    dig.setDataItemList(diList);
                    digList.add(dig);
                    circleDataItems.setDataItemGroups(digList);
                    ci.setCircleDataItems(circleDataItems);
                    ciList.add(ci);
                    co.setCommandItems(ciList);
                }
                coList.add(co);
                mto.setCollectObjects(coList);
                setMto376(mto);
            }
            else if(StringUtils.equals(getAction(), "read")) {
                MTO_376 mto = new MTO_376();
                List<CollectObject> coList = new ArrayList<CollectObject>();
                CollectObject co = new CollectObject();
                if(StringUtils.equals(soTermId, "11")) {
                    co.setLogicalAddr("96123456");
                }
                else if(StringUtils.equals(soTermId, "12")) {
                    co.setLogicalAddr("96123457");
                }
                else if(StringUtils.equals(soTermId, "13")) {
                    co.setLogicalAddr("96123458");
                }
                co.setEquipProtocol("100");
                co.setChannelType("1");
                co.setPwAlgorith("0");
                co.setPwContent("8888");
                co.setMpExpressMode(3);
                int[] mpSn = {0};
                co.setMpSn(mpSn);
                int p = paramsAndValues.indexOf(":");
                String param = paramsAndValues.substring(0, p);
                logger.info("param : " + param);
                if(StringUtils.equals(param, "F10")) {
                    List<CommandItem> ciList = new ArrayList<CommandItem>();
                    CommandItem ci = new CommandItem();
                    ci.setIdentifier("10040010");
                    ci.setCircleLevel(1);
                    Map<String, String> datacellParam = new HashMap<String, String>();
                    datacellParam.put("1004001001", "1");
                    ci.setDatacellParam(datacellParam);
                    CircleDataItems circleDataItems = new CircleDataItems();
                    List<DataItemGroup> digList = new ArrayList<DataItemGroup>();
                    DataItemGroup dig = new DataItemGroup();
                    List<DataItem> diList = new ArrayList<DataItem>();
                    DataItem di1 = new DataItem();
                    di1.setDataItemCode("10040010020001");      // 本次配置第XXXX块电能表/交流采样装置序号
                    di1.setDataItemValue("2");
                    diList.add(di1);
                    dig.setDataItemList(diList);
                    digList.add(dig);
                    circleDataItems.setDataItemGroups(digList);
                    ci.setCircleDataItems(circleDataItems);
                    ciList.add(ci);
                    co.setCommandItems(ciList);
                }
                coList.add(co);
                mto.setCollectObjects(coList);
                setMto376(mto);
            }
        }
    }

    @Override
    public void beforeReceive() {
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
        // TODO Auto-generated method stub
        super.afterReceive();
    }

}
