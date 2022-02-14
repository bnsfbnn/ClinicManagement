/*
 * Copyright(C) 2022, FPT University
 * CMS
 * CLINIC MANAGEMENT SYSTEM
 *
 * Record of change:
 * DATE            Version             AUTHOR           DESCRIPTION
 * 2022-02-08      1.0                 tungnt           First Implement 
 */
package util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class include utility methods
 * 
 * @author Thanh Tung
 */
public class Utils {

    /**
     * - Get today date
     *
     * @return a <code>String</code> objects.
     */
    public static String getToday() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String date = formatter.format(new Date());
        return date;
    }
}
