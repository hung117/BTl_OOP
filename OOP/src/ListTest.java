
public class ListTest {
    public static void main(String[] args){
        SList list = new SList();   // new pointer for SList
//        System.out.print("Tail: "+ list.findTail().data + "\n");

        SNode a = new SNode("A", null);
        list.head = a;
        list.print();
        a.next = new SNode("B", null);  // create B & link to a at the same time
        list.print();
        SNode c = list.addFirst("C");
        list.print();
        list.Shorter_addFirst("D");
        list.print();
//        System.out.print("Tail: "+ list.findTail().data + "\n");
        SNode e = list.addLast("E");
        list.print();
        list.remove(c);
        list.print();
        list.remove(e);
        list.print();
    }
}
