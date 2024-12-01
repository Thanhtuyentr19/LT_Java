import javax.swing.*;
import java.util.Arrays;

public class Bai3 {
    public static void main(String[] args) {
        int n = Integer.parseInt(JOptionPane.showInputDialog("Nhập số phần tử của mảng:"));
        
        int[] array = new int[n];
        
		// Nhập phần tử cho mảng
		for (int i = 0; i < n; i++) {
			array[i] = Integer.parseInt(JOptionPane.showInputDialog("Nhập phần tử thứ " + (i + 1) + ":"));
		}

		// b. Tính tổng các số dương lẻ trong mảng
		int sumOddPositive = Arrays.stream(array).filter(x -> x > 0 && x % 2 != 0).sum();
		System.out.println("Tổng các số dương lẻ trong mảng: " + sumOddPositive);

		// c. Nhập phần tử k và kiểm tra sự xuất hiện
		int k = Integer.parseInt(JOptionPane.showInputDialog("Nhập phần tử k để kiểm tra:"));
		int indexK = -1;

		for (int i = 0; i < n; i++) {
			if (array[i] == k) {
				indexK = i;
				break;
			}
		}
		
		if (indexK != -1) {
			System.out.println("Phần tử k xuất hiện tại vị trí: " + indexK);
		} else {
			System.out.println("Phần tử k không có trong mảng.");
		}

		// d. Sắp xếp mảng theo thứ tự tăng dần
		Arrays.sort(array);
		System.out.println("Mảng sau khi sắp xếp: " + Arrays.toString(array));

		// e. Chèn phần tử p vào mảng sao cho vẫn tăng dần
		int p = Integer.parseInt(JOptionPane.showInputDialog("Nhập phần tử p để chèn vào mảng:"));
		
		array = insertInSortedOrder(array, p);
		
		System.out.println("Mảng sau khi chèn phần tử p: " + Arrays.toString(array));
    }

	private static int[] insertInSortedOrder(int[] arr, int p) {
	    int[] newArr = new int[arr.length + 1];
	    int i;

	    for (i = 0; i < arr.length && arr[i] < p; i++) {
	        newArr[i] = arr[i];
	    }
	    newArr[i] = p;

	    for (; i < arr.length; i++) {
	        newArr[i + 1] = arr[i];
	    }

	    return newArr;
	}
}