package trip;

import java.sql.Date;
import java.util.List;

public class TripMain {
	public static void main(String[] args) {

		TripDAO dao = new TripDAO();

		// 1. [팀원 A] 여행 등록
		TripDTO trip = new TripDTO("부산 여행", "010-9999-8888", Date.valueOf("2026-08-01"), Date.valueOf("2026-08-03"), 3);
		dao.insertTrip(trip);

		// 2. 여행 목록 출력
		System.out.println("=== 여행 목록 ===\n");
		List<TripDTO> tripList = dao.selectAllTrips();
		for (TripDTO t : tripList) {
			System.out.println("여행 제목: " + t.getName() + ", 인원: " + t.getCount() + ", 출발일: " + t.getStartDate()
					+ ", 종료일: " + t.getEndDate() );
		}
		
		// 3. [팀원 B] 여행 날짜 기준 일정 출력
		System.out.println("\n=== 날짜 목록 ===\n");
		List<ScheduleDTO> Schedulelist =  dao.selectDateSchedule();
		
		for (ScheduleDTO s : Schedulelist) {
			System.out.println("출발 장소: " + s.getDeparture() + ", 목적지: " + s.getPlace() + ", 명소: " + s.getLocation() + ",\n   출발일: " + s.getVisitDate()
			+ " 시간: " + s.getTime() + "\n");
		}

		// 4. [팀원 C] 예산 합계 출력
		int num = 3;
		int total = dao.getTotalBudget(num);
		System.out.println("\n=== 예산 관리 ===");
		System.out.println(num + "번 여행의 지출 금액: " + total + "원");

		// 5. [팀원 D] 체크리스트 관리
		System.out.println("\n=== 체크리스트 관리 ===");

		// 6. [팀원 D] 목록 변경
		dao.updateCheckStatus(3, false, "선크림");

		// 7. [팀원 D] 목록 조회 및 구분 출력
		List<CheckListDTO> checklist = dao.selectChecklist(3);

		if (checklist.isEmpty()) {
			System.out.println("등록된 준비물이 없습니다.");
		} else {
			for (CheckListDTO item : checklist) {
				// 체크 여부에 따라 [V] 또는 [ ] 표시
				String status = item.isChecked() ? "[V] 완료" : "[ ] 미완료";
				System.out.println(status + " - " + item.getItemName());
			}
		}

	}
}
