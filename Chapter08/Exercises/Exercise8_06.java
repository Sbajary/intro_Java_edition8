package Chapter08.Exercises;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 *
 * @author Shady Bajary
 * @Exercise 8.6
 * @Title Displaying Calendars
 */
public class Exercise8_06 {

    static String output = "";

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Prompt the user to enter year
        int year = Integer.parseInt(JOptionPane.showInputDialog(
                "Enter full year (e.g, 2001): "));

        // Prompt the user to enter month
        int month = Integer.parseInt(JOptionPane.showInputDialog(
                "Enter month in number between 1 and 12: "));

        // Print calendar for the month of the year
        printMonth(year, month);
        JOptionPane.showMessageDialog(null, output);
    }

    /* Print the calendar for a month in a year */
    public static void printMonth(int year, int month) {
        // print the headings of the calendar
        printMonthTitle(year, month);

        // Print the body of the caledar
        printMonthBody(year, month);
    }

    /* Print the month title, e.g May, 1999 */
    public static void printMonthTitle(int year, int month) {
        output += ("            " + getMonthName(month)
                + " " + year + "\n");
        output += ("-----------------------------------\n");
        output += (" Sun Mon Tue Wed Thu Fri Sat\n");
    }

    /* Get the English name for the month */
    public static String getMonthName(int month) {
        String monthName = " ";
        switch (month) {
            case 1:
                monthName = "January";
                break;
            case 2:
                monthName = "Febrary";
                break;
            case 3:
                monthName = "March";
                break;
            case 4:
                monthName = "April";
                break;
            case 5:
                monthName = "May";
                break;
            case 6:
                monthName = "June";
                break;
            case 7:
                monthName = "July";
                break;
            case 8:
                monthName = "August";
                break;
            case 9:
                monthName = "September";
                break;
            case 10:
                monthName = "October";
                break;
            case 11:
                monthName = "November";
                break;
            case 12:
                monthName = "December";
        }
        return monthName;
    }

    /* Print month body */
    public static void printMonthBody(int year, int month) {
        // Get start day of the week for the first date in the month
        int startDay = getStartDay(year, month);

        // Get number of days in the month
        int numberOfDaysInMonth = getNumberOfDaysInMonth(year, month);

        // Pad space before the first day of the month
        int i = 0;
        for (i = 0; i < startDay; i++) {
            output += "        ";
        }
        for (i = 1; i <= numberOfDaysInMonth; i++) {
            output += String.format("%5d", i);

            if ((i + startDay) % 7 == 0) {
                output += "\n";
            }
        }
        output += "\n";
    }

    /* Get the start day of the month/1/year */
    public static int getStartDay(int year, int month) {
        final int START_DAY_FOR_JAN_1_1800 = 3;

        // Get total number of days from 1/1/1800 to month/1/year
        int totalNumberOfDays = getTotalNumberOfDays(year, month);

        // Return the start day for month/1/year
        return (totalNumberOfDays + START_DAY_FOR_JAN_1_1800) % 7;
    }

    /* Get the total number of days since January 1, 1800 */
    public static int getTotalNumberOfDays(int year, int month) {
        int total = 0;

        // Get the total days from 1800 to 1/1/year
        for (int i = 1800; i < year; i++) {
            if (isLeapYear(i)) {
                total += 366;
            } else {
                total += 365;
            }
        }
        // add days from Jan to the month prior to the calendar month
        for (int i = 1; i < month; i++) {
            total += getNumberOfDaysInMonth(year, i);
        }
        return total;
    }

    /* Get the number of days in a month */
    public static int getNumberOfDaysInMonth(int year, int month) {
        if (month == 1 || month == 3 || month == 5 || month == 7
                || month == 8 || month == 10 || month == 12) {
            return 31;
        }
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        }
        if (month == 2) {
            return isLeapYear(year) ? 29 : 28;
        }
        return 0; // if the month is incorrect
    }

    /* Determine if it is a leap year */
    public static boolean isLeapYear(int year) {
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }
}
