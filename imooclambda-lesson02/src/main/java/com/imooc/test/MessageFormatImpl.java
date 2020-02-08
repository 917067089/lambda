package com.imooc.test;

public class MessageFormatImpl implements IMessageFormat {
    @Override
    public String format(String message, String format) {
        System.out.println("消息转换");
        return message;
    }
}
