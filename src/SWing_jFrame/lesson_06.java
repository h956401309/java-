package SWing_jFrame;


import javax.swing.*;
import java.awt.*;
import java.net.URL;

//单选框   多选框
public class lesson_06 extends JFrame {
    public lesson_06() {

        Container container = new Container();
        // URL resource = lesson_06.class.getResource("ima.jpg");
        //   Icon icon = new ImageIcon(resource);

//单选框        复选框Jcheckbox  不用分组
        JRadioButton jRadioButton1 = new JRadioButton("0000000001");
        JRadioButton jRadioButton2 = new JRadioButton("0000000002");
        JRadioButton jRadioButton3 = new JRadioButton("0000000003");

//由于单选框只能选取一个 分组      一个组中 只能选取一个按钮
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(jRadioButton1);
        buttonGroup.add(jRadioButton2);
        buttonGroup.add(jRadioButton3);

        container.add(jRadioButton1);
        container.add(jRadioButton2);
        container.add(jRadioButton3);

        this.setVisible(true);
        this.setSize(500, 500);
        this.setDefaultCloseOperation(3);

    }

    public static void main(String[] args) {
        new lesson_06();
    }
}
