/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import entity.Book;
import entity.Genre;
import entity.HibernateUtil;
import enums.SearchType;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author IT10
 */
public class DataHelper {
    
    private SessionFactory sessionFactory = null;
    DetachedCriteria currentCriteria;
    
    ArrayList<Book> currentBookList;
    
    private int start = 0;
    private int count = 0;
    
    private int total = 0;
    
    private DataHelper() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }
    
    public static DataHelper getInstance() {
        return DataHelperHolder.INSTANCE;
    }
    
    private static class DataHelperHolder {

        private static final DataHelper INSTANCE = new DataHelper();
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }
    
    public ArrayList<Book> getAllBooks() {
        return (ArrayList<Book>) getSession().createCriteria(Book.class).list();
    }
    
    public ArrayList<Genre> getGenres() {
        return (ArrayList<Genre>) getSession().createCriteria(Genre.class).list();
    }
    
    public ArrayList<Book> getBooksByGenres(long id, int ... limits) {
        Criteria criteria = getSession().createCriteria(Book.class);
//        criteria.createAlias("genre", "genre");
        Criterion criterion = Restrictions.eq("genre.id", id);
        criteria.add(criterion);
        
        setTotal(getTotal(criteria));
        System.out.println("total = " + this.getTotal());
        
        currentCriteria = DetachedCriteria.forClass(Book.class);
        currentCriteria.add(criterion);
        
        runCurrentCriteria(limits);
        
        return this.currentBookList;
    }
    
    public ArrayList<Book> getBooksByLetter (String letter, int ... limits) {
        Criteria criteria = getSession().createCriteria(Book.class);
        Criterion criterion = Restrictions.ilike("name", letter, MatchMode.START);
        criteria.add(criterion);
        
        setTotal(getTotal(criteria));
        
        currentCriteria = DetachedCriteria.forClass(Book.class);
        currentCriteria.add(criterion);
        
        runCurrentCriteria(limits);
        return this.currentBookList;
    }
    
    public ArrayList<Book> getBooksBySearch (String search, SearchType searchType, int ... limits) {
        Criteria criteria = getSession().createCriteria(Book.class, "book");
        Criterion criterion;
        
        switch (searchType) {
            case AUTHOR:
                criteria.createAlias("book.author", "author");
                criterion = Restrictions.ilike("author.fio", search, MatchMode.ANYWHERE);
                break;
            case TITLE:
                criterion = Restrictions.ilike("name", search, MatchMode.ANYWHERE);
                break;
            default:
                criterion = null;
        }
        
        criteria.add(criterion);
        
        setTotal(getTotal(criteria));
        
        currentCriteria = DetachedCriteria.forClass(Book.class, "book").createAlias("book.author", "author");
        currentCriteria.add(criterion);
        
        runCurrentCriteria(limits);
        
        return this.currentBookList;
    }

// Utils -----------------------------------------------------------------------    
    private void setLimits(int ... limits) {
        if (limits.length > 1) {
            start = limits[0];
            count = limits[1];
        }
    }
    
    private int getTotal(Criteria criteria) {
        criteria.setProjection(Projections.rowCount());
        Long rowCount = (Long) criteria.uniqueResult();
        return rowCount.intValue();
    }
    
    private Criteria getBookCriteria(int ... limits) {
        Criteria criteria = getSession().createCriteria(Book.class);
        setCriteriaLimits(criteria, limits);
        
        return criteria;
    }
    
    private void runCurrentCriteria(int ... limits) {
        Criteria criteria = currentCriteria.getExecutableCriteria(getSession());
        setCriteriaLimits(criteria, limits);
        
        this.currentBookList = (ArrayList<Book>) criteria.list();
    }
    
    private void setCriteriaLimits(Criteria criteria, int ... limits) {
        setLimits(limits);
        criteria.setFirstResult(start);
        if (count > 0)
            criteria.setMaxResults(count);
    }
}
