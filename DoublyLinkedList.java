/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsa;

/**
 *
 * @author DELL
 */
class DNode {
    int data;
    DNode prev, next;
    DNode(int data) { this.data = data; }
}

public class DoublyLinkedList {
    private DNode head;

    public void insert(int data) {
        DNode newNode = new DNode(data);
        if (head == null) {
            head = newNode;
            return;
        }
        DNode temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = newNode;
        newNode.prev = temp;
    }

    public void displayForward() {
        DNode temp = head;
        while (temp != null) {
            System.out.print(temp.data + " | ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void displayBackward() {
        DNode temp = head;
        while (temp.next != null) temp = temp.next;
        while (temp != null) {
            System.out.print(temp.data + " | ");
            temp = temp.prev;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.insert(5);
        list.insert(15);
        list.insert(25);
        list.displayForward();   
        list.displayBackward();  
    }
}
