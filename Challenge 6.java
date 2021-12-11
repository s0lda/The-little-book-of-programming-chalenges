import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class Timer {
    public static String getTimeNow() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter f_now = DateTimeFormatter.ofPattern("HH:mm:ss");
        String time_now = now.format(f_now);
        System.out.println(time_now);
        return time_now;
    }

    public static int getTimeDelta(String start, String finish) {
        long diff = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        try {
            Date s_time = sdf.parse(start);
            Date f_time = sdf.parse(finish);
            long diffMillies = Math.abs(f_time.getTime() - s_time.getTime());
            diff = TimeUnit.SECONDS.convert(diffMillies, TimeUnit.MILLISECONDS);
        } catch (ParseException e) {
            diff = 0;
        }
        return Math.round(diff);
    }

    public static String getInput() {
        System.out.print(">> ");
        Scanner sc_input = new Scanner(System.in);
        String input = sc_input.nextLine();
        return input;
    }

    public static void getResult(int time_diff) {
        if ( time_diff == 10) {
            System.out.println("Bang on Time!");
        }
        else if (time_diff < 10) {
            int early = 10 - time_diff;
            if ( early != 1) {
                System.out.println(early + " seconds too early. Wait a bit longer next time.");
            } else {
                System.out.println("Second too early. Wait a bit longer next time.");
            }
        } else {
            int late = time_diff - 10;
            if (late != 1) {
                System.out.println(late + " seconds too late. Next time try to be a bit quicker." );
            } else {
                System.out.println("Second too late. Next time try to be a bit quicker." );
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Press Enter when you ready to start.");
        System.out.println("Press Enter again after 10 seconds.");
        System.out.println("Type EXIT to exit the game.");
        System.out.println("Happy Guessing!");
        boolean run = true;
        while (run == true) {
            String start_input = getInput();
            if (!start_input.toLowerCase().equals("exit")) {
                String start = getTimeNow();
                String finish_input = getInput();
                String finish = getTimeNow();
                int time_diff = getTimeDelta(start, finish);
                getResult(time_diff);
            }
            else {
                run = false;
            }
        }
    }
}