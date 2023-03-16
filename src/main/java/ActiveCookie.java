import Model.Cookies;
import service.CookieImpl;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public class ActiveCookie {
    public static void main(String[] args) throws Exception {
        CookieImpl cookieImpl =new CookieImpl();
        Cookies cookies=cookieImpl.getCookies(args);
        if(cookieImpl.checkNull(cookies))
        {
            Map<String, Integer> cookieMap= cookieImpl.cookieMap(cookies);
            List<String> mostActiveCookie= cookieImpl.getmostActiveCookie(cookieMap);
            cookieImpl.displayMostActiveCookie(mostActiveCookie);
        }
    }
}
