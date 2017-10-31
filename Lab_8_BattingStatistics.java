import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Timothy Johnson Grand Circus Lab 8: Batting Stastics 10/31/17
 *
 */

public class Lab_8_BattingStatistics {
	/**
	 * Will calculate batting average and slugging percentage for one or more
	 * baseball/softball players first ask for the number of at bats for each
	 * at-bat, ask the user for the number of bases earned by the batter after all
	 * of the at-bats are entered, display the batting average and slugging
	 * percentage of the batter
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean repeat = true;
		/*
		 * double battingAverage = 0.0; double sluggingPercentage = 0.0;
		 */
		ArrayList<Integer> battingData = new ArrayList<Integer>();// use array to store the at-bat results for each
																	// player

		while(repeat) {
		int numberOfAtBats = Validator.getInt(sc, "How many at-bats: ");
		// int numberOfBasesEarned = -1;

		System.out.println("0 = out, 1 = single, 2 = double, 3 = triple, 4 = home run");
		for (int i = 0; i < numberOfAtBats; i++) {
			battingData.add(Validator.getInt(sc, "Result for at-bat " + i + ": ", 0, 4));
		}
		
		// System.out.println("\nbattingData: "+ battingData);
		//System.out.println("battingData size: "+ battingData.size() + "\n");
		
		/*
		 * battingAverage = calculateBattingAverage(battingData); sluggingPercentage =
		 * calculateSluggingPercentage(battingData);
		 * 
		 * System.out.println("Batting average:" + battingAverage);
		 * System.out.println("Slugging Percentage:" + sluggingPercentage);
		 */

		System.out.print("\nBatting average:  "); System.out.printf("%.3f",calculateBattingAverage(battingData));
		System.out.print("\nSlugging Percentage: "); System.out.printf("%.3f",calculateSluggingPercentage(battingData));
		System.out.println("\n");

		// validate the input so that the user can only enter positive integers for the
		// at-bat results, the suer can only enter 0,1,2, 3, or 4
		// validate the users' response to the question "Another batter?" so that the
		// user can only enter "Y, y, N, or n". No or n, ends the program
		// format the batting average and slugging percentages such that three decimal
		// places are shown

		repeat = repeatYesNo(Validator.getString(sc, "\nAnother batter, yo? "));
		}
		sc.close();
	}

	/**
	 * @param battingData
	 */
	
	private static boolean repeatYesNo(String repeat) {
		if(repeat.equalsIgnoreCase("Y")) {
			return true;
		}
		
		return false;
	}
	private static double calculateSluggingPercentage(ArrayList<Integer> battingData) {
		//System.out.println("\ncalculateSluggingPercentage()...");
		
		double sluggingPercentage = 0.0;
		int totalBasesEarned = 0;
		
		for(int bats: battingData) {
			if(bats > 0 ) {
				totalBasesEarned += (int) bats;
				//System.out.println("totalBasesEarned: " + totalBasesEarned);
			}
			
		}
		
		//System.out.println("totalBasesEarned: " + totalBasesEarned);
		sluggingPercentage = (double) totalBasesEarned / battingData.size();
		
		return sluggingPercentage;
	}

	private static double calculateBattingAverage(ArrayList<Integer> battingData) {
		//System.out.println("\ncalculateBattingAverage()...");
		double battingAverage;
		int counter = 0;

		for (int bats : battingData) {
			if (bats > 0) {
				counter++;
				//System.out.println("counter: " + counter);
			}
		}
		
		battingAverage = (double) counter / battingData.size();
		
		//System.out.println("battingAverage: " + battingAverage);

		return battingAverage;
	}

}
