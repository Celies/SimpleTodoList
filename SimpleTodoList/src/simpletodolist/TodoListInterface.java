package simpletodolist;

/**
 * Interface for a Todo-list. Simple solution, not built out to cover every type of 
 * situation where you might need more functionality. 
 * 
 */
public interface TodoListInterface {
	/**
	 * Adds a row to the list. 
	 * @param newObject the new object to be added at the end of the list 
	 */
	public void addRow(Object newObject);
	/**
	 * Updates a row in the list with new data. 
	 * @param rowNumber the row to the updated. The old data will be written over 
	 * @param newObject the new data that will write over the previous one
	 */
	public void updateRow(int rowNumber, Object newObject);
	/**
	 * Removes a row from the list. All rows after it will be moved up one row. 
	 * @param rowNumber the row to be deleted
	 */
	public void removeRow(int rowNumber);
	/**
	 * A getter for a specific row. 
	 * @param rowNumber the row to be returned
	 * @return the row data as an Object
	 */
	public Object getRow(int rowNumber);
	/**
	 * A getter for the whole list. 
	 * @return the whole list as an Object array
	 */
	public Object[] getList();
	/**
	 * A getter for the length of the list. 
	 * @return the ammount of rows in the list as an integer
	 */
	public int getLength();
}
