/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

/**
 *
 * @author Thanh Tung
 */
public class TimeTableHtmlHelper {

    public static String addRow(int index, int cellCount) {
        String result = "";
        result += "<tr>\n"
                + "                                    <td class=\"bg-light text-dark\">" + index + ":00</td>\n";
        for (int i = 0; i < cellCount; i++) {
            result += addDisabledCell(index, "00");
        }
        result += "                                </tr>\n"
                + "<tr>\n"
                + "                                    <td class=\"bg-white text-dark\">15</td>\n";
        for (int i = 0; i < cellCount; i++) {
            result += addCell(index, "15");
        }
        result += "                                </tr>\n"
                + "<tr>\n"
                + "                                    <td class=\"bg-white text-dark\">30</td>\n";
        for (int i = 0; i < cellCount; i++) {
            result += addCell(index, "30");
        }
        result += "                                </tr>\n"
                + "<tr>\n"
                + "                                    <td class=\"bg-white text-dark\">45</td>\n";
        for (int i = 0; i < cellCount; i++) {
            result += addCell(index, "45");
        }
        result += "                                </tr>\n"
                + "<tr>\n"
                + "                                    <td class=\"bg-white text-dark\">60</td>\n";
        for (int i = 0; i < cellCount; i++) {
            result += addCell(index + 1, "00");
        }
        return result;
    }

    public static String addDisabledRow(int index, int cellCount) {
        String result = "";
        result += "<tr>\n"
                + "                                    <td class=\"bg-light text-dark\">" + index + ":00</td>\n";
        for (int i = 0; i < cellCount; i++) {
            result += addDisabledCell(index, "00");
        }
        result += "                                </tr>\n"
                + "<tr>\n"
                + "                                    <td class=\"bg-light text-dark\">15</td>\n";
        for (int i = 0; i < cellCount; i++) {
            result += addDisabledCell(index, "15");
        }
        result += "                                </tr>\n"
                + "<tr>\n"
                + "                                    <td class=\"bg-light text-dark\">30</td>\n";
        for (int i = 0; i < cellCount; i++) {
            result += addDisabledCell(index, "30");
        }
        result += "                                </tr>\n"
                + "<tr>\n"
                + "                                    <td class=\"bg-light text-dark\">45</td>\n";
        for (int i = 0; i < cellCount; i++) {
            result += addDisabledCell(index, "45");
        }
        result += "                                </tr>\n"
                + "<tr>\n"
                + "                                    <td class=\"bg-light text-dark\">60</td>\n";
        for (int i = 0; i < cellCount; i++) {
            result += addDisabledCell(index + 1, "00");
        }
        return result;
    }

    public static String addCell(int index, String durationValue) {
        return "                                    <td class=\"bg-white text-secondary\">" + index + ":" + durationValue + "</td>\n";
    }

    public static String addDisabledCell(int index, String durationValue) {
        return "                                    <td class=\"bg-light text-secondary\">" + index + ":" + durationValue + "</td>\n";
    }

    public static String renderTimeRow(int startTime, int endTime, int cellCount) {
        String result = "";
        for (int i = startTime; i <= endTime; i++) {
            if (i != 12) {
                result += addRow(i, cellCount);
            } else {
                result += addDisabledRow(i, cellCount);
            }
        }
        return result;
    }
}
