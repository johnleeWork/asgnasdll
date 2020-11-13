/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dat.dto;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author macbook
 */
public class CartDTO {

    private String userID;
    private Map<String, RoomOrderDTO> cart;

    public CartDTO() {
    }

    public CartDTO(String userID, Map<String, RoomOrderDTO> cart) {
        this.userID = userID;
        this.cart = cart;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public Map<String, RoomOrderDTO> getCart() {
        return cart;
    }

    public void setCart(Map<String, RoomOrderDTO> cart) {
        this.cart = cart;
    }

   
    
    

    public void add(RoomOrderDTO dto) {
        if (this.cart == null) {
            this.cart = new HashMap<>();
        }
        this.cart.put(dto.getRoomID(), dto);
    }

    public void delete(String roomID) {
        if (this.cart == null) {
            return;
        }
        if (this.cart.containsKey(roomID)) {
            this.cart.remove(roomID);
        }
    }

}