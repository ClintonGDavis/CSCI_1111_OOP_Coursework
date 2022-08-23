/*
Author: Clint Davis
Date: 8/19/22

This is my final project for Course 1111.

I keep on thinking of new functions I could implement - as well as novel improvements for existent functions -
which I do plan on implementing in future iterations of this program.

I could obviously also resubmit this project after adding some of those implementations, if it is deemed necessary.
*/

import java.util.*;

public class FinalProject1111 {

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

		public static MonthlyScore setLoveStandards(MonthlyScore standards) {
			Scanner in = new Scanner(System.in);

			System.out.println("~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("\nYou will now be asked to key in the standards - i.e. goals which you have previously " +
					"\nestablished - for each of the 6 categories in the Balanced Living program.");
			System.out.println("\nPlease try to condense each standard to a length of one short, concise sentence.");

			System.out.println("\n\t\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("\t\t\t\t\t\t\t\t\tFor example:");
			System.out.println("\t\t\t  One possible submission in the \"love\" category could be:" +
							"\n\t\t\t\"Having a high trust, long-term relationship with a partner.\"");
			System.out.println("\t\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

			System.out.println("Please type your personal standard for the \"love\" category, then press the Enter key.");
			standards.setLoveStandard(in.nextLine());

			System.out.println("Please type your personal standard for the \"work\" category, then press the Enter key.");
			standards.setWorkStandard(in.nextLine());

			System.out.println("Please type your personal standard for the \"learning\" category, then press the Enter key.");
			standards.setLearningStandard(in.nextLine());

			System.out.println("Please type your personal standard for the \"play\" category, then press the Enter key.");
			standards.setPlayStandard(in.nextLine());

			System.out.println("Please type your personal standard for the \"health\" category, then press the Enter key.");
			standards.setHealthStandard(in.nextLine());

			System.out.println("Please type your personal standard for the \"safety\" category, then press the Enter key.");
			standards.setSafetyStandard(in.nextLine());
		return standards;
		}

		public static MonthlyScore setLoveScores(MonthlyScore month) {
			Scanner in = new Scanner(System.in);
			double love, work, learning, play, health, safety;

			System.out.println("~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("\nYou will now be asked to key in your scores for each Balanced Living category." +
					"\nKeep in mind that all scores should be kept in the bounds of the 1-10 scale.");
			System.out.println("\n\t\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("\t\t\tRemember to hit the Enter key after typing in each answer.");
			System.out.println("\t\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

			System.out.println("What is your overall score for the \"love\" category within the last month?");
			love = in.nextDouble();
			month.setLoveScore(love);

			System.out.println("What is your overall score for the \"work\" category within the last month?");
			work = in.nextDouble();
			month.setWorkScore(work);

			System.out.println("What is your overall score for the \"learning\" category within the last month?");
			learning = in.nextDouble();
			month.setLearningScore(learning);

			System.out.println("What is your overall score for the \"play\" category within the last month?");
			play = in.nextDouble();
			month.setPlayScore(play);

			System.out.println("What is your overall score for the \"health\" category within the last month?");
			health = in.nextDouble();
			month.setHealthScore(health);

			System.out.println("What is your overall score for the \"safety\" category within the last month?");
			safety = in.nextDouble();
			month.setSafetyScore(safety);

			return month;
		}

		public static MonthlyScore reviewSubmissions(MonthlyScore month) {
			MonthlyScore m2 = new MonthlyScore(3, 3, 3, 3, 3, 3);

			ArrayList<Double> m1Array = new ArrayList<>();
				m1Array.add(month.getLearningScore());
				m1Array.add(month.getWorkScore());
				m1Array.add(month.getLearningScore());
				m1Array.add(month.getPlayScore());
				m1Array.add(month.getHealthScore());
				m1Array.add(month.getSafetyScore());

			ArrayList<Double> m2Array = new ArrayList<>();
				m2Array.add(m2.getLoveScore());
				m2Array.add(m2.getWorkScore());
				m2Array.add(m2.getLearningScore());
				m2Array.add(m2.getPlayScore());
				m2Array.add(m2.getHealthScore());
				m2Array.add(m2.getSafetyScore());

			ArrayList<String> m3Array = new ArrayList<>();
				m3Array.add(month.getLoveStandard());
				m3Array.add(month.getWorkStandard());
				m3Array.add(month.getLearningStandard());
				m3Array.add(month.getPlayStandard());
				m3Array.add(month.getHealthStandard());
				m3Array.add(month.getSafetyStandard());

			ArrayList<String> m4Array = new ArrayList<>();
				m4Array.add("Love standard:");
				m4Array.add("Work standard:");
				m4Array.add("Learning standard:");
				m4Array.add("Play standard:");
				m4Array.add("Health standard:");
				m4Array.add("Safety standard:");

			System.out.println(" ");
			System.out.println("\n\t\t\t\t\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" +
					"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("\t\t\t\t\t\tFor the purposes of this project, one prior month's worth of (fake) " +
					"scores have come pre-installed with this program. " +
					" \n\t\t\t\t\t\t\t\t\t\t\tThis was done in order to streamline the grading/review process " +
					"(more-or-less).");
			System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tMonth 1 = pre-installed scores.");
			System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  Month 2 = user input scores.");
			System.out.println("\t\t\t\t\t\t~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" +
					"~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");

			for (int i = 0; i < m3Array.size(); i++) {
				System.out.printf("---------------------------------------------------------" +
						"-------------------------------------------------------------------" +
						"-----------------------------------------------------%n");
				System.out.printf("| %-18s | %-82s | Month (1) score: | %-3.1f | Month (2) " +
								"score: | %-3.1f | Improvement: | %-3.1f|%n",
						m4Array.get(i), m3Array.get(i), m2Array.get(i), m1Array.get(i),
						Math.max(0, (m1Array.get(i) - m2Array.get(i))));
				System.out.printf("---------------------------------------------------------" +
						"-------------------------------------------------------------------" +
						"-----------------------------------------------------%n");
			}
			System.out.println(" ");

		return month;
		}

		public static void learnMore() {
			System.out.println("~~~~~~~~~~~~~~~~~~~~~");
			System.out.println("\nThe Balanced Living program is a goal-oriented system which aims to help people develop " +
					"\nconcrete goals they can then utilize as standards for progressing towards on a month-to-month basis.");
			System.out.println("\nThe scores a person ascribes to themselves each month will serve as indicators for what kinds of " +
					"\nalterations or adjustments they could make in their lives as time passes.");
			System.out.println("\nWhat makes this program unique is its focus on outcomes a person can work towards, rather than a " +
					"\nfocus on simply alleviating the symptoms of conditions such as traumatic stress disorder/etc. " +
					"\n\nCompelling evidence exists which suggests that goal-oriented strategies such as those utilized by the" +
					"\nBalanced Living program will lead to better outcomes for people who suffer with mental illness.");
		}

		public static int returnToMain(int returnUser) {
			Scanner in = new Scanner(System.in);

			while (returnUser != 1 && returnUser != 2) {
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("Would you like to return to the main menu?" +
						"\n\t1) Yes" +
						"\n\t2) No");

				returnUser = in.nextInt();
			}

				if (returnUser == 1)
					returnUser = 0;
				else
					returnUser = 5;

					return returnUser;
		}

}

class BalancedLiving {
	private static String loveStandard = null;
	private static String workStandard = null;
	private static String learningStandard = null;
	private static String playStandard = null;
	private static String healthStandard = null;
	private static String safetyStandard = null;
	
	BalancedLiving() {
		
	}
	
	public String getLoveStandard() {
		
		return loveStandard;
	}

	public void setLoveStandard(String loveStandard) {

		this.loveStandard = loveStandard;
	}

	public String getWorkStandard() {
		
		return workStandard;
	}

	public void setWorkStandard(String workStandard) {

		this.workStandard = workStandard;
	}
	
	public String getLearningStandard() {
		
		return learningStandard;
	}

	public void setLearningStandard(String learningStandard) {

		this.learningStandard = learningStandard;
	}
	
	public String getPlayStandard() {
		
		return playStandard;
	}

	public void setPlayStandard(String playStandard) {

		this.playStandard = playStandard;
	}
	
	public String getHealthStandard() {
		
		return healthStandard;
	}

	public void setHealthStandard(String healthStandard) {

		this.healthStandard = healthStandard;
	}
	
	public String getSafetyStandard() {
		
		return safetyStandard;
	}

	public void setSafetyStandard(String safetyStandard) {

		this.safetyStandard = safetyStandard;
	}
}


class MonthlyScore extends BalancedLiving {
	private double loveScore = 0;
	private double workScore = 0;
	private double learningScore = 0;
	private double playScore = 0;
	private double healthScore = 0;
	private double safetyScore = 0;
	
	MonthlyScore() {
		
	}
	
	MonthlyScore(double loveScore, double workScore, double learningScore, double playScore,
			double healthScore, double safetyScore) {
		this.loveScore = loveScore;
		this.workScore = workScore;
		this.learningScore = learningScore;
		this.playScore = playScore;
		this.healthScore = healthScore;
		this.safetyScore = safetyScore;
	}
	
	public double getLoveScore() {
		
		return loveScore;
	}
	
	public void setLoveScore(double loveScore) {
		
		this.loveScore = loveScore;
	}
	
	public double getWorkScore() {
		
		return workScore;
	}
	
	public void setWorkScore(double workScore) {
		
		this.workScore = workScore;
	}
	
	public double getLearningScore() {
		
		return learningScore;
	}
	
	public void setLearningScore(double learningScore) {
		
		this.learningScore = learningScore;
	}
	
	public double getPlayScore() {
		
		return playScore;
	}
	
	public void setPlayScore(double playScore) {
		
		this.playScore = playScore;
	}
	
	public double getHealthScore() {
		
		return healthScore;
	}
	
	public void setHealthScore(double healthScore) {
		
		this.healthScore = healthScore;
	}
	
	public double getSafetyScore() {
		
		return safetyScore;
	}
	
	public void setSafetyScore(double safetyScore) {
		
		this.safetyScore = safetyScore;
	}
}