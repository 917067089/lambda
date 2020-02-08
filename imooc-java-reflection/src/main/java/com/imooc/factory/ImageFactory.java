package com.imooc.factory;

public class ImageFactory extends AbstractReadFactory {
    @Override
    public IRead craete() {
        return new ImageRead();
    }
}
