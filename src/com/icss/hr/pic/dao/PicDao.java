package com.icss.hr.pic.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.icss.hr.common.DbUtil;
import com.icss.hr.pic.pojo.Pic;

/**
 * 图片dao
 * 
 * @author DLETC
 *
 */
public class PicDao {

	/**
	 * 插入数据
	 * 
	 * @param pic
	 * @throws SQLException
	 */
	public void insert(Pic pic) throws SQLException {

		Connection conn = DbUtil.getConnection();

		String sql = "insert into pic values(pic_seq.nextval,?,?,?,?,?,?)";
		PreparedStatement psmt = conn.prepareStatement(sql);

		psmt.setString(1, pic.getPicName());
		psmt.setString(2, pic.getPicInfo());
		psmt.setLong(3, pic.getPicSize());
		psmt.setString(4, pic.getPicAuthor());
		psmt.setBinaryStream(5, pic.getPicData(), (int) pic.getPicSize());
		psmt.setTimestamp(6, new Timestamp(pic.getPicDatetime().getTime()));

		psmt.executeUpdate();
		psmt.close();
		conn.close();

	}

	/**
	 * 查询多条数据，返回图片集合
	 * 
	 * @return
	 * @throws SQLException
	 */
	public List<Pic> query() throws SQLException {

		Connection conn = DbUtil.getConnection();

		String sql = "select * from pic order by pic_datetime desc";
		PreparedStatement psmt = conn.prepareStatement(sql);

		ResultSet rs = psmt.executeQuery();

		ArrayList<Pic> list = new ArrayList<>();

		while (rs.next()) {
			Pic pic = new Pic(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getLong(4), rs.getString(5), null,
					rs.getTime(7));

			list.add(pic);
		}

		rs.close();
		psmt.close();
		conn.close();

		return list;

	}

	/**
	 * 根据id返回图片二进制数据
	 * 
	 * @throws SQLException
	 */
	public Pic queryById(int picId) throws SQLException {

		Connection conn = DbUtil.getConnection();

		String sql = "select * from pic where pic_id=?";
		PreparedStatement psmt = conn.prepareStatement(sql);

		psmt.setInt(1, picId);

		ResultSet rs = psmt.executeQuery();

		Pic pic = null;

		if (rs.next()) {

			pic = new Pic();
			pic.setPicName(rs.getString(2));
			pic.setPicData(rs.getBinaryStream(6));
		}

		rs.close();
		psmt.close();
		// conn.close();

		return pic;

	}

	/**
	 * 删除数据
	 * 
	 * @throws SQLException
	 */
	public void delete(int picId) throws SQLException {

		Connection conn = DbUtil.getConnection();

		String sql = "delete from pic where pic_id=?";
		PreparedStatement psmt = conn.prepareStatement(sql);

		psmt.setInt(1, picId);

		psmt.executeUpdate();

		psmt.close();
		conn.close();

	}

}
