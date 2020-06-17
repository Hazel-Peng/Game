package game;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DropMode;

public class Star01 extends JFrame {

	private JPanel ok;
	private JTextField num;
	private JTextArea result;
	private String ans =null;
	private String s = "＊";
	private String t = "　";
	private String e = "\n";
	private int gnum;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Star01 frame = new Star01();
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
	public Star01() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 517, 395);
		ok = new JPanel();
		ok.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(ok);
		ok.setLayout(null);

		num = new JTextField();
		num.setFont(new Font("新細明體", Font.PLAIN, 18));
		num.setBounds(10, 97, 117, 21);
		ok.add(num);
		num.setColumns(10);

		JLabel lblNewLabel = new JLabel("\u8ACB\u8F38\u5165\u661F\u661F\u6578:");
		lblNewLabel.setFont(new Font("新細明體", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 66, 122, 20);
		ok.add(lblNewLabel);

		JRadioButton up = new JRadioButton("\u25B2");
		buttonGroup.add(up);
		up.setFont(new Font("新細明體", Font.PLAIN, 18));
		up.setBounds(10, 124, 53, 23);
		ok.add(up);

		JRadioButton down = new JRadioButton("\u25BC");
		buttonGroup.add(down);
		down.setFont(new Font("新細明體", Font.PLAIN, 18));
		down.setBounds(10, 149, 53, 23);
		ok.add(down);

		JRadioButton diamond1 = new JRadioButton("\u25C6");
		buttonGroup.add(diamond1);
		diamond1.setFont(new Font("新細明體", Font.PLAIN, 18));
		diamond1.setBounds(10, 174, 53, 23);
		ok.add(diamond1);

		JRadioButton diamond2 = new JRadioButton("\u25C7");
		buttonGroup.add(diamond2);
		diamond2.setFont(new Font("新細明體", Font.PLAIN, 18));
		diamond2.setBounds(10, 199, 53, 23);
		ok.add(diamond2);

		result = new JTextArea();
		result.setEditable(false);
		result.setBounds(137, 13, 354, 333);
		ok.add(result);

		JButton button = new JButton("\u78BA\u5B9A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				result.setText("");
				ans="";
				try{
					gnum = Integer.parseInt(num.getText());			
				}catch(NumberFormatException a){
					int n=JOptionPane.showConfirmDialog(getContentPane(), "請輸入數字", "數字", JOptionPane.OK_OPTION,
							JOptionPane.INFORMATION_MESSAGE);

				}

				if (up.isSelected()) {
					for (int i = 0; i < gnum; i++) {
						for (int j = i; j < gnum; j++) {
							ans += t;
						}
						for (int k = 0; k <= i; k++) {
							ans += s;
							ans += t;
						}
						ans += e;
					}
					result.setText(ans);
					
				} else if (down.isSelected()) {
					for (int i = gnum; i > 0; i--) {
						for (int j = gnum; j > i - 1; j--) {
							ans += t;
						}
						for (int k = 0; k < i; k++) {
							ans += s;
							ans += t;
						}
						ans += e;

					}
					result.setText(ans);
				} else if (diamond1.isSelected()) {
					for (int i = 0; i < gnum; i++) {
						for (int j = i; j < gnum; j++) {
							ans += t;
						}
						for (int k = 0; k <= i; k++) {
							ans += s;
							ans += t;
						}
						ans += e;
					}
					for (int i = gnum - 1; i > 0; i--) {
						for (int j = gnum - 1; j >= i - 1; j--) {
							ans += t;
						}
						for (int k = 0; k < i; k++) {
							ans += s;
							ans += t;
						}
						ans += e;
					}
					result.setText(ans);
				}else if(diamond2.isSelected()){
					for (int i = 0; i < gnum; i++) {
						for (int j = i; j < gnum; j++) {
							ans += t;
						}
						for (int k = 0; k <= i; k++) {
							if(k==0||k==i||k==1||k==i-1){
								ans += s;
								ans += t;}
							else{
								ans += t;
								ans += t;}
						}
						ans += e;
					}
					for (int i = gnum - 1; i > 0; i--) {
						for (int j = gnum - 1; j >= i - 1; j--) {
							ans += t;
						}
						for (int k = 0; k < i; k++) {
							if(k==0||k==i-1||k==1||k==i-2){
								ans += s;
								ans += t;
								}
							else{
								ans += t;
								ans += t;}
						}
						ans += e;
					}
					result.setText(ans);
				}
			}
		});
		button.setBounds(10, 229, 87, 23);
		ok.add(button);
		
		JButton clear = new JButton("\u91CD\u65B0");
		clear.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				result.setText("");
				ans=" ";
				gnum=0; 
			}
		});
		clear.setBounds(10, 262, 87, 23);
		ok.add(clear);
	}
}
