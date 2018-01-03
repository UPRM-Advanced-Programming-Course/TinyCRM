package models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import beans.CRMBean;
import beans.ContactBean;

public class ContactModel extends CRMModel {

	private static String CONTACTS_FILE = "data/contacts.tsv";

	public ContactModel() {
		super();
	}
	
	@Override
	public void doInit() {
		super.doInit();
		ArrayList<CRMBean> beans = parseBeansFromFile(CONTACTS_FILE);
		this.setList(beans);
		this.setIndex(0);
	}

//	@Override
//	public void doLeft() {
//		super.doLeft();
//	}

//	@Override
//	public void doRight() {
//		super.doRight();
//	}

//	@Override
//	public void doEdit() {
//		super.doEdit();
//	}

	@Override
	public void doAdd() {
		long id = 1;
		if (this.getCount() > 0) {
			id = ((ContactBean) this.getBean(this.getCount()-1)).getId() + 1;
		}
		this.getAllBeans().add(new ContactBean(id));
		this.setIndex(this.getCount() - 1);  // New record becomes the current one
	}

//	@Override
//	public void doDelete() {
//		super.doDelete();
//	}

	@Override
	public void doSave() {
		super.doSave();
		saveBeansToFile(CONTACTS_FILE);
	}
	
//	@Override
//	public void doCancel() {
//		super.doCancel();
//	}

	public ArrayList<CRMBean> parseBeansFromFile(String filename) {
		File inputFile = new File(filename);
		try {
			ArrayList<CRMBean> contactBeans = new ArrayList<CRMBean>();
			Scanner inputScanner = new Scanner(inputFile);
			inputScanner.nextLine();  // Ignore header line
			int count = 0;
			inputScanner.useDelimiter("[\t\n]");
			while (inputScanner.hasNextLine()) {
				String ID = inputScanner.next();
				int id = Integer.parseInt(ID);
				ContactBean newBean = new ContactBean(id);
				String firstName = inputScanner.next();
				newBean.setFirstName(firstName);
				String lastName = inputScanner.next();
				newBean.setLastName(lastName);
				String company = inputScanner.next();
				newBean.setCompany(company);
				String client = inputScanner.next();
				int clientId = Integer.parseInt(client);
				newBean.setClient(clientId);
				String telephone = inputScanner.next();
				newBean.setTelephone(telephone);
				String email = inputScanner.next();
				newBean.setEmail(email);
				String facebook = inputScanner.next();
				newBean.setFacebook(facebook);
				inputScanner.nextLine();  // Skip over anything left in line
				contactBeans.add(newBean);
				count++;
			}
			inputScanner.close();
			return contactBeans;
		}
		catch (FileNotFoundException e) {
			throw new RuntimeException("Fatal Error: Input file not Found");
		}
	}
	
	public String beanToFileLine(CRMBean bean) {

		String result = "";
		ContactBean cb = (ContactBean) bean;
		result += cb.getId();
		result += '\t';
		result += cb.getFirstName();
		result += '\t';
		result += cb.getLastName();
		result += '\t';
		result += cb.getCompany();
		result += '\t';
		if (cb.getClient() < 0) {
			result += "-1";
		}
		else {
			result += ""+cb.getClient();
		}
		result += '\t';
		result += cb.getTelephone();
		result += '\t';
		result += cb.getEmail();
		result += '\t';
		result += cb.getFacebook();
		return result;
		
	}

	public void saveBeansToFile(String filename) {
		
		ArrayList<CRMBean> contactBeans = getAllBeans();
		File outputFile = new File(filename);
		try {
			PrintWriter out = new PrintWriter(outputFile);
			// Print Header Line
			out.println("TinyCRM Contacts data file");
			for (CRMBean bean : contactBeans) {
				out.println(beanToFileLine(bean));
			}
			out.close();
		}
		catch (FileNotFoundException e) {
			throw new RuntimeException("Fatal Error: Output file not Found");
		}
	}

}
