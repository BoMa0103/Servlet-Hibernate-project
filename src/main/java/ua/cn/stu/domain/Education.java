package ua.cn.stu.domain;

import javax.persistence.*;

@Entity
@Table(name = "Education")
public class Education {

    public Education() { }
    
    public Education(Long diplomaNumber, Integer specialtyCode, String nameOfSpecialty) {
		super();
		this.diplomaNumber = diplomaNumber;
		this.specialtyCode = specialtyCode;
		this.nameOfSpecialty = nameOfSpecialty;
	}

	@Id
    @Column(name = "Diploma_number")
    private Long diplomaNumber;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Personal_number", nullable = false)
    private Employee employee;

    @Column(name = "Specialty_code", nullable = false)
    private Integer specialtyCode;

    @Column(name = "Name_of_specialty", nullable = false)
    private String nameOfSpecialty;

	public Long getDiplomaNumber() {
		return diplomaNumber;
	}

	public void setDiplomaNumber(Long diplomaNumber) {
		this.diplomaNumber = diplomaNumber;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Integer getSpecialtyCode() {
		return specialtyCode;
	}

	public void setSpecialtyCode(Integer specialtyCode) {
		this.specialtyCode = specialtyCode;
	}

	public String getNameOfSpecialty() {
		return nameOfSpecialty;
	}

	public void setNameOfSpecialty(String nameOfSpecialty) {
		this.nameOfSpecialty = nameOfSpecialty;
	}
	
	public Long getPersonalNumber() {
		return employee.getPersonalNumber();
	}
    
}
