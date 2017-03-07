import java.util.*;

public class Vanilla {
	public static void main(String[] args){
		//Get input data
		Scanner sc = new Scanner(System.in);
		int numtest = sc.nextInt();
		for(int i = 0; i < numtest; i++){
			//Single test case data
			HashMap<Integer, HashSet<Integer>> thisgraph = new HashMap<>();
			//Test input is correct
			int[] reldata = getSingleCase(sc, thisgraph);
		
			//printgraphmap(thisgraph);
			int reachable = doBFS(thisgraph, reldata);
			int count = countComp(thisgraph, reldata);
			System.out.println(count + " " + reachable);
		}
		sc.close();
	}
	
	public static void printgraphmap(HashMap<Integer, HashSet<Integer>> thisgraph){
		for(Integer i : thisgraph.keySet()){
			System.out.print(i);
			System.out.println(thisgraph.get(i));
		}
	}
	public static int[] getSingleCase(Scanner sc,
			HashMap<Integer, HashSet<Integer>> inputs){	
		
		int[] reldata = new int[4];
		for(int i = 0; i < 4; i++){
			reldata[i] = sc.nextInt();
		}
	
		sc.nextLine();
		for(int i = 0; i < reldata[1]; i++){			
			String curr = sc.nextLine();			
			String[] temp = curr.split(" ");
			int first = Integer.parseInt(temp[0]);
			int second = Integer.parseInt(temp[1]);
			if(inputs.containsKey(first)){
				HashSet<Integer> thisSet = inputs.get(first);
				thisSet.add(second);
				inputs.put(first, thisSet);
			}
			if(!inputs.containsKey(first)){
				HashSet<Integer> thisSet = new HashSet<Integer>();
				thisSet.add(second);
				inputs.put(first, thisSet);
			}
			if(inputs.containsKey(second)){
				HashSet<Integer> thisSet = inputs.get(second);
				thisSet.add(first);
				inputs.put(second, thisSet);
			}
			if(!inputs.containsKey(second)){
				HashSet<Integer> thisSet = new HashSet<Integer>();
				thisSet.add(first);
				inputs.put(second, thisSet);			
			}
		}
		return reldata;
	}
	
	public static void doDFS(HashMap<Integer, HashSet<Integer>> gdata, int start, boolean[] visitb){				
		if(visitb[start]){
			return;
		}
		visitb[start] = true;
		for(Integer i : gdata.get(start)){
			doDFS(gdata, i, visitb);
		}
	}
		
	public static int countComp(HashMap<Integer, HashSet<Integer>> gdata, int[] reldata){
		int count = 0;
		boolean[] visitb = new boolean[reldata[0]+1];
		
		for(int i : gdata.keySet()){
			if(visitb[i]) continue;
			count ++;
			doDFS(gdata, i, visitb);			
		}
		return count;
	}
	
	public static int doBFS(HashMap<Integer, HashSet<Integer>> gdata, int[] reldata){
		Queue<int[]> toVisit = new LinkedList<>();
		
		//A boolean to refer if we had referenced or not
		boolean[] b = new boolean[reldata[0]+1];
		int depth = reldata[3];
		int reachable = 1;
		
		ArrayList<int[]> result = new ArrayList<int[]>();
		int S = reldata[2];
		int[] fNode = new int[2];
		fNode[0] = S;
		fNode[1] = 0;
		toVisit.add(fNode);
		result.add(fNode);
		while(!toVisit.isEmpty()){
			int[] currnode = toVisit.remove();
			int currnodeNum = currnode[0];
			int currnodelevel = currnode[1];
			
			if(b[currnodeNum]){
				continue;
			}
			
			b[currnodeNum] = true;			
			for(Integer i : gdata.get(currnodeNum)){				
				int level = currnodelevel + 1;
				int[] datanow = new int[2];
				datanow[0] = i;
				datanow[1] = level;
				if(!b[i] &&  level <= depth){
					toVisit.add(datanow);
					result.add(datanow);
					reachable ++;
					b[i] = true;
				}
			}
		}
		return reachable;
	}
}
