import java.io.*;
import java.util.*;

public class Stat1 {

	// Mean function
	public static double Mean(double X[], int N){
		double avg = 0.0;
		int i;
		for(i=0; i<N; i++){
			avg = avg + X[i];
		}
		return avg/i;
	}

	// Median
	public static double Median(double X[], int N){
		int i = (N-1)/2;
		if (N%2 != 0) {
			return X[i];
		} else {
			return (X[i] + X[i+1]) / 2;
		}
	}

	// Mode
	public static double Mode(double X[], int N){
		double maxValue=0; 
		int maxCount=0;
 
		for (int i = 0; i < N; ++i) {
			int count = 0;
			for (int j = 0; j < N; ++j) {
				if (X[j] == X[i])
					++count;
			}
			if (count > maxCount) {
				maxCount = count;
				maxValue = X[i];
			}
		}
		if (maxCount <= 1) {
			return X[0];
		} else {
			return maxValue;
		}
	}

	public static void main(String[] args) {
		/* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
		Scanner inpt = new Scanner( System.in );
		System.out.print("N = ");
		int N = inpt.nextInt();

		double[] X = new double[N];
		for(int i=0; i<N; i++){
			System.out.printf("x%d = ", i+1);
			X[i] = inpt.nextDouble();
		}
		
		// Sort x
		System.out.println();
		Arrays.sort(X);
		for (int i=0; i<N; i++) {
			System.out.print(" ["+X[i]+"], ");
		}
		System.out.println();

		// Output
		System.out.printf("\nMean\t= %6.3f", Mean(X, N));
		System.out.printf("\nMedian\t= %6.3f", Median(X, N));
		System.out.printf("\nMode\t= %6.3f", Mode(X, N));
	}
}