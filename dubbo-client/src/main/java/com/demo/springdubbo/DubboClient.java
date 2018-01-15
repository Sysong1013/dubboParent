package com.demo.springdubbo;

import com.alibaba.dubbo.container.spring.SpringContainer;


public class DubboClient {

    public static void main(String[] args) {
        SpringContainer providerContainer = new SpringContainer();
        providerContainer.start();

        BlockchainService blockchainService = SpringContainer.getContext().getBean(BlockchainService.class);
        try {
            blockchainService.chain();
        }catch (Exception e){
            System.out.println(e);
        }
    }

}
