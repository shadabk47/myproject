import javax.swing.*;
import java.awt.*;
public class Chess 
{
	JFrame fr=new JFrame("Chess");
	//variable fr will be created(JFrame fr)
	//Object from JFrame class will be create(new JFrame("Chess"));
	//Reference of the object will be assigned to the variable fr
	JButton[] bt=new JButton[64];
	//In this(bt) array my program will keep reference of 64 button's object
	public Chess()
	{
		fr.setSize(900,600);
		fr.setLocationRelativeTo(null);
		fr.setResizable(false);
		addButtons();
		fr.setVisible(true);
	}
	private void addButtons()
	{
		GridLayout layout=new GridLayout(8,8);
		fr.setLayout(layout);
		int c=1;
		for(int i=0;i<64;i++)
		{
			bt[i]=new JButton();
			if(i%8==0)
				c=1-c;
			if(i%2==c)
				bt[i].setBackground(Color.white);
			else
				bt[i].setBackground(Color.black);
			fr.add(bt[i]);
		}
	}
	public static void main(String[] args) 
	{
		new Chess();
	}
	
}
