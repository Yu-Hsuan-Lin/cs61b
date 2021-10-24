import org.junit.Test;

import java.util.Locale;

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
        if (word.length() == 0 || word.length() == 1) {
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
        }
        word = "racecar";
        if (word.length() == 0 || word.length() == 1) {
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
        }

        word = "";
        if (word.length() == 0 || word.length() == 1) {
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
        }

        word = "a";
        if (word.length() == 0 || word.length() == 1) {
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
        }

        word = "noon";
        if (word.length() == 0 || word.length() == 1) {
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
        }

        word = "moon";
        if (word.length() == 0 || word.length() == 1) {
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
        }

        word = "promp";
        if (word.length() == 0 || word.length() == 1) {
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
        }

        word = "pomp";
        if (word.length() == 0 || word.length() == 1) {
            assertTrue(palindrome.isPalindrome(word));
        } else {
            int lastIndex = word.length() - 1;  //3
            for (int i = 0; i < lastIndex / 2 + 1; i++) {   //2
                if (word.charAt(i) != word.charAt(lastIndex - i)) {
                    assertFalse(palindrome.isPalindrome(word));
                    break;
                } else if (i == lastIndex / 2) {
                    assertTrue(palindrome.isPalindrome(word));
                }
            }
        }


        word = "flake";
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
        CharacterComparator cc102 = new OffByOne();
        if (word.length() == 0 || word.length() == 1) {
            assertTrue(palindrome.isPalindrome(word, cc));
        } else {
            int lastIndex = word.length() - 1;
            for (int i = 0; i < lastIndex / 2 + 1; i++) {
                int diff = word.charAt(i) - word.charAt(lastIndex - i);
                if (i != lastIndex / 2 && Math.abs(diff) != 1) {
                    assertFalse(palindrome.isPalindrome(word, cc102));
                    break;
                } else if (i == lastIndex / 2) {
                    assertTrue(palindrome.isPalindrome(word, cc102));
                    break;
                }
            }
        }

        word = "&%";
        CharacterComparator cc2 = new OffByOne();
        if (word.length() == 0 || word.length() == 1) {
            assertTrue(palindrome.isPalindrome(word, cc2));
        } else {
            int lastIndex = word.length() - 1;
            for (int i = 0; i < lastIndex / 2 + 1; i++) {
                int diff = word.charAt(i) - word.charAt(lastIndex - i);
                if (i != lastIndex / 2 && Math.abs(diff) != 1) {
                    assertFalse(palindrome.isPalindrome(word, cc2));
                    break;
                } else if (i == lastIndex / 2) {
                    assertTrue(palindrome.isPalindrome(word, cc2));
                    break;
                }
            }
        }

        word = "spot";
        CharacterComparator cc3 = new OffByOne();
        if (word.length() == 0 || word.length() == 1) {
            assertTrue(palindrome.isPalindrome(word, cc3));
        } else {
            int lastIndex = word.length() - 1;
            for (int i = 0; i < lastIndex / 2 + 1; i++) {
                int diff = word.charAt(i) - word.charAt(lastIndex - i);
                if (i != lastIndex / 2 && Math.abs(diff) != 1) {
                    assertFalse(palindrome.isPalindrome(word, cc3));
                    break;
                } else if (i == lastIndex / 2) {
                    assertTrue(palindrome.isPalindrome(word, cc3));
                    break;
                }
            }
        }

        word = "s";
        CharacterComparator cc4 = new OffByOne();
        if (word.length() == 0 || word.length() == 1) {
            assertTrue(palindrome.isPalindrome(word, cc4));
        } else {
            int lastIndex = word.length() - 1;
            for (int i = 0; i < lastIndex / 2 + 1; i++) {
                int diff = word.charAt(i) - word.charAt(lastIndex - i);
                if (i != lastIndex / 2 && Math.abs(diff) != 1) {
                    assertFalse(palindrome.isPalindrome(word, cc4));
                    break;
                } else if (i == lastIndex / 2) {
                    assertTrue(palindrome.isPalindrome(word, cc4));
                    break;
                }
            }
        }


        word = "six";
        CharacterComparator cc8 = new OffByN(5);
        if (cc8 instanceof OffByN) {
            if (word.length() == 0 || word.length() == 1) {
                assertTrue(palindrome.isPalindrome(word, cc8));
            } else {
                int lastIndex = word.length() - 1;
                for (int i = 0; i < lastIndex / 2 + 1; i++) {
                    int diff = Math.abs(word.charAt(i) - word.charAt(lastIndex - i));
                    if ((i != lastIndex / 2) && (! cc8.equalChars(word.charAt(i), word.charAt(lastIndex - i)))) {
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
        CharacterComparator cc9 = new OffByN(5);
        if (cc9 instanceof OffByN) {
            if (word.length() == 0 || word.length() == 1) {
                assertTrue(palindrome.isPalindrome(word, cc9));
            } else {
                int lastIndex = word.length() - 1;
                for (int i = 0; i < lastIndex / 2 + 1; i++) {
                    int diff = Math.abs(word.charAt(i) - word.charAt(lastIndex - i));
                    if ((i != lastIndex / 2) && (! cc8.equalChars(word.charAt(i), word.charAt(lastIndex - i)))) {
                        assertFalse(palindrome.isPalindrome(word, cc9));
                        break;
                    } else if (i == lastIndex / 2) {
                        assertTrue(palindrome.isPalindrome(word, cc9));
                        break;
                    }
                }
            }
        }

        word = "tiny";
        CharacterComparator cc10 = new OffByN(5);
        if (cc10 instanceof OffByN) {
            if (word.length() == 0 || word.length() == 1) {
                assertTrue(palindrome.isPalindrome(word, cc10));
            } else {
                int lastIndex = word.length() - 1;
                for (int i = 0; i < lastIndex / 2 + 1; i++) {
                    int diff = Math.abs(word.charAt(i) - word.charAt(lastIndex - i));
                    if ((i != lastIndex / 2) && (! cc8.equalChars(word.charAt(i), word.charAt(lastIndex - i)))) {
                        assertFalse(palindrome.isPalindrome(word, cc10));
                        break;
                    } else if (i == lastIndex / 2) {
                        assertTrue(palindrome.isPalindrome(word, cc10));
                        break;
                    }
                }
            }
        }
    }
}
