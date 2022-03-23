import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

import traning.LoginUri.pwListener;

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
	private JLabel pwRightCheckLabel = new JLabel("숫자,문자,특수문자를 포함한 8자이상 입력해주세요");
	private JLabel pwCheckRightLabel = new JLabel("비밀번호를 일치 시켜 주세요");
	private JTextField idField = new JTextField();
	private JTextField pwField = new JPasswordField();
	private JTextField pwCheckField = new JPasswordField();
	private JTextField nameField = new JTextField();
	private JTextField emailField = new JTextField();
	private JTextField phoneNumberField = new JTextField();
	private JButton signUpButton = new JButton("회원가입");
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
		pwRightCheckLabel.setLocation(30,70);
		pwRightCheckLabel.setSize(250,30);
		pwRightCheckLabel.setForeground(Color.blue);
		pwRightCheckLabel.setFont(new Font("맑은 고딕", Font.CENTER_BASELINE , 10));
		pwCheckLabel.setLocation(0,90);
		pwCheckLabel.setSize(90,30);
		pwCheckLabel.setHorizontalAlignment(JLabel.RIGHT);
		pwCheckRightLabel.setLocation(95,105);
		pwCheckRightLabel.setSize(250,30);
		pwCheckRightLabel.setForeground(Color.blue);
		pwCheckRightLabel.setFont(new Font("맑은 고딕", Font.CENTER_BASELINE , 10));
		nameLabel.setLocation(0,130);
		nameLabel.setSize(90,30);
		nameLabel.setHorizontalAlignment(JLabel.RIGHT);
		emailLabel.setLocation(0,170);
		emailLabel.setSize(90,30);
		emailLabel.setHorizontalAlignment(JLabel.RIGHT);
		phoneNumberLabel.setLocation(0,210);
		phoneNumberLabel.setSize(90,30);
		phoneNumberLabel.setHorizontalAlignment(JLabel.RIGHT);
		idField.setLocation(95,15);
		idField.setSize(120, 20);
		idField.requestFocus();
		pwField.setLocation(95,55);
		pwField.setSize(120, 20);
		pwField.addKeyListener(new pwListener());
		pwCheckField.setLocation(95,95);
		pwCheckField.setSize(120, 20);
		pwCheckField.addKeyListener(new pwCheckListener());
		nameField.setLocation(95,135);
		nameField.setSize(120, 20);
		emailField.setLocation(95,175);
		emailField.setSize(120, 20);
		phoneNumberField.setLocation(95,215);
		phoneNumberField.setSize(120, 20);
		signUpButton.setLocation(100,250);
		signUpButton.setSize(100, 20);
		c.add(pwCheckRightLabel);
		c.add(idLabel);
		c.add(pwLabel);
		c.add(pwRightCheckLabel);
		c.add(pwCheckLabel);
		c.add(nameLabel);
		c.add(emailLabel);
		c.add(phoneNumberLabel);
		c.add(idField);
		c.add(pwField);
		c.add(pwCheckField);
		c.add(nameField);
		c.add(emailField);
		c.add(phoneNumberField);
		c.add(signUpButton);
		setResizable(false);
		setSize(300,350);
		setVisible(true);
	}
	
	class pwCheckListener extends KeyAdapter{
		@Override
        public void keyPressed(KeyEvent e) {
			String Text = pwCheckField.getText()+e.getKeyChar(); 
			pwRightCheckLabel.setLocation(95,70);
			if(Text.equals(pwField.getText())) {
				pwCheckRightLabel.setText("비밀번호가 일치 합니다.");
				pwCheckRightLabel.setForeground(new Color(39, 107, 56));
			}
			else {
				pwCheckRightLabel.setText("비밀번호가 일치하지 않습니다.");
				pwCheckRightLabel.setForeground(Color.red);
			}
			
		}
	}
	
	class pwListener extends KeyAdapter{
		@Override
        public void keyPressed(KeyEvent e) {
			String Text = pwField.getText()+e.getKeyChar(); 
			pwRightCheckLabel.setLocation(95,70);
			if(Text.length() >= 8) {
				// ! ? @ * 
				if(!Text.matches(".*[a-z|A-Z|].*")) {
					pwRightCheckLabel.setText("문자를 입력해 주세요");
					pwRightCheckLabel.setForeground(Color.red);
				}
				else if(!Text.matches(".*[0-9].*")) {
					pwRightCheckLabel.setText("숫자를 입력해 주세요");
					pwRightCheckLabel.setForeground(Color.red);
				}
				else if(!Text.matches(".*[*!@?~&+-].*")) {
					pwRightCheckLabel.setText("특수문자를 입력해 주세요");
					pwRightCheckLabel.setForeground(Color.red);
				}
				else {
					pwRightCheckLabel.setText("사용 할 수 있는 비밀번호 입니다.");
					pwRightCheckLabel.setForeground(new Color(39, 107, 56));
				}
				
			}
			else {
				pwRightCheckLabel.setLocation(95,70);
				pwRightCheckLabel.setText("8자리 이상 입력해 주세요");
				pwRightCheckLabel.setForeground(Color.red);
			}
		}
	}

}
