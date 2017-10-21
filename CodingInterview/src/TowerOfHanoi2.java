

public class TowerOfHanoi2 {

	public void toh(int noOfDisks, String T1,String T2,String T3){
		if(noOfDisks ==1){
			System.out.println("Moving "+noOfDisks+" from "+T1+" To "+T3);
		}
		toh(noOfDisks-1, T1,T2,T3);
		System.out.println("Moving "+noOfDisks+" from "+T1+" To "+T3);
	}
}
