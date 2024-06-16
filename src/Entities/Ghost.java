package Entities;

import MapSettings.PacMap;

import javax.swing.*;

public class Ghost implements Runnable {

    private ImageIcon image;
    private int x;
    private int y;
    int[][] tab;
    private PacMap map;
    private ImageIcon oldPosition;
    private boolean running;
    private static int speed_sleep = 300;
    private int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int directionIndex;

    private Improvements improvement;

    public Ghost(ImageIcon image, int x, int y, int[][] tab, PacMap map) {
        this.image = image;
        this.x = x;
        this.y = y;
        this.tab = tab;
        this.map = map;
        this.oldPosition = new ImageIcon("Images/minpoint.png");
        this.running = true;
    }

    @Override
    public void run() {
        while (running) {
            moving();
            try {
                Thread.sleep(speed_sleep);
            } catch (InterruptedException e) {
                break;
            }
        }
    }

    public ImageIcon getImage() {
        return image;
    }


    public void moving() {
        int[] direction = directions[directionIndex];
        int newX = x + direction[0];
        int newY = y + direction[1];

        if (tab[newX][newY] != 1 && !map.zajetaPozycja(newX, newY)) {
            ImageIcon temp = map.getImages()[newX][newY];
            map.updateGhostPosition(this, x, y, newX, newY, oldPosition);
            this.oldPosition = temp;
            x = newX;
            y = newY;
        } else {
            int tempDirection = -1;
            do {
                tempDirection = (int)(Math.random()*4);
            } while (directionIndex == tempDirection||przeciwnyKierunek(directionIndex, tempDirection));
            directionIndex = tempDirection;
        }
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Improvements getImprovement() {
        return improvement;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public void addImprovement(Improvements improvement) {
        this.improvement = improvement;
    }

    public void infoGift(PacMap pacMap) {
        Thread giftsThread = new Thread(() -> {
            while (running) {
                pacMap.gifts();
                try {
                    Thread.sleep(5000); //co 5 sekund rzuca bonus
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        giftsThread.start();
    }

    public static void slow(int val) {
        speed_sleep += val;
        if (speed_sleep < 40) {
            speed_sleep = 40;
        }
    }

    public void setImprovement(Improvements improvement) {
        this.improvement = improvement;
    }

    public static int getSpeed_sleep() {
        return speed_sleep;
    }

    private boolean przeciwnyKierunek(int a, int b) {
        if (a == 0 && b == 1) return true;
        if (a == 1 && b == 0) return true;
        if (a == 2 && b == 3) return true;
        if (a == 3 && b == 2) return true;

        return false;
    }
}
