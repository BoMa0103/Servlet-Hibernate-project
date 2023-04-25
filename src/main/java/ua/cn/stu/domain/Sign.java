package ua.cn.stu.domain;

import javax.persistence.*;

@Entity
@Table(name = "Sign")
public class Sign {

    public Sign() { }

	public Sign(Long id, String login, String password, String role) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.role = role;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "Login", unique=true, nullable = false)
    private String login;
    
    @Column(name = "Password", nullable = false)
    private String password;
    
    @Column(name = "Role", nullable = false)
    private String role;

	public Long getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
    
}
