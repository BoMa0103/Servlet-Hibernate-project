package ua.cn.stu.domain;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "Work")
public class Work {

    public Work() { }
	
	public Work(Long workCode, Date dateOfAdoption, Date dateOfDismissal) {
		super();
		this.workCode = workCode;
		this.dateOfAdoption = dateOfAdoption;
		this.dateOfDismissal = dateOfDismissal;
	}

	@Id
    @Column(name = "Work_code")
    private Long workCode;
    
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Position_code", nullable = false)
    private Position position;
	
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Personal_number", nullable = false)
    private Employee employee;

    @Column(name = "Date_of_adoption", nullable = false)
    private Date dateOfAdoption;

    @Column(name = "Date_of_dismissal")
    private Date dateOfDismissal;

	public Long getWorkCode() {
		return workCode;
	}

	public void setWorkCode(Long workCode) {
		this.workCode = workCode;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Date getDateOfAdoption() {
		return dateOfAdoption;
	}

	public void setDateOfAdoption(Date dateOfadoption) {
		this.dateOfAdoption = dateOfadoption;
	}

	public Date getDateOfDismissal() {
		return dateOfDismissal;
	}

	public void setDateOfDismissal(Date dateOfdismissal) {
		this.dateOfDismissal = dateOfdismissal;
	}
	
	public Long getPositionCode() {
		return position.getPositionCode();
	}
	
	public Long getPersonalNumber() {
		return employee.getPersonalNumber();
	}
	
}
