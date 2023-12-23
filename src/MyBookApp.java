import com.formdev.flatlaf.FlatIntelliJLaf;
import javax.swing.UIManager;
import repository.MyBookRepository;
import repository.MyBookRepositoryImpl;
import service.BookShelfService;
import service.BookShelfServiceImpl;
import ui.AppFrame;
import ui.pages.HomePage;
import ui.pages.MyBookPage;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author marth
 */
public class MyBookApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            UIManager
                    .setLookAndFeel(new FlatIntelliJLaf());
        } catch (Exception ex) {
            System.out.println("Gagal mengbah desain tampilan");
        }
        
        MyBookRepository myBookRepository = new MyBookRepositoryImpl();
        BookShelfService bookShelfService = new BookShelfServiceImpl(myBookRepository);
        AppFrame appFrame = new AppFrame();
        
       
        appFrame.setBookShelfService(bookShelfService);
 
   
        appFrame.setVisible(true);
     
  

        
   
    }
}
