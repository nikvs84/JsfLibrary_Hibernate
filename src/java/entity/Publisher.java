package entity;
// Generated Apr 12, 2017 10:03:08 AM by Hibernate Tools 4.3.1

import java.util.HashSet;
import java.util.Set;




/**
 * Publisher generated by hbm2java
 */
public class Publisher  implements java.io.Serializable {


     private Long id;
     private String name;
     private Set books = new HashSet(0);

    public Publisher() {
    }

    public Publisher(String name) {
       this.name = name;
    }
    
    public Publisher(String name, Set books) {
        this.name = name;
        this.books = books;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public Set getBooks() {
        return books;
    }

    public void setBooks(Set books) {
        this.books = books;
    }




}


