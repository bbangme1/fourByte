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

	private int result = 0;

	// [팀원 A] 여행 등록
	public int insertTrip(TripDTO dto) {
		String sql = "INSERT INTO trip (name, phone, start_date, end_date, count) VALUES (?, ?, ?, ?, ?)";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbUrl, dbUsr, dbPwd);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getPhone());
			pstmt.setDate(3, dto.getStartDate());
			pstmt.setDate(4, dto.getEndDate());
			pstmt.setInt(5, dto.getCount());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose(rs, pstmt, conn);
		}
		return 0;
	}

	// [팀원 A] 여행 목록 조회
	public List<TripDTO> selectAllTrips() {
		
		List<TripDTO> list = new ArrayList<>();
		
		String sql = "SELECT * FROM trip";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbUrl, dbUsr, dbPwd);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new TripDTO(rs.getString("name"), rs.getString("phone"), rs.getDate("start_date"),
						rs.getDate("end_date"), rs.getInt("count")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose(rs, pstmt, conn);
		}
		return list;
	}

	// [팀원 B] 여행 날짜 기준 일정 조회
	public List<ScheduleDTO> selectDateSchedule(String visit) {
		
		List<ScheduleDTO> list = new ArrayList<>();
		java.sql.Date date = java.sql.Date.valueOf(visit);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbUrl, dbUsr, dbPwd);
			String sql = "SELECT * FROM schedule WHERE visit_date = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setDate(1, date);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				ScheduleDTO dto = new ScheduleDTO();
				
				dto.setPlace(rs.getString("place"));
				dto.setDeparture(rs.getString("departure"));
				dto.setLocation(rs.getString("location"));
				dto.setVisitDate(rs.getDate("visit_date"));
				dto.setTime(rs.getDate("time"));
				
				list.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose(rs, pstmt, conn);
		} return list;

	}

	// [팀원 C] 총 예산 계산
	public int getTotalBudget(long tripId) {
		String sql = "SELECT SUM(price) FROM budget_item WHERE trip_id = ?";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbUrl, dbUsr, dbPwd);
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, tripId);
			rs = pstmt.executeQuery();
			if (rs.next())
				return rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose(rs, pstmt, conn);
		}
		return 0;
	}

	// [팀원 D] 체크 여부 변경
	public int updateCheckStatus(long id, boolean isChecked, String itemName) {
		String sql = "UPDATE checklist SET is_checked = ? WHERE id = ? and item_name = ?";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbUrl, dbUsr, dbPwd);
			pstmt = conn.prepareStatement(sql);
			pstmt.setBoolean(1, isChecked);
			pstmt.setLong(2, id);
			pstmt.setString(3, itemName);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose(rs, pstmt, conn);
		}
		return 0;
	}

	// [팀원 D] 체크리스트 조회
	public List<CheckListDTO> selectChecklist(long tripId) {
		List<CheckListDTO> list = new ArrayList<>();
		String sql = "SELECT * FROM checklist WHERE trip_id = ?";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(dbUrl, dbUsr, dbPwd);
			pstmt = conn.prepareStatement(sql);
			pstmt.setLong(1, tripId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new CheckListDTO(rs.getString("item_name"), rs.getBoolean("is_checked")));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose(rs, pstmt, conn);
		}
		return list;
	}

	// db 종료 메서드
	public void dbClose(ResultSet rs, PreparedStatement pstmt, Connection conn) {
		try {
			if (rs != null)
				rs.close();
			if (pstmt != null)
				pstmt.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}