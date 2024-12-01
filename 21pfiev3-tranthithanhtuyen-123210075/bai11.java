import java.util.Scanner;
public class bai11 {
  int n;
  public void nhap() {
    Scanner input = new Scanner(System.in);
    System.out.print("Nhap n= ");
    n = input.nextInt();
    input.close();

  }
  public void tinh() {
    float gt = 1;
    for (int i = n; i >= 1; i -= 2) gt *= i; 
    System.out.println(n + "! != " + gt);
  }
  public static void main(String[] args) {
    bai11 dt = new bai11();
    dt.nhap();
    dt.tinh();
  }
}