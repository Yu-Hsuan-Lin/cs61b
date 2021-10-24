public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> d = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            d.addLast(word.charAt(i));
        }
        return d;
    }
    public boolean isPalindrome(String word) {
        return isPalindrome(wordToDeque(word));

    }
    private boolean isPalindrome(Deque d) {
        if (d.size() == 0 || d.size() == 1) {
            return true;
        }
        if (d.removeFirst().equals(d.removeLast())) {
            return isPalindrome(d);
        }
        return false;
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        int lastIndex = word.length() - 1;
        return isPalindrome(wordToDeque(word), cc);

    }
    private boolean isPalindrome(Deque d, CharacterComparator cc) {
        if (d.size() == 0 || d.size() == 1) {
            return true;
        }
        if (cc.equalChars((char)d.removeFirst(), (char)d.removeLast())) {
            return isPalindrome(d, cc);
        }
        return false;
    }
}
