import java.util.*;
class Subarray {
// Section 1 Find the longest subArray with a Given Sum

   public static int[] subarraySum(int[] arr, int target) {
        int n = arr.length;

        for (int start = 0; start < n; start++) {
            int sum = 0;

            for (int end = start; end < n; end++) {
                sum += arr[end];

                // If sum equals target, return the 1-based positions
                if (sum == target) {
                    int[] result = new int[2];
                    result[0] = start + 1;
                    result[1] = end + 1;
                    return result;
                }
            }
        }

        // If no subarray found, return [-1]
        return new int[]{-1};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.err.print("Enter the size of Array :");
        int b = sc.nextInt();
        int arr[] = new int[b];
        System.err.print("Enter the Array :");
        for(int i=0 ; i <arr.length;i++)
        {
            arr[i] = sc.nextInt();
        }
          System.err.print("Enter the Target :");
        int target = sc.nextInt();
        int[] result = subarraySum(arr, target);

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
