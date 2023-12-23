/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repository;

import java.util.ArrayList;

import entity.MyBookShelf;

/**
 *
 * @author marth
 */
public interface MyBookRepository {
    
            ArrayList<MyBookShelf> getAll(String keywords);
            
            MyBookShelf get(int isbn);
            
            boolean add(MyBookShelf myBook);
            
            boolean remove(int isbn);
            
            boolean changeBook(int isbn, String title);
            
            boolean updateReading(int isbn, int currentPages);
            
            boolean updateArchived(int isbn, boolean isArchived);   
}
