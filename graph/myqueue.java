package heap;

public class myqueue {
public int front;
public int rear;
public int size;
public int[]array=new int[10];
public myqueue(){
	front=0;
	rear=0;
	size=10;
	for(int i=0;i<array.length;i++){
		array[i]=0;
	}
}
public boolean isEmpty(){
	return front==rear;
}
public boolean isFull(){
	return (rear+1)%size==front;
}
public void push(int i){
	if(isFull()){
		System.out.println(" Queue is full!");
		System.exit(0);
	}
	else{
		array[rear]=i;
		rear=(rear+1)%size;
	}
}
public int pop(){
	if(isEmpty()){
		System.out.println("Queue is empty!");
		System.exit(0);
	}
	else{
		int r=array[front];
		front=(front+1)%size;
		return r;
	}
	return -1;
}
}
