package GUISwing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Window extends JFrame implements ActionListener
{
	//JFrame window;
	static CityPanel redPanel=new CityPanel();
	static CityPanel bluePanel=new CityPanel();
	JButton button = new JButton("Click");
	JTextField text = new JTextField("0");
	public Window()
	{
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//this.setLayout();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.add(bluePanel, BorderLayout.CENTER);
		redPanel.setBackground(Color.red);
		
		button.addActionListener(this);
		this.add(button, BorderLayout.WEST);
		button.setSize(200,200);
		//button.setBounds(30, 0, 100, 100);
		
		text.setVisible(true);
		this.add(text, BorderLayout.NORTH);
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if(redPanel.isDisplayable())
		{
			this.getContentPane().remove(redPanel);
			this.add(bluePanel, BorderLayout.CENTER);
		}
		else if(bluePanel.isDisplayable())
		{
			this.getContentPane().remove(bluePanel);
			this.add(redPanel, BorderLayout.CENTER);
		}
		if(text.getText().equals("0"))
			text.setText("1");
		else if(text.getText().equals("1"))
			text.setText("0");
	}
	
	public static void main(String[] args)
	{  
		new Window();
	}
}