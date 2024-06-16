package MapSettings;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class MapModel extends AbstractTableModel {
    ImageIcon[][] images;
    public MapModel(ImageIcon[][] images){
        this.images = images;
    }
    @Override
    public int getRowCount() {
        return images.length;
    }

    @Override
    public int getColumnCount() {
        return images[0].length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return images[rowIndex][columnIndex];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return ImageIcon.class;
    }
}
