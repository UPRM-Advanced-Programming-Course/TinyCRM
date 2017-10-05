package views;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import beans.CRMBean;
import beans.ClientBean;
import beans.ContactBean;

public class ContactView extends CRMView {

	private static final long serialVersionUID = 1L;
	
	private JTextField textId;
	private JTextField textFirstName;
	private JTextField textLastName;
	private JTextField textCompany;
	private JComboBox<ClientBean> comboBoxClient;
	//private JTextField textClient;
	private JTextField textTelephone;
	private JTextField textEmail;
	private JTextField textFacebook;

	/**
	 * Create the frame.
	 */
	public ContactView() {
		super();
		setTitle("Contacts");

		JPanel centerPanel = new JPanel();
		JScrollPane centerScrollPane = new JScrollPane();
		centerScrollPane.setViewportBorder(new LineBorder(new Color(0, 0, 0)));
		centerPanel.add(centerScrollPane);
		this.setCenterPanel(centerPanel);
		//rootPane.add(centerPanel, BorderLayout.CENTER);
		
		
		JPanel centerGrid = new JPanel();
		centerScrollPane.setViewportView(centerGrid);
		GridBagLayout gbl_centerGrid = new GridBagLayout();
		gbl_centerGrid.columnWidths = new int[]{100, 475, 0};
		gbl_centerGrid.rowHeights = new int[]{50, 50, 50, 50, 50, 50, 50, 50, 0};
		gbl_centerGrid.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_centerGrid.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		centerGrid.setLayout(gbl_centerGrid);
		
		JLabel lblId = new JLabel("ID");
		lblId.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblId = new GridBagConstraints();
		gbc_lblId.anchor = GridBagConstraints.EAST;
		gbc_lblId.insets = new Insets(0, 0, 5, 5);
		gbc_lblId.gridx = 0;
		gbc_lblId.gridy = 0;
		centerGrid.add(lblId, gbc_lblId);
		
		textId = new JTextField();
		textId.setEditable(false);
		GridBagConstraints gbc_txtId = new GridBagConstraints();
		gbc_txtId.insets = new Insets(0, 0, 5, 0);
		gbc_txtId.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtId.gridx = 1;
		gbc_txtId.gridy = 0;
		centerGrid.add(textId, gbc_txtId);
		textId.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblFirstName = new GridBagConstraints();
		gbc_lblFirstName.anchor = GridBagConstraints.EAST;
		gbc_lblFirstName.insets = new Insets(0, 0, 5, 5);
		gbc_lblFirstName.gridx = 0;
		gbc_lblFirstName.gridy = 1;
		centerGrid.add(lblFirstName, gbc_lblFirstName);
		
		textFirstName = new JTextField();
		textFirstName.setEditable(false);
		GridBagConstraints gbc_txtFirstname = new GridBagConstraints();
		gbc_txtFirstname.insets = new Insets(0, 0, 5, 0);
		gbc_txtFirstname.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFirstname.gridx = 1;
		gbc_txtFirstname.gridy = 1;
		centerGrid.add(textFirstName, gbc_txtFirstname);
		textFirstName.setColumns(10);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setHorizontalAlignment(SwingConstants.RIGHT);
		GridBagConstraints gbc_lblLastName = new GridBagConstraints();
		gbc_lblLastName.anchor = GridBagConstraints.EAST;
		gbc_lblLastName.insets = new Insets(0, 0, 5, 5);
		gbc_lblLastName.gridx = 0;
		gbc_lblLastName.gridy = 2;
		centerGrid.add(lblLastName, gbc_lblLastName);
		
		textLastName = new JTextField();
		textLastName.setEditable(false);
		GridBagConstraints gbc_textLastName = new GridBagConstraints();
		gbc_textLastName.insets = new Insets(0, 0, 5, 0);
		gbc_textLastName.fill = GridBagConstraints.HORIZONTAL;
		gbc_textLastName.gridx = 1;
		gbc_textLastName.gridy = 2;
		centerGrid.add(textLastName, gbc_textLastName);
		textLastName.setColumns(10);
		
		JLabel lblCompany = new JLabel("Company");
		GridBagConstraints gbc_lblCompany = new GridBagConstraints();
		gbc_lblCompany.anchor = GridBagConstraints.EAST;
		gbc_lblCompany.insets = new Insets(0, 0, 5, 5);
		gbc_lblCompany.gridx = 0;
		gbc_lblCompany.gridy = 3;
		centerGrid.add(lblCompany, gbc_lblCompany);
		
		textCompany = new JTextField();
		textCompany.setEditable(false);
		GridBagConstraints gbc_textCompany = new GridBagConstraints();
		gbc_textCompany.insets = new Insets(0, 0, 5, 0);
		gbc_textCompany.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCompany.gridx = 1;
		gbc_textCompany.gridy = 3;
		centerGrid.add(textCompany, gbc_textCompany);
		textCompany.setColumns(10);
		
		JLabel lblClient = new JLabel("Client");
		GridBagConstraints gbc_lblClient = new GridBagConstraints();
		gbc_lblClient.anchor = GridBagConstraints.EAST;
		gbc_lblClient.insets = new Insets(0, 0, 5, 5);
		gbc_lblClient.gridx = 0;
		gbc_lblClient.gridy = 4;
		centerGrid.add(lblClient, gbc_lblClient);
		
		comboBoxClient = new JComboBox<ClientBean>();
		comboBoxClient.setEditable(false);
		comboBoxClient.setEnabled(false);
		GridBagConstraints gbc_comboBoxClient = new GridBagConstraints();
		gbc_comboBoxClient.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxClient.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxClient.gridx = 1;
		gbc_comboBoxClient.gridy = 4;
		centerGrid.add(comboBoxClient, gbc_comboBoxClient);
		//comboBoxClient.setColumns(10);
		
		JLabel lblTelephone = new JLabel("Telephone");
		GridBagConstraints gbc_lblTelephone = new GridBagConstraints();
		gbc_lblTelephone.anchor = GridBagConstraints.EAST;
		gbc_lblTelephone.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelephone.gridx = 0;
		gbc_lblTelephone.gridy = 5;
		centerGrid.add(lblTelephone, gbc_lblTelephone);
		
		textTelephone = new JTextField();
		textTelephone.setEditable(false);
		textTelephone.setToolTipText("(xxx) xxx-xxxx");
		GridBagConstraints gbc_textTelephoe = new GridBagConstraints();
		gbc_textTelephoe.insets = new Insets(0, 0, 5, 0);
		gbc_textTelephoe.fill = GridBagConstraints.HORIZONTAL;
		gbc_textTelephoe.gridx = 1;
		gbc_textTelephoe.gridy = 5;
		centerGrid.add(textTelephone, gbc_textTelephoe);
		textTelephone.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 6;
		centerGrid.add(lblEmail, gbc_lblEmail);
		
		textEmail = new JTextField();
		textEmail.setEditable(false);
		textEmail.setToolTipText("JohnDoe@gmail.com");
		GridBagConstraints gbc_textEmail = new GridBagConstraints();
		gbc_textEmail.insets = new Insets(0, 0, 5, 0);
		gbc_textEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textEmail.gridx = 1;
		gbc_textEmail.gridy = 6;
		centerGrid.add(textEmail, gbc_textEmail);
		textEmail.setColumns(10);
		
		JLabel lblFacebook = new JLabel("Facebook");
		GridBagConstraints gbc_lblFacebook = new GridBagConstraints();
		gbc_lblFacebook.anchor = GridBagConstraints.EAST;
		gbc_lblFacebook.insets = new Insets(0, 0, 0, 5);
		gbc_lblFacebook.gridx = 0;
		gbc_lblFacebook.gridy = 7;
		centerGrid.add(lblFacebook, gbc_lblFacebook);
		
		textFacebook = new JTextField();
		textFacebook.setEditable(false);
		GridBagConstraints gbc_textFacebook = new GridBagConstraints();
		gbc_textFacebook.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFacebook.gridx = 1;
		gbc_textFacebook.gridy = 7;
		centerGrid.add(textFacebook, gbc_textFacebook);
		textFacebook.setColumns(10);
		
		this.setMessagesLabel("No Contacts in the CRM");
		
	}
	
