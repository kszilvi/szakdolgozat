package Helper;

import org.testng.Assert;

import javax.mail.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

public class Helper {

    private String latestTimestamp;

    public String getCurrentTimestampForDate2() {
        return new SimpleDateFormat("dd MMM yyyy hh:mm:ss").format(System.currentTimeMillis());
    }

    public String getLatestTimestamp(){
        return latestTimestamp;
    }

    public String getCurrentDay() {
        return new SimpleDateFormat("d MMM yyyy").format(System.currentTimeMillis());
    }

    public LocalDateTime getTimeStampPlusXMinutes(int minutes) {
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime plusMinutes = today.plusMinutes(minutes);
        return LocalDateTime.from(plusMinutes);
    }

    public LocalDate dateConverterFromStringToLocalDate(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d MMM yyyy");
        return LocalDate.parse(date, formatter);
    }

    public String convertLocalDateTimeToStringOnlyHours(LocalDateTime date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("h:mma");
        return date.format(formatter).toLowerCase();
    }

    private String convertLocalDateTimeToStringWithYears(LocalDateTime date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE d MMM yyyy");
        return date.format(formatter);
    }

    private Store connect(Properties prop) throws MessagingException {
        Session session = Session.getDefaultInstance(prop, null);
        Store store = session.getStore("imaps");
        store.connect("smtp.gmail.com", "calendartesting12358@gmail.com", "_ZD8:t9Q");
        return store;
    }

    private boolean searchMessageFromTitleWAndSenderWithRetry(Folder folder, String title, int retryCount, String sender) throws MessagingException, InterruptedException {
        int retryCounter = 0;
        folder.open(Folder.READ_WRITE);
        Message[] messages = folder.getMessages();
        boolean isMatch = false;

        while (messages == null || messages.length == 0 || retryCounter != retryCount) {
            Thread.sleep(5000);
            messages = folder.getMessages();
            retryCounter++;
        }

        for (Message message : messages) {
            if (title.equals(message.getSubject()) && sender.equals(message.getFrom()[0].toString())) {
                isMatch = true;
                break;
            }
        }
        return isMatch;
    }

    public void isEmailMatch(Properties prop, String name, String emailAddress) throws MessagingException, InterruptedException {
        Assert.assertTrue(searchMessageFromTitleWAndSenderWithRetry(connect(prop).getFolder("inbox"),
                subject(name, emailAddress), 5, senderAddress()));
    }

    private String getTimeZone() {
        return new SimpleDateFormat("z").format(System.currentTimeMillis());
    }

    private String senderAddress() {
        return "Google Calendar <calendar-notification@google.com>";
    }

    public String subject(String eventName, String emailAddress) {
        return "Notification: " + eventName + " - " + latestTimestamp + " @ " + convertLocalDateTimeToStringWithYears(getTimeStampPlusXMinutes(10)) + " " +
                convertLocalDateTimeToStringOnlyHours(getTimeStampPlusXMinutes(10)) +
                " (" + getTimeZone() + ")" + " (" + emailAddress + ")";
    }
}
