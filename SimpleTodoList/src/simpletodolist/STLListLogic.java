package simpletodolist;
/**
 * A class that connects the GUI with the TodoList class and handles all the data 
 * moving between them. 
 *
 */
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class STLListLogic {
	private TodoListImpl list;
	
	public STLListLogic() {
		list = new TodoListImpl();
	}
	
	public void addRowAsText(String newRow) {
		list.addRow(newRow);
	}
	public boolean addRowFromURL(String url) {
		
		HttpRequest request = null;
		HttpResponse<String> response = null;
		boolean success = true;
		
		try {
			request = HttpRequest.newBuilder()
					  .uri(new URI(url))
					  .GET()
					  .build();
		} catch (URISyntaxException e1) {
			success = false;
			e1.printStackTrace();
		}
		HttpClient client = HttpClient.newHttpClient();
		try {
			response = client.send(request, BodyHandlers.ofString());
		} catch (IOException e) {
			success = false;
			e.printStackTrace();
		} catch (InterruptedException e) {
			success = false;
			e.printStackTrace();
		}
		
		list.addRow(response.body());
		
		return success;
	}
	public void updateRow(int rowNumber, String newText) {
		list.updateRow(rowNumber, newText);
	}
	public void removeRow(int rowNumber) {
		list.removeRow(rowNumber);
	}
	public String getListAsString() {
		Object[] listData = list.getList();
		int nrOfObjects = list.getLength();
		StringBuilder convertedList = new StringBuilder();
		int convertedRowNr = 0;
		
		for(int i = 0; i < nrOfObjects; i++) {
			convertedRowNr = i + 1;
			convertedList.append(
					convertedRowNr 
					+ ". " 
					+ listData[i].toString() 
					+ STLConstants.newLine
					);
		}
		
		return convertedList.toString();
	}
	public int getNrOfRows() {
		return list.getLength();
	}
}
