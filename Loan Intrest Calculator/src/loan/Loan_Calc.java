package loan;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

import java.awt.Button;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import java.awt.SystemColor;

public class Loan_Calc {

	private JFrame frame;
	private JTextField jtxtEnter;
	private JTextField jtxtNumberofyears;
	private JTextField jtxtEnterloanamount;
	private JTextField jlblmonthlyPayment;
	private JTextField jlbltotalPayment;
	//private JTextArea jtxtReceipt;
	
	private JButton btnExit;
	private JButton btnReset;
	private JButton btnReceipt;
	private JButton btnLoan;
	
	private JButton jbtnPin,jbtnBalance,jbtnDeposit,jbtnWithdrawal;
	private JButton jbtn1,jbtn2,jbtn3,jbtn4,jbtn5,jbt6,jbtn7,jbtn8,jbtn9,jbtn0;

	private JPanel panel_1,panel_2,panel_3,panel_4;
	
		
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Loan_Calc window = new Loan_Calc();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Loan_Calc() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(0, 0, 1450, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_4.setBounds(256, 72, 846, 596);
		frame.getContentPane().add(panel_4);
		panel_4.setLayout(null);
		
		JTextArea jtxtReceipt_1 = new JTextArea();
		jtxtReceipt_1.setBounds(374, 42, 448, 415);
		panel_4.add(jtxtReceipt_1);
		
		JLabel jlblintrestRate = new JLabel("Intrest rate");
		jlblintrestRate.setFont(new Font("Tahoma", Font.BOLD, 24));
		jlblintrestRate.setBounds(10, 42, 209, 40);
		panel_4.add(jlblintrestRate);
		
		jtxtEnter = new JTextField();
		jtxtEnter.setBounds(248, 42, 116, 43);
		panel_4.add(jtxtEnter);
		jtxtEnter.setColumns(10);
		
		JLabel jlblnumberofYears = new JLabel("Number of Years");
		jlblnumberofYears.setFont(new Font("Tahoma", Font.BOLD, 24));
		jlblnumberofYears.setBounds(10, 139, 209, 43);
		panel_4.add(jlblnumberofYears);
		
		jtxtNumberofyears = new JTextField();
		jtxtNumberofyears.setColumns(10);
		jtxtNumberofyears.setBounds(248, 139, 116, 43);
		panel_4.add(jtxtNumberofyears);
		
		JLabel jlblEnterloanamount = new JLabel("Amount of loan");
		jlblEnterloanamount.setFont(new Font("Tahoma", Font.BOLD, 24));
		jlblEnterloanamount.setBounds(10, 218, 209, 50);
		panel_4.add(jlblEnterloanamount);
		
		jtxtEnterloanamount = new JTextField();
		jtxtEnterloanamount.setColumns(10);
		jtxtEnterloanamount.setBounds(248, 228, 116, 43);
		panel_4.add(jtxtEnterloanamount);
		
		JLabel jllMonthlyPayment = new JLabel("Monthly Pay ");
		jllMonthlyPayment.setFont(new Font("Tahoma", Font.BOLD, 24));
		jllMonthlyPayment.setBounds(10, 303, 209, 50);
		panel_4.add(jllMonthlyPayment);
		
		jlblmonthlyPayment = new JTextField();
		jlblmonthlyPayment.setColumns(10);
		jlblmonthlyPayment.setBounds(248, 313, 116, 43);
		panel_4.add(jlblmonthlyPayment);
		
		JLabel jllTotalPayment = new JLabel("Total Payment");
		jllTotalPayment.setFont(new Font("Tahoma", Font.BOLD, 24));
		jllTotalPayment.setBounds(10, 400, 209, 50);
		panel_4.add(jllTotalPayment);
		
		jlbltotalPayment = new JTextField();
		jlbltotalPayment.setColumns(10);
		jlbltotalPayment.setBounds(248, 407, 116, 50);
		panel_4.add(jlbltotalPayment);
		
		JButton btnLoan = new JButton("Loan");
		btnLoan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double annualIntrestRate=Double.parseDouble(jtxtEnter.getText());
				double monthlyIntrestRate=annualIntrestRate / 1200;
				int numberOfYears=Integer.parseInt(jtxtNumberofyears.getText());
				double loanAmount=Double.parseDouble(jtxtEnterloanamount.getText());
				//------------------------------------------------------------------
				double monthlyPayment=loanAmount * monthlyIntrestRate/(1 - 1/Math.pow(1+
						monthlyIntrestRate,
						numberOfYears * 12));
				String imonthlyPayment;
				imonthlyPayment=Double.toString(monthlyPayment);
				imonthlyPayment=String.format("₹%.2f",monthlyPayment);
				jlblmonthlyPayment.setText(imonthlyPayment);
				//----------------------------------------------------
				double totalPayment=monthlyPayment * numberOfYears * 12;
				String itotalPayment;
				itotalPayment=String.format("₹%.2f",totalPayment);
				jlbltotalPayment.setText(itotalPayment);
			}
		});
		btnLoan.setBackground(new Color(176, 224, 230));
		btnLoan.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnLoan.setBounds(0, 505, 170, 62);
		panel_4.add(btnLoan);
		
		JButton btnReceipt = new JButton("Receipt");
		btnReceipt.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			
			
				String annualIntrestRate=String.format(jtxtEnter.getText());
				String numberOfYears=String.format(jtxtNumberofyears.getText());
				String loanAmount=String.format(jtxtEnterloanamount.getText());
				
				String monthlyPayment=String.format(jlblmonthlyPayment.getText());
				String totalPayment=String.format(jlbltotalPayment.getText());
				//================================================================
				int refs=1325+  (int) (Math.random()*4238);
				
				//================================================================
				Calendar timer=Calendar.getInstance();
				timer.getTime();
				SimpleDateFormat tTime=new SimpleDateFormat("HH:mm:ss");
				tTime.format(timer.getTime());
				SimpleDateFormat Tdate=new SimpleDateFormat("dd-MM-yyyy");
				Tdate.format(timer.getTime());
				
				//================================================================
				
				jtxtReceipt_1.append("\tLoan Management System\n" +
				"Reference:\t\t\t" + refs +
				"\n==============================================\t" +
				"\nIntrest rate:\t\t\t " + annualIntrestRate +
				"\nRepayment years:\t\t " +numberOfYears +
				"\nAmount of Loan:\t\t\t " + "₹" +loanAmount +
				"\nMonthly payment:\t\t " +monthlyPayment +
				"\nTotal payment:\t\t\t " +totalPayment +
				
				"\n==============================================\t " +
				"\nDate: "+Tdate.format(timer.getTime()) +
				"\t\tTime: "+tTime.format(timer.getTime())+
				"\n\n\t\tThank You\n" );
						
			}
		});
		btnReceipt.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnReceipt.setBackground(new Color(176, 224, 230));
		btnReceipt.setBounds(180, 505, 170, 62);
		panel_4.add(btnReceipt);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				jtxtEnter.setText(null);
				jtxtNumberofyears.setText(null);
				jtxtEnterloanamount.setText(null);
				jlblmonthlyPayment.setText(null);
				jlbltotalPayment.setText(null);
				jtxtReceipt_1.setText(null);
				
			}
		});
		btnReset.setBackground(new Color(176, 224, 230));
		btnReset.setBounds(496, 505, 170, 62);
		panel_4.add(btnReset);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame=new JFrame("Exit");
				if(JOptionPane.showConfirmDialog(frame,"Confirm if you want to exit",
						"ATM Systems",
						JOptionPane.YES_NO_OPTION)== JOptionPane.YES_NO_OPTION) {
					System.exit(0);
					}
				}
			
		});
		btnExit.setBackground(new Color(176, 224, 230));
		btnExit.setBounds(676, 505, 170, 62);
		panel_4.add(btnExit);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					jtxtReceipt_1.print();
				} catch (PrinterException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnPrint.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnPrint.setBackground(new Color(176, 224, 230));
		btnPrint.setBounds(360, 505, 123, 62);
		panel_4.add(btnPrint);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 1436, 763);
		frame.getContentPane().add(lblNewLabel);
	}
}
