package api.demoapi;

public class Validador_de_Festivos {
public class Date {
    private int day;
    private int month;
    private int year;

    public Date() {
        this.year = 1999;
        this.month = 1;
        this.day = 1;
    }

    public Date(int year, int month, int day) {
        this.year = validateYear(year);
        this.month = validateMonth(month);
        this.day = validateDay(day);
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = validateDay(day);
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = validateMonth(month);
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = validateYear(year);
    }

    @Override
    public String toString() {
        return String.format("%04d/%02d/%02d", year, month, day);
    }

    private int validateYear(int year) {
        if (year < 0) {
            throw new IllegalArgumentException("The year: " + year + " is not valid.");
        }
        return year;
    }

    private int validateMonth(int month) {
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("The month: " + month + " is not valid.");
        }
        return month;
    }

    private int validateDay(int day) {
        if (day < 1) {
            throw new IllegalArgumentException("The day: " + day + " is not valid.");
        }

        if (month == 2 && day == 29 && isLeapYear(year)) {
            return day;
        }

        if ((month == 2 && day <= 28) ||
            (isThirtyDayMonth(month) && day <= 30) ||
            (isThirtyOneDayMonth(month) && day <= 31)) {
            return day;
        }

        throw new IllegalArgumentException("The day: " + day + " is not valid.");
    }

    private boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }

    private boolean isThirtyDayMonth(int month) {
        return month == 4 || month == 6 || month == 9 || month == 11;
    }

    private boolean isThirtyOneDayMonth(int month) {
        return month == 1 || month == 3 || month == 5 ||month == 7 || month == 8 || month == 10 || month == 12;
    }
}


}
