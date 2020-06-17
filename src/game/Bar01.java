package game;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;
import javax.swing.ButtonGroup;

public class Bar01 extends JFrame {
	Random random=new Random();
	private JLabel text;
	JLabel test;
	private JPanel contentPane;
	private JRadioButton r1,r2,r3,r4;
	private JTextField money;
	private String[] pic = { "apple", "cherry", "grape", "lemon", "orange", "pineapple", "strawbarry", "tomato" };
	private int rand1,rand2,rand3;
	private int lastmon;
	private boolean stop=false;
	private boolean go=false;
	private boolean ok=false;//控制stop
	private boolean signal=true;//控制start
	private Thread t1,t2,t3;
	
	private final ButtonGroup buttonGroup = new ButtonGroup();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bar01 frame = new Bar01();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Bar01() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 608, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel pic1 = new JLabel("");
		pic1.setIcon(new ImageIcon(Bar01.class.getResource("/fruits/apple.png")));
		pic1.setBounds(33, 25, 128, 138);
		contentPane.add(pic1);
		
		JLabel pic2 = new JLabel("");
		pic2.setIcon(new ImageIcon(Bar01.class.getResource("/fruits/apple.png")));
		pic2.setBounds(213, 25, 128, 138);
		contentPane.add(pic2);
		
		JLabel pic3 = new JLabel("");
		pic3.setIcon(new ImageIcon(Bar01.class.getResource("/fruits/apple.png")));
		pic3.setBounds(396, 25, 128, 138);
		contentPane.add(pic3);
		
		JLabel label = new JLabel("\u8CED\u91D1:");
		label.setFont(new Font("新細明體", Font.PLAIN, 18));
		label.setBounds(203, 218, 51, 23);
		contentPane.add(label);
		
		money = new JTextField();
		money.setFont(new Font("新細明體", Font.PLAIN, 18));
		money.setHorizontalAlignment(SwingConstants.RIGHT);
		money.setBounds(264, 218, 96, 23);
		contentPane.add(money);
		money.setColumns(10);
		
		JLabel label_1 = new JLabel("\u9918\u984D:");
		label_1.setFont(new Font("新細明體", Font.PLAIN, 18));
		label_1.setBounds(203, 251, 51, 23);
		contentPane.add(label_1);
		
		JLabel lastmoney = new JLabel("0");
		lastmoney.setHorizontalAlignment(SwingConstants.RIGHT);
		lastmoney.setFont(new Font("新細明體", Font.PLAIN, 18));
		lastmoney.setBounds(264, 251, 96, 23);
		contentPane.add(lastmoney);
		
