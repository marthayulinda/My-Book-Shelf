/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.ArrayList;
import entity.MyBookShelf;

import java.util.Collections;
import java.util.Comparator;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.DB;

/**
 *
 * @author marth
 */

public class MyBookRepositoryImpl implements MyBookRepository {
    
     //public ArrayList<Todolist> data = new ArrayList<Todolist>();
    private final DB db;
    
    public MyBookRepositoryImpl() {
        db = new DB();
    }
    
    public ArrayList<MyBookShelf> array = new ArrayList<MyBookShelf>();
    
    @Override
    public ArrayList<MyBookShelf> getAll(String keywords) {
        ArrayList<MyBookShelf> model = new ArrayList<>();

        String query = "SELECT ISBN, title, author, publisher, year, currentPages, totalPages, status FROM myBook";
        ResultSet resultSet = db.get(query, null);
        if (resultSet != null) {
            try {
                while (resultSet.next()) {
                    int ISBN = resultSet.getInt("ISBN");
                    String title = resultSet.getString("title");
                    String author = resultSet.getString("author");
                    String publisher = resultSet.getString("publisher");
                    int year = resultSet.getInt("year");
                    int currentPages = resultSet.getInt("currentPages");
                    int totalPages = resultSet.getInt("totalPages");
                    boolean status = resultSet.getBoolean("status");
                                     
                    MyBookShelf myBookShelf = new MyBookShelf(ISBN, title, author, publisher, year, currentPages, totalPages, status);
                   
                    model.add(myBookShelf);
                }
            } catch (SQLException ex) {
                  System.out.println(ex);
            }
        }
       
        return model;
}

    @Override
    public boolean add(MyBookShelf myBook) {
        
    String query = "INSERT INTO mybook (ISBN, title, author, publisher, year, currentPages, totalPages, status) VALUES (?,?,?,?,?,?, ?, ? )";
        
    String status;
    if (myBook.isArchived()) {
        status = "0";
    } else {
        status = "1";
    }
    String[] values = new String[]{String.valueOf(myBook.getIsbn()), myBook.getTitle(), myBook.getAuthor(), myBook.getPublisher() , String.valueOf(myBook.getYear()), String.valueOf(myBook.getCurrentPages()), String.valueOf(myBook.getTotalPages()), status};
    return db.update(query, values);
}
    
    @Override
    public boolean remove(int isbn) {
        
    String query = "DELETE FROM mybook WHERE isbn = ?";
    String[] values = new String[]{String.valueOf(isbn)};
    return db.update(query, values);
}
    
    @Override
    public boolean changeBook(int isbn, String title) {

        String query = "UPDATE mybook SET title = ? WHERE isbn= ?";
        
        String[] values = new String[]{title, String.valueOf(isbn)};
        return db.update(query, values);
    }
   
    @Override
    public boolean updateReading(int isbn, int currentPages) {
        
    String query = "UPDATE mybook SET currentPages = ? WHERE isbn = ?";
    String[] values = new String[]{String.valueOf(currentPages), String.valueOf(isbn)};
    return db.update(query, values);
}
    
   @Override
    public MyBookShelf get(int isbn) {
    MyBookShelf myBookShelf = null;
    String query = "SELECT * FROM mybook WHERE isbn = ?";
    
    ResultSet resultSet = db.getByISBN(query, isbn);
    if (resultSet != null) {
        try {
            while (resultSet.next()) {

                myBookShelf = new MyBookShelf(
                    resultSet.getInt("ISBN"),
                    resultSet.getString("title"),
                    resultSet.getString("author"),
                    resultSet.getString("publisher"),
                    resultSet.getInt("year"),
                    resultSet.getInt("currentPages"),
                    resultSet.getInt("totalPages"),
                    resultSet.getBoolean("status")
                );

                break;
            }
        } catch (SQLException ex) {
                // Terjadi kesalahan pada JDBC
        }
    }
    return myBookShelf;
    }

    @Override
    public boolean updateArchived(int isbn, boolean isArchived) {
        String query = "UPDATE mybook SET status = ? where isbn = ?";
        String status = "0";
        if (isArchived) {
            status = "1";
        }
        
    String[] values = new String[]{status, String.valueOf(isbn)};
    return db.update(query, values);
    }

}