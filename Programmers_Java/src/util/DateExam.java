package util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExam {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date.toString());

        SimpleDateFormat ft = new SimpleDateFormat("yyyy.MM.dd 'at' hh:mm:ss a zzz");

        System.out.println(ft.format(date));

        System.out.println(date.getTime());

        long today = System.currentTimeMillis();
        System.out.println(today);

        System.out.println(today - date.getTime());
    }
}
