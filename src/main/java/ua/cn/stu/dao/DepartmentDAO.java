package ua.cn.stu.dao;


import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.cn.stu.domain.Department;

import java.util.List;

public class DepartmentDAO {
    private Session session;

    public DepartmentDAO(Session session) {
        this.session = session;
    }
    
    public Department getDepartmentByNumber(Long departmentNumber) {
    	session = HibernateDAOFactory.getInstance().getSession();
    	Department department = (Department) session.get(Department.class, departmentNumber);
    	session.close();
    	return department;
    }
    
    /**
     * This method create new entity
     */
    public Department createDepartment(Department department) {
    	session = HibernateDAOFactory.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
        	session.saveOrUpdate(department);
       	 	transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}
        session.close();
        return department;
    }
    /**
     * This method update existing product
     */
    public Department updateDepartment(Department department) {
    	session = HibernateDAOFactory.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
        	session.merge(department);
       	 	transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}
        session.close();
        return department;
    }
    /**
     * This method delete existing product
     */
    public void deleteDepartment(Department department) {
    	session = HibernateDAOFactory.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
        	session.delete(department);
       	 	transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}
        session.close();
    }
    /**
     * This method remove entity by id
     */
    public void deleteDepartmentByNumber(Long departmentNumber) {
    	session = HibernateDAOFactory.getInstance().getSession();
    	Department department = (Department) session.get(Department.class, departmentNumber);
    	Transaction transaction = session.beginTransaction();
    	try {
    		session.delete(department);
       	 	transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}
        session.close();
    }
    /**
     * This method return all entities
     */
    public List<Department> getAllDepartments() {
    	session = HibernateDAOFactory.getInstance().getSession();
        SQLQuery query = session.createSQLQuery(
                "select * from Department").addEntity(Department.class);
        List<Department> departmentList = query.list();
        session.close();
        return departmentList;
    }
    
    public List<Object> getAllDepartmentEmployees() {
    	session = HibernateDAOFactory.getInstance().getSession();
        SQLQuery query = session.createSQLQuery(
                "select * from department_employees");
        List<Object> departmentList = query.list();
        session.close();
        return departmentList;
    }
    /**
     * This method return all cabins by number
     * This method is specific for Cabin domain object
     *instead of other methods from this class
     * All other methods can be moved to generic class and
     *can be used for other domain objects.
     */
    //public List<Department> getCabinsByNumber(Integer cabinnumber) {
    //    Criteria criteria = session.createCriteria(Department.class).add(Restrictions.eq("cabinnumber", cabinnumber));
    //    return criteria.list();
    //}
}
