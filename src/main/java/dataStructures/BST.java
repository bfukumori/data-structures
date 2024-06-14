package dataStructures;

public class BST {
    private Node root;

    public static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }
    }

    public void insert(int value) {
        if (root == null) {
            root = new Node(value);
        } else {
            insert(root, value);
        }
    }

    private void insert(final Node root, final int value) {
        if (root == null) return;
        if (value == root.value) return;
        if (value < root.value) {
            if (root.left == null) root.left = new Node(value);
            else insert(root.left, value);

        } else {
            if (root.right == null)  root.right = new Node(value);
            else insert(root.right, value);
        }
    }

    public void inOrder() {
        inOrder(root);
    }

    private static void inOrder(final Node node) {
        if (node == null) return;
        inOrder(node.left);
        System.out.println(node.value);
        inOrder(node.right);
    }

    public boolean contains(final int value) {
        return contains(root, value);
    }

    private static boolean contains(final Node root, final int value) {
        if (root == null) return false;
        if (value == root.value) return true;
        if (value > root.value) return contains(root.right,value);
        else return contains(root.left, value);
    }

    private int minValue(Node currentNode) {
        while (currentNode.left != null) {
            currentNode=currentNode.left;
        }

        return currentNode.value;
    }

    public void deleteNode(final int value) {
         root = deleteNode(root,value);
    }

    private Node deleteNode(final Node root, final int value) {
        if (root == null) return null;

       if (value < root.value) {
           root.left = deleteNode(root.left, value);
       } else if (value > root.value) {
           root.right = deleteNode(root.right, value);
       } else {
           if (root.left == null && root.right == null) {
               return null;
           } else if (root.left == null) {
               return root.right;
           } else if (root.right == null) {
               return root.left;
           }
           root.value = minValue(root.right);
           root.right = deleteNode(root.right, root.value);
       }
        return root;
    }
}
