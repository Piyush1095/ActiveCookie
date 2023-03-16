package service;

import Model.Cookies;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class CookieImpl implements Cookie{

    @Override
    public Boolean checkNull(Cookies cookie) {
        // validating input parameters
        if (cookie.getFileName().isEmpty() || cookie.getDate() == null) {
            System.err.println("Usage: java MostActiveCookie -f <filename> -d <date>");
            System.exit(1);
            return false;
        }
        return true;
    }

    @Override
    public Map<String, Integer> cookieMap(Cookies cookie) throws IOException {
        Map<String, Integer> cookieMap = new HashMap<String, Integer>();
        // reading log file
        BufferedReader br = new BufferedReader(new FileReader(cookie.getFileName()));
        String line;
        while ((line = br.readLine()) != null) {
            String[] fields = line.split(",");
            String cookieStr = fields[0].trim();
            LocalDate logDate = LocalDate.parse(fields[1].trim().substring(0, 10));
            if (logDate.isEqual(cookie.getDate())) {
                cookieMap.put(cookieStr, cookieMap.getOrDefault(cookieStr, 0) + 1);
            }
        }
        br.close();
        return cookieMap;
    }

    @Override
    public String getmostActiveCookie(Map<String, Integer> cookieMap) {
        String mostActiveCookie = null;
        int maxCount = 0;
        System.out.println(cookieMap);
        for (Map.Entry<String, Integer> entry : cookieMap.entrySet()) {
            System.out.println(entry);
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostActiveCookie = entry.getKey();
            }
        }

        return mostActiveCookie;
    }

    @Override
    public void displayMostActiveCookie(String mostActiveCookie) {
        if (mostActiveCookie == null) {
            System.out.println("No cookies found for the given date.");
        } else {
            System.out.println(mostActiveCookie);
        }
    }

}
