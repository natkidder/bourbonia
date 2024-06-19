import clientA.RevisedTimeServer;
import clientA.AnnotatedTimeServer;

class TimeClientA {
    public static void main(String[ ] args) {
        RevisedTimeServer ts = new RevisedTimeServer();
        AnnotatedTimeServer ats = ts.getAnnotatedTimeServerPort();

        System.out.println(ats.timeString("Hi, world!"));
        System.out.println(ats.timeElapsed());
    }
}    
