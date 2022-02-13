/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Reservation;
import entity.Service;
import entity.User;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Thanh Tung
 */
public interface ReservationDAO {
    public ArrayList<Reservation> getReservations() throws SQLException;
    public ArrayList<User> getDoctorsHasReservation() throws SQLException;
    public ArrayList<Service> getServices() throws SQLException;
}
