package ua.cn.stu.dao;

import org.hibernate.Criteria;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import ua.cn.stu.domain.Education;

import java.util.List;

public class EducationDAO {
    private Session session;

    public EducationDAO(Session session) {
        this.session = session;
    }
    
    public Education getEducationByNumber(Long diplomaNumber) {
    	session = HibernateDAOFactory.getInstance().getSession();
    	Education education = (Education) session.get(Education.class, diplomaNumber);
    	session.close();
    	return education;
    }
    
    /**
     * This method create new entity
     */
    public Education createEducation(Education education) {
    	session = HibernateDAOFactory.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
        	session.saveOrUpdate(education);
       	 	transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}
        session.close();
        return education;
    }

    /**
     * This method update existing product
     */
    public Education updateEducation(Education education) {
    	session = HibernateDAOFactory.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
        	session.merge(education);
       	 	transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}
        session.close();
        return education;
    }
    /**
     * This method delete existing product
     */
    public void deleteEducation(Education education) {
    	session = HibernateDAOFactory.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
        	session.delete(education);;
       	 	transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}
        session.close();
    }
    /**
     * This method remove entity by Number
     */
    public void deleteEducationByNumber(Long educationNumber) {
    	session = HibernateDAOFactory.getInstance().getSession();
        Education education = (Education) session.get(Education.class, educationNumber);
        Transaction transaction = session.beginTransaction();
        try {
        	session.delete(education);
       	 	transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}
        session.close();
    }
    /**
     * This method return all entities
     */
    public List<Education> getAllEducations() {
    	session = HibernateDAOFactory.getInstance().getSession();
        SQLQuery query = session.createSQLQuery(
                "select * from Education").addEntity(Education.class);
        List<Education> EducationList = query.list();
        session.close();
        return EducationList;
    }
    /**
     * This method return all Educations by name
     * This method is specific for Education domain object
     *instead of other methods from this class
     * All other methods can be moved to generic class and
     *can be used for other domain objects.
     */
    public List<Education> getEducationsBySpecialtyCode(String name) {
    	session = HibernateDAOFactory.getInstance().getSession();
        Criteria criteria = session.createCriteria(Education.class).add(Restrictions.eq("specialty_code", name));
        List<Education> list = criteria.list();
        session.close();
        return list;
    }
}
