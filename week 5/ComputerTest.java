import java.util.ArrayList;

public class ComputerTest {
    public static void main(String[] args) {
        ArrayList<String> files = new ArrayList<String>();
        files.add("file1");
        files.add("file2.txt");
        files.add("Computer.java");

        Computer computer1 = new Computer("Apple", 4500, files);
        Computer computer2 = new Computer();
        Computer computer3 = new Computer(computer1);

        System.out.println("The three computers before changing their data:");
        System.out.printf("Computer 1:%n%s%nComputer2:%n%s%nComputer3:%n%s%n",
                computer1.toString(), computer2.toString(), computer3.toString());

        computer1.setProcSpeed(5000);
        computer2.setFiles(files);
        computer3.setType("Mackintosh");


        System.out.println("The three computers after changing their data:");
        System.out.printf("Computer 1:%n%s%nComputer2:%n%s%nComputer3:%n%s%n",
                computer1.toString(), computer2.toString(), computer3.toString());
    }
}
