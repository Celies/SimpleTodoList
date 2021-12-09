package simpletodolist;
/**
 * Implementation of TodoListInterface. 
 * 
 */
import java.util.ArrayList;
import java.util.List;

public class TodoListImpl implements TodoListInterface {
	
	private List<Object> list;
	
	public TodoListImpl() 
	{
		list = new ArrayList<Object>();
	}

	@Override
	public void addRow(Object newObject) {
		list.add(newObject);
	}

	@Override
	public void updateRow(int rowNumber, Object newObject) {
		list.set(rowNumber, newObject);
	}

	@Override
	public void removeRow(int rowNumber) {
		list.remove(rowNumber);
	}

	@Override
	public Object getRow(int rowNumber) {
		return list.get(rowNumber);
		
	}

	@Override
	public Object[] getList() {
		return list.toArray();
		
	}

	@Override
	public int getLength() {
		return list.size();
	}
}
