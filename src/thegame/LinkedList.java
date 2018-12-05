package thegame;

public class LinkedList
{

    LinkedListNode head;
    LinkedListNode tail;
    int data;

    LinkedList()
    {
        this.head = null;
        this.tail = null;
    }

    void print()
    {
        LinkedListNode current = this.head;
        int i = 1;
        while (current != null)
        {
            System.out.println("- " + current.data);
            current = current.next;
            i++;
        }
        if (this.head == null)
        {
            System.out.println("Kosong");
        }
        else
        {
            System.out.println();
        }
        System.out.println("");
    }

    public int size()
    {
        int r = 0;
        LinkedListNode current = this.head;
        while (current != null)
        {
            current = current.next;
            r++;
        }
        return r;
    }

    void push(LinkedListNode new_node){
        if (this.head == null && this.tail == null) {
            head = new_node;
            tail = new_node;
        } else {
            tail.next = new_node;
            new_node.prev = tail;
            tail = new_node;
        }
    }

    
    LinkedListNode qpop()
    {
        LinkedListNode taken = null;
        if (this.head == null && this.tail == null) {
            taken = null;
        } else if (this.head == this.tail) {
            taken = head;
            head = null;
            tail = null;
        } else {
            taken = head;
            head = head.next;
        }
        return taken;
    }
}
