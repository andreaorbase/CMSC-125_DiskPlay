public class SplashScreen extends javax.swing.JPanel {
    public SplashScreen() {
        initComponents();
    }

    private void initComponents() {
        splash_bg = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1224, 720));
        setLayout(null);

        splash_bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/backgrounds/splash_screen.png"))); // NOI18N
        splash_bg.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        splash_bg.setOpaque(true);
        add(splash_bg);
        splash_bg.setBounds(0, 0, 1224, 720);
    }

    private javax.swing.JLabel splash_bg;
}
