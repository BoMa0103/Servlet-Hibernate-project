package ua.cn.stu.dao;


import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.cn.stu.domain.Passport;

import java.util.List;

public class PassportDAO {
    private Session session;

    public PassportDAO(Session session) {
        this.session = session;
    }
    
    public Passport getPassportByNumber(Long passportNumber) {
    	session = HibernateDAOFactory.getInstance().getSession();
    	Passport passport = (Passport) session.get(Passport.class, passportNumber);
    	session.close();
    	return passport;
    }
    
    /**
     * This method create new entity
     */
    public Passport createPassport(Passport passport) {
    	session = HibernateDAOFactory.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
        	session.saveOrUpdate(passport);
       	 	transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}
        session.close();
        return passport;
    }

    /**
     * This method update existing product
     */
    public Passport updatePassport(Passport passport) {
    	session = HibernateDAOFactory.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
        	session.merge(passport);
       	 	transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}
        session.close();
        return passport;
    }
    /**
     * This method delete existing product
     */
    public void deletePassport(Passport passport) {
    	session = HibernateDAOFactory.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
        	session.delete(passport);
       	 	transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}
        session.close();
    }
    /**
     * This method remove entity by Number
     */
    public void deletePassportByNumber(Long passportNumber) {
    	session = HibernateDAOFactory.getInstance().getSession();
        Passport passport = (Passport) session.get(Passport.class, passportNumber);
        Transaction transaction = session.beginTransaction();
        try {
        	session.delete(passport);
       	 	transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}
        session.close();
    }
    /**
     * This method return all entities
     */
    public List<Passport> getAllPassports() {
    	session = HibernateDAOFactory.getInstance().getSession();
        SQLQuery query = session.createSQLQuery(
                "select * from Passport").addEntity(Passport.class);
        List<Passport> PassportList = query.list();
        session.close();
        return PassportList;
    }
}
