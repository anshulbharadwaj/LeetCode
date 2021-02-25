package com.practice.concepts.ds.tree;

public class SimpleCustomBinaryTree {

    /**
     * A simple program to introduce binary tree
     * Binary Tree: A tree whose elements have at most 2 children is called a binary tree.
     * Since each element in a binary tree can have only 2 children,
     * we typically name them the left and right child.
     */

    static class Node {
        int key;
        Node left, right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    // Root of Binary Tree
    Node root;

    SimpleCustomBinaryTree(int key) {
        root = new Node(key);
    }

    SimpleCustomBinaryTree() {
        root = null;
    }

    public static void main(String[] args) {
        SimpleCustomBinaryTree tree = new SimpleCustomBinaryTree();

        /*create root*/
        tree.root = new Node(1);

        /* following is the tree after above statement

              1
            /   \
          null  null     */

        tree.root.left = new Node(2);
        tree.root.right = new Node(3);

        /* 2 and 3 become left and right children of 1
               1
            /     \
          2        3
        /   \     /  \
      null null null null  */


        tree.root.left.left = new Node(4);
        /* 4 becomes left child of 2
                    1
                /       \
               2          3
             /   \       /  \
            4    null  null  null
           /   \
          null null
         */
    }
}