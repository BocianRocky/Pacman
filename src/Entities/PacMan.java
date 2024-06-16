package Entities;

import MapSettings.PacMap;

import javax.swing.*;
import java.awt.event.KeyEvent;
import SideWindows.Menu;
public class PacMan implements Runnable{
    private int x;
    private int y;
    private int[][] tab;
    private PacMap map;
    private ImageIcon imagePac;
    private int dir=KeyEvent.VK_RIGHT;
    private boolean running;
    private int points;
    private int HP=3;
    private int speed_sleep;
    private ImageIcon[][] animations;
    private Menu menu;



    private int direction;

    public ImageIcon getImagePac() {
        return imagePac;
    }

    public PacMan(int x, int y, int[][] tab, Menu menu, PacMap map, ImageIcon imagePac) {
        this.x = x;
        this.y = y;
        this.tab = tab;
        this.map = map;
        this.imagePac = imagePac;
        this.running = true;
        this.points = 0;
        this.speed_sleep = 350;
        this.animations=getAnimations();
        this.direction = 0;
        this.menu = menu;

    }


    @Override
    public void run() {
        startAnimation();
        while (running) {
            move();
            try{
                Thread.sleep(speed_sleep);
            }catch(InterruptedException e){
                break;
            }
        }
    }

    public void move(){
        int newX=x;
        int newY=y;
        switch(dir){
            case KeyEvent.VK_UP:{
                direction=0;
                newX--;
                break;
            }
            case KeyEvent.VK_DOWN:{
                direction=1;
                newX++;
                break;
            }
            case KeyEvent.VK_LEFT:{
                direction=2;
                newY--;
                break;
            }
            case KeyEvent.VK_RIGHT:{
                direction=3;
                newY++;
                break;
            }
            case KeyEvent.VK_ESCAPE:{
                map.closeThreads();
                map.dispose();
                menu.setVisible(true);
            }
        }
        if(tab[newX][newY]!=1) {
            map.updatePacPosition(x, y, newX, newY, tab);
            x=newX;
            y=newY;
        }

    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }
    public void addPoints(int points) {
        this.points += points;
    }

    public int getPoints() {
        return points;
    }

    public int getHP() {
        return HP;
    }
    public void addHP(int HP) {
        this.HP += HP;
    }

    public void minusHP(){
        HP--;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void editSpeed(double val){
        this.speed_sleep = (int) (this.speed_sleep / val);
        if(this.speed_sleep<100){
            this.speed_sleep=100;
        }

    }
    public void addSpeed(int val){
        this.speed_sleep+=val;
    }
    public void startAnimation(){
        new Thread(()->{
            int index=0;
            while(running){
                if(direction==3) {
                    imagePac = animations[3][index];
                } else if (direction==2) {
                    imagePac = animations[2][index];
                } else if (direction==1) {
                    imagePac = animations[1][index];
                }else if(direction==0) {
                    imagePac = animations[0][index];
                }
                index=(index+1)%animations[0].length;


                try{
                    Thread.sleep(100);
                }catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public int getSpeed_sleep() {
        return speed_sleep;
    }
    public ImageIcon[][] getAnimations() {
        ImageIcon[] tab = {
                new ImageIcon("Images/pac_up_open.png"),
                new ImageIcon("Images/pac_up_close.png"),
                new ImageIcon("Images/pac_down_open.png"),
                new ImageIcon("Images/pac_down_close.png"),
                new ImageIcon("Images/pac_left_open.png"),
                new ImageIcon("Images/pac_left_close.png"),
                new ImageIcon("Images/pac_right_open.png"),
                new ImageIcon("Images/pac_right_close.png")};
        ImageIcon[][] offTab=new ImageIcon[4][2];

        int index = 0;
        for (int i = 0; i < offTab.length; i++) {
            for (int j = 0; j < offTab[i].length; j++) {
                offTab[i][j] = tab[index++];
            }
        }

        return offTab;

    }

}

