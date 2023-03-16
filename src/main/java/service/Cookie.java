package service;

import Model.Cookies;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface Cookie {
    Cookies getCookies(String [] arg);
    Boolean checkNull(Cookies cookie);
    Map<String, Integer> cookieMap(Cookies cookie) throws IOException;
    List<String> getmostActiveCookie(Map<String, Integer> cookieMap);
    void displayMostActiveCookie(List<String> mostActiveCookie);
}
