import org.junit.Test;

import static org.junit.Assert.*;
/* Note: testWordToDeque:
        why we didn’t just create a correct Deque
        and then call assertEquals. The reason is that our Deque class
        does not provide an equals method
        and thus it won’t work. */
public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
        assertEquals("persiflage", actual);
    }

    @Test
    public void testIsPalindrome() {
        String word = "cat";
        assertFalse(palindrome.isPalindrome("cat"));
       /* if (word.length() == 0 || word.length() == 1) {
            assertTrue(palindrome.isPalindrome(word));
        } else {
            int lastIndex = word.length() - 1;
            for (int i = 0; i < lastIndex / 2 + 1; i++) {
                if (word.charAt(i) != word.charAt(lastIndex - i)) {
                    assertFalse(palindrome.isPalindrome(word));
                    break;
                } else if (i == lastIndex / 2) {
                    assertTrue(palindrome.isPalindrome(word));
                }
            }
        }*/

        word = "racecar";
        assertTrue(palindrome.isPalindrome(word));
        word = "";
        assertTrue(palindrome.isPalindrome(word));
        word = "a";
        assertTrue(palindrome.isPalindrome(word));
        word = "noon";
        assertTrue(palindrome.isPalindrome(word));
        word = "moon";
        assertFalse(palindrome.isPalindrome(word));
        word = "promp";
        assertFalse(palindrome.isPalindrome(word));
        word = "pomp";
        assertFalse(palindrome.isPalindrome(word));

    }

    @Test
     public void testIsPalindromeOffByOne() {
        String word = "flake";
        CharacterComparator cc = new OffByOne();
        if (word.length() == 0 || word.length() == 1) {
            assertTrue(palindrome.isPalindrome(word, cc));
        } else {
            int lastIndex = word.length() - 1;
            for (int i = 0; i < lastIndex / 2 + 1; i++) {
                int diff = word.charAt(i) - word.charAt(lastIndex - i);
                if (i != lastIndex / 2 && Math.abs(diff) != 1) {
                    assertFalse(palindrome.isPalindrome(word, cc));
                    break;
                } else if (i == lastIndex / 2) {
                    assertTrue(palindrome.isPalindrome(word, cc));
                    break;
                }
            }
        }

        word = "flaKe";
        assertFalse(palindrome.isPalindrome(word, cc));
        word = "&%";
        assertTrue(palindrome.isPalindrome(word, cc));
        word = "spot";
        assertTrue(palindrome.isPalindrome(word, cc));
        word = "s";
        assertTrue(palindrome.isPalindrome(word, cc));
    }

    @Test
    public void testIsPalindromeOffByN() {
        String word = "six";
        CharacterComparator cc8 = new OffByN(5);
        if (cc8 instanceof OffByN) {
            if (word.length() == 0 || word.length() == 1) {
                assertTrue(palindrome.isPalindrome(word, cc8));
            } else {
                int lastIndex = word.length() - 1;
                for (int i = 0; i < lastIndex / 2 + 1; i++) {
                    int diff = Math.abs(word.charAt(i) - word.charAt(lastIndex - i));
                    if ((i != lastIndex / 2) &&
                            (!cc8.equalChars(word.charAt(i), word.charAt(lastIndex - i)))) {
                        assertFalse(palindrome.isPalindrome(word, cc8));
                        break;
                    } else if (i == lastIndex / 2) {
                        assertTrue(palindrome.isPalindrome(word, cc8));
                        break;
                    }
                }
            }
        }

        word = "tidy";
        assertFalse(palindrome.isPalindrome(word, cc8));
        word = "tiny";
        assertTrue(palindrome.isPalindrome(word, cc8));
    }

    @Test
    public void testIsPalindromeUpper() {
        CharacterComparator cc = new OffByN(5);
        assertTrue(palindrome.isPalindrome("aMuOzHf", cc));
        assertFalse(palindrome.isPalindrome("", cc));

        CharacterComparator cc2 = new OffByOne();
        assertTrue(palindrome.isPalindrome("aDrCb", cc2));
    }

    @Test
    public void testIsPalindromeUpperOne() {
        CharacterComparator cc = new OffByOne();
        assertFalse(palindrome.isPalindrome("Ba", cc));
    }
}
