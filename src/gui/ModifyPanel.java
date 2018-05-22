package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

public class ModifyPanel extends JPanel{
	static {
		MainPanel.GUINF();
	}
	 public JButton modify_pet = new JButton("modify_pet");
	 public JLabel information = new JLabel("«Î ‰»Î“™≤È’“µƒ≥ËŒÔ√˚◊÷£∫");
	 public JTextField text = new JTextField();
	 public JPanel panel= new JPanel();
	 public JPanel panel0 = new JPanel();
	 public JPanel panel_0 = new JPanel();
	 public JDialog dialog = new JDialog();
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
	 public String temp = new String();
	 public JButton  modify = new JButton("modify");
	 private static final long serialVersionUID = 1L;
     public void showpanel() {
   
    	   dialog.setSize(380, 150);
    	   dialog.setLocation(400, 400);	 
    	   information.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.BOLD, 15));
    	   set_typeface();
    	   JPanel tm_panel = new JPanel();
    	   tm_panel.setLayout(new BorderLayout());
    		panel0.setLayout(new GridLayout(5,2));
    		panel0.add(Lpet_name);
    		panel0.add(Tpet_name);
    		panel0.add(Lpet_colour);
    		panel0.add(Tpet_colour);
    		panel0.add(Lpet_age);
    		panel0.add(Tpet_age);
    		panel0.add(Lpet_variety);
    		panel0.add(Tpet_variety);
    		panel0.add(Lpet_cost);
    		panel0.add(Tpet_cost);		    		 
    		tm_panel.add(panel0);
    		tm_panel.add(modify,BorderLayout.SOUTH);
    	    panel_0.setLayout(new GridLayout(1,2));
    	    panel_0.add(information);
    	    panel_0.add(text);
    	    panel.setLayout(new BorderLayout());
    	    panel.add(panel_0,BorderLayout.NORTH);
    	    panel.add(modify_pet,BorderLayout.CENTER) ;	
    	    JDialog f = new JDialog();
    	   
    	    modify_pet.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				temp = text.getText().trim() ;
				 int rows = 0 ;
				int exist = 0 ;
				
				f.setSize(200, 230);				
				f.setLocation(300, 300);			
				JPanel p = new JPanel();
				// TODO Auto-generated method stub
				for(int i =0 ;i< InsertPanel.cats.size() ; i++) {							
				if(InsertPanel.cats.get(i).name .equals(temp)) {
					        rows = i;
					        exist= 1 ;					
							p.add(tm_panel);
							Tpet_name.setText(InsertPanel.cats.get(i).name);
							Tpet_colour.setText(InsertPanel.cats.get(i).color);
							Tpet_age.setText(InsertPanel.cats.get(i).age);
							Tpet_variety.setText(InsertPanel.cats.get(i).variety);
							Tpet_cost.setText(InsertPanel.cats.get(i).cost);	
							
						}
				}
				if(exist == 0) {
					JDialog dia1 = new JDialog();
					dia1.setTitle("Ã· æ£°");
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
					f.add(p);											
					f.setAlwaysOnTop(true);
					f.setResizable(false);
					f.setVisible(true);
				
				
			
			
				}
			 
				
    	   }
    	    });
    		modify.addActionListener(new ActionListener() {

				@Override				
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					  int row = 0 ;
						temp = text.getText().trim() ;
						for(int i =0 ;i< InsertPanel.cats.size() ; i++) {
							if(InsertPanel.cats.get(i).name .equals(temp)) {
							      row = i;
							      break ;
							}
						}
					   DefaultTableModel tableModel = (DefaultTableModel) HomePanel.table.getModel();
					    tableModel.setValueAt(Tpet_name.getText().trim(), row,0);//–ﬁ∏ƒƒ≥µ•‘™∏Òµƒ÷µ
					   // System.out.println(Tpet_name.getText().trim());
					    tableModel.setValueAt(Tpet_colour.getText(), row,1);
					    tableModel.setValueAt(Tpet_age.getText(), row,2);
					    tableModel.setValueAt(Tpet_variety.getText(), row,3);
					    tableModel.setValueAt(Tpet_cost.getText(), row,4);
					    try {
							InitPanel.instance.update(Tpet_name.getText().trim(), 
									Tpet_colour.getText(), Tpet_age.getText(), Tpet_variety.getText(), 
									Tpet_cost.getText(), temp);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					    HomePanel.  table.invalidate();
					    HomePanel.  table.updateUI();
					f.setVisible(false);
					dialog.setVisible(false);
				}
				
			});
    	   dialog.add(panel);
         //  dialog.setModal(true);
           dialog.setVisible(true);
           dialog.setResizable(false);
 }
    public void north() {
  
     }
    private void set_typeface() {
		Lpet_name.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.BOLD, 15));
		Lpet_colour.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.BOLD, 15));
		Lpet_age.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.BOLD, 15));
		Lpet_variety.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.BOLD, 15));
		Lpet_cost.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.BOLD, 15));
	}
    public static ModifyPanel instance = new ModifyPanel();
    public static void main(String[] args) {
 	   instance.showpanel();
 	   
 }
}
