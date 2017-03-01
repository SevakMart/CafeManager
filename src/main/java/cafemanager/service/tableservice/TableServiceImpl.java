package cafemanager.service.tableservice;

import cafemanager.dao.userdao.UserDao;
import cafemanager.model.User;
import cafemanager.model.tablestatus.TableStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import cafemanager.dao.tabledao.TableDao;
import cafemanager.model.Table;

import java.util.List;

/**
 * Created by Sevak on 2/25/2017.
 */
@Service
public class TableServiceImpl implements TableService {

    @Autowired
    private TableDao tableDao;
    /**
     * @param entity is table entity
     *               <p>
     *               insert table into db
     */
    @Override
    public void create(Table entity) {
        tableDao.create(entity);
    }

    /**
     *
     * @param entity is table entity
     *               update table entity in db
     */
    @Override
    public void update(Table entity) {
        tableDao.update(entity);
    }

    @Override
    public void delete(Table entity) {

    }

    /**
     * get table by id
     * @param id is table is
     * @return table
     */
    @Override
    public Table get(long id) {
        return tableDao.get(id);
    }

    /**
     * get all tables from db
     * @return List of tables
     */
    @Override
    @Transactional
    public List<Table> getAll() {
        return tableDao.getAll();
    }


}
