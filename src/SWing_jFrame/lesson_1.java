package SWing_jFrame;


import javax.swing.*;
import java.awt.*;

public class lesson_1 {
    public void init(){
        JFrame jf=new JFrame("这是一个JFrmae");
        jf.setVisible(true);
        jf.setBounds(100,100,600,600);
        //设置文字
        JLabel label = new JLabel("欢迎来到我的世界");

        jf.add(label);
        jf.setBackground(Color.BLUE);
        Container contentPane = jf.getContentPane();
        contentPane.setBackground(Color.blue);
        label.setHorizontalAlignment(0);


        //窗口关闭事件
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


    public static void main(String[] args) {
            new lesson_1().init();
    }
}


