import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.IntStream;

interface Interface1WithDefault{
	public static String function() {
		return "I am in Interface1WithDefault";
	}
}

interface Interface2WithDefault{
	public static String function() {
		return "I am in Interface2WithDefault";
	}
}
public class Java8Interface implements Interface1WithDefault,Interface2WithDefault {

	public static void main(String[] args) {
		listAllPrime(100);
	}
	
	public static void listAllPrime(int N) {
		IntStream primeStream = IntStream.range(1, N).filter(Java8Interface::isPrime);
		primeStream.forEach(System.out::println);
		int sum = IntStream.range(1, N).sum();
		System.out.println(sum);
		OptionalDouble avg = IntStream.range(1, N).average();
		if(avg.isPresent())
			System.out.println(avg.getAsDouble());
	}
	
	public static boolean isPrime(int n) {
	   for(int i=2;i<n/2;i++) {
		   if(n%i==0)
			   return false;
	   }	   
		return true;
	}

}
