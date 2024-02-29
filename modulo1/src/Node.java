class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedList {
    private Node head;
    private int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    public void push(Node node) {
        if (head == null) {
            head = node;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
        size++;
    }

    public Node pop() {
        if (head == null) {
            return null;
        } else if (head.next == null) {
            Node temp = head;
            head = null;
            size--;
            return temp;
        } else {
            Node current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            Node temp = current.next;
            current.next = null;
            size--;
            return temp;
        }
    }

    public void insert(int index, Node node) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (index == 0) {
            node.next = head;
            head = node;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            node.next = current.next;
            current.next = node;
        }
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (index == 0) {
            head = head.next;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }

    public Node elementAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public int size() {
        return size;
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.push(new Node(1));
        list.push(new Node(2));
        list.push(new Node(3));
        list.push(new Node(4));

        System.out.println("Original List:");
        list.printList(); // Output: 1 2 3 4

        list.pop();
        System.out.println("List after pop:");
        list.printList(); // Output: 1 2 3

        list.insert(1, new Node(5));
        System.out.println("List after insert:");
        list.printList(); // Output: 1 5 2 3

        list.remove(2);
        System.out.println("List after remove:");
        list.printList(); // Output: 1 5 3

        System.out.println("Element at index 1: " + list.elementAt(1).data); // Output: Element at index 1: 5
        System.out.println("Size of list: " + list.size()); // Output: Size of list: 3
    }
}
