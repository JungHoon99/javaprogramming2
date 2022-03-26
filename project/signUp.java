import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.*;

//import traning.LoginUri.pwListener;

/*
 * 회원 가입 메뉴
 * 서버와 DataBase를 연동하여 회원가입시에입력한 아이디가
 * DataBase에 있는지 없는지 확인까지함
 */
public class signUp extends JFrame{
	ticketClient getClient;
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
	private JButton idCheckButton = new JButton("확인");
	Container c = getContentPane();
	
	public signUp(ticketClient client) {
		getClient = client;
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
		idCheckButton.setLocation(230,15);
		idCheckButton.setSize(70,20);
		idCheckButton.addActionListener(new idCheckAction());
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
		c.add(idCheckButton);
		setResizable(false);
		setSize(320,350);
		setVisible(true);
	}
	
	class idCheckAction implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String id = idField.getText();
			getClient.select(id);
			
		}
	}
	
	//사용자에게 재입력 비밀번호가 전입력 비밀번호와 맞는지 알림
	class pwCheckListener extends KeyAdapter{
		@Override
        public void keyPressed(KeyEvent e) {
			String Text = pwCheckField.getText()+e.getKeyChar();
			pwCheckRightLabel.setLocation(95,105);
			//pwCheckField에 있는 문자열과 pwField에 있는 문자열이 같은지 확인
			//같으면 일치한다는 걸 알려줌
			if(Text.equals(pwField.getText())) {
				pwCheckRightLabel.setText("비밀번호가 일치 합니다.");
				pwCheckRightLabel.setForeground(new Color(39, 107, 56));
			}
			else if((Text.length()==2 & e.getKeyCode()==8) | (Text.length()==1 & e.getKeyCode()==8)) {
				pwCheckRightLabel.setText("비밀번호를 일치 시켜 주세요");
				pwCheckRightLabel.setForeground(Color.blue);
			}
			//같지 않다면 일치 하지 않음을 보여줌
			else {
				pwCheckRightLabel.setText("비밀번호가 일치하지 않습니다.");
				pwCheckRightLabel.setForeground(Color.red);
			}
		}
	}
	
	//사용자에게 비밀번호 사용 가능 여부 알림
	class pwListener extends KeyAdapter{
		@Override
        public void keyPressed(KeyEvent e) {
			String Text = pwField.getText()+e.getKeyChar(); 
			pwRightCheckLabel.setLocation(95,70);
			// pwField의 길이가 8보다 큰지 확인
			if(Text.length() >= 8) {
				/*
				 * 형식에서 지원하지 않는 문자가 들어오면 지원하지 않는 문자라고 알리는 구문 구현 해야함
				 */
				// pwField에 문자자 있는지 확인
				if(!Text.matches(".*[a-z|A-Z|].*")) {
					pwRightCheckLabel.setText("문자를 입력해 주세요");
					pwRightCheckLabel.setForeground(Color.red);
				}
				// pwField에 숫자가 있는지 확인
				else if(!Text.matches(".*[0-9].*")) {
					pwRightCheckLabel.setText("숫자를 입력해 주세요");
					pwRightCheckLabel.setForeground(Color.red);
				}
				// pwField에 특수 문자가 있는지 확인
				else if(!Text.matches(".*[*!@?~&+-].*")) {
					pwRightCheckLabel.setText("특수문자를 입력해 주세요");
					pwRightCheckLabel.setForeground(Color.red);
				}
				//모든 조건이 만족되어 있으면 만족된걸 사용자에게 알려줌
				else {
					pwRightCheckLabel.setText("사용 할 수 있는 비밀번호 입니다.");
					pwRightCheckLabel.setForeground(new Color(39, 107, 56));
				}
				
			}
			else if((Text.length()==2 & e.getKeyCode()==8) | (Text.length()==1 & e.getKeyCode()==8)) {
				pwRightCheckLabel.setText("숫자,문자,특수문자를 포함한 8자이상 입력해주세요");
				pwRightCheckLabel.setLocation(30,70);
				pwRightCheckLabel.setForeground(Color.blue);
			}
			// 짧다면 부족하나다고 알려줌
			else {
				pwRightCheckLabel.setLocation(95,70);
				pwRightCheckLabel.setText("8자리 이상 입력해 주세요");
				pwRightCheckLabel.setForeground(Color.red);
			}
		}
	}
}
