package br.com.smart_br.consulta_cpnj.commons;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Commons {
    public static String parseDate(String format, Date value) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        return formatter.format(value);
    }

    public static Date parseDate(String format, String value) {
        SimpleDateFormat formatter = new SimpleDateFormat(format);
        try {
            return formatter.parse(value);
        } catch (ParseException e) { }
        return null;
    }
}
