import java.io.File;
import java.util.Scanner;

public class Ballot {
	
	int BallotID;
	String IDString = " ";
	List<String> votes = new ArrayList<String>(10);
//	Scanner sc = new Scanner(new File("ballots.csv"));
//	String Bstr = sc.nextLine();
	public Ballot(String Bstr) {
		for (int i = 0; i < Bstr.length(); i++) {
			if(i < Bstr.indexOf(",")) 
				IDString = IDString + Bstr.charAt(i);
			if(i == Bstr.indexOf(":"))
				//Check for the ":" in "rank:candidateID" and make the rank the position we add the canditate
				votes.add(Integer.parseInt(String.valueOf(Bstr.charAt(i+1))), String.valueOf(Bstr.charAt(i-1)));
		}
		BallotID = Integer.parseInt(IDString);

	}
	
	public int getBallotNum() {
		return BallotID;
	}
	public int getFirstChoice() {
		return Integer.parseInt(votes.get(0));
	}
	public int getRankbyCandidate(int candidateID) {
		for (int i = 0; i < votes.size(); i++) {
			if(Integer.parseInt(votes.get(i)) == candidateID)//the rank is the position of the candidate in the array
				return i+1;//add one because array starts at 0 and the ranks at 1
		}
		return 0;
	}
	public int getCandidatebyRank(int rank) {
		return Integer.parseInt(votes.get(rank));
	}
	public boolean eliminate(int candidateID) {
		for (int i = 0; i < votes.size(); i++) {
			if(candidateID == Integer.parseInt(votes.get(i))) {
				votes.remove(i);
				return true;
			}
				
		}
		return false;
	}
//	public boolean validateBallot(Ballot B) {
//		
//		return false;
//	}
	
		

}
