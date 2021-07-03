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

public class panelNhapDiem extends JPanel {
	private final JLabel labelIDThiSinh = new JLabel("ID Thí Sinh:");
	private final JLabel labelDiem1 = new JLabel("Điểm môn 1:");
	private final JLabel labelDiem2 = new JLabel("Điểm môn 2:");
	private final JLabel labelDiem3 = new JLabel("Điểm môn 3:");
	
	private final JTextField textIDThiSinh = new JTextField();
	private final JTextField textDiem1 = new JTextField();
	private final JTextField textDiem2 = new JTextField();
	private final JTextField textDiem3 = new JTextField();
	
	private final JButton buttonAdd = new JButton("   Thêm   ");
	private final JButton buttonReset = new JButton("  Reset  ");
	private final JButton buttonDel = new JButton("   Xóa    ");
	private final JButton buttonEdit = new JButton(" Thay đổi");
	
	private final JTable table = new JTable();
	private final JScrollPane scrollPane = new JScrollPane();


	public panelNhapDiem() {
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
					textIDThiSinh.setText("");
				else textIDThiSinh.setText(model.getValueAt(i, 0).toString());
				
				if (model.getValueAt(i, 1) == null)
					textDiem1.setText("");
				else textDiem1.setText(model.getValueAt(i, 1).toString());
				
				if (model.getValueAt(i, 2) == null)
					textDiem2.setText("");
				else textDiem2.setText(model.getValueAt(i, 2).toString());
				
				if (model.getValueAt(i, 3) == null)
					textDiem3.setText("");
				else textDiem3.setText(model.getValueAt(i, 3).toString());
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
				float i1 = Float.parseFloat(textDiem1.getText());
				float i2 = Float.parseFloat(textDiem2.getText());
				float i3 = Float.parseFloat(textDiem3.getText());
				try {
					if(textIDThiSinh.getText().equals("") || textDiem1.getText().equals("") || i1<0
							|| textDiem2.getText().equals("") || i2<0
							|| textDiem2.getText().equals("") || i2<0) {
						JOptionPane.showMessageDialog(null, "Dữ liệu không hợp lệ!   ", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                	}
					else {
						Connection connection = null;
						PreparedStatement info = null;

						String connectionURL = "jdbc:sqlserver://LAPTOP-87JFGLT1:1433;databaseName=QUAN_LY_TUYEN_SINH;integratedSecurity=true;";
						connection = DriverManager.getConnection(connectionURL);
						info = connection.prepareStatement("Insert into GANPHACH (IDThiSinh, Diem1, Diem2, Diem3) values (?, ?, ?, ?)");
	                    info.setString(1, textIDThiSinh.getText());
	                    info.setString(2, textDiem1.getText());
	                    info.setString(3, textDiem2.getText());
	                    info.setString(4, textDiem3.getText());
	                    info.executeUpdate();
	                    showData();
	                    
						textIDThiSinh.setText("");
						textDiem1.setText("");
						textDiem2.setText("");
						textDiem3.setText("");
						
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
					info = connection.prepareStatement("Update GANPHACH set IDThiSinh=?, Diem1=?, Diem2=?, Diem3=? where IDThiSinh=?");
					info.setString(1, textIDThiSinh.getText());
                	info.setString(2, textDiem1.getText());
                	info.setString(3, textDiem2.getText());
                	info.setString(4, textDiem3.getText());
                	info.setString(5, textIDThiSinh.getText());
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
						info = connection.prepareStatement("Delete from GANPHACH where IDThiSinh=?");
						info.setString(1, textIDThiSinh.getText());
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
				textIDThiSinh.setText("");
				textDiem1.setText("");
				textDiem2.setText("");
				textDiem3.setText("");
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
				textIDThiSinh.setText("");
				textDiem1.setText("");
				textDiem2.setText("");
				textDiem3.setText("");
			}
		});
		
		GridBagConstraints gbc_labelIDThiSinh = new GridBagConstraints();
		gbc_labelIDThiSinh.anchor = GridBagConstraints.EAST;
		gbc_labelIDThiSinh.insets = new Insets(0, 0, 0, 0);
		gbc_labelIDThiSinh.gridx = 0;
		gbc_labelIDThiSinh.gridy = 2;
		add(labelIDThiSinh, gbc_labelIDThiSinh);
		labelIDThiSinh.setFont(new Font("Times New Roman", Font.BOLD, 20));
		labelIDThiSinh.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_textIDThiSinh = new GridBagConstraints();
		gbc_textIDThiSinh.fill = GridBagConstraints.HORIZONTAL;
		gbc_textIDThiSinh.insets = new Insets(0, 10, 0, 0);
		gbc_textIDThiSinh.gridx = 1;
		gbc_textIDThiSinh.gridy = 2;
		add(textIDThiSinh, gbc_textIDThiSinh);
		textIDThiSinh.setBorder(null);
		textIDThiSinh.setColumns(20);
		textIDThiSinh.setFont(new Font("Times New Roman", Font.PLAIN, 20));

		GridBagConstraints gbc_labelDiem1 = new GridBagConstraints();
		gbc_labelDiem1.anchor = GridBagConstraints.EAST;
		gbc_labelDiem1.insets = new Insets(0, 0, 0, 0);
		gbc_labelDiem1.gridx = 0;
		gbc_labelDiem1.gridy = 3;
		add(labelDiem1, gbc_labelDiem1);
		labelDiem1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		labelDiem1.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_textDiem1 = new GridBagConstraints();
		gbc_textDiem1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textDiem1.insets = new Insets(0, 10, 0, 0);
		gbc_textDiem1.gridx = 1;
		gbc_textDiem1.gridy = 3;
		add(textDiem1, gbc_textDiem1);
		textDiem1.setBorder(null);
		textDiem1.setColumns(20);
		textDiem1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		GridBagConstraints gbc_labelDiem2 = new GridBagConstraints();
		gbc_labelDiem2.anchor = GridBagConstraints.EAST;
		gbc_labelDiem2.insets = new Insets(0, 0, 0, 0);
		gbc_labelDiem2.gridx = 0;
		gbc_labelDiem2.gridy = 4;
		add(labelDiem2, gbc_labelDiem2);
		labelDiem2.setFont(new Font("Times New Roman", Font.BOLD, 20));
		labelDiem2.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_textDiem2 = new GridBagConstraints();
		gbc_textDiem2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textDiem2.insets = new Insets(0, 10, 0, 0);
		gbc_textDiem2.gridx = 1;
		gbc_textDiem2.gridy = 4;
		add(textDiem2, gbc_textDiem2);
		textDiem2.setBorder(null);
		textDiem2.setColumns(20);
		textDiem2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		
		GridBagConstraints gbc_labelDiem3 = new GridBagConstraints();
		gbc_labelDiem3.anchor = GridBagConstraints.EAST;
		gbc_labelDiem3.insets = new Insets(0, 0, 0, 0);
		gbc_labelDiem3.gridx = 0;
		gbc_labelDiem3.gridy = 5;
		add(labelDiem3, gbc_labelDiem3);
		labelDiem3.setFont(new Font("Times New Roman", Font.BOLD, 20));
		labelDiem3.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_textDiem3 = new GridBagConstraints();
		gbc_textDiem3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textDiem3.insets = new Insets(0, 10, 0, 0);
		gbc_textDiem3.gridx = 1;
		gbc_textDiem3.gridy = 5;
		add(textDiem3, gbc_textDiem3);
		textDiem3.setBorder(null);
		textDiem3.setColumns(20);
		textDiem3.setFont(new Font("Times New Roman", Font.PLAIN, 20));
	}
	
