package com.imooc.test;

/**
 * 消息传输格斯话优化接口
 */
@FunctionalInterface
public interface IMessageFormat {
    /**
     * 消息转换方法
     * @param message 要转换的消息
     * @param format  转换的格式（xml/json）
     * @return  返回转换后的数据
     */
    String format(String message,String format);

    /**
     * 方法合法性验证方法
     * @param msg 要验证的消息
     * @return  返回验证结果
     */
    static  boolean verifyMessage(String msg){
        if(msg!=null){
            return true;
        }
        return false;
    }
}
