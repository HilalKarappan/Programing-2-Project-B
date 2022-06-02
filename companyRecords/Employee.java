package companyRecords;

import java.io.Serializable;

public class Employee implements Serializable {

	private int id;
	private String name;
	private Date hiredDate;
	private String position;

	public Employee(int id, String name, Date hiredDate, String position) {
		this.id = id;
		this.name = name;
		this.hiredDate = hiredDate;
		this.position = position;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getHiredDate() {
		return hiredDate;
	}

	public void setHiredDate(Date hiredDate) {
		this.hiredDate = hiredDate;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "Employee ID: " + id + "\tName: " + name + "\nHiredDate: " + hiredDate.toString() + "\tPosition:"
				+ position + "\n=====================================";
	}

}