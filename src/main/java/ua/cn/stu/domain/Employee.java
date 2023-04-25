package ua.cn.stu.domain;

import javax.persistence.*;

@Entity
@Table(name = "Employee")
public class Employee {

    public Employee() { }
    
    public Employee(Long personalNumber, String name, String phone) {
		super();
		this.personalNumber = personalNumber;
		this.name = name;
		this.phone = phone;
	}
    
    @Id
    @Column(name = "Personal_number")
    private Long personalNumber;

    @Column(name = "Name", nullable = false)
    private String name;

    @Column(name = "Phone", nullable = false)
    private String phone;

	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Department_number", nullable = false)
    private Department department;
    

    public Long getPersonalNumber() {
		return personalNumber;
	}

	public void setPersonalNumber(Long personalNumber) {
		this.personalNumber = personalNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public Long getDepartmentNumber() {
		return department.getDepartmentNumber();
	}

}
