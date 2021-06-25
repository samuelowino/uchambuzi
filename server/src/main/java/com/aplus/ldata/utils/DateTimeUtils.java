package com.aplus.ldata.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/**
 * Class that deals with java.date.* stuff that don't
 * work. like date.before and date.after and sdf.parse
 * and all the other stuff @Jame Gosling @author of java.uti.Date.* and java.util.Calendar.*
 * messed up!
 *
 * @author Samuel Owino
 * @contact samuelowino43@gmail.com
 */
public class DateTimeUtils {

    public static final String SIMPLE_DATE_FORMAT = "yyyy.MM.dd HH:mm:ss";
    public static final String SIMPLE_TIMESTAMP_DATE_FORMAT = "yyyy.MM.dd HH:mm:ss";

    public static List<LocalDate> handleDetermineNext7Days(LocalDate startDate) {
        List<LocalDate> next7Days = new ArrayList<>();
        for (int i = 0; i <= 6; i++) {
            LocalDate rollbackDate = DateTimeUtils.getDateOnDaysRolledForward(startDate, i);
            next7Days.add(rollbackDate);
        }
        return next7Days;
    }

    public static LocalDate rollBackByDayOfMonth(LocalDate startDate, int rollAmount) {
        boolean isLastMonth = startDate.getDayOfMonth() < 7;
        rollAmount = rollAmount - 1;
        LocalDate rolledDate = startDate.minusDays(rollAmount);
        if (isLastMonth) {
            rolledDate = rolledDate.plusMonths(1);
            rolledDate = rolledDate.minusMonths(1);
        }
        return rolledDate;
    }

    public static LocalDate getDateOnDaysRolledForward(LocalDate startDate, int forwardingDays) {
        return startDate.plusDays(forwardingDays);
    }

    public static LocalDate getDateOnDaysRolledBack(LocalDate startDate, int rollbackDays) {
        return startDate.minusDays(rollbackDays);
    }

    public static boolean beforeToday(Date date) {
        Date today = Calendar.getInstance().getTime();
        return date.before(today);
    }

