package List;

public class SListNode {
public int item;
public SListNode next;
public SListNode(int i, SListNode n){
	item=i;
	next=n;
}
public SListNode(int i){
	item=i;
	next=null;
}
}
