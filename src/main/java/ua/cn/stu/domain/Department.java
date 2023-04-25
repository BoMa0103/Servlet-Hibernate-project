package ua.cn.stu.domain;

import javax.persistence.*;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name = "Department")
public class Department {

    public Department() { }

    public Department(Long departmentNumber, String address, String phone, Integer workingDays, Time startOfWork,
    		Time endOfWork) {
		super();
		this.departmentNumber = departmentNumber;
		this.address = address;
		this.phone = phone;
		this.workingDays = workingDays;
		this.startOfWork = startOfWork;
		this.endOfWork = endOfWork;
	}

	@Id
    @Column(name = "Department_number")
    private Long departmentNumber;

    @Column(name = "Address", nullable = false)
    private String address;

    @Column(name = "Phone", nullable = false)
    private String phone;
    
    @Column(name = "Working_days", nullable = false)
    private Integer workingDays;
    
    @Column(name = "Start_of_work", columnDefinition = "TIME WITHOUT TIME ZONE", nullable = false)
    private Time startOfWork;
    
    @Column(name = "End_of_work", columnDefinition = "TIME WITHOUT TIME ZONE", nullable = false)
    private Time endOfWork;

    @OneToMany(targetEntity = Employee.class , mappedBy = "department", cascade = ALL)
    private List<Employee> employees = new ArrayList<>();
    
    public Long getDepartmentNumber() {
		return departmentNumber;
	}

	public void setDepartmentNumber(Long departmentNumber) {
		this.departmentNumber = departmentNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getWorkingDays() {
		return workingDays;
	}

	public void setWorkingDays(Integer workingDays) {
		this.workingDays = workingDays;
	}

	public Time getStartOfWork() {
		return startOfWork;
	}

	public void setStartOfWork(Time startOfWork) {
		this.startOfWork = startOfWork;
	}

	public Time getEndOfWork() {
		return endOfWork;
	}

	public void setEndOfWork(Time endOfWork) {
		this.endOfWork = endOfWork;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

}
