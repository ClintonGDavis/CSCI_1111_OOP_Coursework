# CSCI 1111 Final Project

## Synopsis
This project is a rudimentary logbook created for the purposes of enabling its users to track
progress in regards to mental health oriented goals.

## Motivation
My motivations for creating this project can be traced back to conversations I've had with a
personal friend of mine who works as clinical therapist.

My project is directly based off of a system which was developed by this friend (at his request).

## How to Run
The file "FinalProject111.java" is needed in order to run this program.

![This is a screenshot](https://github.com/ClintonGDavis/CSCI_1111_OOP_Coursework/blob/main/CSCI_1111_Final_Project/FinalProject1111%20Screenshot.png)

## Code Example

I am proud of this snippet of code because I was able to figure out how to impliment a main
menu after troubleshooting for relatively short period of time.
```
public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		MonthlyScore m1 = new MonthlyScore();
		int user = 0;
		int returnUser = 0;

		System.out.println("Welcome to the Balanced Living program!" +
				"\nYou are now accessing your Balanced Living logbook.\n");

		while (user != 1 && user != 2 && user != 3 && user != 4 && user != 5) {
			System.out.println("Which action would you like to perform?");
			System.out.println("\t1) Submit your pre-established Balanced Living goals.");
			System.out.println("\t2) Submit your Balanced Living scores for the last month.");
			System.out.println("\t3) Review your submitted goals and overall scores.");
			System.out.println("\t4) Learn more about the Balanced Living program.");
			System.out.println("\t5) Quit program.");
			System.out.print("Choose a menu item: ");

			user = in.nextInt();

			if (user == 1) {
				setLoveStandards(m1);
				user = returnToMain(returnUser);
			} else if (user == 2) {
				setLoveScores(m1);
				user = returnToMain(returnUser);
			} else if (user == 3) {
				reviewSubmissions(m1);
				user = returnToMain(returnUser);
			} else if (user == 4) {
				learnMore();
				user = returnToMain(returnUser);
			} else if (user == 5) {
				break;
			}
		}
	}
  ```
  
  ## Contributers
  My code is based off a system created by Matt Denhalter.
  I have written all the code myself.
  
