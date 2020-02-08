package com.imooc.factory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;


/**
 * 要求：读取图像文件的包括：BMp、GIF\JPG,获取图像的宽度、长度、每一点的RGB三基色
 */
public class ImageRead implements IRead<ImageInfo> {
    @Override
    public ImageInfo read(String... in) throws IOException {
        File file = new File(in[0]);//in[0]表示图像的文件名
        BufferedImage bi = ImageIO.read(file);
        String readSuffix[] = ImageIO.getReaderFileSuffixes();//获得可读图像文件类型扩展
        for(int i=0;i<readSuffix.length;i++){
            System.out.println("获得可读图像文件类型扩展:"+readSuffix[i]);
        }
        String writeSuffix[] = ImageIO.getWriterFileSuffixes();//获得可写图像文件类型扩展名
        for(int i=0;i<writeSuffix.length;i++){
            System.out.println("获得可写图像文件类型扩展名:"+readSuffix[i]);
        }
        int width = bi.getWidth();
        int height = bi.getHeight();
//        int rgb [] = new int[width * height];
//        long len = file.length();
//        FileInputStream fis = new FileInputStream(in[0]);
//        byte[] buf = new byte[(int) len];//缓冲区大小等于文件大小
//        fis.read(buf);//一次读完该文件
//        String result = new String(buf,in[1]);//按in[1] 编码方式转化成可见字符串
//        int[] rgbArray = new int[Integer.parseInt(result)];
//        System.out.println(result);
//        fis.close();
//        bi.getRGB(0,0,width,height,rgbArray,width,width);//将图像读到resujlt缓冲区中

        ImageInfo obj = new ImageInfo();
        obj.setWidth(width);
        obj.setHeght(height);
//        obj.setRGB(rgb);
        return obj;
    }
}
