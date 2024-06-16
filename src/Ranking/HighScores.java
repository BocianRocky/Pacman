package Ranking;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Vector;
import SideWindows.Menu;

public class HighScores extends JFrame {
    private Menu menu;
    private FileLoader fl;
    public HighScores(Menu menu) {
        this.menu = menu;
        this.fl = new FileLoader("scoresss.txt");
        fl.readFile();

        Vector<Player>sortPlayers=new Vector<>(fl.getSortPlayers());
        HSModel hsModel=new HSModel(sortPlayers);
        JList jlist=new JList();
        jlist.setForeground(Color.YELLOW);
        jlist.setBackground(Color.BLACK);
        jlist.setModel(hsModel);
        JScrollPane jsp=new JScrollPane(jlist);
        this.getContentPane().add(jsp);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                menu.setVisible(true);
            }
        });


        generateFrame();
    }
    public void generateFrame(){

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
