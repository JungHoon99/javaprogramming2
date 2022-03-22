import java.awt.Container;

import javax.swing.*;

/*
 * 회원 가입 메뉴
 */
public class signUp extends JFrame{
	private JLabel idLabel = new JLabel("아이디");
	private JLabel pwLabel = new JLabel("비밀번호");
	private JLabel pwCheckLabel = new JLabel("비밀번호 확인");
	private JLabel nameLabel = new JLabel("이름");
	private JLabel emailLabel = new JLabel("이메일");
	private JLabel phoneNumberLabel = new JLabel("전화번호");
	private JTextField idFiled = new JTextField();
	private JTextField pwFiled = new JTextField();
	private JTextField pwCheckFiled = new JTextField();
	private JTextField nameFiled = new JTextField();
	private JTextField emailFiled = new JTextField();
	private JTextField phoneNumberFiled = new JTextField();
	Container c = getContentPane();
	
	public signUp() {
		setTitle("회원가입");
		setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		idLabel.setLocation(0,10);
		idLabel.setSize(90,30);
		idLabel.setHorizontalAlignment(JLabel.RIGHT);
		pwLabel.setLocation(0,50);
		pwLabel.setSize(90,30);
		pwLabel.setHorizontalAlignment(JLabel.RIGHT);
		pwCheckLabel.setLocation(0,90);
		pwCheckLabel.setSize(90,30);
		pwCheckLabel.setHorizontalAlignment(JLabel.RIGHT);
		nameLabel.setLocation(0,130);
		nameLabel.setSize(90,30);
		nameLabel.setHorizontalAlignment(JLabel.RIGHT);
		emailLabel.setLocation(0,170);
		emailLabel.setSize(90,30);
		emailLabel.setHorizontalAlignment(JLabel.RIGHT);
		phoneNumberLabel.setLocation(0,210);
		phoneNumberLabel.setSize(90,30);
		phoneNumberLabel.setHorizontalAlignment(JLabel.RIGHT);
		idFiled.setLocation(95,15);
		idFiled.setSize(120, 20);
		idFiled.requestFocus();
		pwFiled.setLocation(95,55);
		pwFiled.setSize(120, 20);
		c.add(idLabel);
		c.add(pwLabel);
		c.add(pwCheckLabel);
		c.add(nameLabel);
		c.add(emailLabel);
		c.add(phoneNumberLabel);
		c.add(idFiled);
		c.add(pwFiled);
		setResizable(false);
		setSize(300,350);
		setVisible(true);
	}

}
