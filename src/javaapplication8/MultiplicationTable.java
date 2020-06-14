package javaapplication8;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MultiplicationTable extends JFrame {

    private Container container;
    private ImageIcon img;
    private JLabel label;
    private JTextField txtField;
    private JTextArea txtArea;
    private Font font1, font2, font3;
    private JButton btn;
    private Cursor cursor;

    MultiplicationTable() {
        initcomponents();
    }

    public void initcomponents() {
        container = this.getContentPane();
        container.setBackground(Color.pink);
        container.setLayout(null);

        img = new ImageIcon(getClass().getResource("images.jpg"));

        label = new JLabel(img);
        label.setBounds(25, 10, img.getIconWidth(), img.getIconHeight());
        container.add(label);

        font1 = new Font("Areal", Font.BOLD, 20);
        font2 = new Font("Areal", Font.BOLD, 18);
        font3 = new Font("Areal", Font.BOLD, 15);

        label = new JLabel();
        label.setText("Enter any number :");
        label.setBounds(25, 215, 180, 25);
        label.setFont(font2);
        label.setForeground(Color.BLUE);
        container.add(label);

        txtField = new JTextField();
        txtField.setBounds(220, 205, 85, 40);
        txtField.setFont(font1);
        txtField.setBackground(Color.ORANGE);
        txtField.setHorizontalAlignment(JTextField.CENTER);
        txtField.setToolTipText("Give me the number");
        container.add(txtField);

        cursor = new Cursor(Cursor.HAND_CURSOR);
        btn = new JButton();
        btn.setText("Clear");
        btn.setBounds(220, 250, 85, 40);
        btn.setCursor(cursor);
        btn.setFont(font3);
        btn.setBackground(Color.black);
        btn.setForeground(Color.WHITE);
        container.add(btn);

        txtArea = new JTextArea();
        txtArea.setBounds(25, 300, 280, 360);
        txtArea.setBackground(Color.GREEN);
        txtArea.setFont(font2);
        container.add(txtArea);

        txtField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                String value = txtField.getText();

                if (value.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "You did not enter any number.");
                } else {
                    txtArea.setText("");
                    int num = Integer.parseInt(txtField.getText());
                    for (int i = 0; i <= 10; i++) {
                        int result = num * i;

                        String n = String.valueOf(num);
                        String r = String.valueOf(result);
                        String incr = String.valueOf(i);

                        txtArea.append(n + " X " + incr + " = " + r + "\n");
                    }

                }

            }
        });

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                txtArea.setText("");
                txtField.setText("");
            }

        });
    }

    public static void main(String[] args) {
        MultiplicationTable frame = new MultiplicationTable();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(500, 25, 330, 700);
        frame.setTitle("Times Table Software");
        frame.setResizable(false);
    }

}
