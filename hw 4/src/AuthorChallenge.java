import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.io.*;


public class AuthorChallenge {
	public static void main(String[] args) throws FileNotFoundException {
		StreeSet bstSet = new StreeSet();
		AVLStreeSet avlSet = new AVLStreeSet();

		ArrayList<String> words = getWords();
		ArrayList<String> bookWords = getBookWords();

		long timeToBuildBST = buildSet(bstSet, bookWords);
		System.out.printf("BST Set build time: %dms\n", timeToBuildBST / 1000000);
		//System.out.print(bstSet);

		long timeToBuildAVL = buildSet(avlSet, bookWords);
		System.out.printf("AVL Set build time: %dms\n", timeToBuildAVL / 1000000);	
		//System.out.print(avlSet);

		reportSearchBSTSet(bstSet, words);
		reportSearchAVLSet(avlSet, words);
	}

	private static long buildSet(StringSet set, ArrayList<String> values) {
		long startTime;
		startTime = System.nanoTime(); 		

		for (String value : values) {
			set.add(value);
		}

		return System.nanoTime() - startTime;  
	}

	private static ArrayList<String> getBookWords() throws FileNotFoundException {
		ArrayList<String> bookWords = new ArrayList<String>();
		Pattern p = Pattern.compile("[^\\w]");

		Scanner input = new Scanner(System.in);
		System.out.print("Enter book file: ");
		Scanner bookScanner = new Scanner(new File(input.nextLine()));

		while (bookScanner.hasNext()) {
			String nextWord = bookScanner.next().toLowerCase();

			if (p.matcher(nextWord).find()) {
				String[] nextWords = p.split(nextWord);

				for (String word : nextWords) {
					word.intern();
					bookWords.add(word);
				}
			} else {
				nextWord.intern();
				bookWords.add(nextWord);
			}
		}

		return bookWords;
	}


	private static ArrayList<String> getWords() throws FileNotFoundException {
		Scanner input = new Scanner(System.in);
		System.out.print("Use (S)mall or (L)arge dictionary? ");

		Scanner dictScanner = input.nextLine().toLowerCase().startsWith("s") 
				? new Scanner(new File("wordsEn_small.txt")) 
				: new Scanner(new File("wordsEn.txt"));	

		ArrayList<String> words = new ArrayList<String>();
		while (dictScanner.hasNext()) {
			words.add(dictScanner.next().toLowerCase().intern());
		}

		return words;
	}

	private static void reportSearchAVLSet(AVLStreeSet set, ArrayList<String> values) {
		long startTime = System.nanoTime();
		double percentUsed = searchSet(set, values);
		long time = (System.nanoTime() - startTime) / 1000000;

		System.out.printf("AVL Set search time: %dms (%.2f%% of the words are used)\n", time, percentUsed);  		
	}	

	private static void reportSearchBSTSet(StreeSet set, ArrayList<String> values)  {
		long startTime = System.nanoTime();
		double percentUsed = searchSet(set, values);
		long time = (System.nanoTime() - startTime) / 1000000;

		System.out.printf("BST Set search time: %dms (%.2f%% of the words are used)\n", time, percentUsed);  		
	}

	private static double searchSet(StreeSet set, ArrayList<String> values) {
		int count = 0;

		for (String value : values) {
			if (set.contains(value)) {
				count++;
			}
		}

		return count * 1.0 / values.size() * 100;		
	}
}

/*
	Welcome to Author Challenge!

	Use (S)mall or (L)arge dictionary? l
	Enter the book file: ulysses.txt
	BST Set build time: 190ms
	AVL Set build time: 341ms
	BST Set search time: 58ms (19.16% of the words are used)
	AVL Set search time: 45ms (19.16% of the words are used)
 */

