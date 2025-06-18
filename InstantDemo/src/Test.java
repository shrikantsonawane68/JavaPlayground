import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class Test {
    public static void main(String[] args) {


        TimeZone utcTimeZone = TimeZone.getTimeZone("UTC");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        sdf.setTimeZone(utcTimeZone);
        Calendar currentDate = Calendar.getInstance();
        currentDate.setTimeZone(utcTimeZone);
        currentDate.setTime(new Date());
        System.out.println(sdf.format(currentDate.getTime()));
        checkBusinessDay1(currentDate);


    }

    private static void checkBusinessDay1(Calendar date) {
        TimeZone cstTimeZone = TimeZone.getTimeZone("CST");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        sdf.setTimeZone(cstTimeZone);
        Calendar currentDate = Calendar.getInstance();
        currentDate.setTimeZone(cstTimeZone);
        currentDate.setTime(date.getTime());
        System.out.println(sdf.format(currentDate.getTime()));
    }

    public Date getComputedDeliveryDate(Calendar orderDate, String shippingMethod) {

        int leadTimeValue = 2;
        long cutOffHours = 0;
        long cutOffMins = 0;
        Date orderDelDate = null;
        boolean standardGround = false;

        System.out.println("getComputedDeliveryDate :: CST orderDate = " + orderDate.getTime() + ", shippingMethod = " + shippingMethod + ", leadTimeValue = " + leadTimeValue + ", cutOffHours = " + cutOffHours + ", cutOffMins = " + cutOffMins);

        try {
            if ("ups_ground".equalsIgnoreCase(shippingMethod)) {
                standardGround = true;
            }

            if (standardGround) {
                /* Adds shipping lead time to the order submitted date */
                orderDate.add(Calendar.DAY_OF_MONTH, leadTimeValue);
                orderDelDate = orderDate.getTime();
            } else {

                if (checkCutOff(orderDate, cutOffHours, cutOffMins)) {
                    orderDate.add(Calendar.DAY_OF_MONTH, 1);
                    orderDate.setTime(checkBusinessDay(orderDate).getTime());
                }

                /* Add Lead Time and check if each day is a business day */
                for (int i = 0; i < leadTimeValue; i++) {
                    orderDate.add(Calendar.DAY_OF_MONTH, 1);
                    orderDate.setTime(checkBusinessDay(orderDate).getTime());
                }
                orderDelDate = orderDate.getTime();
            }
        } catch (Exception e) {
            System.out.println("e = " + e);
        }
        return orderDelDate;
    }

    private boolean checkCutOff(Calendar orderDate, long cutOffHours, long cutOffMins) {
        //TimeZone timeZone = TimeZone.getTimeZone("CST");
        //orderDate.setTimeZone(timeZone);
        /* Convert cut-off Time to Minutes */
        long cutOffTimeinMinutes = (cutOffHours * 60) + cutOffMins;

        /* convert Order submitted date to 24 Hour format */
        int orderHour = orderDate.get(Calendar.HOUR);
        int orderMeridian = orderDate.get(Calendar.AM_PM);

        /* If PM add 12 to hours */
        if (orderMeridian != 0) {
            orderHour = orderHour + 12;
        }

        /* convert Order submitted hours to Minutes */
        long orderTotalMinutes = orderHour * 60 + orderDate.get(Calendar.MINUTE);

        /*
         * set flag as true if order is placed after cut off time and when not
         * standard ground.
         */

        if (orderTotalMinutes >= cutOffTimeinMinutes) {
            return true;
        }
        return false;
    }

    private Calendar checkBusinessDay(Calendar date) {
        TimeZone timeZone = TimeZone.getTimeZone("CST");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        sdf.setTimeZone(timeZone);
        Calendar currentDate = Calendar.getInstance();
        currentDate.setTimeZone(timeZone);
        currentDate.setTime(date.getTime());
        //System.out.println("checkBusinessDay1:: currentDate = " + sdf.format(currentDate.getTime()));
        /* Flag check to exclude orders with Shipping method as*/
        if (currentDate.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
            currentDate.add(Calendar.DATE, 2);
        } else if (currentDate.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            currentDate.add(Calendar.DATE, 1);
        }
        System.out.println("checkBusinessDay2:: currentDate = " + sdf.format(currentDate.getTime()));
        return currentDate;
    }
}
