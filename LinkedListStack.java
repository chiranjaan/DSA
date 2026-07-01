/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsa;

/**
 *
 * @author DELL
 */
public class LinkedListStack {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node top = null;

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = top;
        top = newNode;
    }

    public int pop() {

        if (top == null) {
            System.out.println("Stack Empty");
            return -1;
        }

        int value = top.data;
        top = top.next;

        return value;
    }

    public int peek() {

        if (top == null)
            return -1;

        return top.data;
    }

    public void display() {

        Node temp = top;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        LinkedListStack stack = new LinkedListStack();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Stack:");

        stack.display();

        System.out.println("Pop = " + stack.pop());

        stack.display();

        System.out.println("Peek = " + stack.peek());
    }
}
