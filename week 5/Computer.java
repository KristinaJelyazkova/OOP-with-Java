import java.util.ArrayList;

public class Computer {
    private String type;
    private int procSpeed;
    private ArrayList<String> files;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = (type == null) ? "ASUS" : type;
    }

    public int getProcSpeed() {
        return procSpeed;
    }

    public void setProcSpeed(int procSpeed) {
        this.procSpeed = (procSpeed > 0) ? procSpeed : 3500;
    }

    public ArrayList<String> getFiles() {
        return new ArrayList<String>(files);
    }

    public void setFiles(ArrayList<String> files) {
        this.files = new ArrayList<String>(files);
    }

    public Computer(String type, int procSpeed, ArrayList<String> files) {
        setType(type);
        setProcSpeed(procSpeed);
        setFiles(files);
    }

    public Computer(){
        this("ASUS", 3500, new ArrayList<String>());
    }

    public Computer(Computer other){
        this(other.type, other.procSpeed, other.files);
    }

    @Override
    public String toString() {
        return String.format("type = %s%nprocSpeed = %d%nfiles = %s%n",
                type, procSpeed, files.toString());
    }
}
