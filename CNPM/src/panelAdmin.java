import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class panelAdmin extends JPanel {
	private final JPanel panelMenu = new JPanel();
	private final JPanel tabPhieuBaoThi = new JPanel();
	private final JPanel tabChamDiem = new JPanel();
	private final JPanel tabNhapDiem = new JPanel();
	private final JLabel labelPhieuBaoThi = new JLabel("Phiếu báo thi");
	private final JLabel labelChamDiem = new JLabel("Chấm điểm");
	private final JLabel labelNhapDiem = new JLabel("Nhập điểm - gán phách");
	
	private panelPhieuBaoThi panelPhieuBaoThi = new panelPhieuBaoThi();
	private panelNhapDiem panelNhapDiem = new panelNhapDiem();
	private panelChamDiem panelChamDiem = new panelChamDiem();
	
	public static CardLayout cardLayout = new CardLayout();
	public static JPanel background = new JPanel();
	public static JPanel contentPane = new JPanel();

	public panelAdmin() {
		initGUI();
		panelPhieuBaoThi.showData();
	}
	
	private void initGUI() {
		setLayout(null);
		setBounds(0, 0, 900, 500);
		
		add(panelMenu);
		panelMenu.setLayout(null);
		panelMenu.setBackground(new Color(51, 102, 153));
		panelMenu.setBounds(0, 0, 900, 50);
		
		panelMenu.add(tabPhieuBaoThi);
		tabPhieuBaoThi.setLayout(null);
		tabPhieuBaoThi.setBackground(new Color(200, 255, 255));
		tabPhieuBaoThi.setBounds(0, 0, 300, 50);
		tabPhieuBaoThi.add(labelPhieuBaoThi);
		labelPhieuBaoThi.setFont(new Font("Times New Roman", Font.BOLD, 25));
		labelPhieuBaoThi.setBounds(78, 0, 150, 50);
		labelPhieuBaoThi.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				labelPhieuBaoThi.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				tabPhieuBaoThi.setBackground(new Color(200, 255, 255));
				tabNhapDiem.setBackground(new Color(51, 102, 153));
				tabChamDiem.setBackground(new Color(51, 102, 153));
				panelPhieuBaoThi.setVisible(true);
				panelNhapDiem.setVisible(false);
				panelChamDiem.setVisible(false);
			}
		});
		
		panelMenu.add(tabChamDiem);
		tabChamDiem.setLayout(null);
		tabChamDiem.setBackground(new Color(51, 102, 153));
		tabChamDiem.setBounds(300, 0, 300, 50);
		tabChamDiem.add(labelChamDiem);
		labelChamDiem.setFont(new Font("Times New Roman", Font.BOLD, 25));
		labelChamDiem.setBounds(85, 0, 130, 50);
		labelChamDiem.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				labelChamDiem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				tabChamDiem.setBackground(new Color(200, 255, 255));
				tabPhieuBaoThi.setBackground(new Color(51, 102, 153));
				tabNhapDiem.setBackground(new Color(51, 102, 153));
				panelPhieuBaoThi.setVisible(false);
				panelNhapDiem.setVisible(false);
				panelChamDiem.setVisible(true);
			}
		});
		
		panelMenu.add(tabNhapDiem);
		tabNhapDiem.setLayout(null);
		tabNhapDiem.setBackground(new Color(51, 102, 153));
		tabNhapDiem.setBounds(600, 0, 300, 50);
		tabNhapDiem.add(labelNhapDiem);
		labelNhapDiem.setFont(new Font("Times New Roman", Font.BOLD, 25));
		labelNhapDiem.setBounds(25, 0, 250, 50);
		labelNhapDiem.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				labelNhapDiem.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				tabNhapDiem.setBackground(new Color(200, 255, 255));
				tabPhieuBaoThi.setBackground(new Color(51, 102, 153));
				tabChamDiem.setBackground(new Color(51, 102, 153));
				panelPhieuBaoThi.setVisible(false);
				panelNhapDiem.setVisible(true);
				panelChamDiem.setVisible(false);
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
		contentPane.add(panelPhieuBaoThi);
		contentPane.add(panelChamDiem);
		contentPane.add(panelNhapDiem);
		
	}

}
