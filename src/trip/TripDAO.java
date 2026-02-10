package trip;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TripDAO {
	private String dbUrl = "jdbc:mysql://codevlab.kr:3306/fourbyte?serverTimezone=Asia/Seoul";
	private String dbUsr = "fourbyte";
	private String dbPwd = "123456";

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	// db 종료하는 메서드
	public void dbClose(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
