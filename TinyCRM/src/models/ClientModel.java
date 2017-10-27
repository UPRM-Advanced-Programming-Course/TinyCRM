package models;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import beans.CRMBean;
import beans.ClientBean;

public class ClientModel extends CRMModel {
	
	private static String CLIENTS_FILE = "data/clients.tsv";

	public ClientModel() {

	}
	
	@Override
	public void doInit() {
		ArrayList<CRMBean> beans = parseBeansFromFile(CLIENTS_FILE);
		for (CRMBean b : beans) {
			add((ClientBean) b);
		}
		setIndex(0);	}

	@Override
	public void doLeft() {
		super.doLeft();
		System.out.println("ClientModel.doLeft()");
	}

	@Override
	public void doRight() {
		super.doRight();
		System.out.println("ClientModel.doRight()");
	}

	@Override
	public void doEdit() {
		super.doEdit();
		System.out.println("ClientModel.doEdit()");
	}

	@Override
	public void doAdd() {
		System.out.println("ClientModel.doAdd()");
		int id = 1;
		if (this.getCount() > 0) {
			id = ((ClientBean) this.getBean(this.getCount()-1)).getId() + 1;
		}
		this.add(new ClientBean(id));
		this.setIndex(this.getCount() - 1);
	}

	@Override
	public void doDelete() {
		super.doDelete();
		System.out.println("ClientModel.doDelete()");

	}

	@Override
	public void doSave() {
		System.out.println("ClientModel.doSave()");
		//super.doSave();
		saveClientBeansCSV(CLIENTS_FILE);
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
				ClientBean newBean = new ClientBean(id);
				System.out.println("Next ID: " + ID);
				String company = inputScanner.next();
				newBean.setCompany(company);
				System.out.println("Next Company: " + company);
				String website = inputScanner.next();
				newBean.setWebsite(website);
				System.out.println("Next Website: " + website);
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
	
	protected void saveClientBeansCSV(String filename) {
		
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
	
	public String beanToFileLine(CRMBean bean) {

		String result = "";
		ClientBean cb = (ClientBean) bean;
		result += cb.getId();
		result += '\t';
		result += cb.getCompany();
		result += '\t';
		result += '\t';
		result += cb.getTelephone();
		result += '\t';
		result += cb.getWebsite();
		result += '\t';
		result += cb.getEmail();
		result += '\t';
		result += cb.getFacebook();
		return result;
		
	}

}
