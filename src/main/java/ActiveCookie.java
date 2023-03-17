import Model.Cookies;
import service.CookieImpl;
import java.util.List;
import java.util.Map;

public class ActiveCookie {
    public static void main(String[] args) throws Exception {
        CookieImpl cookieImpl =new CookieImpl();
        Cookies cookies=cookieImpl.getCookies(args);
        List<String> mostActiveCookie=null;
        if(cookieImpl.checkNull(cookies))
        {
            Map<String, Integer> cookieMap= cookieImpl.cookieMap(cookies);
            if(cookieMap.size()!=0) {
              mostActiveCookie = cookieImpl.getmostActiveCookie(cookieMap);
            }
            cookieImpl.displayMostActiveCookie(mostActiveCookie);
        }
    }
}
