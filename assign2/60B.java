import java.util.*;

public class 60B {

	public static void main (String args[]) {
		Scanner sc = new Scanner(System.in);
		int k = sc.nextInt();
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][][] matrix = new int[k][n][m];
		sc.nextLine();
		sc.nextLine();
		
		
		for (int ii = k-1; ii >= 0; ii--) {									
			for (int jj = 0; jj < n; jj++) {
				String str = sc.nextLine();
				char[] charz = str.toCharArray();								
				for (int kk = 0; kk < m; kk++) {
					if (charz[kk] == '.')
						matrix[ii][jj][kk] = 0;
					else
						matrix[ii][jj][kk] = 1;
				}
			}
			sc.nextLine();			
		}
		
		int tapY = sc.nextInt();
		int tapX = sc.nextInt();
		int result = dfs(k - 1, tapY - 1, tapX - 1,  matrix);
		System.out.println(result);
		sc.close();
	}
	
	public static int dfs(int z, int y, int x, int[][][] matrix) {
		
		if ( x < 0 || y < 0 || z < 0 || // Out of bounds
			 x >= matrix[0][0].length || y >= matrix[0].length || z >= matrix.length ) {
			return 0;
		}
		if (matrix[z][y][x] == 1)	// Visited
			return 0;	
			
		int result = 1;
		matrix[z][y][x] = 1;	// Set visited
		result += dfs(z		, y + 1	, x		,  matrix); // W
		result += dfs(z		, y		, x - 1	,  matrix); // A
		result += dfs(z		, y - 1	, x		,  matrix); // S
		result += dfs(z		, y		, x	+ 1	,  matrix); // D
		result += dfs(z	- 1	, y		, x		,  matrix); // Up
		result += dfs(z	+ 1	, y		, x		,  matrix); // Down
		
		return result;
	}	
}
