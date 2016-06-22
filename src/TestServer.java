import java.io.IOException;

public class TestServer{
	public static final int BASE_PORT = 2000; 
	public static void main(String[] args) {
		try {
			Server s = new Server(BASE_PORT);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		try {
			Server.server_loop();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
