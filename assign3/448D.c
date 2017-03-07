include <stdio.h>
int main(){
	long long m, n;
	long long k;
	scanf("%lld %lld %lld", &n, &m, &k);
	//printf("m is %lld n is %lld and k is %lld\n",m, n, k);
	long long lo = 1;
	long long hi = m * n;

	while(lo < hi){  
             long long mid = (lo+hi)/2;  
             long long count = 0;//Record the mid place  
             for(int i = 1; i <= n; i ++){  
                 long long x = mid/i;  
                 if(x > m){
                 	count += m;
                 }else{
                 	count += x;
                 }
                 
             }  
             if(count < k){
            	 lo = mid+1;  
             }
             else{
            	 hi = mid;  
             }
     }  
     printf("%lld\n", lo);
 
	return 0;
}
