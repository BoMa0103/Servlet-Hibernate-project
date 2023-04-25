package ua.cn.stu.dao;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import ua.cn.stu.domain.Work;

import java.util.List;

public class WorkDAO {
    private Session session;

    public WorkDAO(Session session) {
        this.session = session;
    }
    
    public Work getWorkByCode(Long workCode) {
    	session = HibernateDAOFactory.getInstance().getSession();
    	Work work = (Work) session.get(Work.class, workCode);
    	session.close();
    	return work;
    }
    
    /**
     * This method create new entity
     */
    public Work createWork(Work work) {
    	session = HibernateDAOFactory.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
        	session.saveOrUpdate(work);
       	 	transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}
        session.close();
        return work;
    }

    /**
     * This method update existing product
     */
    public Work updateWork(Work work) {
    	session = HibernateDAOFactory.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
        	session.merge(work);
       	 	transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}
        session.close();
        return work;
    }
    /**
     * This method delete existing product
     */
    public void deleteWork(Work work) {
    	session = HibernateDAOFactory.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
        	session.delete(work);
       	 	transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}
        session.close();
    }
    /**
     * This method remove entity by Number
     */
    public void deleteWorkByCode(Long workCode) {
    	session = HibernateDAOFactory.getInstance().getSession();
        Work work = (Work) session.get(Work.class, workCode);
        Transaction transaction = session.beginTransaction();
        try {
        	session.delete(work);
       	 	transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}
        session.close();
    }
    /**
     * This method return all entities
     */
    public List<Work> getAllWorks() {
    	session = HibernateDAOFactory.getInstance().getSession();
        SQLQuery query = session.createSQLQuery(
                "select * from Work").addEntity(Work.class);
        List<Work> WorkList = query.list();
        session.close();
        return WorkList;
    }
    /**
     * This method return all Works by name
     * This method is specific for Work domain object
     *instead of other methods from this class
     * All other methods can be moved to generic class and
     *can be used for other domain objects.
     */
    public List<Work> getWorksByPositionCode(String positionCode) {
    	session = HibernateDAOFactory.getInstance().getSession();
        Criteria criteria = session.createCriteria(Work.class).add(Restrictions.eq("position_code", positionCode));
        List<Work> list = criteria.list();
        session.close();
        return list;
    }
}
