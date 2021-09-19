package selling;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Buying extends Methodlar {
	public void BuyItem(String username, String barcode, String Item, String stock, String totalStock) {
		File file = new File("Appuser.txt");
		ArrayList<String> temp = new ArrayList<String>();
		Scanner read;
		try {
			read = new Scanner(file);
			while (read.hasNextLine()) {
				String write = read.nextLine();
				temp.add(write);
			}
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		temp.add(username);
		temp.add(barcode);
		temp.add(Item);
		temp.add(stock);
		temp.add(totalStock);

		writeappuserfile(temp, file);

	}

	static int a;
	static int x;

	public void getFrame(String username) throws FileNotFoundException {

		JFrame frame = new JFrame("Item Store");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		File file = new File("items.txt");

		ArrayList<String> item_list = new ArrayList<String>();
		Scanner read = new Scanner(file);

		while (read.hasNextLine()) {
			String write = read.nextLine();
			item_list.add(write);
		}

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 1024, 768);

		DefaultTableModel list1 = new DefaultTableModel();
		list1.addColumn("Barcode");
		list1.addColumn("Item");
		list1.addColumn("Colour");
		list1.addColumn("Size");
		list1.addColumn("Money");
		list1.addColumn("Stock");
		list1.addColumn("Avaliable");
		JTable table = new JTable(list1);
		table.setLayout(new BorderLayout());
		JScrollPane spanel = new JScrollPane(table);
		spanel.setSize(600, 300);
		spanel.setLocation(0, 0);
		panel.add(spanel, BorderLayout.CENTER);

		int j = 0;
		do {
			list1.addRow(new Object[] { item_list.get(j), item_list.get(j + 1), item_list.get(j + 2),
					item_list.get(j + 3), item_list.get(j + 4), item_list.get(j + 6), item_list.get(j + 7) });
			j += 9;
		} while (j < item_list.size());

		JButton buy = new JButton("Buy");
		buy.setBackground(Color.green);
		buy.setLocation(200, 320);
		buy.setSize(100, 60);
		buy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String barcode = (String) table.getValueAt(table.getSelectedRow(), 0);
				String item = (String) table.getValueAt(table.getSelectedRow(), 1);
				String totalStock = (String) table.getValueAt(table.getSelectedRow(), 5);
				a = Integer.valueOf(totalStock);
				for (x = 0; x < item_list.size(); x += 9) {
					if (barcode.equalsIgnoreCase(item_list.get(x)))
						if (a == 0 || item_list.get(x + 7).equalsIgnoreCase("NotAvaliable")) {
							JOptionPane.showMessageDialog(frame, " You can't buy now.");
						}

						else {
							JFrame frame = new JFrame("Item Store");
							JPanel panel = new JPanel();
							panel.setLayout(null);
							JLabel a1 = new JLabel("How many products do you want to buy?");
							a1.setForeground(Color.black);
							a1.setLocation(0, 0);
							a1.setSize(250, 50);
							panel.add(a1);

							JTextField b = new JTextField();
							b.setLocation(230, 15);
							b.setSize(40, 30);
							b.addActionListener(new ActionListener() {

								@Override
								public void actionPerformed(ActionEvent e) {
									if ((a - Integer.parseInt(b.getText())) < 0) {
										JOptionPane.showMessageDialog(frame, " You can't buy that much.");
									} else {
										BuyItem(username, barcode, item, b.getText(), totalStock);
										DefaultTableModel dm = (DefaultTableModel) table.getModel();
										while (dm.getRowCount() > 0) {
											dm.removeRow(0);
										}
										item_list.clear();
										Scanner read = null;
										try {
											read = new Scanner(file);
										} catch (FileNotFoundException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}

										while (read.hasNextLine()) {
											String write = read.nextLine();
											item_list.add(write);
										}
										String b = "NotAvaliable";
										for (int k = 0; k < item_list.size(); k += 9) {
											if (item_list.get(k).equalsIgnoreCase(barcode)) {
												item_list.set(k + 7, b);
												writeitemfile(item_list, file);
											}
										}
										frame.dispose();

										int j = 0;
										do {
											list1.addRow(new Object[] { item_list.get(j), item_list.get(j + 1),
													item_list.get(j + 2), item_list.get(j + 3), item_list.get(j + 4),
													item_list.get(j + 6), item_list.get(j + 7) });
											j += 9;
										} while (j < item_list.size());
									}
								}
							});
							panel.add(b);
							frame.add(panel);
							frame.setSize(300, 100);
							frame.setVisible(true);

						}
				}
			}
		});
		JButton tb = new JButton("Turn Back");
		tb.setBackground(Color.yellow);
		tb.setLocation(50, 320);
		tb.setSize(100, 60);
		tb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Interface a = new Interface();
				try {
					a.getFrame(false, username);
					;
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		panel.add(tb);
		frame.add(tb);
		panel.add(buy);
		frame.add(panel);
		frame.setSize(617, 450);
		frame.setVisible(true);
	}
}
