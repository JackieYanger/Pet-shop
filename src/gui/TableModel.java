package gui;

import javax.swing.table.AbstractTableModel;

public class TableModel extends AbstractTableModel {
	private static final long serialVersionUID = 1L;

	public static String[] columnNames = new String[] { "name","colour","age","variety","cost" };
	public static String[][] infor = new String[10000][5] ;
    // 使用从DAO返回的List作为TableModel的数据
 
    // heros.size返回一共有多少行
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
 
    // 先通过heros.get(rowIndex)获取行对应的Hero对象
    // 然后根据columnIndex返回对应的属性
    public Object getValueAt(int rowIndex, int columnIndex) {
    	 return infor[rowIndex][columnIndex];
    }
 
}
