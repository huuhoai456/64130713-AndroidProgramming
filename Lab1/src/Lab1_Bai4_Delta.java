/**
 * 
 */
import java.util.Scanner;
/**
 * 
 */
public class Lab1_Bai4_Delta {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Tạo đối tượng Scanner để đọc dữ liệu từ bàn phím
        Scanner scanner = new Scanner(System.in);
        
        // Nhập hệ số a, b, c
        System.out.print("Nhập hệ số a: ");
        double a = scanner.nextDouble();
        
        System.out.print("Nhập hệ số b: ");
        double b = scanner.nextDouble();
        
        System.out.print("Nhập hệ số c: ");
        double c = scanner.nextDouble();
        
        // Tính delta
        double delta = Math.pow(b, 2) - 4 * a * c;
        
        // Xuất delta
        System.out.printf("Delta = %.2f\n", delta);
        
        // Tính và xuất căn delta
        if (delta >= 0) {
            double CanDelta = Math.sqrt(delta);
            System.out.printf("Căn delta = %.2f\n", CanDelta);
        } else {
            System.out.println("Delta âm, Phương trình vô nghiệm.");
        }
        
        scanner.close();
	}

}
