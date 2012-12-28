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
                    di1.setDataItemValue("5");
                    diList.add(di1);
                    DataItem di2 = new DataItem();
                    di2.setDataItemCode("10040010030001");      // 本次配置第XXXX块电能表/交流采样装置所属测量点号
                    di2.setDataItemValue("5");
                    diList.add(di2);
                    DataItem di3 = new DataItem();
                    di3.setDataItemCode("10040010040001");      // 本次配置第XXXX块电能表/交流采样装置通信波特率
                    di3.setDataItemValue("3");
                    diList.add(di3);
                    DataItem di4 = new DataItem();
                    di4.setDataItemCode("10040010050001");      // 本次配置第XXXX块电能表/交流采样装置通信端口号
                    di4.setDataItemValue("1");
                    diList.add(di4);
                    DataItem di5 = new DataItem();
                    di5.setDataItemCode("10040010060001");      // 本次配置第XXXX块电能表/交流采样装置通信协议类型
                    di5.setDataItemValue("100");                    // 100 - 
                    diList.add(di5);
                    DataItem di6 = new DataItem();
                    di6.setDataItemCode("10040010070001");      // 本次配置第XXXX块电能表/交流采样装置通信地址
                    di6.setDataItemValue("000000000005");
                    diList.add(di6);
                    DataItem di7 = new DataItem();
                    di7.setDataItemCode("10040010080001");      // 本次配置第XXXX块电能表/交流采样装置通信密码
                    di7.setDataItemValue("000000000000");
                    diList.add(di7);
                    DataItem di8 = new DataItem();
                    di8.setDataItemCode("10040010100001");      // 本次配置第XXXX块电能表/交流采样装置电能费率个数
                    di8.setDataItemValue("000100");
                    diList.add(di8);
                    DataItem di9 = new DataItem();
                    di9.setDataItemCode("10040010120001");      // 本次配置第XXXX块电能表/交流采样装置有功电能示值的整数位个数
                    di9.setDataItemValue("10");
                    diList.add(di9);
                    DataItem di10 = new DataItem();
                    di10.setDataItemCode("10040010130001");      // 本次配置第XXXX块电能表/交流采样装置有功电能示值的小数位个数
                    di10.setDataItemValue("11");
                    diList.add(di10);
                    DataItem di11 = new DataItem();
                    di11.setDataItemCode("10040010140001");      // 本次配置第XXXX块电能表/交流采样装置有功电能示值的小数位个数
                    di11.setDataItemValue("000000000000");
                    diList.add(di11);
                    DataItem di12 = new DataItem();
                    di12.setDataItemCode("10040010140001");      // 本次配置第XXXX块电能表/交流采样装置所属采集器通信地址
                    di12.setDataItemValue("000000000000");
                    diList.add(di12);
                    DataItem di13 = new DataItem();
                    di13.setDataItemCode("10040010150001");      // 本次配置第XXXX块电能表/交流采样装置所属的用户大类号
                    di13.setDataItemValue("0000");
                    diList.add(di13);
                    DataItem di14 = new DataItem();
                    di14.setDataItemCode("10040010160001");      // 本次配置第XXXX块电能表/交流采样装置所属的用户小类号
                    di14.setDataItemValue("0000");
                    diList.add(di14);
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
