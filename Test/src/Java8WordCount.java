import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Java8WordCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Path filePath = Paths.get("D:\\mywork\\Test\\res\\data.txt");
		try {
			Map<String,Long> wordCountMap = Files.readAllLines(filePath).stream().map(l->l.split(" ")).flatMap(Arrays::stream)
			.collect(Collectors.groupingBy(String::toString, Collectors.counting()));
			System.out.println(wordCountMap.get("AGM"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
