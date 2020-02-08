package com.imooc.factory;

public class BMPFactory extends AbstractReadFactory {
    @Override
    public IRead craete() {
        return new BMPRead();
    }
}
