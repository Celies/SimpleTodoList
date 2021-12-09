package simpletodolist;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TodoListImplTest {
	TodoListImpl list;
	
	@BeforeEach
	void init() {
		list = new TodoListImpl();
	}
	@Test
	void testAddRow() {
		String testString = new String("test");
		list.addRow(testString);
		assert(list.getLength() == 1);
		assert(list.getRow(0).toString().equals("test"));
	}
	
	@Test
	void testUpdateRow() {
		String fromString = new String("Before");
		String toString = new String("After");
		list.addRow(fromString);
		list.updateRow(0, toString);
		assert(list.getLength() == 1);
		assert(list.getRow(0).toString().equals("After"));
	}
	
	@Test
	void testRemoveRow() {
		String testString = new String("test");
		list.addRow(testString);
		list.removeRow(0);
		assert(list.getLength() == 0);
	}
	
	@Test
	void testGetList() {
		String testString = new String("test");
		list.addRow(testString);
		list.addRow(testString);
		list.addRow(testString);
		Object[] testList = list.getList();
		assert(testList.length == 3);
		assert(testList[0].toString().equals("test"));
		assert(testList[1].toString().equals("test"));
		assert(testList[2].toString().equals("test"));
	}
}
