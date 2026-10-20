package BinarySearch;

public class BinarySearch {
    static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right ) {
            int middle = left + (right - left) / 2;
            if (arr[middle] == target) {
                return middle;
            }
            if (arr[middle] > target) {
                right = middle - 1;
            } 
            if (arr[middle] < target) {
                left = middle + 1;
            }
        }
        return -1;
    }

    static void check(int expected, int[] arr, int target) {
        int result = binarySearch(arr, target);
        if (result == expected) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed: expected " + expected + ", got " + result);
        }
    }

    public static void main(String[] args) {
        check(2, new int[]{1, 2, 3, 4, 5}, 3);
        check(-1, new int[]{1, 2, 3, 4, 5}, 6);
    }
}
