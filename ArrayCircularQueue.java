/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsa;

/**
 *
 * @author DELL
 */
public class ArrayCircularQueue {
    
    private int[] arr;
    private int front, rear, size, capacity;

    public ArrayCircularQueue(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    public void enqueue(int data) {
        if (size == capacity) {
            throw new RuntimeException("full");
        }
        rear = (rear + 1) % capacity;
        arr[rear] = data;
        size++;
    }

    public int dequeue() {
        if (size == 0) {
            throw new RuntimeException("empty");
        }
        int item = arr[front];
        front = (front + 1) % capacity;
        size--;
        return item;
    }

    public static void main(String[] args) {
        ArrayCircularQueue q = new ArrayCircularQueue(3);
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        System.out.println(q.dequeue()); 
        q.enqueue(4);
        System.out.println(q.dequeue()); 
    }
}
    

