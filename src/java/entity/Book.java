package entity;
// Generated Apr 12, 2017 10:03:08 AM by Hibernate Tools 4.3.1



/**
 * Book generated by hbm2java
 */
public class Book  implements java.io.Serializable {


     private Long id;
     private Author author;
     private Genre genre;
     private String name;
     private byte[] content;
     private int pageCount;
     private String isbn;
     private int publishYear;
     private long publisherId;
     private byte[] image;
     private String descr;
     private String bookcol;

    public Book() {
    }

	
    public Book(Author author, Genre genre, String name, byte[] content, int pageCount, String isbn, int publishYear, long publisherId) {
        this.author = author;
        this.genre = genre;
        this.name = name;
        this.content = content;
        this.pageCount = pageCount;
        this.isbn = isbn;
        this.publishYear = publishYear;
        this.publisherId = publisherId;
    }
    public Book(Author author, Genre genre, String name, byte[] content, int pageCount, String isbn, int publishYear, long publisherId, byte[] image, String descr, String bookcol) {
       this.author = author;
       this.genre = genre;
       this.name = name;
       this.content = content;
       this.pageCount = pageCount;
       this.isbn = isbn;
       this.publishYear = publishYear;
       this.publisherId = publisherId;
       this.image = image;
       this.descr = descr;
       this.bookcol = bookcol;
    }
   
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    public Author getAuthor() {
        return this.author;
    }
    
    public void setAuthor(Author author) {
        this.author = author;
    }
    public Genre getGenre() {
        return this.genre;
    }
    
    public void setGenre(Genre genre) {
        this.genre = genre;
    }
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    public byte[] getContent() {
        return this.content;
    }
    
    public void setContent(byte[] content) {
        this.content = content;
    }
    public int getPageCount() {
        return this.pageCount;
    }
    
    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
    public String getIsbn() {
        return this.isbn;
    }
    
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public int getPublishYear() {
        return this.publishYear;
    }
    
    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }
    public long getPublisherId() {
        return this.publisherId;
    }
    
    public void setPublisherId(long publisherId) {
        this.publisherId = publisherId;
    }
    public byte[] getImage() {
        return this.image;
    }
    
    public void setImage(byte[] image) {
        this.image = image;
    }
    public String getDescr() {
        return this.descr;
    }
    
    public void setDescr(String descr) {
        this.descr = descr;
    }
    public String getBookcol() {
        return this.bookcol;
    }
    
    public void setBookcol(String bookcol) {
        this.bookcol = bookcol;
    }




}

