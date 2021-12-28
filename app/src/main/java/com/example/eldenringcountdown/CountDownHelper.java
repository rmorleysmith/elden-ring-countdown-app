package com.example.eldenringcountdown;

import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class CountDownHelper {

    private static final long RELEASE_DATE_EPOCH = 1645747200;

    public static String getRemainingTimeAsText(long epochNow) {
        long remainingSeconds = RELEASE_DATE_EPOCH - epochNow;
        long daysUntilRelease, hoursUntilRelease, minutesUntilRelease, secondsUntilRelease;

        daysUntilRelease = getDaysFromSeconds(remainingSeconds);
        remainingSeconds = getRemainingSecondsAfterDays(daysUntilRelease, remainingSeconds);

        hoursUntilRelease = getHoursFromSeconds(remainingSeconds);
        remainingSeconds = getRemainingSecondsAfterHours(hoursUntilRelease, remainingSeconds);

        minutesUntilRelease = getMinutesFromSeconds(remainingSeconds);
        remainingSeconds = getRemainingSecondsAfterMinutes(minutesUntilRelease, remainingSeconds);

        secondsUntilRelease = remainingSeconds;

        return String.format(Locale.ENGLISH, "%d:%02d:%02d:%02d", daysUntilRelease, hoursUntilRelease, minutesUntilRelease, secondsUntilRelease);
    }

    private static long getDaysFromSeconds(long seconds) {
        return TimeUnit.SECONDS.toDays(seconds);
    }

    private static long getRemainingSecondsAfterDays(long days, long seconds) {
        return seconds - TimeUnit.DAYS.toSeconds(days);
    }

    private static long getHoursFromSeconds(long seconds) {
        return TimeUnit.SECONDS.toHours(seconds);
    }

    private static long getRemainingSecondsAfterHours(long hours, long seconds) {
        return seconds - TimeUnit.HOURS.toSeconds(hours);
    }

    private static long getMinutesFromSeconds(long seconds) {
        return TimeUnit.SECONDS.toMinutes(seconds);
    }

    private static long getRemainingSecondsAfterMinutes(long minutes, long seconds) {
        return seconds - TimeUnit.MINUTES.toSeconds(minutes);
    }

}
