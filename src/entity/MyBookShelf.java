/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;


public class MyBookShelf {
    private int isbn;
    private String title;
    private String author;
    private String publisher;
    private int year;
    private int totalPages;
    private int currentPages;
    private boolean isArchived = false;
    private boolean status;
    private String activity;
    
   
    public MyBookShelf(int isbn, String title, String author, String publisher, int year, int currentPages, int totalPages, boolean isArchived) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.year = year;
        this.totalPages = totalPages;
        this.currentPages = currentPages;
        this.isArchived = isArchived;
    }
    
      
    public MyBookShelf(int isbn, boolean isArchived) {
        this.isbn = isbn;
        this.isArchived = isArchived;
    }

   public  MyBookShelf(){
        
    }
    
    public int getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getYear() {
        return year;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public int getCurrentPages() {
        return currentPages;
    }

    public void setCurrentPages(int currentPages) {
        this.currentPages = currentPages;
    }

    public boolean isArchived() {
        return isArchived;
    }

    public void setArchived(boolean archived) {
        isArchived = archived;
    }
    
    public boolean isStatus() {
            return status;
        }
   
}
