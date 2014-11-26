import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;

public class ReadPhoneList {
	public static TreeMap<String, String> read() {
		String filename = "phone.csv";
		// Danh ba điện thoại
		TreeMap<String, String> phoneList = new TreeMap<String, String>();
		try {
			// Tạo luồng nối đến tập tin
			FileInputStream is = new FileInputStream(filename);
			// Dùng phương tiện Scanner để đọc theo bảng mã utf-8
			Scanner input = new Scanner(is, "UTF-8");
			// Đọc tệp tin
			int i = 1;
			// Trong khi còn dòng để đọc
			while (input.hasNextLine()) {
				// Đọc 1 dòng
				String line = input.nextLine();
				String[] s2 = line.split(",");
				phoneList.put(s2[0], s2[1]);
			}
			// Đóng luồng
			is.close();
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return phoneList;
	}

	public static void main(String[] args) {
		// Lấy ra danh bạ điện thoại
		TreeMap<String, String> phoneList = read();
	}

}
