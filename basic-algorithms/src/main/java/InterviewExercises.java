import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InterviewExercises {

    /*
     * find two words that compound the word given with the list of words
     * rockstar in [rockstar, rock, star, rocks, tar, highway, high, way] -> rock, star, rocks, tar
     * srocktar -> "" there's no "s" ,
     * best solution will be (not this) KMP Algorithm for Pattern Searching
     */
    public static void printCompoundWords(String word, List<String> words) {
        Set<String> tmpWords = new HashSet<>();
        Set<String> foundWords = new HashSet<>();
        tmpWords.add(word);

        for (String w : words) {
            if (w.equals(word)) {
                continue;
            }
            for (String tmp : tmpWords) {
                if (tmp.equals(w)) {
                    tmpWords.remove(tmp);
                    foundWords.add(w);
                } else if (tmp.contains(w)) {
                    foundWords.add(w);
                    tmpWords.remove(tmp);
                    int posIni = tmp.indexOf(w);
                    if (posIni == 0) {
                        tmpWords.add(tmp.substring(w.length()));
                    } else {
                        String w1 = tmp.substring(0, posIni);
                        String w2 = tmp.substring(w.length());
                        tmpWords.add(w1);
                        tmpWords.add(w2);
                    }
                }
                if (foundWords.size() == 2 && tmpWords.isEmpty()) {
                    for (String fw: foundWords) {
                        System.out.println(fw + " ");
                    }
                    foundWords.clear();
                    tmpWords.add(word);
                }
            }
        }
    }
}