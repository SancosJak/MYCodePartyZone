package practice;

import java.util.Stack;

public class TeacherCode54 {
    public static void main(String[] args) {
        Stack <Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(7);

        System.out.println(stack);
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());
        System.out.println(stack.contains(7));
        System.out.println(stack.contains(70));
        System.out.println(stack.search(7));
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack.peek());
        stack.clear();
        System.out.println(stack);
    }
}
