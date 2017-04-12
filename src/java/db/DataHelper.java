/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import entity.Book;
import entity.Genre;
import entity.HibernateUtil;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author IT10
 */
public class DataHelper {
    
    SessionFactory sessionFactory = null;
    
    private DataHelper() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }
    
    public static DataHelper getInstance() {
        return DataHelperHolder.INSTANCE;
    }
    
    private static class DataHelperHolder {

        private static final DataHelper INSTANCE = new DataHelper();
    }
    
    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    
    public List<Book> getAllBooks() {
        return getSession().createCriteria(Book.class).list();
    }
    
    public List<Genre> getGenres() {
        return getSession().createCriteria(Genre.class).list();
    }

}
