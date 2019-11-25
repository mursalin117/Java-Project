// notepad creating

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class MyNotePad1 extends JFrame implements ActionListener//, ChangeListener 
{
	//private Container c;
	private JTextArea ta;
	private Font f;
	private JMenuBar menubar;
	private JMenu optionMenu;
	private JMenuItem newItm, openItm, saveItm, exitItm;
	//private ButtonGroup btng;
	//private int font = 20;
	private JFileChooser fchoose;
	private JScrollPane scrollBar;

	MyNotePad1()
	{
		//c = this.getContentPane();
        //c.setLayout(null);
		f = new Font("Arial", Font.PLAIN, 20);
		//btng = new ButtonGroup();
		ta = new JTextArea();
		ta.setFont(f);
		ta.setBounds(1, 1, 495, 395);
		this.add(ta);
		scrollBar = new JScrollPane(ta);
		this.add(scrollBar); 
		menubar = new JMenuBar();
		this.setJMenuBar(menubar);
		optionMenu = new JMenu("Option");
		optionMenu.setFont(f);
		menubar.add(optionMenu);
		newItm = new JMenuItem("New");
		newItm.setFont(f);
		openItm = new JMenuItem("Open");
		openItm.setFont(f);
		saveItm = new JMenuItem("Save");
		saveItm.setFont(f);
		exitItm = new JMenuItem("Exit");
		exitItm.setFont(f);
		optionMenu.add(newItm);
		optionMenu.addSeparator();
		optionMenu.add(openItm);
		optionMenu.addSeparator();
		optionMenu.add(saveItm);
		optionMenu.addSeparator();
		optionMenu.add(exitItm);
		newItm.addActionListener(this);
		openItm.addActionListener(this);
		saveItm.addActionListener(this);
		exitItm.addActionListener(this);
	}

	@Override

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource() == saveItm)
		{
			try
			{
				fchoose = new JFileChooser();
				fchoose.showSaveDialog(null);
				File file = fchoose.getSelectedFile();

				Formatter formatter = new Formatter(file);
				formatter.format("%s", ta.getText());
				formatter.close();
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null, "The file has not been saved " + ex);
			}
		}	
		else if(e.getSource() == openItm)
		{
			try
			{
				fchoose = new JFileChooser();
				fchoose.showOpenDialog(null);
				File file = fchoose.getSelectedFile();

				Scanner s = new Scanner(file);
				while(s.hasNext())
				{
					String str = s.nextLine();
					ta.append(str + " \r\n");
				}
				s.close();
			}
			catch(Exception ex)
			{
				JOptionPane.showMessageDialog(null, "No file has been opened " + ex);
			}
		}
		else if(e.getSource() == newItm)
		{
			//dispose();
			JFrame frame = new MyNotePad1();
			frame.setTitle("MyNotePad");
			frame.setSize(400, 400);
			frame.setVisible(true);
		}
		else
		{
			System.exit(0);
		} 
	}

	public static void main(String args[])
	{
		MyNotePad1 m = new MyNotePad1();
		m.setTitle("MyNotePad");
		m.setBounds(100, 100, 500, 400);
		m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		m.setResizable(true);
		m.setVisible(true);
	}
}
