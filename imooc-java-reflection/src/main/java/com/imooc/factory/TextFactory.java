package com.imooc.factory;

public class TextFactory extends AbstractReadFactory {
    @Override
    public IRead craete() {
        return new TextRead();
    }
}
