package companyRecords;

import java.io.Serializable;

public class Date implements Serializable {

	private int date;
	private int month;
	private int year;

	public Date(int date, int month, int year) {
		super();
		if (dateOK(date, month, year)) {
			this.date = date;
			this.month = month;
			this.year = year;
		}

	}

	public boolean dateOK(int date, int month, int year) {
		if ((year > 1000 && year < 9999) && (date >= 1 && date <= 31) && (month >= 1 && month <= 12))
			return true;
		else
			return false;
	}

	public int compare(Date other) {
		if (other.getYear() > this.year)
			return -1;
		else if (other.getYear() < this.year)
			return 1;
		else {
			if (other.getMonth() > this.month)
				return -1;
			else if (other.getMonth() < this.month)
				return 1;
			else {
				if (other.getDate() > this.date)
					return -1;
				else if (other.getDate() < this.date)
					return 1;
				else
					return 0;
			}
		}

	}

	public int getDate() {
		return date;
	}

	public void setDate(int date) {
		this.date = date;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return date + "/" + month + "/" + year + "";
	}
}