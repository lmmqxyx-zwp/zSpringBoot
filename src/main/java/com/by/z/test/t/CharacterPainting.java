package com.by.z.test.t;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 字符画生成
 *
 * @author zwp
 */
public class CharacterPainting {

    /**
     * 图片转换成字符信息组合
     *
     * @param path 图片路径
     * @return
     */
    public static StringBuilder createAsciiPic(final String path) {
        final String base = "@#&$%*o!;.";// 字符串由复杂到简单
        StringBuilder sb = new StringBuilder(); //返回给调用者的字符图片组合信息 TODO
        try {
            final BufferedImage image = ImageIO.read(new File(path));
            for (int y = 0; y < image.getHeight(); y += 2) {
                for (int x = 0; x < image.getWidth(); x++) {
                    final int pixel = image.getRGB(x, y);
                    final int r = (pixel & 0xff0000) >> 16, g = (pixel & 0xff00) >> 8, b = pixel & 0xff;
                    final float gray = 0.299f * r + 0.578f * g + 0.114f * b;
                    final int index = Math.round(gray * (base.length() + 1) / 255);
                    System.out.print(index >= base.length() ? " " : String.valueOf(base.charAt(index)));
                    sb.append(index >= base.length() ? " " : String.valueOf(base.charAt(index)));
                }
                System.out.println();
            }
        } catch (final IOException e) {
            e.printStackTrace();
        }

        return sb;
    }

    /**
     * Main
     *
     * @param args
     */
    public static void main(final String[] args) {
        // 图片文件路径
        String path = "E:\\gitClient\\zwp\\zSpringBoot\\src\\main\\resources\\banner.jpg";
//        StringBuilder sb = CharacterPainting.createAsciiPic(path);
//        System.out.println(sb.toString());

        // 方法分析
        analysis(path);
    }

    /**
     * Analysis 分析 createAsciiPic
     *
     * @param path 图片文件路径
     */
    public static void analysis(final String path) {
        final String base = "@#&$%*o!;.";// 字符串由复杂到简单
        System.out.println("替换图片的相关字符： [ " + base + " ]");
        StringBuilder sb = new StringBuilder();
        try {
            final BufferedImage image = ImageIO.read(new File(path));
            System.out.println("image: = \n" +
                    "[ " + image.getHeight() + " ]\n" +
                    "[ " + image.getWidth() + " ]\n" +
                    "[ " + image.getData() + " ]\n" +
                    "[ " + image.getRGB(250, 281) + " ] " +
                    "[ " + image.getRGB(260, 281) + " ]"
            );
            final int temppixel = image.getRGB(250, 281);
            System.out.println("-----------------");
            System.out.println(temppixel);
            System.out.println(temppixel & 0xff0000);
            System.out.println((temppixel & 0xff0000) >> 16);
            System.out.println(temppixel & 0xff00);
            System.out.println((temppixel & 0xff00) >> 8);
            System.out.println(temppixel & 0xff);
            System.out.println("-----------------");
            final int tr = (temppixel & 0xff0000) >> 16, tg = (temppixel & 0xff00) >> 8, tb = temppixel & 0xff;
            float tempgray = 0.299f * tr + 0.578f * tg + 0.114f * tb;
            System.out.println("R G B 三色：");
            System.out.println("tr : " + tr);
            System.out.println("tg : " + tg);
            System.out.println("tb : " + tb);
            System.out.println("tempgray : " + tempgray);
            final int tempindex = Math.round(tempgray * (base.length() + 1) / 255);
            System.out.println(tempindex);

            for (int y = 0; y < image.getHeight(); y += 2) {
                for (int x = 0; x < image.getWidth(); x++) {
                    final int pixel = image.getRGB(x, y);
                    final int r = (pixel & 0xff0000) >> 16, g = (pixel & 0xff00) >> 8, b = pixel & 0xff;
                    final float gray = 0.299f * r + 0.578f * g + 0.114f * b;
                    final int index = Math.round(gray * (base.length() + 1) / 255);
                    // 暂时不用输出信息
                    //System.out.print(index >= base.length() ? " " : String.valueOf(base.charAt(index)));
                }
                //System.out.println();
            }
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }


}
