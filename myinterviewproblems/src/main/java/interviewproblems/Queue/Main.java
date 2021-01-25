package interviewproblems.Queue;

public class Main {
    public static void main(String[] args) {
        LinkedListQueue q = new LinkedListQueue();
        q.enqueue(1);
        q.enqueue(4);
        q.enqueue(2);
        System.out.println(q);
        System.out.println(q.max());
        q.dequeue();
        System.out.println(q);
        System.out.println(q.max());

        System.out.println();
        System.out.println();

        ArrayQueue q2 = new ArrayQueue();
        q2.enqueue(1);
        q2.enqueue(2);
        q2.enqueue(3);
        q2.enqueue(4);
        q2.enqueue(5);
        System.out.println(q2);
        q2.dequeue();
        System.out.println(q2);
        q2.enqueue(6);
        q2.enqueue(7);
        q2.enqueue(8);
        q2.enqueue(9);
        q2.enqueue(10);
        q2.enqueue(11);
        System.out.println(q2);
        System.out.println();
        System.out.println();

        int[] arr = {2,3,5,6,2,1};
        System.out.println(QueueProblems.slidingWindow(arr, 3));

        Stock[] arr2 = {new Stock(1, 2), new Stock(4, 4),
                new Stock(3, 7), new Stock(2, 9), new Stock(5, 11)};
        System.out.println(QueueProblems.maxStock(arr2, 4));

    }
}
