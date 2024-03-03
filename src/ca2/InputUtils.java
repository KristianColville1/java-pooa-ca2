/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

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
        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(System.in));
            input = reader.readLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return input;
    }

    /**
     * Static method to validate user credentials. Takes in a username, password
     * and credentials as parameters to check.
     *
     * If the HashMap credentials contains the username, return true if that
     * users password equals the password otherwise return false.
     *
     * @param username of the user to validate
     * @param password of the user to validate
     * @param credentials to check against
     * @return true or false to validate user
     */
    public static boolean validateCredentials(
            String username,
            String password,
            HashMap<String, String> credentials) {
        if (credentials.containsKey(username)) {
            return credentials.get(username).equals(password);
        }
        return false;
    }
}
