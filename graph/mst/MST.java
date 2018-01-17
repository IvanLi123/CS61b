package Graph;
/*
 * Minimum Spanning Tree
 * Prim+Kruskal
 */
public class MST {
public Edge []candidates;
public int number;
public MST(int N, int G[][]){
	candidates=new Edge[N];
	number=N;
	for(int i=0;i<N;i++){
		candidates[i]=new Edge();
		candidates[i].vex=0;
		candidates[i].cost=G[0][i];
	}
}
public int find_smallest(){
	int min=Integer.MAX_VALUE;
	int index = 0;
	for(int i=1;i<number;i++){
		if(candidates[i].cost!=0&&candidates[i].cost<min){
			min=candidates[i].cost;
			index=i;
		}
	}
	return index;
}
/*
 * Prim算法求最小生成树，以连通为主
 */
public void Prim(int G[][]){
	 candidates[0].vex=0;
	 candidates[0].cost=0;
	 System.out.print("Prime 算法最小生成树： "+candidates[0].vex);
	 for(int i=1;i<number;i++){
		 int index=find_smallest();
		 System.out.print(index);
		 for(int j=1;j<number;j++){
			 if(G[index][j]<candidates[j].cost){
				 candidates[j].cost=G[index][j];
				 candidates[j].vex=index;
			 }
		 }
	 }
}

public static void main(String []args){
	int inf=10000;
	int G[][]={{0,6,1,5,inf,inf},{6,0,5,inf,3,inf},{1,5,0,5,6,4},{5,inf,5,0,inf,2},{inf,3,6,inf,9,6},{inf,inf,4,2,6,0}};
	MST m=new MST(6,G);
	m.Prim(G);
}
}
