package ua.cn.stu.databean;
import java.util.List;
import ua.cn.stu.dao.HibernateDAOFactory;
import ua.cn.stu.domain.Passport;

public class PassportListDatabean {
	private List<Passport> passportList;
	
	private static Long passportNumber;

	public PassportListDatabean() {
		passportList = HibernateDAOFactory.getInstance().getPassportDAO().getAllPassports();
	}

	public Long getPassportNumber() {
		return passportNumber;
	}
	
	public void setPassportNumber(Long passportNumber) {
		PassportListDatabean.passportNumber = passportNumber;
	}

	public List<Passport> getPassportList() {
		return passportList;
	}

	public void setPassportList(List<Passport> passportList) {
		this.passportList = passportList;
	}
}
