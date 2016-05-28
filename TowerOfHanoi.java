package RecursionAndBacktracking;

import java.util.Scanner;
import java.util.Stack;

public class TowerOfHanoi {
	
	static int n;
	static Stack<Integer> from = new Stack<>();
	static Stack<Integer> to = new Stack<>();
	static Stack<Integer> aux = new Stack<>();
	
	public static void solveTowerOfHanoi(int n,int peg1,int peg2,int peg3){
		
		if(n==0)
		{
			System.out.println("Minimum 1 disk should be present");
			return;
		}
		if(n==1){
			System.out.println("Move disk-"+n+" from peg" + peg1+" and put in peg"+peg3+".");
			return;
		}
		
		solveTowerOfHanoi(n-1, peg1, peg3, peg2);
		System.out.println("Move disk-"+n+" from peg" + peg1+" and put in peg"+peg3+".");
		solveTowerOfHanoi(n-1, peg2, peg1, peg3);
		return;
		
	}
	
	public static void displayPegs() {
		for(int i=0;i<n;i++){
				
				int s1 = from.size();
				if(s1<(n-i))
					System.out.print(" | ");
				else
					System.out.print(" "+from.elementAt(n-i-1)+" ");
				
				int s2 = aux.size();
				if(s2<(n-i))
					System.out.print(" | ");
				else
					System.out.print(" "+aux.elementAt(n-i-1)+" ");
				
				int s3 = to.size();
				if(s3<(n-i))
					System.out.print(" | ");
				else
					System.out.print(" "+to.elementAt(n-i-1)+" ");
				System.out.println();
			
		}
		System.out.println();
		System.out.println("---------------------------------------");
		
		return;
	}
	
	public static void startSimulation(int n,Stack<Integer> from,Stack<Integer> aux,Stack<Integer> to){

	if(n==0){
		displayPegs();
		return;
	}
	if(n==1){
//		displayPegs();
		to.push(from.pop());
		displayPegs();
		return;
	}
		
	startSimulation(n-1,from, to, aux);
	to.push(from.pop());
	displayPegs();
	startSimulation(n-1,aux, from, to);
	
	return;
		
	}
	
	public static void simulateToh(int n){
		
		for(int i=n;i>=1;i--)
			from.push(i);
		displayPegs();
		startSimulation(n,from,aux,to);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Enter the number of Disks :");
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		int nTemp = n;
		//solveTowerOfHanoi(n,1,2,3);   //1 - from peg , 2-auxiliary peg, 3 - to peg
		simulateToh(nTemp);
		
	}

}
