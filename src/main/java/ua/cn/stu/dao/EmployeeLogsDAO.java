package ua.cn.stu.dao;


import org.hibernate.SQLQuery;

import org.hibernate.Session;
import ua.cn.stu.domain.Log;

import java.util.List;

public class EmployeeLogsDAO {
    private Session session;

    public EmployeeLogsDAO(Session session) {
        this.session = session;
    }
    
    public Log getEmployeeLogsById(Long EmployeeLogsId) {
    	session = HibernateDAOFactory.getInstance().getSession();
    	Log EmployeeLogs = (Log) session.get(Log.class, EmployeeLogsId);
    	session.close();
    	return EmployeeLogs;
    }
    /**
     * This method return all entities
     */
    public List<Log> getAllEmployeeLogs() {
    	session = HibernateDAOFactory.getInstance().getSession();
        SQLQuery query = session.createSQLQuery(
                "select * from log").addEntity(Log.class);
        List<Log> EmployeeLogsList = query.list();
        session.close();
        return EmployeeLogsList;
    }
    /**
     * This method return all cabins by number
     * This method is specific for Cabin domain object
     *instead of other methods from this class
     * All other methods can be moved to generic class and
     *can be used for other domain objects.
     */
    //public List<EmployeeLogs> getCabinsByNumber(Integer cabinnumber) {
    //    Criteria criteria = session.createCriteria(EmployeeLogs.class).add(Restrictions.eq("cabinnumber", cabinnumber));
    //    return criteria.list();
    //}
}
