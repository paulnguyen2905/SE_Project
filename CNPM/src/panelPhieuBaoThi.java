import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class panelPhieuBaoThi extends JPanel {
	private final JLabel labelID = new JLabel("ID thí sinh:");
	private final JLabel textID = new JLabel("");
	private final JLabel labelSBD = new JLabel("Số báo danh:");
	private final JLabel labelDiaDiem = new JLabel("Địa điểm thi:");
	private final JLabel labelSoPhong = new JLabel("Số phòng thi:");
	private final JLabel labelNgayThi = new JLabel("Ngày thi:");
	private final JLabel labelLePhi = new JLabel("Lệ phí thi:");
	
	private final JTextField textSBD = new JTextField();
	private final JTextField textDiaDiem = new JTextField();
	private final JTextField textSoPhong = new JTextField();
	private final JTextField textNgayThi = new JTextField();
	private final JTextField textLePhi = new JTextField();
	private final JButton buttonAdd = new JButton("   Thêm   ");
	private final JButton buttonReset = new JButton("  Reset  ");
	private final JButton buttonDel = new JButton("   Xóa    ");
	private final JButton buttonEdit = new JButton(" Thay đổi");
	
	private final JTable table = new JTable();
	private final JScrollPane scrollPane = new JScrollPane();

	public panelPhieuBaoThi() {
		initGUI();
		showData();
	}
	
	private void initGUI() {
		setBackground(new Color(200, 255, 255));
		setBounds(0, 0, 900, 500);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{140, 230, 20, 500, 10};
		gridBagLayout.rowHeights = new int[]{80, 40, 40, 40, 40, 40, 40, 5, 40, 110};
		gridBagLayout.columnWeights = new double[]{};
		gridBagLayout.rowWeights = new double[]{};
		setLayout(gridBagLayout);
		
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(10, 0, 0, 0);
		gbc_scrollPane.gridheight = 9;
		gbc_scrollPane.gridx = 3;
		gbc_scrollPane.gridy = 0;
		add(scrollPane, gbc_scrollPane);
		scrollPane.setViewportView(table);
		table.setDefaultEditor(Object.class, null);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				TableModel model = table.getModel();
				
				if (model.getValueAt(i, 0) == null)
					textID.setText("");
				else textID.setText(model.getValueAt(i, 0).toString());
				
				if (model.getValueAt(i, 1) == null)
					textSBD.setText("");
				else textSBD.setText(model.getValueAt(i, 1).toString());
				
				if (model.getValueAt(i, 2)== null)
					textDiaDiem.setText("");
				else textDiaDiem.setText(model.getValueAt(i, 2).toString());
				
				if (model.getValueAt(i, 3)== null)
					textNgayThi.setText("");
				else textNgayThi.setText(model.getValueAt(i, 3).toString());
				
				if (model.getValueAt(i, 4) == null)
					textSoPhong.setText("");
				else textSoPhong.setText(model.getValueAt(i, 4).toString());
				
				if (model.getValueAt(i, 5) == null)
					textLePhi.setText("");
				else textLePhi.setText(model.getValueAt(i, 5).toString());
			}
		});
		
		GridBagConstraints gbc_buttonAdd = new GridBagConstraints();
		gbc_buttonAdd.anchor = GridBagConstraints.WEST;
		gbc_buttonAdd.insets = new Insets(0, 8, 0, 0);
		gbc_buttonAdd.gridheight = 2;
		gbc_buttonAdd.gridx = 1;
		gbc_buttonAdd.gridy = 6;
		add(buttonAdd, gbc_buttonAdd);
		buttonAdd.setBounds(0, 0, 0, 80);
		buttonAdd.setFont(new Font("Times New Roman", Font.BOLD, 20));
		buttonAdd.setForeground(Color.BLACK);
		buttonAdd.setFocusPainted(false);
		buttonAdd.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				buttonAdd.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Không thể thêm thông tin thí sinh! ", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		GridBagConstraints gbc_buttonEdit = new GridBagConstraints();
		gbc_buttonEdit.anchor = GridBagConstraints.WEST;
		gbc_buttonEdit.insets = new Insets(0, 8, 0, 0);
		gbc_buttonEdit.gridx = 1;
		gbc_buttonEdit.gridy = 8;
		add(buttonEdit, gbc_buttonEdit);
		buttonEdit.setFont(new Font("Times New Roman", Font.BOLD, 20));
		buttonEdit.setForeground(Color.BLACK);
		buttonEdit.setFocusPainted(false);
		buttonEdit.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				buttonEdit.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				try {
					Connection connection = null;
					PreparedStatement info = null;
					
					String ID = textID.getText();
					
					String connectionURL = "jdbc:sqlserver://LAPTOP-87JFGLT1:1433;databaseName=QUAN_LY_TUYEN_SINH;integratedSecurity=true;";
					connection = DriverManager.getConnection(connectionURL);
					info = connection.prepareStatement("Update PHIEUBAOTHI set SBD=?, DiaDiem=?, SoPhong=?, NgayThi=?, LePhi=? where IDThiSinh=?");
					info.setString(1, textSBD.getText());
                	info.setString(2, textDiaDiem.getText());
                	info.setString(3, textSoPhong.getText());
                	info.setString(4, textNgayThi.getText());
                	info.setString(5, textLePhi.getText());
                	info.setString(6, ID);
                	info.executeUpdate();
                	
                	showData();
                	
		            connection.close();
		            info.close();
				} catch (Exception E) {
		            	System.out.println("error: " + E);
				}
			}
		});
		
		GridBagConstraints gbc_buttonDel = new GridBagConstraints();
		gbc_buttonDel.anchor = GridBagConstraints.EAST;
		gbc_buttonDel.insets = new Insets(0, 0, 0, 0);
		gbc_buttonDel.gridx = 1;
		gbc_buttonDel.gridy = 8;
		add(buttonDel, gbc_buttonDel);
		buttonDel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		buttonDel.setForeground(Color.BLACK);
		buttonDel.setFocusPainted(false);
		buttonDel.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				buttonDel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Không thể xóa thông tin thí sinh! ", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		
		GridBagConstraints gbc_buttonReset = new GridBagConstraints();
		gbc_buttonReset.anchor = GridBagConstraints.EAST;
		gbc_buttonReset.insets = new Insets(0, 0, 0, 0);
		gbc_buttonReset.gridheight = 2;
		gbc_buttonReset.gridx = 1;
		gbc_buttonReset.gridy = 6;
		add(buttonReset, gbc_buttonReset);
		buttonReset.setFont(new Font("Times New Roman", Font.BOLD, 20));
		buttonReset.setForeground(Color.BLACK);
		buttonReset.setFocusPainted(false);
		buttonReset.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				buttonReset.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				textSBD.setText("");
				textDiaDiem.setText("");
				textSoPhong.setText("");
				textNgayThi.setText("");
				textLePhi.setText("");
			}
		});
		
		GridBagConstraints gbc_labelID = new GridBagConstraints();
		gbc_labelID.anchor = GridBagConstraints.SOUTHEAST;
		gbc_labelID.insets = new Insets(0, 0, 5, 0);
		gbc_labelID.gridx = 0;
		gbc_labelID.gridy = 0;
		add(labelID, gbc_labelID);
		labelID.setFont(new Font("Times New Roman", Font.BOLD, 20));
		labelID.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_textID = new GridBagConstraints();
		gbc_textID.anchor = GridBagConstraints.SOUTHWEST;
		gbc_textID.insets = new Insets(0, 10, 5, 0);
		gbc_textID.gridx = 1;
		gbc_textID.gridy = 0;
		add(textID, gbc_textID);
		textID.setFont(new Font("Times New Roman", Font.BOLD, 20));
		textID.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_labelSBD = new GridBagConstraints();
		gbc_labelSBD.anchor = GridBagConstraints.EAST;
		gbc_labelSBD.insets = new Insets(0, 0, 0, 0);
		gbc_labelSBD.gridx = 0;
		gbc_labelSBD.gridy = 1;
		add(labelSBD, gbc_labelSBD);
		labelSBD.setFont(new Font("Times New Roman", Font.BOLD, 20));
		labelSBD.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_textSBD = new GridBagConstraints();
		gbc_textSBD.fill = GridBagConstraints.HORIZONTAL;
		gbc_textSBD.insets = new Insets(0, 10, 0, 0);
		gbc_textSBD.gridx = 1;
		gbc_textSBD.gridy = 1;
		add(textSBD, gbc_textSBD);
		textSBD.setBorder(null);
		textSBD.setColumns(20);
		textSBD.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		GridBagConstraints gbc_labelDiaDiem = new GridBagConstraints();
		gbc_labelDiaDiem.anchor = GridBagConstraints.EAST;
		gbc_labelDiaDiem.insets = new Insets(0, 0, 0, 0);
		gbc_labelDiaDiem.gridx = 0;
		gbc_labelDiaDiem.gridy = 2;
		add(labelDiaDiem, gbc_labelDiaDiem);
		labelDiaDiem.setFont(new Font("Times New Roman", Font.BOLD, 20));
		labelDiaDiem.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_textDiaDiem = new GridBagConstraints();
		gbc_textDiaDiem.fill = GridBagConstraints.HORIZONTAL;
		gbc_textDiaDiem.insets = new Insets(0, 10, 0, 0);
		gbc_textDiaDiem.gridx = 1;
		gbc_textDiaDiem.gridy = 2;
		add(textDiaDiem, gbc_textDiaDiem);
		textDiaDiem.setBorder(null);
		textDiaDiem.setColumns(20);
		textDiaDiem.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		GridBagConstraints gbc_labelSoPhong = new GridBagConstraints();
		gbc_labelSoPhong.anchor = GridBagConstraints.EAST;
		gbc_labelSoPhong.insets = new Insets(0, 0, 0, 0);
		gbc_labelSoPhong.gridx = 0;
		gbc_labelSoPhong.gridy = 3;
		add(labelSoPhong, gbc_labelSoPhong);
		labelSoPhong.setFont(new Font("Times New Roman", Font.BOLD, 20));
		labelSoPhong.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_textSoPhong = new GridBagConstraints();
		gbc_textSoPhong.fill = GridBagConstraints.HORIZONTAL;
		gbc_textSoPhong.insets = new Insets(0, 10, 0, 0);
		gbc_textSoPhong.gridx = 1;
		gbc_textSoPhong.gridy = 3;
		add(textSoPhong, gbc_textSoPhong);
		textSoPhong.setBorder(null);
		textSoPhong.setColumns(20);
		textSoPhong.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		GridBagConstraints gbc_labelNgayThi = new GridBagConstraints();
		gbc_labelNgayThi.anchor = GridBagConstraints.EAST;
		gbc_labelNgayThi.insets = new Insets(0, 0, 0, 0);
		gbc_labelNgayThi.gridx = 0;
		gbc_labelNgayThi.gridy = 4;
		add(labelNgayThi, gbc_labelNgayThi);
		labelNgayThi.setFont(new Font("Times New Roman", Font.BOLD, 20));
		labelNgayThi.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_textNgayThi = new GridBagConstraints();
		gbc_textNgayThi.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNgayThi.insets = new Insets(0, 10, 0, 0);
		gbc_textNgayThi.gridx = 1;
		gbc_textNgayThi.gridy = 4;
		add(textNgayThi, gbc_textNgayThi);
		textNgayThi.setBorder(null);
		textNgayThi.setColumns(20);
		textNgayThi.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		GridBagConstraints gbc_labelLePhi = new GridBagConstraints();
		gbc_labelLePhi.anchor = GridBagConstraints.EAST;
		gbc_labelLePhi.insets = new Insets(0, 0, 0, 0);
		gbc_labelLePhi.gridx = 0;
		gbc_labelLePhi.gridy = 5;
		add(labelLePhi, gbc_labelLePhi);
		labelLePhi.setFont(new Font("Times New Roman", Font.BOLD, 20));
		labelLePhi.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_textLePhi = new GridBagConstraints();
		gbc_textLePhi.fill = GridBagConstraints.HORIZONTAL;
		gbc_textLePhi.insets = new Insets(0, 10, 0, 0);
		gbc_textLePhi.gridx = 1;
		gbc_textLePhi.gridy = 5;
		add(textLePhi, gbc_textLePhi);
		textLePhi.setBorder(null);
		textLePhi.setColumns(20);
		textLePhi.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	}
	
	public void showData() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ID Thí Sinh");
		model.addColumn("Số báo danh");
		model.addColumn("Địa điểm thi");
		model.addColumn("Ngày thi");
		model.addColumn("Số phòng");
		model.addColumn("Lệ phí");
		table.setModel(model);
		table.setAutoResizeMode(0);
		table.getColumnModel().getColumn(0).setPreferredWidth(100);
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(350);
		table.getColumnModel().getColumn(3).setPreferredWidth(150);
		table.getColumnModel().getColumn(4).setPreferredWidth(80);
		table.getColumnModel().getColumn(5).setPreferredWidth(80);
		
		try {
			Connection connection = null;
			PreparedStatement info = null;
			ResultSet rs = null;
			
			String connectionURL = "jdbc:sqlserver://LAPTOP-87JFGLT1:1433;databaseName=QUAN_LY_TUYEN_SINH;integratedSecurity=true;";
			connection = DriverManager.getConnection(connectionURL);
			info = connection.prepareStatement("Select IDThiSinh, SBD, DiaDiem, NgayThi, SoPhong, LePhi from PHIEUBAOTHI");
			rs = info.executeQuery();
            while(rs.next()) {
            	model.addRow(new Object[] {
            			rs.getString("IDThiSinh"),
            			rs.getString("SBD"),
            			rs.getString("DiaDiem"),
            			rs.getString("NgayThi"),
            			rs.getString("SoPhong"),
            			rs.getString("LePhi")
            	});		
            }
            connection.close();
            rs.close();
            info.close();
		} catch (Exception e) {
            	System.out.println("error: " + e);
		}
	}
}
