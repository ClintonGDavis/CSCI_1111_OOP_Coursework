/**
 * Author: Clint Davis
 * Date: 10/18/22
 *
 * This is my attempt at solving Exercise 21-09.
 */

import java.util.*;
import java.util.stream.Collectors;

public class Exercise21_09 {
  public static void main(String[] args) {
    final String[][] stateCapital = {
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

    Map<String, String> map = Arrays.stream(stateCapital).collect(Collectors.toMap(e -> e[0].toLowerCase(), e -> e[1]));

    Scanner input = new Scanner(System.in);

    for (Map.Entry<String, String> e : map.entrySet()) {
      System.out.print("Please enter a state: ");
      String state = input.nextLine().trim().toLowerCase();

        map.forEach((k, v) -> k.compareTo(state));
        {
          System.out.println("The capital of " + state + " is: " + map.get(state) + ("\n"));
          if (map.get(state) == null)
            System.out.println("---Make sure to enter a correctly spelled state next time!---\n");
        }
      }
    }
  }