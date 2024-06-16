package Ranking;

import javax.swing.*;
import java.util.Vector;

public class HSModel extends AbstractListModel {

    public Vector<Player>players;

    public HSModel(Vector<Player>players){
        this.players = players;
    }
    @Override
    public int getSize() {
        return players.size();
    }

    @Override
    public Object getElementAt(int index) {
        return players.get(index);
    }
}
