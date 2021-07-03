import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class panelPhieuThiUser extends JPanel {
	private final JLabel labelHoTen = new JLabel("Họ tên: ");
	private final JLabel textHoTen = new JLabel("");
	private final JLabel labelNgaySinh = new JLabel("Ngày sinh:");
	private final JLabel textNgaySinh = new JLabel("");
	private final JLabel labelDiaChi = new JLabel("Địa chỉ báo tin:");
	private final JLabel textDiaChi = new JLabel("");
	private final JLabel labelDiaDiem = new JLabel("Địa điểm thi:");
	private final JLabel textDiaDiem = new JLabel("");
	private final JLabel labelNgayThi = new JLabel("Ngày thi:");
	private final JLabel textNgayThi = new JLabel("");
	private final JLabel labelNoiSinh = new JLabel("Nơi sinh:");
	private final JLabel textNoiSinh = new JLabel("");
	private final JLabel labelSBD = new JLabel("Số báo danh:");
	private final JLabel textSBD = new JLabel("");
	private final JLabel labelSoPhong = new JLabel("Số phòng thi:");
	private final JLabel textSoPhong = new JLabel("");
	private final JLabel labelLePhi = new JLabel("Lệ phí thi:");
	private final JLabel textLePhi = new JLabel("");
	
	public static JLabel textIDNow = new JLabel("");

	public panelPhieuThiUser() {
		initGUI();
	}
	
	private void initGUI() {
		setBackground(new Color(200, 255, 255));
		setBounds(0, 0, 900, 500);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{220, 290, 50, 160, 180};
		gridBagLayout.rowHeights = new int[]{100, 40, 40, 40, 40, 40, 40, 40, 120};
		gridBagLayout.columnWeights = new double[]{};
		gridBagLayout.rowWeights = new double[]{};
		setLayout(gridBagLayout);
		
		GridBagConstraints gbc_labelHoTen = new GridBagConstraints();
		gbc_labelHoTen.anchor = GridBagConstraints.EAST;
		gbc_labelHoTen.insets = new Insets(0, 0, 0, 0);
		gbc_labelHoTen.gridx = 0;
		gbc_labelHoTen.gridy = 1;
		add(labelHoTen, gbc_labelHoTen);
		labelHoTen.setFont(new Font("Times New Roman", Font.BOLD, 20));
		labelHoTen.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_textHoTen = new GridBagConstraints();
		gbc_textHoTen.anchor = GridBagConstraints.WEST;
		gbc_textHoTen.insets = new Insets(0, 10, 0, 0);
		gbc_textHoTen.gridx = 1;
		gbc_textHoTen.gridy = 1;
		add(textHoTen, gbc_textHoTen);
		textHoTen.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textHoTen.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_labelNgaySinh = new GridBagConstraints();
		gbc_labelNgaySinh.anchor = GridBagConstraints.EAST;
		gbc_labelNgaySinh.insets = new Insets(0, 0, 0, 0);
		gbc_labelNgaySinh.gridx = 0;
		gbc_labelNgaySinh.gridy = 2;
		add(labelNgaySinh, gbc_labelNgaySinh);
		labelNgaySinh.setFont(new Font("Times New Roman", Font.BOLD, 20));
		labelNgaySinh.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_textNgaySinh = new GridBagConstraints();
		gbc_textNgaySinh.anchor = GridBagConstraints.WEST;
		gbc_textNgaySinh.insets = new Insets(0, 10, 0, 0);
		gbc_textNgaySinh.gridx = 1;
		gbc_textNgaySinh.gridy = 2;
		add(textNgaySinh, gbc_textNgaySinh);
		textNgaySinh.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textNgaySinh.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_labelDiaChi = new GridBagConstraints();
		gbc_labelDiaChi.anchor = GridBagConstraints.EAST;
		gbc_labelDiaChi.insets = new Insets(0, 0, 0, 0);
		gbc_labelDiaChi.gridx = 0;
		gbc_labelDiaChi.gridy = 3;
		add(labelDiaChi, gbc_labelDiaChi);
		labelDiaChi.setFont(new Font("Times New Roman", Font.BOLD, 20));
		labelDiaChi.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_textDiaChi = new GridBagConstraints();
		gbc_textDiaChi.anchor = GridBagConstraints.WEST;
		gbc_textDiaChi.insets = new Insets(0, 10, 0, 0);
		gbc_textDiaChi.gridwidth = 4;
		gbc_textDiaChi.gridx = 1;
		gbc_textDiaChi.gridy = 3;
		add(textDiaChi, gbc_textDiaChi);
		textDiaChi.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textDiaChi.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_labelDiaDiem = new GridBagConstraints();
		gbc_labelDiaDiem.anchor = GridBagConstraints.EAST;
		gbc_labelDiaDiem.insets = new Insets(0, 0, 0, 0);
		gbc_labelDiaDiem.gridx = 0;
		gbc_labelDiaDiem.gridy = 4;
		add(labelDiaDiem, gbc_labelDiaDiem);
		labelDiaDiem.setFont(new Font("Times New Roman", Font.BOLD, 20));
		labelDiaDiem.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_textDiaDiem = new GridBagConstraints();
		gbc_textDiaDiem.anchor = GridBagConstraints.WEST;
		gbc_textDiaDiem.insets = new Insets(0, 10, 0, 0);
		gbc_textDiaDiem.gridx = 1;
		gbc_textDiaDiem.gridy = 4;
		add(textDiaDiem, gbc_textDiaDiem);
		textDiaDiem.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textDiaDiem.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_labelNgayThi = new GridBagConstraints();
		gbc_labelNgayThi.anchor = GridBagConstraints.EAST;
		gbc_labelNgayThi.insets = new Insets(0, 0, 0, 0);
		gbc_labelNgayThi.gridx = 0;
		gbc_labelNgayThi.gridy = 5;
		add(labelNgayThi, gbc_labelNgayThi);
		labelNgayThi.setFont(new Font("Times New Roman", Font.BOLD, 20));
		labelNgayThi.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_textNgayThi = new GridBagConstraints();
		gbc_textNgayThi.anchor = GridBagConstraints.WEST;
		gbc_textNgayThi.insets = new Insets(0, 10, 0, 0);
		gbc_textNgayThi.gridx = 1;
		gbc_textNgayThi.gridy = 5;
		add(textNgayThi, gbc_textNgayThi);
		textNgayThi.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textNgayThi.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_labelNoiSinh = new GridBagConstraints();
		gbc_labelNoiSinh.anchor = GridBagConstraints.EAST;
		gbc_labelNoiSinh.insets = new Insets(0, 0, 0, 0);
		gbc_labelNoiSinh.gridx = 3;
		gbc_labelNoiSinh.gridy = 1;
		add(labelNoiSinh, gbc_labelNoiSinh);
		labelNoiSinh.setFont(new Font("Times New Roman", Font.BOLD, 20));
		labelNoiSinh.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_textNoiSinh = new GridBagConstraints();
		gbc_textNoiSinh.anchor = GridBagConstraints.WEST;
		gbc_textNoiSinh.insets = new Insets(0, 10, 0, 0);
		gbc_textNoiSinh.gridx = 4;
		gbc_textNoiSinh.gridy = 1;
		add(textNoiSinh, gbc_textNoiSinh);
		textNoiSinh.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textNoiSinh.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_labelSBD = new GridBagConstraints();
		gbc_labelSBD.anchor = GridBagConstraints.EAST;
		gbc_labelSBD.insets = new Insets(0, 0, 0, 0);
		gbc_labelSBD.gridx = 3;
		gbc_labelSBD.gridy = 2;
		add(labelSBD, gbc_labelSBD);
		labelSBD.setFont(new Font("Times New Roman", Font.BOLD, 20));
		labelSBD.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_textSBD = new GridBagConstraints();
		gbc_textSBD.anchor = GridBagConstraints.WEST;
		gbc_textSBD.insets = new Insets(0, 10, 0, 0);
		gbc_textSBD.gridx = 4;
		gbc_textSBD.gridy = 2;
		add(textSBD, gbc_textSBD);
		textSBD.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textSBD.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_labelSoPhong = new GridBagConstraints();
		gbc_labelSoPhong.anchor = GridBagConstraints.EAST;
		gbc_labelSoPhong.insets = new Insets(0, 0, 0, 0);
		gbc_labelSoPhong.gridx = 3;
		gbc_labelSoPhong.gridy = 4;
		add(labelSoPhong, gbc_labelSoPhong);
		labelSoPhong.setFont(new Font("Times New Roman", Font.BOLD, 20));
		labelSoPhong.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_textSoPhong = new GridBagConstraints();
		gbc_textSoPhong.anchor = GridBagConstraints.WEST;
		gbc_textSoPhong.insets = new Insets(0, 10, 0, 0);
		gbc_textSoPhong.gridx = 4;
		gbc_textSoPhong.gridy = 4;
		add(textSoPhong, gbc_textSoPhong);
		textSoPhong.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textSoPhong.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_labelLePhi = new GridBagConstraints();
		gbc_labelLePhi.anchor = GridBagConstraints.EAST;
		gbc_labelLePhi.insets = new Insets(0, 0, 0, 0);
		gbc_labelLePhi.gridx = 3;
		gbc_labelLePhi.gridy = 5;
		add(labelLePhi, gbc_labelLePhi);
		labelLePhi.setFont(new Font("Times New Roman", Font.BOLD, 20));
		labelLePhi.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_textLePhi = new GridBagConstraints();
		gbc_textLePhi.anchor = GridBagConstraints.WEST;
		gbc_textLePhi.insets = new Insets(0, 10, 0, 0);
		gbc_textLePhi.gridx = 4;
		gbc_textLePhi.gridy = 5;
		add(textLePhi, gbc_textLePhi);
		textLePhi.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textLePhi.setForeground(Color.BLACK);
	}
	
	public void updateInfo() {
		try {
			Connection connection = null;
			PreparedStatement info = null;
			ResultSet rs = null;
				
			String connectionURL = "jdbc:sqlserver://LAPTOP-87JFGLT1:1433;databaseName=QUAN_LY_TUYEN_SINH;integratedSecurity=true;";
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			connection = DriverManager.getConnection(connectionURL);
				
			info = connection.prepareStatement("Select HoTen, NgaySinh, NoiSinh, DiaChiBaoTin from THISINH where IDThiSinh=?");
			info.setString(1, textIDNow.getText());
			rs = info.executeQuery();
			while(rs.next()) {
				textHoTen.setText(rs.getNString("HoTen"));
				textNgaySinh.setText(formatter.format(rs.getDate("NgaySinh")));
				textNoiSinh.setText(rs.getNString("NoiSinh"));
				textDiaChi.setText(rs.getNString("DiaChiBaoTin"));
			}
			
			info = connection.prepareStatement("Select DiaDiem, NgayThi, SBD, SoPhong, LePhi from PHIEUBAOTHI where IDThiSinh=?");
			info.setString(1, textIDNow.getText());
			rs = info.executeQuery();
			while(rs.next()) {
				textDiaDiem.setText(rs.getNString("DiaDiem"));
				textNgayThi.setText(formatter.format(rs.getDate("NgayThi")));
				textSBD.setText(rs.getString("SBD"));
				textSoPhong.setText(rs.getString("SoPhong"));
				textLePhi.setText(rs.getString("LePhi"));
			}
				
			connection.close();
	        rs.close();
	        info.close();
	        
	        if(textHoTen.getText().equals("") || textNgaySinh.getText().equals("") || textNoiSinh.getText().equals("") || textDiaChi.getText().equals("")
					|| textDiaDiem.getText().equals("") || textNgayThi.getText().equals("") || textSBD.getText().equals("") || textSoPhong.getText().equals("") || textLePhi.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Thông tin của bạn hiện tại chưa được cập nhật đầy đủ, \nVui lòng quay lại sau.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
	        }
		} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "Thông tin của bạn hiện tại chưa được cập nhật đầy đủ, \nVui lòng quay lại sau.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		System.out.println("error: " + e);
		}
		
		
	}
	
}
