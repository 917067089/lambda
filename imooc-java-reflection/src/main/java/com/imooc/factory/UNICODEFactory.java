package com.imooc.factory;

public class UNICODEFactory extends AbstractReadFactory {
    @Override
    public IRead craete() {
        return new UNICODERead();
    }
}
