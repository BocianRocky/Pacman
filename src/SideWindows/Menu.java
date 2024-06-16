package SideWindows;

import Ranking.HighScores;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu extends JFrame {
    public Menu(){

        setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.BLACK);
        GridBagConstraints gridBagCon = new GridBagConstraints();
        gridBagCon.insets = new Insets(10,10,10,10);

        JButton gameButton = new JButton("New Game");
        JButton scoreButton = new JButton("High Scores");
        JButton exitButton = new JButton("Exit");


        setButton(gameButton);
        setButton(scoreButton);
        setButton(exitButton);

        panel.add(gameButton);
        panel.add(scoreButton);
        panel.add(exitButton);

        gridBagCon.gridx = 0;
        gridBagCon.gridy = 0;
        panel.add(gameButton, gridBagCon);

        gridBagCon.gridx = 1;
        gridBagCon.gridy = 0;
        panel.add(scoreButton, gridBagCon);

        gridBagCon.gridx = 2;
        gridBagCon.gridy = 0;
        panel.add(exitButton, gridBagCon);

        gameButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                setVisible(false);
                new MapSize(Menu.this);
            }
        });
        scoreButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                new HighScores(Menu.this);
            }
        });
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        add(panel, BorderLayout.CENTER);
        generateFrame();

    }
    public void generateFrame(){
        pack();
        setTitle("Pac-Man");
        setMinimumSize(new Dimension(400,150));
        setSize(500, 200);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void setButton(JButton button) {
        button.setForeground(Color.YELLOW);


        button.setFont(new Font("Arial", Font.PLAIN, 20));

        button.setOpaque(false);
        button.setContentAreaFilled(false);
        button.setBorderPainted(false);
        button.setFocusable(false);
        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setFont(new Font("Arial", Font.BOLD, 20));
                button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                button.setForeground(new Color(252, 94, 3));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                button.setFont(new Font("Arial", Font.PLAIN, 20));
                button.setForeground(Color.YELLOW);

            }
        });

    }

}




