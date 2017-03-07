import java.util.*;
public class Vanilla {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = new int[]{1,1,1,2,3,3,5};
	    twoSum(a, 2);
	}

	public static void twoSum(int[] a, int target){
		int l = a.length;
		int start = 0;
		int end;
		List<int[]> result = new ArrayList<int[]>();
		HashMap<Integer, Integer> hs = new HashMap<>();
		for(int i =0; i < l; i++){
			if(hs.containsKey(a[i])){
				hs.put(a[i], hs.get(a[i])+ 1);
			}else{
				hs.put(a[i], 1);
			}
		}
		int newL = hs.size();
		end = newL -1;
		int[] temp = new int[newL];
		int i = 0;
		for(int key: hs.keySet()){
			temp[i++] = key;
		}
		Arrays.sort(temp);
		System.out.println(Arrays.toString(temp));
		if(hs.keySet().size()==1){
			
			if(temp[0]+temp[0]==target&&hs.get(temp[0])!=1){
				
				int size = hs.get(temp[0])*(hs.get(temp[0])-1)/2;
				
				for(int j = 0; j<size; j++){
					int[] tempone = new int[2];
					tempone[0] = temp[0];
					tempone[1] = temp[0];
					result.add(tempone);
				}
			}
		}else{
		while(start<end){
			int sum = temp[start] + temp[end];
			if(sum < target){
				start++;
			}
			else if(sum > target){
				end --;
			}else{
				int[] tempR = new int[2];
				tempR[0] = temp[start];
				tempR[1] = temp[end];
				int tempp = hs.get(tempR[0]);
				int tempq = hs.get(tempR[1]);
				for(int j = 0; j < tempp*tempq; j++){
				result.add(tempR);
				}
				end --;
				start++;
			}
		}
		}
		System.out.println(result.size());
	}
}
