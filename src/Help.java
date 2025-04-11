public class Help extends javax.swing.JPanel {
    public Help() {
        initComponents();
    }

    private void initComponents() {
        exit = new javax.swing.JButton();
        minimize = new javax.swing.JButton();
        help_return = new javax.swing.JButton();
        help_bg = new javax.swing.JLabel();

        help_fcfs = new javax.swing.JButton();
        help_sstf = new javax.swing.JButton();
        help_scan = new javax.swing.JButton();
        help_cScan = new javax.swing.JButton();
        help_look = new javax.swing.JButton();
        help_cLook = new javax.swing.JButton();

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
        exit.setBounds(1160, 20, 40, 30);

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
        minimize.setBounds(1120, 20, 40, 30);

        help_return.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/buttons/return.png"))); 
        help_return.setBorder(null);
        help_return.setBorderPainted(false);
        help_return.setContentAreaFilled(false);
        help_return.setFocusPainted(false);
        help_return.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                help_returnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                help_returnMouseExited(evt);
            }
        });
        help_return.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                help_returnActionPerformed(evt);
            }
        });
        add(help_return);
        help_return.setBounds(1090, 600, 80, 80);

        help_fcfs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/algorithm_info/FCFS.png"))); 
        help_fcfs.setBorder(null);
        help_fcfs.setBorderPainted(false);
        help_fcfs.setContentAreaFilled(false);
        help_fcfs.setFocusPainted(false);
        help_fcfs.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        help_fcfs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                help_fcfsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                help_fcfsMouseExited(evt);
            }
        });
        add(help_fcfs);
        help_fcfs.setBounds(665, 190, 236, 109);

        help_sstf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/algorithm_info/SSTF.png"))); 
        help_sstf.setBorder(null);
        help_sstf.setBorderPainted(false);
        help_sstf.setContentAreaFilled(false);
        help_sstf.setFocusPainted(false);
        help_sstf.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        help_sstf.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                help_sstfMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                help_sstfMouseExited(evt);
            }
        });
        add(help_sstf);
        help_sstf.setBounds(900, 190, 236, 109);

        help_scan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/algorithm_info/SCAN.png"))); 
        help_scan.setBorder(null);
        help_scan.setBorderPainted(false);
        help_scan.setContentAreaFilled(false);
        help_scan.setFocusPainted(false);
        help_scan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        help_scan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                help_scanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                help_scanMouseExited(evt);
            }
        });
        add(help_scan);
        help_scan.setBounds(665, 300, 236, 109);

        help_cScan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/algorithm_info/C-SCAN.png"))); 
        help_cScan.setBorder(null);
        help_cScan.setBorderPainted(false);
        help_cScan.setContentAreaFilled(false);
        help_cScan.setFocusPainted(false);
        help_cScan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        help_cScan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                help_cScanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                help_cScanMouseExited(evt);
            }
        });
        add(help_cScan);
        help_cScan.setBounds(900, 300, 236, 109);

        help_look.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/algorithm_info/LOOK.png"))); 
        help_look.setBorder(null);
        help_look.setBorderPainted(false);
        help_look.setContentAreaFilled(false);
        help_look.setFocusPainted(false);
        help_look.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        help_look.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                help_lookMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                help_lookMouseExited(evt);
            }
        });
        add(help_look);
        help_look.setBounds(665, 410, 236, 109);

        help_cLook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/algorithm_info/C-LOOK.png"))); 
        help_cLook.setBorder(null);
        help_cLook.setBorderPainted(false);
        help_cLook.setContentAreaFilled(false);
        help_cLook.setFocusPainted(false);
        help_cLook.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        help_cLook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                help_cLookMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                help_cLookMouseExited(evt);
            }
        });
        add(help_cLook);
        help_cLook.setBounds(900, 410, 236, 109);


        help_bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/backgrounds/help.png"))); 
        help_bg.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        help_bg.setOpaque(true);
        add(help_bg);
        help_bg.setBounds(0, 0, 1224, 720);
    }

    private void help_returnMouseEntered(java.awt.event.MouseEvent evt) {
        help_return.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/buttons/return_hover.png")));
    }

    private void help_returnMouseExited(java.awt.event.MouseEvent evt) {
        help_return.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/buttons/return.png")));
    }

    private void help_returnActionPerformed(java.awt.event.ActionEvent evt) {
        Music.sfx();
        DiskPlay.card.show(DiskPlay.mainPanel, "2");
    }

    private void minimizeMouseEntered(java.awt.event.MouseEvent evt) {
        minimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/buttons/min_hover.png")));
    }

    private void minimizeMouseExited(java.awt.event.MouseEvent evt) {
        minimize.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/buttons/min.png")));
    }

    private void minimizeActionPerformed(java.awt.event.ActionEvent evt) {
        Music.sfx();
        DiskPlay.mainFrame.setState(java.awt.Frame.ICONIFIED);
    }

    private void exitMouseEntered(java.awt.event.MouseEvent evt) {
        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/buttons/close_hover.png")));
    }

    private void exitMouseExited(java.awt.event.MouseEvent evt) {
        exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/buttons/close.png")));
    }

    private void exitActionPerformed(java.awt.event.ActionEvent evt) {
        Music.sfx();
        System.exit(0);
    }

    private void help_fcfsMouseEntered(java.awt.event.MouseEvent evt) {
        help_fcfs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/algorithm_info/FCFS_hover.png")));
    }

    private void help_fcfsMouseExited(java.awt.event.MouseEvent evt) {
        help_fcfs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/algorithm_info/FCFS.png")));
    }

    private void help_sstfMouseEntered(java.awt.event.MouseEvent evt) {
        help_sstf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/algorithm_info/SSTF_hover.png")));
    }

    private void help_sstfMouseExited(java.awt.event.MouseEvent evt) {
        help_sstf.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/algorithm_info/SSTF.png")));
    }

    private void help_scanMouseEntered(java.awt.event.MouseEvent evt) {
        help_scan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/algorithm_info/SCAN_hover.png")));
    }

    private void help_scanMouseExited(java.awt.event.MouseEvent evt) {
        help_scan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/algorithm_info/SCAN.png")));
    }

    private void help_cScanMouseEntered(java.awt.event.MouseEvent evt) {
        help_cScan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/algorithm_info/C-SCAN_hover.png")));
    }

    private void help_cScanMouseExited(java.awt.event.MouseEvent evt) {
        help_cScan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/algorithm_info/C-SCAN.png")));
    }

    private void help_lookMouseEntered(java.awt.event.MouseEvent evt) {
        help_look.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/algorithm_info/LOOK_hover.png")));
    }

    private void help_lookMouseExited(java.awt.event.MouseEvent evt) {
        help_look.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/algorithm_info/LOOK.png")));
    }

    private void help_cLookMouseEntered(java.awt.event.MouseEvent evt) {
        help_cLook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/algorithm_info/C-LOOK_hover.png")));
    }

    private void help_cLookMouseExited(java.awt.event.MouseEvent evt) {
        help_cLook.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/algorithm_info/C-LOOK.png")));
    }


    private javax.swing.JButton exit;
    private javax.swing.JLabel help_bg;
    private javax.swing.JButton help_return;
    private javax.swing.JButton minimize;

    private javax.swing.JButton help_fcfs;
    private javax.swing.JButton help_sstf;
    private javax.swing.JButton help_scan;
    private javax.swing.JButton help_cScan;
    private javax.swing.JButton help_look;
    private javax.swing.JButton help_cLook;
}
