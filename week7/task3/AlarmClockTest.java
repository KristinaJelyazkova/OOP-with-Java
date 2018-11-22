public class AlarmClockTest{
    private static AlarmClock alarmClock = new AlarmClock();

    public static void main(String[] args) {
        alarmClock.addAlarmListener(new AlarmListener() {
            @Override
            public void alarmActionPerformed(AlarmEvent args) {
                System.out.println("Number of rings left: " + alarmClock.getNrings());
            }
        });
        alarmClock.start(2);
    }
}
