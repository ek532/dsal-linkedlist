import java.util.Scanner;
public class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return head == null; // true is list is empty
    }

    /**
     * Adds a new node to the lined list
     * @param data - the String we are adding
     */
    public void add(String data) {
        Node node = new Node(data);// Make a new node object
        if (isEmpty()) { // if the list is empty this is the first item
            head = node;
            tail = node;
        } else { // otherwise add it to the tail
            tail.setNext(node); // What was the tail is now pointing to the new item
            tail = node; // the new item is now the tail
        }
    }

    public void print() {
        Node next = head;
        while (next != null) {
            System.out.println(next.getData());
            next = next.getNext();
        }
    }

    public String search(String item) {
        Node next = head;
        String itemFound = "";
        while (next != null) {
            if (next.getData().equals(item)) {
                itemFound = item;
            }
            next = next.getNext();
        }
        return itemFound;
    }
    public void addAtHead(String data) {
    Node node = new Node(data);

    if (isEmpty()) {
        head = node;
        tail = node;
    } else {
        node.setNext(head);
        head = node;
    }
    size++;
}
public boolean replace(String oldItem, String newItem) {
    Node current = head;

    while (current != null) {
        if (current.getData().equals(oldItem)) {
            current.setData(newItem);
            return true;
        }
        current = current.getNext();
    }
    return false;
}
public boolean delete(int index) {

    if (index < 0 || index >= size)
        return false;

    if (index == 0) {
        head = head.getNext();
        if (head == null)
            tail = null;
        size--;
        return true;
    }

    Node current = head;
    for (int i = 0; i < index - 1; i++) {
        current = current.getNext();
    }

    current.setNext(current.getNext().getNext());

    if (index == size - 1)
        tail = current;

    size--;
    return true;
}
public boolean remove(String item) {

    if (isEmpty())
        return false;

    if (head.getData().equals(item)) {
        head = head.getNext();
        if (head == null)
            tail = null;
        size--;
        return true;
    }

    Node current = head;

    while (current.getNext() != null) {
        if (current.getNext().getData().equals(item)) {
            current.setNext(current.getNext().getNext());

            if (current.getNext() == null)
                tail = current;

            size--;
            return true;
        }
        current = current.getNext();
    }
    return false;
}


public void menu() {

    Scanner sc = new Scanner(System.in);
    boolean running = true;

    while (running) {

        System.out.println("\n1 Add");
        System.out.println("2 Remove");
        System.out.println("3 Search");
        System.out.println("4 Print");
        System.out.println("5 Replace");
        System.out.println("6 Delete by index");
        System.out.println("7 Add at head");
        System.out.println("0 Exit");

        int choice = sc.nextInt();
        sc.nextLine();

        if (choice == 1) {
            System.out.print("Item: ");
            add(sc.nextLine());
        } 
        else if (choice == 2) {
            System.out.print("Item: ");
            System.out.println(remove(sc.nextLine()));
        } 
        else if (choice == 3) {
            System.out.print("Item: ");
            System.out.println(search(sc.nextLine()));
        } 
        else if (choice == 4) {
            print();
        } 
        else if (choice == 5) {
            System.out.print("Old: ");
            String oldItem = sc.nextLine();
            System.out.print("New: ");
            String newItem = sc.nextLine();
            System.out.println(replace(oldItem, newItem));
        } 
        else if (choice == 6) {
            System.out.print("Index: ");
            System.out.println(delete(sc.nextInt()));
        } 
        else if (choice == 7) {
            System.out.print("Item: ");
            addAtHead(sc.nextLine());
        } 
        else if (choice == 0) {
            running = false;
        }
    }
}


    /**
     * For your in class exercise explore completing the following methods for a Singly Linked list supported by
     * your tutor.
     *     // remove
     *     // replace
     *     // delete
     *     // add at head
     *     // menu
     * If you complete all of these save the code, copy  and refactor the entire project as a doubly linked list.
     */

}
