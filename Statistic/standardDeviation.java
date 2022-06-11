import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class standardDeviation{
	
	// mean function
	public static double mean(double X[], int N){
		double avg = 0.0;
		int i;
		for(i=0; i<N; i++){
			avg = avg + X[i];
		}
		return avg/i;
	}

	// Variabnce function
	public static double variance(double x[], int N, double mu){
		double nux = 0;
		for (int i=0; i<N; i++) {
			nux = nux + Math.pow(x[i]-mu, 2); 
		}
		return nux/N;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double data;
		int N = sc.nextInt();
		double x[] = new double[N]; 
		
		for (int i=0; i<N; i++) {
			data = sc.nextDouble();
			x[i] = data;
		}

		double Nu = mean(x, N);
		
		// Standard deviation
		double Sd = Math.sqrt(variance(x,N,Nu));
		System.out.printf("%.1f", Sd);
	}
}