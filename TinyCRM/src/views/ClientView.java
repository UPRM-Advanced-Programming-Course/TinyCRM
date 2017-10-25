package views;

import java.awt.Color;
import java.awt.Font;
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

	private JLabel idLblError;
	private JLabel companyLblError;
	private JLabel telephoneLblError;
	private JLabel emailLblError;
	private JLabel websiteLblError;
	private JLabel facebookLblError;

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
		gbl_centerGrid.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_centerGrid.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_centerGrid.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
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
				
		idLblError = new JLabel("New label");
		idLblError.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		idLblError.setForeground(Color.RED);
		GridBagConstraints gbc_IdLblError = new GridBagConstraints();
		gbc_IdLblError.anchor = GridBagConstraints.WEST;
		gbc_IdLblError.insets = new Insets(0, 0, 5, 0);
		gbc_IdLblError.gridx = 1;
		gbc_IdLblError.gridy = 1;
		centerGrid.add(idLblError, gbc_IdLblError);

		JLabel lblCompany = new JLabel("Company");
		GridBagConstraints gbc_lblCompany = new GridBagConstraints();
		gbc_lblCompany.anchor = GridBagConstraints.EAST;
		gbc_lblCompany.insets = new Insets(0, 0, 5, 5);
		gbc_lblCompany.gridx = 0;
		gbc_lblCompany.gridy = 2;
		centerGrid.add(lblCompany, gbc_lblCompany);
		
		textCompany = new JTextField();
		textCompany.setEditable(false);
		GridBagConstraints gbc_textCompany = new GridBagConstraints();
		gbc_textCompany.insets = new Insets(0, 0, 5, 0);
		gbc_textCompany.fill = GridBagConstraints.HORIZONTAL;
		gbc_textCompany.gridx = 1;
		gbc_textCompany.gridy = 2;
		centerGrid.add(textCompany, gbc_textCompany);
		textCompany.setColumns(10);
		
		companyLblError = new JLabel("New label");
		companyLblError.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		companyLblError.setForeground(Color.RED);
		GridBagConstraints gbc_CompanyLblbError = new GridBagConstraints();
		gbc_CompanyLblbError.anchor = GridBagConstraints.WEST;
		gbc_CompanyLblbError.insets = new Insets(0, 0, 5, 0);
		gbc_CompanyLblbError.gridx = 1;
		gbc_CompanyLblbError.gridy = 3;
		centerGrid.add(companyLblError, gbc_CompanyLblbError);
		
		JLabel lblTelephone = new JLabel("Telephone");
		GridBagConstraints gbc_lblTelephone = new GridBagConstraints();
		gbc_lblTelephone.anchor = GridBagConstraints.EAST;
		gbc_lblTelephone.insets = new Insets(0, 0, 5, 5);
		gbc_lblTelephone.gridx = 0;
		gbc_lblTelephone.gridy = 4;
		centerGrid.add(lblTelephone, gbc_lblTelephone);
		
		textTelephone = new JTextField();
		textTelephone.setEditable(false);
		textTelephone.setToolTipText("(xxx) xxx-xxxx");
		GridBagConstraints gbc_textTelephoe = new GridBagConstraints();
		gbc_textTelephoe.insets = new Insets(0, 0, 5, 0);
		gbc_textTelephoe.fill = GridBagConstraints.HORIZONTAL;
		gbc_textTelephoe.gridx = 1;
		gbc_textTelephoe.gridy = 4;
		centerGrid.add(textTelephone, gbc_textTelephoe);
		textTelephone.setColumns(10);
		
		telephoneLblError = new JLabel("New label");
		telephoneLblError.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		telephoneLblError.setForeground(Color.RED);
		GridBagConstraints gbc_telephoneLblError = new GridBagConstraints();
		gbc_telephoneLblError.anchor = GridBagConstraints.WEST;
		gbc_telephoneLblError.insets = new Insets(0, 0, 5, 0);
		gbc_telephoneLblError.gridx = 1;
		gbc_telephoneLblError.gridy = 5;
		centerGrid.add(telephoneLblError, gbc_telephoneLblError);
		
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
		
		emailLblError = new JLabel("New label");
		emailLblError.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		emailLblError.setForeground(Color.RED);
		GridBagConstraints gbc_emailLblError = new GridBagConstraints();
		gbc_emailLblError.anchor = GridBagConstraints.WEST;
		gbc_emailLblError.insets = new Insets(0, 0, 5, 0);
		gbc_emailLblError.gridx = 1;
		gbc_emailLblError.gridy = 7;
		centerGrid.add(emailLblError, gbc_emailLblError);
		
		JLabel lblWebsite = new JLabel("Website");
		GridBagConstraints gbc_lblWebsite = new GridBagConstraints();
		gbc_lblWebsite.anchor = GridBagConstraints.EAST;
		gbc_lblWebsite.insets = new Insets(0, 0, 5, 5);
		gbc_lblWebsite.gridx = 0;
		gbc_lblWebsite.gridy = 8;
		centerGrid.add(lblWebsite, gbc_lblWebsite);
		
		textWebsite = new JTextField();
		textWebsite.setEditable(false);
		textWebsite.setToolTipText("JohnDoe@gmail.com");
		GridBagConstraints gbc_textWebsite = new GridBagConstraints();
		gbc_textWebsite.insets = new Insets(0, 0, 5, 0);
		gbc_textWebsite.fill = GridBagConstraints.HORIZONTAL;
		gbc_textWebsite.gridx = 1;
		gbc_textWebsite.gridy = 8;
		centerGrid.add(textWebsite, gbc_textWebsite);
		textWebsite.setColumns(10);

		websiteLblError = new JLabel("New label");
		websiteLblError.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		websiteLblError.setForeground(Color.RED);
		GridBagConstraints gbc_websiteLblError = new GridBagConstraints();
		gbc_websiteLblError.anchor = GridBagConstraints.WEST;
		gbc_websiteLblError.insets = new Insets(0, 0, 5, 0);
		gbc_websiteLblError.gridx = 1;
		gbc_websiteLblError.gridy = 9;
		centerGrid.add(websiteLblError, gbc_websiteLblError);
		
		JLabel lblFacebook = new JLabel("Facebook");
		GridBagConstraints gbc_lblFacebook = new GridBagConstraints();
		gbc_lblFacebook.anchor = GridBagConstraints.EAST;
		gbc_lblFacebook.insets = new Insets(0, 0, 0, 5);
		gbc_lblFacebook.gridx = 0;
		gbc_lblFacebook.gridy = 10;
		centerGrid.add(lblFacebook, gbc_lblFacebook);
		
		textFacebook = new JTextField();
		textFacebook.setEditable(false);
		GridBagConstraints gbc_textFacebook = new GridBagConstraints();
		gbc_textFacebook.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFacebook.gridx = 1;
		gbc_textFacebook.gridy = 10;
		centerGrid.add(textFacebook, gbc_textFacebook);
		textFacebook.setColumns(10);
		
		facebookLblError = new JLabel("New label");
		facebookLblError.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		facebookLblError.setForeground(Color.RED);
		GridBagConstraints gbc_facebookLblError = new GridBagConstraints();
		gbc_facebookLblError.anchor = GridBagConstraints.WEST;
		gbc_facebookLblError.insets = new Insets(0, 0, 5, 0);
		gbc_facebookLblError.gridx = 1;
		gbc_facebookLblError.gridy = 11;
		centerGrid.add(facebookLblError, gbc_facebookLblError);
		
		this.setMessagesText("No Clients in the CRM");
		
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
	
	public String getErrorCompany() {
		return companyLblError.getText();
	}

	public void setErrorCompany(String errorCompany) {
		companyLblError.setText(errorCompany);
	}
	
	public String getErrorTelephone() {
		return telephoneLblError.getText();
	}

	public void setErrorTelephone(String errorFirstName) {
		telephoneLblError.setText(errorFirstName);
	}
	
	public String getErrorEmail() {
		return emailLblError.getText();
	}

	public void setErrorEmail(String errorEmail) {
		emailLblError.setText(errorEmail);
	}
	
	public String getErrorWebsite() {
		return websiteLblError.getText();
	}

	public void setErrorWebsite(String errorWebsite) {
		websiteLblError.setText(errorWebsite);
	}
	
	public String getErrorFacebook() {
		return facebookLblError.getText();
	}

	public void setErrorFacebook(String errorFacebook) {
		facebookLblError.setText(errorFacebook);
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
		clearFieldErrors();
	}
	
	public void clearFieldErrors() {
		idLblError.setText("");
		companyLblError.setText("");
		telephoneLblError.setText("");
		emailLblError.setText("");
		websiteLblError.setText("");
		facebookLblError.setText("");
	}
}