	private void showData() {
		DefaultTableModel model = new DefaultTableModel();
		model.addColumn("ID Thí Sinh");
		model.addColumn("Điểm môn 1");
		model.addColumn("Điểm môn 2");
		model.addColumn("Điểm môn 3");
		table.setModel(model);
		table.setAutoResizeMode(0);
		table.getColumnModel().getColumn(0).setPreferredWidth(125);
		table.getColumnModel().getColumn(1).setPreferredWidth(125);
		table.getColumnModel().getColumn(2).setPreferredWidth(125);
		table.getColumnModel().getColumn(3).setPreferredWidth(125);


		
		try {
			Connection connection = null;
			PreparedStatement info = null;
			ResultSet rs = null;
			
			String connectionURL = "jdbc:sqlserver://LAPTOP-87JFGLT1:1433;databaseName=QUAN_LY_TUYEN_SINH;integratedSecurity=true;";
			connection = DriverManager.getConnection(connectionURL);
			info = connection.prepareStatement("Select IDThiSinh, Diem1, Diem2, Diem3 from GANPHACH");
			rs = info.executeQuery();
            while(rs.next()) {
            	model.addRow(new Object[] {
            			rs.getString("IDThiSinh"),
            			rs.getString("Diem1"),
            			rs.getString("Diem2"),
            			rs.getString("Diem3"),
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
