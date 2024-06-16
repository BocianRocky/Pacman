package SideWindows;

import MapSettings.PacMap;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MapSize extends JFrame {
    private int[][] map;
    private Menu menu;

    public MapSize(Menu menu) {
        this.menu = menu;
        getContentPane().setBackground(Color.BLACK);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Color.BLACK);
        JButton small = new JButton("Small");
        JButton medium = new JButton("Medium");
        JButton large = new JButton("Large");
        JButton wide = new JButton("Wide");
        JButton octagon = new JButton("Octagon");

        setButton(small);
        setButton(medium);
        setButton(large);
        setButton(wide);
        setButton(octagon);


        panel.add(Box.createRigidArea(new Dimension(0, 15)));
        panel.add(small);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));
        panel.add(medium);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));
        panel.add(large);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));
        panel.add(wide);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));
        panel.add(octagon);
        panel.add(Box.createRigidArea(new Dimension(0, 15)));


        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        add(panel, gbc);


        small.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                typeMap(0);
                new PacMap(map, menu);
                dispose();
            }
        });
        medium.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                typeMap(1);
                new PacMap(map, menu);
                dispose();
            }
        });
        large.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                typeMap(2);
                new PacMap(map, menu);
                dispose();
            }
        });
        wide.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                typeMap(3);
                new PacMap(map, menu);
                dispose();
            }
        });
        octagon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                typeMap(4);
                new PacMap(map, menu);
                dispose();
            }
        });

        generateFrame();
    }

    public void generateFrame() {
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public void typeMap(int type){
        switch(type){
            case 0:{
                map=new int[][]{{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                        {1,0,1,1,1,1,1,1,0,0,1,1,1,1,1,1,0,1,1,1,1,1},
                        {1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,1,1,1,1},
                        {1,0,1,0,0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,1},
                        {1,0,1,1,1,1,1,1,0,1,1,1,1,1,1,1,0,1,1,1,1,1},
                        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                        {1,1,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1},
                        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,1},
                        {1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,1,1,0,1},
                        {1,0,1,0,1,1,1,1,1,1,1,1,1,1,0,1,0,1,1,1,0,1},
                        {1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0,1,1,1,0,1},
                        {1,0,1,1,1,1,1,1,0,0,1,1,1,1,1,1,0,1,1,1,0,1},
                        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
                };
                break;
            }
            case 1:{
                map=new int[][]{{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                        {1,0,1,1,0,1,1,1,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1},
                        {1,0,1,1,0,1,0,0,0,1,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1},
                        {1,0,1,1,0,1,0,1,1,1,1,1,1,1,1,0,1,0,1,1,1,1,1,1,1,1,0,0,1},
                        {1,0,1,1,0,0,0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,1},
                        {1,0,1,1,1,1,1,1,0,1,1,1,1,1,1,0,1,0,0,1,1,1,1,1,1,1,1,0,1},
                        {1,0,1,1,1,1,1,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                        {1,0,1,1,1,1,1,1,0,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1},
                        {1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,0,1},
                        {1,0,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,0,1,1,1,1,0,1},
                        {1,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,1,0,1,0,1,1,1,1,0,1},
                        {1,0,1,1,1,1,1,1,0,1,0,1,1,1,1,0,1,1,0,1,0,1,0,1,1,1,1,0,1},
                        {1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,1,0,0,0,1,0,0,0,0,0,0,1},
                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}


                };
                break;
            }
            case 2:{
                map=new int[][]{{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                        {1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1},
                        {1,0,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,0,1},
                        {1,0,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,0,1},
                        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                        {1,0,1,1,1,1,0,1,1,0,1,1,1,1,1,1,1,1,0,1,1,0,1,1,1,1,0,1},
                        {1,0,0,0,0,0,0,1,1,0,0,0,0,1,1,0,0,0,0,1,1,0,0,0,0,0,0,1},
                        {1,1,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,1,1},
                        {1,1,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,1,1},
                        {1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1},
                        {1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1},
                        {1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,1,1,1,1},
                        {1,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,1},
                        {1,0,1,1,1,1,1,1,1,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,0,1},
                        {1,0,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,0,1},
                        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                        {1,0,1,1,1,1,0,1,1,0,1,1,1,1,1,1,1,1,0,1,1,0,1,1,1,1,0,1},
                        {1,0,0,0,0,0,0,1,1,0,0,0,0,1,1,0,0,0,0,1,1,0,0,0,0,0,0,1},
                        {1,1,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,1,1},
                        {1,1,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,1,1},
                        {1,1,1,1,1,1,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,1,1,1,1,1,1},
                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}

                };
                break;

            }
            case 3:{
                map = new int[][]{
                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                        {1,0,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,1,1,0,1},
                        {1,0,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,1,1,0,1},
                        {1,0,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,1,1,0,1},
                        {1,0,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,1,1,0,1},
                        {1,0,1,1,1,1,0,0,0,0,0,0,0,1,1,0,1,1,1,1,1,0,0,0,0,0,0,0,0,1},
                        {1,0,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,1,1,0,1},
                        {1,0,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,1,1,0,1},
                        {1,0,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,1,1,0,1},
                        {1,0,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,1,1,0,1},
                        {1,0,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,1,1,0,1},
                        {1,0,0,0,0,0,0,1,1,1,1,1,0,1,1,0,0,0,0,0,0,0,1,1,1,1,1,1,0,1},
                        {1,0,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,1,1,0,1},
                        {1,0,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,1,1,0,1},
                        {1,0,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,1,1,0,1},
                        {1,0,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,1,1,0,1},
                        {1,0,1,1,1,1,0,0,0,0,0,0,0,1,1,0,1,1,1,1,1,0,0,0,0,0,0,0,0,1},
                        {1,0,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,1,1,0,1},
                        {1,0,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,1,1,0,1},
                        {1,0,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,1,1,0,1},
                        {1,0,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,1,1,0,1},
                        {1,0,1,1,1,1,0,1,1,1,1,1,0,1,1,0,1,1,1,1,1,0,1,1,1,1,1,1,0,1},
                        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}
                };

                break;
            }
            case 4:{
                map = new int[][]{{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
                        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                        {1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
                        {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}


                };
                break;
            }
            default:{
                throw new RuntimeException();
            }
        }


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
