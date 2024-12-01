
import java.util.Arrays;

import javax.swing.JOptionPane;

public class Bai4 {

    public static void main(String[] args) {
        int rows = Integer.parseInt(JOptionPane.showInputDialog("Nhập số dòng của ma trận:"));
        int cols = Integer.parseInt(JOptionPane.showInputDialog("Nhập số cột của ma trận:"));
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Integer.parseInt(JOptionPane.showInputDialog("Nhập phần tử [" + i + "][" + j + "]:"));
            }
        }

        // b. Tính tích các số bội 3 trên dòng đầu tiên
        int productOfMultiplesOfThree = Arrays.stream(matrix[0]).filter(x -> x % 3 == 0).reduce(1, (a, b) -> a * b);
        System.out.println("Tích các số bội 3 trên dòng đầu tiên: " + productOfMultiplesOfThree);

        // c. Tạo ra mảng một chiều X[i] là các giá trị lớn nhất trên dòng thứ i của ma trận a.
        int[] maxInRows = new int[rows];
        for (int i = 0; i < rows; i++) {
            maxInRows[i] = Arrays.stream(matrix[i]).max().orElse(Integer.MIN_VALUE);
        }

        System.out.println("Mảng chứa giá trị lớn nhất trên mỗi dòng: " + Arrays.toString(maxInRows));

        // d. Xoá đi phần tử đầu tiên của mảng X[i]
        if (maxInRows.length > 0) {
            maxInRows[0] = -1; // hoặc một giá trị nào đó để đánh dấu đã xoá.
            System.out.println("Mảng sau khi xoá phần tử đầu tiên: " + Arrays.toString(maxInRows));
        }
    }
}
