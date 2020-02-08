package com.imooc.reflection;

/**
 * 已接收的字符串可有两种走向，若输入ConsoleMsg,则将字符串输出到控制台，若输入FileMsg 则将字符串输出到文件
 *
 * 为实现上述功能，可定义共同的字符串处理接口IMsg,两个子类ConsloeMsg\FileMsg 均实现IMsg接口，
 */
public class Demo05 {
    public static void main(String [] args) throws Exception {
        String str = args[0];
        System.out.println(str);
        IMsg iMsg = (IMsg) Class.forName(args[0]).newInstance();
        iMsg.process("hello world");
    }
}
