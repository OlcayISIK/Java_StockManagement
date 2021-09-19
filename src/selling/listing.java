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

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class listing {
	public void getFrame() throws FileNotFoundException {
		JFrame frame = new JFrame("Listing Page");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		File file = new File("items.txt");
		ArrayList<String> item_list = new ArrayList<String>();
		Scanner read = new Scanner(file);

		while (read.hasNextLine()) {
			String write = read.nextLine();
			item_list.add(write);
		}

		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.setBounds(0, 0, 1024, 768);
		DefaultTableModel list1 = new DefaultTableModel();
		list1.addColumn("Barcode");
		list1.addColumn("Clothes");
		list1.addColumn("Colour");
		list1.addColumn("Size");
		list1.addColumn("Selling Money");
		list1.addColumn("Buying Money");
		list1.addColumn("Stock");
		list1.addColumn("Avaibility");

		JTable table = new JTable(list1);
		table.setLayout(new BorderLayout());
		JScrollPane spanel = new JScrollPane(table);
		spanel.setSize(1024, 468);
		spanel.setLocation(0, 0);
		panel.add(spanel, BorderLayout.CENTER);

		int i = 0;
		do {
			list1.addRow(
					new Object[] { item_list.get(i), item_list.get(i + 1), item_list.get(i + 2), item_list.get(i + 3),
							item_list.get(i + 4), item_list.get(i + 5), item_list.get(i + 6), item_list.get(i + 7) });
			i += 9;
		} while (i < item_list.size());

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
		frame.add(tb);
		frame.add(panel);
		frame.setSize(1024, 768);
		frame.setLayout(null);
		frame.setVisible(true);
	}
}