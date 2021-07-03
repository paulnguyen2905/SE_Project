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

public class panelXemDiem extends JPanel {
	private final JLabel labelHoTen = new JLabel("Họ tên: ");
	private final JLabel textHoTen = new JLabel("");
	private final JLabel labelNgaySinh = new JLabel("Ngày sinh:");
	private final JLabel textNgaySinh = new JLabel("");
	private final JLabel labelDiaChi = new JLabel("Địa chỉ báo tin:");
	private final JLabel textDiaChi = new JLabel("");
	private final JLabel labelDiem1 = new JLabel("Điểm môn 1:");
	private final JLabel textDiem1 = new JLabel("");
	private final JLabel labelDiem2 = new JLabel("Điểm môn 2:");
	private final JLabel textDiem2 = new JLabel("");
	private final JLabel labelDiem3 = new JLabel("Điểm môn 3:");
	private final JLabel textDiem3 = new JLabel("");
	private final JLabel labelNoiSinh = new JLabel("Nơi sinh:");
	private final JLabel textNoiSinh = new JLabel("");
	private final JLabel labelSBD = new JLabel("Số báo danh:");
	private final JLabel textSBD = new JLabel("");
	private final JLabel labelTongDiem = new JLabel("Tổng điểm:");
	private final JLabel textTongDiem = new JLabel("");
	private final JLabel labelKetQua = new JLabel("Trúng tuyển:");
	private final JLabel textKetQua = new JLabel("");
	
	public static JLabel textIDNow = new JLabel("");

	public panelXemDiem() {
		initGUI();
	}
	
	private void initGUI() {
		setBackground(new Color(200, 255, 255));
		setBounds(0, 0, 900, 500);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{220, 90, 170, 90, 160, 170};
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
		gbc_textHoTen.gridwidth = 3;
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
		gbc_textNgaySinh.gridwidth = 3;
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
		gbc_textDiaChi.gridwidth = 5;
		gbc_textDiaChi.gridx = 1;
		gbc_textDiaChi.gridy = 3;
		add(textDiaChi, gbc_textDiaChi);
		textDiaChi.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textDiaChi.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_labelDiem1 = new GridBagConstraints();
		gbc_labelDiem1.anchor = GridBagConstraints.EAST;
		gbc_labelDiem1.insets = new Insets(0, 0, 0, 0);
		gbc_labelDiem1.gridx = 0;
		gbc_labelDiem1.gridy = 4;
		add(labelDiem1, gbc_labelDiem1);
		labelDiem1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		labelDiem1.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_textDiem1 = new GridBagConstraints();
		gbc_textDiem1.anchor = GridBagConstraints.WEST;
		gbc_textDiem1.insets = new Insets(0, 10, 0, 0);
		gbc_textDiem1.gridx = 1;
		gbc_textDiem1.gridy = 4;
		add(textDiem1, gbc_textDiem1);
		textDiem1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textDiem1.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_labelDiem2 = new GridBagConstraints();
		gbc_labelDiem2.anchor = GridBagConstraints.EAST;
		gbc_labelDiem2.insets = new Insets(0, 0, 0, 0);
		gbc_labelDiem2.gridx = 2;
		gbc_labelDiem2.gridy = 4;
		add(labelDiem2, gbc_labelDiem2);
		labelDiem2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		labelDiem2.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_textDiem2 = new GridBagConstraints();
		gbc_textDiem2.anchor = GridBagConstraints.WEST;
		gbc_textDiem2.insets = new Insets(0, 10, 0, 0);
		gbc_textDiem2.gridx = 3;
		gbc_textDiem2.gridy = 4;
		add(textDiem2, gbc_textDiem2);
		textDiem2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textDiem2.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_labelDiem3 = new GridBagConstraints();
		gbc_labelDiem3.anchor = GridBagConstraints.EAST;
		gbc_labelDiem3.insets = new Insets(0, 0, 0, 0);
		gbc_labelDiem3.gridx = 4;
		gbc_labelDiem3.gridy = 4;
		add(labelDiem3, gbc_labelDiem3);
		labelDiem3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		labelDiem3.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_textDiem3 = new GridBagConstraints();
		gbc_textDiem3.anchor = GridBagConstraints.WEST;
		gbc_textDiem3.insets = new Insets(0, 10, 0, 0);
		gbc_textDiem3.gridx = 5;
		gbc_textDiem3.gridy = 4;
		add(textDiem3, gbc_textDiem3);
		textDiem3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textDiem3.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_labelTongDiem = new GridBagConstraints();
		gbc_labelTongDiem.anchor = GridBagConstraints.EAST;
		gbc_labelTongDiem.insets = new Insets(0, 0, 0, 0);
		gbc_labelTongDiem.gridx = 0;
		gbc_labelTongDiem.gridy = 5;
		add(labelTongDiem, gbc_labelTongDiem);
		labelTongDiem.setFont(new Font("Times New Roman", Font.BOLD, 20));
		labelTongDiem.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_textTongDiem = new GridBagConstraints();
		gbc_textTongDiem.anchor = GridBagConstraints.WEST;
		gbc_textTongDiem.insets = new Insets(0, 10, 0, 0);
		gbc_textTongDiem.gridx = 1;
		gbc_textTongDiem.gridy = 5;
		add(textTongDiem, gbc_textTongDiem);
		textTongDiem.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textTongDiem.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_labelNoiSinh = new GridBagConstraints();
		gbc_labelNoiSinh.anchor = GridBagConstraints.EAST;
		gbc_labelNoiSinh.insets = new Insets(0, 0, 0, 0);
		gbc_labelNoiSinh.gridx = 4;
		gbc_labelNoiSinh.gridy = 1;
		add(labelNoiSinh, gbc_labelNoiSinh);
		labelNoiSinh.setFont(new Font("Times New Roman", Font.BOLD, 20));
		labelNoiSinh.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_textNoiSinh = new GridBagConstraints();
		gbc_textNoiSinh.anchor = GridBagConstraints.WEST;
		gbc_textNoiSinh.insets = new Insets(0, 10, 0, 0);
		gbc_textNoiSinh.gridx = 5;
		gbc_textNoiSinh.gridy = 1;
		add(textNoiSinh, gbc_textNoiSinh);
		textNoiSinh.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textNoiSinh.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_labelSBD = new GridBagConstraints();
		gbc_labelSBD.anchor = GridBagConstraints.EAST;
		gbc_labelSBD.insets = new Insets(0, 0, 0, 0);
		gbc_labelSBD.gridx = 4;
		gbc_labelSBD.gridy = 2;
		add(labelSBD, gbc_labelSBD);
		labelSBD.setFont(new Font("Times New Roman", Font.BOLD, 20));
		labelSBD.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_textSBD = new GridBagConstraints();
		gbc_textSBD.anchor = GridBagConstraints.WEST;
		gbc_textSBD.insets = new Insets(0, 10, 0, 0);
		gbc_textSBD.gridx = 5;
		gbc_textSBD.gridy = 2;
		add(textSBD, gbc_textSBD);
		textSBD.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textKetQua.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_labelKetQua = new GridBagConstraints();
		gbc_labelKetQua.anchor = GridBagConstraints.EAST;
		gbc_labelKetQua.insets = new Insets(0, 0, 0, 0);
		gbc_labelKetQua.gridx = 4;
		gbc_labelKetQua.gridy = 5;
		add(labelKetQua, gbc_labelKetQua);
		labelKetQua.setFont(new Font("Times New Roman", Font.BOLD, 20));
		labelKetQua.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_textKetQua = new GridBagConstraints();
		gbc_textKetQua.anchor = GridBagConstraints.WEST;
		gbc_textKetQua.insets = new Insets(0, 10, 0, 0);
		gbc_textKetQua.gridx = 5;
		gbc_textKetQua.gridy = 5;
		add(textKetQua, gbc_textKetQua);
		textKetQua.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textKetQua.setForeground(Color.BLACK);

	}

