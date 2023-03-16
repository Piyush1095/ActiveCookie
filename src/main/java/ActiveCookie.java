import Model.Cookies;
import service.CookieImpl;

import java.time.LocalDate;
import java.util.Map;

public class ActiveCookie {
    public static void main(String[] args) throws Exception {
        CookieImpl cookieImpl =new CookieImpl();
        Cookies cookies=new Cookies();
        // parsing command-line arguments
        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-f")) {
                cookies.setFileName(args[++i]);
            } else if (args[i].equals("-d")) {
                cookies.setDate(LocalDate.parse(args[++i]));
            }
        }
        if(cookieImpl.checkNull(cookies))
        {
            Map<String, Integer> cookieMap= cookieImpl.cookieMap(cookies);
            String mostActiveCookie= cookieImpl.getmostActiveCookie(cookieMap);
            cookieImpl.displayMostActiveCookie(mostActiveCookie);
        }
    }
}
