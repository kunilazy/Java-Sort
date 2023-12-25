package cautruc;

import java.util.Scanner;


public class SortMenu {
	
	private static void clearScreen() {
        for (int i = 0; i < 50; ++i) System.out.println();  // In 50 dòng trắng
    }
	
    public static void main(String[] args) {
        Sort s = new Sort();
        Scanner scanner = new Scanner(System.in);
        int choice;
        int n;
        System.out.print("Nhập số lượng phần tử của mảng: ");
        n = scanner.nextInt();
        int[] array = new int[n];

        do {
        	clearScreen();
            System.out.println("\n----------- Menu -----------");
            System.out.println("1. Nhập mảng từ bàn phím");
            System.out.println("2. Tạo mảng ngẫu nhiên");
            System.out.println("----------------------------");

            System.out.println("3. Insertion Sort");
            System.out.println("4. Selection Sort");
            System.out.println("5. Bubble Sort");
            System.out.println("6. Shaker Sort");
            System.out.println("7. Interchange Sort");
            System.out.println("8. Shell Sort");
            System.out.println("9. Heap Sort");
            System.out.println("10. Quick Sort");

            System.out.println("0. Thoát chương trình");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = scanner.nextInt();
            scanner.nextLine();	

            System.out.println();
            switch (choice) {
                case 1:
                    s.inputArray(array);
                    s.display(array);
                    break;
                case 2:
                    s.generateRandomArray(array);
                    s.display(array);
                    break;
                case 3:
                    
                    s.display(array);
                    s.InsertionSort(array, n);
                    break;
                case 4:
                	System.out.println("Array[0] là Mảng khi chưa sắp xếp\n");
                    s.display(array);
                    s.SelectionSort(array, n);
                    break;
                case 5:
                	System.out.println("Array[0] là Mảng khi chưa sắp xếp\n");
                    s.display(array);
                    s.BubbleSort(array, n);
                    break;
                case 6:
                	System.out.println("Array[0] là Mảng khi chưa sắp xếp\n");
                    s.display(array);
                    s.ShakerSort(array, n);
                    break;
                case 7:
                	System.out.println("Array[0] là Mảng khi chưa sắp xếp\n");
                    s.display(array);
                    s.InterchangeSort(array, n);
                    break;
                case 8:
                	System.out.println("Array[0] là Mảng khi chưa sắp xếp\n");
                    s.display(array);
                    s.ShellSort(array, n);
                    break;
                case 9:
                	System.out.println("Array[0] là Mảng khi chưa sắp xếp\n");
                    s.display(array);
                    s.HeapSort(array, n);
                    break;
                case 10:
                	System.out.println("Array[0] là Mảng khi chưa sắp xếp\n");
                    s.display(array);
                    s.QuickSort(array, 0, n - 1);
                    break;
                case 0:
                    System.out.println("Chương trình kết thúc.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
            System.out.print("\nNhấn Enter để tiếp tục...");
            scanner.nextLine();
            
        } while (choice != 0);
    }
}
