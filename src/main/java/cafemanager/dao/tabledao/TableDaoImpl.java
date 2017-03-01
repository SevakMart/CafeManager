package cafemanager.dao.tabledao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import cafemanager.model.Table;
import cafemanager.model.tablestatus.TableStatus;

import java.util.List;
/**
 * Created by Sevak on 2/25/2017.
 */
@Repository
public class TableDaoImpl implements TableDao {

    private static Logger logger = Logger.getLogger(TableDaoImpl.class);
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    @Transactional
    public void create(Table entity) {
        Session session = sessionFactory.getCurrentSession();
        session.save(entity);
        logger.info(entity+" saved into db");
    }

    @Override
    @Transactional
    public void update(Table entity) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.update(entity);
        logger.info(entity+" updated in db");
    }

    @Override
    public void delete(Table entity) {

    }

    @Override
    @Transactional
    public Table get(long id) {
        Session session = sessionFactory.getCurrentSession();
        logger.info("get table by id: "+id);
        return (Table) session.get(Table.class, id);
    }

    @Override
    @Transactional
    public List<Table> getAll() {
        Session session = sessionFactory.getCurrentSession();
        logger.info("get all tables from db");
        return session.createCriteria(Table.class).add(Restrictions.eq("tableStatus", TableStatus.FREE)).list();
    }
}
