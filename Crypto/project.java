package cryptonite;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import backend.*;
public class project
{
	JFrame f;
	String e_file = null;
	String e_path = null;
	String d_file = null;
	String d_path = null;
	boolean enc = false;
	JPanel p1;
	JLabel la6,la7,la8,la9;
	public project()
	{
		f = new JFrame();
		p1 = new JPanel();
		p1.setLayout(null);
		p1.setBackground(new Color(30,10,50));
		p1.setForeground(Color.white);
		p1.setFont(new Font("Roboto Slab", Font.PLAIN, 22));
		JLabel l1 = new JLabel("<html><span><font size=32 color='yellow'>&nbsp&nbsp&nbsp&nbsp WELCOME TO CRYPTONITE</font><br>Data Encryption-Decryption Program</span></html>");
		l1.setFont(new Font("Roboto Slab", Font.PLAIN, 32));
		l1.setForeground(Color.white);
		p1.add(l1);
		l1.setLocation(650,50);
		l1.setSize(700,100);
		JLabel l2 = new JLabel("<html>Choose the file to be encrypted</html>");
		l2.setFont(new Font("Roboto Slab", Font.PLAIN, 32));
		l2.setForeground(Color.white);
		p1.add(l2);
		l2.setLocation(120,250);
		l2.setSize(700,50);
		JButton fcb1 = new JButton("Choose File");
		fcb1.setFont(new Font("Roboto Slab", Font.PLAIN, 26));
		fcb1.setBackground(Color.white);
		fcb1.setForeground(Color.black);
		fcb1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				e_file = chooseFile(e_file);
				e_fileChosen();
			}
		});
		p1.add(fcb1);
		fcb1.setBounds(120,320,200,50);
		JLabel l3 = new JLabel("<html>Choose the path to save the encrypted<br>file and the encryption key</html>");
		l3.setFont(new Font("Roboto Slab", Font.PLAIN, 32));
		l3.setForeground(Color.white);
		p1.add(l3);
		l3.setLocation(120,500);
		l3.setSize(700,100);
		JButton pcb1 = new JButton("Choose Path");
		pcb1.setFont(new Font("Roboto Slab", Font.PLAIN, 26));
		pcb1.setBackground(Color.white);
		pcb1.setForeground(Color.black);
		pcb1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				e_path = choosePath(e_path);
				e_pathChosen();
			}
		});
		p1.add(pcb1);
		pcb1.setBounds(120,620,200,50);
		JButton en = new JButton("Encrypt");
		en.setFont(new Font("Roboto Slab", Font.PLAIN, 32));
		en.setBackground(Color.pink);
		en.setForeground(Color.black);
		en.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				encrypt_call();
			}
		});
		p1.add(en);
		en.setBounds(300,800,200,50);
		JLabel l4 = new JLabel("<html>Choose the file to be decrypted</html>");
		l4.setFont(new Font("Roboto Slab", Font.PLAIN, 32));
		l4.setForeground(Color.white);
		p1.add(l4);
		l4.setLocation(1170,250);
		l4.setSize(700,50);
		JButton fcb2 = new JButton("Choose File");
		fcb2.setFont(new Font("Roboto Slab", Font.PLAIN, 26));
		fcb2.setBackground(Color.white);
		fcb2.setForeground(Color.black);
		fcb2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				d_file = chooseFile(d_file);
				d_fileChosen();
			}
		});
		p1.add(fcb2);
		fcb2.setBounds(1170,320,200,50);
		JLabel l5 = new JLabel("<html>Choose the path to save the decrypted file</html>");
		l5.setFont(new Font("Roboto Slab", Font.PLAIN, 32));
		l5.setForeground(Color.white);
		p1.add(l5);
		l5.setLocation(1170,500);
		l5.setSize(700,50);
		JButton pcb2 = new JButton("Choose Path");
		pcb2.setFont(new Font("Roboto Slab", Font.PLAIN, 26));
		pcb2.setBackground(Color.white);
		pcb2.setForeground(Color.black);
		pcb2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				d_path = choosePath(d_path);
				d_pathChosen();
			}
		});
		p1.add(pcb2);
		pcb2.setBounds(1170,570,200,50);
		JButton de = new JButton("Decrypt");
		de.setFont(new Font("Roboto Slab", Font.PLAIN, 32));
		de.setBackground(Color.blue);
		de.setForeground(Color.white);
		de.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				decrypt_call();
			}
		});
		p1.add(de);
		de.setBounds(1350,800,200,50);
		JButton vr = new JButton();
		vr.setBackground(Color.green);
		vr.setEnabled(false);
		p1.add(vr);
		vr.setBounds(920,250,5,700);
		f.add(p1);
		f.setSize(1920,1020);
		f.setTitle("Cryptonite - Data Encryption-Decryption Software");
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setResizable(false);
		f.setExtendedState( f.getExtendedState()|JFrame.MAXIMIZED_BOTH );
		f.setVisible(true);
	}
	private String chooseFile(String s)
	{
		JFileChooser fc1 = new JFileChooser();
		fc1.setCurrentDirectory(new File(System.getProperty("user.home")));
		fc1.setLocation(40,300);
		int result = fc1.showOpenDialog(p1);
		if(result == JFileChooser.APPROVE_OPTION)
		{
			File selectedFile = fc1.getSelectedFile();
			s = selectedFile.getAbsolutePath();
		}
		return s;
	}
	private String choosePath(String s)
	{
		JFileChooser fc1 = new JFileChooser();
		fc1.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		fc1.setCurrentDirectory(new File(System.getProperty("user.home")));
		fc1.setLocation(40,300);
		int result = fc1.showOpenDialog(p1);
		if(result == JFileChooser.APPROVE_OPTION)
		{
			File selectedFile = fc1.getSelectedFile();
			s = selectedFile.getAbsolutePath();
		}
		return s;
	}
	public void e_fileChosen()
	{
		if(e_file!=null)
		{
			JLabel la1 = new JLabel("<html>File Chosen</html>");
			la1.setFont(new Font("Roboto Slab", Font.PLAIN, 32));
			la1.setForeground(Color.green);
			p1.add(la1);
			la1.setLocation(125,380);
			la1.setSize(200,50);
		}
	}
	public void e_pathChosen()
	{
		if(e_path!=null)
		{
			JLabel la2 = new JLabel("<html>Path Chosen</html>");
			la2.setFont(new Font("Roboto Slab", Font.PLAIN, 32));
			la2.setForeground(Color.green);
			p1.add(la2);
			la2.setLocation(125,680);
			la2.setSize(200,50);
		}
	}
	public void d_fileChosen()
	{
		if(d_file!=null)
		{
			JLabel la3 = new JLabel("<html>File Chosen</html>");
			la3.setFont(new Font("Roboto Slab", Font.PLAIN, 32));
			la3.setForeground(Color.green);
			p1.add(la3);
			la3.setLocation(1175,380);
			la3.setSize(200,50);
		}
	}
	public void d_pathChosen()
	{
		if(d_path!=null)
		{
			JLabel la5 = new JLabel("<html>Path Chosen</html>");
			la5.setFont(new Font("Roboto Slab", Font.PLAIN, 32));
			la5.setForeground(Color.green);
			p1.add(la5);
			la5.setLocation(1175,630);
			la5.setSize(200,50);
		}
	}
	public JLabel e_notPossible()
	{
		if(la8!=null)
		{
			p1.remove(la8);
			p1.revalidate();
		}
		if(la6!=null)
		{
			p1.remove(la6);
			p1.revalidate();
		}
		la6 = new JLabel("<html>&nbsp Encryption failed<br>&nbsp&nbsp Please try again</html>");
		la6.setFont(new Font("Roboto Slab", Font.PLAIN, 32));
		la6.setForeground(Color.red);
		p1.add(la6);
		la6.setLocation(260,800);
		la6.setSize(500,200);
		return la6;
	}
	public JLabel e_possible()
	{
		if(la6!=null)
		{
			p1.remove(la6);
			p1.revalidate();
		}
		if(la8!=null)
		{
			p1.remove(la8);
			p1.revalidate();
		}
		la8 = new JLabel("<html>Encryption Successful !</html>");
		la8.setFont(new Font("Roboto Slab", Font.PLAIN, 32));
		la8.setForeground(Color.green);
		p1.add(la8);
		la8.setLocation(240,780);
		la8.setSize(500,200);
		return la8;
	}
	public JLabel d_notPossible()
	{
		if(la9!=null)
		{
			p1.remove(la9);
			p1.revalidate();
		}
		if(la7!=null)
		{
			p1.remove(la7);
			p1.revalidate();
		}
		la7 = new JLabel("<html>&nbsp Decryption failed<br>&nbsp&nbsp Please try again</html>");
		la7.setFont(new Font("Roboto Slab", Font.PLAIN, 32));
		la7.setForeground(Color.red);
		p1.add(la7);
		la7.setLocation(1310,800);
		la7.setSize(500,200);
		return la7;
	}
	public JLabel d_possible()
	{
		if(la7!=null)
		{
			p1.remove(la7);
			p1.revalidate();
		}
		if(la9!=null)
		{
			p1.remove(la9);
			p1.revalidate();
		}
		la9 = new JLabel("<html>Decryption Successful !</html>");
		la9.setFont(new Font("Roboto Slab", Font.PLAIN, 32));
		la9.setForeground(Color.green);
		p1.add(la9);
		la9.setLocation(1290,780);
		la9.setSize(500,200);
		return la9;
	}
	private void encrypt_call()
	{
		if(e_file!=null && e_path!=null)
		{
			backend.Text.encrypt(e_file,e_path);
			la6 = e_possible();
			enc = true;
		}
		else
			la8 = e_notPossible();
	}
	private void decrypt_call()
	{
		if(d_file!=null && d_path!=null && enc == true)
		{
			backend.Text.decrypt(e_path,d_file,d_path);
			la7 = d_possible();
		}
		else
			la9 = d_notPossible();
	}
}

