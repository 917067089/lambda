package com.imooc.factory;

import java.io.File;
import java.io.FileInputStream;

/**
 * 读文本文件
 * 1、jdk 提供了不同编码下的字符串转换方法。其中，一个重要的构造方法是：String(byte buf [],String encode),因此读出文本文件的思路，既按字节输入流吧文件读入缓冲区 buf,然后在按上说的string 的构造方法，将buf换冲区按encode编码方式进行编码，转化成可视的字符串。这种方法不但适合GBK、utf8、uncode编码文件，还可适用其他编码文件
 * String... in
 * 就是一个String类型的可变长度的数组,
 * 固定长度的数组是String[] str={};
 * 这样写,可变的就String... str.
 */
public class TextRead implements IRead<String>{

    @Override
    public String read(String... in) {
        String result ="";//result 是结果串
        try{
            File file = new File(in[0]);//in[0] 表示文件名称
            long len = file.length();
            FileInputStream fis = new FileInputStream(in[0]);
            byte[] buf = new byte[(int) len];//缓冲区大小等于文件大小
            fis.read(buf);//一次读完该文件
            result = new String(buf,in[1]);//按in[1] 编码方式转化成可见字符串
            fis.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return result;
    }
}
