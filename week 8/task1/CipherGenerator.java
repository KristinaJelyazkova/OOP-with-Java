package secretchars;

import java.util.Arrays;

public class CipherGenerator {
    public Result countDistinct(Cipherable cipher, int seed){
        char[] array = cipher.getSecretChars(seed);

        if(array.length == 0){
            return new Result(array, 0);
        }

        if(array.length == 1){
            return new Result(array, 1);
        }

        int countDistinct = 0;
        int position = 0;

        char[] arrayCopy = Arrays.copyOf(array, array.length);
        Arrays.sort(arrayCopy);

        for (int i = 0; i < arrayCopy.length - 1; i++) {
            if(arrayCopy[i] != arrayCopy[i + 1]){
                if(position == i) {
                    countDistinct++;
                }
                position = i + 1;
            }
        }

        if(position == arrayCopy.length - 1){
            countDistinct++;
        }

        return new Result(array, countDistinct);
    }
}
