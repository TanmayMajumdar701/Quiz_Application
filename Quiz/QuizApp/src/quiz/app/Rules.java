package quiz.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Rules extends JFrame implements ActionListener {

    JButton start, back;
    String name;

    Rules(String name) {
        this.name = name;

        setSize(800, 650);
        setLocation(350, 100);
        setLayout(null);
        setUndecorated(true);

        // Load background first
        java.net.URL imgURL = ClassLoader.getSystemResource("icons/back.png");
        JLabel image = null;
        if (imgURL != null) {
            ImageIcon i1 = new ImageIcon(imgURL);
            Image i = i1.getImage().getScaledInstance(800, 650, Image.SCALE_DEFAULT);
            ImageIcon i2 = new ImageIcon(i);
            image = new JLabel(i2);
            image.setBounds(0, 0, 800, 650);
            image.setLayout(null);
            add(image);
        } else {
            System.err.println("Image not found: icons/back.png");
        }

        JLabel heading = new JLabel("Welcome " + name + " to QUIZ TEST");
        heading.setBounds(150, 100, 700, 30);
        heading.setFont(new Font("Viner Hand ITC", Font.BOLD, 28));
        heading.setForeground(new Color(22, 99, 54));

        JLabel rules = new JLabel();
        rules.setBounds(70, 150, 700, 350);
        rules.setFont(new Font("Tahoma", Font.BOLD, 16));
        rules.setForeground(new Color(22, 99, 54));
        rules.setText(
                "<html>" +
                        "1. Participation in the quiz is free and open to all persons above 18 years old.<br><br>" +
                        "2. There are a total 10 questions.<br><br>" +
                        "3. You only have 15 seconds to answer the question.<br><br>" +
                        "4. No cell phones or other secondary devices in the room or test area.<br><br>" +
                        "5. No talking.<br><br>" +
                        "6. No one else can be in the room with you.<br><br>" +
                        "</html>"
        );

        back = new JButton("Back");
        back.setBounds(300, 500, 100, 30);
        back.setBackground(new Color(22, 99, 54));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);

        start = new JButton("Start");
        start.setBounds(450, 500, 100, 30);
        start.setBackground(new Color(22, 99, 54));
        start.setForeground(Color.WHITE);
        start.addActionListener(this); // fixed

        if (image != null) {
            image.add(heading);
            image.add(rules);
            image.add(back);
            image.add(start);
        } else {
            add(heading);
            add(rules);
            add(back);
            add(start);
        }

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == start) {
            setVisible(false);
            new Quiz(name);
        } else {
            setVisible(false);
            new Login();
        }
    }

    public static void main(String[] args) {
        new Rules("User");
    }
}
