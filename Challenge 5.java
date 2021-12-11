import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class DaysYouLived {
    public static void main(String[] args) {
        String today = getTodaysDate();
        String dob = getDoB();
        int result = getTimeDelta(today, dob);
        if (result != 0) {
            System.out.println("You live " + result + " days.");
        }
        else {
            System.out.println("Wrong input.");
        }
        
    }

    public static String getTodaysDate() {
        LocalDateTime today = LocalDateTime.now();
        DateTimeFormatter f_today = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date = today.format(f_today);
        return date;
    }

    public static String getDoB() {
        System.out.println("What is your date of birth?");
        System.out.println("Format: dd/mm/yyy");
        System.out.print(">> ");
        Scanner sc_input = new Scanner(System.in);
        String dob = sc_input.nextLine();
        return dob;
    }

    public static int getTimeDelta(String today, String dob) {
        long diff = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");
        try {
            Date f_date = sdf.parse(today);
            Date s_date = sdf.parse(dob);
            long diffMillies = Math.abs(s_date.getTime() - f_date.getTime());
            diff = TimeUnit.DAYS.convert(diffMillies, TimeUnit.MILLISECONDS);
        } catch (ParseException e) {
            return 0;
        }
        return Math.round(diff);
    }
}
