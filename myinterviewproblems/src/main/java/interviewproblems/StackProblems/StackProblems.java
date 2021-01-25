package interviewproblems.StackProblems;

import java.util.Stack;

public class StackProblems {
    public static boolean existsInStack(int num, Stack<Integer> s) {
        if (s == null) {
            return false;
        }
        boolean found = false;
        Stack<Integer> temp = new Stack<Integer>();
        while (!s.empty()) {
            int elem = s.peek();
            if (elem == num) {
                found = true;
            }
            temp.push(s.pop());
        }
        while (!temp.empty()) {
            s.push(temp.pop());
        }
        return found;
    }

    public static int inflixExpression(String expression) {
        Stack<Integer> operands = new Stack<Integer>();
        Stack<Character> operators = new Stack<Character>();
        if (expression.length() == 0) {
            return 0;
        }
        for (int i = 0 ; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch >= '0' && ch <= '9') {
                operands.push((ch - '0'));
            }
            else {
                if (ch == '(') {
                    operators.push(ch);
                }
                else if (ch == ')') {
                    while (operators.peek() != '(') {
                        int num2 = operands.pop();
                        int num1 = operands.pop();
                        char op = operators.pop();
                        if (op == '+') {
                            int result = num1 + num2;
                            operands.push(result);
                        } else if (op == '-') {
                            int result = num1 - num2;
                            operands.push(result);
                        } else if (op == '*') {
                            int result = num1 * num2;
                            operands.push(result);
                        } else {
                            int result = num1 / num2;
                            operands.push(result);
                        }
                    }
                    operators.pop();
                }
                else {
                    while (operators.isEmpty() == false &&
                            precedence(operators.peek()) >= precedence(ch)) {
                        int num2 = operands.pop();
                        int num1 = operands.pop();
                        char op = operators.pop();
                        if (op == '+') {
                            int result = num1 + num2;
                            operands.push(result);
                        } else if (op == '-') {
                            int result = num1 - num2;
                            operands.push(result);
                        } else if (op == '*') {
                            int result = num1 * num2;
                            operands.push(result);
                        } else {
                            int result = num1 / num2;
                            operands.push(result);
                        }
                    }
                    operators.push(ch);
                }
            }
        }
        while (operators.isEmpty() == false) {
            int num2 = operands.pop();
            int num1 = operands.pop();
            char op = operators.pop();
            if (op == '+') {
                int result = num1 + num2;
                operands.push(result);
            }
            else if (op == '-') {
                int result = num1 - num2;
                operands.push(result);
            }
            else if (op == '*') {
                int result = num1*num2;
                operands.push(result);
            }
            else {
                int result = num1/num2;
                operands.push(result);
            }
        }
        return operands.pop();
    }

    public static int precedence(char a) {
        if (a == '*' || a == '/') {
            return 2;
        }
        if (a == '+' || a == '-') {
            return 1;
        }
        return -1;
    }
}

class StackWithMax {
    Stack<Integer> values;
    Stack<Integer> max;

    public StackWithMax() {
        values = new Stack<Integer>();
        max = new Stack<Integer>();
    }

    public void push(int num) {
        values.push(num);
        if (max.isEmpty() || num >= max.peek()) {
            max.push(num);
        }

    }

    public void pop() {
        if (values.isEmpty() && max.isEmpty()) {
            return;
        }
        if (values.peek() == max.peek()) {
            max.pop();
        }
        values.pop();
    }

    public int max() {
        if (max.isEmpty()) {
            return -1;
        }
        return max.peek();
    }
}

class TwoStacksWithArray {
    int[] arr;
    int stack_one_ptr;
    int stack_two_ptr;

    public TwoStacksWithArray() {
        arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = -100;
        }
        stack_one_ptr = 0;
        stack_two_ptr = arr.length - 1;
    }

    public void pushStackOne(int num) {
        if (stack_one_ptr <= stack_two_ptr && arr[stack_one_ptr] == -100) {
            arr[stack_one_ptr] = num;
            stack_one_ptr++;
        }
        else {
            System.out.println("Can't do that both stacks completely filled up the array");
        }
    }

    public void pushStackTwo(int num) {
        if (stack_two_ptr >= stack_one_ptr && arr[stack_two_ptr] == -100) {
            arr[stack_two_ptr] = num;
            stack_two_ptr--;
        }
        else {
            System.out.println("Can't do that both stacks completely filled up the array");
        }
    }

    public void dequeueStackOne() {
        if (stack_one_ptr - 1 >= 0) {
            arr[stack_one_ptr - 1] = -100;
            stack_one_ptr--;
        }
    }

    public void dequeueStackTwo() {
        if (stack_two_ptr + 1 <= arr.length - 1) {
            arr[stack_two_ptr + 1] = -100;
            stack_two_ptr++;
        }
    }

    public String toString() {
        String toReturn = "Stack One: ";
        int i = stack_one_ptr;
        while (i > 0) {
            toReturn = toReturn + arr[i - 1] + " ";
            i--;
        }
        toReturn = toReturn + "\nStack Two: ";
        i = stack_two_ptr;
        while (i < arr.length - 1) {
            toReturn = toReturn + arr[i + 1] + " ";
            i++;
        }
        return toReturn;
    }
}

class Queue {
    Stack<Integer> enqueueStack;
    Stack<Integer> dequeueStack;

    Queue() {
        enqueueStack = new Stack<Integer>();
        dequeueStack = new Stack<Integer>();
    }

    public void enqueue(int num) {
        enqueueStack.push(num);
    }

    public void dequeue() {
        if (dequeueStack.empty() && enqueueStack.empty()) {
            return;
        }
        else if (!dequeueStack.empty()) {
            dequeueStack.pop();
        }
        else {
            while (!enqueueStack.empty()) {
                dequeueStack.push(enqueueStack.pop());
            }
            dequeueStack.pop();
        }
    }

    public String toString() {
        String toReturn = "";
        Stack<Integer> temp = new Stack<Integer>();
        while (!enqueueStack.isEmpty()) {
            toReturn = toReturn + enqueueStack.peek() + " ";
            temp.push(enqueueStack.pop());
        }
        while (!temp.empty()) {
            enqueueStack.push(temp.pop());
        }

        while (!dequeueStack.isEmpty()) {
            temp.push(dequeueStack.pop());
        }
        while (!temp.empty()) {
            toReturn = toReturn + temp.peek() + " ";
            dequeueStack.push(temp.pop());
        }

        return toReturn;
    }
}
