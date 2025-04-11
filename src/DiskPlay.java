import javax.swing.*;
import java.awt.*;

public class DiskPlay extends javax.swing.JFrame {
    public static JFrame mainFrame = new JFrame();
    public static JPanel mainPanel = new JPanel();
    public static CardLayout card = new CardLayout();
    
    public static SplashScreen splashScreen = new SplashScreen();
    public static MainMenu mainMenu = new MainMenu();
    public static Help help = new Help();
    public static About about = new About();
    public static IOPanel IO = new IOPanel();
    
    public static boolean sound = true;
    
    public DiskPlay() {
        try {
            java.awt.Font poppins_semibold = java.awt.Font.createFont(java.awt.Font.TRUETYPE_FONT,
                    getClass().getClassLoader().getResourceAsStream("Poppins-SemiBold.ttf"));
            java.awt.GraphicsEnvironment ge = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(poppins_semibold);
        } catch (java.io.IOException | java.awt.FontFormatException e) {
            e.printStackTrace();
        }

        try {
            java.awt.Font poppins_extrabold = java.awt.Font.createFont(java.awt.Font.TRUETYPE_FONT,
                    getClass().getClassLoader().getResourceAsStream("Poppins-ExtraBold.ttf"));
            java.awt.GraphicsEnvironment ge = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(poppins_extrabold);
        } catch (java.io.IOException | java.awt.FontFormatException e) {
            e.printStackTrace();
        }

        mainFrame.setSize(1080, 720);
        mainFrame.setTitle("DiskPlay");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setUndecorated(true);
        
        mainPanel.setLayout(card);
        mainPanel.add(splashScreen, "1");
        mainPanel.add(mainMenu, "2");
        mainPanel.add(help, "3");
        mainPanel.add(about, "4");
        mainPanel.add(IO, "5");
        
        mainFrame.add(mainPanel);
        mainFrame.pack();
        
        mainFrame.setVisible(true);
        mainFrame.setLocationRelativeTo(null);
        
        card.show(mainPanel, "1");
        Music.bgMusic();
        
        new java.util.Timer().schedule(new java.util.TimerTask() {
            @Override
            public void run() {
                card.show(mainPanel, "2");
            }
        }, 3 * 1000); // Miliseconds
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new DiskPlay();
            }
        });
    }
}