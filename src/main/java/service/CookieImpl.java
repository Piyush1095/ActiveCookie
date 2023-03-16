package service;

import Model.Cookies;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class CookieImpl implements Cookie{

    @Override
    public Cookies getCookies(String[] args) {
        Cookies cookies=new Cookies();
        // parsing command-line arguments
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-f")) {
                cookies.setFileName(args[++i]);
            } else if (args[i].equals("-d")) {
                cookies.setDate(LocalDate.parse(args[++i]));
            }
        }
        return cookies;
    }

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
    public List<String>  getmostActiveCookie(Map<String, Integer> cookieMap) {
        int maxValue = Collections.max(cookieMap.values());

        List<String> maxValueKeys = cookieMap.entrySet().stream()
                .filter(entry -> entry.getValue() == maxValue)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        return maxValueKeys;
    }

    @Override
    public void displayMostActiveCookie(List<String> mostActiveCookie) {
        if (mostActiveCookie == null) {
            System.out.println("No cookies found for the given date.");
        } else{
           for (String entity:mostActiveCookie)
           {
               System.out.println(entity);
           }
        }
    }

}
