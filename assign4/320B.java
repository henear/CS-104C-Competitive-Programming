import java.util.*;
public class MergeInterval {
	public static class Interval {
		int start;
		int end;
		
		
		public Interval(int start, int end){
			this.start = start;
			this.end = end;
			
		}
		
		public void setStart(int start){
			this.start = start;
		}
		
		public void setEnd(int end){
			this.end = end;
		}
		
		
	}
	public static Interval[] in;
	public static boolean[] ans;
	public static int n;
	public static void main(String[] args){		
		Scanner sc = new Scanner(System.in);
		n = 0;
		int num = sc.nextInt();
		ans = new boolean[num+1];
	    in = new Interval[num+1];
		for(int i = 1; i<= num; i++){			
			for(int j = 1; j<= num; j++){
				  
				ans[j] = false;
			}
			int mycase = sc.nextInt();
			if(mycase == 1){
				n++;
				in[n] = new Interval(sc.nextInt(), sc.nextInt());
			}
			else
			{
				int source = sc.nextInt();
				int target = sc.nextInt();
				dodfs(source);
				if(ans[target]){
					System.out.println("YES");
				}else{
					System.out.println("NO");
				}
			}
		}
		sc.close();
	}	
	
	public static void dodfs(int k){
		ans[k] = true;
		for(int i = 1;i <=n; i++){
			if(in[k].start > in[i].start &&in[k].start < in[i].end && !ans[i]){
					dodfs(i);
			}
			else if(in[k].end > in[i].start && in[k].end < in[i].end && !ans[i]){
				dodfs(i);
			}
		}
	}
}
