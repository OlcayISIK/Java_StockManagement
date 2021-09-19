package selling;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Interface {

	public void getFrame(boolean Control, String username) throws FileNotFoundException {

		JFrame frame = new JFrame("Main Page");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel label = new JLabel();
		ImageIcon icon = new ImageIcon("C:\\Users\\ronaaltug\\workspace\\sellingProje\\main.jpg");
		label.setSize(467, 422);
		label.setLocation(0, 0);
		label.setIcon(icon);

		JPanel panel = new JPanel();
		panel.setBackground(Color.blue);
		panel.setLayout(null);

		if (Control == true) {
			JButton add = new JButton("Adding");
			add.setBackground(Color.orange);
			add.setLocation(240, 50);
			add.setSize(200, 50);
			add.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					adding adding = new adding();
					try {
						adding.getFrame();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					frame.dispose();

				}
			});

			panel.add(add);

			JButton update = new JButton("Updating");
			update.setBackground(Color.orange);
			update.setLocation(240, 100);
			update.setSize(200, 50);
			update.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					updating updating = new updating();
					try {
						updating.getFrame();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					frame.dispose();

				}
			});
			panel.add(update);

			JButton delete = new JButton("Delete");
			delete.setBackground(Color.orange);
			delete.setLocation(240, 150);
			delete.setSize(200, 50);
			delete.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					deleting deleting = new deleting();
					try {
						deleting.getFrame();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					frame.dispose();

				}
			});
			panel.add(delete);

			JButton selling = new JButton("Selling");
			selling.setBackground(Color.orange);
			selling.setLocation(240, 200);
			selling.setSize(200, 50);
			selling.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					Selling sell = new Selling();
					try {
						sell.getFrame();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					frame.dispose();

				}
			});
			panel.add(selling);

			JButton listing = new JButton("Listing");
			listing.setBackground(Color.orange);
			listing.setLocation(240, 250);
			listing.setSize(200, 50);
			listing.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					listing listing = new listing();
					try {
						listing.getFrame();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					frame.dispose();

				}
			});
			panel.add(listing);

			JButton apply = new JButton("Apply Items");
			apply.setBackground(Color.orange);
			apply.setLocation(240, 300);
			apply.setSize(200, 50);
			apply.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					Apply app = new Apply();
					try {
						app.getFrame();
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					frame.dispose();

				}
			});
			panel.add(apply);
		} else {

			JButton showitems = new JButton("Show Items");
			showitems.setBackground(Color.ORANGE);
			showitems.setLocation(240, 50);
			showitems.setSize(200, 50);
			showitems.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					ShowItems show = new ShowItems();
					try {
						show.getFrame(username);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					frame.dispose();

				}
			});
			panel.add(showitems);

			JButton buy = new JButton("Buy");
			buy.setBackground(Color.ORANGE);
			buy.setLocation(320, 300);
			buy.setSize(120, 80);
			buy.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					Buying buying = new Buying();
					try {
						buying.getFrame(username);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					frame.dispose();

				}
			});
			panel.add(buy);

			JButton showuser = new JButton("Show User Information");
			showuser.setBackground(Color.ORANGE);
			showuser.setLocation(20, 50);
			showuser.setSize(200, 50);
			showuser.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					UserInfo userinfo = new UserInfo();
					userinfo.getFrame(username);
					frame.dispose();

				}
			});
			panel.add(showuser);
		}

		JButton tb = new JButton("Turn Back");
		tb.setBackground(Color.yellow);
		tb.setLocation(20, 320);
		tb.setSize(120, 30);
		tb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				login a = new login();
				try {
					a.getFrame();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		panel.add(label);
		panel.add(tb);
		frame.add(tb);
		frame.add(panel);
		frame.setSize(475, 430);
		frame.setVisible(true);

	}
}
