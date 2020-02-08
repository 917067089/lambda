package com.imooc.factory;

public class MidFactory extends AbstractFactory {
    @Override
    public ICar createCar() {
        return new MidCar();
    }

    @Override
    public IBus createBus() {
        return new MidBus();
    }
}
