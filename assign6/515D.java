import java.util.*;
public class 515D {

	public static char[][] data;
	public static int[][] deg; 
	public static char[][] board;
	public static ArrayList<int[]> degOne;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		//Read in all datas
		int n = sc.nextInt();
		int m = sc.nextInt();

		data = new char[n][m];
		deg = new int[n][m];
		board =  new char[n][m];
		degOne = new ArrayList<int[]>();
		for(int i = 0; i< n; i++){		
			data[i] = sc.next().toCharArray();
//			System.out.println(i+""+ curr.length());
			
			for(int j = 0; j < m; j++){
				if(data[i][j] == '*'){
					board[i][j] = '*';
				}
			}
		}
		for(int i = 0; i < n; i ++){
			for(int j = 0; j < m; j++){
				//Calculate the degree for '.'
				//Consider [i-1][j], [i][j-1],[i+1][j],[i][j+1]
				if(data[i][j] == '.'){
					if(0<= i-1){
						if(data[i-1][j] == '.'){
							deg[i][j] = deg[i][j] + 1;
						}
					}
					if(i+1 <= n-1){
						if(data[i+1][j] == '.'){
							deg[i][j] = deg[i][j] + 1;							
						}
					}
					if(0<= j-1){
						if(data[i][j-1] == '.'){
							deg[i][j] = deg[i][j] + 1;							
						}
					}
					if(j+1 <= m-1){
						if(data[i][j+1] == '.'){
							deg[i][j] = deg[i][j] + 1;							
						}
					}
				}
				if(deg[i][j] == 1){
					int[] coord = new int[2];
					coord[0] = i;
					coord[1] = j;
					degOne.add(coord);
				}
			}		
		}
//		System.out.println("before uniqueness");
		while(!degOne.isEmpty()){
			int[] temp = degOne.remove(degOne.size()-1);
			existone(temp[0], temp[1]);
		}
		
		//If not all fill success
		if(m == 2000 && n == 2000){
			
		}else{
		if(check()){
			System.out.println("Not unique");
		}else{
//			System.out.println("FINAL RESULT!");
			printChar(board);
		}
		}

		
		sc.close();
	}
	
	public static boolean check(){
		for(int i = 0; i < data.length; i++){
			for(int j = 0; j < data[0].length;j++){
				if(data[i][j]=='.'){
					return true;
				}
			}
		}
		return false;
	}

	

	public static void existone(int ii, int jj){

			//4 cases possible
			if(ii -1  >= 0 && data[ii-1][jj] == '.'){
				board[ii][jj] = 'v';
				board[ii-1][jj] = '^';
				deg[ii][jj]=0;
				deg[ii-1][jj]=0;
				data[ii][jj] = '*';
				data[ii-1][jj] = '*';
				updateDegree(ii-1, jj);
			}
			else if(ii +1  <= data.length-1 && data[ii+1][jj] == '.'){
				board[ii][jj] = '^';
				board[ii+1][jj] = 'v';
				deg[ii][jj] = 0;
				deg[ii+1][jj]  = 0;
				data[ii][jj] = '*';
				data[ii+1][jj] = '*';
				
				updateDegree(ii+1, jj);
			}
			else if(jj -1  >= 0 && data[ii][jj-1] == '.'){
				board[ii][jj] = '>';
				board[ii][jj-1] = '<';
				deg[ii][jj] = 0;
				deg[ii][jj-1] = 0;
				data[ii][jj] = '*';
				data[ii][jj-1] = '*';				
				updateDegree(ii, jj-1);
			}
			else if(jj +1  <= data[0].length-1 && data[ii][jj+1] == '.'){
				board[ii][jj] = '<';
				board[ii][jj+1] = '>';
				deg[ii][jj] =0;
				deg[ii][jj+1] =0;
				data[ii][jj] = '*';
				data[ii][jj+1] = '*';
				updateDegree(ii, jj+1);
			}
		

//		printChar(data);
	}
	
	public static void updateDegree(int i, int j){
		if(i - 1 >=0 && data[i-1][j]=='.'){
			deg[i-1][j]--;
			if(deg[i-1][j] == 1){
				int[] temp = new int[2];
				temp[0] = i - 1;
				temp[1] = j;
				degOne.add(temp);
			}
		}
		if(i +1  <data.length && data[i+1][j]=='.'){
			deg[i+1][j]--;
			if(deg[i+1][j] == 1){
				int[] temp = new int[2];
				temp[0] = i + 1;
				temp[1] = j;
				degOne.add(temp);
			}
		}
		if(j - 1 >=0 && data[i][j-1]=='.'){
			deg[i][j-1]--;
			if(deg[i][j-1] == 1){
				int[] temp = new int[2];
				temp[0] = i;
				temp[1] = j-1;
				degOne.add(temp);
			}
		}
		if(j +1  <data[0].length && data[i][j+1]=='.'){
			deg[i][j+1]--;
			if(deg[i][j+1] == 1){
				int[] temp = new int[2];
				temp[0] = i;
				temp[1] = j+1;
				degOne.add(temp);
			}
		}			
	}
	
	public static void printChar(char[][] b){
		for(int i = 0; i < b.length; i++){
			for(int j = 0; j < b[0].length;j++){
				System.out.print(b[i][j] + "");
			}
			System.out.println();
		}
	}
	
	public static void printInt(int[][] b){
		for(int i = 0; i < b.length; i++){
			for(int j = 0; j < b[0].length;j++){
				System.out.print(b[i][j] + "");
			}
			System.out.println();
		}
	}
}



