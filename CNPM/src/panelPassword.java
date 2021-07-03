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

public class panelPassword extends JPanel {
	
	private final JLabel labelTitle = new JLabel("Đổi mật khẩu");
	private final JLabel labelOldPassword = new JLabel("Mật khẩu hiện tại:");
	private final JLabel labelNewPassword = new JLabel("Mật khẩu mới:");
	private final JLabel labelConfirm = new JLabel("Xác nhận mật khẩu:");
	
	public static JPasswordField textOldPassword = new JPasswordField();
	public static JPasswordField textNewPassword = new JPasswordField();
	public static JPasswordField textConfirm = new JPasswordField();
	
	private final JButton buttonChange = new JButton("Đổi mật khẩu");
	private final JButton buttonBack = new JButton("Quay lại");
	public static JLabel textIDNow = new JLabel("");
	
	public static CardLayout cardLayout = new CardLayout();
	public static JPanel background = new JPanel();
	public static JPanel panelMainContent = new JPanel();
	
	public panelPassword() {
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
		
		panelMainContent.setLayout(null);
		panelMainContent.setBackground(new Color(200, 255, 255));
		panelMainContent.setBounds(0, 0, 900, 500);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{230, 120, 130, 130, 290};
		gridBagLayout.rowHeights = new int[]{160, 40, 40, 40, 40, 180};
		gridBagLayout.columnWeights = new double[]{};
		gridBagLayout.rowWeights = new double[]{};
		panelMainContent.setLayout(gridBagLayout);
		
		GridBagConstraints gbc_labelTitle = new GridBagConstraints();
		gbc_labelTitle.insets = new Insets(100, 70, 0, 0);
		gbc_labelTitle.gridwidth = 5;
		gbc_labelTitle.gridx = 0;
		gbc_labelTitle.gridy = 0;
		panelMainContent.add(labelTitle, gbc_labelTitle);
		labelTitle.setFont(new Font("Times New Roman", Font.BOLD, 36));
		labelTitle.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_labelOldPassword = new GridBagConstraints();
		gbc_labelOldPassword.anchor = GridBagConstraints.EAST;
		gbc_labelOldPassword.insets = new Insets(0, 0, 0, 0);
		gbc_labelOldPassword.gridx = 1;
		gbc_labelOldPassword.gridy = 1;
		panelMainContent.add(labelOldPassword, gbc_labelOldPassword);
		labelOldPassword.setFont(new Font("Times New Roman", Font.BOLD, 20));
		labelOldPassword.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_textOldPassword = new GridBagConstraints();
		gbc_textOldPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_textOldPassword.insets = new Insets(0, 10, 0, 0);
		gbc_textOldPassword.gridwidth = 2;
		gbc_textOldPassword.gridx = 2;
		gbc_textOldPassword.gridy = 1;
		panelMainContent.add(textOldPassword, gbc_textOldPassword);
		textOldPassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textOldPassword.setForeground(Color.BLACK);
		textOldPassword.setColumns(20);
		textOldPassword.setBorder(null);
		
		GridBagConstraints gbc_labelNewPassword = new GridBagConstraints();
		gbc_labelNewPassword.anchor = GridBagConstraints.EAST;
		gbc_labelNewPassword.insets = new Insets(0, 0, 0, 0);
		gbc_labelNewPassword.gridx = 1;
		gbc_labelNewPassword.gridy = 2;
		panelMainContent.add(labelNewPassword, gbc_labelNewPassword);
		labelNewPassword.setFont(new Font("Times New Roman", Font.BOLD, 20));
		labelNewPassword.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_textNewPassword = new GridBagConstraints();
		gbc_textNewPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_textNewPassword.insets = new Insets(0, 10, 0, 0);
		gbc_textNewPassword.gridwidth = 2;
		gbc_textNewPassword.gridx = 2;
		gbc_textNewPassword.gridy = 2;
		panelMainContent.add(textNewPassword, gbc_textNewPassword);
		textNewPassword.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textNewPassword.setForeground(Color.BLACK);
		textNewPassword.setColumns(20);
		textNewPassword.setBorder(null);
		
		GridBagConstraints gbc_labelConfirm = new GridBagConstraints();
		gbc_labelConfirm.anchor = GridBagConstraints.EAST;
		gbc_labelConfirm.insets = new Insets(0, 0, 0, 0);
		gbc_labelConfirm.gridx = 1;
		gbc_labelConfirm.gridy = 3;
		panelMainContent.add(labelConfirm, gbc_labelConfirm);
		labelConfirm.setFont(new Font("Times New Roman", Font.BOLD, 20));
		labelConfirm.setForeground(Color.BLACK);
		
		GridBagConstraints gbc_textConfirm = new GridBagConstraints();
		gbc_textConfirm.fill = GridBagConstraints.HORIZONTAL;
		gbc_textConfirm.insets = new Insets(0, 10, 0, 0);
		gbc_textConfirm.gridwidth = 2;
		gbc_textConfirm.gridx = 2;
		gbc_textConfirm.gridy = 3;
		panelMainContent.add(textConfirm, gbc_textConfirm);
		textConfirm.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		textConfirm.setForeground(Color.BLACK);
		textConfirm.setColumns(20);
		textConfirm.setBorder(null);
		
		GridBagConstraints gbc_labelbuttonChange = new GridBagConstraints();
		gbc_labelbuttonChange.anchor = GridBagConstraints.SOUTH;
		gbc_labelbuttonChange.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelbuttonChange.insets = new Insets(0, 10, 0, 0);
		gbc_labelbuttonChange.gridx = 2;
		gbc_labelbuttonChange.gridy = 4;
		panelMainContent.add(buttonChange, gbc_labelbuttonChange);
		buttonChange.setFont(new Font("Times New Roman", Font.BOLD, 20));
		buttonChange.setForeground(Color.BLACK);
		buttonChange.setFocusPainted(false);
		buttonChange.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				buttonChange.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				String newPassword = textNewPassword.getText();
				String confirm = textConfirm.getText();
				
				try {
					Connection connection = null;
					PreparedStatement info = null;
					PreparedStatement info1 = null;
					ResultSet rs = null;
					
					String connectionURL = "jdbc:sqlserver://LAPTOP-87JFGLT1:1433;databaseName=QUAN_LY_TUYEN_SINH;integratedSecurity=true;";
					connection = DriverManager.getConnection(connectionURL);
					info = connection.prepareStatement("Select IDThiSinh, MatKhau from THISINH where UserName=? and MatKhau=?");
					info.setString(1, textIDNow.getText());
                    info.setString(2, textOldPassword.getText());
                    rs = info.executeQuery();
                    if (rs.next() && newPassword.equals(confirm)) {
                    	info1 = connection.prepareStatement("Update THISINH set MatKhau=? where UserName=?");
                    	info1.setString(1, textNewPassword.getText());
                    	info1.setString(2, textIDNow.getText());
                    	info1.executeUpdate();
    					JOptionPane.showMessageDialog(null, "Đổi mật khẩu thành công.  \nVui lòng đăng nhập lại!");
    					setVisible(false);
                    } 
                    
                    else {
                        JOptionPane.showMessageDialog(null, "Sai mật khẩu hoặc xác nhận mật khẩu chưa đúng!.\nVui lòng nhập lại!  ", "Login Error", JOptionPane.ERROR_MESSAGE);
                        textOldPassword.setText(null);
                        textNewPassword.setText(null);
                        textConfirm.setText(null);
    				}
                    connection.close();
		            info.close(); 
		            info1.close(); 
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
		gbc_labelbuttonBack.gridy = 4;
		panelMainContent.add(buttonBack, gbc_labelbuttonBack);
		buttonBack.setFont(new Font("Times New Roman", Font.BOLD, 20));
		buttonBack.setForeground(Color.BLACK);
		buttonBack.setFocusPainted(false);
		buttonBack.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				buttonBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			public void mouseClicked(MouseEvent e) {
				textOldPassword.setText("");
				textNewPassword.setText("");
				textConfirm.setText("");
				setVisible(false);
			}
		});
	}

}
