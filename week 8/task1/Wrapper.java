package secretchars;

import java.util.Random;

public class Wrapper {
    private int size;

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = (size >= 0) ? size : 0;
    }

    public Wrapper(int size) {
        setSize(size);
    }

    public Cipherable makeFixedRandom(){
        return new FixedRandom();
    }

    public Cipherable makeFixedSelection(){
        return new FixedSelection();
    }

    private class FixedRandom implements Cipherable{

        @Override
        public char[] getSecretChars(int seed) {
            Random generator = new Random(seed);

            char[] array = new char[size];

            for (int i = 0; i < size; i++) {
                array[i] = (char) ('A' + generator.nextInt(26));
            }

            return array;
        }
    }

    private class FixedSelection implements Cipherable{

        @Override
        public char[] getSecretChars(int seed) {
            Random generator = new Random(seed);

            char[] array = new char[seed];

            for (int i = 0; i < seed; i++) {
                array[i] = (char) ('A' + generator.nextInt(26));
            }

            char[] result = new char[size];

            for (int i = 0; i < size; i++) {
                result[i] = array[generator.nextInt(seed)];
            }

            return result;
        }
    }
}
