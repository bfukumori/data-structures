package dataStructures;

public class LinkedList {
    private Node head;
    private Node tail;
    private int length;

    public LinkedList(String data) {
        this.length = 1;
        Node newNode = new Node(data);
        this.head = newNode;
        this.tail = newNode;
    }


    public static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
        }
    }

    public void getHead() {
        if (this.head == null) {
            System.out.println("Empty list");
        } else {
            System.out.println("Head: " + this.head.data);
        }
    }

    public void getTail() {
        if (this.tail == null) {
            System.out.println("Empty list");
        } else {
            System.out.println("Tail: " + this.tail.data);
        }
    }

    public void getLength() {
        System.out.println("Length: " + this.length);
    }

    public void makeEmpty() {
        this.head = this.tail = null;
        this.length = 0;
    }

    public void print() {
        Node temp = this.head;

        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public void append(String data) {
        Node newNode = new Node(data);

        if (this.length == 0) {
            this.head = newNode;
        } else {
            this.tail.next = newNode;
        }
        this.tail = newNode;
        this.length++;
    }

    public Node removeLast() {
        if (this.length==0) return null;
        Node pre = this.head;
        Node temp = null;

        while (pre.next != this.tail) {
            pre = pre.next;
        }

        temp = this.tail;
        this.tail = pre;
        this.tail.next = null;
        this.length--;

        if (length==0) {
            this.head = this.tail = null;
        }

        return temp;
    }

    public void prepend(String data) {
        Node newNode = new Node(data);

        if (this.length == 0) {
            this.head = this.tail= newNode;
        } else {
            newNode.next = this.head;
            this.head = newNode;

        }
        this.length++;
    }

    public Node removeFirst() {
        if (this.length==0) return null;
        Node temp = this.head;
        this.head = this.head.next;
        temp.next = null;
        this.length--;

        if (this.length==0) {
            this.head = this.tail = null;
        }

        return temp;
    }

    public Node get(int index) {
        if (index <0 || index >= this.length) return null;
        Node temp = this.head;

        for(int i = 0; i<index; i++) {
            temp = temp.next;
        }

        return temp;
    }

    public boolean set(int index,String data) {
        Node temp = get(index);
        if(temp!=null) {
            temp.data=data;
            return true;
        }
        return false;
    }

    public boolean insert(int index, String data) {
        if (index <0 || index > this.length) return false;

        if(index==0) {
            prepend(data);
            return true;
        }

        if (index==this.length) {
            append(data);
            return true;
        }

        Node newNode = new Node(data);
        Node prev = this.get(index - 1);
        newNode.next = prev.next;
        prev.next=newNode;
        this.length++;

        return true;

    }

    public Node remove(int index) {
        if (index <0 || index >= this.length) return null;

        if(index==0) return this.removeFirst();

        if (index == this.length - 1) return this.removeLast();

        Node prev = this.get(index - 1);
        Node temp = prev.next;
        prev.next = temp.next;
        temp.next = null;

        this.length--;

        return temp;
    }
}
