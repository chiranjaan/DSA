/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsa;

/**
 *
 * @author DELL
 */
public class UnboundedArrayStack {
        private int[] stack;
    private int top;

    public UnboundedArrayStack() {
        stack = new int[2];
        top = -1;
    }

    public void push(int value) {

        if (top == stack.length - 1) {

            int[] newStack = new int[stack.length * 2];

            for (int i = 0; i < stack.length; i++) {
                newStack[i] = stack[i];
            }

            stack = newStack;
        }

        stack[++top] = value;
    }

    public int pop() {

        if (top == -1) {
            System.out.println("Stack Empty");
            return -1;
        }

        int value = stack[top--];

        if (top + 1 <= stack.length / 4 && stack.length > 2) {

            int[] newStack = new int[stack.length / 2];

            for (int i = 0; i <= top; i++) {
                newStack[i] = stack[i];
            }

            stack = newStack;
        }

        return value;
    }

    public static void main(String[] args) {

        UnboundedArrayStack s = new UnboundedArrayStack();

        s.push(10);
        s.push(20);
        s.push(30);
        s.push(40);

        System.out.println(s.pop());
    }
    
}
