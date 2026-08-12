/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dsa;

/**
 *
 * @author DELL
 */
public class AVLTree {

    class Node {
        int data;
        int height;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.height = 1;
        }
    }

    Node root;

    // Get height
    int height(Node node) {

        if (node == null) {
            return 0;
        }

        return node.height;
    }

    // Get maximum
    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // Get balance factor
    int getBalance(Node node) {

        if (node == null) {
            return 0;
        }

        return height(node.left) - height(node.right);
    }

    // Right Rotation
    Node rightRotate(Node y) {

        Node x = y.left;
        Node temp = x.right;

        x.right = y;
        y.left = temp;

        y.height = 1 + max(height(y.left), height(y.right));
        x.height = 1 + max(height(x.left), height(x.right));

        return x;
    }

    // Left Rotation
    Node leftRotate(Node x) {

        Node y = x.right;
        Node temp = y.left;

        y.left = x;
        x.right = temp;

        x.height = 1 + max(height(x.left), height(x.right));
        y.height = 1 + max(height(y.left), height(y.right));

        return y;
    }

    // Insert
    Node insert(Node node, int data) {

        // Normal BST insertion
        if (node == null) {
            return new Node(data);
        }

        if (data < node.data) {
            node.left = insert(node.left, data);
        }
        else if (data > node.data) {
            node.right = insert(node.right, data);
        }
        else {
            return node;
        }

        // Update height
        node.height = 1 + max(
                height(node.left),
                height(node.right)
        );

        // Calculate balance factor
        int balance = getBalance(node);

        // LL Case
        if (balance > 1 && data < node.left.data) {
            return rightRotate(node);
        }

        // RR Case
        if (balance < -1 && data > node.right.data) {
            return leftRotate(node);
        }

        // LR Case
        if (balance > 1 && data > node.left.data) {

            node.left = leftRotate(node.left);

            return rightRotate(node);
        }

        // RL Case
        if (balance < -1 && data < node.right.data) {

            node.right = rightRotate(node.right);

            return leftRotate(node);
        }

        return node;
    }

    // Inorder traversal
    void inorder(Node root) {

        if (root != null) {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    public static void main(String[] args) {

        AVLTree tree = new AVLTree();

        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 25);
        tree.root = tree.insert(tree.root, 28);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 50);

        System.out.print("Inorder Traversal: ");
        tree.inorder(tree.root);
    }
}