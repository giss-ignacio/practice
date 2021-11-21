public class BasicSearch {

    public static int binarySearch(int[] v, int e) {
        int l=0, r=v.length-1;

        while (l<r) {
            int m = (l+r) /2;
            if (v[m] == e) {
                return m;
            } else if (v[m] > e){
                r = m;
            } else {
                l = m+1;
            }
        }
        return -1;
    }
}
