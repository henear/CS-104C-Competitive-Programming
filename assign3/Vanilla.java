import java.util.*;

public class Vanilla {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		// Read in data
		int numTest = sc.nextInt();
		for(int i = 0; i < numTest; i++){
			int hiorder = sc.nextInt();
			int target = sc.nextInt();
			
			int[] order = new int[hiorder+1];
			for(int j = 0; j< hiorder + 1; j++){
				order[j] = sc.nextInt();
			}
			//Deal with corner case
			if(target < order[0]){
				System.out.println(-1);
			// Deal with corner case
			}else if(target == order[0]){
				System.out.println(0);
			}else{
				int p = 1;
				int behind = p;
				while(eval(order, p, target) == -1){
					behind = p;
					p *= 2;
				}
				if(eval(order, p, target) == 0){
					System.out.println(p);
				}else{
					//binary search in [behind, p]
					binarysearch(behind, p, target, order);						
				}
			}
		}
		sc.close();
	}

	//Check if there exist a solution between lo and hi, if yes, print the number,
	// if not print -1
	public static boolean binarysearch(int lo, int hi, int target, int[] order){
		boolean b = false;
		while(lo + 1 < hi){
			int mid = (lo + hi) / 2;
			if(eval(order, mid, target ) == -1){
				lo = mid;
			}else if(eval(order, mid, target) == 1){
				hi = mid;
			}else{
				System.out.println(mid);
				b = true;
				break;
			}
			
		}
		if(!b){
			System.out.println(-1);
		}
		return b;
	}
	
	//Evaluate the current number plug in polynomial result versus target number
	public static int eval(int[] order, int num, int target){
		int l = order.length;
		int sum = 0;
		for(int i = 0; i < l; i++){
			sum += Math.pow(num, i) * order[i];
		}
		if(sum < target){
			return -1;
		}else if(sum == target){
			return 0;
		}else{
			return 1;
		}
	}
}
