package List;

public class SList {
public SListNode head;
public SListNode tail;
public int size;
public SList(){
	head=tail=null;
	size=0;
}
public void insertfront(int o){
	head=new SListNode(o,head);
	if(size==0)
		tail=head;
	size++;
}
public void insertback(int o){
	SListNode t=new SListNode(o);
	tail.next=t;
	tail=t;
	size++;
}
public boolean isEmpty(){
	return(size==0);
}
public void removefront(){
	if(isEmpty()){
		return;
	}else{
		if(size==1){
			head=tail=null;
			size=0;
			return;
		}else{
			head=head.next;
			size--;
		}
	}
}
public void remoreback(){
	if(isEmpty()){
		return;
	}else{
		if(size==1){
			head=tail=null;
			size=0;
		}else{
			SListNode tmp=head;
			while(tmp.next!=tail)
				tmp=tmp.next;
			tail=tmp;
			size--;
		}
	}
}

}
