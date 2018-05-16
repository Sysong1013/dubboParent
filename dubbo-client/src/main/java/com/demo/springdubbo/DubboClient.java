package com.demo.springdubbo;

import com.alibaba.dubbo.container.spring.SpringContainer;
import com.dangdang.stock.wmssync.api.WmsSyncStockService;
import com.dangdang.stock.wmssync.api.module.WmsSyncParam;
import com.dangdang.wms.interlayer.stock.facade.SyncStockInfoFacade;
import com.dangdang.wms.interlayer.stock.model.Jkxx_Kcxx;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j
public class DubboClient {

    public static void main(String[] args) {
        SpringContainer providerContainer = new SpringContainer();
        providerContainer.start();

        //RemotePinBackFacade RemotePinBackFacade = SpringContainer.getContext().getBean(RemotePinBackFacade.class);
        SyncStockInfoFacade syncStockInfoFacade=SpringContainer.getContext().getBean(SyncStockInfoFacade.class);
        //WmsSyncStockService wmsSyncStockService=SpringContainer.getContext().getBean(WmsSyncStockService.class);
        try {
            //RemotePinBackReturnBean remotePinBackReturnBean= RemotePinBackFacade.getOrderFromErp("13526498192");//线上
//            RemotePinBackReturnBean remotePinBackReturnBean= RemotePinBackFacade.getOrderFromErp("13034376492");//测试
//            System.out.println(remotePinBackReturnBean.getResponseInfo());
//            System.out.println(remotePinBackReturnBean.getOrderMainDetail().getChildList().get(0).getItemId());
//            System.out.println(remotePinBackReturnBean.getStockRecordList());
//            System.out.println(remotePinBackReturnBean.getInvoiceMainDetail());
            ////////////////////////////////////////////////////////////////////////////
            Date date = new Date();
            //Date date1 =new Date();
            List<Jkxx_Kcxx> list = new ArrayList<Jkxx_Kcxx>();
            Jkxx_Kcxx jkxx_kcxx = new Jkxx_Kcxx();
            jkxx_kcxx.setBmspckkcid("aaadqjdo");
            jkxx_kcxx.setCkid("31");
            jkxx_kcxx.setKykc(97l);
            jkxx_kcxx.setSpxxid("210889234");
            jkxx_kcxx.setZckc(12l);
            jkxx_kcxx.setZt("1");
            jkxx_kcxx.setZtkc(22l);
            jkxx_kcxx.setCdate(date);
            jkxx_kcxx.setUdate(date);
            //jkxx_kcxx.setAllotDate(date1);
            list.add(jkxx_kcxx);
            System.out.println(syncStockInfoFacade.acceptData2WmsInter(list));

//            WmsSyncParam wmsSyncParam =new WmsSyncParam();
//            wmsSyncParam.setProductId(35778752l);
//            wmsSyncParam.setWarehouseId(30);
//            wmsSyncParam.setOpNum(10);
//            wmsSyncParam.setStockQuantityTs(9);
//            wmsSyncParam.setStockQuantityAllot(8);
//            Timestamp allotTime =new Timestamp(date.getTime());
//            wmsSyncParam.setAllotArrivalDate(allotTime);
//            System.out.println(wmsSyncStockService.sync(wmsSyncParam));


        }catch (Exception e){
            System.out.println(e);
        }
    }

}
