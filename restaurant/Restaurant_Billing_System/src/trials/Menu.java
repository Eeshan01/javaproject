package trials;


import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Menu extends JFrame implements ActionListener{

	JButton backButton;
	JButton printBill;
	JButton showMenu;
	
	Menu(){
		backButton = new JButton();
		backButton.setText("Back");
		backButton.setBounds(10,20,100,50);
		backButton.addActionListener(this);
		printBill = new JButton();
		printBill.setText("Place Order");
		printBill.setBounds(1050,20,120,50);
		printBill.addActionListener(this);
		showMenu = new JButton();
		showMenu.setText("Display Menu");
		showMenu.setBounds(550,250,120,50);
		showMenu.addActionListener(this);
		
		JLabel label1 = new JLabel("Please select the item from the Menu");
		label1.setBounds(400, 30, 550, 100);
		label1.setFont(new Font("MV Boli",Font.BOLD,20));
		
		this.setTitle("Restaurant billing system");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200,800);
		this.setVisible(true);
		this.setLayout(null);
		this.setResizable(false);
		this.add(backButton);
		this.add(printBill);
		this.add(label1);
		this.add(showMenu);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==backButton) {
			MainFrame MainFrameOb = new MainFrame();
			MainFrameOb.setVisible(true);
		}
		
		else if(e.getSource() == printBill) {
			PlaceOrder PlaceOrderOb = new PlaceOrder();
			PlaceOrderOb.setVisible(true);
		}
		else if(e.getSource() == showMenu) {
		    try 
		  {
		      String url = "jdbc:mysql://localhost:3306/restaurant";
		      String user = "root";
		      String password = "tiger";
		    
		      Connection con = DriverManager.getConnection(url, user, password);
		    
		      String query = "SELECT * FROM menu";
		    
		      Statement stm = con.createStatement();
		      ResultSet res = stm.executeQuery(query);
		    
		      String columns[] = { "Name", "Price" };
		      String data[][] = new String[8][5];
		    
		      int i = 0;
		      while (res.next()) {
		        String name = res.getString("Name");
		        String price = res.getString("Price");
		        data[i][0] = name;
		        data[i][1] = price;
		        i++;
		      }
		    
		      DefaultTableModel model = new DefaultTableModel(data, columns);
		      JTable table = new JTable(model);
		      table.setShowGrid(true);
		      table.setShowVerticalLines(true);
		      JScrollPane pane = new JScrollPane(table);
		      JFrame f = new JFrame("Today's Menu");
		      JPanel panel = new JPanel();
		      panel.add(pane);
		      f.add(panel);
		      f.setSize(500, 250);
		      f.setVisible(true);
		    
		    } catch(SQLException e1) {
		      e1.printStackTrace();
		    }
		  }
		
	}
	
}