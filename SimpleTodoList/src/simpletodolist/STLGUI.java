package simpletodolist;
/**
 * Builds the Java Swing GUI and sets up ActionListeners for the buttons. 
 *
 */
import javax.swing.*;
import java.awt.event.*;

public class STLGUI implements ActionListener {
	private JFrame frame;
	private JPanel addPanel;
	private JPanel addTextFieldPanel;
	private JPanel updatePanel;
	private JPanel updateTextFieldPanel;
	private JPanel removePanel;
	private JPanel listPanel;
	private JTextArea listTextArea;
	private JTextField addRowTextField;
	private JButton addRowButton;
	private JButton addResolveButton;
	private JComboBox<Integer> updateRowNumberComboBox;
    private JTextField updateRowDataTextField;
    private JButton updateRowButton;
    private JComboBox<Integer> removeRowNumberComboBox;
    private JButton removeRowButton;
	
	private STLListLogic listLogic;
	
	public STLGUI() {
		listLogic = new STLListLogic();
	}
	public void startGUI() {
		frame = new JFrame(STLConstants.c_GUITitle);
		frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.PAGE_AXIS));
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(400, 500);
	    
		addPanel = new JPanel();
		addTextFieldPanel = new JPanel();
		updatePanel = new JPanel();
		updateTextFieldPanel = new JPanel();
		removePanel = new JPanel();
		listPanel = new JPanel();

	    listTextArea = new JTextArea(STLConstants.c_EmptyList, 15, 30);
	    JScrollPane scroll = new JScrollPane (listTextArea);
	    scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	    listTextArea.setLineWrap(true);
	    listTextArea.setWrapStyleWord(true);
	    listTextArea.setEditable(false);
	    
	    listPanel.add(scroll);
        
        addRowTextField = new JTextField(30);
        addRowButton = new JButton(STLConstants.c_AddAsTextButton);
        addResolveButton = new JButton(STLConstants.c_AddAsURLButton);
        addTextFieldPanel.add(addRowTextField);
        addPanel.add(addRowButton);
        addPanel.add(addResolveButton);
        
        updateRowNumberComboBox = new JComboBox<Integer>();
        updateRowDataTextField = new JTextField(30);
        updateRowButton = new JButton(STLConstants.c_UpdateButton);
        updatePanel.add(updateRowNumberComboBox);
        updateTextFieldPanel.add(updateRowDataTextField);
        updatePanel.add(updateRowButton);
        
        removeRowNumberComboBox = new JComboBox<Integer>();
        removeRowButton = new JButton(STLConstants.c_RemoveButton);
        removePanel.add(removeRowNumberComboBox);
        removePanel.add(removeRowButton);
        
        frame.add(listPanel);
        frame.add(addTextFieldPanel);
        frame.add(addPanel);
        frame.add(updateTextFieldPanel);
        frame.add(updatePanel);
        frame.add(removePanel);
        
        addRowButton.addActionListener(this);
        addResolveButton.addActionListener(this);
        updateRowButton.addActionListener(this);
        removeRowButton.addActionListener(this);

        frame.pack();
        frame.setVisible(true);
	}
	
	public void updateList() {
		if(listLogic.getNrOfRows() == 0) {
			listTextArea.setText(STLConstants.c_EmptyList);
		}
		else {
			listTextArea.setText(listLogic.getListAsString());
		}
	}
	public void actionPerformed(ActionEvent e) {
        if(e.getSource() == addRowButton) {
        	if(addRowTextField.getText() != "") {
        		listLogic.addRowAsText(addRowTextField.getText());
        		updateRowNumberComboBox.addItem(listLogic.getNrOfRows());
        		removeRowNumberComboBox.addItem(listLogic.getNrOfRows());
        	}
        }
        else if (e.getSource() == addResolveButton) {
        	if(addRowTextField.getText() != "") {
        		if(listLogic.addRowFromURL(addRowTextField.getText())) {
        			updateRowNumberComboBox.addItem(listLogic.getNrOfRows());
            		removeRowNumberComboBox.addItem(listLogic.getNrOfRows());
        		}
        	}
        }
        else if (e.getSource() == updateRowButton) {
        	if(addRowTextField.getText() != "") {
        		listLogic.updateRow(updateRowNumberComboBox.getSelectedIndex(), 
        							updateRowDataTextField.getText());
        	}
        }
        else if (e.getSource() == removeRowButton) {
        	listLogic.removeRow(removeRowNumberComboBox.getSelectedIndex());
        	updateRowNumberComboBox.removeItem(listLogic.getNrOfRows() + 1);
    		removeRowNumberComboBox.removeItem(listLogic.getNrOfRows() + 1);
        }
        
        updateList();
	}
}
