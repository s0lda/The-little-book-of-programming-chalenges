import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class SpeedTyping {

    public static String getTimeNow() {
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter f_now = DateTimeFormatter.ofPattern("HH:mm:ss");
        String time_now = now.format(f_now);
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

    public static void main(String[] args) {
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        System.out.println("How fast can you type the alphabet?");
        boolean run = true;
        while (run == true) {
            System.out.println("Press Enter when you ready to start, when you finish press Enter again.");
            System.out.println("Type EXIT to exit.");
            String start_input = getInput();
            if (!start_input.toLowerCase().equals("exit")) {
                String start = getTimeNow();
                String answer = getInput();
                String finish = getTimeNow();
                if (answer.toLowerCase().equals(alphabet)) {
                    int time_diff = getTimeDelta(start, finish);
                    System.out.println("Took you " + time_diff + " seconds to finish it.");
                } else {
                    System.out.println("Not correct. Try again.");
                }
            } else {
                run = false;
            }

        }
    }
}
