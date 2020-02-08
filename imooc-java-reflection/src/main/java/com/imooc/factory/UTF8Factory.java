package com.imooc.factory;

public class UTF8Factory extends AbstractReadFactory {
    @Override
    public IRead craete() {
        return new UTF8Read();
    }
}
