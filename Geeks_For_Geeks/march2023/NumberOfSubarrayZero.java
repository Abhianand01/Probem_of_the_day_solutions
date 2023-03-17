package Geeks_For_Geeks.march2023;

public class NumberOfSubarrayZero {

    public static void main(String[] args) {
        int N=4;
        int arr[]={0,0,0,0};
        System.out.println(no_of_subarrays(N, arr));
    }

    /* Brute Force: By using two for loops generate all subarrays and count subarrays if they contain only zeros
        Time complexity: At worst case O(n^3)

        Optimal Solution : Simple mathematical formula will help us to solve this problem very easily

        consider array of zeros of length 1 -> 1  (total subarrays)
        consider array of zeros of length 2 -> 3  (total subarrays)
        consider array of zeros of length 3 -> 6  (total subarrays)
        There is some correlation right, yep there is which is if length of array which contains
        only zero is n then the number of subarrays fomed will be n*(n+1)/2. Hurray!!

        so, By using two pointer approach..., let me explain this also

        consider two variable i and j initialized to 0.

        move j until it meets a non zero value which means the values between i and j are zero
        now we have found a subarray of length j-i  apply formula we saw above, add this to count

        now increment j by 1 and i to j+1, apply the same steps above untill j > arr.length-1
         return count
     * 
     * 
     */
    static long no_of_subarrays(int N, int [] arr) {
		//initialization
		int i=0;
		int j=0;
		long count=0;
        //loop untill j crosses length of array
		while(j<arr.length){
		    
            //find continous subarray of zeros from i by incrementing j
		    while(j<arr.length&&arr[j]==0){
		        j++;
		        
		    }

            //apply discussed formula
		    int n=j-i;
		    count+=(long)n*(n+1)/2;
		    
            //increment i and j
		    i=j+1;
		    j++;
		    
		    
		}
        //return count
		return count;
	}
    
}
