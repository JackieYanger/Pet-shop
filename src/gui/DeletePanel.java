package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import 宠物商店文件版.Cat;

public class DeletePanel extends JPanel {
	public static ArrayList<Cat> cat_delete = new ArrayList<>();
	static{
		MainPanel.GUINF();
	}
   private static final long serialVersionUID = 1L;
   public JPanel panel = new JPanel();
   public JPanel panel0 = new JPanel();
   public JDialog dialog = new JDialog();
   public JButton delete_pet = new JButton("delete_pet");
   public JLabel information = new JLabel("请输入要删除的宠物名字：");
   public JTextField text = new JTextField();
   public static HomePanel homepanel = new HomePanel();
   public static int  index;
   public void showpanel() {
	//   MainPanel.table.setModel(MainPanel.model);
	   dialog.setSize(380, 150);
	   dialog.setLocation(400, 400);	 
	   //text.setSize(200, 20);
	   set_type();
        north();
	   panel.setLayout(new BorderLayout());
	   panel.add(panel0,BorderLayout.NORTH);
	   panel.add(delete_pet,BorderLayout.CENTER) ;
	   delete_pet.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			JDialog dia = new JDialog();
			dia.setTitle("提示！");
			dia.setSize(200, 150);
			dia.setLocation(390, 300);
			JLabel label = new JLabel("                          deleted!");
			dia.add(label);
			// TODO Auto-generated method stub
			int temp = 0;
			int exist = 0;
			index =  InsertPanel.cats.size() ;
			for(int i = 0 ;i< InsertPanel.cats.size() ; i++ )
			{
				cat_delete.add(InsertPanel.cats.get(i));
			}
		    for(int i = 0 ;i < InsertPanel.cats.size() ; i ++)
		    {
		    	if(InsertPanel.cats.get(i).name.equals(text.getText()))
		    	{
		    		cat_delete.remove(i);
		    		InsertPanel.cats.remove(i);
		    	    temp = i ;
		    	    exist = 1 ;
		    	}
		    	
		    }
		    if(exist == 0) {
		    	JDialog dia1 = new JDialog();
				dia1.setTitle("提示！");
				dia1.setSize(200, 150);
				dia1.setLocation(390, 300);
				JLabel label1 = new JLabel("            no such member !");
				dia1.add(label1);
				dia1.setModal(true);
				dia1.setAlwaysOnTop(true);
				dia1.setVisible(true);
				dialog.setVisible(false);
		    }
		    else {
			DefaultTableModel tableModel = (DefaultTableModel) HomePanel.table.getModel();
			HomePanel.model.removeRow(temp);// rowIndex是要删除的行序号
			HomePanel. table.invalidate();
			HomePanel.  table.updateUI();
			   dia.setModal(true);
			   dia.setAlwaysOnTop(true);
			   dia.setVisible(true);
			   dialog.setVisible(false);
			   try {
				InitPanel.instance.delete(text.getText());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		    }
		}
		   
		   
	   });
	
	   dialog.add(panel);
       dialog.setModal(true);
       dialog.setVisible(true);
       dialog.setResizable(false);
   }
   public void north() {
	   panel0.setLayout(new GridLayout(1,2));
	   panel0.add(information);
	   panel0.add(text);
   }
   public void set_type() {
	   information.setFont(new Font("微软雅黑", Font.BOLD, 15));
   }
   public static DeletePanel instance = new DeletePanel();
   public static void main(String[] args) {
	   instance.showpanel();
}
}
