package ua.cn.stu.domain;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.CascadeType.ALL;

@Entity
@Table(name = "Position")
public class Position {

    public Position() { }
    
    public Position(Long positionCode, String name, BigDecimal salary, Integer numberOfHours) {
		super();
		this.positionCode = positionCode;
		this.name = name;
		this.salary = salary;
		this.numberOfHours = numberOfHours;
	}
    
	@Id
    @Column(name = "Position_code", nullable = false)
    private Long positionCode;

    @Column(name = "Name", nullable = false)
    private String name;

	@Column(name = "Salary", nullable = false)
    private BigDecimal salary;
    
    @Column(name = "Number_of_hours", nullable = false)
    private Integer numberOfHours;

    @OneToMany(targetEntity = Work.class , mappedBy = "position", cascade = ALL)
    private List<Work> works = new ArrayList<>();

	public Long getPositionCode() {
		return positionCode;
	}

	public void setPositionCode(Long positionCode) {
		this.positionCode = positionCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

	public Integer getNumberOfHours() {
		return numberOfHours;
	}

	public void setNumberOfHours(Integer numberOfHours) {
		this.numberOfHours = numberOfHours;
	}

	public List<Work> getWorks() {
		return works;
	}

	public void setWorks(List<Work> works) {
		this.works = works;
	}

    
}
