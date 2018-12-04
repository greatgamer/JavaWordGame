package petercampbell;

public class Main {

	public static void main(String[] args) {
		View viewer = new View();
		Controller control = new Controller(viewer);
		control.doStuff();

	}

}
