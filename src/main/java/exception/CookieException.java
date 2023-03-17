package exception;

import java.io.IOException;

public class CookieException extends IOException {
    public CookieException(String message)
    {
        super(message);
    }
}
