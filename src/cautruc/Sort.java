package cautruc;

import java.util.Random;
import java.util.Scanner;

public class Sort {

    static int count = 0;

    private static void Swap(int i, int j, int A[]) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public static void inputArray(int A[]) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the array elements: ");
        for (int i = 0; i < A.length; i++) {
            A[i] = scanner.nextInt();
        }
        count = -1;
    }

    public static void generateRandomArray(int A[]) {
        Random random = new Random();
        for (int i = 0; i < A.length; i++) {
            A[i] = random.nextInt(100) + 1;
        }
        count = -1;
    }

    public static void InsertionSort(int A[], int n) {
        int x, pos;
        for (int i = 1; i < n; ++i) {
            x = A[i];
            pos = i - 1; //vị trí  chèn
            while (pos >= 0 && A[pos] > x) {
                A[pos + 1] = A[pos];
                pos = pos - 1;
            }
            A[pos + 1] = x;

            // In ra mảng sau mỗi lần duyệt
            display(A);
        }
        count = 0;
    }

    public static void SelectionSort(int A[], int n) {
        int i, j, vtmin, temp;
        for (i = 0; i < n - 1; i++) {
            vtmin = i;
            for (j = i + 1; j < n; j++) {
                if (A[j] < A[vtmin])
                    vtmin = j;
            }
            /* Swap(i, vtmin, A) */
            temp = A[i];
            A[i] = A[vtmin];
            A[vtmin] = temp;

            // In ra mảng sau mỗi lần duyệt
            display(A);
        }
        count = 0;
    }

    public static void BubbleSort(int A[], int n) {
        int i, j, temp;
        for (i = 0; i < n - 1; i++) {
            for (j = n - 1; j > i; j--)
                if (A[j] < A[j - 1]) {
                    Swap(j, j - 1, A);
                }
            // In ra mảng sau mỗi lần duyệt
            display(A);
        }
    }

    public static void ShakerSort(int A[], int n) {
        int i, k, left, right;
        k = 0;
        left = 0;
        right = n - 1;
        while (left < right) {
            for (i = right; i > left; i--)
                if (A[i] < A[i - 1]) {
                    Swap(i, i - 1, A);
                    k = i; // biến k dùng đánh dấu để bỏ qua đoạn đã có thứ tự
                }
            left = k;
            for (i = left; i < right; i++)
                if (A[i] > A[i + 1]) {
                    Swap(i, i + 1, A);
                    k = i;
                }
            right = k;

            // In ra mảng sau mỗi lần duyệt
            display(A);
        }
        count = 0;
    }

    public static void InterchangeSort(int A[], int n) {
        int temp;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++)
                if (A[j] < A[i]) {
                    temp = A[j];
                    A[j] = A[i];
                    A[i] = temp;
                }

            // In ra mảng sau mỗi lần duyệt
            display(A);
        }
        count = 0;
    }

    public static void ShellSort(int A[], int n) {
        for (int h = n / 2; h > 0; h /= 2) //bắt đầu với h lớn và giảm dần
        {
            for (int i = h; i < n; i += 1) {
                int temp = A[i];
                int j;
                for (j = i; j >= h && A[j - h] > temp; j -= h)
                    A[j] = A[j - h];
                A[j] = temp;
            }

            // In ra mảng sau mỗi lần duyệt
            display(A);
        }
        count = 0;
    }

    public static void Heapify(int A[], int n, int vt) {
        while (vt <= n / 2 - 1) {
            int child1 = 2 * vt + 1;
            int child2 = 2 * vt + 2;
            int childmax = child1;
            if (child2 < n && A[child2] > A[childmax])
                childmax = child2;
            if (A[vt] < A[childmax])
                Swap(vt, childmax, A);
            vt = childmax;
            System.out.println("\nHeapify");
        }
    }

    public static void BuildHeap(int A[], int n) {
        for (int i = n / 2 - 1; i >= 0; i--)
            Heapify(A, n, i);
    }

    public static void HeapSort(int A[], int n) {
        BuildHeap(A, n);
        for (int i = n - 1; i >= 0; i--) {
            Swap(0, i, A);
            Heapify(A, i, 0);

            // In ra mảng sau mỗi lần duyệt
            display(A);
        }
        count = 0;
    }

    public static void QuickSort(int A[], int left, int right) {
        int i = left, j = right;
        int temp;
        int pivot = A[(left + right) / 2]; // Phần tử pivot là phần tử giữa
        while (i <= j) {
            while (A[i] < pivot)
                i++;
            while (A[j] > pivot)
                j--;
            if (i <= j) {
                /** hoán vị 2 phần tử **/
                temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                i++;
                j--;
                
                // Hiển thị mảng và thông tin
                System.out.println("Pivot: " + pivot + ", Left: " + left + ", Right: " + right + "\t");
                display(A);
                System.out.println();
                
            }
        }
        
        if (left < j)
            QuickSort(A, left, j);
        if (i < right)
            QuickSort(A, i, right);
    }
    // Hàm in ra mảng
    public static void display(int A[]) {
        System.out.print("Array[" + count + "] : ");
        for (int i = 0; i < A.length; i++) {
            System.out.print(A[i] + " ");
        }
        count++;
        System.out.println();
    }

}