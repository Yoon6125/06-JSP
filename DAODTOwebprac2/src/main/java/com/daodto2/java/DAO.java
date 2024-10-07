package com.daodto2.java;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO extends DA {
	// 1. 글 리스트
	public ArrayList<DTO> list(String page) {
		ArrayList<DTO> post = new ArrayList<DTO>();
		int startindex = (Integer.parseInt(page) - 1) * 3;
		connect();
		String sql = String.format("select * from PS_BOARD_FREE limit %s,3", startindex);
		try {
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				post.add(new DTO(rs.getString("b_no"), rs.getString("b_title"), rs.getString("b_id"),
						rs.getString("b_datetime"), rs.getString("b_hit"), rs.getString("b_text"),
						rs.getString("b_reply_count"), rs.getString("b_reply_ori")));
			}
			closeconnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return post;
	}

	// 2. 글 읽기

	public DTO read(String no) {
		DTO d = null;
		connect();
		String sql = String.format("select * from PS_BOARD_FREE where b_no = '%s'", no);
		try {
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				d = new DTO(rs.getString("b_no"), rs.getString("b_title"), rs.getString("b_id"),
						rs.getString("b_datetime"), rs.getString("b_hit"), rs.getString("b_text"),
						rs.getString("b_reply_count"), rs.getString("b_reply_ori"));
			}
			closeconnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return d;
	}

	// 3. 글 쓰기
	public void write(DTO d) {
		connect();
		String sql = String.format("insert into PS_BOARD_FREE (b_title , b_id , b_text) values ('%s' ,'%s' ,'%s')",
				d.title, d.id, d.text);

		UpdateSql(sql);
		closeconnect();

	}

	// 4. 글 삭제
	public void delete(String no) {
		connect();
		String sql = String.format("delete from PS_BOARD_FREE where b_no='%s'", no);
		UpdateSql(sql);
		closeconnect();
	}

	// 5. 글 수정
	public void edit(DTO d, String no) {
		connect();
		String sql = String.format("update PS_BOARD_FREE set b_title ='%s' , b_text ='%s' where b_no ='%s'", d.title,
				d.text, no);

		UpdateSql(sql);
		closeconnect();

	}

	// 6. 페이징용 전체 글 수

	public int getPostCount() {
		int count = 0;
		connect();
		String sql = "select count(*) from PS_BOARD_FREE";
		try {
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				count = rs.getInt("count(*)");
			}
			closeconnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return count;
	}

	// 7. 검색용 전체 글 수
	public int getPostCount(String word) {
		int count = 0;
		connect();
		String sql = String.format("select count(*) from PS_BOARD_FREE where b_title like  '%%%s%%'", word);
		try {
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				count = rs.getInt("count(*)");
			}
			closeconnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return count;
	}

	// 8. 페이징용 전체 글 수 /3 = 페이지 수
	public int getTotalpage() {
		int Totalcount = 0;

		int count = getPostCount();

		if (count % 3 == 0) {
			Totalcount = count / 3;
		} else {
			Totalcount = count / 3 + 1;
		}

		return Totalcount;
	}

	// 9. 검색용 전체 글 수/3 = 페이지 수
	public int getTotalpage(String word) {
		int Totalcount = 0;

		int count = getPostCount(word);

		if (count % 3 == 0) {
			Totalcount = count / 3;
		} else {
			Totalcount = count / 3 + 1;
		}

		return Totalcount;

	}

	// 10. 회원가입 (세션 사용)

	// 11. 로그인

	// 12. 글 검색

	public ArrayList<DTO> serchlist(String word, String page) {
		ArrayList<DTO> post = new ArrayList<DTO>();

		int serchindex = (Integer.parseInt(page) - 1) * 3;
		connect();
		String sql = String.format("select * from PS_BOARD_FREE where b_title like '%%%s%%' limit %s,3", word,
				serchindex);
		try {
			ResultSet rs = st.executeQuery(sql);
			while (rs.next()) {
				post.add(new DTO(rs.getString("b_no"), rs.getString("b_title"), rs.getString("b_id"),
						rs.getString("b_datetime"), rs.getString("b_hit"), rs.getString("b_text"),
						rs.getString("b_reply_count"), rs.getString("b_reply_ori")));
			}
			closeconnect();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return post;
	}
}
