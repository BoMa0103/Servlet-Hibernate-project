package ua.cn.stu.dao;


import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import ua.cn.stu.domain.Position;

import java.util.List;

public class PositionDAO {
    private Session session;

    public PositionDAO(Session session) {
        this.session = session;
    }
    
    public Position getPositionByCode(Long positionCode) {
    	session = HibernateDAOFactory.getInstance().getSession();
    	Position position = (Position) session.get(Position.class, positionCode);
    	session.close();
    	return position;
    }
    
    /**
     * This method create new entity
     */
    public Position createPosition(Position position) {
    	session = HibernateDAOFactory.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
        	session.saveOrUpdate(position);
       	 	transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}
        session.close();
        return position;
    }
    /**
     * This method update existing product
     */
    public Position updatePosition(Position position) {
    	session = HibernateDAOFactory.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
        	session.merge(position);
       	 	transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}
        session.close();
        return position;
    }
    /**
     * This method delete existing product
     */
    public void deletePosition(Position position) {
    	session = HibernateDAOFactory.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
        	session.delete(position);
       	 	transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}
        session.close();
    }
    /**
     * This method remove entity by id
     */
    public void deletePositionByCode(Long positionCode) {
    	session = HibernateDAOFactory.getInstance().getSession();
    	Position position = (Position) session.get(Position.class, positionCode);
    	Transaction transaction = session.beginTransaction();
    	try {
    		session.delete(position);
       	 	transaction.commit();
		} catch (Exception e) {
			transaction.rollback();
		}
        session.close();
    }
    /**
     * This method return all entities
     */
    public List<Position> getAllPositions() {
    	session = HibernateDAOFactory.getInstance().getSession();
        SQLQuery query = session.createSQLQuery(
                "select * from Position").addEntity(Position.class);
        List<Position> cabinList = query.list();
        session.close();
        return cabinList;
    }
    /**
     * This method return all cabins by number
     * This method is specific for Cabin domain object
     *instead of other methods from this class
     * All other methods can be moved to generic class and
     *can be used for other domain objects.
     */
    //public List<Position> getCabinsByNumber(Integer cabinnumber) {
    //    Criteria criteria = session.createCriteria(Position.class).add(Restrictions.eq("cabinnumber", cabinnumber));
    //    return criteria.list();
    //}
}