	public String getTextId() {
		return textId.getText();
	}

	public void setTextId(String textId) {
		this.textId.setText(textId);
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

	public ClientBean getSelectedComboBoxClient() {
		System.out.println("Selected Item: " + comboBoxClient.getSelectedItem());
		return (ClientBean) comboBoxClient.getSelectedItem();
	}

	public void setSelectedComboBoxClient(ClientBean b) {
		for (int i=0; i<comboBoxClient.getItemCount(); i++) {
			ClientBean b2 = (ClientBean) comboBoxClient.getItemAt(i);
			if (b2.equals(b)) {
				comboBoxClient.setSelectedIndex(i);
				return;
			}
		}
	}
	
	public void setComboBoxClientItems(ArrayList<CRMBean> list) {
		comboBoxClient.removeAllItems();
		for (CRMBean item : list) {
			comboBoxClient.addItem((ClientBean) item);
		}
	}
	
	public void setComboBoxClientListener(ActionListener listener) {
		comboBoxClient.addActionListener(listener);
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
	
	public void enableEditMode() { 
		super.enableEditMode();
		// Make all fields editable
		//textId.setEditable(true);
		textFirstName.setEditable(true);
		textLastName.setEditable(true);
		textCompany.setEditable(true);
		comboBoxClient.setEnabled(true);
		textTelephone.setEditable(true);
		textEmail.setEditable(true);
		textFacebook.setEditable(true);
	}
	public void disableEditMode() {
		super.disableEditMode();
		// Make all fields not editable
		textId.setEditable(false);
		textFirstName.setEditable(false);
		textLastName.setEditable(false);
		textCompany.setEditable(false);
		comboBoxClient.setEnabled(false);
		textTelephone.setEditable(false);
		textEmail.setEditable(false);
		textFacebook.setEditable(false);
	}

	public void beanToForm(CRMBean bean) {
		ContactBean cb = (ContactBean) bean;
		this.setTextId(""+cb.getId());
		this.setTextFirstName(cb.getFirstName());
		this.setTextLastName(cb.getLastName());
		this.setTextCompany(cb.getCompany());
		this.setSelectedComboBoxClient(cb.getClient());
		this.setTextTelephone(cb.getTelephone());
		this.setTextEmail(cb.getEmail());
		this.setTextFacebook(cb.getFacebook());
	}
	
	public void formToBean(CRMBean bean) {
		ContactBean cb = (ContactBean) bean;
		cb.setId(Integer.parseInt(textId.getText()));
		cb.setFirstName(textFirstName.getText());
		cb.setLastName(textLastName.getText());
		cb.setCompany(textCompany.getText());
		cb.setClient((ClientBean) this.getSelectedComboBoxClient());
		cb.setTelephone(textTelephone.getText());
		cb.setEmail(textEmail.getText());
		cb.setFacebook(textFacebook.getText());
	}
	
	public void clearForm() {
		textId.setText("");
		textFirstName.setText("");
		textLastName.setText("");
		textCompany.setText("");
		comboBoxClient.setSelectedIndex(0);
		textTelephone.setText("");
		textEmail.setText("");
		textFacebook.setText("");
	}
}
