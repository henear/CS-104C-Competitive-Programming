import java.util.Scanner;

public class 520B {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		if(m < n){
			System.out.println(n - m);
		}else{
			int count = 0;
			while(n < m){
				if(m % 2 == 0){
					m = m / 2;
				}else{
					m ++;
				}
				count ++;
			}
			System.out.println(count + n - m);
		}
	}
}