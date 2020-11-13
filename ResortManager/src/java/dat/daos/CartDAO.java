/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dat.daos;

import dat.dto.CartDTO;
import dat.dto.RoomOrderDTO;
import dat.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author macbook
 */
public class CartDAO {

    public int save(CartDTO cart, float total) throws SQLException {
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        int result = -1;
        try {
            cn = DBUtils.getConnection();
            if (cn != null) {
                cn.setAutoCommit(false);
                String sql = "insert into tblOrders(userID, orderDate, totalMoney, status) values(?, CURRENT_TIMESTAMP, ?, 1)";
                pst = cn.prepareStatement(sql);
                pst.setString(1, cart.getUserID());
                pst.setFloat(2, total);
                result = pst.executeUpdate();
                if (result != -1) {
                    String sql2 = "select max(orderID) as orderID"
                            + " from tblOrders";
                    pst = cn.prepareStatement(sql2);
                    rs = pst.executeQuery();
                    if (rs.next()) {
                        int orderID = rs.getInt("orderID");
                        for (RoomOrderDTO dto : cart.getCart().values()) {
                            String sql3 = "insert into tblOrderDetail(roomID, price, checkIn, checkOut, orderID) values (?, ?, ?, ?, ?)";
                            pst = cn.prepareStatement(sql3);
                            pst.setString(1, dto.getRoomID());
                            pst.setFloat(2, dto.getPrice());
                            pst.setString(3, dto.getCheckIn());
                            pst.setString(4, dto.getCheckOut());
                            pst.setInt(5, orderID);
                            result = pst.executeUpdate();
                        }

                    }
                } else {
                    result = -1;
                }
                cn.commit();
            }

        } catch (Exception e) {
            cn.rollback();
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
        return result;
    }
}
