package SWing_jFrame;

import javax.swing.*;
import java.awt.*;

public class lesson_05 extends JFrame {
    public lesson_05()  {
        Container container = getContentPane();
        container.setLayout(new GridLayout(2,1,10,10));//后面两个参数 表示间距

        JPanel panel = new JPanel(new GridLayout(1,3));
        panel.add(new JButton("1"));
        panel.add(new JButton("1"));
        panel.add(new JButton("1"));

        this.setVisible(true);
        this.setSize(500,500);
        this.setDefaultCloseOperation(3);

        container.add(panel);
    }


    public static void main(String[] args) {
        new lesson_05();
    }
}
