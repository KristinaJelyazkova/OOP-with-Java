import java.util.Random;

public class TrafficLightTest {
    public static void main(String[] args) throws InterruptedException {
        Random generator = new Random();
        long begin = System.currentTimeMillis();
        long current = begin;
        long beginNewColor = begin;
        boolean nextIsGreen = true;
        TrafficLight trafficLight =
                TrafficLight.values()[generator.nextInt(3)];

        while(current - begin < 90000){
            System.out.printf("The traffic light is %s.%n",
                    trafficLight);
            current = System.currentTimeMillis();

            if(current - beginNewColor >= trafficLight.getDuration()){

                switch (trafficLight.toString()){
                    case "red":
                        trafficLight = TrafficLight.YELLOW;
                        nextIsGreen = true;
                        break;
                    case "yellow":
                        trafficLight = nextIsGreen ? TrafficLight.GREEN : TrafficLight.RED;
                        break;
                    case "green":
                        trafficLight = TrafficLight.YELLOW;
                        nextIsGreen = false;
                        break;
                }

                beginNewColor = current;
            }

            Thread.sleep(1000);
        }
    }
}
