package iterator;

public class Sequence {
    // outer class
    // Holds a sequence of Objects.

        private Object[] obs;
        private int next = 0;

        public Sequence(int size) {
            obs = new Object[size];
        }

        public void add(Object x) {
            if (next < obs.length) {
                obs[next] = x;
                next++;
            }
        }

        private class SSelectorForward implements SelectorForward {
            private int i = 0;

            @Override
            public boolean end() {
                return i == obs.length;
            }

            @Override
            public void next() {
                if (i < obs.length) i++;
            }

            @Override
            public Object current() {
                return obs[i];
            }
        }

        public SelectorForward getSelectorForward() {
            return new SSelectorForward();
        }

        private class SSelectorBackward implements SelectorBackward {
            private int i = obs.length - 1;

            @Override
            public boolean begin() {
                return i == -1;
            }

            @Override
            public void previous() {
                if (i >= 0) i--;
            }

            @Override
            public Object current() {
                return obs[i];
            }
        }

        public SelectorBackward getSelectorBackward() {
            return new SSelectorBackward();
        }

        private class SSelectorTwoWay implements SelectorTwoWay {
            private int i;

            public SSelectorTwoWay(int index) {
                if (index >= 0 && index < obs.length) {
                    i = index;
                } else {
                    i = obs.length / 2;
                }
            }

            @Override
            public boolean begin() {
                return i == -1;
            }

            @Override
            public void previous() {
                if (i >= 0) i--;
            }

            @Override
            public boolean end() {
                return i == obs.length;
            }

            @Override
            public void next() {
                if (i < obs.length) i++;
            }

            @Override
            public Object current() {
                return obs[i];
            }
        }

        public SelectorTwoWay getSelectorTwoWay(int index) {
            return new SSelectorTwoWay(index);
        }
}
