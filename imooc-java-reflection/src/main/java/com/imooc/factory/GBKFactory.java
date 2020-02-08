package com.imooc.factory;

public class GBKFactory extends AbstractReadFactory {
    @Override
    public IRead craete() {
        return new GBKRead();
    }
}
