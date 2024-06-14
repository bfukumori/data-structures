package dataStructures;

public class Stack {
   private Node top;
   private int height;

    Stack(int value) {
        top = new Node(value);
        height = 1;
    }

    public static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public void getTop() {
        if (top == null) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Top element is " + top.value);
        }
    }

    public void getHeight() {
        System.out.println("Height is " + height);
    }

    public void print() {
        System.out.println("#########################");
        Node temp = top;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
        System.out.println("#########################");
    }

    public void push(int value) {
       Node newNode = new Node(value);

        if (height != 0) {
            newNode.next = top;
        }

        top = newNode;
        height++;
    }

    public Node pop() {
        if (height==0) return null;

        Node temp = top;
        top = top.next;
        temp.next = null;
        height--;

        return temp;
    }
}


