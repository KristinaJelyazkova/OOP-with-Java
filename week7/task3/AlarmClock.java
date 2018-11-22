public class AlarmClock {
    private AlarmListener alarm;
    private int nrings;

    public int getNrings() {
        return nrings;
    }

    public void setNrings(int nrings) {
        this.nrings = nrings;
    }

    public AlarmClock() {
        nrings = 10;
    }

    public void addAlarmListener(AlarmListener a){
        alarm = a;
    }

    public void onAlarm(AlarmEvent e){
        if(alarm != null){
            alarm.alarmActionPerformed(e);
        }
    }

    public void start(){
        while(nrings >= 0){
            AlarmEvent e = new AlarmEvent(nrings);
            onAlarm(e);
            nrings--;
        }
    }
}
