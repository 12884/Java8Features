/**
 * 
 */
package com.cerence.assignment;

import com.cerence.assignment.solution.IWordPairFinder;
import com.cerence.assignment.solution.SolutionOneWordPairFinder;
import com.cerence.assignment.solution.SolutionTwoWordPairFinder;

/**
 * @author mukesh
 *
 */
public class MainApplication {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int wordLength = 6;
		IWordPairFinder wordPairFinder;
		long startTms = System.currentTimeMillis();
		wordPairFinder = new SolutionOneWordPairFinder(wordLength);
		//wordPairFinder = new SolutionTwoWordPairFinder(wordLength);
		wordPairFinder.findAll().forEach(System.out::println);
		System.out.println(System.currentTimeMillis()-startTms);
	}

}
