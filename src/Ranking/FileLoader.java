package Ranking;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class FileLoader{

    private String file;
    private List<Player>players=new ArrayList<>();

    public FileLoader(String file){
        this.file = file;
    }
    public void readFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {

            while (true) {
                try {
                    Player p = (Player) ois.readObject();
                    players.add(p);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("puste");
        }
    }
    public void writeToFile(Player p){
        readFile();
        ObjectOutputStream oos = null;
        players.add(p);
        try{
            oos = new ObjectOutputStream(new FileOutputStream(file));
            for(Player p1 : players){
                oos.writeObject(p1);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public List<Player> getSortPlayers(){
        Comparator<Player> cmp = new Comparator<Player>() {
            @Override
            public int compare(Player o1, Player o2) {
                return o2.points-o1.points;
            }
        };
        players.sort(cmp);
        return players;
    }


}
