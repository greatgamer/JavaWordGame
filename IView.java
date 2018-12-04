package petercampbell;

public interface IView {

	public String getUserInput(String prompt);
	public <T> void say(T data);
}
