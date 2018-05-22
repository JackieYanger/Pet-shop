package gui;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

import ³èÎïÉÌµêÎÄ¼þ°æ.Cat;
import ³èÎïÉÌµêÎÄ¼þ°æ.Pet;
public class MainPanel extends Thread{
	static {
		GUINM();
	}
	private static final long serialVersionUID = 1L;
 	public JFrame f = new JFrame("                                                                            Pet Shop");
 	public JPanel panel = new JPanel();
 	public JButton home = new JButton("Home");
 	public JButton insert= new JButton("Insert");
 	public JButton delete= new JButton("Delete");
 	public JButton modify = new JButton("Modify");
 	public JButton find = new JButton("Find");
 	public JButton write_in_client = new JButton("Write in client");    
 	public JButton init = new JButton("download all data from database");
	public static ArrayList<Cat>  cat_init = new ArrayList<>();
//    public static    String[] columnNames = { "name","colour","age","variety","cost" };
//    public  static   Object[][] infor =null;
//    public static     JTable table = new JTable(infor, columnNames);
//    public static    DefaultTableModel model = new DefaultTableModel(infor, columnNames) {
//		private static final long serialVersionUID = 1L;
//		public boolean isCellEditable(int row, int column) {
//	        return false;
//	      }
//	    };
 	private MainPanel()  {
 	

         
 	}
    private void showpanel() throws SQLException {   	
        f.setSize(745, 715);
    	f.setLocation(300, 20);
		//HomePanel.insert_pet_init();
    //	InitPanel.select();
    	//sql();
    	JPanel tm_panel = new JPanel();
    	tm_panel.setLayout(new BorderLayout());
    	HomePanel.table = new JTable(HomePanel.model);
    	panel.add(insert);
    	panel.setLayout(new GridLayout(2,3));
    	showbutton();              
    	panel.add(home);
    	panel.add(insert);
    	panel.add(delete);
    	panel.add(modify);
    	panel.add(find);
    	panel.add(write_in_client);
    	tm_panel.add(panel,BorderLayout.NORTH);
    	tm_panel.add(init,BorderLayout.SOUTH);
    	HomeListener homelistener = new HomeListener();
    	InsertListener insertlistener=new InsertListener();
    	DeleteListener deletelistener=new DeleteListener();
    	ModifyListener modifylistener = new ModifyListener();
    	FindListener findlistener = new FindListener();
    	WriteListener writelistener= new WriteListener();
    	InitListener initlistener = new InitListener();
        home.addActionListener(homelistener);
        insert.addActionListener(insertlistener);
        delete.addActionListener(deletelistener);
        modify.addActionListener(modifylistener);
        find.addActionListener(findlistener);
        write_in_client.addActionListener(writelistener);
        init.addActionListener(initlistener);
    	f.add(tm_panel);
    	f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	f.setResizable(false);
    	f.setVisible(true);
    }
    public void showbutton() {
    	 ImageIcon phome = new ImageIcon("d:/Èý¼ÑºþÑ©¾°/Ê×Ò³.png");
    	 home.setIcon(phome);
    	 home.setVerticalTextPosition(JButton.BOTTOM);
    	 home.setHorizontalTextPosition(JButton.CENTER);
    	 ImageIcon pinsert = new ImageIcon("d:/Èý¼ÑºþÑ©¾°/±à¼­.png");
    	 insert.setIcon(pinsert);
    	 insert.setVerticalTextPosition(JButton.BOTTOM);
    	 insert.setHorizontalTextPosition(JButton.CENTER);
    	 ImageIcon pdelete = new ImageIcon("d:/Èý¼ÑºþÑ©¾°/É¾³ý.png");
    	 delete.setIcon(pdelete);
    	 delete.setVerticalTextPosition(JButton.BOTTOM);
    	 delete.setHorizontalTextPosition(JButton.CENTER);
    	 ImageIcon pmodify = new ImageIcon("d:/Èý¼ÑºþÑ©¾°/ÉèÖÃ.png");
    	 modify.setIcon(pmodify);
    	 modify.setVerticalTextPosition(JButton.BOTTOM);
    	 modify.setHorizontalTextPosition(JButton.CENTER);
    	 ImageIcon pfind = new ImageIcon("d:/Èý¼ÑºþÑ©¾°/ËÑË÷.png");
    	 find.setIcon(pfind);
    	 find.setVerticalTextPosition(JButton.BOTTOM);
    	 find.setHorizontalTextPosition(JButton.CENTER);
    	 ImageIcon pwrite_in_client = new ImageIcon("d:/Èý¼ÑºþÑ©¾°/ÎÒµÄ.png");
    	 write_in_client.setIcon(pwrite_in_client);
    	 write_in_client.setVerticalTextPosition(JButton.BOTTOM);
    	 write_in_client.setHorizontalTextPosition(JButton.CENTER);
    	 ImageIcon pinit = new ImageIcon("d:/Èý¼ÑºþÑ©¾°/addfolder.png");
    	 init.setIcon(pinit);
    	 init.setVerticalTextPosition(JButton.BOTTOM);
    	 init.setHorizontalTextPosition(JButton.CENTER);
    }
 
    public static MainPanel instance  = new MainPanel();

    public static void GUINM() {
    	 try {
    		 UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
    		// UIManager.setLookAndFeel("org.jvnet.substance.skin.SubstanceFieldOfWheatLookAndFeel");
			//UIManager.setLookAndFeel("com.nilo.plaf.nimrod.NimRODLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public static void GUINF() {
    	try {
    		javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.mcwin.McWinLookAndFeel");
    		//javax.swing.UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");
    		 
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    public void run(){
    
    	try {
			instance.showpanel();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    public static void main(String[] args) throws UnknownHostException, IOException, SQLException {
    	MainPanel thread_start = new MainPanel();
		thread_start.start();

  }
}
