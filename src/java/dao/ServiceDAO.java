/*
 * Copyright(C) 20022, FPT University
 * CMS:
 * Clinic Management System
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-02-08      1.0                 TrangCT          Service DAO
 */
package dao;

import entity.Pagination;
import entity.Service;

/**
 * <h1>Service DAO</h1>
 * Interface ServiceDAO. Method access and return data. Its method is implements by ServiceDAOIpml class
 * <p>
 * 
 * 
 * @author TrangCT
 * @version 1.0
 * @since 2022-02-08
 */
public interface ServiceDAO {
  
    /**
     * Get all services
     * @param pageIndex
     * @param pageSize
     * @return list services
     */
    Pagination<Service> getAllService(int pageIndex, int pageSize);
    
    /**
     * Count total service
     * @return total service
     */
    int count();
    
    /**
     * Get service by id
     * @param id
     * @return service
     */
    Service getById(int id);
}
