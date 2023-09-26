import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Traffic extends JFrame implements ActionListener {
    String msg = "";
    private JLabel label;
    private JRadioButton r1, r2, r3;
    private Container c;
    private JTextField display;
    private ButtonGroup bg;

    public Traffic() {
        setLayout(new FlowLayout());
        c = getContentPane();
        label = new JLabel("Traffic Light");
        display = new JTextField(10);
        r1 = new JRadioButton("RED");
        r2 = new JRadioButton("GREEN");
        r3 = new JRadioButton("YELLOW");
        r1.setBounds(50, 50, 100, 10);
        bg = new ButtonGroup();
        c.add(label);
        c.add(r1);
        c.add(r2);
        c.add(r3);
        c.add(display);
        bg.add(r1);
        bg.add(r2);
        bg.add(r3);
        r1.setLocation(250, 150);

        r1.addActionListener(this);
        r2.addActionListener(this);
        r3.addActionListener(this);

        setSize(800, 800);
        setVisible(true);
        c.setBackground(Color.white);
    }

    public void actionPerformed(ActionEvent ie) {
        msg = ie.getActionCommand();
        if (msg.equals("RED")) {
            c.setBackground(Color.RED);
            display.setText(msg + ":STOP");
        } else if (msg.equals("GREEN")) {
            c.setBackground(Color.GREEN);
            display.setText(msg + ":GO");
        } else if (msg.equals("YELLOW")) {
            c.setBackground(Color.YELLOW);
            display.setText(msg + ":READY");
        }
    }

    public static void main(String args[]) {
        Traffic tf = new Traffic();
        tf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
