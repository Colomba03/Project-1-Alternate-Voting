
import java.io.File;
import java.util.Scanner;


public class Election {
	public static void main(String[] args){
		int rank;
		List<String> CandidateNames = new ArrayList<String>(10);// list with names of candidates 
		List<Integer> candidateID = new ArrayList<Integer>(10);//the size() function serves to know number of candidates
		Boolean Winner = false; 
		Scanner scC = new Scanner(new File("/res/candidates.csv"));{
		while(scC.hasNext()) {
			String Cstr = scC.nextLine();
			for (int i = 0; i < Cstr.length(); i++) {
				String Name = "";
				String ID = "";
				if(i<Cstr.indexOf(","))
					Name = Name + Cstr.charAt(i);
				CandidateNames.add(Name);
				if(i>Cstr.indexOf(","))
					ID = ID + Cstr.charAt(i);
				candidateID.add(Integer.parseInt(ID));		
			}
		}
		scC.close();
		List<Set<Ballot>> Candidates = new ArrayList<Set<Ballot>>(candidateID.size());
		Set<Integer> eliminated = new StaticSet<Integer>(candidateID.size());
		Scanner sc = new Scanner(new File("ballots.csv"));
		for (int i = 0; i < candidateID.size(); i++) {
			Set<Ballot> CandBallots = new StaticSet<Ballot>(10);
			while(sc.hasNext()) {
				String Bstr = sc.nextLine();
				Ballot B = new Ballot(Bstr);
				if(B.getFirstChoice() == candidateID.get(i))
					CandBallots.add(B);
			}
			Candidates.add(CandBallots);
		}
		sc.close();
		int Rounds = 0;
		int top1s = 0;
		int min1s = 0;
		int numOf1s = 0;
		int x = 0;
		while(!Winner) {
			for (Set<Ballot> candidate : Candidates) {
				for(Ballot B : candidate) {
					if(B.getFirstChoice() == candidateID.get(x))
						numOf1s++;				
				}
				if(numOf1s > top1s) top1s = numOf1s;
				if(numOf1s < min1s) min1s = numOf1s;
			}
			Rounds++;
		}

	}
	}
	
}


