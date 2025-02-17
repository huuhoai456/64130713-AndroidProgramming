/**
 * 
 */
import java.util.Scanner;
/**
 * 
 */
public class Lab1_Bai2_ChuviDT {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Tạo đối tượng Scanner để đọc dữ liệu từ bàn phím
        Scanner scanner = new Scanner(System.in);
        
        // Nhập chiều dài của hình chữ nhật
        System.out.print("Nhập chiều dài: ");
        double dai = scanner.nextDouble();
        
        // Nhập chiều rộng của hình chữ nhật
        System.out.print("Nhập chiều rộng: ");
        double rong = scanner.nextDouble();
        
        // Tính chu vi, diện tích và cạnh nhỏ nhất
        double ChuVi = (dai + rong) * 2;
        double DienTich = dai * rong;
        double CanhNhoNhat = Math.min(dai, rong);
        
        // Xuất kết quả ra màn hình
        System.out.printf("Chu vi: %.2f\n", ChuVi);
        System.out.printf("Diện tích: %.2f\n", DienTich);
        System.out.printf("Cạnh nhỏ nhất: %.2f\n", CanhNhoNhat);
        
        scanner.close();
	}

}
