/**
 * 
 */
package com.cerence.assignment.solution;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.cerence.assignment.constants.Constants;

/**
 * @author mukesh
 *
 */
public class SolutionOneWordPairFinder implements IWordPairFinder {

	private int wordLen;
	private Path inputFilePath;
	
	private Set<String> wordDictionary = null;
	
	private List<String> result=null;
	
	public SolutionOneWordPairFinder(int wordLen) {
		super();
		this.wordLen = wordLen;
		loadFileData();
	}
	
	private void loadFileData(){
		try {
			inputFilePath = Paths.get(Constants.FILE_PATH);
			wordDictionary = Files.readAllLines(inputFilePath).stream().filter(this::wordLengthFilter)
					.collect(Collectors.toSet());
		} catch (IOException e) {
			wordDictionary = null;
			e.printStackTrace();
		}
	}
	
	private boolean wordLengthFilter(String word) {
		return word.length()<=wordLen ?true:false;
	}
	
	private void findPairMatch(String word) {
		for(int i=1;i<word.length()-1;i++) {
			String first = word.substring(0, i);
			String second = word.substring(i);
			if(wordDictionary.contains(first) && wordDictionary.contains(second)) {
				StringBuilder resultString = new StringBuilder();
				resultString.append(first);
				resultString.append(Constants.PLUS_SIGN);
				resultString.append(second);
				resultString.append(Constants.CONCATENATOR);
               	resultString.append(word);
               	result.add(resultString.toString());
			}
		}
	}

	@Override
	public List<String> findAll() {
		if(wordDictionary.isEmpty())
			return null;
		result = new LinkedList<String>();
		wordDictionary.stream().filter(word->word.length()==wordLen).forEach(this::findPairMatch);
		return result;
	}

	@Override
	public List<String> find(String word) {
		result = new ArrayList<String>();
		findPairMatch(word);
		return result;
	}

}
