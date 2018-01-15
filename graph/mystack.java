package heap;

public class mystack {
public int size;
public int top;
public int []array;
public mystack(){
	size=10;
	top=0;
	array=new int[10];
}
public boolean isEmpty(){
	return top==0;
}
public boolean isFull(){
	return top==size;
}
public void push(int i){
	if(isFull()){
		System.out.println("stack is full");
		System.exit(0);
	}
		else{
	array[top]=i;
	top=top+1;
	}
}
public int pop(){
	if(isEmpty()){
		System.out.println("stack is empty");
		System.exit(0);
	}else{
		top=top-1;
		return array[top];
	}
	return 0;
}
}
