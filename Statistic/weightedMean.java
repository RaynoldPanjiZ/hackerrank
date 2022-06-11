import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class weightedMean {

	public static double M_w(double x[], double w[], int N){
		double W = 0;

		double XW = 0;

		System.out.println("Result: ");
		for (int i=0; i<N; i++) {
			W = W + w[i];
			XW = XW + (x[i]*w[i]);
		}
		return XW/W;
	}

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		double data, weight;
		double Mean=0;

		double x[] = new double[N];
		double w[] = new double[N];

		for (int i=0; i<N; i++) {
			data = sc.nextDouble();
			x[i] = data;
		}
		for (int i=0; i<N; i++) {
			weight = sc.nextDouble();
			w[i] = weight;
		}

        if ((Mean = M_w(x, w, N))%1 == 0){
            System.out.printf("%.1f", Mean);
        } else {
            System.out.printf("%.2f", Mean);
        }
	}


	// public static void Showdata(){
	// 	System.out.println(" [X]  [w] ");
	// 	for (int i=0; i<N; i++) {
	// 		System.out.print(" ["+x[i]+"] ");
	// 		System.out.print(" ["+w[i]+"] ");
	// 		for (int j=0; j<1; j++) {
	// 			System.out.println();
	// 		}
	// 	}
	// }
}