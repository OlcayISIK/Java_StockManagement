package selling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Methodlar {

	public void writeappuserfile(ArrayList<String> apuser, File file) {
		FileWriter fw = null;
		try {
			fw = new FileWriter(file);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (int add = 0; add < apuser.size(); add++) // We create a loop for
														// write all the index
														// to the file.
		{
			try {
				fw.write(apuser.get(add) + "\n");
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

	}

	public void writeitemfile(ArrayList<String> item_list, File file) {
		FileWriter fw = null;
		try {
			fw = new FileWriter(file);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (int add = 0; add < item_list.size(); add++) // We create a loop for
															// write all the
															// index to the
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
	}

	public void writeuserinfofile(ArrayList<String> user, File file) {
		FileWriter fw = null;
		try {
			fw = new FileWriter(file);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (int add = 0; add < user.size(); add++) // We create a loop for
													// write all the index to
													// the file.
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
	}

	public void writemoneyinfofile(ArrayList<String> money_list, File file) {
		FileWriter fw = null;
		try {
			fw = new FileWriter(file);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		for (int add = 0; add < money_list.size(); add++) // We create a loop
															// for write all the
															// index to the
															// file.
		{
			try {
				fw.write(money_list.get(add) + "\n");
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
	}
}
