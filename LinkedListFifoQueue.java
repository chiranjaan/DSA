/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsa;

/**
 *
 * @author DELL
 */
public class LinkedListFifoQueue {

    class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    Node front = null;
    Node rear = null;

   
    public void enqueue(int data) {

        Node newNode = new Node(data);

        if (rear == null) {
            front = rear = newNode;
            return;
        }

        rear.next = newNode;
        rear = newNode;
    }


    public int dequeue() {

        if (front == null) {
            System.out.println("Queue Empty");
            return -1;
        }

        int value = front.data;
        front = front.next;

        if (front == null)
            rear = null;

        return value;
    }

    public int peek() {

        if (front == null)
            return -1;

        return front.data;
    }

   
    public void display() {

        Node temp = front;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        LinkedListFifoQueue queue = new LinkedListFifoQueue();

        queue.enqueue(100);
        queue.enqueue(200);
        queue.enqueue(300);

        System.out.println("Queue:");

        queue.display();

        System.out.println("Dequeued = " + queue.dequeue());

        queue.display();

        System.out.println("Front = " + queue.peek());
    }
}
