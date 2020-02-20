/**
 * 
 */
package com.cerence.assignment.solution;

/**
 * @author mukesh
 *
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

import com.cerence.assignment.constants.Constants;

/**
 * @author mukesh
 * In this solution parllelStream is used for the faster execution when more cores are available.
 * Performance improvement can be measured when input size is very large. 
 */
public class SolutionTwoWordPairFinder implements IWordPairFinder {

	private int wordLen;
	
	private Set<String> wordDictionary = null;

	private List<String> output = null;

	public SolutionTwoWordPairFinder(int wordLen) {
		super();
		this.wordLen = wordLen;
		loadFileData();
	}
	private void loadFileData() {
		try {
			 wordDictionary = Files.lines(Paths.get(Constants.FILE_PATH)).parallel().filter(this::wordLengthFilter)
					.collect(Collectors.toSet());
		} catch (IOException e) {
			wordDictionary = null;
			e.printStackTrace();
		}
	}

	private boolean wordLengthFilter(String word) {
		return word.length() <= wordLen ? true : false;
	}

	private void findPairMatch(String word) {
		for (int i = 1; i < word.length() - 1; i++) {
			String first = word.substring(0, i);
			String second = word.substring(i);
			if (wordDictionary.contains(first) && wordDictionary.contains(second)) {
				StringBuffer resultString = new StringBuffer();
				resultString.append(first);
				resultString.append(Constants.PLUS_SIGN);
				resultString.append(second);
				resultString.append(Constants.CONCATENATOR);
				resultString.append(word);
				output.add(resultString.toString());
			}

		}
	}

	@Override
	public List<String> findAll() {
		if (wordDictionary.isEmpty())
			return null;
		output = new CopyOnWriteArrayList<>();
		wordDictionary.parallelStream().filter(word -> word.length() == wordLen).forEach(this::findPairMatch);
		return output;
	}

	@Override
	public List<String> find(String word) {
		output = new ArrayList<String>();
		findPairMatch(word);
		return output;
	}

}
