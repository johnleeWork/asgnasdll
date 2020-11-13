/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dat.daos;

import dat.dto.RoomDTO;
import dat.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author macbook
 */
public class RoomDAO {

    public List<RoomDTO> getAvailableRoom(String checkIn, String checkOut) throws SQLException {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<RoomDTO> list = new ArrayList<>();
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "select roomID, description, price\n"
                        + "                        from tblRoom\n"
                        + "                        where status = 1 and roomID not in (\n"
                        + "                        select roomID\n"
                        + "                        from tblOrderDetail \n"
                        + "                        where  not (checkIn > ? or checkOut < ?))";
                pst = cn.prepareStatement(sql);
                pst.setString(1, checkOut);
                pst.setString(2, checkIn);
                rs = pst.executeQuery();
                while (rs.next()) {
                    String roomID = rs.getString("roomID");
                    float price = rs.getFloat("price");
                    String description = rs.getString("description");
                    list.add(new RoomDTO(roomID, price, description, true));
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return list;
    }

    public List<RoomDTO> getAllRoom() throws SQLException {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<RoomDTO> list = new ArrayList<>();
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "select roomID, description, price, status\n"
                        + "from tblRoom";
                pst = cn.prepareStatement(sql);
                rs = pst.executeQuery();
                while (rs.next()) {
                    String roomID = rs.getString("roomID");
                    float price = rs.getFloat("price");
                    String description = rs.getString("description");
                    boolean status = rs.getBoolean("status");
                    list.add(new RoomDTO(roomID, price, description, status));
                }
            }
        } catch (Exception e) {
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return list;
    }

    public int update(RoomDTO dto) throws SQLException {
        Connection cn = null;
        PreparedStatement pst = null;
        int result = -1;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "Update tblRoom"
                        + " set price = ?, description = ?, status = ? "
                        + "where roomID = ?";
                pst = cn.prepareStatement(sql);
                pst.setFloat(1, dto.getPrice());
                pst.setString(2, dto.getDescription());
                pst.setBoolean(3, dto.isStatus());
                pst.setString(4, dto.getRoomID());
                result = pst.executeUpdate();
            }
        } catch (Exception e) {
        } finally {
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return result;
    }

    public int delete(String roomID) throws SQLException {
        Connection cn = null;
        PreparedStatement pst = null;
        int result = -1;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                String sql = "Update tblRoom"
                        + " set status = 0 "
                        + "where roomID = ?";
                pst = cn.prepareStatement(sql);
                pst.setString(1, roomID);
                result = pst.executeUpdate();
            }
        } catch (Exception e) {
        } finally {
            if (pst != null) {
                pst.close();
            }
            if (cn != null) {
                cn.close();
            }
        }
        return result;
    }
}
