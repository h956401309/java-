package SWing_jFrame;

import javax.swing.*;
import java.awt.*;

public class lesson_3 extends JFrame implements Icon {
    private int width;
    private int height;

    public lesson_3()  {
    }

    public lesson_3(int width, int height)  {
        this.width = width;
        this.height = height;
    }


    public void init(){


        lesson_3 icon = new lesson_3(15, 15);
        //图标放在标签上 也可以再按钮上

        JLabel jLabel = new JLabel("图标", icon,SwingConstants.CENTER);

        Container container = getContentPane();
        container.add(jLabel);

        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
     new lesson_3().init();
    }

    @Override
    public void paintIcon(Component component, Graphics graphics, int i, int i1) {
        graphics.fillOval(i,i1,width,height);
    }

    @Override
    public int getIconWidth() {
        return this.width;
    }

    @Override
    public int getIconHeight() {
        return this.height;
    }
}
