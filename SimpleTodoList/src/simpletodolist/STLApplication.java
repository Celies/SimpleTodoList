package simpletodolist;
/**
 * Application start. 
 * 
 * @author Viktor Svensson
 *
 */
import java.io.IOException;

public class STLApplication {

	public static void main(String[] args) throws IOException {
		STLGUI gui = new STLGUI();
		gui.startGUI();
	}

}
