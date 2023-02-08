package Bank;

import java.util.ArrayList;

public class Account {
	
	public int accno;
	public static int caccno=1001;
	public String name;
	public int bal;
	
	public Account() {}

	public Account(String name, int bal) 
	{
		
		this.name = name;
		this.bal = bal;
		this.accno = caccno++;
	}
	
	public int getAccno() {
		return accno;
	}

	public void setAccno(int accno) {
		this.accno = accno;
	}

	public static int getCaccno() {
		return caccno;
	}

	public static void setCaccno(int caccno) {
		Account.caccno = caccno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBal() {
		return bal;
	}

	public void setBal(int bal) {
		this.bal = bal;
	}

	@Override
	public String toString() {
		return "Account [accno=" + accno + ", name=" + name + ", bal=" + bal + "]";
	}
}
