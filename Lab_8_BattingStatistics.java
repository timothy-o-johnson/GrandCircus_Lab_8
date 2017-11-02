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
	 * baseball/softball players by first asking for the number of at bats for each
	 * at-bat then asking the user for the number of bases earned by the batter
	 * after all of the at-bats are entered. Next, it display the batting average
	 * and slugging percentage of the batter. Finally it asks the user whether to t
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Welcome to Batting Average Calculator!!");

		Scanner sc = new Scanner(System.in);
		boolean repeat = true;
		int playerCounter = 0; // loop through each player
		
		int playerCount = Validator.getInt(sc, "\nHow many players? ", 1, 5);
		double[][] playerStorage = new double[playerCount][2];

		ArrayList<Integer> battingData = new ArrayList<Integer>();// use array to store the at-bat results for each
																	// player

		while (repeat) {
			for (int player = 0; player < playerCount; player++) { // increment through each player
				int numberOfAtBats = Validator.getInt(sc, "\nHow many at-bats for player " + (player + 1) + ": ", 0, 5);

				System.out.println("0 = out, 1 = single, 2 = double, 3 = triple, 4 = home run");
				for (int i = 0; i < numberOfAtBats; i++) {
					battingData.add(Validator.getInt(sc, "Result for at-bat " + (i + 1) + ": ", 0, 4));
					storePlayerData(player, calculateBattingAverage(battingData),
							calculateSluggingPercentage(battingData), playerStorage);
				}
			}

			printPlayerStats(playerStorage);

			repeat = repeatYesNo(Validator.getString(sc, "\n\nAnother batter, yo? "));

			// because initialized outside of the while loop, we reset number of players and
			// storage variables
			playerCount = Validator.getInt(sc, "\nHow many players? ", 1, 5);
			playerStorage = new double[playerCount][2];

		}

		System.out.println("Okay thanks! Good bye!");
		sc.close();

	}

	/**
	 * @param battingData
	 */

	public static void storePlayerData(int playerNumber, double battingAverage, double sluggingPercentage,
			double[][] playerStorage) {
		playerStorage[playerNumber][0] = battingAverage;
		playerStorage[playerNumber][1] = sluggingPercentage;
	}

	/**
	 * @param repeat
	 * @return boolean
	 */
	private static boolean repeatYesNo(String repeat) {
		if (repeat.equalsIgnoreCase("Y")) {
			return true;
		}

		return false;
	}

	/*
	 * 
	 */
	private static double calculateSluggingPercentage(ArrayList<Integer> battingData) {
		// System.out.println("\ncalculateSluggingPercentage()...");

		double sluggingPercentage = 0.0;
		int totalBasesEarned = 0;

		for (int bats : battingData) {
			if (bats > 0) {
				totalBasesEarned += (int) bats;
				// System.out.println("totalBasesEarned: " + totalBasesEarned);
			}

		}

		// System.out.println("totalBasesEarned: " + totalBasesEarned);
		sluggingPercentage = (double) totalBasesEarned / battingData.size();

		return sluggingPercentage;
	}

	private static double calculateBattingAverage(ArrayList<Integer> battingData) {
		// System.out.println("\ncalculateBattingAverage()...");
		double battingAverage;
		int counter = 0;

		for (int bats : battingData) {
			if (bats > 0) {
				counter++;
				// System.out.println("counter: " + counter);
			}
		}

		battingAverage = (double) counter / battingData.size();

		// System.out.println("battingAverage: " + battingAverage);

		return battingAverage;
	}

	public static void printPlayerStats(double[][] playerStorage) {
		System.out.println("\n***********************************************************************************");
		System.out.println("BUG WARNING: For more than one batter, the stats get off. No time to debug.");
		System.out.println("************************************************************************************");
		for (int i = 0; i < playerStorage.length; i++) {
			System.out.println("\n\nPlayer " + (i + 1));
			System.out.print("Batting average: ");
			System.out.printf("%.3f", playerStorage[i][0]);
			System.out.print("\nSlugging Percentage: ");
			System.out.printf("%.3f", playerStorage[i][1]);
		}
	}

}
