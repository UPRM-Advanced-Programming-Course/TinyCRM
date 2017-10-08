package views;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import beans.CRMBean;
import beans.ClientBean;

public class ClientView extends CRMView {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField textId;
	private JTextField textCompany;
	private JTextField textTelephone;
	private JTextField textEmail;
	private JTextField textWebsite;
	private JTextField textFacebook;

	/**
	 * Create the frame.
	 */
	public ClientView() {
		super();
		setTitle("Clients");

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
		gbl_centerGrid.rowHeights = new int[]{50, 50, 50, 50, 50, 50, 50, 0};
		gbl_centerGrid.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_centerGrid.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
				
		JLabel lblCompany = new JLabel("Company");
		GridBagConstraints gbc_lblCompany = new GridBagConstraints();
		gbc_lblCompany.anchor = GridBagConstraints.EAST;
		gbc_lblCompany.insets = new Insets(0, 0, 5, 5);
		gbc_lblCompany.gridx = 0;
		gbc_lblCompany.gridy = 1;
		centerGrid.add(lblCompany, gbc_lblCompany);
		
		textCompany = new JTextField();
		textCompany.setEditable(false);
		GridBagConstraints gbc_textCompany = new GridBagConstraints();
		gbc_textCompany.insets = new Insets(0, 0, 5, 0);
		gbc_textCompany.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCompany.gridx = 1;
		gbc_textCompany.gridy = 1;
		centerGrid.add(textCompany, gbc_textCompany);
		textCompany.setColumns(10);
		
		JLabel lblTelephone = new JLabel("Telephone");
		GridBagConstraints gbc_lblTelephone = new GridBagConstraints();
		gbc_lblTelephone.anchor = GridBagConstraints.EAST;
		gbc_lblTelephone.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelephone.gridx = 0;
		gbc_lblTelephone.gridy = 2;
		centerGrid.add(lblTelephone, gbc_lblTelephone);
		
		textTelephone = new JTextField();
		textTelephone.setEditable(false);
		textTelephone.setToolTipText("(xxx) xxx-xxxx");
		GridBagConstraints gbc_textTelephoe = new GridBagConstraints();
		gbc_textTelephoe.insets = new Insets(0, 0, 5, 0);
		gbc_textTelephoe.fill = GridBagConstraints.HORIZONTAL;
		gbc_textTelephoe.gridx = 1;
		gbc_textTelephoe.gridy = 2;
		centerGrid.add(textTelephone, gbc_textTelephoe);
		textTelephone.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 0;
		gbc_lblEmail.gridy = 3;
		centerGrid.add(lblEmail, gbc_lblEmail);
		
		textEmail = new JTextField();
		textEmail.setEditable(false);
		textEmail.setToolTipText("JohnDoe@gmail.com");
		GridBagConstraints gbc_textEmail = new GridBagConstraints();
		gbc_textEmail.insets = new Insets(0, 0, 5, 0);
		gbc_textEmail.fill = GridBagConstraints.HORIZONTAL;
		gbc_textEmail.gridx = 1;
		gbc_textEmail.gridy = 3;
		centerGrid.add(textEmail, gbc_textEmail);
		textEmail.setColumns(10);
		
		JLabel lblWebsite = new JLabel("Website");
		GridBagConstraints gbc_lblWebsite = new GridBagConstraints();
		gbc_lblWebsite.anchor = GridBagConstraints.EAST;
		gbc_lblWebsite.insets = new Insets(0, 0, 5, 5);
		gbc_lblWebsite.gridx = 0;
		gbc_lblWebsite.gridy = 4;
		centerGrid.add(lblWebsite, gbc_lblWebsite);
		
		textWebsite = new JTextField();
		textWebsite.setEditable(false);
		textWebsite.setToolTipText("JohnDoe@gmail.com");
		GridBagConstraints gbc_textWebsite = new GridBagConstraints();
		gbc_textWebsite.insets = new Insets(0, 0, 5, 0);
		gbc_textWebsite.fill = GridBagConstraints.HORIZONTAL;
		gbc_textWebsite.gridx = 1;
		gbc_textWebsite.gridy = 4;
		centerGrid.add(textWebsite, gbc_textWebsite);
		textWebsite.setColumns(10);

		JLabel lblFacebook = new JLabel("Facebook");
		GridBagConstraints gbc_lblFacebook = new GridBagConstraints();
		gbc_lblFacebook.anchor = GridBagConstraints.EAST;
		gbc_lblFacebook.insets = new Insets(0, 0, 0, 5);
		gbc_lblFacebook.gridx = 0;
		gbc_lblFacebook.gridy = 5;
		centerGrid.add(lblFacebook, gbc_lblFacebook);
		
		textFacebook = new JTextField();
		textFacebook.setEditable(false);
		GridBagConstraints gbc_textFacebook = new GridBagConstraints();
		gbc_textFacebook.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFacebook.gridx = 1;
		gbc_textFacebook.gridy = 5;
		centerGrid.add(textFacebook, gbc_textFacebook);
		textFacebook.setColumns(10);
		
		this.setMessagesLabel("No Clients in the CRM");
		
	}
	
	public String getTextId() {
		return textId.getText();
	}

	public void setTextId(String textId) {
		this.textId.setText(textId);
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

	public String getTextWebsite() {
		return textWebsite.getText();
	}

	public void setTextWebsite(String textWebsite) {
		this.textWebsite.setText(textWebsite);
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
		textCompany.setEditable(true);
		textTelephone.setEditable(true);
		textEmail.setEditable(true);
		textWebsite.setEditable(true);
		textFacebook.setEditable(true);
	}
	public void disableEditMode() {
		super.disableEditMode();
		// Make all fields not editable
		textId.setEditable(false);
		textCompany.setEditable(false);
		textTelephone.setEditable(false);
		textEmail.setEditable(false);
		textWebsite.setEditable(false);
		textFacebook.setEditable(false);
	}

	public void beanToForm(CRMBean bean) {
		ClientBean cb = (ClientBean) bean;
		this.setTextId(""+cb.getId());
		this.setTextCompany(cb.getCompany());
		this.setTextTelephone(cb.getTelephone());
		this.setTextEmail(cb.getEmail());
		this.setTextWebsite(cb.getEmail());
		this.setTextFacebook(cb.getFacebook());
	}
	
	public void formToBean(CRMBean bean) {
		ClientBean cb = (ClientBean) bean;
		cb.setId(Integer.parseInt(textId.getText()));
		cb.setCompany(textCompany.getText());
		cb.setTelephone(textTelephone.getText());
		cb.setEmail(textEmail.getText());
		cb.setWebsite(textWebsite.getText());
		cb.setFacebook(textFacebook.getText());
	}
	
	public void clearForm() {
		textId.setText("");
		textCompany.setText("");
		textTelephone.setText("");
		textEmail.setText("");
		textWebsite.setText("");
		textFacebook.setText("");
	}
	
	public void clearFieldErrors() {
		
	}
}
