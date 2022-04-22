package SWing_jFrame;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class lesson_4 extends JFrame {

    public lesson_4()  {
        JLabel label = new JLabel("image");
        URL url = lesson_4.class.getResource("ima.jpg");
        ImageIcon icon = new ImageIcon(url);
        label.setIcon(icon);
        label.setHorizontalAlignment(0);
        Container container = getContentPane();
        container.add(label);
        setVisible(true);
        setDefaultCloseOperation(3);
        setBounds(100,100,500,500);

    }




    public static void main(String[] args) {
        new lesson_4();
    }
}
