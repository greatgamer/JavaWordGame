package petercampbell;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class GuessWord{
	private String secretWord;
	public String userWord;
	public int numLetters;
	
	public GuessWord() {
		secretWord = chooseWordFromFile();
		if (secretWord == null) {chooseWord();}
		numLetters = getNumberOfLetters();
		userWord = createUserWord();
	}
	
	public boolean hasWon() {
		return userWord.equalsIgnoreCase(secretWord);
	}
	
	public boolean guessWord(String guess) {
		if(guess.equalsIgnoreCase(secretWord)) {
			userWord = guess;
			return true;
		}
		return false;
	}
	

	public String guessLetter(String letter) {
		char guess = letter.charAt(0);
		String word = "";
		String workingString = userWord;
		for(int i = 0; i < secretWord.length(); i ++) {
			if(workingString.charAt(i) != '*') {
				word += workingString.charAt(i);
			} else if (secretWord.charAt(i) == guess) {
				word += guess;
			}else {
				word += '*';
			}
		}
		userWord = word;
		return word;
	}

	private String chooseWord() {
		int random = (int )(Math.random() * 20 + 1);
		String [] wordArr = {
				"abnormal",
				"knowing",
				"roof",
				"discovery",
				"example",
				"quilt",
				"boorish",
				"steadfast",
				"request",
				"cream",
				"smoke",
				"pushy",
				"ray",
				"clap",
				"wing",
				"responsible",
				"careless",
				"beds",
				"snakes",
				"mend"	
		};
		return wordArr[random];
	}
	public String chooseWordFromFile() {
		ArrayList<String> wordList = new ArrayList<String>();
		String inputStr;
		int counter = 0;
		try {
			BufferedReader br = new BufferedReader(new FileReader("words.txt"));
			while( (inputStr = br.readLine()) != null) {
				inputStr = inputStr.trim();
				if (inputStr != "") {
					wordList.add(inputStr);
					counter ++;
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.out.println("Could not find the required file. Game could not load");
			return null;
		}catch (IOException e) {
			System.out.println("Problem reading current files. Game could not load");
			return null;
		}catch (NullPointerException e) {
			System.out.println("Problem reading current files. Game could not load");
			return null;
		}
		
		int random = (int )(Math.random() * counter + 1);
		return wordList.get(random);
	}

	
	
	
	private int getNumberOfLetters() {
		return secretWord.length();
	}
	
	private String createUserWord() {
		String word ="";
		for(int i =0; i < secretWord.length(); i++ ) {
			word += "*";
		}
		return word;
	}
	
}
