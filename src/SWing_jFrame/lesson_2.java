package SWing_jFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class lesson_2 extends JFrame {
    public lesson_2() {
        this.setVisible(true);
        this.setSize(600, 600);
        // this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //jFrame容器放东西

        Container container = new Container();
        container.setLayout(null);
        JButton jButton = new JButton("点击弹框");
        jButton.setBounds(100, 100, 300, 10);
  //      jButton.setVisible(true);
        //点击按钮的时候   事件
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //弹窗
                new Mydialog();
            }
        });
            this.add(jButton);
         //container.add(jButton);
        //this.add(jButton);

    }


    public static void main(String[] args) {
        new lesson_2();
    }
}


class Mydialog extends JDialog {
    public Mydialog() {
        this.setVisible(true);
        this.setBounds(100, 100, 500, 500);
      //  this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(null);

        container.add(new Label("java学习就是好"));

    }
}