	public void updateInfo() {
		try {
			Connection connection = null;
			PreparedStatement info = null;
			ResultSet rs = null;
				
			String connectionURL = "jdbc:sqlserver://LAPTOP-87JFGLT1:1433;databaseName=QUAN_LY_TUYEN_SINH;integratedSecurity=true;";
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
			connection = DriverManager.getConnection(connectionURL);
			info = connection.prepareStatement("Select SBD from PHIEUBAOTHI where IDThiSinh=?");
			info.setString(1, textIDNow.getText());
			rs = info.executeQuery();
			while(rs.next()) {
				textSBD.setText(rs.getString("SBD"));
			}
				
			info = connection.prepareStatement("Select HoTen, NgaySinh, NoiSinh, DiaChiBaoTin from THISINH where IDThiSinh=?");
			info.setString(1, textIDNow.getText());
			rs = info.executeQuery();
			while(rs.next()) {
				String strDate = formatter.format(rs.getDate("NgaySinh")); 
				textHoTen.setText(rs.getNString("HoTen"));
				textNgaySinh.setText(strDate);
				textNoiSinh.setText(rs.getNString("NoiSinh"));
				textDiaChi.setText(rs.getNString("DiaChiBaoTin"));
			}
			
			info = connection.prepareStatement("Select Diem1, Diem2, Diem3 from GANPHACH where IDThiSinh=?");
			info.setString(1, textIDNow.getText());
			rs = info.executeQuery();
			while(rs.next()) {
				textDiem1.setText(rs.getString("Diem1"));
				textDiem2.setText(rs.getString("Diem2"));
				textDiem3.setText(rs.getString("Diem3"));
				float sum = rs.getFloat("Diem1") + rs.getFloat("Diem2") + rs.getFloat("Diem3");
				textTongDiem.setText(Float.toString(sum));
				if (sum > 24)
					textKetQua.setText("Đậu");
				else
					textKetQua.setText("Không đậu");
			}
			
			connection.close();
	        rs.close();
	        info.close();
	        if(textHoTen.getText().equals("") || textNgaySinh.getText().equals("") || textNoiSinh.getText().equals("") || textDiaChi.getText().equals("")
	        		|| textSBD.getText().equals("") || textDiem1.getText().equals("") || textDiem2.getText().equals("") || textDiem3.getText().equals("")) {
	        	JOptionPane.showMessageDialog(null, "Thông tin của bạn hiện tại chưa được cập nhật đầy đủ, \nVui lòng quay lại sau.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		    }
		} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "Thông tin của bạn hiện tại chưa được cập nhật đầy đủ, \nVui lòng quay lại sau.", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		System.out.println("error: " + e);
		}
	}
}
