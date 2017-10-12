package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import beans.CRMBean;
import main.CRMMain;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public abstract class CRMView extends JFrame {

	private static final long serialVersionUID = 1L;

	private JPanel rootPane;
	private JPanel centerPanel;

	// Dynamic Labels
	JLabel indexCountLabel;
	JLabel messagesLabel;

	private boolean editMode = false;

	private MouseAdapter leftAdapter;
	private MouseAdapter rightAdapter;
	private MouseAdapter editAdapter;
	private MouseAdapter addAdapter;
	private MouseAdapter deleteAdapter;
	private MouseAdapter saveAdapter;
	private MouseAdapter cancelAdapter;

	private JButton leftButton;
	private JButton rightButton;
	private JButton editButton;
	private JButton addButton;
	private JButton deleteButton;
	private JButton saveButton;
	private JButton cancelButton;
	private JComboBox moduleComboBox;
	private JLabel tinyCRMLabel;

	public CRMView() {
		setTitle("TinyCRM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 633, 450);
		rootPane = new JPanel();
		rootPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(rootPane);
		rootPane.setLayout(new BorderLayout(0, 0));

		JPanel topPanel = new JPanel();
		rootPane.add(topPanel, BorderLayout.NORTH);
		topPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		tinyCRMLabel = new JLabel("");
		tinyCRMLabel.setMaximumSize(new Dimension(57, 16));
		tinyCRMLabel.setIcon(new ImageIcon(CRMView.class.getResource("/images/TinyCRMLogo.png")));
		tinyCRMLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		tinyCRMLabel.setForeground(new Color(0, 128, 0));
		topPanel.add(tinyCRMLabel);

		moduleComboBox = new JComboBox<String>();
		topPanel.add(moduleComboBox);
		
		messagesLabel = new JLabel("This is the messages label");
		messagesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		messagesLabel.setPreferredSize(new Dimension(400, 16));
		messagesLabel.setMinimumSize(new Dimension(300, 16));
		messagesLabel.setMaximumSize(new Dimension(300, 16));
		messagesLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		messagesLabel.setForeground(Color.RED);
		topPanel.add(messagesLabel);

		JPanel panel = new JPanel();
		rootPane.add(panel, BorderLayout.CENTER);

		JPanel bottomPanel = new JPanel();
		rootPane.add(bottomPanel, BorderLayout.SOUTH);
		bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		leftButton = new JButton("Left");
		bottomPanel.add(leftButton);

		rightButton = new JButton("Right");
		bottomPanel.add(rightButton);

		editButton = new JButton("Edit");
		bottomPanel.add(editButton);

		addButton = new JButton("Add");
		bottomPanel.add(addButton);

		deleteButton = new JButton("Delete");
		bottomPanel.add(deleteButton);

		saveButton = new JButton("Save");
		bottomPanel.add(saveButton);

		cancelButton = new JButton("Cancel");
		bottomPanel.add(cancelButton);

		indexCountLabel = new JLabel("0/0");
		indexCountLabel.setForeground(Color.RED);
		bottomPanel.add(indexCountLabel);

		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		rootPane.add(horizontalStrut_2, BorderLayout.WEST);

		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		rootPane.add(horizontalStrut_3, BorderLayout.EAST);
	}

	public JPanel getCenterPanel() {
		return centerPanel;
	}

	public void setCenterPanel(JPanel centerPanel) {
		this.centerPanel = centerPanel;
		getContentPane().add(centerPanel, BorderLayout.CENTER);
	}

	public JLabel getIndexCountLabel() {
		return indexCountLabel;
	}

	public void setIndexCountLabel(JLabel indexCountLabel) {
		this.indexCountLabel = indexCountLabel;
	}

	public String getMessagesLabel() {
		return messagesLabel.getText();
	}

	public void setMessagesLabel(String text) {
		this.messagesLabel.setText(text);
	}

	public MouseAdapter getLeftAdapter() {
		return leftAdapter;
	}

	public void setLeftAdapter(MouseAdapter leftAdapter) {
		leftButton.addMouseListener(leftAdapter);
		this.leftAdapter = leftAdapter;
	}

	public MouseAdapter getRightAdapter() {
		return rightAdapter;
	}

	public void setRightAdapter(MouseAdapter rightAdapter) {
		rightButton.addMouseListener(rightAdapter);
		this.rightAdapter = rightAdapter;
	}

	public MouseAdapter getEditAdapter() {
		return editAdapter;
	}

	public void setEditAdapter(MouseAdapter editAdapter) {
		editButton.addMouseListener(editAdapter);
		this.editAdapter = editAdapter;
	}

	public MouseAdapter getAddAdapter() {
		return addAdapter;
	}

	public void setAddAdapter(MouseAdapter addAdapter) {
		addButton.addMouseListener(addAdapter);
		this.addAdapter = addAdapter;
	}

	public MouseAdapter getDeleteAdapter() {
		return deleteAdapter;
	}

	public void setDeleteAdapter(MouseAdapter deleteAdapter) {
		deleteButton.addMouseListener(deleteAdapter);
		this.deleteAdapter = deleteAdapter;
	}

	public MouseAdapter getSaveAdapter() {
		return saveAdapter;
	}

	public void setSaveAdapter(MouseAdapter saveAdapter) {
		saveButton.addMouseListener(saveAdapter);
		this.saveAdapter = saveAdapter;
	}

	public MouseAdapter getCancelAdapter() {
		return cancelAdapter;
	}

	public void setCancelAdapter(MouseAdapter cancelAdapter) {
		cancelButton.addMouseListener(cancelAdapter);
		this.cancelAdapter = cancelAdapter;
	}

	public void setModuleComboBoxModel(String[] modules) {
		moduleComboBox.setModel(new DefaultComboBoxModel(modules));
	}

	public void setModuleComboBoxListener(ActionListener listener) {
		moduleComboBox.addActionListener(listener);
	}
	
	public String getModuleSelected() {
		return (String) moduleComboBox.getSelectedItem();
	}
	
	public void setModuleSelected(int index) {
		moduleComboBox.setSelectedIndex(index);
	}

	public abstract void beanToForm(CRMBean bean);
	public abstract void formToBean(CRMBean bean);

	public void updateIndexCount(int index, int count) {
		indexCountLabel.setText(index+1 + "/" + count);
	}

	public boolean inEditMode() { return editMode; }

	// The following should be overriden to enable/disable editing of input components
	public void enableEditMode() { editMode = true; }
	public void disableEditMode() {editMode = false; }

	public void enableLeftButton() { leftButton.setEnabled(true); }
	public void disableLeftButton() { leftButton.setEnabled(false); }

	public void enableRightButton() { rightButton.setEnabled(true); }
	public void disableRightButton() { rightButton.setEnabled(false); }

	public void enableEditButton() { editButton.setEnabled(true); }
	public void disableEditButton() { editButton.setEnabled(false); }

	public void enableAddButton() { addButton.setEnabled(true); }
	public void disableAddButton() { addButton.setEnabled(false); }

	public void enableDeleteButton() { deleteButton.setEnabled(true); }
	public void disableDeleteButton() { deleteButton.setEnabled(false); }

	public void enableSaveButton() { saveButton.setEnabled(true); }
	public void disableSaveButton() { saveButton.setEnabled(false); }

	public void enableCancelButton() { cancelButton.setEnabled(true); }
	public void disableCancelButton() { cancelButton.setEnabled(false); }

	public abstract void clearForm();
	public abstract void clearFieldErrors();


}
