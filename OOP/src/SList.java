import jdk.jshell.Snippet;

public class SList {
    SNode head; // new pointer for class SNode

    // Constructor

    // Function
    // MISC
    public SNode findTail() {
        if (head == null) return null;  // if List is empty
        SNode p = head;
        while (p.next != null) p = p.next;
        return p;
    }

    public void print() {
        SNode p = head;
        System.out.print("[");
        while (p != null) {
            System.out.print(p.data + " ");
            p = p.next; // to next node;
        }
        System.out.print("]" + "\n");
    }

    // Add FIRST
    public SNode addFirst(String data) {
        // new Node
        SNode newNode = new SNode(data, null);
        newNode.data = data;
        // new SNode.next points to the old one
        newNode.next = head;
        // Redirect head
        head = newNode;
        return head;
    }

    public SNode Shorter_addFirst(String data) {
        // new Node
        SNode newNode = new SNode(data, head);
        // Redirect head
        head = newNode;
        return head;
    }

    public SNode minsert(SNode head, String data, int position){
        SNode newNode = new SNode(data,null);
        int cur_pos = 0;
        SNode p = head;
        while(p.next != null){
            if(cur_pos +1 == position ){
                break;
            }
            cur_pos++;
            p = p.next;
        }
        p.next = newNode;
        newNode.next = p.next.next;

        return head;
    }
    public void reversePrint(SNode head){
        SNode pos = head;
        String arr[];
        arr = new String[100];
        int ipos=0;
        while(pos.next != null){
            pos = pos.next;
            arr[ipos] = pos.data;
            ipos++;
        }
        for(int i = ipos; i >= 0; i--){
            System.out.println(arr[i]);
        }
    }
    // Add LAST
    // without tail
    public SNode addLast(String data) {
        if (head == null) {
            addFirst(data);
        }
        // create new Node
        SNode newNode = new SNode(data, null);
        // find last node (tail)
        SNode tail = findTail();
        tail.next = newNode;
        // connect last to new one
        return tail;
    }

    // Remove()
    public void remove(SNode n) {
        // find node u before n;
        SNode prev = head;
        if (prev != n) {
            while (prev.next != n) prev = prev.next;
            // connect u to v (with v is the node behind n)
            prev.next = n.next; // = n.next.next;
        } else {
            head = head.next;
        }
    }

}
