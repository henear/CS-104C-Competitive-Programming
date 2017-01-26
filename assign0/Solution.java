/*
Gravity Flip Codeforce Question 405A
time limit per test1 second
memory limit per test256 megabytes
inputstandard input
outputstandard output
Little Chris is bored during his physics lessons (too easy), so he has built a toy box 
to keep himself occupied. The box is special, since it has the ability to change gravity.

There are n columns of toy cubes in the box arranged in a line. The i-th column contains ai cubes. 
At first, the gravity in the box is pulling the cubes downwards. When Chris switches the gravity, it begins to pull all the cubes to the 
right side of the box. The figure shows the initial and final configurations of the cubes in the box: the cubes that have changed 
their position are highlighted with orange.

Given the initial configuration of the toy cubes in the box, find the amounts of cubes in each 
of the n columns after the gravity switch!

Input
The first line of input contains an integer n (1 ≤ n ≤ 100), the number of the columns in the box. 
The next line contains n space-separated integer numbers. The i-th number ai (1 ≤ ai ≤ 100) denotes the number of 
cubes in the i-th column.

Output
Output n integer numbers separated by spaces, where the i-th 
number is the amount of cubes in the i-th column after the gravity switch.
*/

import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		int counter = 0;
		int[] spec = new int[l];
		while(sc.hasNextInt()){
			spec[counter++] = sc.nextInt();
		}
		Arrays.sort(spec);
		for(int i = 0; i < l; i++){
			System.out.println(spec[i] + " ");
		}
		sc.close();
	}

}
