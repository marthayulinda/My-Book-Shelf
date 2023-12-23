/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import entity.MyBookShelf;
import javax.swing.JTable;

/**
 *
 * @author user
 */
public interface BookShelfService {
    
    void addBook (int isbn, String title, String author, String publisher, int year, int currentPages, int totalPages, boolean isArchived);
    
    void removeBook (int isbn);
   
    void showBook(String keywords);
    
    void showBook2(String keywords);
    
    void changeBook(int isbn, String title);
    
    void updateReadBook(int isbn, int currentPages);
    
    void updateArchivedBook(int isbn, boolean isArchived);
    
    void setTableBook (JTable tblList);
    
    void setTableBook2(JTable tblArchieved);
    
    void tableHandling();
    
    void tableHandling2();
    
    void loadData(String keywords);
    
    void loadData2(String keywords);
    
    public MyBookShelf getByIsbn(int isbn);
}
