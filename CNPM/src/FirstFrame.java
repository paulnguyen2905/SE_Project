import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.SystemColor;

public class FirstFrame extends JFrame {

	private Image image_Exit = new ImageIcon(FirstFrame.class.getResource("image/close_icon.png")).getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH);
	private Image banner = new ImageIcon(FirstFrame.class.getResource("image/banner.png")).getImage().getScaledInstance(900, 120, Image.SCALE_SMOOTH);

	private final JButton buttonTrangChu = new JButton("Trang chủ");
	private final JButton buttonDangNhap = new JButton("Đăng nhập");
	private final JButton buttonDangKy = new JButton("Đăng ký tuyển sinh");
	
	private final JButton exitButton = new JButton("");
	private final JLabel imageBanner = new JLabel("");
	private final JPanel header = new JPanel();
	
	public static CardLayout cardLayout = new CardLayout();
	public static JPanel background = new JPanel();
	public static JPanel panelMainContent = new JPanel();
	public panelDangKy panelDK = new panelDangKy();
	public panelDangNhap panelDN = new panelDangNhap();
	
	private int mouseX, mouseY;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FirstFrame frame = new FirstFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FirstFrame() {
		initialize();
	}
	
	
	private void initialize() {
		getContentPane().setLayout(null);
		setUndecorated(true);
		setBounds(500, 200, 900, 620);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		add(background);
		background.setLayout(null);
		background.setBackground(new Color(224, 255, 255));
		background.setBounds(0, 120, 900, 500);
		background.setLayout(cardLayout);
		background.add(panelMainContent, "0");
		background.add(panelDN, "1");
		background.add(panelDK, "2");
		cardLayout.show(background, "0");
		
		panelMainContent.setLayout(null);
		panelMainContent.setBackground(new Color(200, 255, 255));
		panelMainContent.setBounds(0, 120, 900, 500);
		
		panelMainContent.add(buttonTrangChu);
		buttonTrangChu.setBounds(340, 150, 220, 32);
		buttonTrangChu.setFocusPainted(false);
		buttonTrangChu.setFont(new Font("Times New Roman", Font.BOLD, 22));
		buttonTrangChu.setFocusPainted(false);
		buttonTrangChu.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				buttonTrangChu.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				try {
			        Desktop.getDesktop().browse(new URI("https://daa.uit.edu.vn/"));
			    }
				catch (IOException | URISyntaxException e1) {
			        e1.printStackTrace();
			    }
			}
		});
		
		panelMainContent.add(buttonDangNhap);
		buttonDangNhap.setBounds(340, 200, 220, 32);
		buttonDangNhap.setFocusPainted(false);
		buttonDangNhap.setFont(new Font("Times New Roman", Font.BOLD, 22));
		buttonDangNhap.setFocusPainted(false);
		buttonDangNhap.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				buttonDangNhap.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				cardLayout.show(background, "1");
		}
		});
		
		panelMainContent.add(buttonDangKy);
		buttonDangKy.setBounds(340, 250, 220, 32);
		buttonDangKy.setFocusPainted(false);
		buttonDangKy.setFont(new Font("Times New Roman", Font.BOLD, 22));
		buttonDangKy.setFocusPainted(false);
		buttonDangKy.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				buttonDangKy.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
					cardLayout.show(background, "2");
			}
		});
		
		getContentPane().add(imageBanner);
		imageBanner.setBounds(0, 20, 900, 120);
		imageBanner.setIcon(new ImageIcon(banner));
		
		getContentPane().add(header);
		header.setBounds(0, 0, 900, 20);
		header.setLayout(null);
		
		header.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				setLocation(getX() + e.getX() - mouseX, getY() + e.getY() - mouseY);
			}
		});
		header.addMouseListener(new MouseAdapter( ) {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		
		header.add(exitButton);
		exitButton.setBounds(875, 0, 26, 20);
		exitButton.setBackground(Color.WHITE);
		exitButton.setBorder(null);
		exitButton.setContentAreaFilled(false);
		exitButton.setIcon(new ImageIcon(image_Exit));
		exitButton.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				exitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		exitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame fromLoginSystem = new JFrame("Exit");
				int confirmed = JOptionPane.showConfirmDialog(fromLoginSystem, "Are you sure you want to exit this application?", 
				"Login System", JOptionPane.YES_NO_OPTION);
				if (confirmed == JOptionPane.YES_OPTION)
					System.exit(0);
				else
					setVisible(true);
			}
		});
		
	}

}
