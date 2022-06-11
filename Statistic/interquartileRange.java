import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class interquartileRange {

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
        int data, frequency;
        int x[] = new int[N];
        int f[] = new int[N];
        int fn = 0;

        // input data x
        for (int i=0; i<N; i++) {
        	data = sc.nextInt();
        	x[i] = data;
        }

        // input frequencies f
        for (int i=0; i<N; i++) {
        	frequency = sc.nextInt();
        	f[i] = frequency;
        	fn = fn + f[i];
        }

        // set x to S
        int S[] = new int[fn];
        fn=0;
        for (int i=0; i<N; i++) {
        	for (int j=0; j<f[i]; j++) {
        		S[fn] = x[i];
        		fn++;
        	}
        }

        // sort value of S
   		Arrays.sort(S);
        System.out.println(Arrays.toString(S));

   		// get value q2 aka median
   		double result[] = median(S, fn);
   		int indices = (int)result[0];
   		double median = result[1];

   		// get value q1
   		int lowHalf[] = new int[indices];
   		for (int i=0; i<indices; i++) {
   			lowHalf[i] = S[i];
   		}
   		double q1[] = median(lowHalf, indices);

   		// get value q3
   		int hightHalft[] = new int[indices];
   		int j=0;
   		for (int i=(fn%2==0)?indices:indices+1; i<fn; i++) {
   			hightHalft[j] = S[i];
   			j++;
   		}
   		double q3[] = median(hightHalft, indices);

   		// result the interquartile range
   		double range = q3[1] - q1[1];
		System.out.printf("%.1f\n",range);	

    }
}