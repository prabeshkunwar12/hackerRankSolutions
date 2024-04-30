package lettersequences;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class BiggerIsGreater {
    public static void main(String[] args) {
        try {
            BufferedReader readerInput = new BufferedReader(new FileReader(
                    "C:/Users/prabe/OneDrive/Desktop/projects/letterSequences/app/src/main/java/lettersequences/input.txt"));
            BufferedReader readerResult = new BufferedReader(new FileReader(
                    "C:/Users/prabe/OneDrive/Desktop/projects/letterSequences/app/src/main/java/lettersequences/result.txt"));
            int n = Integer.parseInt(readerInput.readLine());
            String[] strings = new String[n];

            for (int i = 0; i < n; i++) {
                strings[i] = readerInput.readLine();
            }

            int count = 0;
            for (String str : strings) {
                String result = biggerIsGreater(str);
                String expectedResult = readerResult.readLine();
                if (!result.equals(expectedResult)) {
                    System.out.println("Mismatch for input: " + str);
                    count++;
                }
            }
            if (count == 0) {
                System.out.println("All inputs match the expected results.");
            } else {
                System.out.println("Total mismatches: " + count);
            }

            readerInput.close();
            readerResult.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // System.out.println(biggerIsGreater("dpidb"));
    }

    public static String biggerIsGreater(String w) {
        for (int i = w.length() - 2; i >= 0; i--) {
            for (int j = w.length() - 1; j > i; j--) {
                if (w.charAt(i) < w.charAt(j)) {
                    StringBuilder wb = new StringBuilder(w);
                    char pivot = w.charAt(i);
                    wb.setCharAt(i, w.charAt(j));
                    wb.setCharAt(j, pivot);
                    return wb.substring(0, i) + wb.substring(i, i + 1)
                            + ascendingOrder(wb.substring(i + 1, wb.length()));
                }
            }
        }
        return ("no answer");
    }

    public static String ascendingOrder(String input) {
        char[] chars = input.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

}
