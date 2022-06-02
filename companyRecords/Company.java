package companyRecords;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Company {

	public Company() {
// TODO Auto-generated constructor stub
	}

	public static void writeToFile(List<Employee> list) throws IOException {
		FileOutputStream f = new FileOutputStream(new File("src/CompanyRepertory.ser"));
		ObjectOutputStream o = new ObjectOutputStream(f);
		for (Employee emp : list) {
			o.writeObject(emp);
		}
	}

	public static List<Employee> readFromFile() throws IOException, ClassNotFoundException {
		FileInputStream fi = new FileInputStream(new File("src/CompanyRepertory.ser"));
		ObjectInputStream oi = new ObjectInputStream(fi);

		List<Employee> list = new ArrayList<Employee>();
		try {
			for (;;) {
				list.add((Employee) oi.readObject());
			}
		} catch (EOFException e) {
// End of stream
		}
		return list;
	}

	public static List<Employee> getEmployeeListAfterADate(Date d) throws IOException, ClassNotFoundException {

		List<Employee> totalList = readFromFile();
		List<Employee> list = new ArrayList<Employee>();
		for (Employee emp : totalList) {
			if (d.compare(emp.getHiredDate()) < 0)
				list.add(emp);
		}
		return list;
	}

	public static void main(String args[]) throws IOException, ClassNotFoundException {

		Date d = new Date(10, 10, 2010);
		Date d1 = new Date(10, 10, 2011);
		Date d2 = new Date(10, 10, 2012);
		List<Employee> list = new ArrayList<Employee>();
		list.add(new Employee(101, "John", d, "Manager"));
		list.add(new Employee(102, "Jane", d1, "Developer"));
		list.add(new Employee(103, "Sarah", d2, "Tester"));
		writeToFile(list);

		List<Employee> list2 = readFromFile();

		for (Employee emp : list2) {
			System.out.println(emp.toString());
		}

		Date d3 = new Date(9, 10, 2010);
		System.out.println("\nEmployees hired after date: " + d3.toString());

		List<Employee> list3 = getEmployeeListAfterADate(d3);

		for (Employee emp : list3) {
			System.out.println(emp.toString());
		}
		d3.setYear(2011);
		System.out.println("\nEmployees hired after date: " + d3.toString());
		list3 = null;
		list3 = getEmployeeListAfterADate(d3);

		for (Employee emp : list3) {
			System.out.println(emp.toString());
		}
		d3.setYear(2012);
		System.out.println("\nEmployees hired after date: " + d3.toString());
		list3 = null;
		list3 = getEmployeeListAfterADate(d3);

		for (Employee emp : list3) {
			System.out.println(emp.toString());
		}

	}
}