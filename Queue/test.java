package Queue;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class test extends JFrame {
    Label InputArguments;
    Label label_3;
    Label label_2;
    JButton Simulate;
    JButton button_2;
    Label label_4;
    Label label_5;
    Label label_6;
    Label label_7;
    TextField textfield_4;
    TextField textfield_5;
    TextField textfield_6;
    TextField textfield_7;
    TextField textfield_8;
    TextField textfield_9;
    Label label_8;
    TextField textfield_11;
    Label label_9;
    TextField textfield_10;

    public test() {
        testLayout customLayout = new testLayout();

        getContentPane().setFont(new Font("Helvetica", Font.PLAIN, 12));
        getContentPane().setLayout(customLayout);

        InputArguments = new Label("Input Arguments");
        getContentPane().add(InputArguments);

        label_3 = new Label("Minimum Inter-Arrival Time");
        getContentPane().add(label_3);

        label_2 = new Label("Maximum Inter-Arrival Time");
        getContentPane().add(label_2);

        Simulate = new JButton("Simulate");
        getContentPane().add(Simulate);

        button_2 = new JButton("Clear");
        getContentPane().add(button_2);

        label_4 = new Label("");
        getContentPane().add(label_4);

        label_5 = new Label("label_5");
        getContentPane().add(label_5);

        label_6 = new Label("label_6");
        getContentPane().add(label_6);

        label_7 = new Label("label_7");
        getContentPane().add(label_7);

        textfield_4 = new TextField("textfield_4");
        getContentPane().add(textfield_4);

        textfield_5 = new TextField("textfield_5");
        getContentPane().add(textfield_5);

        textfield_6 = new TextField("textfield_6");
        getContentPane().add(textfield_6);

        textfield_7 = new TextField("textfield_7");
        getContentPane().add(textfield_7);

        textfield_8 = new TextField("textfield_8");
        getContentPane().add(textfield_8);

        textfield_9 = new TextField("textfield_9");
        getContentPane().add(textfield_9);

        label_8 = new Label("label_8");
        getContentPane().add(label_8);

        textfield_11 = new TextField("textfield_11");
        getContentPane().add(textfield_11);

        label_9 = new Label("label_9");
        getContentPane().add(label_9);

        textfield_10 = new TextField("textfield_10");
        getContentPane().add(textfield_10);

        setSize(getPreferredSize());

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String args[]) {
        test window = new test();

        window.setTitle("test");
        window.pack();
        window.show();
    }
}

class testLayout implements LayoutManager {

    public testLayout() {
    }

    public void addLayoutComponent(String name, Component comp) {
    }

    public void removeLayoutComponent(Component comp) {
    }

    public Dimension preferredLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);

        Insets insets = parent.getInsets();
        dim.width = 342 + insets.left + insets.right;
        dim.height = 383 + insets.top + insets.bottom;

        return dim;
    }

    public Dimension minimumLayoutSize(Container parent) {
        Dimension dim = new Dimension(0, 0);
        return dim;
    }

    public void layoutContainer(Container parent) {
        Insets insets = parent.getInsets();

        Component c;
        c = parent.getComponent(0);
        if (c.isVisible()) {c.setBounds(insets.left+0,insets.top+0,115,26);}
        c = parent.getComponent(1);
        if (c.isVisible()) {c.setBounds(insets.left+0,insets.top+32,115,32);}
        c = parent.getComponent(2);
        if (c.isVisible()) {c.setBounds(insets.left+0,insets.top+70,115,32);}
        c = parent.getComponent(3);
        if (c.isVisible()) {c.setBounds(insets.left+0,insets.top+262,173,26);}
        c = parent.getComponent(4);
        if (c.isVisible()) {c.setBounds(insets.left+173,insets.top+262,173,26);}
        c = parent.getComponent(5);
        if (c.isVisible()) {c.setBounds(insets.left+0,insets.top+109,115,32);}
        c = parent.getComponent(6);
        if (c.isVisible()) {c.setBounds(insets.left+0,insets.top+147,115,32);}
        c = parent.getComponent(7);
        if (c.isVisible()) {c.setBounds(insets.left+0,insets.top+186,115,32);}
        c = parent.getComponent(8);
        if (c.isVisible()) {c.setBounds(insets.left+0,insets.top+224,115,32);}
        c = parent.getComponent(9);
        if (c.isVisible()) {c.setBounds(insets.left+128,insets.top+154,58,19);}
        c = parent.getComponent(10);
        if (c.isVisible()) {c.setBounds(insets.left+128,insets.top+192,58,19);}
        c = parent.getComponent(11);
        if (c.isVisible()) {c.setBounds(insets.left+128,insets.top+115,58,19);}
        c = parent.getComponent(12);
        if (c.isVisible()) {c.setBounds(insets.left+128,insets.top+77,58,19);}
        c = parent.getComponent(13);
        if (c.isVisible()) {c.setBounds(insets.left+128,insets.top+38,58,19);}
        c = parent.getComponent(14);
        if (c.isVisible()) {c.setBounds(insets.left+128,insets.top+230,58,19);}
        c = parent.getComponent(15);
        if (c.isVisible()) {c.setBounds(insets.left+58,insets.top+307,134,26);}
        c = parent.getComponent(16);
        if (c.isVisible()) {c.setBounds(insets.left+205,insets.top+314,58,19);}
        c = parent.getComponent(17);
        if (c.isVisible()) {c.setBounds(insets.left+19,insets.top+339,205,26);}
        c = parent.getComponent(18);
        if (c.isVisible()) {c.setBounds(insets.left+230,insets.top+339,58,19);}
    }
}
