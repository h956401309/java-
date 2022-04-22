package jianting;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class shurukaung {

    public static void main(String[] args) {
        new MyFrame();
    }

}

class  MyFrame extends Frame{
    public MyFrame(){
        TextField textField = new TextField();
        add(textField);
        MyActionLister2 myActionLister2 = new MyActionLister2();

        //按下回车 发生事件
        textField.addActionListener(myActionLister2);
        setVisible(true);


        textField.setEchoChar('t');
        pack();
        

    }
}



class MyActionLister2 implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        TextField textField =(TextField) actionEvent.getSource();
        System.out.println(textField.getText());//获得输入框的文本

        textField.setText("");
    }
}
