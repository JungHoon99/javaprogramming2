import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
import javax.swing.event.*;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class StartMenu {
	
	public static void main(String[] args){
		ticketClient client = null;
		try {
			client = new ticketClient();
		} catch (IOException e) {
			e.printStackTrace();
		}
		LoginUri main = new LoginUri(client);
	}
}


/*
 * 로그인 메뉴
 */

class LoginUri extends JFrame{
	ticketClient getClient;
	private JButton signInButton = new JButton("로그인");
	private JButton signUpButton = new JButton("회원가입");
	private JLabel IdLabel = new JLabel("아이디");
	private JLabel pwLabel = new JLabel("비밀번호");
	private JTextField idFiled = new JTextField();
	private JTextField pwFiled = new JPasswordField();
	Container c = getContentPane();
	public LoginUri(ticketClient client) {
		getClient = client;
		setTitle("로그인");
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		signInButton.setLocation(90,100);
		signInButton.setSize(100, 20);
		signInButton.addActionListener(new SignInListener());
		signUpButton.setLocation(90,130);
		signUpButton.setSize(100, 20);
		signUpButton.addActionListener(new SignUpListener());
		IdLabel.setLocation(0,10);
		IdLabel.setSize(90,30);
		IdLabel.setHorizontalAlignment(JLabel.RIGHT);
		pwLabel.setLocation(0,50);
		pwLabel.setSize(90,30);
		pwLabel.setHorizontalAlignment(JLabel.RIGHT);
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
	
	//pwFiled에 엔터  입력이 들어 온다면 로그인 회면 출력  
	class pwListener extends KeyAdapter{
		@Override
        public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_ENTER){
				//JFrame 기능 정지
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				// 프로그램 화면 종료
				dispose();
				mainMenu signup = new mainMenu();
			}
		}
	}
	
	//idFiled에 엔터 입력이 들어 온다면 포커스를 pwFiled에 둔다
	class idListener extends KeyAdapter{
		@Override
        public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_ENTER){
				pwFiled.requestFocus();
			}
		}
	}
	
	class SignInListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			mainMenu signup = new mainMenu();
		}
		
	}
	
	class SignUpListener implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			signUp signup = new signUp(getClient);
		}
		
	}
}
