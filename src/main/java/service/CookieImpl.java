package service;

import Model.Cookies;
import exception.CookieException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;


public class CookieImpl implements Cookie{
    Logger logger = Logger.getLogger(String.valueOf(CookieImpl.class));

    // parsing command-line arguments
    @Override
    public Cookies getCookies(String[] args) {
        Cookies cookies=new Cookies();
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
        if (cookie.getFileName().isEmpty() || cookie.getDate() == null) {
            System.err.println("Usage: java MostActiveCookie -f <filename> -d <date>");
            return false;
        }
        return true;
    }

    // reading log file
    @Override
    public Map<String, Integer> cookieMap(Cookies cookie) throws CookieException {
        Map<String, Integer> cookieMap = new HashMap<String, Integer>();
        BufferedReader br = null;
        try {
                br = new BufferedReader(new FileReader(cookie.getFileName()));
                String line;
                    while ((line = br.readLine()) != null) {
                    String[] fields = line.split(",");
                    String cookieStr = fields[0].trim();
                    LocalDate logDate = LocalDate.parse(fields[1].trim().substring(0, 10));
                    Date.from(logDate.atStartOfDay().toInstant(ZoneOffset.UTC));
                        if (logDate.isEqual(cookie.getDate())) {
                        cookieMap.put(cookieStr, cookieMap.getOrDefault(cookieStr, 0) + 1);
                    }
                }
                br.close();
        } catch (IOException e) {
            throw new CookieException("wrong input file is provided");
        }
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
        if (mostActiveCookie.size() == 0) {
            logger.info("No cookies found for the given date.");
        } else{
           for (String entity:mostActiveCookie)
           {
               logger.info(entity);
           }
        }
    }

}
