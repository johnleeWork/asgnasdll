/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dat.dto;

/**
 *
 * @author macbook
 */
public class RoomOrderDTO {

    private String roomID;
    private float price;
    private String email;
    private String checkIn;
    private String checkOut;

    public RoomOrderDTO() {
    }

    public RoomOrderDTO(String roomID, float price, String email, String checkIn, String checkOut) {
        this.roomID = roomID;
        this.price = price;
        this.email = email;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public String getRoomID() {
        return roomID;
    }

    public void setRoomID(String roomID) {
        this.roomID = roomID;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

}
