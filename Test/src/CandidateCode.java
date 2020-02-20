
import java.io.*;
import java.util.*;
public class CandidateCode {
    public static void main(String args[] ) throws Exception {
        
    	//Write code here
    	Scanner sc = new Scanner(System.in);
    	int t = 1;//sc.nextInt();
    	
      	while(t!=0) {
    		int numberOFTeam = 7;//sc.nextInt();
    		//System.out.println(numberOFTeam>>1);
    		int result = calculateNoOfMatches(numberOFTeam);
    		
    		System.out.println(result);
    		t--;
    	}
      	sc.close();
   }

	private static int calculateNoOfMatches(int numberOFTeam) {
		// TODO Auto-generated method stub
		int totalMatch = 0;
		while(numberOFTeam>>1!=0)
		{
			totalMatch+=(numberOFTeam>>1);
			int teamleft = numberOFTeam & 1;
			numberOFTeam = (numberOFTeam>>1)+teamleft;
		}
		return totalMatch;
	}
}
