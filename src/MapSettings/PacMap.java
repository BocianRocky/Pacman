package MapSettings;

import Entities.Ghost;
import Entities.Improvements;
import Entities.PacMan;
import Ranking.FileLoader;
import Ranking.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import SideWindows.Menu;

public class PacMap extends JFrame {


    private ImageIcon[][]images;
    private JTable field;
    private int currPacX=1;
    private int currPacY=1;
    private PacMan pacMan;
    ArrayList<Ghost>ghosts;
    private JLabel countPoints;
    private JLabel countTime;
    private JLabel countHP;
    private JLabel speedPac;
    private JLabel speedGhosts;
    private int pacTimer=0;
    int [][]tab;
    boolean running=true;
    private Menu menu;

    public PacMap(int [][]tab, Menu menu){
        this.menu=menu;
        this.tab=tab;
        Color colorBackground = new Color(6,16,79);
        images = setImagesAsBackground(tab);

        pacMan=new PacMan(currPacX,currPacY,tab,menu,this,new ImageIcon("Images/pacmannn.png"));



        field = new JTable(new MapModel(images));
        field.setDefaultRenderer(ImageIcon.class, new MyTableCellRenderer());
        field.setTableHeader(null);
        field.setBackground(colorBackground);
        field.setGridColor(colorBackground);


        JPanel infoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel infoPaneldown = new JPanel(new FlowLayout(FlowLayout.LEFT));

        infoPanel.setBackground(colorBackground);
        infoPaneldown.setBackground(colorBackground);

        countPoints =new JLabel("Count Points: "+pacMan.getPoints());
        countTime=new JLabel("Time: "+pacTimer);
        countHP=new JLabel("HP: "+pacMan.getHP());
        speedPac=new JLabel("Speed-pac: "+(1000-pacMan.getSpeed_sleep()));
        speedGhosts=new JLabel("Speed-ghosts: "+(1000-Ghost.getSpeed_sleep()));
        Font topFont =new Font("Calibri",Font.BOLD,18);
        Font botFont =new Font("Arial",Font.BOLD,12);

        countPoints.setFont(topFont);
        countTime.setFont(topFont);
        countHP.setFont(topFont);

        speedPac.setFont(botFont);
        speedGhosts.setFont(botFont);

        countTime.setForeground(new Color(53, 132, 234));
        countHP.setForeground(new Color(215,55,55));
        countPoints.setForeground(new Color(179, 179, 5));

        speedPac.setForeground(new Color(220, 117, 38));
        speedGhosts.setForeground(new Color(158, 74, 1));


        infoPanel.add(countPoints);
        infoPanel.add(countTime);
        infoPanel.add(countHP);
        infoPaneldown.add(speedPac);
        infoPaneldown.add(speedGhosts);

        setLayout(new BorderLayout());

        JScrollPane pane = new JScrollPane(field);
        pane.getViewport().setBackground(colorBackground);
        add(pane, BorderLayout.CENTER);
        add(infoPanel, BorderLayout.NORTH);
        add(infoPaneldown, BorderLayout.SOUTH);
        field.setFocusable(true);
        field.requestFocusInWindow();
        field.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();
                pacMan.setDir(keyCode);
                pacMan.move();


            }


        });
        ghosts=new ArrayList<>();
        ghosts.add(new Ghost(new ImageIcon("Images/greenghost.png"),1,5,tab,this));
        ghosts.add(new Ghost(new ImageIcon("Images/redghost.png"),1,tab[1].length-2,tab,this));
        ghosts.add(new Ghost(new ImageIcon("Images/blueghost.png"),tab.length-5,1,tab,this));
        ghosts.add(new Ghost(new ImageIcon("Images/purpleghost.png"),tab.length-5,tab[tab.length-5].length-2,tab,this));

        for(Ghost ghost:ghosts){
            new Thread(ghost).start();
        }
        new Thread(pacMan).start();
        timer();



        checkEnding();
        for(Ghost ghost : ghosts){
            ghost.infoGift(this);
        }
        getContentPane().setBackground(colorBackground);
        setTitle("Pac-Man");
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    public ImageIcon[][] setImagesAsBackground(int [][]tab){

        int x=tab.length;
        int y=tab[0].length;
        ImageIcon[][] images = new ImageIcon[x][y];


        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if(tab[i][j]==1){
                    images[i][j] = new ImageIcon("Images/block.png");

                }
                if(tab[i][j]==0){
                    images[i][j] = new ImageIcon("Images/minpoint.png");
                }
            }
        }
        images[currPacX][currPacY]=new ImageIcon("Images/pacmannn.png");

        return images;
    }
    public void updateGhostPosition(Ghost ghost,int oldX,int oldY,int newX,int newY, ImageIcon oldPosition){
        if(checkField()){   //jezli pacman zebral wszssystkie pkt
            for (int i = 0; i < tab.length; i++) {
                for (int j = 0; j < tab[i].length; j++) {
                    if(tab[i][j]==2){
                        tab[i][j]=0;
                        images[i][j]=new ImageIcon("Images/minpoint.png");
                    }
                }
            }
            pacMan.setX(1);
            pacMan.setY(1);
            images[1][1]=new ImageIcon("Images/pacmannn.png");
            setUpgrade();


        }

        if(tab[oldX][oldY]==2){
            images[oldX][oldY]=new ImageIcon("Images/allblack.png");
        }else if(tab[oldX][oldY]==3 ||tab[oldX][oldY]==4||tab[oldX][oldY]==5||tab[oldX][oldY]==6||tab[oldX][oldY]==7){
            images[oldX][oldY]=oldPosition;
        }else if(tab[oldX][oldY]==0){
            images[oldX][oldY]=new ImageIcon("Images/minpoint.png");
        }



        images[newX][newY]=ghost.getImage();



        if(ghost.getImprovement()!=null){
            int x=ghost.getImprovement().getNumber();
            images[oldX][oldY]=new ImageIcon(ghost.getImprovement().getValue());

            switch (x) {
                case 100: {
                    tab[oldX][oldY] = 3;
                    break;
                }
                case 101: {
                    tab[oldX][oldY] = 4;
                    break;
                }
                case 102: {
                    tab[oldX][oldY] = 5;
                    break;
                }
                case 103: {
                    tab[oldX][oldY] = 6;
                    break;
                }
                case 104: {
                    tab[oldX][oldY] = 7;
                    break;
                }
            }
            ghost.setImprovement(null);





        }

        field.repaint();

    }
    public void updatePacPosition(int oldX,int oldY,int newX,int newY, int [][]tab){
        tab[oldX][oldY]=2;
        if(tab[newX][newY]==0){
            pacMan.addPoints(10);

        }else if(tab[newX][newY]==3){
            Improvements.SPEED.adapt(pacMan);
            speedPac.setText("Speed-pac: "+(1000-pacMan.getSpeed_sleep()));
        }else if(tab[newX][newY]==4){
            Improvements.SLOW_GHOSTS.adapt();
            speedGhosts.setText("Speed-ghosts: "+(1000-Ghost.getSpeed_sleep()));

        }else if(tab[newX][newY]==5){
            Improvements.MORE_POINTS.adapt(pacMan);
        }else if(tab[newX][newY]==6){
            Improvements.PLUS_HP.adapt(pacMan);
            countHP.setText("HP: "+pacMan.getHP());
        }else if(tab[newX][newY]==7){
            Improvements.MORE_TIME.adapt(this);
            countTime.setText("Time: "+pacTimer);
        }
        countPoints.setText("Count Points: "+pacMan.getPoints());

        images[oldX][oldY]=new ImageIcon("Images/allblack.png");
        images[newX][newY]=pacMan.getImagePac();
        field.repaint();
    }


    public void checkFailure(){
        for(Ghost ghost:ghosts){
            if((ghost.getX()==pacMan.getX()&&ghost.getY()==pacMan.getY())||(pacTimer>=90)){
                pacMan.minusHP();
                images[ghost.getX()][ghost.getY()]=ghost.getImage();

                int hp=pacMan.getHP();
                countHP.setText("HP: "+hp);
                if(hp==0) {
                    closeThreads();
                    this.dispose();

                    String message="GAME OVER !!!\nZdobyłeś "+pacMan.getPoints()+" punktów.";
                    String name=JOptionPane.showInputDialog(null,message,"KONIEC", JOptionPane.INFORMATION_MESSAGE);
                    if(name!=null){
                        Player player = new Player(name,pacMan.getPoints());
                        FileLoader fl = new FileLoader("scoresss.txt");
                        fl.writeToFile(player);

                    }
                    menu.setVisible(true);
                }else{
                    pacMan.setX(1);
                    pacMan.setY(1);
                    images[1][1]=new ImageIcon("Images/pac_right_open.png");
                }

            }
        }
    }

    public ImageIcon[][] getImages() {
        return images;
    }
    public void checkEnding(){
        Thread x = new Thread(()->{
            while(running){
                checkFailure();
                try{
                    Thread.sleep(10);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }

        });
        x.start();
    }
    public void timer(){
        Thread time = new Thread(()->{
            while(running){
                pacTimer++;
                countTime.setText("Time: "+pacTimer);
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }

        });
        time.start();

    }
    public boolean checkField(){
        boolean flag = true;
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                if(tab[i][j]==0){
                    flag = false;
                }
            }
        }
        return flag;
    }

    public void addTime(){
        if((pacTimer-20)<=0){
            pacTimer =0;
        }else {
            pacTimer -= 20;

        }
        countTime.setText("Time: "+pacTimer);
    }
    public void gifts() {
        int number = 0;
        int giftNumber = 0;
        for (Ghost ghost : ghosts) {
            number = (int) (Math.random() * 4);
            if (number == 1) {
                giftNumber = (int)(Math.random()*Improvements.values().length);
                ghost.addImprovement(Improvements.values()[giftNumber]);
            }else{
                ghost.setImprovement(null);
            }
        }
    }

    public void closeThreads(){
        running=false;
        for (Ghost ghosttt : ghosts) {
            ghosttt.setRunning(running);
        }
        pacMan.setRunning(running);
    }
    public void setUpgrade(){
        Ghost.slow(-200);
        pacMan.addSpeed(100);
        if(pacTimer-40<0){
            pacTimer=0;
        }else {
            pacTimer -= 40;
        }

        speedGhosts.setText("Speed-ghosts: "+(1000-Ghost.getSpeed_sleep()));
        speedPac.setText("Speed-pac: "+(1000-pacMan.getSpeed_sleep()));

    }
    public boolean zajetaPozycja(int x, int y) {
        for (Ghost ghost :ghosts) {
            if (ghost.getX()==x && ghost.getY()==y) {
                return true;
            }
        }
        return false;
    }



}
