package com.imooc.factory;

public class UpFactory extends AbstractFactory {
    @Override
    public ICar createCar() {
        return new UpCar();
    }

    @Override
    public IBus createBus() {
        return new UpBus();
    }
}
