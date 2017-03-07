import java.util.*;
public class 755C {

	public static void main(String[] args) {
		 Scanner sc = new Scanner(System.in);
	        int num = sc.nextInt();
	        HashSet<Integer> vertices = new HashSet<>();
	        int single = 0; 
	        int normal = 0;
	        
	        for (int i = 1; i <= num; i++) {
	        	int oneEnd = i;
	            int otherEnd = sc.nextInt();
	            if (otherEnd == oneEnd){
	                single++;
	            }
	            else if (vertices.add(otherEnd)){	                
	                normal++;
	            }
	        }

	        System.out.println(single+normal/2);
	        sc.close();
	}	
}
