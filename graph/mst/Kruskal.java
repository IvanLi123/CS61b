package Graph;

public class Kruskal {
public KVex[]node;
public KEdge[]edge;
public Kruskal(){
	node=new KVex[6];
	edge=new KEdge[10];
	for(int i=0;i<node.length;i++){
		node[i]=new KVex();
		node[i].vex=i;
		node[i].gno=i;
	}
	for(int j=0;j<10;j++){
		edge[j]=new KEdge();
		edge[j].flag=0;
	}
	edge[0].head=1;
	edge[0].tail=2;
	edge[0].weight=6;
	edge[1].head=1;
	edge[1].tail=3;
	edge[1].weight=1;
	edge[2].head=1;
	edge[2].tail=4;
	edge[2].weight=5;
	edge[3].head=2;
	edge[3].tail=3;
	edge[3].weight=5;
	edge[4].head=2;
	edge[4].tail=5;
	edge[4].weight=3;
	edge[5].head=3;
	edge[5].tail=4;
	edge[5].weight=5;
	edge[6].head=3;
	edge[6].tail=5;
	edge[6].weight=6;
	edge[7].head=3;
	edge[7].tail=6;
	edge[7].weight=4;
	edge[8].head=4;
	edge[8].tail=6;
	edge[8].weight=2;
	edge[9].head=5;
	edge[9].tail=6;
	edge[9].weight=6;
	for(int k=0;k<edge.length;k++){
		edge[k].head-=1;
		edge[k].tail-=1;
	}
}
public void mst(){
	
	int count=1;
	System.out.println("连接顺序为：");
	while(count<node.length){
		int min=Integer.MAX_VALUE;
		int idx = 0;
		for(int i=0;i<edge.length;i++){
			if(edge[i].flag==0&&edge[i].weight<min){
				min=edge[i].weight;
				idx=i;
			}
		}
		if(node[edge[idx].head].gno!=node[edge[idx].tail].gno){
			count++;
			edge[idx].flag=1;
			System.out.println("头顶点："+edge[idx].head+"尾顶点："+edge[idx].tail);
			for(int j=0;j<node.length;j++){
				if(node[j].gno==node[edge[idx].tail].gno){
					node[j].gno=node[edge[idx].head].gno;
				}
			}
		}
		else
			edge[idx].flag=-1;
	}
}
public static void main(String[] args){
	Kruskal k=new Kruskal();
	k.mst();
}
}
