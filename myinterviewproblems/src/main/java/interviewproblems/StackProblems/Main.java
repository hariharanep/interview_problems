package interviewproblems.StackProblems;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println(s);
        System.out.println(StackProblems.existsInStack(3, s));
        System.out.println(s);

        Queue q = new Queue();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        System.out.println(q);
        q.dequeue();
        System.out.println(q);
        //q.enqueue(4);
        //System.out.println(q);
        //q.dequeue();
        System.out.println();

        TwoStacksWithArray p = new TwoStacksWithArray();
        p.pushStackOne(1);
        p.pushStackOne(2);
        p.pushStackOne(3);
        p.pushStackTwo(1);
        p.pushStackTwo(2);
        p.pushStackTwo(3);
        p.dequeueStackOne();
        p.dequeueStackTwo();
        System.out.println(p);
        System.out.println();

        StackWithMax a = new StackWithMax();
        a.push(1);
        a.push(2);
        a.push(3);
        a.push(4);
        a.push(5);
        a.pop();
        a.pop();
        System.out.println(a.values);
        System.out.println(a.max);
        System.out.println(a.max());
        System.out.println();

        System.out.println(StackProblems.inflixExpression("1+(8-6)/2"));

    }

}
