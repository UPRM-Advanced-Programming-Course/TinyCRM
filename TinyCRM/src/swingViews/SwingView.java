package swingViews;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Box;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import beans.CRMBean;
import views.TCRMView;

public abstract class SwingView extends JFrame implements TCRMView {

	private static final long serialVersionUID = 1L;

	private JPanel rootPanel;
	private JComponent centerPanel;

	// Dynamic Labels
	private JLabel indexCountLabel;
	private JLabel messagesLabel;

	private boolean editMode = false;

	private JButton leftButton;
	private JButton rightButton;
	private JButton editButton;
	private JButton addButton;
	private JButton deleteButton;
	private JButton saveButton;
	private JButton cancelButton;
	private JComboBox<String> moduleComboBox;
	private JLabel tinyCRMLabel;

	public SwingView() {
		setTitle("TinyCRM");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 633, 450);
		rootPanel = new JPanel();
		rootPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(rootPanel);
		rootPanel.setLayout(new BorderLayout(0, 0));

		JPanel topPanel = new JPanel();
		rootPanel.add(topPanel, BorderLayout.NORTH);
		topPanel.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));

		tinyCRMLabel = new JLabel("");
		tinyCRMLabel.setMaximumSize(new Dimension(57, 16));
		tinyCRMLabel.setIcon(new ImageIcon(SwingView.class.getResource("/images/TinyCRMLogo.png")));
		tinyCRMLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		tinyCRMLabel.setForeground(new Color(0, 128, 0));
		topPanel.add(tinyCRMLabel);

		moduleComboBox = new JComboBox<String>();
		moduleComboBox.setMaximumSize(new Dimension(150, 27));
		moduleComboBox.setPreferredSize(new Dimension(150, 27));
		topPanel.add(moduleComboBox);

		messagesLabel = new JLabel("This is the messages label");
		messagesLabel.setHorizontalAlignment(SwingConstants.CENTER);
		messagesLabel.setPreferredSize(new Dimension(340, 16));
		messagesLabel.setMinimumSize(new Dimension(340, 16));
		messagesLabel.setMaximumSize(new Dimension(340, 16));
		messagesLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		messagesLabel.setForeground(Color.RED);
		topPanel.add(messagesLabel);

		JPanel panel = new JPanel();
		rootPanel.add(panel, BorderLayout.CENTER);

		JPanel bottomPanel = new JPanel();
		rootPanel.add(bottomPanel, BorderLayout.SOUTH);
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
		rootPanel.add(horizontalStrut_2, BorderLayout.WEST);

		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		rootPanel.add(horizontalStrut_3, BorderLayout.EAST);
	}

	protected JComponent getCenterPanel() {
		return centerPanel;
	}

	protected void setCenterPanel(JComponent centerPanel) {
		this.centerPanel = centerPanel;
		getContentPane().add(centerPanel, BorderLayout.CENTER);
	}

	protected JLabel getIndexCountLabel() {
		return indexCountLabel;
	}

	protected void setIndexCountLabel(JLabel indexCountLabel) {
		this.indexCountLabel = indexCountLabel;
	}

	protected String getMessagesText() {
		return messagesLabel.getText();
	}

	public void setMessagesText(String text) {
		this.messagesLabel.setText(text);
	}

	public String getModuleSelected() {
		return (String) moduleComboBox.getSelectedItem();
	}

	public void setModuleSelected(int index) {
		boolean previous = moduleComboBox.isEnabled();
		moduleComboBox.setEnabled(false); // Avoid firing event listeners
		moduleComboBox.setSelectedIndex(index);
		moduleComboBox.setEnabled(previous);
	}

	public void setModuleSelectionItems(String[] modules) {
		moduleComboBox.setModel(new DefaultComboBoxModel<String>(modules));
	}

	public void setModuleSelectionListener(Runnable listener) {
		moduleComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Combo Box Selected");
				listener.run();
			}
		});
	}

	public abstract void beanToForm(CRMBean bean);
	public abstract void formToBean(CRMBean bean);

	public void updateIndexCountLabel(int index, int count) {
		indexCountLabel.setText(index+1 + "/" + count);
	}

	public boolean inEditMode() { return editMode; }
	public void enableEditMode() { editMode = true; }
	public void disableEditMode() {editMode = false; }

	public void setLeftButtonListener(Runnable listener) {
		leftButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				listener.run();
			}
		});
	}

	public void setRightButtonListener(Runnable listener) {
		rightButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				listener.run();
			}
		});
	}

	public void setEditButtonListener(Runnable listener) {
		editButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				listener.run();
			}
		});
	}

	public void setAddButtonListener(Runnable listener) {
		addButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				listener.run();
			}
		});
	}

	public void setDeleteButtonListener(Runnable listener) {
		deleteButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				listener.run();
			}
		});
	}

	public void setSaveButtonListener(Runnable listener) {
		saveButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				listener.run();
			}
		});
	}

	public void setCancelButtonListener(Runnable listener) {
		cancelButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				listener.run();
			}
		});
	}

	public void enableLeftButton()   { leftButton.setEnabled(true); }
	public void enableRightButton()  { rightButton.setEnabled(true); }
	public void enableEditButton()   { editButton.setEnabled(true); }
	public void enableAddButton()    { addButton.setEnabled(true); }
	public void enableDeleteButton() { deleteButton.setEnabled(true); }
	public void enableSaveButton()   { saveButton.setEnabled(true); }
	public void enableCancelButton() { cancelButton.setEnabled(true); }

	public void disableLeftButton()   { leftButton.setEnabled(false); }
	public void disableRightButton()  { rightButton.setEnabled(false); }
	public void disableEditButton()   { editButton.setEnabled(false); }
	public void disableAddButton()    { addButton.setEnabled(false); }
	public void disableDeleteButton() { deleteButton.setEnabled(false); }
	public void disableSaveButton()   { saveButton.setEnabled(false); }
	public void disableCancelButton() { cancelButton.setEnabled(false); }

	public abstract void clearForm();
	public abstract void clearFieldErrors();

}
