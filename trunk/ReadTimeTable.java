import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class ReadTimeTable {
	public static TreeMap<Date, String> read() {
		String filename = "lich.csv";
		TreeMap<Date, String> dsCongViec = new TreeMap<Date, String>();
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
				// Chia các nội dung bằng dấu phảy ","
				String[] s2 = line.split(",");
				// Thành phần tham dự
				String dsDuocNhanTin = s2[2];
				// Lấy danh bạ điện thoại
				TreeMap<String, String> phoneList = ReadPhoneList.read();
				// Lấy tên tất cả người dùng
				Set<String> danhSachNguoiDung = phoneList.keySet();
				for (String ten : danhSachNguoiDung) {
					// Kiểm tra họ và tên người dùng có trong thành phần tham dự
					// không
					if (dsDuocNhanTin.contains(ten)) {
						// Thay tên bằng số điện thoại
						dsDuocNhanTin = dsDuocNhanTin.replace(ten,
								phoneList.get(ten));
					}
					// Thay các dấu chấm phảy “;” bằng dấu cách (space)
					dsDuocNhanTin = dsDuocNhanTin.replace(";", " ");
				}
				// Tổng hợp số điện thoại và nội dung tin nhắn
				String command = dsDuocNhanTin + " " + s2[1];
				Date gio = new Date(s2[0]);
				System.out.println(gio.toString() + " : " + command);
				dsCongViec.put(gio, command);
			}
			// Đóng luồng
			is.close();
			input.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return dsCongViec;
	}

	public static void main(String[] args) {
		read();
	}

}
