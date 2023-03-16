package Model;

import java.time.LocalDate;
public class Cookies {
    private  String fileName;
    private LocalDate date;

    public Cookies() {
        fileName="";
        date=null;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getFileName() {
        return fileName;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

}
