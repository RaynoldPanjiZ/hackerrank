import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class quartile {

	// find mid value
	public static double[] median(int x[], int N){
		double median = 0.0;
		double result[] = new double[2];
		if (N%2 == 0) {
			int indices1 = N / 2;
			int indices2 = indices1 - 1;
			median = (x[indices1] + x[indices2]) / 2.0;
			result[0] = indices1;

		} else {
			int indices = N / 2;
			median = x[indices];
			result[0] = indices;
		}
		result[1] = median;
		return result;
	}

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int data;
        int x[] = new int[N];

        for (int i=0; i<N; i++) {
        	data = sc.nextInt();
        	x[i] = data;
        }

        // sort value of x
   		Arrays.sort(x);

   		// get value q2 aka median
   		double result[] = median(x, N);
   		int indices = (int)result[0];
   		double median = result[1];

   		// get value q1
   		int lowHalf[] = new int[indices];
   		for (int i=0; i<indices; i++) {
   			lowHalf[i] = x[i];
   		}
   		double q1[] = median(lowHalf, indices);

   		// get value q3
   		int hightHalft[] = new int[indices];
   		int j=0;
   		for (int i=(N%2==0)?indices:indices+1; i<N; i++) {
   			hightHalft[j] = x[i];
   			j++;
   		}
   		double q3[] = median(hightHalft, indices);

   		// result value of q1, q2, q3
   		if (q1[1]%1==0) {
			System.out.printf("%.0f\n",q1[1]);
   		} else {
	   		System.out.println(q1[1]);
   		}
   		if ( median%1==0 ) {
			System.out.printf("%.0f\n",median);
   		} else {
	   		System.out.println(median);
   		}
   		if (q3[1]%1==0) {
			System.out.printf("%.0f\n",q3[1]);	
   		} else {
	   		System.out.println(q3[1]);
   		}

    }
}