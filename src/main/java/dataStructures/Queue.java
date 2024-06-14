package dataStructures;

public class Queue {
    private Node first;
    private Node last;
    private int length;

    Queue(int value) {
        Node newNode = new Node(value);
        first = newNode;
        last = newNode;
        length = 1;
    }

    public static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public void enqueue(int value) {
        Node newNode = new Node(value);

        if (isEmpty()) {
            first = newNode;
            last = first;
        } else {
            last.next = newNode;
            last = newNode;
        }
        length++;
    }

    public Node dequeue() {
        if (isEmpty()) return null;
        Node temp = first;
        if (length == 1) {
            first = null;
            last =null;
        } else {
            first = first.next;
            temp.next = null;
        }
        length--;
        return temp;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void getLength() {
        System.out.println("Length: " + length);
    }

    public void getFirst() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("First: " + first.value);
        }
    }

    public void getLast() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("Last: " + last.value);
        }
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
        } else {
            Node temp = first;
            while (temp != null) {
                System.out.print(temp.value + " ");
                temp = temp.next;
            }
        }
    }
}
