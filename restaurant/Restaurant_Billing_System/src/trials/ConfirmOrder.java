package trials;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ConfirmOrder extends JFrame implements ActionListener{

	JButton backButton;
	JButton addBtn;
	JTextField totalprice;
	JLabel verifyLabel;
	
	ConfirmOrder(){
		backButton = new JButton();
		backButton.setText("Back");
		backButton.setBounds(10,20,100,50);
		backButton.addActionListener(this);
		
		JLabel fN = new JLabel("The price : ");
		fN.setBounds(480, 150, 200, 100);
		
		totalprice = new JTextField();
		totalprice.setBounds(600, 150, 200, 80);
		

		
		verifyLabel = new JLabel();
		
		this.setTitle("Restaurant billing system");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1200,800);
		this.setVisible(true);
		this.setLayout(null);
		this.setResizable(false);
		this.add(backButton);
		this.add(fN);
		this.add(totalprice);
		this.add(verifyLabel);
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==backButton) {
			
			MainFrame MainFrameOb = new MainFrame();
			MainFrameOb.setVisible(true);
		}
	}
}