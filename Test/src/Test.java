
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        System.out.println(smallest("harman"));
        System.out.println(breakPalindrome("abccba"));
	}
	
	 static String smallest(String s) { 
		    
		    StringBuilder result = null; 
	        for (int i = 0; i < s.length()-1; i++) { 
	               if (s.charAt(i) > s.charAt(i + 1)) {
				/*
				 * result = new StringBuilder(); for (int j = 0; j < s.length(); j++) { if (i !=
				 * j) { result.append(s.charAt(j)); } }
				 */
	             result = new StringBuilder();
	             result.append(s.substring(0, i));
				 result.append(s.substring(i+1));
				 return result.toString(); 
	            } 
	        } 
	        result = new StringBuilder(s.substring(0, s.length() - 1)); 
	        return result.toString(); 
	    }
	 
	 public static String breakPalindrome(String palindrome) {
	        if (palindrome.length() == 1) return "";
	        for (int i = 0; i < palindrome.length() / 2; ++ i) {
	            if (palindrome.charAt(i) != 'a') {
	                return palindrome.substring(0, i) + 'a' +
	                    palindrome.substring(i + 1);
	            }
	        }
	        return palindrome.substring(0, palindrome.length() - 1) + 'b';
	    }

}
