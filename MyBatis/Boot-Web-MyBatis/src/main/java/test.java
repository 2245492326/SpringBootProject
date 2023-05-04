/**
 * @Create 2023-03-21 20:16
 * @Author cgs
 * @Version 1.0
 * Description:
 */
public class test {
    int calculateDaysBetweenDates(String date1, String date2) {
        int year1 = Integer.parseInt(date1.substring(0, 4));
        int month1 = Integer.parseInt(date1.substring(5, 7));
        int day1 = Integer.parseInt(date1.substring(8, 10));
        int year2 = Integer.parseInt(date2.substring(0, 4));
        int month2 = Integer.parseInt(date2.substring(5, 7));
        int day2 = Integer.parseInt(date2.substring(8, 10));
        int days = 0;
        if (year1 == year2) {
            if (month1 == month2) {
                days = day2 - day1;
            } else {
                days = day2 + (30 - day1);
            }
        } else {
            days = day2 + (30 - day1) + (year2 - year1 - 1) * 365 + (12 - month1) * 30;
        }
        return days;
    }

    public static void main(String[] args) {
        test test = new test();
        System.out.println(test.calculateDaysBetweenDates("2019-02-01", "2019-02-03"));
    }

}
