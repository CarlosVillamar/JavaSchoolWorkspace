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
	   System.exit(0);
  }
  private static long BeamStrength(char[] hackSeq){
	
	  long damage = 0;
	  long strength = 1;
	  
	  for(int i = 0; i< hackSeq.length; i++) {
		  if(hackSeq[i]=='S') {
			  damage = damage + strength;
		  }else if(hackSeq[i]=='C') {
			  strength = strength*2;
		  }
	  }
	  return damage;
	  
  }
  
  private static long hackVerififaction(char hackCode, char [] seq) {
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
			  return String.valueOf(hackCount);
		  }else {
			  hackCount = hackAttack(hackLength, seq);
		  }
	  }
	return String.valueOf(hackCount);
  }

  
  private static long hackAttack(long numHack, char[] seq) {
	   long hack =0;
//	  for(int i =0; i <seq.length; i++) {
		  for(int i = seq.length-1; i >0; i--) {
		  int nextInSequence = i--;
		  
		  if(seq[i]=='S'& seq[nextInSequence]=='C') {
			  hack++;
			  seq[i]='C';
			  seq[nextInSequence] ='S';
			  
			  if(numHack >= BeamStrength(seq)) {
				  return hack;
			  }else {
				  return hackAttack(numHack, seq);
			  }
		  }
	  }
	  
	  return hack;
  }
	
}
