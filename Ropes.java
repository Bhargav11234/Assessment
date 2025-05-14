import java.util.*;

//sec 5 Find the Diameter of a Binary Tree 
public class Ropes {
    public static int minCost(int[] arr) {
        int totalCost = 0;
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int rope : arr) {
            minHeap.add(rope);
        }
        while (minHeap.size() > 1) {
            int first = minHeap.poll();
            int second = minHeap.poll();
            int cost = first + second;
            totalCost += cost;
            minHeap.add(cost);
        }
        return totalCost;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
         System.out.print("Enter the Size of  Array : ");
        int n = sc.nextInt();
        int ropes[] = new int[n];
        System.out.print("Enter the Array : ");
        for(int i =0; i<ropes.length ;i++){
            ropes[i] = sc.nextInt();
        }
        System.out.println(minCost(ropes));
    }
}