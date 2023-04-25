package ua.cn.stu.domain;

import java.sql.Date;


import javax.persistence.*;

@Entity
@Table(name = "Passport")
public class Passport {

    public Passport() { }
    
	public Passport(Long passportNumber,Date dateOfBirth, String homeAddress, String sex) {
		super();
		this.passportNumber = passportNumber;
		this.dateOfBirth = dateOfBirth;
		this.homeAddress = homeAddress;
		this.sex = sex;
	}
	
	@Id
    @Column(name = "Passport_number")
    private Long passportNumber;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Personal_number", nullable = false)
    private Employee employee;

    @Column(name = "Date_of_birth", nullable = false)
    private Date dateOfBirth;

    @Column(name = "Home_address", nullable = false)
    private String homeAddress;
    
    @Column(name = "Sex", nullable = false)
    private String sex;

	public Long getPassportNumber() {
		return passportNumber;
	}

	public void setPassportNumber(Long passportNumber) {
		this.passportNumber = passportNumber;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getHomeAddress() {
		return homeAddress;
	}

	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
	
	public Long getPersonalNumber() {
		return employee.getPersonalNumber();
	}
	
}
