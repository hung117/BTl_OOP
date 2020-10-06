import java.util.Scanner;

public class SinglyListListNode {
    int data;
    SinglyListListNode next;

    public SinglyListListNode(int data) {
        this.next = null;
        this.data = data;
    }
    Scanner sc = new Scanner(System.in);
    public SinglyListListNode insertNodetAtTail(int data, SinglyListListNode head) {
        SinglyListListNode p = head;
        p.data = data;
        if (head == null) head = p;
        else {
            while (p.next != null) {
                p = p.next;
            } p.next = p;

        }

        return head;
    }

}

