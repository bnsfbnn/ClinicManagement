/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.impl;

import context.DBContext;
import dao.ReservationDAO;
import entity.Reservation;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Thanh Tung
 */
public class ReservationDAOImpl extends DBContext implements ReservationDAO {

    @Override
    public ArrayList<Reservation> getReservations() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
