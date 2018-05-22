package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import 宠物商店文件版.PetShop;
//这个面板类主要是综合显示商店里已有的宠物信息
public class HomePanel extends JPanel {
	static {
		MainPanel.GUINF();
		//insert_pet_init();
	}

	private static final long serialVersionUID = 1L;
	public static JButton pet_name = new JButton("pet name");
	public static JButton pet_colour = new JButton("pet colour");
	public static JButton pet_age = new JButton("pet age");
	public static JButton pet_variety= new JButton("pet variety");
	public static JButton pet_cost = new JButton("pet cost");
	public JFrame f = new JFrame("Home");
	public static JPanel panel_0 = new JPanel();
	public JPanel panel_1= new JPanel();
	public JTextField name_text = new JTextField();
	public static JScrollPane pane1 = new JScrollPane(panel_0);
 
    public JDialog dialog = new JDialog(f);
    public static JPanel []row = new JPanel[InsertPanel.cats.size()];
    public static JPanel column = new JPanel();
    public static JPanel firstrow = new JPanel();
    public static ArrayList<JPanel> firstrow_m = new ArrayList<>();
 	//public  static String [][]infor = new String[10000][5];
// 	public static TableModel model = new TableModel();
//    public  static String columns[] = new String[] {"name","colour","age","variety","cost"};
//    public  static DefaultTableModel model = new DefaultTableModel(infor, columns);
//    public static JTable table = new JTable(model);
    public static    String[] columnNames = { "name","colour","age","variety","cost" };
    public  static   Object[][] infor =null;
    public static     JTable table = new JTable(infor, columnNames);
    public static    DefaultTableModel model = new DefaultTableModel(infor, columnNames) {
		private static final long serialVersionUID = 1L;
		public boolean isCellEditable(int row, int column) {
	        return false;
	      }
	    };

    public static int  index = 0  ;
    public static int  index_d= 0  ;
	public HomePanel() {
	
	}

	public static HomePanel instance = new HomePanel();
	public void west(int row) {
		pane1.setLayout(new GridLayout(row,1));
		for(int i= 0 ;i< InsertPanel.cats.size() ;i ++) {
			JButton pet = new JButton();
			pet.setText(InsertPanel.cats.get(i).name);
			pane1.add(pet);
		}		
	}
	public void center() {
		panel_1.setLayout(new GridLayout(6,2));
		
	}
	public void set_column(int row) {
		column.setLayout(new GridLayout(row,1));
		
		for(int i= 0 ;i< InsertPanel.cats.size() ;i ++)
		{
			column.add(firstrow_m.get(i));
			
		}
	}
	public void showpanel() {     			
		dialog.setSize(420, 400);
		dialog.setLocation(300, 300);
		panel_1.setLayout(new BorderLayout());		
		//table = new JTable(model);

         panel_1.add(panel_0,BorderLayout.NORTH);
//         DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
//         tableModel.addRow(new Object[]{"sitinspring", "35", "Boss"});
	
		pane1 = new JScrollPane(table); 
        dialog.add(pane1);
        dialog.setModal(true);
        dialog.setVisible(true);
        dialog.setResizable(false);
	}
	
	public static void insert_pet() {
		     String temp[] = new String[5];		  
			 DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		     temp[0]= InsertPanel.cats.get( InsertPanel.cats.size()-1).name;
		     temp[1]= InsertPanel.cats.get(InsertPanel.cats.size()-1).color;
		     temp[2]= InsertPanel.cats.get(InsertPanel.cats.size()-1).age;
		     temp[3]= InsertPanel.cats.get(InsertPanel.cats.size()-1).variety;
		     temp[4]= InsertPanel.cats.get(InsertPanel.cats.size()-1).cost;		
		   //  System.out.println( InsertPanel.cats.get(InsertPanel.cats.size()-1).toString());
		     tableModel.addRow(temp);
		     table.invalidate();
		     table.updateUI();

	
	}
	
	public static void insert_pet_init() {
	     String temp[] = new String[5];		  
				 DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
			     temp[0]= InitPanel.cat_init.get( InitPanel.cat_init.size()-1).name;
			     temp[1]= InitPanel.cat_init.get(InitPanel.cat_init.size()-1).color;
			     temp[2]= InitPanel.cat_init.get(InitPanel.cat_init.size()-1).age;
			     temp[3]= InitPanel.cat_init.get(InitPanel.cat_init.size()-1).variety;
			     temp[4]= InitPanel.cat_init.get(InitPanel.cat_init.size()-1).cost;		
			   //  System.out.println( InsertPanel.cats.get(InsertPanel.cats.size()-1).toString());
			     tableModel.addRow(temp);
			     table.invalidate();
			     table.updateUI();

		
	}
	public static void main(String[] args) {
		instance.showpanel();
	}
}
