/**
 * Author: Clint Davis
 * Date: 10/10/22
 *
 * This is my attempt at solving Exercise 20-03.
 */

import java.util.*;

public class Exercise20_03 {
        public static void main(String[] args) {
            String[][] stateCapital = {
                    {"Alabama", "Montgomery"},
                    {"Alaska", "Juneau"},
                    {"Arizona", "Phoenix"},
                    {"Arkansas", "Little Rock"},
                    {"California", "Sacramento"},
                    {"Colorado", "Denver"},
                    {"Connecticut", "Hartford"},
                    {"Delaware", "Dover"},
                    {"Florida", "Tallahassee"},
                    {"Georgia", "Atlanta"},
                    {"Hawaii", "Honolulu"},
                    {"Idaho", "Boise"},
                    {"Illinois", "Springfield"},
                    {"Indiana", "Indianapolis"},
                    {"Iowa", "Des Moines"},
                    {"Kansas", "Topeka"},
                    {"Kentucky", "Frankfort"},
                    {"Louisiana", "Baton Rouge"},
                    {"Maine", "Augusta"},
                    {"Maryland", "Annapolis"},
                    {"Massachusettes", "Boston"},
                    {"Michigan", "Lansing"},
                    {"Minnesota", "Saint Paul"},
                    {"Mississippi", "Jackson"},
                    {"Missouri", "Jefferson City"},
                    {"Montana", "Helena"},
                    {"Nebraska", "Lincoln"},
                    {"Nevada", "Carson City"},
                    {"New Hampshire", "Concord"},
                    {"New Jersey", "Trenton"},
                    {"New York", "Albany"},
                    {"New Mexico", "Santa Fe"},
                    {"North Carolina", "Raleigh"},
                    {"North Dakota", "Bismarck"},
                    {"Ohio", "Columbus"},
                    {"Oklahoma", "Oklahoma City"},
                    {"Oregon", "Salem"},
                    {"Pennsylvania", "Harrisburg"},
                    {"Rhode Island", "Providence"},
                    {"South Carolina", "Columbia"},
                    {"South Dakota", "Pierre"},
                    {"Tennessee", "Nashville"},
                    {"Texas", "Austin"},
                    {"Utah", "Salt Lake City"},
                    {"Vermont", "Montpelier"},
                    {"Virginia", "Richmond"},
                    {"Washington", "Olympia"},
                    {"West Virginia", "Charleston"},
                    {"Wisconsin", "Madison"},
                    {"Wyoming", "Cheyenne"}
            };
            Scanner input = new Scanner(System.in);

            List<String> states = new ArrayList<>();
            List<String> capitals = new ArrayList<>();

            for (int i = 0; i < stateCapital.length; i++) {
                states.add(stateCapital[i][0]);
                capitals.add(stateCapital[i][1]);
            }

            long seed = System.currentTimeMillis();
            Collections.shuffle(states, new Random(seed));
            Collections.shuffle(capitals, new Random(seed));

            int correctCount = 0;
            for (int i = 0; i < stateCapital.length; i++) {
                // Prompt the user with a question
                System.out.print("What is the capital of " + states.get(i) + "? ");
                String capital = input.nextLine().trim().toLowerCase();

                if (capital.toLowerCase().equals(capitals.get(i).toLowerCase())) {
                    System.out.println("Your answer is correct");
                    correctCount++;
                }
                else
                    System.out.println("The correct answer should be " + capitals.get(i));
            }
            System.out.println("The correct count is " + correctCount);
        }
}