    public static String getTodayLabel() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd, yyyy", Locale.getDefault());
        Calendar calendar = Calendar.getInstance();
        return dateFormat.format(calendar.getTime());
    }

    public static String getTomorrowLabel() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEE MMM dd, yyyy", Locale.getDefault());
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        return dateFormat.format(calendar.getTime());
    }

    public static int isBefore(Date initialDate, Date nextDate) {

        Calendar initialCalendar = Calendar.getInstance();
        initialCalendar.setTime(initialDate);
        Calendar nextCalendar = Calendar.getInstance();
        nextCalendar.setTime(nextDate);

        if (initialCalendar.get(Calendar.YEAR) < nextCalendar.get(Calendar.YEAR)) {
            return 1;
        }

        if (initialCalendar.get(Calendar.MONTH) < nextCalendar.get(Calendar.MONTH)) {
            return 1;
        }

        if (initialCalendar.get(Calendar.DAY_OF_MONTH) < nextCalendar.get(Calendar.DAY_OF_MONTH)) {
            return 1;
        }

        if (initialCalendar.get(Calendar.HOUR_OF_DAY) < nextCalendar.get(Calendar.HOUR_OF_DAY)) {
            return 1;
        }

        if (initialCalendar.get(Calendar.MINUTE) < nextCalendar.get(Calendar.MINUTE)) {
            return 1;
        }


        return 0;
    }

    public static boolean isBeforeNow(Date date) {
        Calendar calendar = Calendar.getInstance();
        Calendar calendarDate = Calendar.getInstance();
        calendarDate.setTime(date);

        int nowHour = calendar.get(Calendar.HOUR_OF_DAY);
        int nowMinute = calendar.get(Calendar.MINUTE);

        int dateHour = calendarDate.get(Calendar.HOUR_OF_DAY);
        int dateMinute = calendarDate.get(Calendar.MINUTE);

        if (nowHour > dateHour) {
            return true;
        }

        if (nowHour == dateHour) {
            return nowMinute > dateMinute;
        }

        return false;
    }

    public static boolean isAfterToday(Date date) {
        Date today = Calendar.getInstance().getTime();
        return date.after(today);
    }

    public static boolean isToday(Date date) {
        Calendar calendarDate = Calendar.getInstance();
        calendarDate.setTime(date);
        Calendar calendarToday = Calendar.getInstance();

        int month = calendarToday.get(Calendar.MONTH);
        int year = calendarToday.get(Calendar.YEAR);
        int dayOfMonth = calendarToday.get(Calendar.DAY_OF_MONTH);

        int dateMonth = calendarDate.get(Calendar.MONTH);
        int dateYear = calendarDate.get(Calendar.YEAR);
        int dateDayOfMonth = calendarDate.get(Calendar.DAY_OF_MONTH);

        return month == dateMonth && year == dateYear && dayOfMonth == dateDayOfMonth;

    }

    public static Date parseDateString(String parsableDate) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE MMM dd, yyyy", Locale.getDefault());
            simpleDateFormat.setLenient(false);
            return simpleDateFormat.parse(parsableDate);
        } catch (Exception ex) {
            return null;
        }
    }

    public static Date parseDateLong(long parsableDate) {
        Date date = new Date();
        date.setTime(parsableDate);

        return date;
    }

    public static boolean isBeforeToday(Date date) {
        Calendar todayCalendar = Calendar.getInstance();
        Calendar calendarDate = Calendar.getInstance();
        calendarDate.setTime(date);

        int month = calendarDate.get(Calendar.MONTH);
        int year = calendarDate.get(Calendar.YEAR);
        int dayOfMonth = calendarDate.get(Calendar.DAY_OF_MONTH);

        int todayMonth = todayCalendar.get(Calendar.MONTH);
        int todayYear = todayCalendar.get(Calendar.YEAR);
        int today = todayCalendar.get(Calendar.DAY_OF_MONTH);

        if (todayYear > year) {
            return true;
        }

        if (todayYear < year) {
            return false;
        }

        if (todayMonth > month) {
            return true;
        }

        if (todayMonth < month) {
            return false;
        }

        if (today > dayOfMonth) {
            return true;
        }

        if (today < dayOfMonth) {
            return false;
        }

        return false;
    }

    public static Calendar getMinutesFromNow(Calendar currentTime, int minutes) {
        currentTime.add(Calendar.MINUTE, minutes);
        return currentTime;
    }

    private static String formartMinute(int minute) {
        switch (minute) {
            case 0:
                return "00";
            case 1:
                return "01";
            case 2:
                return "02";
            case 3:
                return "03";
            case 4:
                return "04";
            case 5:
                return "05";
            case 6:
                return "06";
            case 7:
                return "07";
            case 8:
                return "08";
            case 9:
                return "09";
            default:
                return Integer.toString(minute);
        }
    }

    public static String getDayofWeek(int dayOfWeekIndex) {
        switch (dayOfWeekIndex) {
            case 1:
                return "Mon";
            case 2:
                return "Tue";
            case 3:
                return "Wed";
            case 4:
                return "Thu";
            case 5:
                return "Fri";
            case 6:
                return "Sat";
            case 7:
            case 0:
                return "Sun";
            default:
                return "N/A";
        }
    }

    public static Date localToGMT(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.getDefault());
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
        Date gmt = new Date(sdf.format(date));
        return gmt;
    }

    public static Date gmtToLocalDate(Date date) {
        String timeZone = Calendar.getInstance().getTimeZone().getID();
        Date local = new Date(date.getTime() + TimeZone.getTimeZone(timeZone).getOffset(date.getTime()));
        return local;
    }

    public static boolean isSameDay(Date firstEntry, Date secondEntry) {
        Calendar entry1 = Calendar.getInstance();
        entry1.setTime(firstEntry);
        Calendar entry2 = Calendar.getInstance();
        entry2.setTime(secondEntry);

        if (entry1.get(Calendar.YEAR) != entry2.get(Calendar.YEAR))
            return false;

        if (entry1.get(Calendar.MONTH) != entry2.get(Calendar.MONTH))
            return false;

        if (entry1.get(Calendar.DAY_OF_MONTH) != entry2.get(Calendar.DAY_OF_MONTH))
            return false;

        return true;
    }

    public static boolean isInDateRange(Calendar startDate, Calendar endDate, Calendar selectedDate) {
        int selectedYear = selectedDate.get(Calendar.YEAR);
        int startYear = startDate.get(Calendar.YEAR);
        int endYear = endDate.get(Calendar.YEAR);

        int selectedMonth = selectedDate.get(Calendar.MONTH);
        int startMonth = startDate.get(Calendar.MONTH);
        int endMonth = endDate.get(Calendar.MONTH);

        int selectedDayOfMonth = selectedDate.get(Calendar.DAY_OF_MONTH);
        int startDayOfMonth = startDate.get(Calendar.DAY_OF_MONTH);
        int endDayOfMonth = endDate.get(Calendar.DAY_OF_MONTH);


        if (!(startYear <= selectedYear && selectedYear <= endYear)) {
            return false;
        }

        if (startYear == endYear) {

            if (!(startMonth <= selectedMonth && selectedMonth <= endMonth)) {
                return false;
            }

            if (startMonth == selectedMonth) {
                if (!(startDayOfMonth <= selectedDayOfMonth && selectedDayOfMonth <= endDayOfMonth)) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean isEveningHours(int hourOfDay) {
        if (hourOfDay > 15)
            return true;
        else
            return false;
    }

    public static boolean isMorningHours(int hourOfDay) {
        if (hourOfDay < 12)
            return true;
        else
            return false;
    }

    public static boolean isAfternoonHours(int hourOfDay) {
        if (hourOfDay > 12 && hourOfDay < 16)
            return true;
        else
            return false;
    }

    /**
     * Time travel;forward time by hours
     *
     * @param calendarTime-Calendar
     * @return newTimeValue-Calendar
     */
    public static Calendar forwardTimeMinutes(Calendar calendarTime, int minutes) {
        calendarTime.set(Calendar.MINUTE, calendarTime.get(Calendar.MINUTE) + minutes);
        return calendarTime;
    }

    public static String convertDateToString(Calendar calendar) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(SIMPLE_DATE_FORMAT, Locale.getDefault());
        return simpleDateFormat.format(calendar.getTime());
    }

    public static String convertDateToTimeStampString(Calendar calendar) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(SIMPLE_TIMESTAMP_DATE_FORMAT, Locale.getDefault());
        return simpleDateFormat.format(calendar.getTime());
    }

    public static String convertDateToString(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(SIMPLE_DATE_FORMAT, Locale.getDefault());
        return simpleDateFormat.format(calendar.getTime());
    }

    public static Calendar convertSimpleDateTimeStringToCalendarDate(String dateTimeString) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(SIMPLE_DATE_FORMAT, Locale.getDefault());
        try {
            Calendar calendar = Calendar.getInstance();
            Date date = simpleDateFormat.parse(dateTimeString);
            if (date == null) {
                throw new AssertionError("convertSimpleDateTimeStringToCalendarDate: failed date return is null");
            } else
                calendar.setTime(date);

            return calendar;
        } catch (ParseException e) {
            long numberFormatedDateTime = Long.parseLong(dateTimeString);
            Date date = new Date(numberFormatedDateTime);
            String formatedDateTime = simpleDateFormat.format(date);
            return convertSimpleDateTimeStringToCalendarDate(formatedDateTime);
        }
    }

    public static Date convertSimpleDateTimeStringToDate(String dateTimeString) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(SIMPLE_DATE_FORMAT, Locale.getDefault());
        try {
            Calendar calendar = Calendar.getInstance();
            Date date = simpleDateFormat.parse(dateTimeString);
            if (date == null) {
                throw new AssertionError("convertSimpleDateTimeStringToCalendarDate: failed date return is null");
            } else
                calendar.setTime(date);

            return calendar.getTime();
        } catch (ParseException e) {
            long numberFormatedDateTime = Long.parseLong(dateTimeString);
            Date date = new Date(numberFormatedDateTime);
            String formatedDateTime = simpleDateFormat.format(date);
            return convertSimpleDateTimeStringToDate(formatedDateTime);
        }
    }

    public static List<Calendar> determineLastSevenDaysCalendar() {
        List<Calendar> dates = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        int startDate = calendar.get(Calendar.DAY_OF_MONTH) - 7;
        for (int i = 0; i <= 7; i++) {
            Calendar instance = Calendar.getInstance();
            instance.set(Calendar.DAY_OF_MONTH, startDate);
            dates.add(instance);
            startDate++;
        }

        return dates;
    }

    public static List<Calendar> determineCalendarMonthDates(int month) {
        List<Calendar> dates = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.MONTH, (month - 1));

        int startDate = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        int maxDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        for (int monthDate = maxDays; monthDate >= 1; monthDate--) {
            Calendar instance = Calendar.getInstance();
            instance.set(Calendar.MONTH, (month - 1));
            instance.set(Calendar.DAY_OF_MONTH, startDate);
            dates.add(instance);

            if (startDate == -1) {
                break;
            } else
                startDate--;
        }
        return dates;
    }

    public static LocalDate getEarliestDate(List<LocalDate> pastCycleDates) {
        LocalDate earliestDate = pastCycleDates.get(pastCycleDates.size() - 1);
        for (int i = 0; i < pastCycleDates.size(); i++) {
            int previousIndex = i - 1;
            if (previousIndex < 0) previousIndex = 0;
            if (pastCycleDates.get(i).isBefore(pastCycleDates.get(previousIndex))) {
                earliestDate = pastCycleDates.get(i);
            }
        }
        return earliestDate;
    }

    public static LocalDate getLatestDate(List<LocalDate> pastCycleDates) {
        LocalDate latestDate = pastCycleDates.get(0);
        for (int i = 0; i < pastCycleDates.size(); i++) {
            int previousIndex = i - 1;
            if (previousIndex < 0) previousIndex = 0;
            if (pastCycleDates.get(i).isAfter(pastCycleDates.get(previousIndex))) {
                latestDate = pastCycleDates.get(i);
            }
        }
        return latestDate;
    }
}
