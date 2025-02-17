/**
 * 
 */
import java.util.Scanner;
/**
 * 
 */
public class Lab1_Bai1_DTB {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Tạo đối tượng Scanner để đọc dữ liệu từ bàn phím
        Scanner scanner = new Scanner(System.in);
        
        // Nhập họ và tên
        System.out.print("Họ và tên: ");
        String hoTen = scanner.nextLine();
        
        // Nhập điểm trung bình
        System.out.print("Điểm TB: ");
        double diemTB = scanner.nextDouble();
        
        // Xuất thông tin ra màn hình
        System.out.printf("%s %f điểm", hoTen, diemTB);

        scanner.close();
	}

}
