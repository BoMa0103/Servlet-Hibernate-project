package ua.cn.stu.domain;

import javax.persistence.*;

import java.sql.Time;

@Entity
@Table(name = "Log")
public class Log {

    public Log() { }

	public Log(Long id, Integer personalNumber, String name, String phone, Integer departmentNumber,
			Time added, String action, String client) {
		super();
		this.id = id;
		this.personalNumber = personalNumber;
		this.name = name;
		this.phone = phone;
		this.departmentNumber = departmentNumber;
		this.added = added;
		this.action = action;
		this.client = client;
	}

	@Id
	@Column(columnDefinition = "SERIAL")
    private Long id;

    @Column(name = "Personal_number", nullable = false)
    private Integer personalNumber;

    @Column(name = "Name", nullable = false)
    private String name;
    
    @Column(name = "Phone", nullable = false)
    private String phone;
    
    @Column(name = "Department_number", nullable = false)
    private Integer departmentNumber;
    
    @Column(name = "Added", columnDefinition = "TIME WITHOUT TIME ZONE", nullable = false)
    private Time added;
    
    @Column(name = "Action", nullable = false)
    private String action;
    
    @Column(name = "Client", nullable = false)
    private String client;

	public Long getId() {
		return id;
	}

	public Integer getPersonalNumber() {
		return personalNumber;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public Integer getDepartmentNumber() {
		return departmentNumber;
	}

	public Time getAdded() {
		return added;
	}

	public String getAction() {
		return action;
	}

	public String getClient() {
		return client;
	}

}
