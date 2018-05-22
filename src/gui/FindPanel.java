package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class FindPanel extends JPanel{
	static {
		MainPanel.GUINF();
	}
	 public JButton modify_pet = new JButton("Find_pet");
	 public JLabel information = new JLabel("«Î ‰»Î“™≤È’“µƒ≥ËŒÔ√˚◊÷£∫");
	 public JTextField text = new JTextField();
	 public JPanel panel= new JPanel();
	 public JPanel panel0 = new JPanel();
	 public JPanel panel_0 = new JPanel();
	 public JDialog dialog = new JDialog();
	 public JLabel Tpet_name = new JLabel();
	 public JLabel Tpet_colour = new JLabel();
	 public JLabel Tpet_age = new JLabel();
	 public JLabel Tpet_variety= new JLabel();
	 public JLabel Tpet_cost = new JLabel();
	 public JLabel Lpet_name = new JLabel("Pet Name");
	 public JLabel Lpet_colour = new JLabel("Pet Colour");
	 public JLabel Lpet_age = new JLabel("Pet Age");
	 public JLabel Lpet_variety= new JLabel("Pet Variety");
	 public JLabel Lpet_cost = new JLabel("Pet Cost");
	 public String temp = new String();
	 private static final long serialVersionUID = 1L;
     public void showpanel() {
   
    	   dialog.setSize(380, 150);
    	   dialog.setLocation(400, 400);	 
    	   information.setFont(new Font("Œ¢»Ì—≈∫⁄", Font.BOLD, 15));
    	   set_typeface();
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
    	    panel_0.setLayout(new GridLayout(1,2));
    	    panel_0.add(information);
    	    panel_0.add(text);
    	    panel.setLayout(new BorderLayout());
    	    panel.add(panel_0,BorderLayout.NORTH);
    	    panel.add(modify_pet,BorderLayout.CENTER) ;	
    	    modify_pet.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
	
				temp = text.getText().trim() ;
				int row = 0 ;
				int exist = 0 ;
				JDialog f = new JDialog();
				JPanel p = new JPanel();
				// TODO Auto-generated method stub
				for(int i =0 ;i< InsertPanel.cats.size() ; i++) {	
				     if(InsertPanel.cats.get(i).name .equals(temp)) {
					    row = i;
				        exist= 1 ;					
							p.add(panel0);
							Tpet_name.setText(InsertPanel.cats.get(i).name);
							Tpet_colour.setText(InsertPanel.cats.get(i).color);
							Tpet_age.setText(InsertPanel.cats.get(i).age);
							Tpet_variety.setText(InsertPanel.cats.get(i).variety);
							Tpet_cost.setText(InsertPanel.cats.get(i).cost);
							f.add(p);						
							f.setSize(200, 230);
							f.setModal(true);
							f.setAlwaysOnTop(true);
							f.setLocation(300, 300);
							f.setResizable(false);
							f.setVisible(true);
							break ;
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
				
				}
    	   }
    	    });
    	    
    	   dialog.add(panel);
           dialog.setModal(true);
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
    public static FindPanel instance = new FindPanel();
    public static void main(String[] args) {
 	   instance.showpanel();
 	   
 }

}
