/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Utility class providing static methods to use around user input.
 *
 * @author kristian
 */
public class InputUtils {

    /**
     * Static method to return user input. Uses Buffered reader and
     * InputStreamReader to gather the text entered into the terminal by the
     * user.
     *
     * @return user input
     */
    public static String getUserInput() {
        String input = "";
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            input = reader.readLine();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return input;
    }
}
