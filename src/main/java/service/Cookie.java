package service;

import Model.Cookies;
import java.io.IOException;
import java.util.Map;

public interface Cookie {
    Boolean checkNull(Cookies cookie);
    Map<String, Integer> cookieMap(Cookies cookie) throws IOException;
    String getmostActiveCookie(Map<String, Integer> cookieMap);
    void displayMostActiveCookie(String mostActiveCookie);
}
