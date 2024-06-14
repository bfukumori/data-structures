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

    public static void main(String[] args) {
        // Criação de uma pilha com um valor inicial
        Stack stack = new Stack(1);

        // Imprimindo a pilha inicial
        System.out.println("Initial stack:");
        stack.print();
        stack.getTop();
        stack.getHeight();

        // Adicionando elementos à pilha
        System.out.println("\nPushing elements:");
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.print();
        stack.getTop();
        stack.getHeight();

        // Removendo o elemento do topo da pilha
        System.out.println("\nPopping an element:");
        Stack.Node poppedNode = stack.pop();
        System.out.println("Popped: " + (poppedNode != null ? poppedNode.value : "null"));
        stack.print();
        stack.getTop();
        stack.getHeight();

        // Removendo todos os elementos da pilha
        System.out.println("\nPopping all elements:");
        while (stack.pop() != null) {
            poppedNode = stack.pop();
            System.out.println("Popped: " + (poppedNode != null ? poppedNode.value : "null"));
        }
        stack.print();
        stack.getTop();
        stack.getHeight();
    }
}


