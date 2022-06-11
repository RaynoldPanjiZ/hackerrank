
/*
	** program hackerrank 
	** problem = https://www.hackerrank.com/challenges/s10-mcq-3/problem
*/

import java.util.*;

public class compoundEvent {

	// probability
	public static int[] P_E(int[] x, int[] y, int[] z){
		int a = x[0] * y[0] * z[0];
		int b = x[1] * y[1] * z[1];

		int []result = {a,b};
		return result;
	}

	public static int countEle(String arr[], String s){
		int countN = 0;
		for (int i=0; i<arr.length; i++) {
			if (arr[i] == s) {
				countN ++;
			}
		}
		return countN;
	}
		

	public static String Bagi(int a, int b){
		int tempA[] = new int[35];
		int tempB[] = new int[35];

		for (int i=1; i<b; i++) {
			if (a%2 == 0 && b%2 == 0) {
				a = a /2;
				b = b /2;
			} else
			if (a%3 == 0 && b%3 == 0) {
				a = a /3;
				b = b /3;
			 }
		}

		return a + "/" + b;
	}

	public static void main(String[] args) {
		String []urnX = {"b","b","b","r","r","r","r"};
		String []urnY = {"b","b","b","b","r","r","r","r","r"};
		String []urnZ = {"b","b","b","b","r","r","r","r"};

		// Urn X
		int E_xB[] = {countEle(urnX, "b"), urnX.length};
		int E_xR[] = {countEle(urnX, "r"), urnX.length};

		// Urn Y
		int E_yB[] = {countEle(urnY, "b"), urnY.length};
		int E_yR[] = {countEle(urnY, "r"), urnY.length};

		// Urn Z
		int E_zB[] = {countEle(urnZ, "b"), urnZ.length};
		int E_zR[] = {countEle(urnZ, "r"), urnZ.length};


		/* 
			*	P(2 balls are red and 1 is black) : 
			*	P(E(R,R,B)) + P(E(R,R,B)) + P(E(R,R,B))
		*/
		int A = P_E(E_xR, E_yR, E_zB)[0]+P_E(E_xR, E_yB, E_zR)[0]+P_E(E_xB, E_yR, E_zR)[0];
		int B = P_E(E_xR, E_yR, E_zB)[1];

		System.out.println(Bagi(A, B));
	}
}