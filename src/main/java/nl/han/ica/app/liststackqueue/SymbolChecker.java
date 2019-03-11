package nl.han.ica.app.liststackqueue;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class SymbolChecker {

    public static void checkSymbols(File file) {

        HANStack<String> stack = new HANStack<>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            int lineNumber = 1;
            for(String line; (line = br.readLine()) != null; )
            {
                line = line.trim();
                for(int i = 0; i < line.length(); i++) {
                    String character = Character.toString(line.charAt(i));

                    if(character.matches("[(\\[{]")) {
                        stack.push(character);
                    } else if (character.matches("[)\\]}]")) {
                        if(stack.getSize() == 0) {
                            throw new RuntimeException("line " + lineNumber + ": unexpected " + character);
                        } else {
                            stack.pop();
                        }
                    }
                }

                lineNumber++;

            }

            if(stack.getSize() > 0) {
                throw new RuntimeException("unexpected end of file");
            }

        } catch (IOException e) {
            System.out.println("file does not exist");
        }
    }



}
