
import java.time.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
// Initial example from: https://www.javatpoint.com/java-localdatetime
// Documentation: https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/time/LocalDateTime.html
public class DateTimeStuff {
public static void main(String[] args) {
LocalDateTime myDate = LocalDateTime.now();
System.out.println("Before Formatting: " + myDate);
DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
String formatDateTime = myDate.format(format);
System.out.println("After Formatting: " + formatDateTime); // Often though we need something with a timezone... Let's check out the documentation:
// Also - want to print all the ids? Check out this HashMap Code:
// https://mkyong.com/java8/java-display-all-zoneid-and-its-utc-offset/
ZonedDateTime zmyDate = myDate.atZone(ZoneId.of("Canada/Atlantic"));
System.out.println(zmyDate.toEpochSecond());
System.out.println(zmyDate);
System.out.println(zmyDate.withZoneSameInstant(ZoneOffset.of("-06:00")));
}
}

