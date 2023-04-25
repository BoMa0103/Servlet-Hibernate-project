package ua.cn.stu.dao;


import org.hibernate.Criteria;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import ua.cn.stu.domain.Sign;

import java.util.List;

public class SignDAO {
    private Session session;

    public SignDAO(Session session) {
        this.session = session;
    }
    
    public Sign getSignById(Long id) {
    	session = HibernateDAOFactory.getInstance().getSession();
    	Sign sign = (Sign) session.get(Sign.class, id);
    	session.close();
    	return sign;
    }
    
    public Sign getSignByLogin(String login) {
    	session = HibernateDAOFactory.getInstance().getSession();
        Criteria criteria = session.createCriteria(Sign.class).add(Restrictions.eq("login", login));
        if(criteria.list().isEmpty()) {
        	session.close();
        	return null;
        }
        Sign sign = (Sign) criteria.list().get(0);
        session.close();
        return sign;
    }
    
    /**
     * This method create new entity
     */
    public Sign createSign(Sign sign) {
    	session = HibernateDAOFactory.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
        	 session.saveOrUpdate(sign);
        	 transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}
        session.close();
        return sign;
    }
    /**
     * This method update existing product
     */
    public Sign updateSign(Sign sign) {
    	session = HibernateDAOFactory.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
        	session.merge(sign);
       	 	transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}
        session.close();
        return sign;
    }
    /**
     * This method delete existing product
     */
    public void deleteSign(Sign sign) {
    	session = HibernateDAOFactory.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
        	session.delete(sign);
       	 	transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}
        session.close();
    }
    /**
     * This method remove entity by id
     */
    public void deleteSignById(Long signId) {
    	session = HibernateDAOFactory.getInstance().getSession();
    	Sign sign = (Sign) session.get(Sign.class, signId);
    	Transaction transaction = session.beginTransaction();
    	try {
        	session.delete(sign);
       	 	transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}
        session.close();
    }
    /**
     * This method return all entities
     */
    public List<Sign> getAllSigns() {
    	session = HibernateDAOFactory.getInstance().getSession();
        SQLQuery query = session.createSQLQuery(
                "select * from sign").addEntity(Sign.class);
        List<Sign> SignList = query.list();
        session.close();
        return SignList;
    }
    /**
     * This method return all cabins by number
     * This method is specific for Cabin domain object
     *instead of other methods from this class
     * All other methods can be moved to generic class and
     *can be used for other domain objects.
     */
    //public List<Sign> getCabinsByNumber(Integer cabinnumber) {
    //    Criteria criteria = session.createCriteria(Sign.class).add(Restrictions.eq("cabinnumber", cabinnumber));
    //    return criteria.list();
    //}
}
