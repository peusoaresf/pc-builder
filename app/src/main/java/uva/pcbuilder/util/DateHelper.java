package uva.pcbuilder.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by peuso on 02/11/2016.
 */

public class DateHelper {
    // Classe para auxiliar nas instancias de datas
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private DateHelper() {}
    public static Date stringToDate(String inputDate) {
        Date d = null;
        try {
            d = simpleDateFormat.parse(inputDate);
        } catch (ParseException e) {
            System.out.println("Erro ao parsear data inserida!");
        }
        return d;
    }
    public static String dateToString(Date inputDate) {
        return simpleDateFormat.format(inputDate);
    }
    public static Date nowToDate() {
        Date d = stringToDate(simpleDateFormat.format(new Date()));
        return d;
    }
    public static String nowToString() {
        String s = dateToString(new Date());
        return s;
    }
}
