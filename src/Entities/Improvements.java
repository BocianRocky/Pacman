package Entities;

import MapSettings.PacMap;

public enum Improvements implements ImprovementAdapter {
    SPEED(100,"Images/wingsboot.png"){public void adapt(PacMan pacman){
        pacman.editSpeed(1.05);
    }},
    SLOW_GHOSTS(101,"Images/slow.png"){
        public void adapt(){
            Ghost.slow(15);
        }}, MORE_POINTS(102,"Images/addpoints.png"){public void adapt(PacMan pacMan){
        pacMan.addPoints(500);
    }}, PLUS_HP(103,"Images/heart.png"){public void adapt(PacMan pacman){
        pacman.addHP(1);
    }}, MORE_TIME(104,"Images/time.png"){public void adapt(PacMap pacMap){
        pacMap.addTime();
    }};

    private final String photo;
    private final int number;
    Improvements(int number,String photo){
        this.number = number;
        this.photo = photo;
    }
    public String getValue(){
        return photo;
    }
    public int getNumber() {
        return number;
    }



}
