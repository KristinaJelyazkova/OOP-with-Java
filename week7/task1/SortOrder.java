public class SortOrder {

    private class Upward implements Sortable{
        @Override
        public boolean greater(int a, int b) {
            return a > b;
        }
    }

    private class Downward implements Sortable{
        @Override
        public boolean greater(int a, int b) {
            return a < b;
        }
    }

    public Sortable upward(){
        return new Upward();
    }

    public Sortable downward(){
        return new Downward();
    }
}
