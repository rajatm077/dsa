package misc;
public class PermCheck {
    public static void main(String[] args) {
        int[] arr = { 1, 4, 2, 3, 1 };
        System.out.println(isPerm(arr));

    }

    private static int isPerm(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            if (val < 0) val = -val;
            int index = val - 1;
            if (index >= arr.length) return 0;
            if (arr[index] < 0) return 0;
            arr[index] = -arr[index];
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) return 0;
        }
        return 1;
    }
}