public enum TrafficLight {
    RED(30000, "red"),
    YELLOW(3000, "yellow"),
    GREEN(30000, "green");


    private long duration;
    private String name;

    TrafficLight(long duration, String name){
        this.duration = duration;
        this.name = name;
    }

    public long getDuration(){
        return duration;
    }

    @Override
    public String toString() {
        return name;
    }
}
