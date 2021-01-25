package interviewproblems.LinkedList;


import java.util.HashMap;
import java.util.Stack;

public class LinkedListProblems {
    public static Node getNthNode(Node head, int n) {
        if (n <= 0 || head == null) {
            return null;
        }
        Node temp = head;
        for (int i = 0; i < n - 1; i++) {
            if (temp != null) {
                temp = temp.next;
            }
        }
        return temp;
    }

    /*
    You are given a Linked List with nodes that have values 0, 1 or 2.
    Sort the linked list.
     */
    public static LinkedList simpleSortLinkedList(Node head) {
        if (head == null) {
            return null;
        }
        LinkedList zeroLinkedList = new LinkedList();
        LinkedList oneLinkedList = new LinkedList();
        LinkedList twoLinkedList = new LinkedList();

        Node temp = head;
        while (temp != null) {
            if (temp.data == 0) {
                zeroLinkedList.append(new Node(temp.data));
            }
            else if (temp.data == 1) {
                oneLinkedList.append(new Node(temp.data));
            }
            else{
                twoLinkedList.append(new Node(temp.data));
            }
            temp = temp.next;
        }
        zeroLinkedList.tail.next = oneLinkedList.head;
        oneLinkedList.tail.next = twoLinkedList.head;

        LinkedList toReturn = new LinkedList();
        toReturn.head = zeroLinkedList.head;
        toReturn.tail = twoLinkedList.tail;
        return toReturn;
    }

    /*
    Given a Linked List L, separate it into 2 Linked Lists.
    One contains L's odd nodes and the other contains L's even nodes.
    Odd and Even here refer to the node's position, not value.
     */
    public static LinkedList[] oddEvenLinkedList(Node head) {
        if (head == null) {
            return null;
        }
        LinkedList[] toReturn = new LinkedList[2];

        LinkedList oddLinkedList = new LinkedList();
        LinkedList evenLinkedList = new LinkedList();

        Node temp = head;
        int count = 1;
        while (temp != null) {
            if (count % 2 == 1) {
                oddLinkedList.append(new Node(temp.data));
            }
            else {
                evenLinkedList.append(new Node (temp.data));
            }
            count++;
            temp = temp.next;
        }
        toReturn[0] = oddLinkedList;
        toReturn[1] = evenLinkedList;
        return toReturn;
    }

    /*
    Given a Linked List, find if it has a cycle.
     */
    public static boolean hasCycle(LinkedList a) {
        if (a == null) {
            return false;
        }
        Node slow_ptr = a.head;
        Node fast_ptr = a.head;
        while (fast_ptr != null) {
            //System.out.println(fast_ptr.data + " " + slow_ptr.data);
            if (fast_ptr != null) {
                fast_ptr = fast_ptr.next;
            }
            if (fast_ptr == slow_ptr) {
                return true;
            }
            if (fast_ptr != null) {
                fast_ptr = fast_ptr.next;
            }
            if (fast_ptr == slow_ptr) {
                return true;
            }
            if (slow_ptr != null) {
                slow_ptr = slow_ptr.next;
            }

        }
        return false;
    }

    public static int lengthCycle(LinkedList a) {
        int length = 0;
        if (hasCycle(a)) {
            Node slow_ptr = a.head;
            Node fast_ptr = a.head;
            while (fast_ptr != null) {
                if (fast_ptr != null) {
                    fast_ptr = fast_ptr.next;
                }
                if (fast_ptr == slow_ptr) {
                    break;
                }
                if (fast_ptr != null) {
                    fast_ptr = fast_ptr.next;
                }
                if (fast_ptr == slow_ptr) {
                    break;
                }
                if (slow_ptr != null) {
                    slow_ptr = slow_ptr.next;
                }
            }
            length = 1;
            fast_ptr = fast_ptr.next;
            while (fast_ptr != slow_ptr) {
                length += 1;
                fast_ptr = fast_ptr.next;
            }

        }
        return length;
    }

