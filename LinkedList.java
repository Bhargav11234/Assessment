import java.util.Scanner;

// sec 2 DFS Detect Cycle
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {

    // Function to reverse linked list in groups of size k
    public static Node reverseInGroups(Node head, int k) {
        if (head == null || k <= 1) {
            return head;  // No need to reverse
        }

        Node current = head;
        Node prevTail = null;
        Node newHead = null;

        // Traverse the list in chunks of k
        while (current != null) {
            int count = 0;
            Node groupHead = current;
            Node prev = null;
            Node next = null;

            // Reverse k nodes
            while (current != null && count < k) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
                count++;
            }

            // Set new head for the first group
            if (newHead == null) {
                newHead = prev;
            }

            // Connect last node of previous group to first of current reversed
            if (prevTail != null) {
                prevTail.next = prev;
            }

            // Move prevTail to the end of this group
            prevTail = groupHead;
        }

        return newHead;
    }

    // Print linked list
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create linked list: 10 -> 20 -> ... -> 80
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);
        head.next.next.next.next.next = new Node(60);
        head.next.next.next.next.next.next = new Node(70);
        head.next.next.next.next.next.next.next = new Node(80);

        System.out.print("Enter value of k: ");
        int k = sc.nextInt();

        System.out.println("\nOriginal Linked List:");
        printList(head);

        Node newHead = reverseInGroups(head, k);

        System.out.println("\nLinked List after reversing in groups of " + k + ":");
        printList(newHead);
    }
}
