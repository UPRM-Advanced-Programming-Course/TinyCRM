package views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import beans.CRMBean;
import beans.ContactBean;

public class ContactView extends CRMView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel rootPane;
	private JTextField textFirstName;
	private JTextField textLastName;
	private JTextField textCompany;
	private JTextField textTelephone;
	private JTextField textEmail;
	private JTextField textFacebook;
	private JTextField textFirstname;

//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					ContactView frame = new ContactView();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public ContactView() {
		super();
		setTitle("Contacts");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 632, 412);
		rootPane = new JPanel();
		rootPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(rootPane);
		rootPane.setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		rootPane.add(toolBar, BorderLayout.NORTH);
		
		Component leftStrut = Box.createHorizontalStrut(20);
		rootPane.add(leftStrut, BorderLayout.WEST);
		
		JScrollPane centerPanel = new JScrollPane();
		centerPanel.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		rootPane.add(centerPanel, BorderLayout.CENTER);
		
		JPanel centerGrid = new JPanel();
		centerPanel.setViewportView(centerGrid);
		GridBagLayout gbl_centerGrid = new GridBagLayout();
		gbl_centerGrid.columnWidths = new int[]{100, 385, 0};
		gbl_centerGrid.rowHeights = new int[]{50, 50, 50, 50, 50, 50,0};
		gbl_centerGrid.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_centerGrid.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		centerGrid.setLayout(gbl_centerGrid);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblFirstName = new GridBagConstraints();
		gbc_lblFirstName.anchor = GridBagConstraints.EAST;
		gbc_lblFirstName.insets = new Insets(0, 0, 5, 5);
		gbc_lblFirstName.gridx = 0;
		gbc_lblFirstName.gridy = 0;
		centerGrid.add(lblFirstName, gbc_lblFirstName);
		
		textFirstname = new JTextField();
		GridBagConstraints gbc_txtFirstname = new GridBagConstraints();
		gbc_txtFirstname.insets = new Insets(0, 0, 5, 0);
		gbc_txtFirstname.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFirstname.gridx = 1;
		gbc_txtFirstname.gridy = 0;
		centerGrid.add(textFirstname, gbc_txtFirstname);
		textFirstname.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblLastName = new GridBagConstraints();
		gbc_lblLastName.anchor = GridBagConstraints.EAST;
		gbc_lblLastName.insets = new Insets(0, 0, 5, 5);
		gbc_lblLastName.gridx = 0;
		gbc_lblLastName.gridy = 1;
		centerGrid.add(lblLastName, gbc_lblLastName);
		
		textLastName = new JTextField();
		GridBagConstraints gbc_textLastName = new GridBagConstraints();
		gbc_textLastName.insets = new Insets(0, 0, 5, 0);
		gbc_textLastName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textLastName.gridx = 1;
		gbc_textLastName.gridy = 1;
		centerGrid.add(textLastName, gbc_textLastName);
		textLastName.setColumns(10);
		
		JLabel lblCompany = new JLabel("Company");
		GridBagConstraints gbc_lblCompany = new GridBagConstraints();
		gbc_lblCompany.anchor = GridBagConstraints.EAST;
		gbc_lblCompany.insets = new Insets(0, 0, 5, 5);
		gbc_lblCompany.gridx = 0;
		gbc_lblCompany.gridy = 2;
		centerGrid.add(lblCompany, gbc_lblCompany);
		
		textCompany = new JTextField();
		GridBagConstraints gbc_textCompany = new GridBagConstraints();
		gbc_textCompany.insets = new Insets(0, 0, 5, 0);
		gbc_textCompany.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCompany.gridx = 1;
		gbc_textCompany.gridy = 2;
		centerGrid.add(textCompany, gbc_textCompany);
		textCompany.setColumns(10);
		
		JLabel lblTelephone = new JLabel("Telephone");
		GridBagConstraints gbc_lblTelephone = new GridBagConstraints();
		gbc_lblTelephone.anchor = GridBagConstraints.EAST;
		gbc_lblTelephone.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelephone.gridx = 0;
		gbc_lblTelephone.gridy = 3;
		centerGrid.add(lblTelephone, gbc_lblTelephone);
		
		textTelephone = new JTextField();
		GridBagConstraints gbc_textTelephoe = new GridBagConstraints();
		gbc_textTelephoe.insets = new Insets(0, 0, 5, 0);
		gbc_textTelephoe.fill = GridBagConstraints.HORIZONTAL;
		gbc_textTelephoe.gridx = 1;
		gbc_textTelephoe.gridy = 3;
		centerGrid.add(textTelephone, gbc_textTelephoe);
		textTelephone.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 4;
		centerGrid.add(lblEmail, gbc_lblEmail);
		
		textEmail = new JTextField();
		GridBagConstraints gbc_textEmail = new GridBagConstraints();
		gbc_textEmail.insets = new Insets(0, 0, 5, 0);
		gbc_textEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textEmail.gridx = 1;
		gbc_textEmail.gridy = 4;
		centerGrid.add(textEmail, gbc_textEmail);
		textEmail.setColumns(10);
		
		JLabel lblFacebook = new JLabel("Facebook");
		GridBagConstraints gbc_lblFacebook = new GridBagConstraints();
		gbc_lblFacebook.anchor = GridBagConstraints.EAST;
		gbc_lblFacebook.insets = new Insets(0, 0, 0, 5);
		gbc_lblFacebook.gridx = 0;
		gbc_lblFacebook.gridy = 5;
		centerGrid.add(lblFacebook, gbc_lblFacebook);
		
		textFacebook = new JTextField();
		GridBagConstraints gbc_textFacebook = new GridBagConstraints();
		gbc_textFacebook.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFacebook.gridx = 1;
		gbc_textFacebook.gridy = 5;
		centerGrid.add(textFacebook, gbc_textFacebook);
		textFacebook.setColumns(10);
		
		Component rightStrut = Box.createHorizontalStrut(20);
		rootPane.add(rightStrut, BorderLayout.EAST);
		
		JPanel bottomPanel = new JPanel();
		rootPane.add(bottomPanel, BorderLayout.SOUTH);
		bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton leftButton = new JButton("Left");
		bottomPanel.add(leftButton);
		
		JButton addButton = new JButton("Add");
		bottomPanel.add(addButton);
		
		JButton saveButton = new JButton("Save");
		bottomPanel.add(saveButton);
		
		JButton deleteButton = new JButton("Delete");
		bottomPanel.add(deleteButton);
		
		JButton rightButton = new JButton("Right");
		bottomPanel.add(rightButton);
	}

	public String getTextFirstName() {
		return textFirstName.getText();
	}

	public void setTextFirstName(String textFirstName) {
		this.textFirstName.setText(textFirstName);
	}
	
	public String getTextLastName() {
		return textLastName.getText();
	}

	public void setTextLastName(String textLastName) {
		this.textLastName.setText(textLastName);
	}

	public String getTextCompany() {
		return textCompany.getText();
	}

	public void setTextCompany(String textCompany) {
		this.textCompany.setText(textCompany);
	}

	public String getTextTelephone() {
		return textTelephone.getText();
	}

	public void setTextTelephone(String textTelephoe) {
		this.textTelephone.setText(textTelephoe);
	}

	public String getTextEmail() {
		return textEmail.getText();
	}

	public void setTextEmail(String textEmail) {
		this.textEmail.setText(textEmail);
	}

	public String getTextFacebook() {
		return textFacebook.getText();
	}

	public void setTextFacebook(String textFacebook) {
		this.textFacebook.setText(textFacebook);
	}

	public void display(CRMBean bean) {
		ContactBean cb = (ContactBean) bean;
		this.setTextFirstName(cb.getFirstName());
		this.setTextLastName(cb.getLastName());
		this.setTextCompany(cb.getCompany());
		this.setTextTelephone(cb.getFirstName());
		this.setTextFirstName(cb.getFirstName());
		this.setTextFirstName(cb.getFirstName());
	}
}
