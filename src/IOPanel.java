import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.swing.Timer;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;

public class IOPanel extends javax.swing.JPanel {
    public IOPanel() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        initComponents();
    }
    String direction = "left";
    int selected;
    double speed;
    final int cylinder_line = 199;
    final int req_caps = 40;
    int[] main_queue;
    int head;
    private ArrayList<Integer> temp_array;


    public void reset(){
        // speed = 1;
        // selected = 0;
        removeAll();
        initComponents();
    }

    public void initComponents() {
        
        speed = 1;
        // timer = new javax.swing.Timer();
        seek_label = new javax.swing.JLabel();
        io_left_button = new javax.swing.JButton();
        io_right_button = new javax.swing.JButton();
        exit = new javax.swing.JButton();
        minimize = new javax.swing.JButton();
        io_save_panel = new javax.swing.JPanel();
        io_save_label = new javax.swing.JLabel();
        io_save_png = new javax.swing.JButton();
        io_save_pdf = new javax.swing.JButton();
        io_directory_label = new javax.swing.JLabel();
        io_directory_input = new javax.swing.JTextField();
        io_directory_bg = new javax.swing.JLabel();
        io_return_panel = new javax.swing.JButton();
        io_save_bg = new javax.swing.JLabel();
        io_backpanel = new javax.swing.JPanel();
        io_output_panel_scroll = new javax.swing.JScrollPane();
        io_output_panel = new javax.swing.JPanel();
        io_add = new javax.swing.JButton();
        io_minus = new javax.swing.JButton();
        io_import = new javax.swing.JButton();
        io_simulate = new javax.swing.JButton();
        io_simulate_all = new javax.swing.JButton();
        io_random = new javax.swing.JButton();
        io_save = new javax.swing.JButton();
        io_return = new javax.swing.JButton();
        io_algo_select = new javax.swing.JComboBox<>();
        io_queue_input = new javax.swing.JTextField();
        io_position_input = new javax.swing.JTextField();
        io_dot_fcfs = new javax.swing.JLabel();
        io_dot_sstf = new javax.swing.JLabel();
        io_dot_scan = new javax.swing.JLabel();
        io_dot_cscan = new javax.swing.JLabel();
        io_dot_look = new javax.swing.JLabel();
        io_dot_clook = new javax.swing.JLabel();
        io_algo_label = new javax.swing.JLabel();
        io_speed_value = new javax.swing.JLabel();
        io_position_bg = new javax.swing.JLabel();
        io_speed_label = new javax.swing.JLabel();
        io_timer_label = new javax.swing.JLabel();
        io_select_algo_bg = new javax.swing.JLabel();
        io_timer_bg = new javax.swing.JLabel();
        io_seek_bg = new javax.swing.JLabel();
        io_speed_bg = new javax.swing.JLabel();
        io_bg = new javax.swing.JLabel();
        scan_look = new javax.swing.JLabel();

        setEnabled(false);
        setPreferredSize(new java.awt.Dimension(1224, 720));
        setLayout(null);

        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/buttons/close.png"))); 
        exit.setBorder(null);
        exit.setBorderPainted(false);
        exit.setContentAreaFilled(false);
        exit.setFocusPainted(false);
        exit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitMouseExited(evt);
            }
        });
        exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitActionPerformed(evt);
            }
        });
        add(exit);
        exit.setBounds(1175, 10, 40, 30);

        minimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/buttons/min.png"))); 
        minimize.setBorder(null);
        minimize.setBorderPainted(false);
        minimize.setContentAreaFilled(false);
        minimize.setFocusPainted(false);
        minimize.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                minimizeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                minimizeMouseExited(evt);
            }
        });
        minimize.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                minimizeActionPerformed(evt);
            }
        });
        add(minimize);
        minimize.setBounds(1135, 10, 40, 30);

        io_save_panel.setOpaque(false);
        io_save_panel.setVisible(false);
        io_save_panel.setLayout(null);

        io_save_label.setFont(new java.awt.Font("Poppins ExtraBold", 0, 36)); 
        io_save_label.setForeground(new java.awt.Color(250, 236, 182));
        io_save_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        io_save_label.setText("Save as");
        io_save_label.setToolTipText("");
        io_save_label.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        io_save_panel.add(io_save_label);
        io_save_label.setBounds(250, 260, 580, 40);

        io_save_png.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/png.png"))); 
        io_save_png.setBorder(null);
        io_save_png.setBorderPainted(false);
        io_save_png.setContentAreaFilled(false);
        io_save_png.setFocusPainted(false);
        io_save_png.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                io_save_pngMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                io_save_pngMouseExited(evt);
            }
        });
        io_save_png.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                io_save_pngActionPerformed(evt);
            }
        });
        io_save_panel.add(io_save_png);
        io_save_png.setBounds(320, 380, 200, 70);

        io_save_pdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/pdf.png"))); 
        io_save_pdf.setBorder(null);
        io_save_pdf.setBorderPainted(false);
        io_save_pdf.setContentAreaFilled(false);
        io_save_pdf.setFocusPainted(false);
        io_save_pdf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                io_save_pdfMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                io_save_pdfMouseExited(evt);
            }
        });
        io_save_pdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                io_save_pdfActionPerformed(evt);
            }
        });
        io_save_panel.add(io_save_pdf);
        io_save_pdf.setBounds(560, 380, 200, 70);

        io_directory_label.setFont(new java.awt.Font("Poppins ExtraBold", 0, 18)); 
        io_directory_label.setForeground(new java.awt.Color(250, 236, 182));
        io_directory_label.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        io_directory_label.setText("Enter Directory:");
        io_directory_label.setToolTipText("");
        io_directory_label.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        io_save_panel.add(io_directory_label);
        io_directory_label.setBounds(280, 290, 350, 30);

        io_directory_input.setFont(new java.awt.Font("Poppins SemiBold", 0, 18));
        io_directory_input.setText("C://Users/PC/directory/"); 
        io_directory_input.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        io_directory_input.setToolTipText("");
        io_directory_input.setBorder(null);
        io_directory_input.setOpaque(false);
        io_save_panel.add(io_directory_input);
        io_directory_input.setBounds(290, 330, 500, 30);

        io_directory_input.setForeground(Color.GRAY);
        io_directory_input.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (io_directory_input.getText().equals("C://Users/PC/directory/")) {
                    io_directory_input.setText("");
                    io_directory_input.setForeground(Color.BLACK);
                }
            }
            @Override
            public void focusLost(FocusEvent e) {
                if (io_directory_input.getText().isEmpty()) {
                    io_directory_input.setForeground(Color.GRAY);
                    io_directory_input.setText("C://Users/PC/directory/");
                }
            }
            });

        io_directory_bg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        io_directory_bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/directory_input.png"))); 
        io_directory_bg.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        io_save_panel.add(io_directory_bg);
        io_directory_bg.setBounds(250, 310, 580, 70);

        io_return_panel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/buttons/return.png"))); 
        io_return_panel.setBorder(null);
        io_return_panel.setBorderPainted(false);
        io_return_panel.setContentAreaFilled(false);
        io_return_panel.setFocusPainted(false);
        io_return_panel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                io_return_panelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                io_return_panelMouseExited(evt);
            }
        });
        io_return_panel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                io_return_panelActionPerformed(evt);
            }
        });
        io_save_panel.add(io_return_panel);
        io_return_panel.setBounds(780, 430, 80, 90);

        io_save_bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/backgrounds/save_bg.png"))); 
        io_save_bg.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        io_save_panel.add(io_save_bg);
        io_save_bg.setBounds(0, 0, 1224, 720);

        add(io_save_panel);
        io_save_panel.setBounds(0, 0, 1224, 720);

        io_backpanel.setPreferredSize(new java.awt.Dimension(1224, 720));
        io_backpanel.setLayout(null);

        io_backpanel.setPreferredSize(new java.awt.Dimension(1224, 720));
        io_backpanel.setLayout(null);

        io_output_panel_scroll.setBackground(new java.awt.Color(250, 236, 182));
        io_output_panel_scroll.getViewport().setBackground(new java.awt.Color(250, 236, 182));
        io_output_panel_scroll.setBorder(null);

        io_output_panel.setBackground(new java.awt.Color(250, 236, 182));
        io_output_panel.setLayout(null);
        io_output_panel_scroll.setViewportView(io_output_panel);

        io_backpanel.add(io_output_panel_scroll);
        io_output_panel_scroll.setBounds(70, 350, 940, 330);

        io_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/add.png"))); 
        io_add.setBorder(null);
        io_add.setBorderPainted(false);
        io_add.setContentAreaFilled(false);
        io_add.setFocusPainted(false);
        io_add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                io_addMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                io_addMouseExited(evt);
            }
        });
        io_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                io_addActionPerformed(evt);
            }
        });
        io_backpanel.add(io_add);
        io_add.setBounds(832, 166, 40, 40);

        io_minus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/minus.png"))); 
        io_minus.setBorder(null);
        io_minus.setBorderPainted(false);
        io_minus.setContentAreaFilled(false);
        io_minus.setFocusPainted(false);
        io_minus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                io_minusMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                io_minusMouseExited(evt);
            }
        });
        io_minus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                io_minusActionPerformed(evt);
            }
        });
        io_backpanel.add(io_minus);
        io_minus.setBounds(771, 166, 40, 40);

        io_import.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/import.png"))); 
        io_import.setBorder(null);
        io_import.setBorderPainted(false);
        io_import.setContentAreaFilled(false);
        io_import.setFocusPainted(false);
        io_import.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                io_importMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                io_importMouseExited(evt);
            }
        });
        io_import.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                io_importActionPerformed(evt);
            }
        });
        io_backpanel.add(io_import);
        io_import.setBounds(360, 105, 130, 40);

        io_left_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/left_after.png"))); 
        io_right_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/right.png"))); 
        
        io_left_button.setBorder(null);
        io_left_button.setBorderPainted(false);
        io_left_button.setContentAreaFilled(false);
        io_right_button.setBorder(null);
        io_right_button.setBorderPainted(false);
        io_right_button.setContentAreaFilled(false);

        io_left_button.setBounds(770, 115, 59, 20);
        io_right_button.setBounds(770 + 59 + 8, 115, 59, 20);
        
        scan_look.setFont(new java.awt.Font("Poppins SemiBold", 0, 12));
        scan_look.setForeground(new java.awt.Color(225, 225, 225)); 
        scan_look.setText("(for SCAN and LOOK)");
        scan_look.setBounds(770 + 68 + 59 + 4, 117, 300, 20);
        add(scan_look);

        io_right_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                // io_startActionPerformed(evt);
                direction = "right";
                io_right_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/right_after.png"))); 
                io_left_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/left.png"))); 
            }
        });

        io_left_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                direction = "left";
                // io_startActionPerformed(evt);
                // direction = "right";
                io_left_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/left_after.png"))); 
                io_right_button.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/right.png"))); 
            }
        });

        add(io_right_button);
        add(io_left_button);

        io_simulate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/simulate.png"))); 
        io_simulate.setBorder(null);
        io_simulate.setBorderPainted(false);
        io_simulate.setContentAreaFilled(false);
        io_simulate.setFocusPainted(false);
        io_simulate.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                io_simulateMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                io_simulateMouseExited(evt);
            }
        });
        io_simulate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                io_simulateActionPerformed(evt);
            }
        });
        io_backpanel.add(io_simulate);
        io_simulate.setBounds(435, 210, 180, 70);

        io_simulate_all.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/simulate_all.png"))); 
        io_simulate_all.setBorder(null);
        io_simulate_all.setBorderPainted(false);
        io_simulate_all.setContentAreaFilled(false);
        io_simulate_all.setFocusPainted(false);
        io_simulate_all.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                io_simulateAllMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                io_simulateAllMouseExited(evt);
            }
        });
        io_simulate_all.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                io_simulateAllActionPerformed(evt);
            }
        });
        io_backpanel.add(io_simulate_all);
        io_simulate_all.setBounds(435 + 180 + 5, 210, 180, 70);

        io_random.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/random.png"))); 
        io_random.setBorder(null);
        io_random.setBorderPainted(false);
        io_random.setContentAreaFilled(false);
        io_random.setFocusPainted(false);
        io_random.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                io_randomMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                io_randomMouseExited(evt);
            }
        });
        io_random.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                io_randomActionPerformed(evt);
            }
        });
        io_backpanel.add(io_random);
        io_random.setBounds(500, 105, 140, 40);

        io_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/save.png"))); 
        io_save.setBorder(null);
        io_save.setEnabled(false);
        io_save.setBorderPainted(false);
        io_save.setContentAreaFilled(false);
        io_save.setFocusPainted(false);
        io_save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                io_saveMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                io_saveMouseExited(evt);
            }
        });
        io_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                io_saveActionPerformed(evt);
            }
        });
        io_backpanel.add(io_save);
        io_save.setBounds(1070, 530, 80, 90);

        io_return.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/buttons/return.png"))); 
        io_return.setBorder(null);
        io_return.setBorderPainted(false);
        io_return.setContentAreaFilled(false);
        io_return.setFocusPainted(false);
        io_return.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                io_returnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                io_returnMouseExited(evt);
            }
        });
        io_return.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                io_returnActionPerformed(evt);
            }
        });
        io_backpanel.add(io_return);
        io_return.setBounds(1070, 610, 80, 90);

        io_algo_select.setBackground(new java.awt.Color(197, 211, 221));
        io_algo_select.setFont(new java.awt.Font("Poppins SemiBold", 0, 11)); 
        io_algo_select.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "First Come First Serve", "Shortest Seek Time First", "Scan", "C-Scan", "Look", "C-Look" }));
        io_algo_select.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
                io_algoSelectActionPerformed(evt);
            }

            public void io_algoSelectActionPerformed(ActionEvent evt) {
             
            //1. FCFS, 2. SSTF, 3. SCAN 4.C-SCAN 5. LOOK 6. C-LOOK
            int index = io_algo_select.getSelectedIndex();
            int x = 250;
            int y = 350;
            int width = 300;
            int height = 110;
            set_dot(index);
            //[x=220,y=20,width=300,height=110]
            switch(index){
                
                case 0:
                    io_algo_label.setText("FCFS");
                    io_algo_label.setBounds(x+50, y, width, height);
                    
                break;
                case 1:
                    io_algo_label.setText("SSTF");
                    io_algo_label.setBounds(x+50, y, width, height);
                break;
                case 2:
                    io_algo_label.setText("SCAN");
                    io_algo_label.setBounds(x+50, y, width, height);
                break;
                case 3:
                    io_algo_label.setText("C-SCAN");
                    io_algo_label.setBounds(x, y, width, height);
                break;
                case 4:
                    io_algo_label.setText("LOOK");
                    io_algo_label.setBounds(x+50, y, width, height);
                break;
                case 5:
                    io_algo_label.setText("C-LOOK");
                    io_algo_label.setBounds(x, y, width, height);
                break;
            }

            }
        });
        io_algo_select.setBorder(null);
        io_backpanel.add(io_algo_select);
        io_algo_select.setBounds(489, 170, 170, 30);

        io_queue_input.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); 
        io_queue_input.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        io_queue_input.setToolTipText("");
        io_queue_input.setBorder(null);
        io_queue_input.setOpaque(false);
        io_backpanel.add(io_queue_input);
        io_queue_input.setBounds(375, 72, 360, 30);

        io_position_input.setFont(new java.awt.Font("Poppins SemiBold", 0, 14)); 
        io_position_input.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        io_position_input.setToolTipText("");
        io_position_input.setBorder(null);
        io_position_input.setOpaque(false);
        io_backpanel.add(io_position_input);
        io_position_input.setBounds(960, 72, 80, 30);

        io_dot_fcfs.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        io_dot_fcfs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/dot.png"))); 
        
        io_dot_fcfs.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        io_backpanel.add(io_dot_fcfs);
        io_dot_fcfs.setBounds(65, 65, 115, 36);
        set_dot(0);

        io_dot_sstf.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        io_dot_sstf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/dot.png"))); 
        io_dot_sstf.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        io_backpanel.add(io_dot_sstf);
        io_dot_sstf.setBounds(65, 65 + 25 + 5, 115, 36);

        io_dot_scan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        io_dot_scan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/dot.png"))); 
        io_dot_scan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        io_backpanel.add(io_dot_scan);
        io_dot_scan.setBounds(65, 65 + 25 + 25 + 10, 115, 36);

        io_dot_cscan.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        io_dot_cscan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/dot.png"))); 
        io_dot_cscan.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        io_backpanel.add(io_dot_cscan);
        io_dot_cscan.setBounds(65, 65 + 25 + 25 + 25 + 15, 115, 36);

        io_dot_look.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        io_dot_look.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/dot.png"))); 
        io_dot_look.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        io_backpanel.add(io_dot_look);
        io_dot_look.setBounds(65, 65 + 25 + 25 + 25 + 25 + 20, 115, 36);

        io_dot_clook.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        io_dot_clook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/dot.png"))); 
        io_dot_clook.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        io_backpanel.add(io_dot_clook);
        io_dot_clook.setBounds(65, 65 + 25 + 25 + 25 + 25 + 25 + 25, 115, 36);

        io_algo_label.setFont(new java.awt.Font("Poppins ExtraBold", 0, 25)); 
        io_algo_label.setForeground(new java.awt.Color(106, 171, 240));
        io_algo_label.setText("FCFS");
        io_algo_label.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        io_backpanel.add(io_algo_label);
        io_algo_label.setBounds(700, 400, 300, 110);

        io_speed_value.setFont(new java.awt.Font("Poppins ExtraBold", 0, 20)); 
        io_speed_value.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        io_speed_value.setText(String.valueOf(speed) + "");
        io_speed_value.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        io_backpanel.add(io_speed_value);
        io_speed_value.setBounds(796, 158, 50, 60);

        io_position_bg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        io_position_bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/position.png"))); 
        io_position_bg.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        io_backpanel.add(io_position_bg);
        io_position_bg.setBounds(750, 60, 310, 50);

        io_speed_label.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        io_speed_label.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/queue.png"))); 
        io_speed_label.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        io_backpanel.add(io_speed_label);
        io_speed_label.setBounds(30, 60, 920, 50);

        io_timer_label.setFont(new java.awt.Font("Poppins ExtraBold", 0, 25)); 
        io_timer_label.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        io_timer_label.setText("0");
        io_timer_label.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        io_backpanel.add(io_timer_label);
        io_timer_label.setBounds(1070, 480, 70, 30);

        seek_label.setFont(new java.awt.Font("Poppins ExtraBold", 0, 25)); 
        seek_label.setText("-");
        seek_label.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        seek_label.setBounds(1070, 348, 300, 100);
        add(seek_label);

        io_select_algo_bg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        io_select_algo_bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/algo_bg.png"))); 
        io_select_algo_bg.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        io_backpanel.add(io_select_algo_bg);
        io_select_algo_bg.setBounds(305, 155, 400, 60);

        io_seek_bg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        io_seek_bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/seek-time.png"))); 
        io_seek_bg.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        io_backpanel.add(io_seek_bg);
        io_seek_bg.setBounds(1035, 300, 150, 150);

        io_timer_bg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        io_timer_bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/timer.png"))); 
        io_timer_bg.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        io_backpanel.add(io_timer_bg);
        io_timer_bg.setBounds(1035, 400, 150, 150);

        io_speed_bg.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        io_speed_bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/speed_bg.png"))); 
        io_speed_bg.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        io_backpanel.add(io_speed_bg);
        io_speed_bg.setBounds(580, 155, 400, 60);

        io_bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/backgrounds/background_IO.png"))); 
        io_bg.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        io_bg.setOpaque(true);
        io_backpanel.add(io_bg);
        io_bg.setBounds(0, 0, 1224, 720);

        add(io_backpanel);
        io_backpanel.setBounds(0, 0, 1224, 720);
    }

    public void set_dot(int i) {
    // 1. FCFS, 2. SSTF, 3. SCAN 4.C-SCAN 5. LOOK 6. C-LOOK
        switch(i){
            case 0:
            io_dot_fcfs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/dot_selected.png")));
            io_dot_sstf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/dot.png")));
            io_dot_look.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/dot.png")));
            io_dot_clook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/dot.png")));
            io_dot_scan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/dot.png")));
            io_dot_cscan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/dot.png")));
            break;

            case 1:
            io_dot_fcfs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/dot.png")));
            io_dot_sstf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/dot_selected.png")));
            io_dot_look.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/dot.png")));
            io_dot_clook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/dot.png")));
            io_dot_scan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/dot.png")));
            io_dot_cscan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/dot.png")));
            break;

            case 2:
            io_dot_fcfs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/dot.png")));
            io_dot_sstf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/dot.png")));
            io_dot_look.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/dot.png")));
            io_dot_clook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/dot.png")));
            io_dot_scan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/dot_selected.png")));
            io_dot_cscan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/dot.png")));
            break;

            case 3:
            io_dot_fcfs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/dot.png")));
            io_dot_sstf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/dot.png")));
            io_dot_look.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/dot.png")));
            io_dot_clook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/dot.png")));
            io_dot_scan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/dot.png")));
            io_dot_cscan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/dot_selected.png")));
            break;


            case 4:
            io_dot_fcfs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/dot.png")));
            io_dot_sstf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/dot.png")));
            io_dot_look.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/dot_selected.png")));
            io_dot_clook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/dot.png")));
            io_dot_scan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/dot.png")));
            io_dot_cscan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/dot.png")));
            break;


            case 5:
            io_dot_fcfs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/dot.png")));
            io_dot_sstf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/dot.png")));
            io_dot_look.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/dot.png")));
            io_dot_clook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/dot_selected.png")));
            io_dot_scan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/dot.png")));
            io_dot_cscan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/dot.png")));
            break;
        }
    }

    public void exitMouseEntered(java.awt.event.MouseEvent evt) {                                  
        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/buttons/close_hover.png")));
    }                                 

    public void exitMouseExited(java.awt.event.MouseEvent evt) {                                 
        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/buttons/close.png")));
    }                                

    public void exitActionPerformed(java.awt.event.ActionEvent evt) {          
        Music.sfx();                           
        System.exit(0);
    }                                    

    public void minimizeMouseEntered(java.awt.event.MouseEvent evt) {                                      
        minimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/buttons/min_hover.png")));
    }                                     

    public void minimizeMouseExited(java.awt.event.MouseEvent evt) {                                     
        minimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/buttons/min.png")));
    }                                    

    public void minimizeActionPerformed(java.awt.event.ActionEvent evt) {          
        Music.sfx();                               
        DiskPlay.mainFrame.setState(java.awt.Frame.ICONIFIED);
    }                                        

    public void io_returnMouseEntered(java.awt.event.MouseEvent evt) {                                       
        io_return.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/buttons/return_hover.png")));
    }                                      

    public void io_returnMouseExited(java.awt.event.MouseEvent evt) {                                      
        io_return.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/buttons/return.png")));
    }                                     

    public void io_returnActionPerformed(java.awt.event.ActionEvent evt) {  
        Music.sfx();                                        
        reset();
        DiskPlay.card.show(DiskPlay.mainPanel, "2");
    }                                         

    public void io_saveMouseEntered(java.awt.event.MouseEvent evt) {                                     
        io_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/save_hover.png")));
    }                                    

    public void io_saveMouseExited(java.awt.event.MouseEvent evt) {                                    
        io_save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/save.png")));
    }                                   

    public void io_saveActionPerformed(java.awt.event.ActionEvent evt) {    
        Music.sfx();                                    
        setPanelEnabled(io_backpanel, false);
        setPanelEnabled(io_output_panel, false);
        io_output_panel_scroll.setVisible(false);
        io_left_button.setEnabled(false);
        io_right_button.setEnabled(false);
        scan_look.setEnabled(false);
        seek_label.setEnabled(false);
        io_save_panel.setVisible(true);
    }                                       

    public void io_addMouseEntered(java.awt.event.MouseEvent evt) {                                    
        io_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/add_hover.png")));
    }                                   

    public void io_addMouseExited(java.awt.event.MouseEvent evt) {                                   
        io_add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/add.png")));
    }                                  

    public void io_addActionPerformed(java.awt.event.ActionEvent evt) {                                       
        Music.sfx();
        if(speed < 2.5){
            speed += 0.5;
            io_speed_value.setText(String.valueOf(speed));
        }
        else{
            speed = 2.5;
            io_speed_value.setText(String.valueOf(speed));
        }

    }                                      

    public void io_minusMouseEntered(java.awt.event.MouseEvent evt) {                                      
        io_minus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/minus_hover.png")));
    }                                     

    public void io_minusMouseExited(java.awt.event.MouseEvent evt) {                                     
        io_minus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/minus.png")));
    }                                    

    public void io_minusActionPerformed(java.awt.event.ActionEvent evt) {       
        Music.sfx();
        Music.sfx();
        if(speed > 0.5){
            speed -= 0.5;
            io_speed_value.setText(String.valueOf(speed));
        }
        else{
            speed = 0.5;
            io_speed_value.setText(String.valueOf(speed));
        }

    }                                        

    public void io_importMouseEntered(java.awt.event.MouseEvent evt) {                                       
        io_import.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/import_hover.png")));
    }                                      

    public void io_importMouseExited(java.awt.event.MouseEvent evt) {                                      
        io_import.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/import.png")));
    }                                     

    public void io_importActionPerformed(java.awt.event.ActionEvent evt) {                                          
        Music.sfx();
        String queueline;

        io_queue_input.setText("");

        final JFileChooser fc = new JFileChooser();
        fc.showOpenDialog(null);
        File file = fc.getSelectedFile();
        import_ArrayList = new ArrayList<Integer>();
        try(Scanner read = new Scanner(file)) {

            queueline = read.nextLine();

            Scanner read2 = new Scanner(queueline);
            read2.next();
            while(read2.hasNext()){ 
              if(io_queue_input.getText().equals("")){
                io_queue_input.setText(read2.next());
              }
              else{
                io_queue_input.setText(io_queue_input.getText() + " " + read2.next());
              }

            }

           read.next();
           io_position_input.setText(read.next());
        } catch (Exception e) {}
    }                                         

    public void io_randomMouseEntered(java.awt.event.MouseEvent evt) {                                       
        io_random.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/random_hover.png")));
    }                                      

    public void io_randomMouseExited(java.awt.event.MouseEvent evt) {                                      
        io_random.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/random.png")));
    }                                     
    
    public void io_randomActionPerformed(java.awt.event.ActionEvent evt) {                                          
        Music.sfx();
        
        int[] random_array;
        Random rand = new Random();
        int len = rand.nextInt(10) + 3;
        
        random_array = new int[len];
        io_queue_input.setText("");

        for(int i = 0; i < len; i++){
            random_array[i] = rand.nextInt(199);

            if(io_queue_input.getText().equals("")){
                io_queue_input.setText(String.valueOf(random_array[i]));
            }
            else{
                io_queue_input.setText(io_queue_input.getText() + " " + String.valueOf(random_array[i]));
            }
        }
        io_position_input.setText(String.valueOf(random_array[rand.nextInt(random_array.length)]));
    }                                         

    public void io_simulateMouseEntered(java.awt.event.MouseEvent evt) {                                      
        io_simulate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/simulate_hover.png")));
    }                                     

    public void io_simulateMouseExited(java.awt.event.MouseEvent evt) {                                     
        io_simulate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/simulate.png")));
    }

    public void io_simulateAllMouseEntered(java.awt.event.MouseEvent evt) {                                      
        io_simulate_all.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/simulate_all_hover.png")));
    }

    public void io_simulateAllMouseExited(java.awt.event.MouseEvent evt) {                                     
        io_simulate_all.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/simulate_all.png")));
    }
                                                                     
    public void io_simulateActionPerformed(java.awt.event.ActionEvent evt) {
        Music.sfx();
        io_output_panel_scroll.getVerticalScrollBar().setValue(-10);     
        count = 0;
        io_output_panel.removeAll();        
        io_save.setEnabled(true);
        
        temp_array = new ArrayList<Integer>();
        try(Scanner read = new Scanner(io_queue_input.getText())) {
            while(read.hasNext()){
                temp_array.add(read.nextInt());
            }

            main_queue = new int[temp_array.size()];
            
            for(int i = 0; i < temp_array.size(); i++){
                main_queue[i] = temp_array.get(i);
            }
            head = Integer.valueOf(io_position_input.getText());

            ArrayList<Integer> sequence = new ArrayList<>();
            ArrayList<Integer> temp_results = new ArrayList<>();

            //main queue and head is set
            sequence.add(head);
            temp_results.add(head);
            for(int i = 0; i < main_queue.length; i++){
                sequence.add(main_queue[i]);
            }
            int [] results = new int[sequence.size() + 1];

            if(main_queue.length > 40){
                JOptionPane.showMessageDialog(null, "Invalid Input", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            int choose = io_algo_select.getSelectedIndex();
            switch(choose){
                case 0:
                results = DiskAlgos.FCFS(main_queue, head);
                for(int i = 0; i < results.length; i++){
                    temp_results.add(results[i]);
                }

                results = new int[temp_results.size()];
                for(int i = 0; i < temp_results.size(); i++){
                    results[i] = temp_results.get(i);
                }
                break;

                case 1:
                // SSTF CASE IS DIFFERENT, IF PRINTING REQUIRES AUTOMATION, EXCLUDE SSTF
                results = DiskAlgos.SSTF(main_queue, head);
                break;

                case 2:
                results = DiskAlgos.SCAN(main_queue, head, direction);

                for(int i = 0; i < results.length; i++){
                    temp_results.add(results[i]);
                }

                results = new int[temp_results.size()];
                for(int i = 0; i < temp_results.size(); i++){
                    results[i] = temp_results.get(i);
                }
                break;

                case 3:
                results = DiskAlgos.CSCAN(main_queue, head);
                for(int i = 0; i < results.length; i++){
                    temp_results.add(results[i]);
                }

                results = new int[temp_results.size()];
                for(int i = 0; i < temp_results.size(); i++){
                    results[i] = temp_results.get(i);
                }
                break;

                case 4:
                results = DiskAlgos.LOOK(main_queue, head, direction);

                for(int i = 0; i < results.length; i++){
                    temp_results.add(results[i]);
                }

                results = new int[temp_results.size()];
                for(int i = 0; i < temp_results.size(); i++){
                    results[i] = temp_results.get(i);
                }
                break;

                case 5:
                results = DiskAlgos.CLOOK(main_queue, head);

                for(int i = 0; i < results.length; i++){
                    temp_results.add(results[i]);
                }

                results = new int[temp_results.size()];
                for(int i = 0; i < temp_results.size(); i++){
                    results[i] = temp_results.get(i);
                }
                break;
            }
            
            int start = 0;
            int end = 199;
            scroll_value = io_output_panel_scroll.getVerticalScrollBar().getValue();
            // io_output_panel_scroll.getVerticalScrollBar().setValue(scroll_value);
            // int scroll_value = results.length;
            final int[] staticResults = results.clone();
            timer = new Timer((int) (500/speed), new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent evt){
                    
                    scroll_value = scroll_value + 10;
                    io_output_panel_scroll.getVerticalScrollBar().setValue(scroll_value);
                    io_timer_label.setText(String.valueOf(count));
                    
                   
                    final int[] newResults = Arrays.copyOfRange(staticResults,0,count+1);
                    
                    numberline = new NumberLineDrawing(start, end, sequence, newResults, head, speed);
                    // numberline.repaint();
                    if(count < staticResults.length){
                        count++;
                    }
                    else{
                        timer.stop();
                    }
                    numberline.setAutoscrolls(true);

                    int size = main_queue.length * 60 + 40;
                    if (io_algo_select.getSelectedItem() == "C-Scan")
                        size = size + 100;
                
                    numberline.setPreferredSize(new Dimension(920, size));
                    seek_label.setText("" + DiskAlgos.getTotal_distance());
                    
                    JLabel algo = new JLabel("Algorithm: " + io_algo_select.getSelectedItem().toString(), null, SwingConstants.LEFT);
                    algo.setBackground(new java.awt.Color(250, 236, 182));
                    algo.setFont(new java.awt.Font("Poppins SemiBold", 0, 16));
                    algo.setAlignmentX(Component.LEFT_ALIGNMENT);

                    JLabel head_position = new JLabel("Head Starting Position: " + io_position_input.getText(), null, SwingConstants.LEFT);
                    head_position.setBackground(new java.awt.Color(250, 236, 182));
                    head_position.setFont(new java.awt.Font("Poppins SemiBold", 0, 16));
                    head_position.setAlignmentX(Component.LEFT_ALIGNMENT);

                    JLabel queue = new JLabel("Queue: " + io_queue_input.getText(), null, SwingConstants.LEFT);
                    queue.setBackground(new java.awt.Color(250, 236, 182));
                    queue.setFont(new java.awt.Font("Poppins SemiBold", 0, 16));
                    queue.setAlignmentX(Component.LEFT_ALIGNMENT);

                    JLabel seek_time = new JLabel(seek_label.getText(), null, SwingConstants.LEFT);
                    seek_time.setBackground(new java.awt.Color(250, 236, 182));
                    seek_time.setFont(new java.awt.Font("Poppins SemiBold", 0, 25));
                    seek_time.setAlignmentX(Component.LEFT_ALIGNMENT);
                    
                    // numberline.setBounds(getX(), getY(), 200, 200);
                    Box box = Box.createVerticalBox();
                    box.setBackground(new java.awt.Color(255, 255, 255));
                    box.setAlignmentX(Component.LEFT_ALIGNMENT);
                    box.add(algo);
                    box.add(head_position);
                    box.add(queue);
                    box.add(seek_time);
                    box.add(numberline);
                    
                    io_output_panel = new JPanel(); // crazy clearing mechansim for canvas
                    io_output_panel.add(box);;

                    io_output_panel.setAlignmentX(Component.LEFT_ALIGNMENT);
                    io_output_panel.setLayout(new BoxLayout(io_output_panel, BoxLayout.Y_AXIS));
                    io_output_panel.setBackground(new java.awt.Color(250, 236, 182));
                    io_output_panel_scroll.setViewportView(io_output_panel);

                    io_output_panel_scroll.getVerticalScrollBar().setValue(io_output_panel_scroll.getVerticalScrollBar().getValue());
                    io_output_panel_scroll.getVerticalScrollBar().setUnitIncrement(30);
                    scroll_value = scroll_value + 30;
                    io_output_panel_scroll.getVerticalScrollBar().setValue(scroll_value);
                    

                    if(count >= staticResults.length){
                        scroll_value = 0;
                        timer.stop();
                    }
                }
            });
            if(!timer.isRunning()){
                timer.start();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid Input: " + e, "Input Error", JOptionPane.ERROR_MESSAGE);
            timer.stop();
            return;
        }
    }


    // INSERT SIMULATE ALL IN HERE
    public void io_simulateAllActionPerformed(java.awt.event.ActionEvent evt) {
    Music.sfx();
    io_output_panel_scroll.getVerticalScrollBar().setValue(-10);     
    io_output_panel.removeAll();        
    io_save.setEnabled(true);
    
    temp_array = new ArrayList<Integer>();
    try(Scanner read = new Scanner(io_queue_input.getText())) {
        while(read.hasNext()){
            temp_array.add(read.nextInt());
        }

        if(temp_array.size() > 40){
            JOptionPane.showMessageDialog(null, "Invalid Input: Queue size exceeds 40", 
                    "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        main_queue = new int[temp_array.size()];
        
        for(int i = 0; i < temp_array.size(); i++){
            main_queue[i] = temp_array.get(i);
        }
        
        try {
            head = Integer.valueOf(io_position_input.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid Head Position", 
                    "Input Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Create a panel to hold all algorithm results
        JPanel allAlgorithmsPanel = new JPanel();
        allAlgorithmsPanel.setLayout(new BoxLayout(allAlgorithmsPanel, BoxLayout.Y_AXIS));
        allAlgorithmsPanel.setBackground(new java.awt.Color(250, 236, 182));
        
        // Add header information
        JLabel queueLabel = new JLabel("Queue: " + io_queue_input.getText(), null, SwingConstants.LEFT);
        queueLabel.setFont(new java.awt.Font("Poppins SemiBold", 0, 16));
        queueLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        JLabel headPositionLabel = new JLabel("Head Starting Position: " + io_position_input.getText(), null, SwingConstants.LEFT);
        headPositionLabel.setFont(new java.awt.Font("Poppins SemiBold", 0, 16));
        headPositionLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        allAlgorithmsPanel.add(queueLabel);
        allAlgorithmsPanel.add(headPositionLabel);
        allAlgorithmsPanel.add(Box.createRigidArea(new Dimension(0, 20)));
        
        // Array to store all algorithm names
        String[] algorithms = {"FCFS", "SSTF", "SCAN", "C-SCAN", "LOOK", "C-LOOK"};
        
        // Process each algorithm
        for(int algoIndex = 0; algoIndex < algorithms.length; algoIndex++) {
            ArrayList<Integer> sequence = new ArrayList<>();
            ArrayList<Integer> temp_results = new ArrayList<>();
            
            // Add head to sequence
            sequence.add(head);
            temp_results.add(head);
            
            // Add queue items to sequence
            for(int i = 0; i < main_queue.length; i++){
                sequence.add(main_queue[i]);
            }
            
            int[] results;
            
            // Process based on algorithm type
            switch(algoIndex) {
                case 0: // FCFS
                    results = DiskAlgos.FCFS(main_queue, head);
                    for(int i = 0; i < results.length; i++){
                        temp_results.add(results[i]);
                    }
                    results = temp_results.stream().mapToInt(i -> i).toArray();
                    break;
                    
                case 1: // SSTF
                    results = DiskAlgos.SSTF(main_queue, head);
                    break;
                    
                case 2: // SCAN
                    results = DiskAlgos.SCAN(main_queue, head, direction);
                    for(int i = 0; i < results.length; i++){
                        temp_results.add(results[i]);
                    }
                    results = temp_results.stream().mapToInt(i -> i).toArray();
                    break;
                    
                case 3: // C-SCAN
                    results = DiskAlgos.CSCAN(main_queue, head);
                    for(int i = 0; i < results.length; i++){
                        temp_results.add(results[i]);
                    }
                    results = temp_results.stream().mapToInt(i -> i).toArray();
                    break;
                    
                case 4: // LOOK
                    results = DiskAlgos.LOOK(main_queue, head, direction);
                    for(int i = 0; i < results.length; i++){
                        temp_results.add(results[i]);
                    }
                    results = temp_results.stream().mapToInt(i -> i).toArray();
                    break;
                    
                case 5: // C-LOOK
                    results = DiskAlgos.CLOOK(main_queue, head);
                    for(int i = 0; i < results.length; i++){
                        temp_results.add(results[i]);
                    }
                    results = temp_results.stream().mapToInt(i -> i).toArray();
                    break;
                    
                default:
                    results = new int[0];
            }
            
            // Calculate seek time for this algorithm
            int seekTime = 0;
            for(int i = 1; i < results.length; i++) {
                seekTime += Math.abs(results[i] - results[i-1]);
            }
            
            // Create algorithm panel
            JPanel algoPanel = new JPanel();
            algoPanel.setLayout(new BoxLayout(algoPanel, BoxLayout.Y_AXIS));
            algoPanel.setBackground(new java.awt.Color(250, 236, 182));
            algoPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
            
            // Algorithm name
            JLabel algoName = new JLabel("Algorithm: " + algorithms[algoIndex], null, SwingConstants.LEFT);
            algoName.setFont(new java.awt.Font("Poppins SemiBold", 0, 16));
            algoName.setAlignmentX(Component.LEFT_ALIGNMENT);
            
            // Seek time
            JLabel seekTimeLabel = new JLabel("Total Seek Time: " + seekTime, null, SwingConstants.LEFT);
            seekTimeLabel.setFont(new java.awt.Font("Poppins SemiBold", 0, 25));
            seekTimeLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
            
            // Create number line visualization
            int start = 0;
            int end = 199;
            
            NumberLineDrawing numberline = new NumberLineDrawing(start, end, sequence, results, head, speed);
            numberline.setAutoscrolls(true);
            
            int size = main_queue.length * 60 + 40;
            if (algorithms[algoIndex].equals("C-SCAN")) {
                size = size + 100;
            }
            
            numberline.setPreferredSize(new Dimension(920, size));
            
            // Add components to algorithm panel
            algoPanel.add(algoName);
            algoPanel.add(seekTimeLabel);
            algoPanel.add(numberline);
            
            // Add separator between algorithms
            algoPanel.add(Box.createRigidArea(new Dimension(0, 30)));
            JSeparator separator = new JSeparator();
            separator.setMaximumSize(new Dimension(920, 2));
            algoPanel.add(separator);
            algoPanel.add(Box.createRigidArea(new Dimension(0, 30)));
            
            // Add this algorithm's panel to the main panel
            allAlgorithmsPanel.add(algoPanel);
        }
        
        // Set the content of the output panel
        io_output_panel.removeAll();
        io_output_panel.add(allAlgorithmsPanel);
        io_output_panel.setAlignmentX(Component.LEFT_ALIGNMENT);
        io_output_panel.setLayout(new BoxLayout(io_output_panel, BoxLayout.Y_AXIS));
        io_output_panel.setBackground(new java.awt.Color(250, 236, 182));
        io_output_panel_scroll.setViewportView(io_output_panel);
        
        // Configure scrolling
        io_output_panel_scroll.getVerticalScrollBar().setValue(0);
        io_output_panel_scroll.getVerticalScrollBar().setUnitIncrement(30);
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, "Invalid Input: " + e, 
                "Input Error", JOptionPane.ERROR_MESSAGE);
        return;
    }
}



    public void io_save_pngMouseEntered(java.awt.event.MouseEvent evt) {                                         
        io_save_png.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/png_hover.png")));
    }                                        

    public void io_save_pngMouseExited(java.awt.event.MouseEvent evt) {                                        
        io_save_png.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/png.png")));
    }                                       

    public void io_save_pngActionPerformed(java.awt.event.ActionEvent evt) {                                            
        Music.sfx();
        File directory = new File(io_directory_input.getText());
        String fileName;

        String text = io_directory_input.getText();
        String searchText = "\\";
        String replacementText = "/";

        // Loop until there are no more occurrences of searchText
        while (text.contains(searchText)) {
            // Find the index of the first occurrence of searchText
            int index = text.indexOf(searchText);

            // Replace searchText with replacementText
            text = text.substring(0, index) + replacementText + text.substring(index + searchText.length());
        }
        char lastCharacter = text.charAt(text.length() - 1);
        if(lastCharacter != '/') {
            text = text + "/";
        }

        if(directory.isDirectory() && io_directory_input.getText() != "C://Users/PC/directory/") {
            fileName = text + getLocalTime() + ".png";
        } else {
            JOptionPane.showMessageDialog(DiskPlay.IO, "Directory is empty/invalid. Saving to default directory."); 
            fileName = getLocalTime() + ".png";
        }
        
        saveJScrollPaneAsImage(io_output_panel_scroll, fileName);

        setPanelEnabled(io_backpanel, true);
        setPanelEnabled(io_output_panel, true);
        io_output_panel_scroll.setVisible(true);
        io_left_button.setEnabled(true);
        io_right_button.setEnabled(true);
        scan_look.setEnabled(true);
        seek_label.setEnabled(true);
        io_save_panel.setVisible(false);
    }                                           

    public void io_save_pdfMouseEntered(java.awt.event.MouseEvent evt) {                                         
        io_save_pdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/pdf_hover.png")));
    }                                        

    public void io_save_pdfMouseExited(java.awt.event.MouseEvent evt) {                                        
        io_save_pdf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/io_panel/pdf.png")));
    }                                       

    public void io_save_pdfActionPerformed(java.awt.event.ActionEvent evt) {                                            
        Music.sfx();

        String fileName = "temp.png";
        saveJScrollPaneAsImage(io_output_panel_scroll, fileName);

        File directory = new File(io_directory_input.getText());
        String pdfPath;

        String text = io_directory_input.getText();
        String searchText = "\\";
        String replacementText = "/";

        // Loop until there are no more occurrences of searchText
        while (text.contains(searchText)) {
            // Find the index of the first occurrence of searchText
            int index = text.indexOf(searchText);

            // Replace searchText with replacementText
            text = text.substring(0, index) + replacementText + text.substring(index + searchText.length());
        }
        char lastCharacter = text.charAt(text.length() - 1);
        if(lastCharacter != '/') {
            text = text + "/";
        }

        if(directory.isDirectory() && io_directory_input.getText() != "C://Users/PC/directory/") {
            pdfPath = text + getLocalTime() + ".pdf";
        } else {
            JOptionPane.showMessageDialog(DiskPlay.IO, "Directory is empty/invalid. Saving to default directory."); 
            pdfPath = getLocalTime() + ".pdf";
        }

        try {   
            BufferedImage bufferedImage = ImageIO.read(new File(fileName));
            int imageWidth = bufferedImage.getWidth() + 70;
            int imageHeight = bufferedImage.getHeight() + 70;

            Document document = new Document();
            document.setPageSize(new com.itextpdf.text.Rectangle(imageWidth, imageHeight));
            PdfWriter.getInstance(document, new FileOutputStream(pdfPath));
            document.open();

            Image image = Image.getInstance(bufferedImage, null);
            document.add(image);

            document.close();
            
            File imageFile = new File(fileName);
            imageFile.delete();

        } catch (IOException | DocumentException e) {
            e.printStackTrace();
        }

        setPanelEnabled(io_backpanel, true);
        setPanelEnabled(io_output_panel, true);
        io_output_panel_scroll.setVisible(true);
        io_left_button.setEnabled(true);
        io_right_button.setEnabled(true);
        scan_look.setEnabled(true);
        seek_label.setEnabled(true);
        io_save_panel.setVisible(false);
    }                                           

    public void io_return_panelMouseEntered(java.awt.event.MouseEvent evt) {                                             
        io_return_panel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/buttons/return_hover.png")));
    }                                            

    public void io_return_panelMouseExited(java.awt.event.MouseEvent evt) {                                            
        io_return_panel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/buttons/return.png")));
    }                                           

    public void io_return_panelActionPerformed(java.awt.event.ActionEvent evt) {     
        Music.sfx();                                           
        setPanelEnabled(io_backpanel, true);
        setPanelEnabled(io_output_panel, true);
        io_output_panel_scroll.setVisible(true);
        io_left_button.setEnabled(true);
        io_right_button.setEnabled(true);
        scan_look.setEnabled(true);
        seek_label.setEnabled(true);
        io_save_panel.setVisible(false);
    }                                               

     void setPanelEnabled(javax.swing.JPanel panel, Boolean isEnabled) {
        panel.setEnabled(isEnabled);
        java.awt.Component[] components = panel.getComponents();
    
        for (java.awt.Component component : components) {
            if (component instanceof javax.swing.JPanel)
                setPanelEnabled((javax.swing.JPanel) component, isEnabled);
            component.setEnabled(isEnabled);
        }
    }

    private static String getLocalTime() {
        LocalDate currentDate = LocalDate.now();

        // Get the current time
        LocalTime currentTime = LocalTime.now();

        // Define the desired date and time formats
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MMddyy");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hhmmss");

        // Format the current date and time
        String formattedDate = currentDate.format(dateFormatter);
        String formattedTime = currentTime.format(timeFormatter);

        return formattedDate + "_" + formattedTime + "_DS";
    }

    private static void saveJScrollPaneAsImage(JScrollPane scrollPane, String filename) {
        // Get the panel or component contained in the JScrollPane
        JComponent component = (JComponent) scrollPane.getViewport().getView();

        // Get the size of the panel or component
        Dimension size = component.getSize();

        // Create a BufferedImage with the size of the panel or component
        BufferedImage image = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_RGB);

        // Create a Graphics2D object from the image
        Graphics2D graphics = image.createGraphics();

        // Paint the panel or component onto the image
        component.paint(graphics);

        // Dispose the graphics object
        graphics.dispose();

        // Save the image to a file
        try {
            ImageIO.write(image, "png", new File(filename));
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
                 
    public javax.swing.JButton exit;
    public javax.swing.JButton io_add;
    public javax.swing.JLabel io_algo_label;
    public javax.swing.JComboBox<String> io_algo_select;
    public javax.swing.JPanel io_backpanel;
    public javax.swing.JLabel io_bg;
    public javax.swing.JLabel io_directory_bg;
    public javax.swing.JTextField io_directory_input;
    public javax.swing.JLabel io_directory_label;
    public javax.swing.JLabel io_dot_clook;
    public javax.swing.JLabel io_dot_cscan;
    public javax.swing.JLabel io_dot_fcfs;
    public javax.swing.JLabel io_dot_look;
    public javax.swing.JLabel io_dot_scan;
    public javax.swing.JLabel io_dot_sstf;
    public javax.swing.JButton io_import;
    public javax.swing.JButton io_minus;
    public javax.swing.JPanel io_output_panel;
    public javax.swing.JScrollPane io_output_panel_scroll;
    public javax.swing.JLabel io_position_bg;
    public javax.swing.JTextField io_position_input;
    public javax.swing.JLabel io_speed_value;
    public javax.swing.JTextField io_queue_input;
    public javax.swing.JButton io_random;
    public javax.swing.JButton io_return;
    public javax.swing.JButton io_return_panel;
    public javax.swing.JButton io_save;
    public javax.swing.JLabel io_save_bg;
    public javax.swing.JLabel io_save_label;
    public javax.swing.JPanel io_save_panel;
    public javax.swing.JButton io_save_pdf;
    public javax.swing.JButton io_save_png;
    public javax.swing.JLabel io_speed_bg;
    public javax.swing.JLabel io_speed_label;
    public javax.swing.JButton io_simulate;
    public javax.swing.JButton io_simulate_all;
    public javax.swing.JLabel io_select_algo_bg;
    public javax.swing.JLabel io_seek_bg;
    public javax.swing.JLabel io_timer_bg;
    public javax.swing.JLabel io_timer_label;
    public javax.swing.JButton minimize;             
    public ArrayList<Integer> import_ArrayList;
    public NumberLineDrawing numberline;
    public javax.swing.JButton io_left_button; 
    public javax.swing.JButton io_right_button;
    public javax.swing.JLabel seek_label;
    public javax.swing.JLabel scan_look;
    public int[] results;
    public Timer timer;
    public int count = 0;
    public int scroll_value;
}
