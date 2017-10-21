

public class TowerOfHanoi {
	static int nDisks = 5;

	public static void main(String[] args) {
		doTowers(nDisks, "Origin", "Temp", "Destination");
	}

	// -----------------------------------------------------------
	public static void doTowers(int numberOfDisks, String origin, String temp, String destination) {
		if (numberOfDisks == 1)
			System.out.println("Disk 1 from " + origin + " to " + destination);
		else {
			doTowers(numberOfDisks - 1, origin, destination, temp); // origin-->temp
			System.out.println("Disk " + numberOfDisks + " from " + origin + " to " + destination);
			doTowers(numberOfDisks - 1, temp, origin, destination); // temp-->dest
		}
	}
}