import java.awt.CardLayout;
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
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class panelDangNhap extends JPanel {
	private final JLabel labelTitle = new JLabel("Đăng nhập");
	private final JLabel labelUsername = new JLabel("Tài khoản:");
	private final JLabel labelPassword = new JLabel("Mật khẩu:");
	public static JTextField textUsername = new JTextField();
	public static JPasswordField textPassword = new JPasswordField();
	private final JButton buttonLogin = new JButton("Đăng nhập");
	private final JButton buttonBack = new JButton("Quay lại");
	
	public static CardLayout cardLayout = new CardLayout();
	public static JPanel background = new JPanel();
	public static JPanel panelMainContent = new JPanel();
	
	public panelAdmin panelAdmin = new panelAdmin();
	public panelUser panelUser = new panelUser();
	
	public panelDangNhap() {
		initGUI();
	}
	
	private void initGUI() {
		setLayout(null);
		setBounds(0, 0, 900, 500);
		
		add(background);
		background.setLayout(null);
		background.setBackground(new Color(200, 255, 255));
		background.setBounds(0, 0, 900, 500);
		background.setLayout(cardLayout);
		background.add(panelMainContent, "0");
		background.add(panelAdmin, "1");
		background.add(panelUser, "2");
		cardLayout.show(background, "0");
		
		panelMainContent.setLayout(null);
		panelMainContent.setBackground(new Color(200, 255, 255));
		panelMainContent.setBounds(0, 0, 900, 500);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{250, 100, 130, 130, 290};
		gridBagLayout.rowHeights = new int[]{160, 40, 40, 40, 40, 180};
		gridBagLayout.columnWeights = new double[]{};
		gridBagLayout.rowWeights = new double[]{};
		panelMainContent.setLayout(gridBagLayout);
		
		GridBagConstraints gbc_labelTitle = new GridBagConstraints();
		gbc_labelTitle.insets = new Insets(100, -20, 0, 0);
		gbc_labelTitle.gridwidth = 5;
		gbc_labelTitle.gridx = 0;
		gbc_labelTitle.gridy = 0;
		panelMainContent.add(labelTitle, gbc_labelTitle);
		labelTitle.setFont(new Font("Times New Roman", Font.BOLD, 36));
		labelTitle.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_labelUsername = new GridBagConstraints();
		gbc_labelUsername.anchor = GridBagConstraints.EAST;
		gbc_labelUsername.insets = new Insets(0, 0, 0, 0);
		gbc_labelUsername.gridx = 1;
		gbc_labelUsername.gridy = 1;
		panelMainContent.add(labelUsername, gbc_labelUsername);
		labelUsername.setFont(new Font("Times New Roman", Font.BOLD, 20));
		labelUsername.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_labelPassword = new GridBagConstraints();
		gbc_labelPassword.anchor = GridBagConstraints.EAST;
		gbc_labelPassword.insets = new Insets(0, 0, 0, 0);
		gbc_labelPassword.gridx = 1;
		gbc_labelPassword.gridy = 2;
		panelMainContent.add(labelPassword, gbc_labelPassword);
		labelPassword.setFont(new Font("Times New Roman", Font.BOLD, 20));
		labelPassword.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_textUsername = new GridBagConstraints();
		gbc_textUsername.fill = GridBagConstraints.HORIZONTAL;
		gbc_textUsername.insets = new Insets(0, 10, 0, 0);
		gbc_textUsername.gridwidth = 2;
		gbc_textUsername.gridx = 2;
		gbc_textUsername.gridy = 1;
		panelMainContent.add(textUsername, gbc_textUsername);
		textUsername.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textUsername.setForeground(Color.BLACK);
		textUsername.setColumns(20);
		textUsername.setBorder(null);
		
		GridBagConstraints gbc_textPassword = new GridBagConstraints();
		gbc_textPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_textPassword.insets = new Insets(0, 10, 0, 0);
		gbc_textPassword.gridwidth = 2;
		gbc_textPassword.gridx = 2;
		gbc_textPassword.gridy = 2;
		panelMainContent.add(textPassword, gbc_textPassword);
		textPassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textPassword.setForeground(Color.BLACK);
		textPassword.setColumns(20);
		textPassword.setBorder(null);
		
		GridBagConstraints gbc_labelbuttonLogin = new GridBagConstraints();
		gbc_labelbuttonLogin.anchor = GridBagConstraints.SOUTH;
		gbc_labelbuttonLogin.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelbuttonLogin.insets = new Insets(0, 10, 0, 0);
		gbc_labelbuttonLogin.gridx = 2;
		gbc_labelbuttonLogin.gridy = 3;
		panelMainContent.add(buttonLogin, gbc_labelbuttonLogin);
		buttonLogin.setFont(new Font("Times New Roman", Font.BOLD, 20));
		buttonLogin.setForeground(Color.BLACK);
		buttonLogin.setFocusPainted(false);
		buttonLogin.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				buttonLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				String username = textUsername.getText();
				String password = textPassword.getText();
				
				try {
					Connection connection = null;
					PreparedStatement info = null;
					ResultSet rs = null;
					
					String connectionURL = "jdbc:sqlserver://LAPTOP-87JFGLT1:1433;databaseName=QUAN_LY_TUYEN_SINH;integratedSecurity=true;";
					connection = DriverManager.getConnection(connectionURL);
					info = connection.prepareStatement("Select IDThiSinh, MatKhau from THISINH where UserName=? and MatKhau=?");
					info.setString(1, username);
                    info.setString(2, password);
                    rs = info.executeQuery();
                    if (rs.next()) {
                    	cardLayout.show(background, "2");
    					JOptionPane.showMessageDialog(null, "Đăng nhập thành công!  ");
    					textUsername.setText(null);
                        textPassword.setText(null);
                        panelPhieuThiUser.textIDNow.setText(rs.getString("IDThiSinh"));
                        panelXemDiem.textIDNow.setText(rs.getString("IDThiSinh"));
                        panelPassword.textIDNow.setText(rs.getString("IDThiSinh"));
                        panelThongTin.textIDNow.setText(rs.getString("IDThiSinh"));
                        panelThongTin.updateInfo();
                    } 
                    
                    else if(username.equals("admin") && password.equals("admin123")) {
    					cardLayout.show(background, "1");
    					JOptionPane.showMessageDialog(null, "Đăng nhập thành công!  ");
    					textUsername.setText(null);
                        textPassword.setText(null);
    				}
                    
                    else {
                        JOptionPane.showMessageDialog(null, "Sai tài khoản hoặc mật khẩu!.\nVui lòng nhập lại!  ", "Login Error", JOptionPane.ERROR_MESSAGE);
                        textUsername.setText(null);
                        textPassword.setText(null);
    				}
                    connection.close();
		            info.close(); 
		            rs.close();
				}
				catch (SQLException sqlException) {
                    sqlException.printStackTrace();
				}
			}
		});
		
		GridBagConstraints gbc_labelbuttonBack = new GridBagConstraints();
		gbc_labelbuttonBack.anchor = GridBagConstraints.SOUTH;
		gbc_labelbuttonBack.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelbuttonBack.insets = new Insets(0, 10, 0, 0);
		gbc_labelbuttonBack.gridx = 3;
		gbc_labelbuttonBack.gridy = 3;
		panelMainContent.add(buttonBack, gbc_labelbuttonBack);
		buttonBack.setFont(new Font("Times New Roman", Font.BOLD, 20));
		buttonBack.setForeground(Color.BLACK);
		buttonBack.setFocusPainted(false);
		buttonBack.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				buttonBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				textUsername.setText("");
				textPassword.setText("");
				setVisible(false);
			}
		});
		
	}

}
