/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

import java.util.ArrayList;
import entity.MyBookShelf;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;

import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import repository.MyBookRepository;
import util.ButtonEditor;

/**
 *
 * @author user
 */
public class BookShelfServiceImpl implements BookShelfService {

    private MyBookRepository myBookRepository;
    private JTable tblList;
    private JTable tblArchieved;

    public BookShelfServiceImpl(MyBookRepository myBookRepository) {
        this.myBookRepository = myBookRepository;
    }

    @Override
    public MyBookShelf getByIsbn(int isbn) {
        return myBookRepository.get(isbn);
    }

    @Override
    public void setTableBook(JTable tblList) {
        this.tblList = tblList;
        showBook(null);
    }

    @Override
    public void setTableBook2(JTable tblArchieved) {
        this.tblArchieved = tblArchieved;
        showBook2(null);
    }

    @Override
    public void tableHandling() {

        try {
            JTable tblBook = this.tblList;
            tblBook.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(new JTextField()) {
                @Override
                public boolean isCellEditable(EventObject anEvent) {
                    return false;
                }
            });

            {
                ButtonEditor btnDeleteEditor = new ButtonEditor(new JCheckBox());
                // Menambahkan ActionListener ke Button yang ada di Button Editor
                btnDeleteEditor.button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int row = tblBook.getSelectedRow();
                        int column = tblBook.getSelectedColumn();
                        DefaultTableModel model = (DefaultTableModel) tblBook.getModel();

                        if (row >= 0 && column == 7) {
                            int ID = (int) model.getValueAt(row, 0);
                            removeBook(ID);
                            model.removeRow(row);
                        }
                    }
                });
                // Menambahkan Button Editor ke JTable
                tblBook.getColumnModel().getColumn(7).setCellRenderer(new util.ButtonRenderer());
                tblBook.getColumnModel().getColumn(7).setCellEditor(btnDeleteEditor);
            }

            {
                // Menambahkan CellEditorListener untuk menangkap perubahan pada kolom di JTable
                tblBook.getDefaultEditor(String.class).addCellEditorListener(new CellEditorListener() {
                    @Override
                    public void editingStopped(ChangeEvent e) {
                        int row = tblBook.getSelectedRow();
                        int column = tblBook.getSelectedColumn();
                        if (row >= 0 && column >= 0) {
                            String selectedValue = tblBook.getValueAt(row, column).toString();
                            System.out.println("Cell di baris " + row + ", kolom " + column + " diubah menjadi: " + selectedValue);

                            // Pastikan tblList memiliki cukup baris
                            if (tblList.getRowCount() > row) {
                                changeBook((Integer) tblList.getValueAt(row, 0), selectedValue);
                                showBook("");
                            } else {
                                System.out.println("Sukses mengubah judul buku");
                            }
                        } else {
                            System.out.println("Sukses mengubah judul buku");
                        }

                    }

                    @Override
                    public void editingCanceled(ChangeEvent e) {
                        // aksi jika pengiditan dibatalkan
                    }
                });
            }
        } catch (Error | Exception e) {

        }
    }

    @Override
    public void tableHandling2() {

        try {
            JTable tblBook = this.tblArchieved;
            tblArchieved.getColumnModel().getColumn(0).setCellEditor(new DefaultCellEditor(new JTextField()) {
                @Override
                public boolean isCellEditable(EventObject anEvent) {
                    return false;
                }
            });

            {
                ButtonEditor btnUnarchievedEditor = new ButtonEditor(new JCheckBox());
                // Menambahkan ActionListener ke Button yang ada di Button Editor
                btnUnarchievedEditor.button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int row = tblArchieved.getSelectedRow();
                        int column = tblArchieved.getSelectedColumn();
                        DefaultTableModel model = (DefaultTableModel) tblBook.getModel();

                        if (row >= 0 && column == 6) {
                            int ID = (int) model.getValueAt(row, 0);

                            removeBook(ID);
                            model.removeRow(row);
                        }
                    }
                });
                // Menambahkan Button Editor ke JTable
                tblBook.getColumnModel().getColumn(6).setCellRenderer(new util.ButtonRenderer());
                tblBook.getColumnModel().getColumn(6).setCellEditor(btnUnarchievedEditor);
            }

            {
                // Menambahkan CellEditorListener untuk menangkap perubahan pada kolom di JTable
                tblBook.getDefaultEditor(String.class).addCellEditorListener(new CellEditorListener() {
                    @Override
                    public void editingStopped(ChangeEvent e) {
                        int row = tblBook.getSelectedRow();
                        int column = tblBook.getSelectedColumn();
                        String selectedValue = tblBook.getValueAt(row, column).toString();
                        System.out.println("Cell di baris " + row + ", kolom " + column + " diubah menjadi: " + selectedValue);
                        changeBook((Integer) tblArchieved.getValueAt(row, 0), selectedValue);
                        showBook2("");
                    }

                    @Override
                    public void editingCanceled(ChangeEvent e) {
                        // aksi jika pengiditan dibatalkan
                    }
                });
            }
        } catch (Error | Exception e) {

        }
    }

    @Override
    public void loadData(String keywords) {
        JTable tblBook = this.tblList;

        ArrayList<MyBookShelf> model = myBookRepository.getAll(keywords);
        DefaultTableModel tableModel = new DefaultTableModel(null, new Object[]{"isbn", "Title", "Author", "Publisher", "Year", "Total Pages", "Current Pages", "Action"}) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return true;
            }
        };

        tblBook.setModel(tableModel);
        tblBook.setCellSelectionEnabled(false);
        tblBook.setRowSelectionAllowed(true);
        tblBook.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblBook.setRowHeight(40);

        TableColumnModel columnModel = tblBook.getColumnModel();

        TableColumn columnISBN = columnModel.getColumn(0);
        columnISBN.setPreferredWidth(84);

        TableColumn columnTitle = columnModel.getColumn(1);
        columnTitle.setPreferredWidth(170);

        TableColumn columnAuthor = columnModel.getColumn(2);
        columnAuthor.setPreferredWidth(150);

        TableColumn columnPublisher = columnModel.getColumn(3);
        columnPublisher.setPreferredWidth(150);

        TableColumn columnYear = columnModel.getColumn(4);
        columnYear.setPreferredWidth(85);

        TableColumn columnTotalPages = columnModel.getColumn(5);
        columnTotalPages.setPreferredWidth(85);

        TableColumn columnCurrentPages = columnModel.getColumn(6);
        columnCurrentPages.setPreferredWidth(85);

        TableColumn columnAction = columnModel.getColumn(7);
        columnAction.setPreferredWidth(95);

        if (!model.isEmpty()) {
            for (var i = 0; i < model.size(); i++) {
                var myBook = model.get(i);
                if (myBook.isArchived()) {
                    if (keywords == null || (myBook != null && myBook.getTitle().contains(keywords))) {
                        tableModel.addRow(new Object[]{myBook.getIsbn(), myBook.getTitle(), myBook.getAuthor(), myBook.getPublisher(), myBook.getYear(), myBook.getTotalPages(), myBook.getCurrentPages(), "Remove"});
                    }

                }

            }
        }

    }

    @Override
    public void loadData2(String keywords) {
        JTable tblBook = this.tblArchieved;

        ArrayList<MyBookShelf> model = myBookRepository.getAll(keywords);
        DefaultTableModel tableModel = new DefaultTableModel(null, new Object[]{"isbn", "Title", "Author", "Publisher", "Year", "Total Pages", "Action"}) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return true;
            }
        };

        tblBook.setModel(tableModel);
        tblBook.setCellSelectionEnabled(false);
        tblBook.setRowSelectionAllowed(true);
        tblBook.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        tblBook.setRowHeight(40);

        TableColumnModel columnModel = tblBook.getColumnModel();

        TableColumn columnISBN = columnModel.getColumn(0);
        columnISBN.setPreferredWidth(84);

        TableColumn columnTitle = columnModel.getColumn(1);
        columnTitle.setPreferredWidth(188);

        TableColumn columnAuthor = columnModel.getColumn(2);
        columnAuthor.setPreferredWidth(150);

        TableColumn columnPublisher = columnModel.getColumn(3);
        columnPublisher.setPreferredWidth(150);

        TableColumn columnYear = columnModel.getColumn(4);
        columnYear.setPreferredWidth(88);

        TableColumn columnTotalPages = columnModel.getColumn(5);
        columnTotalPages.setPreferredWidth(85);

        TableColumn columnAction = columnModel.getColumn(6);
        columnAction.setPreferredWidth(135);

        if (!model.isEmpty()) {
            for (var i = 0; i < model.size(); i++) {
                var myBook = model.get(i);
                if (!myBook.isArchived()) {
                    tableModel.addRow(new Object[]{myBook.getIsbn(), myBook.getTitle(), myBook.getAuthor(), myBook.getPublisher(), myBook.getYear(), myBook.getTotalPages(), "Delete"});
                }
            }
        }

    }

    @Override
    public void showBook(String keywords) {
        loadData(keywords);
        tableHandling();
    }

    @Override
    public void showBook2(String keywords) {
        loadData2(keywords);
        tableHandling2();
    }

    @Override
    public void addBook(int isbn, String title, String author, String publisher, int year, int currentPages, int totalPages, boolean isArchived) {

        MyBookShelf book = new MyBookShelf(isbn, title, author, publisher, year, currentPages, totalPages, isArchived);

        boolean success = myBookRepository.add(book);

        if (success) {
            System.out.println("SUKSES MENAMBAHKAN BUKU : " + book.getTitle());
        } else {
            System.out.println("GAGAL MENAMBAHKAN BUKU : " + book.getTitle() + ". Panjang karakter minimal 6.");
        }

        showBook("");

    }

    @Override
    public void removeBook(int isbn) {
        boolean success = myBookRepository.remove(isbn);

        if (success) {
            System.out.println("SUKSES MENGHAPUS BUKU : isbn-" + isbn);
        } else {
            System.out.println("GAGAL MENGHAPUS BUKU : " + isbn);
        }
    }

    @Override
    public void changeBook(int isbn, String title) {
        System.out.println("isbn: " + isbn);
        boolean result = myBookRepository.changeBook(isbn, title);

        if (result) {
            System.out.println("SUKSES MENGUBAH BUKU : posisi ke-" + isbn + " menjadi " + title);
        } else {
            System.out.println("GAGAL MENGUBAH BUKU : posisi ke-" + isbn + " menjadi " + title + ". Buku tidak tersedia.");
        }

    } 

    @Override
    public void updateReadBook(int isbn, int currentPages) {
        System.out.println("reading book");

        boolean result = myBookRepository.updateReading(isbn, currentPages);

        if (result) {
            System.out.println("SUKSES MEMBACA");
        } else {
            System.out.println("GAGAL MEMBACA");
        }
    }

    @Override
    public void updateArchivedBook(int isbn, boolean isArchived) {
        MyBookShelf book = new MyBookShelf(isbn, isArchived);
        boolean success = myBookRepository.updateArchived(isbn, isArchived);
        if (success) {
            System.out.println("SUKSES MENGARSIPKAN BUKU : " + book.isArchived());
        } else {
            System.out.println("GAGAL MENGARSIPKAN BUKU : " + book.isArchived() + ". Panjang karakter minimal 6.");
        }

        showBook("");
    }

}
