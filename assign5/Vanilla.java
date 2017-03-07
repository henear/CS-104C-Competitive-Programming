import java.util.*;
public class Vanilla {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String a = sc.nextLine();
		String[] data = a.split(" ");
		int n = Integer.parseInt(data[0]);
		int m = Integer.parseInt(data[1]);
		Node[][] street = new Node[n][m];
		String lr = sc.nextLine();
		String ud = sc.nextLine();
		for(int i = 0; i< n; i++){		
			for(int j = 0; j < m; j++){
				street[i][j] = 
						new Node(i, j, lr.charAt(i), ud.charAt(j), false);
			}
		}


		boolean b = true;
		for(int i = 0; i < n&&b; i++){
			for(int j = 0; j < m&&b; j++){
				if(!comp(i, j, street)){
					b = false;

				}
			}
		}
		if(b){
			System.out.println("YES");
		}else{
			System.out.println("NO");
		}
		sc.close();
	}

	public static boolean comp(int i, int j, Node[][] street){
		boolean result = true;

		Stack<Node> toVisit = new Stack<>();

		toVisit.push(street[i][j]);
		for(int it = 0; it < street.length; it++){
			for(int ti = 0; ti < street[0].length; ti++){
				street[it][ti].setVisited(false);
			}
		}
		while(!toVisit.isEmpty()){
			Node curr = toVisit.pop();
			int curri = curr.geti();
			int currj = curr.getj();
			if(street[curri][currj].getVisited()){
				continue;
			}
			street[curri][currj].setVisited(true);
			char lr = street[curri][currj].lr;
			char ud = street[curri][currj].ud;

			if(lr=='<'&&currj!=0){
				toVisit.push(street[curri][currj-1]);
			}
			if(lr=='>'&&currj!=street[0].length-1){
				toVisit.push(street[curri][currj+1]);
			}

			if(ud=='^'&&curri!=0){
				toVisit.push(street[curri-1][currj]);
			}
			if(ud=='v'&&curri!=street.length-1){
				toVisit.push(street[curri+1][currj]);
			}
		}
		for(int ii = 0; ii < street.length; ii++){
			for(int tt = 0; tt < street[0].length; tt++){
				result = result && street[ii][tt].getVisited();
			}
		}
		return result;
	}

	public static class Node{
		int i;
		int j;
		char lr;
		char ud;
		boolean visited;
		public Node(int i, int j, char lr, char ud, boolean visited){
			this.i = i;
			this.j = j;
			this.lr = lr;
			this.ud = ud;
			this.visited = visited;
		}
		public void seti(int i){
			this.i = i;
		}
		public int geti(){
			return i;
		}
		public void setj(int j){
			this.j = j;
		}
		public int getj(){
			return j;
		}
		public void setlr(char lr){
			this.lr = lr;
		}
		public int getlr(){
			return lr;
		}
		public void setud(char ud){
			this.ud = ud;
		}
		public int getud(){
			return ud;
		}
		public void setVisited(boolean visited){
			this.visited = visited;
		}
		public boolean getVisited(){
			return visited;
		}
	}
}

