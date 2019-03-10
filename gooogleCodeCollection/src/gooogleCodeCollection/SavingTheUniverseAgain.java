package gooogleCodeCollection;

import java.util.Scanner;

public class SavingTheUniverseAgain {

  public static void main(String args[]) {
	  	Scanner scanner = new Scanner(System.in);
	  	System.out.println("Enter the number of engagements:  ");
	  	int numOfEngagements = scanner.nextInt();
	  	
	  	//loop through the number of engagements
	  	for(int i =1; i<=numOfEngagements;i++) {
	  		System.out.print("Enter the number hacks we have to attempt: ");
	  		long numberOfHacks = scanner.nextLong();
	  	
	  		System.out.println("Enter the haccking sequence you would like to try: ");
	  		char[] hackSeq = scanner.next().toCharArray();
	  		
	  		//send a call to method to hack the robot
	  		String result = HackAttempt(numberOfHacks, hackSeq);
	  		
	  		//print out results
	  		System.out.println(result);
	  		
	  	}
	  	scanner.close();
	   System.exit(0);
  }
  private static long BeamStrength(char[] hackSeq){
	
	  long damage = 0;
	  long strength = 1;
	  
	  for(int i = 0; i< hackSeq.length; i++) {
		  if(hackSeq[i]=='S') {
			  damage = damage + strength;
			  System.out.println("Current Beam Damage " + damage);
		  }else if(hackSeq[i]=='C') {
			  strength = strength*2;
			  System.out.println("Current Beam Strength " + strength );
		  }
	  }
	  System.out.println("is this it?");
	  return damage;
	  
  }
  
  private static long hackVerififaction(char hackCode, char [] seq) {
	  //Check how many times our sequence returns a charge or shoot operations
	int codeCount =0;
	for(int i = 0; i < seq.length;i++) {
		if (hackCode==seq[i]) {
			codeCount++;
		}
	}

	  return codeCount;
  }
  
  public static String HackAttempt(long hackLength, char[] seq) {
	  long hackCount = 0;
	  
	  if(hackLength< hackVerififaction('S', seq)) {
		  return "Impossible";
	  }else {
		  
		  if(hackVerififaction('C', seq)==seq.length||hackVerififaction('S', seq)==seq.length) {
			  System.out.print("You cannot just charge the beam or shoot it ");
			  return "0";
		  }else {
			  
			  if(hackLength >=BeamStrength(seq)) {
				  System.out.print("Denied");
				  return "0";
				  
			  }else  hackCount = hackAttack(hackLength, seq,0);
		  }
	  }
	return String.valueOf(hackCount);
  }

  
  private static long hackAttack(long numberOfHacks, char[] seq, long hack) {
//	   long hack =0;
//	  for(int i =0; i <seq.length; i++) {
		  for(int shotAttempt = seq.length-1; shotAttempt >0; shotAttempt--) {
		  int chargeCheck = shotAttempt--;
		  
		  if(seq[shotAttempt]=='S'& seq[chargeCheck]=='C') {
			  hack++;
			  seq[shotAttempt]='C';
			  seq[chargeCheck] ='S';
			  System.out.println("Swap occured");
			  
			  if(numberOfHacks >= BeamStrength(seq)) {
				  System.out.println("Number of hacks is greater than the beam strength");
				  return hack;
			  }else {
				  System.out.println("You are cleared to engage!!!");
				  return hackAttack(numberOfHacks, seq,hack);
			  }
		  }
	  }
	  
	  return hack;
  }
	
}