package selling;

import java.awt.Color;
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
import javax.swing.JTextField;

public class Selling {
	public void getFrame() throws FileNotFoundException {
		JFrame frame = new JFrame("Selling Page");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		File file = new File("items.txt");

		ArrayList<String> item_list = new ArrayList<String>();
		Scanner read = new Scanner(file);

		while (read.hasNextLine()) {
			String write = read.nextLine();
			item_list.add(write);
		}
		File file2 = new File("UserInfos.txt");

		ArrayList<String> user_list = new ArrayList<String>();
		Scanner read2 = new Scanner(file2);

		while (read2.hasNextLine()) {
			String write = read2.nextLine();
			user_list.add(write);
		}

		JLabel label = new JLabel();
		ImageIcon icon = new ImageIcon("selling.png");
		label.setSize(690, 690);
		label.setLocation(-100, -100);
		label.setIcon(icon);

		JPanel panel = new JPanel();
		panel.setBackground(Color.white);
		panel.setLayout(null);

		JLabel a = new JLabel("Please Enter 9 Digit Barcode:");
		a.setLocation(10, 10);
		a.setSize(2000, 200);
		panel.add(a);
		a.setForeground(Color.black);

		JLabel b = new JLabel("Please Enter Sold Items:");
		b.setLocation(10, 110);
		b.setSize(2000, 200);
		panel.add(b);
		b.setForeground(Color.black);

		JLabel stock = new JLabel("Warehouse: ");
		stock.setLocation(50, 150);
		stock.setSize(150, 30);
		panel.add(stock);
		stock.setForeground(Color.black);

		JTextField stolen = new JTextField();
		stolen.setLocation(200, 200);
		stolen.setEnabled(false);
		stolen.setSize(100, 30);
		panel.add(stolen);

		JLabel generalProfit = new JLabel("General Profit: ");
		generalProfit.setLocation(200, 350);
		generalProfit.setSize(150, 30);
		panel.add(generalProfit);
		generalProfit.setForeground(Color.black);

		JLabel buymoney = new JLabel("Buying Money: ");
		buymoney.setLocation(50, 250);
		buymoney.setSize(300, 30);
		panel.add(buymoney);

		JLabel t = new JLabel("Selling Money: ");
		t.setLocation(50, 300);
		t.setSize(300, 30);
		panel.add(t);

		JLabel k = new JLabel("");
		k.setLocation(50, 350);
		k.setSize(300, 30);
		panel.add(k);

		JTextField barcode = new JTextField();
		barcode.setLocation(200, 100);
		barcode.setSize(100, 30);
		barcode.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				for (int i = 0; i < item_list.size(); i += 9) {

					if (item_list.get(i).equals(barcode.getText())) {
						if (Integer.valueOf(item_list.get(i + 6)) > 0) {
							stock.setText("Warehouse: " + item_list.get(i + 6));
							stolen.setEnabled(true);

							for (int z = 0; z < item_list.size(); z += 9) {

								if (item_list.get(z).equals(barcode.getText())) {
									buymoney.setText("Buying Money: " + item_list.get(z + 5));
									t.setText("Selling Money: " + item_list.get(z + 4));
									int f = Integer.valueOf(item_list.get(z + 4))
											- Integer.valueOf(item_list.get(z + 5));
									if (f > 0) {
										k.setText("Your Profit is: " + f);
									} else if (f < 0)
										k.setText("Your loss is" + f);
									else
										k.setText("You Don't Have Loss or Profit");
								}

							}
						}
					}
				}
			}
		});

		panel.add(barcode);
		stolen.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < item_list.size(); i += 9) {

					if (item_list.get(i).equals(barcode.getText())) {
						if (Integer.valueOf(item_list.get(i + 6)) > Integer.valueOf(stolen.getText())) {
							int soldout = 0;
							int soldmoney = Integer.valueOf(item_list.get(i + 4));
							int getamount = Integer.valueOf(stolen.getText());
							int lostmoney = Integer.valueOf(item_list.get(i + 5));
							item_list.set(i + 6, String.valueOf(
									Integer.valueOf(item_list.get(i + 6)) - Integer.valueOf(stolen.getText())));
							for (int a = 0; a < user_list.size(); a += 4) {
								if (user_list.get(a + 1).equals(barcode.getText())) {
									soldout = Integer.valueOf(user_list.get(a + 3));
								}
							}
							int profit = ((soldout + getamount) * soldmoney) - ((soldout + getamount) * lostmoney);
							generalProfit.setText("General Profit: " + profit);

							FileWriter fw = null;
							try {
								fw = new FileWriter(file);
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							for (int add = 0; add < item_list.size(); add++) // We
																				// create
																				// a
																				// loop
																				// for
																				// write
																				// all
																				// the
																				// index
																				// to
																				// the
																				// file.
							{
								try {
									fw.write(item_list.get(add) + "\n");
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

							stock.setText("Warehouse: " + item_list.get(i + 6));

						} else {
							JOptionPane.showMessageDialog(frame, " You can't substract anymore.");
							break;
						}
					}
				}

			}
		});

		JButton tb = new JButton("Turn Back");
		tb.setLocation(30, 400);
		tb.setSize(100, 30);
		tb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Interface Interface = new Interface();
				try {
					Interface.getFrame(true, null);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel.add(tb);
		panel.add(label);
		frame.add(panel);
		frame.setSize(500, 500);
		frame.setVisible(true);
	}
}
