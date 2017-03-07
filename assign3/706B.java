import java.util.*;

public class 706B {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[] price = new int[num];
		for(int i = 0; i < num; i++){
			price[i] = sc.nextInt();
		}
		Arrays.sort(price);
		
		int daysnum = sc.nextInt();
		
		for(int i = 0 ; i < daysnum; i++){
			int temp = sc.nextInt();
			if( temp >= price[num-1]){
				System.out.println(num);
			}else if(temp < price[0]){
				System.out.println(0);
			}else{
			int a = binarySearch(price, temp);	
			System.out.println(a+1);
			}
			
			
		}		
		sc.close();		
	}
	
	public static int binarySearch(int[] price, int temp){
		
		int lo = 0;
		int hi = price.length -1;
		while(lo +1 < hi){
			int mid = ( lo + hi ) /2 ;
			int t = price[mid];
			if(t <= temp){
				lo = mid;
			}else{
				hi = mid;
			}
		}
		return lo;
	}
	
}
