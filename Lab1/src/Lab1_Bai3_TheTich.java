/**
 * 
 */
import java.util.Scanner;
/**
 * 
 */
public class Lab1_Bai3_TheTich {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Tạo đối tượng Scanner để đọc dữ liệu từ bàn phím
        Scanner scanner = new Scanner(System.in);
        
        // Nhập cạnh của khối lập phương 
        System.out.print("Nhập cạnh: ");
        double canh = scanner.nextDouble();
        
        // Tính thể tích của khối chữ nhật
        double TheTich1 = canh * canh *canh;
        double TheTich2 = Math.pow(canh,3);
        
        // Xuất kết quả ra màn hình
        System.out.printf("Thể tích 1: %.2f\n", TheTich1);
        System.out.printf("Thể tích 2: %.2f\n", TheTich2);
        
        scanner.close();
	}

}
