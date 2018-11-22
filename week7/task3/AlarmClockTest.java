public class AlarmClockTest implements AlarmListener {
    private static AlarmClock alarmClock;

    public AlarmClockTest() {
        alarmClock = new AlarmClock(10);
        alarmClock.addAlarmListener(this);
    }

    @Override
    public void alarmActionPerformed(AlarmEvent args) {
        System.out.println("Number of rings left: " + alarmClock.getNrings());
    }

    public static void main(String[] args) {
        AlarmClockTest alarmClockTest = new AlarmClockTest();
        AlarmClockTest.alarmClock.start();
    }
}
