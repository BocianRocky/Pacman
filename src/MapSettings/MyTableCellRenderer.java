package MapSettings;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class MyTableCellRenderer extends JLabel implements TableCellRenderer {
    public MyTableCellRenderer() {
        setOpaque(true);

    }
    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        this.setBackground(Color.BLACK);
        setIcon((ImageIcon) value);
        this.setForeground(this.getBackground());

        return this;
    }

}
