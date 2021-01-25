package interviewproblems.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.append(new Node(1));
        ll.append(new Node(2));
        ll.append(new Node(3));
        ll.append(new Node(4));
        ll.append(new Node(5));
        ll.append(new Node(6));
        System.out.println(ll);
        if (LinkedListProblems.getNthNode(ll.head, 3) != null) {
            System.out.println(LinkedListProblems.getNthNode(ll.head, 3).data);
        }

        LinkedList temp = new LinkedList();
        temp.append(new Node(1));
        temp.append(new Node(0));
        temp.append(new Node(2));
        temp.append(new Node(1));
        temp.append(new Node(2));
        temp.append(new Node(1));
        System.out.println(temp);
        System.out.println(LinkedListProblems.simpleSortLinkedList(temp.head));

        LinkedList temp2 = new LinkedList();
        temp2.append(new Node(1));
        temp2.append(new Node(2));
        temp2.append(new Node(3));
        temp2.append(new Node(4));
        temp2.append(new Node(5));
        temp2.append(new Node(6));
        LinkedList[] output = LinkedListProblems.oddEvenLinkedList(temp2.head);
        System.out.println(output[0]);
        System.out.println(output[1]);

        LinkedList temp3 = new LinkedList();
        temp3.append(new Node(8));
        temp3.append(new Node(9));
        temp3.append(new Node(10));
        temp3.append(new Node(11));
        Node n = new Node(12);
        temp3.append(n);
        //System.out.println(temp3);
        n.next = temp3.head;
        //System.out.println(temp3);
        //temp3.delete(n);
        //System.out.println(temp3);
        System.out.println(LinkedListProblems.hasCycle(temp3));
        System.out.println(LinkedListProblems.lengthCycle(temp3));
        //System.out.println(LinkedListProblems.medianNode(temp3).data);
        //System.out.println(LinkedListProblems.thirdToLastElement(temp3).data);
        System.out.println(LinkedListProblems.startOfCycle(temp3).data);


        LinkedList temp4 = new LinkedList();
        temp4.append(new Node(1));
        temp4.append(new Node(2));
        temp4.append(new Node(3));
        temp4.append(new Node(4));
        temp4.append(new Node(5));
        System.out.println(temp4);
        LinkedListProblems.reverseLinkedList(temp4);
        System.out.println(temp4);
        System.out.println(LinkedListProblems.isPalindrome(temp4));
        System.out.println(LinkedListProblems.isPalindromePart2(temp4));

    }
}
