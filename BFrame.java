import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class BFrame extends JPanel
{
	String accts [] = {"Checking" , "Saving"};

	ArrayList<BankAccount> accounts = new ArrayList<BankAccount> ();
	JList <String> acc  = new JList<String> (accts);
	
	public BFrame()
	{
		setSize(400, 300);
		setLayout( new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		JLabel lblName = new JLabel("Name: ");
		add(lblName, gbc);
		gbc.gridx++;
		JTextField txtName = new JTextField();
		txtName.setPreferredSize(new Dimension(180, 30)); //width, height
		add(txtName, gbc);
		gbc.gridx = 0;
		gbc.gridy++;
		
		JLabel lblDeposit = new JLabel("Initial Deposit: ");
		add(lblDeposit, gbc);
		gbc.gridx++;

		JTextField txtDeposit = new JTextField();
		txtDeposit.setPreferredSize(new Dimension (180, 30));
		add(txtDeposit, gbc);
		
		
		
		gbc.gridy++;
		gbc.gridx=0;
		JButton submit = new JButton("Submit");
		add(submit,gbc);
		
		gbc.gridx++;
		JScrollPane list = new JScrollPane();
		list.setViewportView(acc);
		list.setPreferredSize(new Dimension(80, 40));
		add(list, gbc);
		
		
		submit.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e) 
			{
				double OVER_DRAFT_FEE = 15; 
				double rate = 0.0025; 
				double TRANSACTION_FEE = 1.5; 
				double MIN_BAL = 300;
				double MIN_BAL_FEE = 10;
				int FREE_TRANSACTION = 10;
				if(acc.getSelectedValue() == "Checking")
				{
					
					CheckingAccount check = new CheckingAccount(txtName.getText(), Double.parseDouble(txtDeposit.getText()), OVER_DRAFT_FEE, TRANSACTION_FEE, FREE_TRANSACTION);
					accounts.add(check);
				}
				else
				{
					SavingsAccount save = new SavingsAccount(txtName.getText(), Double.parseDouble(txtDeposit.getText()),rate, MIN_BAL, MIN_BAL_FEE);
					accounts.add(save);
				}
				
				
				txtName.setText("");
				txtDeposit.setText("");
				
			}
		}
		
		);
	}
}
