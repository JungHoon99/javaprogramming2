import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
import javax.swing.event.*;

import java.util.ArrayList;

public class StartMenu {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LoginUri f = new LoginUri();
	}

}


class LoginUri extends JFrame{
	private JButton signInButton = new JButton("로그인");
	private JButton signUpButton = new JButton("회원가입");
	private JLabel IdLabel = new JLabel("아이디");
	private JLabel pwLabel = new JLabel("비밀번호");
	private JTextField idFiled = new JTextField();
	private JTextField pwFiled = new JTextField(20);
	Container c = getContentPane();
	public LoginUri() {
		setTitle("로그인");
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		signInButton.setLocation(90,100);
		signInButton.setSize(100, 20);
		signUpButton.setLocation(90,130);
		signUpButton.setSize(100, 20);
		signUpButton.addActionListener(new SignUpListener());
		IdLabel.setLocation(50,10);
		IdLabel.setSize(100,30);
		pwLabel.setLocation(40,50);
		pwLabel.setSize(100,30);
		idFiled.setLocation(95,15);
		idFiled.setSize(120, 20);
		idFiled.requestFocus();
		idFiled.addKeyListener(new idListener());
		pwFiled.setLocation(95,55);
		pwFiled.setSize(120, 20);
		pwFiled.addKeyListener(new pwListener());
		c.add(signInButton);
		c.add(signUpButton);
		c.add(IdLabel);
		c.add(pwLabel);
		c.add(idFiled);
		c.add(pwFiled);
		setResizable(false);
		setSize(300,200);
		setVisible(true);
	}
	
	class pwListener extends KeyAdapter{
		@Override
        public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_ENTER){
				mainMenu signup = new mainMenu();
			}
		}
	}
	
	class idListener extends KeyAdapter{
		@Override
        public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_ENTER){
				pwFiled.requestFocus();
			}
		}
	}
	
	class SignUpListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			signUp signup = new signUp();
		}
		
	}
}
