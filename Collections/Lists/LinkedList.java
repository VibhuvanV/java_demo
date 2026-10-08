package Collections.Lists;

class Node
{
    int data;
    Node next;
    public Node(int data) {
        this.data = data;
        next = null;
    }
}

class List {
    Node head;
    Node prev;

    public List() {
        head = null;
        prev = null;
    }

    public Node insertHead(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            return head;
        }

        newNode.next = head;
        head = newNode;
        return head;
    }


    public Node insert(int data) {
        Node newNode = new Node(data);
        if(head == null) {
            head = newNode;
            return head;
        }
        Node temp = head;
        while(temp.next != null) {
//            prev = temp;
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }

    public Node pop_front() {
        Node curr = head;
        if(head ==null) {
            return null;
        }
        head = head.next;
        curr.next = null;

        return head;
    }

    public Node pop_back() {
        Node curr = head;
        if(head == null) {
            return null;
        }
        while(curr.next != null) {
            prev = curr;
            curr = curr.next;
        }
        prev.next = null;
        return head;
    }

    public Node removeNode(int val) {
        if(head == null) {
            return null;
        }
        Node curr = head;
        if(head.data == val) {
            head = head.next;
            curr.next = null;
        }

        while(curr != null && curr.data != val) {
            prev = curr;
            curr = curr.next;
        }
        if(curr == null) {
            return head;
        }

        prev.next = curr.next;
        curr.next = null;

        return head;
    }

    public boolean searchNode(int val) {
        Node curr = head;
        if(head == null) return false;
        while(curr != null ) {
            if(curr.data == val) {
                return true;
            }
            curr = curr.next;
        }

        return false;
    }

    public void display() {
        Node curr = head;
        while(curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.print("\n");
    }

}

public class LinkedList{
    public static void main(String[] args) {
        List list = new List();

        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);
        list.display();
        list.insertHead(6);
        list.insertHead(7);
        list.display();
        list.pop_front();
        list.display();
        list.pop_back();
        list.display();
        list.removeNode(2);
        list.display();
        System.out.println(list.searchNode(3));

    }
}
