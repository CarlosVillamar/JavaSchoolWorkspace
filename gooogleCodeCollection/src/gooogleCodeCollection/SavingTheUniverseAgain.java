package gooogleCodeCollection;

import java.util.Scanner;

public class SavingTheUniverseAgain {
	
	/***
	 * In order to hack the robot
	 * % we need to know how many times we will attempt to hack it
	 * % how strong is our shield?
	 * % Analyze the robots sequence
	 */

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the number of times we will attempt to hack the robot:  ");
		int numOfEngagements = scanner.nextInt();

		// loop through the number of engagements
		for (int i = 1; i <= numOfEngagements; i++) {
			System.out.print("How much damage can our sheild sustain? ");
			long shieldCapacity = scanner.nextLong();

			System.out.println("Enter the hacking sequence we need to hack to reduce the damage?  \n Remember C for charge and S for shoot \n no lower case C's or S' ");
			char[] hackSeq = scanner.next().toCharArray();

			// send a call to a method to hack the robot
			String result = HackAttempt(shieldCapacity, hackSeq);

			// print out results
			System.out.println("This engagement will require  " + result  + " hacks  \n We have " + i + " engageents left");

		}
		scanner.close();
		System.exit(0);
	}

	public static String HackAttempt(long shieldDamage, char[] seq) {
		//Lets attempt to hack the robot's beam based on certain criteria
		long hackCount = 0;

		if (shieldDamage < hackVerififaction('S', seq)) {
			//we can't  hack if the sequence is only set to shoot and our shield capacity is less that the amount of times the sequence is set to shoot
			return "Impossible";
		} else {

			if (hackVerififaction('C', seq) == seq.length || hackVerififaction('S', seq) == seq.length) {
				//we can't hack the beam if it is only a series of charges or shots
				return "You cannot just charge the beam or shoot it ";
			} else {
				//for every other case

				if (BeamStrength(seq)<=shieldDamage) {
					return "**No need to hack it we can take the hit**";

				} else {
					//we have to try to hack the sequence the damage is too strong
					hackCount = hackAttack(shieldDamage, seq, 0);
				}
			}
		}
		return String.valueOf(hackCount);
	}

	private static long hackVerififaction(char hackCode, char[] seq) {
		// Check how many times our sequence returns a charge or shoot
		// operations depending on what gets passed in
		int codeCount = 0;
		for (int i = 0; i < seq.length; i++) {
			if (hackCode == seq[i]) {
				codeCount++;
			}
		}

		return codeCount;
	}

	private static long hackAttack(long shieldDamage, char[] seq, long hack) {
		//Lets hack the robot and make sure we don't get caught |  lets see what we can change
		 for(int hackIndex=0; hackIndex <seq.length; hackIndex++) {
			 
			int shotCheck = hackIndex+1;//check the index ahead for a shoot command


			if (seq[hackIndex] == 'C' & seq[shotCheck] == 'S') {
				//we can swap operations when a shoot command follows up a charge command
				hack++;
				seq[hackIndex] = 'S';
				seq[shotCheck] = 'C';
				System.out.println("Swap occured ");

				if (BeamStrength(seq)<=shieldDamage) {
					//The beam is no longer strong enough to place us in danger
					System.out.println("Prepare to engage!!!");
					return hack;
				} else {
					//the beam is too strong, we have to hack the sequence again
					System.out.println("The beam is still too strong");
					return hackAttack(shieldDamage, seq, hack);
				}
			}
		}

		return hack;
	}

	private static long BeamStrength(char[] hackSeq) {
		//What is the current damage of robots beam? lets calculate it

		long damage = 0;
		long strength = 1;

		for (int i = 0; i < hackSeq.length; i++) {
			if (hackSeq[i] == 'S') {
				damage = damage + strength;
				System.out.println("Current Beam Damage " + damage);
			}else if (hackSeq[i] == 'C') {
				strength = strength * 2;
				System.out.println("Current Beam Strength " + strength);
			}
		}
		return damage;

	}

}
