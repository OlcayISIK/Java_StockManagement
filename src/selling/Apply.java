package selling;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Apply extends Methodlar {
	ButtonCreator Button = new Button();
	ButtonCreator redButton = new RedButtonDecorator(new Button());

	public void apuserDelete(String username, String barcode, String item, String stock) throws FileNotFoundException {
		ArrayList<String> apuser = new ArrayList<String>();
		File nfile = new File("Appuser.txt");

		Scanner read;
		try {
			read = new Scanner(nfile);
			while (read.hasNextLine()) {
				String write = read.nextLine();
				apuser.add(write);
			}
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		for (int i = 0; i < apuser.size(); i += 5) {
			if (barcode.equalsIgnoreCase(apuser.get(i + 1))) {
				apuser.remove(i);
				apuser.remove(i);
				apuser.remove(i);
				apuser.remove(i);
				apuser.remove(i);
			}
		}
		File itemfile = new File("items.txt");
		ArrayList<String> item_list = new ArrayList<String>();
		Scanner itemread = new Scanner(itemfile);

		while (itemread.hasNextLine()) {
			String write2 = itemread.nextLine();
			item_list.add(write2);
		}
		for (int x = 0; x < item_list.size(); x += 9) {
			if (barcode.equalsIgnoreCase(item_list.get(x))) {
				item_list.set(x + 7, "Avaliable");
			}
		}

		writeappuserfile(apuser, nfile);
		writeitemfile(item_list, itemfile);

	}

	public int appuserApprove(String username, String barcode, String item, String stock, int newstock)
			throws FileNotFoundException {
		ArrayList<String> user = new ArrayList<String>();
		File nfile = new File("UserInfos.txt");
		Scanner read;
		try {
			read = new Scanner(nfile);
			while (read.hasNextLine()) {
				String write = read.nextLine();
				user.add(write);
			}
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		user.add(username);
		user.add(barcode);
		user.add(item);
		user.add(stock);
		writeuserinfofile(user, nfile);

		ArrayList<String> apuser = new ArrayList<String>();
		File file = new File("Appuser.txt");
		Scanner read2;
		try {
			read2 = new Scanner(file);
			while (read2.hasNextLine()) {
				String write = read2.nextLine();
				apuser.add(write);
			}
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		for (int i = 0; i < apuser.size(); i += 5) {
			if (apuser.get(i).equalsIgnoreCase(username) && apuser.get(i + 1).equalsIgnoreCase(barcode)) {
				apuser.remove(i);
				apuser.remove(i);
				apuser.remove(i);
				apuser.remove(i);
				apuser.remove(i);
			}
		}

		File itemfile = new File("items.txt");
		ArrayList<String> item_list = new ArrayList<String>();
		Scanner itemread = new Scanner(itemfile);

		while (itemread.hasNextLine()) {
			String write2 = itemread.nextLine();
			item_list.add(write2);
		}
		for (int x = 0; x < item_list.size(); x += 9) {
			if (barcode.equalsIgnoreCase(item_list.get(x))) {
				newstock = (Integer.parseInt(item_list.get(x + 6)) - Integer.parseInt(stock));
				item_list.set(x + 6, String.valueOf(newstock));
				item_list.set(x + 7, "Avaliable");
			}
		}

		writeappuserfile(apuser, file);
		writeitemfile(item_list, itemfile);
		return newstock;
	}

	public void getFrame() throws FileNotFoundException {
		int newstock = 0;
		JFrame frame = new JFrame("Apply Page");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		File file = new File("Appuser.txt");
		ArrayList<String> applist = new ArrayList<String>();
		Scanner read = new Scanner(file);

		while (read.hasNextLine()) {
			String write = read.nextLine();
			applist.add(write);
		}

		File file2 = new File("items.txt");
		ArrayList<String> item_list = new ArrayList<String>();
		Scanner read2 = new Scanner(file2);

		while (read2.hasNextLine()) {
			String write = read2.nextLine();
			item_list.add(write);
		}
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBounds(0, 0, 1024, 768);
		DefaultTableModel list1 = new DefaultTableModel();
		list1.addColumn("Username");
		list1.addColumn("Barcode");
		list1.addColumn("Item");
		list1.addColumn("Stock");
		list1.addColumn("Total Stock");

		JTable table = new JTable(list1);
		table.setLayout(new BorderLayout());
		JScrollPane spanel = new JScrollPane(table);
		panel.add(spanel, BorderLayout.CENTER);
		spanel.setSize(800, 800);
		spanel.setLocation(0, 0);
		int i = 0;
		while (i < applist.size()) {
			list1.addRow(new Object[] { applist.get(i), applist.get(i + 1), applist.get(i + 2), applist.get(i + 3),
					applist.get(i + 4) });
			i += 5;
		}

		JButton decline = new JButton("Decline");
		decline.setLocation(430, 450);
		decline.setSize(100, 45);
		redButton.draw(decline);
		decline.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				String username = (String) table.getValueAt(table.getSelectedRow(), 0);
				String barcode = (String) table.getValueAt(table.getSelectedRow(), 1);
				String item = (String) table.getValueAt(table.getSelectedRow(), 2);
				String stock = (String) table.getValueAt(table.getSelectedRow(), 3);
				try {
					apuserDelete(username, barcode, item, stock);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				DefaultTableModel dm = (DefaultTableModel) table.getModel();
				while (dm.getRowCount() > 0) {
					dm.removeRow(0);
				}
				File nfile = new File("Appuser.txt");
				ArrayList<String> apuser = new ArrayList<String>();
				Scanner read;
				try {
					read = new Scanner(nfile);
					while (read.hasNextLine()) {
						String write = read.nextLine();
						apuser.add(write);
					}
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				int i = 0;
				while (i < apuser.size()) {
					list1.addRow(new Object[] { apuser.get(i), apuser.get(i + 1), apuser.get(i + 2), apuser.get(i + 3),
							apuser.get(i + 4) });
					i += 5;
				}
			}
		});

		JButton approve = new JButton("Approve");
		approve.setLocation(100, 450);
		approve.setSize(100, 45);
		Button.draw(approve);
		approve.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String username = (String) table.getValueAt(table.getSelectedRow(), 0);
				String barcode = (String) table.getValueAt(table.getSelectedRow(), 1);
				String item = (String) table.getValueAt(table.getSelectedRow(), 2);
				String stock = (String) table.getValueAt(table.getSelectedRow(), 3);
				String totalstock = (String) table.getValueAt(table.getSelectedRow(), 4);

				File file = new File("items.txt");
				ArrayList<String> itemlist = new ArrayList<String>();
				Scanner read2;
				try {
					read2 = new Scanner(file);
					while (read2.hasNextLine()) {
						String write = read2.nextLine();
						itemlist.add(write);
					}
				} catch (FileNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

				if (Integer.valueOf(totalstock) == 0) {
					JOptionPane.showMessageDialog(frame, " You Can't Approve Because There is No Stock For This Item");
				} else {
					try {
						appuserApprove(username, barcode, item, stock, newstock);
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					DefaultTableModel dm = (DefaultTableModel) table.getModel();
					while (dm.getRowCount() > 0) {
						dm.removeRow(0);
					}
					File nfile = new File("Appuser.txt");
					ArrayList<String> apuser = new ArrayList<String>();
					Scanner read;
					try {
						read = new Scanner(nfile);
						while (read.hasNextLine()) {
							String write = read.nextLine();
							apuser.add(write);
						}
					} catch (FileNotFoundException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					int i = 0;
					while (i < apuser.size()) {
						list1.addRow(new Object[] { apuser.get(i), apuser.get(i + 1), apuser.get(i + 2),
								apuser.get(i + 3), apuser.get(i + 4) });
						i += 5;
					}

				}
			}

		});

		JButton tb = new JButton("Turn Back");
		tb.setBackground(Color.YELLOW);
		tb.setLocation(500, 520);
		tb.setSize(100, 30);
		tb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Interface a = new Interface();
				try {
					a.getFrame(true, null);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel.add(tb);
		panel.add(approve);
		panel.add(decline);
		panel.add(spanel);
		frame.add(panel);
		frame.setSize(1024, 768);
		frame.setLayout(null);
		frame.setVisible(true);

	}
}