/*
 * Copyright(C) 20022, FPT University
 * CMS:
 * Clinic Management System
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-02-08      1.0                 TrangCT          Service DAO Implement
 */
package dao.impl;

import context.DBContext;
import dao.ServiceDAO;
import entity.Pagination;
import entity.Service;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ServiceDAOImpl extends DBContext implements ServiceDAO {

    /**
     * Logger for system
     */
    private static Logger logger = Logger.getLogger(UserDAOImpl.class.getName());

    /**
     * Method: Get All Service
     *
     * - get all services by pageIndex and pageSize
     *
     * @param pageIndex integer
     * @param pageSize integer
     * @return pagination Pagination Service
     */
    public Pagination<Service> getAllService(int pageIndex, int pageSize) {

        Pagination<Service> pagination = new Pagination<>(); // pagination services

        logger.log(Level.INFO, "getAllService");
        Connection connecion = null; // connection database
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        List<Service> services = new ArrayList<>();// list all services
        try {
            int totalItem = count(); // count total service
            pagination.setCurrentPage(pageIndex);
            pagination.setItemPerPage(pageSize);
            pagination.setTotalItem(totalItem);

            connecion = getConnection();
            // Get data
            preparedStatement = connecion.prepareStatement("select * from services ORDER BY service_id  OFFSET ? ROWS FETCH NEXT ? ROWS ONLY");
            preparedStatement.setInt(1, pageIndex);
            preparedStatement.setInt(2, pageSize);
            //excute query
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                Service service = new Service();
                service.setServiceId(rs.getInt("service_id"));
                service.setServiceName(rs.getString("service_name"));
                service.setServiceBrief(rs.getString("service_brief"));
                service.setServiceDescription(rs.getString("service_description"));
                service.setServiceImage(rs.getString("service_image"));
                services.add(service);
            }
        } catch (Exception ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeResultSet(rs);
            closePreparedStatement(preparedStatement);
            closeConnection(connecion);
        }
        pagination.setData(services);// paging for list services
        return pagination;
    }

    /**
     * Method : count - count total services in database
     *
     * @return an integer
     */
    public int count() {
        Connection connecion = null;
        PreparedStatement countPreparedStatement = null;
        ResultSet countResultSet = null;
        try {
            connecion = getConnection();
            countPreparedStatement = connecion.prepareStatement("SELECT COUNT(service_id) AS id FROM services;");
            countResultSet = countPreparedStatement.executeQuery();
            if (countResultSet.next()) {
                // get and return count total services
                return countResultSet.getInt(1);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            closeResultSet(countResultSet);
            closePreparedStatement(countPreparedStatement);
            closeConnection(connecion);
        }
        return 0;
    }

    /**
     * Method: Get Service By Id - Get and return data of service by an id
     *
     * @param id
     * @return service Service
     */
    public Service getById(int id) {
        logger.log(Level.INFO, "getById");
        Connection connecion = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;
        Service service = new Service();
        try {
            connecion = getConnection();
            // Get data
            preparedStatement = connecion.prepareStatement("select * from services where service_id = ?");
            preparedStatement.setInt(1, id);
            rs = preparedStatement.executeQuery();
            while (rs.next()) {
                service.setServiceId(rs.getInt("service_id"));
                service.setServiceName(rs.getString("service_name"));
                service.setServiceBrief(rs.getString("service_brief"));
                service.setServiceDescription(rs.getString("service_description"));
                service.setServiceImage(rs.getString("service_image"));
            }
        } catch (Exception ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            closeResultSet(rs);
            closePreparedStatement(preparedStatement);
            closeConnection(connecion);
        }
        return service;
    }

    /**
     * - Get all services of clinic
     *
     * @return a list of <code>Service</code> objects. <br>
     * -It is a <code>java.util.ArrayList</code> object
     * @throws SQLException
     */
    @Override
    public ArrayList<Service> getServices() throws SQLException {
        ArrayList<Service> result = new ArrayList<>();
        String sql = "SELECT [service_id]\n"
                + "      ,[service_name]\n"
                + "      ,[service_brief]\n"
                + "      ,[service_description]\n"
                + "      ,[service_image]\n"
                + "  FROM [CMS].[dbo].[services]";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = getConnection(); //get connection
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            /**
             * set attributes for services from result set then add its to
             * result list
             */
            while (rs.next()) {
                Service service = new Service(rs.getInt("service_id"), rs.getString("service_name"), rs.getString("service_brief"), rs.getString("service_description"), rs.getString("service_image"));
                result.add(service);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReservationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            throw ex;
        } catch (Exception ex) {
            Logger.getLogger(ReservationDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            /**
             * close result set, prepared statement and connection by
             * corresponding order
             */
        } finally {
            this.closeResultSet(rs);
            this.closePreparedStatement(ps);
            this.closeConnection(con);
        }
        return result;
    }
}
