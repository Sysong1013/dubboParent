package com.demo.springdubbo;

import com.alibaba.dubbo.container.spring.SpringContainer;
import com.dangdang.wms.interlayer.stock.facade.RemotePinBackFacade;
import com.dangdang.wms.interlayer.stock.model.RemotePinBackReturnBean;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DubboClient {

    public static void main(String[] args) {
        SpringContainer providerContainer = new SpringContainer();
        providerContainer.start();

        RemotePinBackFacade RemotePinBackFacade = SpringContainer.getContext().getBean(RemotePinBackFacade.class);
        try {
            RemotePinBackReturnBean remotePinBackReturnBean= RemotePinBackFacade.getOrderFromErp("13034376492");
            System.out.println(remotePinBackReturnBean.getResponseInfo());
            System.out.println(remotePinBackReturnBean.getOrderMainDetail().getChildList().get(0).getItemId());
            System.out.println(remotePinBackReturnBean.getStockRecordList());
            System.out.println(remotePinBackReturnBean.getInvoiceMainDetail());
        }catch (Exception e){
            System.out.println(e);
        }
    }

}
