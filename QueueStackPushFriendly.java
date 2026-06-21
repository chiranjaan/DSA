/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsa;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author DELL
 */
public class QueueStackPushFriendly {
    Queue<Integer>q1=new LinkedList<>();
    Queue<Integer>q2=new LinkedList<>();
    
    public void push(int data){
        q1.add(data);
    }
    public int pop(){
        if(q1.isEmpty()){
            System.out.println("Empty stack");
            return -1;
            
        }
        
        while (q1.size() > 1) {
            q2.add(q1.remove());
        }
        
        int popped = q1.remove();

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return popped;
    }
    public static void main(String[] args) {
        QueueStackPushFriendly pu =new QueueStackPushFriendly();
        pu.push(10);
        pu.push(20);
        pu.push(30);
        System.out.println(pu.pop());
    }
    
    
}
