import java.util.PriorityQueue;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
// sec 2 Merge Multiple Sorted Linked Lists

public class MergeSortedLists {

    public static Node mergeKLists(Node[] lists) {

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.data - b.data);
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                pq.add(lists[i]);
            }
        }

        Node dummy = new Node(0);
        Node current = dummy;

        // While heap is not empty take out small element
        while (!pq.isEmpty()) {
            Node smallest = pq.poll();
            current.next = smallest;
            current = current.next;

            // If the picked node has a next node, add it to the heap
            if (smallest.next != null) {
                pq.add(smallest.next);
            }
        }

        return dummy.next;
    }

    public static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data + " --> ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        Node[] lists = new Node[3];

        // List 1: 1 -> 3 -> 5
        lists[0] = new Node(1);
        lists[0].next = new Node(3);
        lists[0].next.next = new Node(5);

        // List 2: 2 -> 4 -> 6
        lists[1] = new Node(2);
        lists[1].next = new Node(4);
        lists[1].next.next = new Node(6);
        Node mergedHead = mergeKLists(lists);
        System.out.println("Merged Sorted Linked List:");
        printList(mergedHead);
    }
}
