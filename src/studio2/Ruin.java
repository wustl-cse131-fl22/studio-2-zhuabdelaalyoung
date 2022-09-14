package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner var = new Scanner(System.in);
		
		System.out.print("Starting Amount");
		double startAmount= var.nextDouble();
		
		System.out.print("Win Chance:");
		double winChance= var.nextDouble();
		
		System.out.print("Win Limit:");
		double winLimit= var.nextDouble();
		
		System.out.print("How many Simulations?: ");
		int sims = var.nextInt();
		
		
		
		double temp=0;
		double eRuin;
		double Ruin;
		double alpha = (1-winChance)/winChance;
		int bruh = 0;
		int bro = 0;
		int bruv = 0;

		for(int j=0;j<sims;j++) {
			for(double i = startAmount+1; (winLimit+1) > i && i > 0; i++) {
				double mRandom=Math.random(); 
				if(mRandom>winChance) {
					i=i-2;
					//System.out.println("money minus "+i);
					bruh++;
				}
				else {
					i=i;
					//System.out.println("money plus "+i);
					bro++;
				}
				temp=i;
				if (i == 0) {
					break;
				}
			}
			bruv+=bruh;
		}
		Ruin=bruv/sims;
		if(temp == winLimit) {
			System.out.println("You reached " + winLimit+ " in earnings!");
		}
		else {
		System.out.println("You lost all your money.");
	}
		
		if( winChance == 0.5) {
			eRuin = 1-(startAmount/winLimit);
		}
		else {
			eRuin  =((Math.pow(alpha,(startAmount)-Math.pow(alpha, winLimit)))/(1-(Math.pow(alpha, winLimit))));
		}
		System.out.println("We won "+ bro+" times!");
		System.out.println("You lost " + bruh + " times!");
		System.out.println("We played: "+(bruh+bro)+ " times!");
		System.out.println("Ruin Rate: " +Ruin + " and Expected Ruin is "+ eRuin);
}
}
