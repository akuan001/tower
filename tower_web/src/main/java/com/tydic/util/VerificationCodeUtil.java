package com.tydic.util;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Random;

public class VerificationCodeUtil {

    private ByteArrayInputStream image;// 图像
    private String str;// 验证码
    private int width = 80;
    private int height = 20;

    /**
     * 功能：获取一个验证码类的实例
     * 
     * @return
     */
    public static VerificationCodeUtil getInstance(int width, int height) {
        return new VerificationCodeUtil(width, height);
    }

    private VerificationCodeUtil(int width, int height) {
        this.width = width;
        this.height = height;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        initNumVerificationCode(image);
    }

    /**
     * 功能：设置第一种验证码的属性
     */
    public void initNumVerificationCode(BufferedImage image) {

        Random random = new Random(); // 生成随机类
        Graphics g = initImage(image, random);
        String sRand = "";
        for (int i = 0; i < 4; i++) {
            String rand = String.valueOf(random.nextInt(10));
            sRand += rand;
            // 将认证码显示到图象中
            g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));
            g.setFont(new Font("Times New Roman", Font.BOLD, 30));
            // 调用函数出来的颜色相同，可能是因为种子太接近，所以只能直接生成
            g.drawString(rand, 24 * i + 6, 25);
        }
        this.setStr(sRand);/* 赋值验证码 */
        // 图象生效
        g.dispose();
        this.setImage(drawImage(image));
    }

    public Graphics initImage(BufferedImage image, Random random) {
        Graphics g = image.getGraphics(); // 获取图形上下文
        g.setColor(Color.WHITE);// 设定背景色
        g.fillRect(0, 0, width, height);
        // g.setFont(new Font("Times New Roman", Font.BOLD, 16));// 设定字体
        // 画边框
        g.setColor(new Color(55, 55, 12));
        g.drawRect(0, 0, width - 1, height - 1);

        // g.setColor(getRandColor(100, 150)); // 随机产生165条干扰线，使图象中的认证码不易被其它程序探测到
        g.setColor(Color.BLACK); // 随机产生165条干扰线，使图象中的认证码不易被其它程序探测到
        float lineWidth = 1f;
        ((Graphics2D) g).setStroke(new BasicStroke(lineWidth));
        for (int i = 0; i < 3; i++) {
//            int x = random.nextInt(10);
            int y = random.nextInt(height);
//            int xl = width - random.nextInt(10);
            int yl = random.nextInt(height);
            ((Graphics2D) g).drawLine(6, y, width - 6, yl);
        }
        return g;
    }

    public ByteArrayInputStream drawImage(BufferedImage image) {
        ByteArrayInputStream input = null;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        try {
            ImageOutputStream imageOut = ImageIO.createImageOutputStream(output);
            ImageIO.write(image, "JPEG", imageOut);
            imageOut.close();
            input = new ByteArrayInputStream(output.toByteArray());
        } catch (Exception e) {
            System.out.println("验证码图片产生出现错误：" + e.toString());
        }
        return input;
    }

    /**
     * 功能：获取验证码的字符串值
     * 
     * @return
     */
    public String getVerificationCodeValue() {
        return this.getStr();
    }

    /**
     * 功能：取得验证码图片
     * 
     * @return
     */
    public ByteArrayInputStream getImage() {
        return this.image;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public void setImage(ByteArrayInputStream image) {
        this.image = image;
    }

}
