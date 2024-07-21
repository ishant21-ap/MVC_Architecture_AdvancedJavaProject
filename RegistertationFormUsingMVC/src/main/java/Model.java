import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Model {
	
	private String fullname;
	private String phone;
	private String email;
	private String password;
	private String gender;
	
	private Connection connect;
	private PreparedStatement pstm;
	private int row;
	
	// now we will use getter and setter bcoz we have collected data in our servlet now we have to pass that data to class which connects to database here we will use setter to send data 
	
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	// now method to connect to database;
	
	public int register() {
	
		try {
			connect = JdbcUtil.getDBConnection(); //calling connection
			String sql = "insert into  registerform(fullname, phone, email, password, gender) values(?, ?, ?, ?, ?)";
			pstm = connect.prepareStatement(sql);
			
			pstm.setString(1, fullname);
			pstm.setString(2, phone);
			pstm.setString(3, email);
			pstm.setString(4, password);
			pstm.setString(5, gender);
			
			row = pstm.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		finally {
			try {
				JdbcUtil.closeResource(connect, pstm);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return row;
	}
	
	public boolean checkUserExists(String email) {
	    boolean userExists = false;
	    try {
	        connect = JdbcUtil.getDBConnection();
	        String sql = "SELECT COUNT(*) FROM registerform WHERE email = ?";
	        pstm = connect.prepareStatement(sql);
	        pstm.setString(1, email);
	        ResultSet rs = pstm.executeQuery();
	        if (rs.next()) {
	            int count = rs.getInt(1);
	            if (count > 0) {
	                userExists = true;
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            JdbcUtil.closeResource(connect, pstm);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return userExists;
	}
	
	
	public boolean validateUser(String email, String password) {
		boolean isValidUser = false;
		try {
			connect = JdbcUtil.getDBConnection();
			String sql = "select * from registerForm where email = ? and password = ?";
			pstm = connect.prepareStatement(sql);
			pstm.setString(1, email);
			pstm.setString(2, password);
			ResultSet rs = pstm.executeQuery();
			if(rs.next()) {
				isValidUser = true;
			}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
	        try {
	            JdbcUtil.closeResource(connect, pstm);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		}
		return isValidUser;
	}
	
	public String getFullNameByEmail(String email) {
	    String fullName = null;
	    try {
	        connect = JdbcUtil.getDBConnection();
	        String sql = "SELECT fullname FROM registerform WHERE email = ?";
	        pstm = connect.prepareStatement(sql);
	        pstm.setString(1, email);
	        ResultSet rs = pstm.executeQuery();
	        if (rs.next()) {
	            fullName = rs.getString("fullname");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            JdbcUtil.closeResource(connect, pstm);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    return fullName;
	}


	
	
}
