package time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class TimeExam {
    public static void main(String[] args) {
        LocalDateTime timePoint = LocalDateTime.now();
        System.out.println(timePoint);

        LocalDate ld1 = LocalDate.of(2022, Month.DECEMBER, 12);
        System.out.println(ld1);

        LocalTime lt1 = LocalTime.of(22, 22);
        System.out.println(lt1);

        LocalTime lt2 = LocalTime.parse("10:15:32");
        System.out.println(lt2);

        LocalDate theDate = timePoint.toLocalDate();
        System.out.println(theDate);
        Month month = timePoint.getMonth();
        System.out.println(timePoint.getMonth());
        System.out.println(month.getValue());
        System.out.println(timePoint.getMonthValue());
        System.out.println(timePoint.getHour());
    }
}
