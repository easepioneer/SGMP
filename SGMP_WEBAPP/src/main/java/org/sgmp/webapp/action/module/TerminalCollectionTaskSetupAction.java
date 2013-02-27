package org.sgmp.webapp.action.module;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.sgmp.webapp.ActionException;
import org.springframework.stereotype.Component;

import fep.bp.realinterface.mto.CircleDataItems;
import fep.bp.realinterface.mto.CollectObject;
import fep.bp.realinterface.mto.CommandItem;
import fep.bp.realinterface.mto.DataItem;
import fep.bp.realinterface.mto.DataItemGroup;
import fep.bp.realinterface.mto.MTO_376;

/**
 * 终端任务设置
 * @author Nick
 *
 */
@Component
public class TerminalCollectionTaskSetupAction extends AbstractSimpleInteractionAction {

    /**
     * 
     */
    private static final long serialVersionUID = -3095776939950182057L;

    /**
     * 
     * @return
     * @throws ActionException
     */
    public String init() throws ActionException {
        return SUCCESS;
    }

    @Override
    public void beforeSend() throws ActionException {
        MTO_376 mto = new MTO_376();
        List<CollectObject> coList = new ArrayList<CollectObject>();
        CollectObject co = new CollectObject();
        co.setLogicalAddr("33010008");
        co.setEquipProtocol("101");
        co.setChannelType("1");
        co.setPwAlgorith("0");
        co.setPwContent("8888");
        co.setMpExpressMode(3);
        int[] mpSn = {0};
        co.setMpSn(mpSn);

        CommandItem ci1 = new CommandItem();
        ci1.setIdentifier("10040065");
        ci1.setCircleLevel(1);
        Map<String, String> dcp = new HashMap<String, String>();
        for(int i = 0; i < 5; i++) {
            if(i == 0) {
                dcp.put("1004006501", "1");                     // 定时上报周期单位
            }
            else if(i == 1) {
                dcp.put("1004006502", "1");                     // 定时上报周期
            }
            else if(i == 2) {
                dcp.put("1004006503", "2013-02-27 22:00:00");   // 上报基准时间
            }
            else if(i == 3) {
                dcp.put("1004006504", "1");                     // 曲线数据抽取倍率
            }
            else if(i == 4) {
                dcp.put("1004006505", "1");                     // 数据单元标识个数
            }
        }
        ci1.setDatacellParam(dcp);
        CircleDataItems cdi = new CircleDataItems();
        List<DataItemGroup> digList = new ArrayList<DataItemGroup>();
        DataItemGroup dig = new DataItemGroup();
        List<DataItem> diList = new ArrayList<DataItem>();
        DataItem di1 = new DataItem();
        di1.setDataItemCode("10040065060001");
        di1.setDataItemValue("" + 0x0201);
        diList.add(di1);
        DataItem di2 = new DataItem();
        di2.setDataItemCode("10040065070001");
        di2.setDataItemValue("" + 0x100D);
        diList.add(di2);
        dig.setDataItemList(diList);
        digList.add(dig);
        cdi.setDataItemGroups(digList);
        ci1.setCircleDataItems(cdi);
        co.AddCommandItem(ci1);

        //CommandItem ci2 = new CommandItem();
        //ci2.setIdentifier("10040067");

        coList.add(co);
        mto.setCollectObjects(coList);
        setMto376(mto);
    }

    @Override
    public void beforeReceive() throws ActionException {
        // TODO Auto-generated method stub
        super.beforeReceive();
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
