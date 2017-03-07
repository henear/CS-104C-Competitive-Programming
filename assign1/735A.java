import java.util.Scanner;


public class 735A {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		String s = sc.next();
		//System.out.println(s);
		sc.close();
		int gindex = 0;
		int tindex = 0;
		for(int i = 0 ; i < n; i++){
			char curr = s.charAt(i);
			if(curr == 'G'){
				gindex = i;
			}
			if(curr == 'T'){
				tindex = i;
			}
		}
		int min = Math.min(gindex, tindex);
		int max = Math.max(gindex, tindex);
		int dist = max - min;
		if(dist % k !=0 ){
			System.out.println("NO");
		}else{
			char cur = 'a';
			for(int i = min + k; i < max; i+=k){
				cur = s.charAt(i);
				if(cur == '#'){
					break;
				}
			}
			if(cur == '#'){
				System.out.println("NO");
			}else{
				System.out.println("YES");
			}
		}
	}

}