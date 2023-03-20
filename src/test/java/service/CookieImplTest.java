package service;

import Model.Cookies;
import exception.CookieException;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class CookieImplTest {

    CookieImpl cookieImpl=new CookieImpl();

    @Test
    public void getCookiesTest()
    {
        String[] args = {"-f", "cookie_log.csv", "-d", "2018-12-09"};
        Cookies cookies=cookieImpl.getCookies(args);
        assertEquals("cookie_log.csv", cookies.getFileName());
        assertEquals(LocalDate.parse("2018-12-09"), cookies.getDate());
    }


    @Test
    public void testCheckNullTrue()
    {
        Cookies cookies= new Cookies();
        cookies.setDate(LocalDate.parse("2018-12-09"));
        cookies.setFileName("cookie_log.csv");
        assertEquals(true,  cookieImpl.checkNull(cookies));
    }

    @Test
    public void testCheckNullFalse()
    {
        Cookies cookies= new Cookies();
        assertEquals(false,  cookieImpl.checkNull(cookies));
    }

    @Test
    public void testCookieMap() throws CookieException {
        Cookies cookies= new Cookies();
        LocalDate date = LocalDate.parse("2018-12-09T06:19:00+00:00".trim().substring(0, 10));
        cookies.setDate(date);
        cookies.setFileName("src/main/java/cookie_log.csv");
        Map<String, Integer> map= cookieImpl.cookieMap(cookies);
        assertEquals(map.get("AtY0laUfhglK3lC7").toString(), "2");
    }

    @Test
    public void getmostActiveCookieTest(){
        Map<String, Integer> cookieMap = new HashMap<String, Integer>();
        cookieMap.put("AtY0laUfhglK3lC7",2);
        cookieMap.put("AtY0laUfhglK3lC8",3);
        cookieMap.put("AtY0laUfhglK3lC9",1);
        List<String> strCookies= cookieImpl.getmostActiveCookie(cookieMap);
        assertEquals(strCookies.contains("AtY0laUfhglK3lC8"), true);
    }
    @Test
    public void testDisplayMostActiveCookie(){
        List<String> listMostActiveCookies=new ArrayList<>();
        listMostActiveCookies.add("AtY0laUfhglK3lC7");
        listMostActiveCookies.add("AtY0laUfhglK3lC9");
        cookieImpl.displayMostActiveCookie(listMostActiveCookies);
    }

    @Test
    public void testDisplayMostActiveCookieNull(){
        List<String> listMostActiveCookies=new ArrayList<>();
        cookieImpl.displayMostActiveCookie(listMostActiveCookies);
    }

    @Test(expected=CookieException.class)
    public void testCookieMapException() throws CookieException {
        Cookies cookies= new Cookies();
        LocalDate date = LocalDate.parse("2018-12-09T06:19:00+00:00".trim().substring(0, 10));
        cookies.setDate(date);
        cookies.setFileName("wrongpath");
        Map<String, Integer> map= cookieImpl.cookieMap(cookies);
        assertEquals("AtY0laUfhglK3lC7", map);

    }

}
