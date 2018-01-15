package heap;
import List.*;
public class graph_traverse {
public SList[] graph;
int []visit=new int[9];//标志数组 代表节点是否访问过
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
 * 图的深度优先搜索 dfs
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
 * 深度优先 堆栈跟踪
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
 * 对于不是连通图来说，若visit[i]==0 则从此开始遍历图
 * 循环遍历图 直到所有节点都被访问过
 */
public void search_modifyed(){
	for(int i=1;i<visit.length;i++){
		if(visit[i]==0)
			dfs(i);
	}
}
/*
 * bfs bread-first-search
 * 图的深度优先遍历 用队列实现
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
				visit[n.item]=1; //访问更新
				queue.push(n.item);
			}
			n=n.next;
		}
	}
}
public static void main(String []args){
	graph_traverse DFS=new graph_traverse();
	System.out.println("图的深度遍历:");
	DFS.dfs(1);
	//DFS.dfs2(1);
	//System.out.println("\n"+"stack 栈顶位置： "+DFS.stack.top);
	graph_traverse DFS2=new graph_traverse();
	System.out.println("图的广度遍历:");
	DFS2.bfs(1);
}
}
