package com.imooc.factory;

public class JPGFactory extends AbstractReadFactory {
    @Override
    public IRead craete() {
        return new JPGRead();
    }
}
