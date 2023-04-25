package ua.cn.stu.dao;

import org.hibernate.Session;


import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import ua.cn.stu.domain.Department;
import ua.cn.stu.domain.Education;
import ua.cn.stu.domain.Employee;
import ua.cn.stu.domain.Log;
import ua.cn.stu.domain.Passport;
import ua.cn.stu.domain.Position;
import ua.cn.stu.domain.Sign;
import ua.cn.stu.domain.Work;

public class HibernateDAOFactory {
	
	private String user_name = "login_user";
	private String user_pass = "login_user";
	
    private static HibernateDAOFactory instance;
    private DepartmentDAO departmentDAO;
    private EmployeeDAO employeeDAO;
    private EducationDAO educationDAO;
    private PassportDAO passportDAO; 
    private WorkDAO workDAO;
    private PositionDAO positionDAO;
    private EmployeeLogsDAO employeeLogsDAO;
    private SignDAO signDAO;
    private Session session;
    
    //Ініціалізація синглетону
    public static HibernateDAOFactory getInstance() {
        if (null == instance) {
            instance = new HibernateDAOFactory();
        }
        return instance;
    }
    
    //Створення обєкта Session для взаємодії з Hibernate
    public Session getSession() {
        if (null == session || !session.isOpen()) {
            Configuration configuration = new Configuration();
            configuration.setProperty(Environment.DRIVER, "org.postgresql.Driver");
            configuration.setProperty(Environment.URL,
                    "jdbc:postgresql://localhost:5432/Department");
            configuration.setProperty(Environment.USER, user_name);
            configuration.setProperty(Environment.PASS, user_pass);
            configuration.setProperty(Environment.DIALECT,
                    "org.hibernate.dialect.PostgreSQLDialect");
            configuration.setProperty(Environment.HBM2DDL_AUTO, "update");
            configuration.setProperty(Environment.SHOW_SQL, "true");
            configuration.addAnnotatedClass(Department.class);
            configuration.addAnnotatedClass(Education.class);
            configuration.addAnnotatedClass(Employee.class);
            configuration.addAnnotatedClass(Passport.class);
            configuration.addAnnotatedClass(Position.class);
            configuration.addAnnotatedClass(Work.class);
            configuration.addAnnotatedClass(Sign.class);
            configuration.addAnnotatedClass(Log.class);
            StandardServiceRegistryBuilder serviceRegistryBuilder = new StandardServiceRegistryBuilder();
            serviceRegistryBuilder.applySettings(configuration.getProperties());
            ServiceRegistry serviceRegistry = serviceRegistryBuilder.build();
            SessionFactory sessionFactory =
                    configuration.buildSessionFactory(serviceRegistry);
            session = sessionFactory.openSession();
        }
        return session;
    }
    
    public void setSession(Session session) {
    	this.session = session;
    }
    
    public void setInstance(HibernateDAOFactory inst) {
    	instance = inst;
    }
    
    public DepartmentDAO getDepartmentDAO() {
        if (null == departmentDAO) {
        	departmentDAO = new DepartmentDAO(getSession());
        }
        return departmentDAO;
    }
    
    public EmployeeDAO getEmployeeDAO() {
        if (null == employeeDAO) {
        	employeeDAO = new EmployeeDAO(getSession());
        }
        return employeeDAO;
    }
    
    public EducationDAO getEducationDAO() {
        if (null == educationDAO) {
        	educationDAO = new EducationDAO(getSession());
        }
        return educationDAO;
    }
    
    public PassportDAO getPassportDAO() {
        if (null == passportDAO) {
        	passportDAO = new PassportDAO(getSession());
        }
        return passportDAO;
    }
    
    public WorkDAO getWorkDAO() {
        if (null == workDAO) {
        	workDAO = new WorkDAO(getSession());
        }
        return workDAO;
    }
    
    public PositionDAO getPositionDAO() {
        if (null == positionDAO) {
        	positionDAO = new PositionDAO(getSession());
        }
        return positionDAO;
    }
    
    public EmployeeLogsDAO getEmployeeLogsDAO() {
        if (null == employeeLogsDAO) {
        	employeeLogsDAO = new EmployeeLogsDAO(getSession());
        }
        return employeeLogsDAO;
    }
    
    public SignDAO getSignDAO() {
        if (null == signDAO) {
        	signDAO = new SignDAO(getSession());
        }
        return signDAO;
    }
    
    public void setUserName(String user_name) {
    	this.user_name = user_name;
    }
    
    public void setUserPass(String user_pass) {
    	this.user_pass = user_pass;
    }
    
    public void closeSession() {
    	getSession().close();
    }
}
