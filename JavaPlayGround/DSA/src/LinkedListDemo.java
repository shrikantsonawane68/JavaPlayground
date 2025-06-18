class Node {
  private String data;
  private Node next;

  public Node(String data) {
    this.data = data;
  }

  public void setData(String data) {
    this.data = data;
  }

  public void setNext(Node node) {
    this.next = node;
  }

  public String getData() {
    return this.data;
  }

  public Node getNext() {
    return this.next;
  }
}

class LinkedList {

  private Node head;
  private Node tail;

  public Node getHead() {
    return this.head;
  }

  public Node getTail() {
    return this.tail;
  }

  public void addAtEnd(String data) {
    // Create a new node
    Node node = new Node(data);

    // Check if the list is empty,
    // if yes, make the node as the head and the tail
    if (this.head == null) this.head = this.tail = node;
    else {
      // If the list is not empty, add the element at the end
      this.tail.setNext(node);
      // Make the new node as the tail
      this.tail = node;
    }
  }

  public void addAtBeginning(String data) {
    // Implement your code here
    // Create a new node
    Node node = new Node(data);

    // Check if the list is empty,
    // if yes, make the node as the head and the tail
    if (this.head == null) this.head = this.tail = node;
    else {
      node.setNext(this.getHead());
      this.head = node;
    }
  }

  public void display() {
    // Initialize temp to the head node
    Node temp = this.head;
    // Traverse the list and print data of each node
    while (temp != null) {
      System.out.println(temp.getData());
      temp = temp.getNext();
    }
  }

  public Node find(String data) {
    Node temp = this.head;
    // Traverse the list and return the node
    // if the data of it matches with the searched data
    while (temp != null) {
      if (temp.getData().equals(data)) return temp;
      temp = temp.getNext();
    }
    return null;
  }

  public void delete(String data) {
    // Check if the list is empty,
    if (this.head == null) System.out.println("List is empty");
    else {
      // Find the node to be deleted
      Node node = this.find(data);
      // If the node is not found
      if (node == null) System.out.println("Node not found");
      // If the node to be deleted is the head node
      else if (node == this.head) {
        this.head = this.head.getNext();
        node.setNext(null);
        // If the node to be deleted is also the tail node
        if (node == this.tail) tail = null;
      } else {
        // Traverse to the node present before the node to be deleted
        Node nodeBefore = null;
        Node temp = this.head;
        while (temp != null) {
          if (temp.getNext() == node) {
            nodeBefore = temp;
            break;
          }
          temp = temp.getNext();
        }
        // Remove the node
        nodeBefore.setNext(node.getNext());
        // If the node to be deleted is the tail node,
        // then make the previous node as the tail
        if (node == this.tail) this.tail = nodeBefore;
        node.setNext(null);
      }
    }
  }
}

class Tester {
  public static void main(String args[]) {
    LinkedList list = new LinkedList();
    list.addAtEnd("Milan");
    list.addAtEnd("Venice");
    list.addAtEnd("Munich");
    list.addAtEnd("Vienna");
    System.out.println("Linked List After Adding element at end : ");
    list.display();
    list.addAtBeginning("Nice");
    System.out.println("Linked List After Adding Nice at beginning : ");
    list.display();
    System.out.println("Find Munich in Linked List...");
    if (list.find("Munich") != null) System.out.println("Munich found in linked list");
    else System.out.println("Munich not found in linked list");
    // System.out.println("Adding an element to the linked list");
    System.out.println("Delete Venice from Linked List...");
    list.delete("Venice");
    System.out.println("Linked List After Deleting Venice : ");
    list.display();
  }
}
