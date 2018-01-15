package heap;
import List.*;
public class graph_traverse {
public SList[] graph;
int []visit=new int[9];//��־���� ����ڵ��Ƿ���ʹ�
mystack stack;
myqueue queue;
public graph_traverse(){
	stack=new mystack();
	queue=new myqueue();
	for(int i=0;i<visit.length;i++)
		visit[i]=0;
	graph=new SList[9];
	for(int i=0;i<graph.length;i++)
		graph[i]=new SList();
	graph[1].insertfront(3);
	graph[1].insertfront(2);
	
	graph[2].insertfront(5);
	graph[2].insertfront(4);
	graph[2].insertfront(1);
	
	graph[3].insertfront(7);
	graph[3].insertfront(6);
	graph[3].insertfront(1);
	
	graph[4].insertfront(8);
	graph[4].insertfront(2);
	
	graph[5].insertfront(8);
	graph[5].insertfront(2);
	
	graph[6].insertfront(7);
	graph[6].insertfront(3);
	
	graph[7].insertfront(6);
	graph[7].insertfront(3);
	
	graph[8].insertfront(5);
	graph[8].insertfront(4);
}
/*
 * ͼ������������� dfs
 * depth-first-search
 */
public void dfs(int v){
	visit[v]=1;
	System.out.print(v+" ");
	SListNode n=graph[v].head;
	while(n != null){
		if(visit[n.item]==0)
			dfs(n.item);
		n=n.next;
	}
}
/*
 * ������� ��ջ����
 */
public void dfs2(int v){
	visit[v]=1;
	System.out.print(v+" ");
	stack.push(v);
	SListNode n=graph[v].head;
	while(!stack.isEmpty()){
	while(n!=null){
		if(visit[n.item]==0){
			dfs2(n.item);
		}
		n=n.next;
	}
	stack.pop();
	return;
	}
	
}
/*
 * ���ڲ�����ͨͼ��˵����visit[i]==0 ��Ӵ˿�ʼ����ͼ
 * ѭ������ͼ ֱ�����нڵ㶼�����ʹ�
 */
public void search_modifyed(){
	for(int i=1;i<visit.length;i++){
		if(visit[i]==0)
			dfs(i);
	}
}
/*
 * bfs bread-first-search
 * ͼ��������ȱ��� �ö���ʵ��
 */
public void bfs(int v){
	visit[v]=1;
	queue.push(v);
	while(!queue.isEmpty()){
		int tmp=queue.pop();
		System.out.print(tmp+" ");
		SListNode n=graph[tmp].head;
		while(n!=null){
			if(visit[n.item]==0){
				visit[n.item]=1; //���ʸ���
				queue.push(n.item);
			}
			n=n.next;
		}
	}
}
public static void main(String []args){
	graph_traverse DFS=new graph_traverse();
	System.out.println("ͼ����ȱ���:");
	DFS.dfs(1);
	//DFS.dfs2(1);
	//System.out.println("\n"+"stack ջ��λ�ã� "+DFS.stack.top);
	graph_traverse DFS2=new graph_traverse();
	System.out.println("ͼ�Ĺ�ȱ���:");
	DFS2.bfs(1);
}
}
