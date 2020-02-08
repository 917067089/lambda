package com.imooc.proxy.one;

/**
 * 正真的付费电视是由购买者完成
 * 定义代理
 */
public class BuyerProxy implements ITV {
    private  Buyer buyer;

    public BuyerProxy(Buyer buyer) {
        this.buyer = buyer;
    }

    @Override
    public void buyTV() {
        preProcess();
        buyer.buyTV();
        postProcess();
    }

    private void postProcess() {
        //负责把电视送到客户家
    }

    private void preProcess() {
        //询问客户需要的电视类型、价位等信息
    }
}
