package _01control;

import java.util.Scanner;

/*
variable count = 0
variable previous letter = first letter in word
if previous letter is a vowel, add one to count
for each letter in word until end of the word
    if letter is a vowel and previous letter was a vowel
        do nothing
    else if letter is a vowel and previous letter was a consonant
        if not last letter and letter is e
            add one to count
    else if letter is a consonant
        do nothing
    set previous letter to letter

if count is 0, set count to 1
 */

public class P4_11 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.print("Input word: ");
        String word = scan.next();
        

        int countSyllables = 0;
        Character prevLetter = word.charAt(0);

        // idea credit: https://stackoverflow.com/questions/27555895/is-it-possible-to-check-if-a-char-matches-a-list-of-possibilities

        if ("aeiouyAEIOUY".indexOf(prevLetter) != -1)  {
            countSyllables ++;
        }

        if (word.length() > 1) {
            for (int i = 1; i < word.length(); i++) {
                Character thisLetter = word.charAt(i);
                if ("aeiouyAEIOUY".indexOf(thisLetter) != -1 &&
                        "aeiouyAEIOUY".indexOf(prevLetter) == -1) {
                    if (i < word.length()-  1 || !thisLetter.equals('e')) {
                        countSyllables ++;

                    }
                }
                prevLetter = thisLetter;
            }
        }

        if (countSyllables == 0)
            countSyllables = 1;

        System.out.print(countSyllables);

    }

}
