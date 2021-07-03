import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class panelDangKy extends JPanel {
	private final JLabel labelTitle = new JLabel("Phiếu thông tin đăng ký dự thi");
	private final JLabel labelSoPhieu = new JLabel("Số phiếu:");
	private final JLabel labelKhoi = new JLabel("Khối:");
	private final JLabel labelHoTen = new JLabel("Họ và tên: ");
	private final JLabel labelNgaySinh = new JLabel("Ngày sinh:");
	private final JLabel labelKhuVuc = new JLabel("Khu vực:");
	private final JLabel labelNamTN = new JLabel("Năm tốt nghiệp TH:");
	private final JLabel labelHoKhau = new JLabel("Hộ khẩu thường trú:");
	private final JLabel labelDiaChi = new JLabel("Địa chỉ báo tin:");
	private final JLabel labelTruong = new JLabel("Đăng ký dự thi trường:");
	private final JLabel labelNganh = new JLabel("Mã ngành:");
	private final JLabel labelNoiSinh = new JLabel("Nơi sinh:");
	private final JLabel labelHeTH = new JLabel("Hệ TH: ");
	private final JLabel labelDoiTuong = new JLabel("Đối tượng dự thi:");
	
	public static JTextField textSoPhieu = new JTextField();
	public static JTextField textKhoi = new JTextField();
	public static JTextField textHoTen = new JTextField();
	public static JTextField textNgaySinh = new JTextField();
	public static JTextField textKhuVuc = new JTextField();
	public static JTextField textNamTN = new JTextField();
	public static JTextField textHoKhau = new JTextField();
	public static JTextField textDiaChi = new JTextField();
	public static JTextField textTruong = new JTextField();
	public static JTextField textNganh = new JTextField();
	public static JTextField textNoiSinh = new JTextField();
	public static JTextField textHeTH = new JTextField();
	public static JTextField textDoiTuong = new JTextField();
	
	private final JPanel contentPane = new JPanel();
	private final JButton buttonDK = new JButton("Đăng ký");
	private final JButton buttonBack = new JButton("Quay lại");
	
	public panelDangKy() {
		initGUI();
	}
	
	private void initGUI() {
		setLayout(null);
		setBounds(0, 0, 900, 500);
		
		add(contentPane);
		contentPane.setBounds(0, 0, 900, 500);
		contentPane.setBackground(new Color(200, 255, 255));
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{200, 260, 20, 210, 200, 10};
		gridBagLayout.rowHeights = new int[]{80, 40, 40, 40, 40, 40, 40, 40, 40, 5, 40, 55};
		gridBagLayout.columnWeights = new double[]{};
		gridBagLayout.rowWeights = new double[]{};
		contentPane.setLayout(gridBagLayout);
		
		GridBagConstraints gbc_labelTitle = new GridBagConstraints();
		gbc_labelTitle.fill = GridBagConstraints.VERTICAL;
		gbc_labelTitle.insets = new Insets(0, 0, 0, 0);
		gbc_labelTitle.gridwidth = 5;
		gbc_labelTitle.gridx = 0;
		gbc_labelTitle.gridy = 0;
		contentPane.add(labelTitle, gbc_labelTitle);
		labelTitle.setFont(new Font("Times New Roman", Font.BOLD, 36));
		labelTitle.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_labelSoPhieu = new GridBagConstraints();
		gbc_labelSoPhieu.anchor = GridBagConstraints.EAST;
		gbc_labelSoPhieu.fill = GridBagConstraints.VERTICAL;
		gbc_labelSoPhieu.insets = new Insets(0, 0, 0, 0);
		gbc_labelSoPhieu.gridx = 0;
		gbc_labelSoPhieu.gridy = 1;
		contentPane.add(labelSoPhieu, gbc_labelSoPhieu);
		labelSoPhieu.setFont(new Font("Times New Roman", Font.BOLD, 20));
		labelSoPhieu.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_textSoPhieu = new GridBagConstraints();
		gbc_textSoPhieu.fill = GridBagConstraints.HORIZONTAL;
		gbc_textSoPhieu.insets = new Insets(0, 10, 0, 0);
		gbc_textSoPhieu.gridx = 1;
		gbc_textSoPhieu.gridy = 1;
		contentPane.add(textSoPhieu, gbc_textSoPhieu);
		textSoPhieu.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textSoPhieu.setColumns(20);
		textSoPhieu.setBorder(null);
		
		GridBagConstraints gbc_labelHoTen = new GridBagConstraints();
		gbc_labelHoTen.anchor = GridBagConstraints.EAST;
		gbc_labelHoTen.fill = GridBagConstraints.VERTICAL;
		gbc_labelHoTen.insets = new Insets(0, 0, 0, 0);
		gbc_labelHoTen.gridx = 0;
		gbc_labelHoTen.gridy = 2;
		contentPane.add(labelHoTen, gbc_labelHoTen);
		labelHoTen.setFont(new Font("Times New Roman", Font.BOLD, 20));
		labelHoTen.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_textHoTen = new GridBagConstraints();
		gbc_textHoTen.fill = GridBagConstraints.HORIZONTAL;
		gbc_textHoTen.insets = new Insets(0, 10, 0, 0);
		gbc_textHoTen.gridx = 1;
		gbc_textHoTen.gridy = 2;
		contentPane.add(textHoTen, gbc_textHoTen);
		textHoTen.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textHoTen.setColumns(20);
		textHoTen.setBorder(null);
		
		GridBagConstraints gbc_labelKhoi = new GridBagConstraints();
		gbc_labelKhoi.anchor = GridBagConstraints.EAST;
		gbc_labelKhoi.fill = GridBagConstraints.VERTICAL;
		gbc_labelKhoi.insets = new Insets(0, 0, 0, 0);
		gbc_labelKhoi.gridx = 0;
		gbc_labelKhoi.gridy = 3;
		contentPane.add(labelKhoi, gbc_labelKhoi);
		labelKhoi.setFont(new Font("Times New Roman", Font.BOLD, 20));
		labelKhoi.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_textKhoi = new GridBagConstraints();
		gbc_textKhoi.fill = GridBagConstraints.HORIZONTAL;
		gbc_textKhoi.insets = new Insets(0, 10, 0, 0);
		gbc_textKhoi.gridx = 1;
		gbc_textKhoi.gridy = 3;
		contentPane.add(textKhoi, gbc_textKhoi);
		textKhoi.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textKhoi.setColumns(20);
		textKhoi.setBorder(null);
		
		GridBagConstraints gbc_labelNgaySinh = new GridBagConstraints();
		gbc_labelNgaySinh.anchor = GridBagConstraints.EAST;
		gbc_labelNgaySinh.fill = GridBagConstraints.VERTICAL;
		gbc_labelNgaySinh.insets = new Insets(0, 0, 0, 0);
		gbc_labelNgaySinh.gridx = 0;
		gbc_labelNgaySinh.gridy = 4;
		contentPane.add(labelNgaySinh, gbc_labelNgaySinh);
		labelNgaySinh.setFont(new Font("Times New Roman", Font.BOLD, 20));
		labelNgaySinh.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_textNgaySinh = new GridBagConstraints();
		gbc_textNgaySinh.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNgaySinh.insets = new Insets(0, 10, 0, 0);
		gbc_textNgaySinh.gridx = 1;
		gbc_textNgaySinh.gridy = 4;
		contentPane.add(textNgaySinh, gbc_textNgaySinh);
		textNgaySinh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textNgaySinh.setColumns(20);
		textNgaySinh.setBorder(null);
		
		GridBagConstraints gbc_labelKhuVuc = new GridBagConstraints();
		gbc_labelKhuVuc.anchor = GridBagConstraints.EAST;
		gbc_labelKhuVuc.fill = GridBagConstraints.VERTICAL;
		gbc_labelKhuVuc.insets = new Insets(0, 0, 0, 0);
		gbc_labelKhuVuc.gridx = 0;
		gbc_labelKhuVuc.gridy = 5;
		contentPane.add(labelKhuVuc, gbc_labelKhuVuc);
		labelKhuVuc.setFont(new Font("Times New Roman", Font.BOLD, 20));
		labelKhuVuc.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_textKhuVuc = new GridBagConstraints();
		gbc_textKhuVuc.fill = GridBagConstraints.HORIZONTAL;
		gbc_textKhuVuc.insets = new Insets(0, 10, 0, 0);
		gbc_textKhuVuc.gridx = 1;
		gbc_textKhuVuc.gridy = 5;
		contentPane.add(textKhuVuc, gbc_textKhuVuc);
		textKhuVuc.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textKhuVuc.setColumns(20);
		textKhuVuc.setBorder(null);
		
		GridBagConstraints gbc_labelNamTN = new GridBagConstraints();
		gbc_labelNamTN.anchor = GridBagConstraints.EAST;
		gbc_labelNamTN.fill = GridBagConstraints.VERTICAL;
		gbc_labelNamTN.insets = new Insets(0, 0, 0, 0);
		gbc_labelNamTN.gridx = 0;
		gbc_labelNamTN.gridy = 6;
		contentPane.add(labelNamTN, gbc_labelNamTN);
		labelNamTN.setFont(new Font("Times New Roman", Font.BOLD, 20));
		labelNamTN.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_textNamTN = new GridBagConstraints();
		gbc_textNamTN.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNamTN.insets = new Insets(0, 10, 0, 0);
		gbc_textNamTN.gridx = 1;
		gbc_textNamTN.gridy = 6;
		contentPane.add(textNamTN, gbc_textNamTN);
		textNamTN.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textNamTN.setColumns(20);
		textNamTN.setBorder(null);
		
		GridBagConstraints gbc_labelHoKhau = new GridBagConstraints();
		gbc_labelHoKhau.anchor = GridBagConstraints.EAST;
		gbc_labelHoKhau.fill = GridBagConstraints.VERTICAL;
		gbc_labelHoKhau.insets = new Insets(0, 0, 0, 0);
		gbc_labelHoKhau.gridx = 0;
		gbc_labelHoKhau.gridy = 7;
		contentPane.add(labelHoKhau, gbc_labelHoKhau);
		labelHoKhau.setFont(new Font("Times New Roman", Font.BOLD, 20));
		labelHoKhau.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_textHoKhau = new GridBagConstraints();
		gbc_textHoKhau.fill = GridBagConstraints.HORIZONTAL;
		gbc_textHoKhau.insets = new Insets(0, 10, 0, 0);
		gbc_textHoKhau.gridwidth = 4;
		gbc_textHoKhau.gridx = 1;
		gbc_textHoKhau.gridy = 7;
		contentPane.add(textHoKhau, gbc_textHoKhau);
		textHoKhau.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textHoKhau.setColumns(20);
		textHoKhau.setBorder(null);
		
		GridBagConstraints gbc_labelDiaChi = new GridBagConstraints();
		gbc_labelDiaChi.anchor = GridBagConstraints.EAST;
		gbc_labelDiaChi.fill = GridBagConstraints.VERTICAL;
		gbc_labelDiaChi.insets = new Insets(0, 0, 0, 0);
		gbc_labelDiaChi.gridx = 0;
		gbc_labelDiaChi.gridy = 8;
		contentPane.add(labelDiaChi, gbc_labelDiaChi);
		labelDiaChi.setFont(new Font("Times New Roman", Font.BOLD, 20));
		labelDiaChi.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_textDiaChi = new GridBagConstraints();
		gbc_textDiaChi.fill = GridBagConstraints.HORIZONTAL;
		gbc_textDiaChi.insets = new Insets(0, 10, 0, 0);
		gbc_textDiaChi.gridwidth = 4;
		gbc_textDiaChi.gridx = 1;
		gbc_textDiaChi.gridy = 8;
		contentPane.add(textDiaChi, gbc_textDiaChi);
		textDiaChi.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textDiaChi.setColumns(20);
		textDiaChi.setBorder(null);
		
		GridBagConstraints gbc_labelTruong = new GridBagConstraints();
		gbc_labelTruong.anchor = GridBagConstraints.EAST;
		gbc_labelTruong.fill = GridBagConstraints.VERTICAL;
		gbc_labelTruong.insets = new Insets(0, 0, 0, 0);
		gbc_labelTruong.gridx = 3;
		gbc_labelTruong.gridy = 1;
		contentPane.add(labelTruong, gbc_labelTruong);
		labelTruong.setFont(new Font("Times New Roman", Font.BOLD, 20));
		labelTruong.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_textTruong = new GridBagConstraints();
		gbc_textTruong.fill = GridBagConstraints.HORIZONTAL;
		gbc_textTruong.insets = new Insets(0, 10, 0, 0);
		gbc_textTruong.gridx = 4;
		gbc_textTruong.gridy = 1;
		contentPane.add(textTruong, gbc_textTruong);
		textTruong.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textTruong.setColumns(20);
		textTruong.setBorder(null);
		
		GridBagConstraints gbc_labelNganh = new GridBagConstraints();
		gbc_labelNganh.anchor = GridBagConstraints.EAST;
		gbc_labelNganh.fill = GridBagConstraints.VERTICAL;
		gbc_labelNganh.insets = new Insets(0, 0, 0, 0);
		gbc_labelNganh.gridx = 3;
		gbc_labelNganh.gridy = 2;
		contentPane.add(labelNganh, gbc_labelNganh);
		labelNganh.setFont(new Font("Times New Roman", Font.BOLD, 20));
		labelNganh.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_textNganh = new GridBagConstraints();
		gbc_textNganh.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNganh.insets = new Insets(0, 10, 0, 0);
		gbc_textNganh.gridx = 4;
		gbc_textNganh.gridy = 2;
		contentPane.add(textNganh, gbc_textNganh);
		textNganh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textNganh.setColumns(20);
		textNganh.setBorder(null);
		
		GridBagConstraints gbc_labelNoiSinh = new GridBagConstraints();
		gbc_labelNoiSinh.anchor = GridBagConstraints.EAST;
		gbc_labelNoiSinh.fill = GridBagConstraints.VERTICAL;
		gbc_labelNoiSinh.insets = new Insets(0, 0, 0, 0);
		gbc_labelNoiSinh.gridx = 3;
		gbc_labelNoiSinh.gridy = 3;
		contentPane.add(labelNoiSinh, gbc_labelNoiSinh);
		labelNoiSinh.setFont(new Font("Times New Roman", Font.BOLD, 20));
		labelNoiSinh.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_textNoiSinh = new GridBagConstraints();
		gbc_textNoiSinh.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNoiSinh.insets = new Insets(0, 10, 0, 0);
		gbc_textNoiSinh.gridx = 4;
		gbc_textNoiSinh.gridy = 3;
		contentPane.add(textNoiSinh, gbc_textNoiSinh);
		textNoiSinh.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textNoiSinh.setColumns(20);
		textNoiSinh.setBorder(null);
		
		GridBagConstraints gbc_labelHeTH = new GridBagConstraints();
		gbc_labelHeTH.anchor = GridBagConstraints.EAST;
		gbc_labelHeTH.fill = GridBagConstraints.VERTICAL;
		gbc_labelHeTH.insets = new Insets(0, 0, 0, 0);
		gbc_labelHeTH.gridx = 3;
		gbc_labelHeTH.gridy = 4;
		contentPane.add(labelHeTH, gbc_labelHeTH);
		labelHeTH.setFont(new Font("Times New Roman", Font.BOLD, 20));
		labelHeTH.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_textHeTH = new GridBagConstraints();
		gbc_textHeTH.fill = GridBagConstraints.HORIZONTAL;
		gbc_textHeTH.insets = new Insets(0, 10, 0, 0);
		gbc_textHeTH.gridx = 4;
		gbc_textHeTH.gridy = 4;
		contentPane.add(textHeTH, gbc_textHeTH);
		textHeTH.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textHeTH.setColumns(20);
		textHeTH.setBorder(null);
		
		GridBagConstraints gbc_labelDoiTuong = new GridBagConstraints();
		gbc_labelDoiTuong.anchor = GridBagConstraints.EAST;
		gbc_labelDoiTuong.fill = GridBagConstraints.VERTICAL;
		gbc_labelDoiTuong.insets = new Insets(0, 0, 0, 0);
		gbc_labelDoiTuong.gridx = 3;
		gbc_labelDoiTuong.gridy = 5;
		contentPane.add(labelDoiTuong, gbc_labelDoiTuong);
		labelDoiTuong.setFont(new Font("Times New Roman", Font.BOLD, 20));
		labelDoiTuong.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_textDoiTuong = new GridBagConstraints();
		gbc_textDoiTuong.fill = GridBagConstraints.HORIZONTAL;
		gbc_textDoiTuong.insets = new Insets(0, 10, 0, 0);
		gbc_textDoiTuong.gridx = 4;
		gbc_textDoiTuong.gridy = 5;
		contentPane.add(textDoiTuong, gbc_textDoiTuong);
		textDoiTuong.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textDoiTuong.setColumns(20);
		textDoiTuong.setBorder(null);
		
		GridBagConstraints gbc_labelButtonDK = new GridBagConstraints();
		gbc_labelButtonDK.fill = GridBagConstraints.BOTH;
		gbc_labelButtonDK.insets = new Insets(0, 50, 0, 0);
		gbc_labelButtonDK.gridx = 1;
		gbc_labelButtonDK.gridy = 10;
		contentPane.add(buttonDK, gbc_labelButtonDK);
		buttonDK.setFont(new Font("Times New Roman", Font.BOLD, 20));
		buttonDK.setForeground(Color.BLACK);
		buttonDK.setFocusPainted(false);
		buttonDK.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				buttonDK.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				try {
					Connection connection = null;
					PreparedStatement info = null;
					ResultSet rs = null;
					
					if(textHoTen.getText().equals("") || textNgaySinh.getText().equals("") || textNoiSinh.getText().equals("") || textHoKhau.getText().equals("")
							|| textKhuVuc.getText().equals("") || textNamTN.getText().equals("") || textHeTH.getText().equals("") || textDiaChi.getText().equals("")
							|| textKhoi.getText().equals("") || textTruong.getText().equals("") || textNganh.getText().equals("") || textDoiTuong.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin để đăng ký!   ", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
	                }
					else {
						String connectionURL = "jdbc:sqlserver://LAPTOP-87JFGLT1:1433;databaseName=QUAN_LY_TUYEN_SINH;integratedSecurity=true;";
						connection = DriverManager.getConnection(connectionURL);
						info = connection.prepareStatement("Insert into THISINH (Hoten, NgaySinh, NoiSinh, HoKhau, KhuVuc, NamTN, HeTH, DiaChiBaoTin, MatKhau) values (?, ?, ?, ?, ?, ?, ?, ?, ?)");
						info.setString(1, textHoTen.getText());
	                    info.setString(2, textNgaySinh.getText());
	                    info.setString(3, textNoiSinh.getText());
	                    info.setString(4, textHoKhau.getText());
	                    info.setString(5, textKhuVuc.getText());
	                    info.setString(6, textNamTN.getText());
	                    info.setString(7, textHeTH.getText());
	                    info.setString(8, textDiaChi.getText());
	                    info.setString(9, "123456");
	                    info.executeUpdate();
	                    
						info = connection.prepareStatement("Insert into PHIEUDUTHI (Khoi, MaTruong, MaNganh, MaDT) values (?, ?, ?, ?)");
						info.setString(1, textKhoi.getText());
	                    info.setString(2, textTruong.getText());
	                    info.setString(3, textNganh.getText());
	                    info.setString(4, textDoiTuong.getText());
	                    info.executeUpdate();
	                    
	                    PreparedStatement info1 = null;
	                    PreparedStatement info2 = null;
	                    ResultSet rs1 = null;
	        
	                    info1 = connection.prepareStatement("Select TOP 1 IDThiSinh from THISINH order by IDThiSinh DESC");
	                    rs1 = info1.executeQuery();
						while(rs1.next()) {
							info2 = connection.prepareStatement("Insert into PHIEUBAOTHI (IDThiSinh) values (?)");
		                    info2.setString(1, rs1.getString("IDThiSinh"));
		                    info2.executeUpdate();
						}
	                    
						textKhoi.setText("");
						textHoTen.setText("");
						textNgaySinh.setText("");
						textKhuVuc.setText("");
						textNamTN.setText("");
						textHoKhau.setText("");
						textDiaChi.setText("");
						textTruong.setText("");
						textNganh.setText("");
						textNoiSinh.setText("");
						textHeTH.setText("");
						textDoiTuong.setText("");
						setVisible(false);
						info = connection.prepareStatement("Select TOP 1 IDThiSinh, MatKhau from THISINH order by IDThiSinh	DESC");
						rs = info.executeQuery();
						while(rs.next()) {
							JOptionPane.showMessageDialog(null, "Đăng ký tài khoản thành công!  \n"
									+ "\nThí sinh vui lòng đăng nhập bằng tài khoản sau  "
									+ "\nTên tài khoản: " + rs.getString("IDThiSinh")
									+ "\nMật khẩu: " + rs.getString("MatKhau"));
						}
						connection.close();
			            rs.close();
			            rs1.close();
			            info.close();
			            info1.close();
			            info2.close();
					} 
				}catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Đăng ký không thành công!   \n", "Thông báo", JOptionPane.ERROR_MESSAGE);
					System.out.println("error: " + e1);
				}
			}
		});
		
		GridBagConstraints gbc_labelButtonBack = new GridBagConstraints();
		gbc_labelButtonBack.fill = GridBagConstraints.BOTH;
		gbc_labelButtonBack.insets = new Insets(0, 0, 0, 0);
		gbc_labelButtonBack.gridx = 3;
		gbc_labelButtonBack.gridy = 10;
		contentPane.add(buttonBack, gbc_labelButtonBack);
		buttonBack.setFont(new Font("Times New Roman", Font.BOLD, 20));
		buttonBack.setForeground(Color.BLACK);
		buttonBack.setFocusPainted(false);
		buttonBack.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				buttonBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				textSoPhieu.setText("");
				textKhoi.setText("");
				textHoTen.setText("");
				textNgaySinh.setText("");
				textKhuVuc.setText("");
				textNamTN.setText("");
				textHoKhau.setText("");
				textDiaChi.setText("");
				textTruong.setText("");
				textNganh.setText("");
				textNoiSinh.setText("");
				textHeTH.setText("");
				textDoiTuong.setText("");
				setVisible(false);
			}
		});
	}

}
