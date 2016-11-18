package zajecia_18XI;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/**
 * Created on 18.11.16, at 19:04
 */
public class A {
    public static void main(String[] args) {
        Instant instant = Instant.now();
        System.out.println(instant);

        System.out.println("-------------------");

        ZoneId.getAvailableZoneIds().forEach(System.out::println);

        System.out.println("-----------------");

//        System.out.println(ZonedDateTime.ofInstant(instant, ZoneId.systemDefault()));
//        System.out.println(ZonedDateTime.ofInstant(instant, ZoneId.of("Europe/London")));
        ZonedDateTime zdt = ZonedDateTime.ofInstant(instant, ZoneId.of("Europe/Prague"));
        System.out.println(DateTimeFormatter.ofPattern("yyyy/MMM/dd HH:mm:ss").format(zdt));
//
//        Instant later = instant.plus(5, ChronoUnit.DAYS);
//        System.out.println(later);


    }
}
