package petercampbell;

import java.util.Scanner;

public class View implements IView {
	private Scanner in;
	
	@Override
	public String getUserInput(String prompt) {
		in = new Scanner(System.in);
		System.out.print(prompt + ">> ");
		String input = in.nextLine();
		//in.close();
		return input;
	}

	@Override
	public <T> void say(T data) {
		System.out.println(data);
	}

}
