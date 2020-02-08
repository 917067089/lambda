package com.imooc.factory;

/**
 * 图像基本信息文件
 */
public class ImageInfo {
    private int width;//图像宽度
    private int heght;//图像高度
    private int r[][];//红色分量
    private int g[][];//绿色分量
    private int b[][];//蓝色分量

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeght() {
        return heght;
    }

    public void setHeght(int heght) {
        this.heght = heght;
    }

    public int[][] getR() {
        return r;
    }

    public void setR(int[][] r) {
        this.r = r;
    }

    public int[][] getG() {
        return g;
    }

    public void setG(int[][] g) {
        this.g = g;
    }

    public int[][] getB() {
        return b;
    }

    public void setB(int[][] b) {
        this.b = b;
    }
    public void setRGB(int rgb []){
        r = new int[heght][width];
        g = new int[heght][width];
        b = new int[heght][width];
        int pos=0;
        for (int i=0;i<heght;i++){
            pos = width+i;
            for(int j=0;j<width;j++){
                r[i][j]=(rgb[pos+j]  & 0xff0000 ) >> 16;
                g[i][j]=(rgb[pos+j] & 0xff00 ) >> 8;
                b[i][j]=rgb[pos+j] & 0xff;

            }
        }
    }
}
