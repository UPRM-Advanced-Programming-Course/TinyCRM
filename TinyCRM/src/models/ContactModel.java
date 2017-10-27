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
	}
	
	@Override
	public void doInit() {
		ArrayList<CRMBean> beans = parseBeansFromFile(CONTACTS_FILE);
		for (CRMBean b : beans) {
			add((ContactBean) b);
		}
		setIndex(0);
	}


	@Override
	public void doLeft() {
		System.out.println("ContactModel.doLeft()");
		super.doLeft();
	}

	@Override
	public void doRight() {
		System.out.println("ContactModel.doRight()");
		super.doRight();
	}

	@Override
	public void doEdit() {
		System.out.println("ContactModel.doEdit()");
		super.doEdit();
	}

	@Override
	public void doAdd() {
		System.out.println("ContactModel.doAdd()");
		int id = 1;
		if (this.getCount() > 0) {
			id = ((ContactBean) this.getBean(this.getCount()-1)).getId() + 1;
		}
		this.add(new ContactBean(id));
		this.setIndex(this.getCount() - 1);
	}

	@Override
	public void doDelete() {
		System.out.println("ContactModel.doDelete()");
		super.doDelete();

	}

	@Override
	public void doSave() {
		System.out.println("ContactModel.doSave()");
		//super.doSave();
		saveContactBeansCSV(CONTACTS_FILE);
	}

	public static ArrayList<CRMBean> parseBeansFromFile(String filename) {
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
				System.out.println("Next ID: " + ID);
				String firstName = inputScanner.next();
				newBean.setFirstName(firstName);
				System.out.println("Next FirstName: " + firstName);
				String lastName = inputScanner.next();
				newBean.setLastName(lastName);
				System.out.println("Next LastName: " + lastName);
				String company = inputScanner.next();
				newBean.setCompany(company);
				System.out.println("Next Company: " + company);
				String client = inputScanner.next();
				int clientId = Integer.parseInt(client);
				newBean.setClient(clientId);
				System.out.println("Next client: " + client);
				String telephone = inputScanner.next();
				newBean.setTelephone(telephone);
				System.out.println("Next Telephone: " + telephone);
				String email = inputScanner.next();
				newBean.setEmail(email);
				System.out.println("Next Email: " + email);
				String facebook = inputScanner.next();
				newBean.setFacebook(facebook);
				System.out.println("Next Facebook: " + facebook);
				inputScanner.nextLine();  // Skip over anything left in line
				contactBeans.add(newBean);
				count++;
			}
			System.out.println("Total ContactBeans in file:" + count);
			System.out.println("Total ContactBeans added:" + contactBeans.size());
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

	public void saveContactBeansCSV(String filename) {
		
		ArrayList<CRMBean> contactBeans = getList();
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
