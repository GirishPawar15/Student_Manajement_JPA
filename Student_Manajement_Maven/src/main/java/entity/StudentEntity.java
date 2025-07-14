package entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "studdetails")  
public class StudentEntity {

    @Id
    @Column(name = "ro_No") 
    private int ro_No;
@Column(name ="Name")
private String name;

@Column(name ="address")
private String address;

@Column(name ="mobile")
private String mobile;

@Column(name ="email")
private String email;

@Column(name="std")
private String std;

@Column(name="marks")
private double marks;

public StudentEntity() {}

public int getro_No() {
	return ro_No;
}

public void setro_No(int ro_No) {
	this.ro_No = ro_No;
}

public String getname() {
	return name;
}

public void setname(String name) {
	this.name = name;
}

public String getaddress() {
	return address;
}

public void setaddress(String address) {
	this.address = address;
}

public String getmobile() {
	return mobile;
}

public void setmobile(String mobile) {
	this.mobile = mobile;
}

public String getemail() {
	return email;
}

public void setemail(String email) {
	this.email = email;
}

public String getstd() {
	return std;
}

public void setstd(String std) {
	this.std = std;
}

public double getmarks() {
	return marks;
}

public void setmarks(double marks) {
	this.marks = marks;
}
}