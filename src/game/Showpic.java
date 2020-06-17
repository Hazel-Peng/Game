package Game;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;

public class Showpic extends JFrame {

	private JPanel contentPane;
	private JLabel labelname;
	
	int i=0;
	int j=4;
	int count=0;
	
	String animal[]={"dog.jpg","elephant.jpg","fox.jpg","lion.jpg","monkey.jpg"};
	String name[]={"狗","大象","狐狸","獅子","猴子"};
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Showpic frame = new Showpic();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Showpic() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension d=Toolkit.getDefaultToolkit().getScreenSize();
		int xweight=d.width;
		int xheight=d.height;
		setSize(800,600);
		int x=(xweight-getSize().width)/2;
		int y=(xheight-getSize().height)/2;
		setLocation(x,y);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 686, 528);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblpic = new JLabel("");
		lblpic.setHorizontalAlignment(SwingConstants.CENTER);
		lblpic.setIcon(new ImageIcon(Showpic.class.getResource("/photos/dog.jpg")));
		lblpic.setBounds(119, 43, 545, 345);
		contentPane.add(lblpic);
		
		JButton btnPrev = new JButton("");
		btnPrev.setIcon(new ImageIcon(Showpic.class.getResource("/photos/Backward.png")));
		btnPrev.setFont(new Font("新細明體", Font.PLAIN, 18));
		btnPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {								
				lblpic.setIcon(new ImageIcon(Showpic.class.getResource("/photos/"+animal[j])));
				labelname.setText(name[j]);
				j--;
				if(j==-1){
					j=animal.length-1;
				}
								
			}
		});
		btnPrev.setBounds(284, 424, 68, 65);
		contentPane.add(btnPrev);
		
		JButton btnNext = new JButton("");
		btnNext.setIcon(new ImageIcon(Showpic.class.getResource("/photos/Forward.png")));
		btnNext.setFont(new Font("新細明體", Font.PLAIN, 18));
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblpic.setIcon(new ImageIcon(Showpic.class.getResource("/photos/"+animal[i])));
				labelname.setText(name[i]);
				i++;
				if(i==animal.length){
					i=0;
				}
			}
		});
		btnNext.setBounds(440, 424, 68, 65);
		contentPane.add(btnNext);
		
		labelname = new JLabel("");
		labelname.setFont(new Font("新細明體", Font.BOLD, 18));
		labelname.setHorizontalAlignment(SwingConstants.CENTER);
		labelname.setBounds(348, 382, 87, 32);
		contentPane.add(labelname);
		
		
		JButton btnAuto = new JButton("");
		btnAuto.setIcon(new ImageIcon(Showpic.class.getResource("/photos/Repeat.png")));
		btnAuto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count++;
				new Thread(){
					public void run(){
						lblpic.setIcon(new ImageIcon(Showpic.class.getResource("/photos/"+animal[i])));
						labelname.setText(name[i]);	
						i++;
						if(i==animal.length){
							i=0;
						}						
						try {
							Thread.sleep(1000);
							if(count%2==0){
								stop();
							}
							run();
							
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						
					};
					
				}.start();
							
				
			}
		});
		btnAuto.setFont(new Font("新細明體", Font.PLAIN, 18));
		btnAuto.setBounds(362, 424, 68, 65);
		contentPane.add(btnAuto);
		
		JLabel lblNewLabel = new JLabel("14\u865F \u5F6D\u8389\u83C1");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblNewLabel.setBounds(342, 10, 100, 23);
		contentPane.add(lblNewLabel);
	}

}


