package business.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOFile {
	
	public static final String PATH_CATEGORY = "src/business/data/category.txt";
	public static final String PATH_PRODUCT = "src/business/data/product.txt";
	public static final String PATH_USER = "src/business/data/user.txt";
	public static final String PATH_USER_PRINCIPAL = "src/business/data/userPricipal.txt";


	public static <T> void writeObjectToFile(T t, String path) {
		FileOutputStream fos = null; // output là đầu ra nên cái FileOutputStream nó là ghi file (đại diện cho file nào dựa vào path)
		ObjectOutputStream oos = null; // đối tượng ObjectOutputStream dành việc ghi object vào file
		try {
			fos = new FileOutputStream(path);
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(t);
			
		} catch (IOException e) {

		} finally {
			try {
				if (fos != null) {
					fos.close();
				}
				if (oos != null) {
					oos.close();
				}
			} catch (Exception e) {

			}
			
		}
	}
	
	public static <T> T readObjectFromFile(String path) {
		FileInputStream fis = null; // Input là đầu vào nên nó sẽ là lấy dữ liệu vào chương trình (đại diện cho file thông đường dẫn path)
		ObjectInputStream ois = null; // ObjectInputStream nó là đối tượng dùng để làm việc đọc file
		T t = null ;
		try {
			fis = new FileInputStream(path);
			ois = new ObjectInputStream(fis);
			
			t = (T) ois.readObject();
			
		} catch (IOException | ClassNotFoundException e) {

		} finally {
			try {
				if (fis != null) {
					fis.close();
				}
				if (ois != null) {
					ois.close();
				}
			} catch (Exception e) {

			}
		}
		return t;
	}
}
