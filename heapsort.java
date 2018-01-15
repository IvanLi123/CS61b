package heap;

public class heapsort {
//小顶堆
public void sift_heap(int a[],int id,int num){
	int idx=id*2;
	//int tmp=a[id];
	while(idx<=num){
		if((idx<num)&&a[idx+1]<a[idx]) //找两个子节点中较小者
			idx=idx+1;
		if(a[id]>a[idx]){
			int tmp=a[id];
			a[id]=a[idx];
			a[idx]=tmp;
			id=idx;
			idx=2*id;
		}
		else
			break;         //已符合递归定义
	}
	return;
}
//大顶堆
public void sift_heap_big(int a[],int id,int num){
	int idx=id*2;
	
	while(idx<=num){
		if(idx<num&&a[idx+1]>a[idx])
			idx=idx+1;
		if(a[id]<a[idx]){
			int tmp=a[id];
			a[id]=a[idx];
			a[idx]=tmp;
			id=idx;
			idx=2*id;
		}
		else
			break;
	}
	return;
}
public  void heap_sort(int a[]){
	for(int i=a.length-1;i>=1;i--){
		int tmp=a[1];
		a[1]=a[i];
		a[i]=tmp;
		sift_heap(a,1,i-1);
	}
}
public  void heap_sort_big(int a[]){
	for(int i=a.length-1;i>=1;i--){
		int tmp=a[1];
		a[1]=a[i];
		a[i]=tmp;
		sift_heap_big(a,1,i-1);
	}
}
public static void main(String[] args){
	heapsort hp=new heapsort();
	int index[]={2,45,645,6767,747,35,-3,0,1};
	
	int num=index.length-1;
	for(int i=(int)(num/2);i>=1;i--){
			hp.sift_heap_big(index, i, num);	
	}
	hp.heap_sort_big(index);
	for(int i=1;i<index.length;i++)
		System.out.println(index[i]);
}

}

