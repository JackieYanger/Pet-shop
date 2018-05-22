package gui;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import 宠物商店文件版.Cat;

public class InsertPanel extends JPanel{
	static {
		MainPanel.GUINF();
	}
	private static final long serialVersionUID = 1L;
	public JTextField Tpet_name = new JTextField();
	public JTextField Tpet_colour = new JTextField();
	public JTextField Tpet_age = new JTextField();
	public JTextField Tpet_variety= new JTextField();
	public JTextField Tpet_cost = new JTextField();
	public JLabel Lpet_name = new JLabel("Pet Name");
	public JLabel Lpet_colour = new JLabel("Pet Colour");
	public JLabel Lpet_age = new JLabel("Pet Age");
	public JLabel Lpet_variety= new JLabel("Pet Variety");
	public JLabel Lpet_cost = new JLabel("Pet Cost");
	public JTextField Tpet_image = new JTextField();
	public JButton file_choose = new JButton("Choose Pictures ");
	public JFileChooser filechoose = new JFileChooser();
	public File file = new File("D:\\三佳湖雪景\\云.png");
	public static String myfile;
	public JFrame f= new JFrame("INSERT");
	public JDialog dialog = new JDialog(f );
	public JPanel panel = new JPanel();
	public  JPanel panels = new JPanel();
	public JButton insert = new JButton("Add This Pet");
//	public static Cat []cats = new Cat[100];
	public 	OutputStream out;
	public static ArrayList<Cat> cats = new ArrayList<>();
	public ArrayList<Cat> cat_out = new ArrayList<>();
    public InsertPanel() {


    }
    public void setlocation() {	
	  panels.setLayout(new BorderLayout());
	  panels.add(panel);
	  panels.add(insert,BorderLayout.SOUTH);
  }
    public void showpanel() {
    	set_typeface();
		dialog.setSize(300, 280);
		dialog.setLocation(300, 300);
		panel.setLayout(new GridLayout(6,2));
		panel.add(Lpet_name);
		panel.add(Tpet_name);
		panel.add(Lpet_colour);
		panel.add(Tpet_colour);
		panel.add(Lpet_age);
		panel.add(Tpet_age);
		panel.add(Lpet_variety);
		panel.add(Tpet_variety);
		panel.add(Lpet_cost);
		panel.add(Tpet_cost);		
		panel.add(file_choose);
		panel.add(Tpet_image);		
		insert.setSize(20, 20);
		JDialog dia = new JDialog(dialog);
		dia.setTitle("reminder");
		dia.setSize(200, 150);
		dia.setLayout(new BorderLayout());
		dia.setLocation(350, 340);
		file_choose.addActionListener(new ActionListener() {         
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFileChooser fd = new JFileChooser();
				fd.showOpenDialog(null);
				 file = fd.getSelectedFile();			
				 
				if(file.isDirectory()) {
					myfile =file.getAbsolutePath();
				}
				if(file == null ) myfile = "none";
				myfile =file.getAbsolutePath();		
				Tpet_image.setText(myfile);
			}			
		});
		insert.addActionListener(new ActionListener() {
			@Override			
			public void actionPerformed(ActionEvent e) {
		    	Cat cat = new Cat("","","","","");
		    	cat.name = Tpet_name.getText();
		    	cat.color = Tpet_colour.getText();
		    	cat.age =Tpet_age.getText();
		    	cat.variety =Tpet_variety.getText();
		    	cat.cost= Tpet_cost.getText();
			    cats.add(cat);			

			   HomePanel. insert_pet();
               try {
				InitPanel.instance.add(cat.name, cat.color, cat.age, cat.variety, cat.cost);
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
				File f = new File("D:" + File.separator + "Pet.txt") ;	// 定义保存路径
				ArrayList<Cat> a=new ArrayList<Cat>();
				for(int i=0;i<InsertPanel.cats.size();i++){
					a.add(InsertPanel.cats.get(i));
				}
				
				ObjectOutputStream oos = null ;	// 声明对象输出流
				
				try {
					out = new FileOutputStream(f);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	// 文件输出流
				
				try {
					oos = new ObjectOutputStream(out) ;
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					oos.writeObject(a) ;
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	// 保存对象
				try {
					oos.close() ;
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}	// 关闭
         
			    JLabel infor = new JLabel("       related information is stored !");
			    dia.add(infor,BorderLayout.CENTER);
			    dia.setModal(true);
			    dia.setVisible(true);
			    dialog.setVisible(false);
			}
			
		});
		setlocation();
		dialog.add(panels);
		dialog.setModal(true);
	     dialog.setVisible(true);
	      dialog.setResizable(false);

    }
    private void set_typeface() {
		Lpet_name.setFont(new Font("微软雅黑", Font.BOLD, 15));
		Lpet_colour.setFont(new Font("微软雅黑", Font.BOLD, 15));
		Lpet_age.setFont(new Font("微软雅黑", Font.BOLD, 15));
		Lpet_variety.setFont(new Font("微软雅黑", Font.BOLD, 15));
		Lpet_cost.setFont(new Font("微软雅黑", Font.BOLD, 15));

	}
    public static InsertPanel instance = new InsertPanel();
	public static void main(String[] args) {
		instance.showpanel();
	
	}
}
