package dataStructures;

import java.util.LinkedList;
import java.util.Queue;

public class Tree {
    public Node root;

    public static class Node {
        public int value;
        public Node left;
        public Node right;

        public Node(int value) {
            this.value = value;
        }

        public boolean isLeaf() {
            return left == null && right == null;
        }
    }

    public int countLeaves() {
        return countLeaves(root);
    }

    private int countLeaves(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.isLeaf()) {
            return 1;
        }
        return countLeaves(node.left) + countLeaves(node.right);
    }


    public void insert(int value) {
        Node newNode = new Node(value);

        if (root == null) {
            root = newNode;
        } else {
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);

            while (!queue.isEmpty()) {
                Node currentNode = queue.poll();

                if (currentNode.left == null) {
                    currentNode.left = newNode;
                    break;
                } else {
                    queue.add(currentNode.left);
                }

                if (currentNode.right == null) {
                    currentNode.right = newNode;
                    break;
                } else {
                    queue.add(currentNode.right);
                }
            }
        }
    }

    public void preOrder() {
        preOrder(root);
    }

    // Same as Depth-First Search (DFS)
    private void preOrder(final Node node) {
        if (node == null) return;
        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder() {
        inOrder(root);
    }
    private void inOrder(final Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.print(node.value + " ");
        inOrder(node.right);
    }

    public void postOrder() {
        postOrder(root);
    }
    private void postOrder(final Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }

    // Breadth-First Search
    public void BFS() {
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            System.out.print(currentNode.value + " ");
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
    }

    public static void main(String[] args) {
        Tree tree = new Tree();

        // Inserindo valores na árvore
        System.out.println("Inserting values into the tree:");
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(3);
        tree.insert(7);
        tree.insert(12);
        tree.insert(18);

        // Exibindo a árvore em diferentes ordens de travessia
        System.out.println("\nPre-order traversal:");
        tree.preOrder(); // Esperado: 10 5 3 7 15 12 18
        System.out.println();

        System.out.println("\nIn-order traversal:");
        tree.inOrder(); // Esperado: 3 5 7 10 12 15 18
        System.out.println();

        System.out.println("\nPost-order traversal:");
        tree.postOrder(); // Esperado: 3 7 5 12 18 15 10
        System.out.println();

        System.out.println("\nBreadth-first search (BFS):");
        tree.BFS(); // Esperado: 10 5 15 3 7 12 18
        System.out.println();

        // Contando o número de folhas na árvore
        System.out.println("\nNumber of leaves in the tree:");
        int numberOfLeaves = tree.countLeaves(); // Esperado: 4 (3, 7, 12, 18)
        System.out.println("Number of leaves: " + numberOfLeaves);
    }
}
