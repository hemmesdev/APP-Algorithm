package nl.han.ica.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Recursion {

    public static void main(String[] args) {
        faculteit();
        sum();
        binaryOnes();
        System.out.println(getSumOfIntegersInFileAndReferencedFiles("file1.txt"));
        System.out.println(reverseString("harry"));
        System.out.println(reverseStringBuffer("harry"));
    }

    private static void faculteit() {
        int n = 5;
        System.out.println("Faculteit:");
        System.out.println("non recursive: "  + faculteitNonRecursive(n));
        System.out.println("recursive: " + faculteitRecursive(n));
        System.out.println();
    }

    private static int faculteitRecursive(int length) {
        if(length <= 1) {
            return 1;
        } else {
            return length * faculteitRecursive(length - 1);
        }
    }

    private static int faculteitNonRecursive(int n) {
        int total = 1;
        for(int i = 2; i <= n; i++) {
            total = total * i;
        }
        return total;
    }

    private static void sum() {
        int n = 5;
        System.out.println("SUM:");
        System.out.println("non recursive: "  + sumNonRecursive(n));
        System.out.println("recursive: " + sumRecursive(n));
        System.out.println();
    }

    /**
     *
     * @param
     * @return
     */
    private static int sumRecursive(int n) {
        if(n == 1) {
            return 1;
        } else {
            return n + sumRecursive(n - 1);
        }
    }

    private static int sumNonRecursive(int length) {
        int total = 1;
        for(int i = 2; i <= length; i++) {
            total = total + i;
        }
        return total;
    }

    private static void binaryOnes() {
        int n = 7;
        System.out.println("BinaryOnes: " + getBinaryOnesInInteger(n));
        System.out.println();
    }

    private static int getBinaryOnesInInteger(int number) {
        if(number == 0) {
            return 0;
        }
        if(number % 2 == 0) {
            return getBinaryOnesInInteger(number / 2);
        }
        else {
            return getBinaryOnesInInteger(number / 2) + 1;
        }
    }

    private static int getSumOfIntegersInFileAndReferencedFiles(String fileName) {
        ArrayList<String> referencedFiles = new ArrayList<>();
        return getSumOfIntegersInFileAndReferencedFiles(fileName, referencedFiles);
    }

    private static int getSumOfIntegersInFileAndReferencedFiles(String fileName, ArrayList<String> referencedFiles) {
        if(referencedFiles.contains(fileName)) {
            return 0;
        }

        referencedFiles.add(fileName);
        int sum = 0;
        try (BufferedReader br = new BufferedReader(new FileReader("resources/" + fileName))) {
            for(String line; (line = br.readLine()) != null; )
            {
                line = line.trim();
                if(isStringAnInt(line)) {
                    sum += Integer.parseInt(line);
                } else {
                    sum += getSumOfIntegersInFileAndReferencedFiles(line, referencedFiles);
                }
            }
        } catch (IOException e) {
            System.out.println("file does not exist");
        }
        return sum;
    }

    private static boolean isStringAnInt(String str) {
        return str.matches("-?(0|[1-9]\\d*)");
    }

    private static String reverseString(String str) {
        if(str.length() <= 1) {
            return str;
        } else {
            return str.substring(str.length() - 1) + reverseString(str.substring(0, str.length() - 1));
        }
    }

    private static String reverseStringBuffer(String str) {
        StringBuffer stringBuffer = new StringBuffer();
        reverseStringBuffer(str, stringBuffer);
        return stringBuffer.toString();
    }

    private static void reverseStringBuffer(String str, StringBuffer stringBuffer) {
        if(str.length() == 1) {
            stringBuffer.append(str);
        } else {
            stringBuffer.append(str.substring(str.length() - 1));
            reverseStringBuffer(str.substring(0, str.length() - 1), stringBuffer);
        }
    }


}
