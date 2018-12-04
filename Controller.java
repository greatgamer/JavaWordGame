package petercampbell;

public class Controller {

	private GuessWord game;
	private View viewer;
	
	public Controller(View view) {
		viewer = view;
		game = new GuessWord();
		
	}
	public void doStuff() {
		viewer.say("Welcome to the word game.");
		viewer.say("The secret word has " + game.numLetters + " letters.");
		int counter = 0;
		while(!game.hasWon()){
			viewer.say("\n"+ game.userWord +"\n");
			String guess = viewer.getUserInput("Guess the word or enter a letter");
			if (guess.length() == 1) {
				game.guessLetter(guess);
			} else {
				game.guessWord(guess);
			}
			counter ++;
		}
		viewer.say("Well done! You won. The word was " + game.userWord + ". It took you " + counter + " goes!");
	}

}
