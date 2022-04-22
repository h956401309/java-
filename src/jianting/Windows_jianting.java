package jianting;

import javafx.stage.Window;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Windows_jianting {
    public static void main(String[] args) {
        new MywindowFrame();
    }
}

      class MywindowFrame extends Frame{
        public MywindowFrame(){

            setBounds(100,100,600,600);
            setBackground(new Color(125,155,168));
            setVisible(true);
            addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    System.out.println("你点击了xxx");
                    System.exit(0);
                }
            });


        }



    }





