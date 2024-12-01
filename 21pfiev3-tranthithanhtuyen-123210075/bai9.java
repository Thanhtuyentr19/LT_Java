import java.util.Scanner;

public class bai9 {
    int n;
    
    public void nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap n = ");
        n = scanner.nextInt();
        scanner.close();

    }
    
    public int giaithua(int m) {
        if (m == 0) {
            return 1;
        } else {
            return m * giaithua(m - 1);
        }
    }
    
    public void tinh() {
        float s = 15.0f;
        float p = 0.0f;
        
        for (int i = 1; i <= n; i++) {
            p = 1.0f / giaithua(i);
            p *= Math.pow(-1, i);
            s += p;
        }
        
        System.out.println("S = " + s);
    }
    
    public static void main(String[] args) {
        bai9 b = new bai9();
        b.nhap();
        b.tinh();

    }
}