		JButton coin = new JButton("");
		coin.addMouseListener(new MouseAdapter() {
			public synchronized void mouseClicked(MouseEvent e) {
				
				if(signal){	
				if(money.getText().equals("")){					
					JOptionPane.showConfirmDialog(contentPane, "請輸入下注金額", " 下注", JOptionPane.OK_OPTION,
							JOptionPane.INFORMATION_MESSAGE);		
				}
				else if(Integer.parseInt(money.getText())>Integer.parseInt(lastmoney.getText())){					
					JOptionPane.showConfirmDialog(contentPane, "餘額不足，請加值", " 沒錢", JOptionPane.OK_OPTION,
							JOptionPane.INFORMATION_MESSAGE);
				}
				else if(Integer.parseInt(lastmoney.getText())<=0){
					JOptionPane.showConfirmDialog(contentPane, "餘額不足，請加值", " 沒錢", JOptionPane.OK_OPTION,
							JOptionPane.INFORMATION_MESSAGE);					
				}
				else{
					go=true;
					lastmon=(Integer.parseInt(lastmoney.getText())-Integer.parseInt(money.getText()));
					lastmoney.setText(String.valueOf(lastmon));	
					signal=false;
				}
				
				t1=new Thread(){
					public void run(){
						while(go){						
						rand1=random.nextInt(pic.length);
						pic1.setIcon(new ImageIcon(Bar01.class.getResource("/fruits/"+pic[rand1]+".png")));
						try {
							sleep(200);
							if(stop){
								stop();		
							}
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							
						}
						}
					}
				};
				t2=new Thread(){
					public void run(){
						while(go){
						rand2=random.nextInt(pic.length);
						pic2.setIcon(new ImageIcon(Bar01.class.getResource("/fruits/"+pic[rand2]+".png")));
						try {
							sleep(200);
							if(stop){
								stop();
														
							}
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						}
					}
				};
				t3=new Thread(){
					public void run(){
						while(go){
						rand3=random.nextInt(pic.length);
						pic3.setIcon(new ImageIcon(Bar01.class.getResource("/fruits/"+pic[rand3]+".png")));
						try {
							sleep(200);
							if(stop){
								stop();								
							}
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						}
					}
				};				
				}
				
				t1.start();
				t2.start();
				t3.start();
				
				
				
				ok=true;
				stop=false;		
			
			}
			
			
		});
		coin.setIcon(new ImageIcon(Bar01.class.getResource("/fruits/coin.png")));
		coin.setBounds(33, 218, 139, 138);
		contentPane.add(coin);
		
		JButton btnNewButton = new JButton("\u52A0\u503C");
		btnNewButton.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				if(r1.isSelected()){
					lastmon=(Integer.parseInt(lastmoney.getText())+10);
					lastmoney.setText(String.valueOf(lastmon));					
				}
				else if(r2.isSelected()){
					lastmon=(Integer.parseInt(lastmoney.getText())+30);
					lastmoney.setText(String.valueOf(lastmon));					
				}
				else if(r3.isSelected()){
					lastmon=(Integer.parseInt(lastmoney.getText())+50);
					lastmoney.setText(String.valueOf(lastmon));					
				}
				else if(r4.isSelected()){
					lastmon=(Integer.parseInt(lastmoney.getText())+100);
					lastmoney.setText(String.valueOf(lastmon));
				}
				
			}
		});
		btnNewButton.setFont(new Font("新細明體", Font.PLAIN, 18));
		btnNewButton.setBounds(413, 218, 87, 23);
		contentPane.add(btnNewButton);
		
		r1 = new JRadioButton("10");
		buttonGroup.add(r1);
		r1.setBounds(396, 251, 45, 23);
		contentPane.add(r1);
		
		r2 = new JRadioButton("30");
		buttonGroup.add(r2);
		r2.setBounds(471, 251, 45, 23);
		contentPane.add(r2);
		
		r3 = new JRadioButton("50");
		buttonGroup.add(r3);
		r3.setBounds(396, 288, 45, 23);
		contentPane.add(r3);
		
		r4 = new JRadioButton("100");
		buttonGroup.add(r4);
		r4.setBounds(471, 288, 53, 23);
		contentPane.add(r4);
		
		JButton btnNewButton_1 = new JButton("stop");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			public synchronized void mouseClicked(MouseEvent e) {
				if(ok){
				stop=true;
				
				if(rand1==rand2 && rand2==rand3){
					lastmon=(Integer.parseInt(lastmoney.getText())+(Integer.parseInt(money.getText())*3));
					lastmoney.setText(String.valueOf(lastmon));
					text.setText("恭喜獲得3倍:"+(Integer.parseInt(money.getText())*3)+"元");
				}else if(rand1==rand2||rand2==rand3||rand3==rand1){
					lastmon=(Integer.parseInt(lastmoney.getText())+(Integer.parseInt(money.getText())*2));
					lastmoney.setText(String.valueOf(lastmon));
					text.setText("恭喜獲得2倍:"+(Integer.parseInt(money.getText())*2)+"元");
				}else{
					text.setText("沒中");
				}
				ok=false;
				signal=true;
				}
			}
		});
		btnNewButton_1.setBounds(33, 173, 491, 23);
		contentPane.add(btnNewButton_1);
		
		text = new JLabel("");
		text.setFont(new Font("新細明體", Font.PLAIN, 18));
		text.setBounds(203, 284, 157, 32);
		contentPane.add(text);
		
		test = new JLabel("");
		test.setBounds(203, 326, 157, 32);
		contentPane.add(test);
	}
}
