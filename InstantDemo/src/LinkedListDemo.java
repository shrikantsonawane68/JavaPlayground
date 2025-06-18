class Node {
    int data;
    Node next;

    public Node(int data) {

        this.data = data;
        this.next = null;
    }
}

class LinkedListDemo {
    Node head;

    void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "" + " ---> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        LinkedListDemo linkedListDemo = new LinkedListDemo();

        //add the elements to linked list
        linkedListDemo.append(10);
        linkedListDemo.append(20);
        linkedListDemo.append(30);
        linkedListDemo.append(40);

        //display the list
        linkedListDemo.display();
    }
}

