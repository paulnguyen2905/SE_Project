import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class panelUser extends JPanel {
	private final JPanel panelMenu = new JPanel();
	private final JPanel tabPhieuThiUser = new JPanel();
	private final JPanel tabXemDiem = new JPanel();
	private final JPanel tabThongTin = new JPanel();
	private final JLabel labelPhieuThiUser = new JLabel("Phiếu báo thi");
	private final JLabel labelXemDiem = new JLabel("Xem điểm");
	private final JLabel labelThongTin = new JLabel("Thông tin cá nhân");
	
	private panelPhieuThiUser panelPhieuThiUser = new panelPhieuThiUser();
	private panelXemDiem panelXemDiem = new panelXemDiem();
	private panelThongTin panelThongTin = new panelThongTin();
	
	public static CardLayout cardLayout = new CardLayout();
	public static JPanel background = new JPanel();
	public static JPanel contentPane = new JPanel();


	public panelUser() {
		initGUI();
	}
	
	private void initGUI() {
		setLayout(null);
		setBounds(0, 0, 900, 500);
		
		add(panelMenu);
		panelMenu.setLayout(null);
		panelMenu.setBackground(new Color(51, 102, 153));
		panelMenu.setBounds(0, 0, 900, 50);
		
		panelMenu.add(tabThongTin);
		tabThongTin.setLayout(null);
		tabThongTin.setBackground(new Color(200, 255, 255));
		tabThongTin.setBounds(0, 0, 300, 50);
		tabThongTin.add(labelThongTin);
		labelThongTin.setFont(new Font("Times New Roman", Font.BOLD, 25));
		labelThongTin.setBounds(40, 0, 220, 50);
		labelThongTin.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				labelThongTin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				tabThongTin.setBackground(new Color(200, 255, 255));
				tabXemDiem.setBackground(new Color(51, 102, 153));
				tabPhieuThiUser.setBackground(new Color(51, 102, 153));
				panelThongTin.setVisible(true);
				panelXemDiem.setVisible(false);
				panelPhieuThiUser.setVisible(false);
				panelThongTin.updateInfo();
			}
		});
		
		panelMenu.add(tabPhieuThiUser);
		tabPhieuThiUser.setLayout(null);
		tabPhieuThiUser.setBackground(new Color(51, 102, 153));
		tabPhieuThiUser.setBounds(300, 0, 300, 50);
		tabPhieuThiUser.add(labelPhieuThiUser);
		labelPhieuThiUser.setFont(new Font("Times New Roman", Font.BOLD, 25));
		labelPhieuThiUser.setBounds(75, 0, 150, 50);
		labelPhieuThiUser.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				labelPhieuThiUser.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				tabPhieuThiUser.setBackground(new Color(200, 255, 255));
				tabThongTin.setBackground(new Color(51, 102, 153));
				tabXemDiem.setBackground(new Color(51, 102, 153));
				panelThongTin.setVisible(false);
				panelXemDiem.setVisible(false);
				panelPhieuThiUser.setVisible(true);
				panelPhieuThiUser.updateInfo();
			}
		});
		
		panelMenu.add(tabXemDiem);
		tabXemDiem.setLayout(null);
		tabXemDiem.setBackground(new Color(51, 102, 153));
		tabXemDiem.setBounds(600, 0, 300, 50);
		tabXemDiem.add(labelXemDiem);
		labelXemDiem.setFont(new Font("Times New Roman", Font.BOLD, 25));
		labelXemDiem.setBounds(95, 0, 110, 50);
		labelXemDiem.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				labelXemDiem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				tabXemDiem.setBackground(new Color(200, 255, 255));
				tabThongTin.setBackground(new Color(51, 102, 153));
				tabPhieuThiUser.setBackground(new Color(51, 102, 153));
				panelThongTin.setVisible(false);
				panelXemDiem.setVisible(true);
				panelPhieuThiUser.setVisible(false);
				panelXemDiem.updateInfo();
			}
		});
		
		add(background);
		background.setLayout(null);
		background.setBackground(new Color(200, 255, 255));
		background.setBounds(0, 50, 900, 450);
		background.setLayout(cardLayout);
		background.add(contentPane, "0");
		
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(200, 255, 255));
		contentPane.setBounds(0, 0, 900, 500);
		contentPane.add(panelThongTin);
		contentPane.add(panelPhieuThiUser);
		contentPane.add(panelXemDiem);

	}

}
