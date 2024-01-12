import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
public class Calculator 
{
	JFrame fr=new JFrame("Calculator");
	JTextField tb=new JTextField("0");
	JPanel pa=new JPanel();
	//In this array reference of 20 objects of JButton class can be kept by program
	JButton[] bt=new JButton[20];
	public Calculator()
	{
		fr.setSize(400,470);
		fr.setLocationRelativeTo(null);
		fr.setDefaultCloseOperation(3);
		fr.setResizable(false);
		fr.setLayout(null);
		addTextBox();
		fr.setVisible(true);
	}
	private void addTextBox()
	{
		tb.setBounds(20,20,360,40);
		fr.add(tb);
		tb.setHorizontalAlignment(JTextField.RIGHT);
		tb.setFont(new Font("arial",Font.PLAIN,25));
		tb.setEditable(false);
		tb.setBackground(Color.white);
		tb.setBorder(BorderFactory.createLineBorder(Color.black,1));
		addPanel();
	}
	private void addPanel()
	{
		pa.setBounds(20,90,360,320);
		//pa.setBackground(Color.pink);
		fr.add(pa);
		addButtons();
	}
	private void addButtons()
	{
		pa.setLayout(new GridLayout(5,4,5,5));
		String[] str= {"Back","CE","C","%","7","8","9","/","4","5","6","*","1","2","3","-","0",".","=","+"};
		Font font=new Font("arial",Font.PLAIN,20);
		//code to create object of listener class
		CalListener listener=new CalListener();
		for(int i=0;i<20;i++)
		{
			bt[i]=new JButton(str[i]);
			//code to give reference of listener to the buttons one by one
			bt[i].addActionListener(listener);
			bt[i].setFont(font);
			if(i==3||i==7||i==11||i==15||i==18||i==19)
				bt[i].setForeground(Color.red);
			else
				bt[i].setForeground(Color.blue);
			pa.add(bt[i]);
		}
		bt[17].setFont(new Font("arial",Font.BOLD,25));
	}//end of addButtons method
	class CalListener implements ActionListener
	{
		int abc=0;
		String num1=null;
		String op=null;
		public void actionPerformed(ActionEvent evt)
		{
			JButton bb=(JButton)evt.getSource();
			if(bb==bt[7] || bb==bt[11] || bb==bt[15] || bb==bt[19])
			{
				abc=1;
				num1=tb.getText();
				op=bb.getText();
			}//end of if condition of arithmetic buttons clicked
			if(bb==bt[4] || bb==bt[5] || bb==bt[6] || bb==bt[8] || bb==bt[9] || bb==bt[10] || bb==bt[12] || bb==bt[13] || bb==bt[14] || bb==bt[16] || bb==bt[16])
			{
				//code to get text/value from the button
				String str1=bb.getText();
				//code to get text/value from the textbox
				String str2=tb.getText();
				if(str2.equals("0") || abc==1)
				{
					tb.setText(str1);
					abc=0;
				}
				else
					tb.setText(str2+str1);
			}//end of if condition of digit buttons clicked
			if(bb==bt[18])//if of equal(=) button clicked
			{
				String num2=tb.getText();
				int n1=Integer.parseInt(num1);
				int n2=Integer.parseInt(num2);
				if(op.equals("+"))
				{
					//code to add n1 and n2
					int res=n1+n2;
					tb.setText(String.valueOf(res));
				}
				else if(op.equals("-"))
				{
					//code to subtract n2 from n1
					int res=n1-n2;
					tb.setText(String.valueOf(res));
				}
				else if(op.equals("*"))
				{
					//code to multiply n1 add n2
					int res=n1*n2;
					tb.setText(String.valueOf(res));
				}
				else if(op.equals("/"))
				{
					//code to divide n1 by n2
					int res=n1/n2;
					tb.setText(String.valueOf(res));
				}
			}
			
		}
	}
	public static void main(String[] args) 
	{
		new Calculator();
	}//end of main method
}//end of class Calculator
