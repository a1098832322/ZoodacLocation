package com.dsw.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.text.html.HTMLDocument.HTMLReader.ParagraphAction;

import com.alibaba.fastjson.JSONArray;
import com.dsw.constant.RoomStatusCode;
import com.dsw.dao.RoomDao;
import com.dsw.util.DBConnection;
/**
 * 预留
 * @author Administrator
 *
 */
public class RoomDaoImpl implements RoomDao {
	private static RoomDaoImpl rdi = new RoomDaoImpl();

	private RoomDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	public static RoomDaoImpl getInstance() {
		return rdi;
	}

	@Override
	public RoomStatusCode insertRoom(JSONArray jsonArray) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		conn = DBConnection.getConnertion();
		try {
			ps = conn.prepareStatement("insert into room_area(id,room_name,beginX,endX,beginY,endY) values(?,?,?,?,?,?)");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.free(ps, conn);
		}
		return null;
	}

	@Override
	public RoomStatusCode deleteRoom() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		conn = DBConnection.getConnertion();
		try {
			ps = conn.prepareStatement("truncate table room_area");
			if (ps.execute()) {
				return RoomStatusCode.SUCCESS;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.free(ps, conn);
		}
		return RoomStatusCode.FAIL;
	}

	@Override
	public ArrayList<Integer> checkRoom() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Integer> list = new ArrayList<>();
		try {
			conn = DBConnection.getConnertion();
			ps = conn.prepareStatement("select id from room_area");
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new Integer(rs.getInt(1)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.free(rs, ps, conn);
		}
		return list;
	}

}
