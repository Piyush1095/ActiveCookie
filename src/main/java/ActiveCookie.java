import Model.Cookies;
import service.CookieImpl;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class ActiveCookie {
    public static void main(String[] args) throws Exception {
        Logger logger = Logger.getLogger(String.valueOf(CookieImpl.class));
        CookieImpl cookieImpl =new CookieImpl();
        Cookies cookies=cookieImpl.getCookies(args);
        List<String> mostActiveCookie=null;
        if(cookieImpl.checkNull(cookies))
        {
            Map<String, Integer> cookieMap= cookieImpl.cookieMap(cookies);
            if(cookieMap.size()!=0) {
              mostActiveCookie = cookieImpl.getListOfMostActiveCookie(cookieMap);
            }
            if (mostActiveCookie!=null) {
                cookieImpl.displayMostActiveCookie(mostActiveCookie);
            }else
            {
                logger.info("No cookies found for the given date.");
            }
        }
    }
}
