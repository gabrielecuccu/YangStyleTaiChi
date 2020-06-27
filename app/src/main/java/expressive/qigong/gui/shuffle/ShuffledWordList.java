package expressive.qigong.gui.shuffle;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ShuffledWordList {

    private final List<String> words;

    private int current = 0;

    public ShuffledWordList(String... words) {
        this.words = Arrays.asList(words);
        Collections.shuffle(this.words);
    }

    public String next() {
        String word = words.get(current);
        current = (current + 1) % words.size();
        return word;
    }
}
