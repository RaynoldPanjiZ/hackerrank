import java.util.*;
public class probabilityBasic{

	public static int comb(String[] dice, int total){
		System.out.println("dadu = "+Arrays.toString(dice));
		System.out.println("jumlah dadu = "+total);
		
		String R[] = new String[dice.length*dice.length];
		int k=-1;
		for (int i=0; i<dice.length; i++) {
			for (int j=0; j<dice.length; j++) {
				if (Integer.parseInt(dice[i])+Integer.parseInt(dice[j]) <= 9) {
					R[++k] = dice[i]+dice[j];
				}
			}
		}
		
		R = Arrays.copyOf(R, k+1);

		System.out.println("komnbinasi dadu = "+Arrays.toString(R));
		System.out.println("jumlah komnbinasi = "+R.length);
		return R.length;
	}

	public static String prob(int combDice, double n){
		int N = (int)n;
		String a[] = {combDice+"", N+""};
		System.out.print(Arrays.toString(a)+" ");
		for (int i=1; i<N; i++) {
			if (combDice%i == 0 && N%i == 0) {
				int tempA = combDice /i;
				int tempB = N /i;
				a[0] = tempA+"";
				a[1] = tempB+"";
			}
		}

		return a[0]+"/"+a[1];
	}

	public static void main(String[] args) {
		int totDice = 2;
		String SideDice[] = {"1","2","3","4","5","6"};

		System.out.println("Probabilitas = "+prob(comb(SideDice, totDice), Math.pow(SideDice.length, 2)));
	}
}
