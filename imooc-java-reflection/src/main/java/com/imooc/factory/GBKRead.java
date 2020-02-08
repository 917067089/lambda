package com.imooc.factory;

/**
 * 定义具体读文本、图像文件类--GBK编码文件
 */
public class GBKRead extends AbstractTextRead {
    public void read(String fileName){
        System.out.println("这是GBK 文本");
    }
}
