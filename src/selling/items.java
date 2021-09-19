package selling;

public class items implements clothes {
	public String Dress(String barcode, Object color, Object size, String stock, Object Avaibility) {
		String Code = barcode.substring(0, 3);
		String buy_money = barcode.substring(6, 9);
		String sell_money = barcode.substring(3, 6);
		if (Integer.valueOf(Code) < 200) {

			return barcode + "\n" + "Dress\n" + color + "\n" + size + "\n" + buy_money + "\n" + sell_money + "\n"
					+ stock + "\n" + Avaibility;
		} else if (200 < Integer.valueOf(Code) && Integer.valueOf(Code) < 400) {

			return barcode + "\n" + "Pants\n" + color + "\n" + size + "\n" + buy_money + "\n" + sell_money + "\n"
					+ stock + "\n" + Avaibility;
		} else if (400 < Integer.valueOf(Code) && Integer.valueOf(Code) < 600) {

			return barcode + "\n" + "T-Shirt\n" + color + "\n" + size + "\n" + buy_money + "\n" + sell_money + "\n"
					+ stock + "\n" + Avaibility;
		} else if (600 < Integer.valueOf(Code) && Integer.valueOf(Code) < 800) {

			return barcode + "\n" + "Sweat Shirt\n" + color + "\n" + size + "\n" + buy_money + "\n" + sell_money + "\n"
					+ stock + "\n" + Avaibility;
		} else if (800 < Integer.valueOf(Code) && Integer.valueOf(Code) < 1000) {

			return barcode + "\n" + "Hat\n" + color + "\n" + size + "\n" + buy_money + "\n" + sell_money + "\n" + stock
					+ "\n" + Avaibility;
		}
		return null;

	}
}
