package jianting;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class keyjianting {


    public static void main(String[] args) {
        new KeyFrame();
    }
}


class KeyFrame extends Frame{
    public KeyFrame(){
        setBounds(100,100,600,600);
        setBackground(new Color(125,155,168));
        setVisible(true);

        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                //获得键盘按下的键是哪个   当前的码
                int keyCode = e.getKeyCode();
                System.out.println(keyCode);

                if (keyCode==KeyEvent.VK_UP){
                    System.out.println("你按下了上建");
                }
            }
        });

    }
}
