package gui;

import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;

	public static String[] columnNames = new String[] { "name","colour","age","variety","cost" };
	public static String[][] infor = new String[10000][5] ;
    // ʹ�ô�DAO���ص�List��ΪTableModel������
 
    // heros.size����һ���ж�����
    public int getRowCount() {
        // TODO Auto-generated method stub
        return InsertPanel.cats.size();
    }
 
    public int getColumnCount() {
        // TODO Auto-generated method stub
        return columnNames.length;
    }
 
    public String getColumnName(int columnIndex) {
        // TODO Auto-generated method stub
        return columnNames[columnIndex];
    }
 
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
 
    // ��ͨ��heros.get(rowIndex)��ȡ�ж�Ӧ��Hero����
    // Ȼ�����columnIndex���ض�Ӧ������
    public Object getValueAt(int rowIndex, int columnIndex) {
    	 return infor[rowIndex][columnIndex];
    }
 
}
