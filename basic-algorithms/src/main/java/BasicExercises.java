public class BasicExercises {

    public static int getMissingNumber(int[] v) {
        if (v.length==0) {
            return -1;
        }
        int x1 = v[0];
        for (int i=1; i<v.length; i++) {
            x1 ^= v[i];
        }
        int x2 = 1;
        for (int i=2; i<=v.length+1; i++) {
            x2 ^= i;
        }

        return x1 ^ x2;
    }
}
