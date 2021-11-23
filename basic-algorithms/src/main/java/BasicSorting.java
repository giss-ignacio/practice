import org.junit.Test;

import java.util.Arrays;

public class BasicSorting {

    public static int[] bubbleSort(int[] vector) {
        int temp;
        for (int l=0; l< vector.length - 1; l++) {
            for (int i=0; i< vector.length-l-1; i++) {
                if (vector[i] > vector[i+1]) {
                    temp = vector[i];
                    vector[i] = vector[i+1];
                    vector[i+1] = temp;
                }
            }
        }
        return vector;
    }


    // [1,2] 0 1
    // m =0, nl=1, nr= 1
    //
    public static void mergeSort(int[] v, int l, int r) {
        if (r-l < 1) {
            return;
        }

        int m = (l+r)/2;
        int nl = m-l+1;
        int nr = r-m;
        int[] la = new int[nl];
        int[] ra = new int[nr];
        System.arraycopy(v, l, la, 0, nl);
        System.arraycopy(v, l+m+1, ra, 0, nr);

        mergeSort(la, 0, nl-1);
        mergeSort(ra, 0, nr-1);

        merge(v, la, ra, l, r);
    }

    private static void merge(int[] v, int[] la, int[] ra, int l, int r) {
        int i =0, j = 0, k=0;

        while (i < la.length && j<ra.length) {
            if (la[i] < ra[j]) {
                v[k] = la[i];
                k++;
                i++;
            } else {
                v[k] = ra[j];
                k++;
                j++;
            }
        }

        while (i < la.length) {
            v[k] = la[i];
            k++;
            i++;
        }

        while (j < ra.length) {
            v[k] = ra[j];
            k++;
            j++;
        }
    }

    /*
     * {4, 8, 5} - 4, 5, 6, 7, 8 - 5 possible values
     * freq = [1, 2, 2, 2, 3]
     * tmp = [4, 5, 8]
     *
     *

     */
    public static void countingSort(int[] v) {
        int max = Arrays.stream(v).max().getAsInt();
        int min = Arrays.stream(v).min().getAsInt();
        int[] freq = new int[max-min+1];
        int[] result = new int[v.length];

        for (int j : v) {
            freq[j-min]++;
        }
        for (int i=1; i<freq.length; i++) {
            freq[i] += freq[i-1];
        }

        for (int i=v.length-1; i>=0; i--) {
            freq[v[i] - min]--;
            result[freq[v[i]-min]] = v[i];
        }
        System.arraycopy(result, 0, v, 0, v.length);
    }

    public static String countingSortString(String input) {
        int[] v = new int[input.length()];
        for (int i=0; i<v.length;i++ ) {
            v[i] = input.charAt(i);
        }
        countingSort(v);
        StringBuilder sb = new StringBuilder();
        for (int j : v) {
            sb.append((char) j);
        }

        return sb.toString();
    }

    private static void countSort10(int[] v, int exp) {
        int[] freq = new int[10];
        int[] result = new int[v.length];
        int n = v.length;

        for (int i=0; i<n; i++) {
            freq[(v[i]/exp) % 10]++;
        }
        for (int i=1; i<freq.length; i++) {
            freq[i] += freq[i-1];
        }

        for (int i=n-1; i>=0; i--) {
            result[freq[(v[i]/exp) %10] -1] = v[i];
            freq[(v[i]/exp) %10]--;
        }
        System.arraycopy(result, 0, v, 0, n);
    }

    public static void radixSort(int[] v) {
        int max = Arrays.stream(v).max().getAsInt();

        for (int exp = 1 ; max/exp >0; exp*=10) {
            countSort10(v, exp);
        }

    }
}
