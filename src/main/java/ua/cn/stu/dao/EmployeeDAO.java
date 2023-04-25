package ua.cn.stu.dao;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import ua.cn.stu.domain.Employee;

import java.util.List;

public class EmployeeDAO {
    private Session session;

    public EmployeeDAO(Session session) {
        this.session = session;
    }
    
    public Employee getEmployeeByNumber(Long employeeNumber) {
    	session = HibernateDAOFactory.getInstance().getSession();
    	Employee Employee = (Employee) session.get(Employee.class, employeeNumber);
    	session.close();
    	return Employee;
    }
    
    /**
     * This method create new entity
     */
    public Employee createEmployee(Employee employee) {
    	session = HibernateDAOFactory.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
        	session.saveOrUpdate(employee);
       	 	transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}
        session.close();
        return employee;
    }

    /**
     * This method update existing product
     */
    public Employee updateEmployee(Employee employee) {
    	session = HibernateDAOFactory.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
        	session.merge(employee);
       	 	transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}
        session.close();
        return employee;
    }
    /**
     * This method delete existing product
     */
    public void deleteEmployee(Employee employee) {
    	session = HibernateDAOFactory.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
        	session.delete(employee);
       	 	transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}
        session.close();
    }
    /**
     * This method remove entity by Number
     */
    public void deleteEmployeeByNumber(Long employeeNumber) {
    	session = HibernateDAOFactory.getInstance().getSession();
        Employee employee = (Employee) session.get(Employee.class, employeeNumber);
        Transaction transaction = session.beginTransaction();
        try {
        	session.delete(employee);
       	 	transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}
        session.close();
    }
    /**
     * This method return all entities
     */
    public List<Employee> getAllEmployees() {
    	session = HibernateDAOFactory.getInstance().getSession();
        SQLQuery query = session.createSQLQuery(
                "select * from Employee").addEntity(Employee.class);
        List<Employee> EmployeeList = query.list();
        session.close();
        return EmployeeList;
    }
    /**
     * This method return all Employees by name
     * This method is specific for Employee domain object
     *instead of other methods from this class
     * All other methods can be moved to generic class and
     *can be used for other domain objects.
     */
    public List<Employee> getEmployeesByName(String name) {
    	session = HibernateDAOFactory.getInstance().getSession();
        Criteria criteria = session.createCriteria(Employee.class).add(Restrictions.eq("name", name));
        List<Employee> EmployeeList = criteria.list();
        session.close();
        return EmployeeList;
    }

	public List<Employee> getEmployeesByDepartmentNumber(Long departmentNumber) {
		session = HibernateDAOFactory.getInstance().getSession();
		SQLQuery query = session.createSQLQuery(
                "select * from Employee where Department_number="+departmentNumber).addEntity(Employee.class);
        List<Employee> EmployeeList = query.list();
        session.close();
        return EmployeeList;
	}
}
