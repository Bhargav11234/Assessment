import java.util.*;

// sec 6 Max Sum of Non-Adjacent Elements 
class Maxsum {
    static int maxSumRec(int[] arr, int n, int[] memo) {
        if (n <= 0) return 0;
        if (n == 1) return arr[0];

        int pick = arr[n - 1] + maxSumRec(arr, n - 2, memo);
        int notPick = maxSumRec(arr, n - 1, memo);
        return memo[n];
    }
    static int maxSum(int[] arr) {
        int n = arr.length;
    
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Size Of the Array : ");
        int n = sc.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the Array : ");
        for(int i=0 ; i <arr.length ; i++)
        {
            arr[i] = sc.nextInt();
        }
        // int[] arr = {6, 7, 1, 3, 8, 2, 4};
        System.out.println(maxSum(arr));
    }
}