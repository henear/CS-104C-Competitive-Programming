import java.util.*;

public class 165B {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int target = sc.nextInt();
		int div = sc.nextInt();
		sc.close();
		if(div >= target){
			System.out.println(target);
		}else{
			
			//conduct binary search
			int lo = div;
			int hi = target;
			while(lo + 1 < hi){
				int mid = (lo + hi) / 2;
				if(p(mid, target, div)){
					
					hi = mid;
				}else{
					lo = mid;
				}
			}
			System.out.println(hi);
		}
		
		sc.close();
	}
	
	public static boolean p(int number, int target, int div){
		int sum = number;
		while(number/div!=0){
			number /= div;
			sum += number;
		}
		
		
		return sum >= target;
	}
}
