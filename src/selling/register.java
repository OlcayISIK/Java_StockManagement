package selling;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class register {
	public void getFrame() {
		JFrame frame = new JFrame("Register Page");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		File file = new File("users.txt");

		JLabel label = new JLabel();
		ImageIcon icon = new ImageIcon("Employee_ID-512.png");
		label.setSize(690, 685);
		label.setLocation(-15, -100);
		label.setIcon(icon);

		ArrayList<String> user = new ArrayList<String>();
		Scanner read = null;
		try {
			read = new Scanner(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		while (read.hasNextLine()) {
			String write = read.nextLine();
			user.add(write);
		}

		JPanel panel = new JPanel();
		panel.setBackground(Color.blue);
		panel.setLayout(null);

		JLabel namel = new JLabel("Name :");
		namel.setForeground(Color.cyan);
		namel.setSize(100, 30);
		namel.setLocation(5, 222);
		panel.add(namel);
		JTextField name = new JTextField();
		name.setLocation(220, 222);
		name.setSize(230, 30);
		panel.add(name);

		JLabel passl = new JLabel("Password :");
		passl.setForeground(Color.cyan);
		passl.setSize(200, 30);
		passl.setLocation(5, 282);
		panel.add(passl);
		JPasswordField password = new JPasswordField();
		password.setLocation(220, 282);
		password.setSize(230, 30);
		panel.add(password);

		JLabel passl1 = new JLabel("Password Repeat :");
		passl1.setForeground(Color.cyan);
		passl1.setSize(200, 30);
		passl1.setLocation(5, 342);
		panel.add(passl1);
		JPasswordField password2 = new JPasswordField();
		password2.setLocation(220, 342);
		password2.setSize(230, 30);
		password2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (password.getText().equals(password2.getText())) {
					user.add(name.getText());
					user.add(password.getText());

					FileWriter fw = null;
					try {
						fw = new FileWriter(file);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					for (int add = 0; add < user.size(); add++) // We create a
																// loop for
																// write all the
																// index to the
																// file.
					{
						try {
							fw.write(user.get(add) + "\n");
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}

					try {
						fw.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} // Close the file.

					JOptionPane.showMessageDialog(frame, " Register Complete.");
				} else {
					JOptionPane.showMessageDialog(frame, "Your password didn't match");
				}
			}
		});

		JButton tb = new JButton("Turn Back");
		tb.setBackground(Color.cyan);
		tb.setLocation(30, 420);
		tb.setSize(100, 30);
		tb.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				login log = login.getlogin();
				try {
					log.getFrame();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel.add(password2);
		panel.add(tb);
		panel.add(label);
		frame.add(panel);
		frame.setSize(500, 500);
		frame.setVisible(true);

	}
}
