package com.imooc.factory;

public class GIFFactory extends AbstractReadFactory {
    @Override
    public IRead craete() {
        return new GIFRead();
    }
}
