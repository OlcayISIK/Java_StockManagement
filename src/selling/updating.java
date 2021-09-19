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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class updating {

	public void getFrame() throws FileNotFoundException {
		JFrame frame = new JFrame("Updating Page");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		File file = new File("items.txt");

		ArrayList<String> item_list = new ArrayList<String>();
		Scanner read = new Scanner(file);

		while (read.hasNextLine()) {
			String write = read.nextLine();
			item_list.add(write);
		}

		JLabel label = new JLabel();
		ImageIcon icon = new ImageIcon("Update.png");
		label.setSize(690, 690);
		label.setLocation(-90, -150);
		label.setIcon(icon);

		JPanel panel = new JPanel();
		panel.setBackground(Color.blue);
		panel.setLayout(null);
		panel.setLayout(null);
		panel.setSize(300, 300);

		JLabel a = new JLabel("Please Enter 9 Digit Barcode:");
		a.setForeground(Color.black);
		a.setLocation(10, 10);
		a.setSize(200, 200);
		panel.add(a);

		JLabel b = new JLabel("Please Enter The Color:");
		b.setForeground(Color.black);
		b.setLocation(10, 60);
		b.setSize(200, 200);
		panel.add(b);

		JLabel c = new JLabel("Please Enter The Size:");
		c.setForeground(Color.black);
		c.setLocation(10, 110);
		c.setSize(200, 200);
		panel.add(c);

		JLabel d = new JLabel("Please Enter The Stock:");
		d.setForeground(Color.black);
		d.setLocation(10, 160);
		d.setSize(200, 200);
		panel.add(d);

		JLabel e = new JLabel("Please Enter The Avaibility:");
		e.setLocation(10, 210);
		e.setSize(200, 200);
		panel.add(e);

		JLabel f = new JLabel("Please Enter The Internet Picture Of Item:");
		f.setLocation(10, 260);
		f.setSize(200, 200);
		panel.add(f);

		JTextField barcode = new JTextField();
		barcode.setLocation(200, 100);
		barcode.setSize(100, 30);
		panel.add(barcode);

		JComboBox color = new JComboBox();
		color.addItem("Red");
		color.addItem("Blue");
		color.addItem("White");
		color.addItem("Black");
		color.addItem("Yellow");
		color.setLocation(200, 150);
		color.setSize(100, 30);
		panel.add(color);

		JComboBox size = new JComboBox();
		size.addItem("Small");
		size.addItem("Medium");
		size.addItem("Large");
		size.setLocation(200, 200);
		size.setSize(100, 30);
		panel.add(size);

		JTextField stock = new JTextField();
		stock.setLocation(200, 250);
		stock.setSize(100, 30);
		panel.add(stock);

		JComboBox avab = new JComboBox();
		avab.addItem("Avaiable");
		avab.addItem("Not Avaiable");
		avab.setLocation(200, 300);
		avab.setSize(100, 30);
		panel.add(avab);

		JTextField pic = new JTextField();
		pic.setLocation(200, 350);
		pic.setSize(100, 30);
		panel.add(pic);

		JButton add = new JButton("Update");
		add.setLocation(30, 30);
		add.setSize(100, 30);
		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean control = false;
				for (int i = 0; i < item_list.size(); i += 9) {

					if (item_list.get(i).equals(barcode.getText())) {
						control = true;
						items items = new items();
						item_list.remove(i);
						item_list.remove(i);
						item_list.remove(i);
						item_list.remove(i);
						item_list.remove(i);
						item_list.remove(i);
						item_list.remove(i);
						item_list.remove(i);
						item_list.add(items.Dress(barcode.getText(), color.getSelectedItem(), size.getSelectedItem(),
								stock.getText(), avab.getSelectedItem()));
						item_list.add(pic.getText());

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
						JOptionPane.showMessageDialog(frame, " Updating is Complete.");
						break;
					}

				}
				if (control == false) {
					JOptionPane.showMessageDialog(frame, " Item didn't found.");
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
		panel.add(add);
		panel.add(tb);
		panel.add(label);
		frame.add(panel);
		frame.setSize(500, 500);
		frame.setVisible(true);
	}
}
