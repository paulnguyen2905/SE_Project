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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class panelChamDiem extends JPanel {
	private final JLabel labelMaPhach = new JLabel("Mã phách:");
	private final JLabel labelMonThi = new JLabel("Môn thi:");
	private final JLabel labelDiem = new JLabel("Điểm:");
	
	private final JTextField textMaPhach = new JTextField();
	private final JTextField textMonThi = new JTextField();
	private final JTextField textDiem = new JTextField();
	
	private final JButton buttonAdd = new JButton("   Thêm   ");
	private final JButton buttonReset = new JButton("  Reset  ");
	private final JButton buttonDel = new JButton("   Xóa    ");
	private final JButton buttonEdit = new JButton(" Thay đổi");
	
	private final JTable table = new JTable();
	private final JScrollPane scrollPane = new JScrollPane();

	public panelChamDiem() {
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
					textMaPhach.setText("");
				else textMaPhach.setText(model.getValueAt(i, 0).toString());
				
				if (model.getValueAt(i, 1) == null)
					textMonThi.setText("");
				else textMonThi.setText(model.getValueAt(i, 1).toString());
				
				if (model.getValueAt(i, 2)== null)
					textDiem.setText("");
				else textDiem.setText(model.getValueAt(i, 2).toString());
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
				float i = Float.parseFloat(textDiem.getText());
				try {
					if(textMaPhach.getText().equals("") || textMonThi.getText().equals("") || textDiem.getText().equals("") || i<0) {
						JOptionPane.showMessageDialog(null, "Dữ liệu không hợp lệ!   ", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                	}
					else {
						Connection connection = null;
						PreparedStatement info = null;

						String connectionURL = "jdbc:sqlserver://LAPTOP-87JFGLT1:1433;databaseName=QUAN_LY_TUYEN_SINH;integratedSecurity=true;";
						connection = DriverManager.getConnection(connectionURL);
						info = connection.prepareStatement("Insert into BAITHI (MaPhach, MonThi, Diem) values (?, ?, ?)");
						info.setString(1, textMaPhach.getText());
	                    info.setString(2, textMonThi.getText());
	                    info.setString(3, textDiem.getText());
	                    info.executeUpdate();
	                    showData();
	                    
	                    textMaPhach.setText("");
						textMonThi.setText("");
						textDiem.setText("");
						
						connection.close();
						info.close();
					}
				} catch (Exception e1) {
					System.out.println("error: " + e1);
				}
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
				
					String connectionURL = "jdbc:sqlserver://LAPTOP-87JFGLT1:1433;databaseName=QUAN_LY_TUYEN_SINH;integratedSecurity=true;";
					connection = DriverManager.getConnection(connectionURL);
					info = connection.prepareStatement("Update BAITHI set MaPhach=?, MonThi=?, Diem=? where MaPhach=?");
					info.setString(1, textMaPhach.getText());
                	info.setString(2, textMonThi.getText());
                	info.setString(3, textDiem.getText());
                	info.setString(4, textMaPhach.getText());
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
				try {
					JFrame fromConfirm = new JFrame("Confirm");
                    int confirmed = JOptionPane.showConfirmDialog(fromConfirm, "Bạn có chắc muốn xóa dữ liệu này?", "Confirm information", JOptionPane.YES_NO_OPTION);
            		if (confirmed == JOptionPane.YES_OPTION) {	
						Connection connection = null;
						PreparedStatement info = null;
	
						String connectionURL = "jdbc:sqlserver://LAPTOP-87JFGLT1:1433;databaseName=QUAN_LY_TUYEN_SINH;integratedSecurity=true;";
						connection = DriverManager.getConnection(connectionURL);
						info = connection.prepareStatement("Delete from BAITHI where MaPhach=?");
						info.setString(1, textMaPhach.getText());
						info.executeUpdate();
						showData();
			            connection.close();
			            info.close();
            		}
            		else
            			setVisible(true);
				} catch (Exception E) {
		            	System.out.println("error: " + E);
				}
				textMaPhach.setText("");
				textMonThi.setText("");
				textDiem.setText("");
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
				textMaPhach.setText("");
				textMonThi.setText("");
				textDiem.setText("");
			}
		});
		
		GridBagConstraints gbc_labelMaPhach = new GridBagConstraints();
		gbc_labelMaPhach.anchor = GridBagConstraints.EAST;
		gbc_labelMaPhach.insets = new Insets(0, 0, 0, 0);
		gbc_labelMaPhach.gridx = 0;
		gbc_labelMaPhach.gridy = 3;
		add(labelMaPhach, gbc_labelMaPhach);
		labelMaPhach.setFont(new Font("Times New Roman", Font.BOLD, 20));
		labelMaPhach.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_textMaPhach = new GridBagConstraints();
		gbc_textMaPhach.fill = GridBagConstraints.HORIZONTAL;
		gbc_textMaPhach.insets = new Insets(0, 10, 0, 0);
		gbc_textMaPhach.gridx = 1;
		gbc_textMaPhach.gridy = 3;
		add(textMaPhach, gbc_textMaPhach);
		textMaPhach.setBorder(null);
		textMaPhach.setColumns(20);
		textMaPhach.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		GridBagConstraints gbc_labelMonThi = new GridBagConstraints();
		gbc_labelMonThi.anchor = GridBagConstraints.EAST;
		gbc_labelMonThi.insets = new Insets(0, 0, 0, 0);
		gbc_labelMonThi.gridx = 0;
		gbc_labelMonThi.gridy = 4;
		add(labelMonThi, gbc_labelMonThi);
		labelMonThi.setFont(new Font("Times New Roman", Font.BOLD, 20));
		labelMonThi.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_textMonThi = new GridBagConstraints();
		gbc_textMonThi.fill = GridBagConstraints.HORIZONTAL;
		gbc_textMonThi.insets = new Insets(0, 10, 0, 0);
		gbc_textMonThi.gridx = 1;
		gbc_textMonThi.gridy = 4;
		add(textMonThi, gbc_textMonThi);
		textMonThi.setBorder(null);
		textMonThi.setColumns(20);
		textMonThi.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		GridBagConstraints gbc_labelDiem = new GridBagConstraints();
		gbc_labelDiem.anchor = GridBagConstraints.EAST;
		gbc_labelDiem.insets = new Insets(0, 0, 0, 0);
		gbc_labelDiem.gridx = 0;
		gbc_labelDiem.gridy = 5;
		add(labelDiem, gbc_labelDiem);
		labelDiem.setFont(new Font("Times New Roman", Font.BOLD, 20));
		labelDiem.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_textDiem = new GridBagConstraints();
		gbc_textDiem.fill = GridBagConstraints.HORIZONTAL;
		gbc_textDiem.insets = new Insets(0, 10, 0, 0);
		gbc_textDiem.gridx = 1;
		gbc_textDiem.gridy = 5;
		add(textDiem, gbc_textDiem);
		textDiem.setBorder(null);
		textDiem.setColumns(20);
		textDiem.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	}
	
	private void showData() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("Mã phách");
		model.addColumn("Môn thi");
		model.addColumn("Điểm");
		table.setModel(model);
		table.setAutoResizeMode(0);
		table.getColumnModel().getColumn(0).setPreferredWidth(150);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);

		
		try {
			Connection connection = null;
			PreparedStatement info = null;
			ResultSet rs = null;
			
			String connectionURL = "jdbc:sqlserver://LAPTOP-87JFGLT1:1433;databaseName=QUAN_LY_TUYEN_SINH;integratedSecurity=true;";
			connection = DriverManager.getConnection(connectionURL);
			info = connection.prepareStatement("Select MaPhach, MonThi, Diem from BAITHI");
			rs = info.executeQuery();
            while(rs.next()) {
            	model.addRow(new Object[] {
            			rs.getString("MaPhach"),
            			rs.getString("MonThi"),
            			rs.getString("Diem"),
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
