package interviewproblems.Queue;

import java.util.Stack;

public class QueueProblems {
    /*
    You are given stock prices and the corresponding day of each stock price in an array.
    You should be able to tell the maximum stock price in the last timeframe days.
     */
    public static int maxStock(Stock[] arr, int timeframe) {
        if (arr.length < 2) {
            if (arr.length == 1) {
                return arr[0].stock;
            }
            else {
                return -1;
            }
        }
        Stack<Stock> daysInTimeFrame = new Stack<>();
        daysInTimeFrame.push(arr[0]);
        daysInTimeFrame.push(arr[1]);
        for (int i = 2; i < arr.length; i++) {
            daysInTimeFrame.push(arr[i]);
            int maxDay = maxDay(daysInTimeFrame);
            for (int j = 0; j < daysInTimeFrame.size(); j++) {
                if (maxDay - daysInTimeFrame.get(j).day > timeframe) {
                    daysInTimeFrame.remove(j);
                }
            }
        }
        int maxStock = maxOfStock(daysInTimeFrame);
        return maxStock;
    }

    public static int maxOfStock(Stack<Stock> a) {
        int max = a.get(0).stock;
        for (int i = 1; i < a.size(); i++) {
            if (a.get(i).stock > max) {
                max = a.get(i).stock;
            }
        }
        return max;
    }



    public static int maxDay(Stack<Stock> a) {
        int max = a.get(0).day;
        for (int i = 1; i < a.size(); i++) {
            if (a.get(i).day > max) {
                max = a.get(i).day;
            }
        }
        return max;
    }

    /*
    Given an array of integers A, find the sum of sliding windows of size n.
     */
    public static Stack<Integer> slidingWindow(int[] arr, int n) {
        Stack<Integer> sums = new Stack<>();
        if (n < 1) {
           return sums;
        }
        int sum = 0;
        int start = 0;
        int end = start + n - 1;
        for (int i = start; i <= end; i++) {
            sum += arr[i];
        }
        sums.push(sum);

        for (int i = end + 1; i < arr.length; i++) {
            sum = sum - arr[start];
            start++;
            sum = sum + arr[i];
            sums.push(sum);
        }

        return sums;
    }
}

class Stock {
    int stock;
    int day;
    public Stock(int s, int d) {
        stock = s;
        day = d;
    }
}

class ArrayQueue {
    int[] arr;
    int back;
    int front;
    int length;

    public ArrayQueue() {
        arr = new int[10];
        back = 0;
        //back of the queue
        front = 0;
        //where you will add next element
    }

    public void enqueue(int n) {
        if (length == arr.length) {
            System.out.println("Can't do this, array is full");
        }
        else {
            arr[front] = n;
            front = (front + 1) % arr.length;
            length++;
        }
    }

    public void dequeue() {
        if (length == 0) {
            System.out.println("Can't do this, array is empty");
        }
        else {
            arr[back] = 0;
            back = (back + 1) % arr.length;
            length--;
        }
    }

    public String toString() {
        String toReturn = "";
        if (front == back && length == 0) {
            return toReturn;
        }

        int j = back;
        int i = front - 1;
        while (i != j) {
            toReturn += arr[i] + " ";
            i = i - 1;
            if (i < 0) {
                i = arr.length + i;
            }
        }
        toReturn += arr[i] + " ";
        return toReturn;
    }
}

class LinkedListQueue {
    LinkedList q;
    LinkedList maxQueue;
    public LinkedListQueue() {
        q = new LinkedList();
        maxQueue = new LinkedList();
    }

    public void enqueue(int a) {
        if (maxQueue.head == null) {
            maxQueue.append(new Node(a));
        }
        else {
            while (maxQueue.head != null && maxQueue.head.data < a) {
                maxQueue.delete(maxQueue.head);
            }
            maxQueue.append(new Node(a));
        }

        Node n = new Node(a);
        q.append(n);
    }

    public void dequeue() {
        if (q.tail.data == maxQueue.tail.data) {
            maxQueue.delete(maxQueue.tail);
        }
        q.delete(q.tail);
    }

    public int max() {
        if (maxQueue.head != null) {
            return maxQueue.tail.data;
        }
        else {
            return -1;
        }

    }

    public String toString() {
        return q.toString();
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
            tail = n;
        }
        else {
            n.next = head;
            head = n;

        }
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
