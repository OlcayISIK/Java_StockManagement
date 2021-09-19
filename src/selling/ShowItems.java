package selling;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ShowItems {
	public void getFrame(String username) throws FileNotFoundException {
		JFrame frame = new JFrame("Items");
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
		list1.addColumn("Item");
		list1.addColumn("Colour");
		list1.addColumn("Size");
		list1.addColumn("Money");
		list1.addColumn("Stock");
		list1.addColumn("Avaliable");

		JTable table = new JTable(list1);
		table.setLayout(new BorderLayout());
		JScrollPane spanel = new JScrollPane(table);
		panel.add(spanel, BorderLayout.CENTER);
		spanel.setSize(1024, 1000);
		spanel.setLocation(0, 0);
		table.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				String avv = (String) table.getValueAt(table.getSelectedRow(), 6);
				System.out.println(avv);
				if (avv.equalsIgnoreCase("Avaliable")) {
					JFrame frame = new JFrame("" + (String) table.getValueAt(table.getSelectedRow(), 0));
					JPanel panel = new JPanel();
					panel.setLayout(null);
					panel.setBounds(0, 0, 650, 650);

					JLabel a = new JLabel("Money:");
					a.setLocation(50, 80);
					a.setSize(200, 200);
					panel.add(a);
					a.setForeground(Color.red);

					JLabel b = new JLabel("" + (String) table.getValueAt(table.getSelectedRow(), 4));
					b.setLocation(100, 80);
					b.setSize(200, 200);
					panel.add(b);
					b.setForeground(Color.red);

					JLabel c = new JLabel("Size:");
					c.setLocation(50, 180);
					c.setSize(200, 200);
					panel.add(c);
					c.setForeground(Color.red);

					JLabel d = new JLabel("" + (String) table.getValueAt(table.getSelectedRow(), 3));
					d.setLocation(100, 180);
					d.setSize(200, 200);
					panel.add(d);
					d.setForeground(Color.red);

					JLabel ea = new JLabel("Stock:");
					ea.setLocation(50, 280);
					ea.setSize(200, 200);
					panel.add(ea);
					ea.setForeground(Color.red);

					JLabel f = new JLabel("" + (String) table.getValueAt(table.getSelectedRow(), 5));
					f.setLocation(100, 280);
					f.setSize(200, 200);
					panel.add(f);
					f.setForeground(Color.red);

					JLabel picture = new JLabel();
					picture.setLocation(1, 1);
					picture.setSize(400, 400);
					for (int i = 0; i < item_list.size(); i += 9)
						if (item_list.get(i).equalsIgnoreCase((String) table.getValueAt(table.getSelectedRow(), 0))) {
							Icon image = new ImageIcon(item_list.get(i + 8));
							picture.setIcon(image);
						}

					frame.add(panel);
					frame.setSize(750, 600);
					frame.setLayout(null);
					frame.setVisible(true);
				}

			}
		});

		int i = 0;
		do {
			list1.addRow(new Object[] { item_list.get(i), item_list.get(i + 1), item_list.get(i + 2),
					item_list.get(i + 3), item_list.get(i + 4), item_list.get(i + 6), item_list.get(i + 7) });
			i += 9;
		} while (i < item_list.size());

		JButton tb = new JButton("Turn Back");
		tb.setBackground(Color.yellow);
		tb.setLocation(300, 500);
		tb.setSize(100, 30);
		tb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Interface a = new Interface();
				try {
					a.getFrame(false, null);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		panel.add(spanel);
		panel.add(tb);
		frame.add(tb);
		frame.add(panel);
		frame.setSize(1024, 640);
		frame.setLayout(null);
		frame.setVisible(true);

	}
}
