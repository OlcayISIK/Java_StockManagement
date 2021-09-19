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

public class adding extends Methodlar {
	public void getFrame() throws FileNotFoundException {
		JFrame frame = new JFrame("Adding Page");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		File file = new File("items.txt");

		ArrayList<String> item_list = new ArrayList<String>();
		Scanner read = new Scanner(file);

		while (read.hasNextLine()) {
			String write = read.nextLine();
			item_list.add(write);
		}

		JLabel label = new JLabel();
		ImageIcon icon = new ImageIcon("adding.png");
		label.setSize(690, 690);
		label.setLocation(-90, -75);
		label.setIcon(icon);

		JPanel panel = new JPanel();
		panel.setBackground(Color.yellow);
		panel.setLayout(null);

		JLabel barcodeLabel = new JLabel("Please Enter 9 Digit Barcode:");
		barcodeLabel.setLocation(10, 10);
		barcodeLabel.setSize(200, 200);
		panel.add(barcodeLabel);

		JLabel ColorLabel = new JLabel("Please Enter The Color:");
		ColorLabel.setLocation(10, 60);
		ColorLabel.setSize(200, 200);
		panel.add(ColorLabel);

		JLabel SizeLabel = new JLabel("Please Enter The Size:");
		SizeLabel.setLocation(10, 110);
		SizeLabel.setSize(200, 200);
		panel.add(SizeLabel);

		JLabel StockLabel = new JLabel("Please Enter The Stock:");
		StockLabel.setLocation(10, 160);
		StockLabel.setSize(200, 200);
		panel.add(StockLabel);

		JLabel AvaibilityLabel = new JLabel("Please Enter The Avaibility:");
		AvaibilityLabel.setLocation(10, 210);
		AvaibilityLabel.setSize(200, 200);
		panel.add(AvaibilityLabel);

		JLabel PictureLabel = new JLabel("Please Enter The Internet Picture Of Item:");
		PictureLabel.setLocation(10, 260);
		PictureLabel.setSize(200, 200);
		panel.add(PictureLabel);

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

		JComboBox avab = new JComboBox();
		avab.addItem("Avaiable");
		avab.addItem("Not Avaiable");
		avab.setLocation(200, 300);
		avab.setSize(100, 30);
		panel.add(avab);

		JTextField stock = new JTextField();
		stock.setLocation(200, 250);
		stock.setSize(100, 30);
		panel.add(stock);

		JTextField pic = new JTextField();
		pic.setLocation(200, 350);
		pic.setSize(100, 30);
		panel.add(pic);

		JButton add = new JButton("Adding");
		add.setLocation(30, 30);
		add.setSize(130, 45);
		add.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				items items = new items();
				boolean b = false;
				for (int a = 0; a < item_list.size(); a += 9) {
					if (item_list.get(a).equals(barcode.getText())) {
						b = true;
						break;
					}
				}
				if (b == true) {
					JOptionPane.showMessageDialog(frame, " You can't add same barcode.");
				} else {
					JOptionPane.showMessageDialog(frame, " Addition Complete.");
					item_list.add(items.Dress(barcode.getText(), color.getSelectedItem(), size.getSelectedItem(),
							stock.getText(), avab.getSelectedItem()));
					item_list.add(pic.getText());
					writeitemfile(item_list, file);
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