    public static Node medianNode(LinkedList a) {
        if (hasCycle(a) == false) {
            Node fast_ptr = a.head;
            Node slow_ptr = a.head;
            while (fast_ptr != null && fast_ptr.next != null) {
                if (fast_ptr != null) {
                    fast_ptr = fast_ptr.next;
                }
                if (fast_ptr != null) {
                    fast_ptr = fast_ptr.next;
                }
                if (slow_ptr != null) {
                    slow_ptr = slow_ptr.next;
                }
            }
            return slow_ptr;
        }
        return null;
    }

    public static Node thirdToLastElement(LinkedList a) {
        if (a == null || a.head == null || a.head.next == null || a.head.next.next == null) {
            return null;
        }
        Node first_ptr = a.head;
        Node second_ptr = a.head.next.next;
        while (second_ptr != a.tail) {
            second_ptr = second_ptr.next;
            first_ptr = first_ptr.next;
        }
        return first_ptr;
    }

    public static Node startOfCycle(LinkedList a) {
        if (hasCycle(a)) {
            int l = lengthCycle(a);
            Node start = a.head;
            Node end = a.head;
            for (int i = 0; i < l; i++) {
                end = end.next;
            }

            while (start != end) {
                start = start.next;
                end = end.next;
            }
            return start;
         }
        return null;
    }

    public static boolean isPalindrome(LinkedList a) {
        if (a == null || a.head == null || a.head == null) {
            return false;
        }
        LinkedList reverse = new LinkedList();
        Node temp = a.head;
        while (temp != null) {
            reverse.append(new Node(temp.data));
            temp = temp.next;
        }
        reverseLinkedList(reverse);
        //System.out.println(reverse);
        //System.out.println(a);
        Node reversePtr = reverse.head;
        Node regularPtr = a.head;
        while (reversePtr != null & regularPtr != null) {

            if (reversePtr.data != regularPtr.data) {
                return false;
            }
            reversePtr = reversePtr.next;
            regularPtr = regularPtr.next;
        }
        return true;
    }

    public static boolean isPalindromePart2(LinkedList b) {
        LinkedList a = new LinkedList();
        Node temp = b.head;
        while (temp != null) {
            a.append(new Node(temp.data));
            temp = temp.next;
        }

        Node prev = medianNode(a);
        Node curr = prev.next;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        Node last = prev;
        Node start = a.head;

        while (last != start) {
            if (last.data != start.data) {
                return false;
            }
            last = last.next;
            start = start.next;
        }
        return true;
    }

    public static void reverseLinkedList(LinkedList a) {
        if (a == null || a.head == null || a.tail == null) {
            return;
        }
        Node prev = null;
        Node curr = a.head;
        a.tail = curr;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        a.head = prev;
    }


}

class LinkedList {
    Node head;
    Node tail;

    LinkedList () {
        head = null;
        tail = null;
    }

    public void delete(Node n) {
        if (n == null) {
            return;
        }
        if (head == n) {
            head = n.next;
            return;
        }
        Node temp = head;
        while (temp != null) {
            if (temp.next == n) {
                //System.out.println("Here");
                break;
            }
            temp = temp.next;
        }
        if (tail == n) {
            tail = temp;
            tail.next = null;
            return;
        }
        if (temp != null) {
            temp.next = n.next;
            return;
        }
    }

    public void append(Node n) {
        if (head == null) {
            head = n;
        }
        else {
            tail.next = n;
        }
        tail = n;
    }

    public String toString() {
        String toReturn = "";
        Node temp = head;
        while (temp != null) {

            toReturn = toReturn + temp.data + " ";
            temp = temp.next;
        }
        return toReturn;
    }
}

class Node {
    int data;
    Node next;

    // Constructor to create a new node
    // Next is by default initialized
    // as null
    Node(int d) { data = d; }
}
