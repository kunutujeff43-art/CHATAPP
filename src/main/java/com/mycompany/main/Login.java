/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.main;

import java.util.Scanner;

/**
 *
 * @author jeffreyponto
 */
public class Login {

     String username;
     String password;
     String cellPhoneNumber;
     String firstName;
     String lastName;

    public Login() {
    }

    public Login(String username, String password, String cellPhoneNumber,
                 String firstName, String lastName) {
        this.username = username;
        this.password = password;
        this.cellPhoneNumber = cellPhoneNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public boolean checkUserName() {
        return username != null
                && username.contains("_")
                && username.length() <= 5;
    }

    public boolean checkPasswordComplexity() {
        return password != null
                && password.length() >= 8
                && password.matches(".*[A-Z].*")
                && password.matches(".*\\d.*")
                && password.matches(".*[^a-zA-Z0-9].*");
    }

    public boolean checkCellPhoneNumber() {
        return cellPhoneNumber != null
                && cellPhoneNumber.matches("^\\+27\\d{9}$");
    }

    public String registerUser() {

        if (!checkUserName()) {
            return "Username is not correctly formatted; please ensure that "
                    + "your username contains an underscore and is no more "
                    + "than five characters in length.";
        }

        if (!checkPasswordComplexity()) {
            return "Password is not correctly formatted; please ensure that "
                    + "the password contains at least eight characters, a "
                    + "capital letter, a number, and a special character.";
        }

        if (!checkCellPhoneNumber()) {
            return "Cell phone number incorrectly formatted or does not "
                    + "contain international code.";
        }

        return "User registered successfully.";
    }

    public boolean loginUser(String enteredUsername, String enteredPassword) {
        return username != null
                && password != null
                && username.equals(enteredUsername)
                && password.equals(enteredPassword);
    }

    public String returnLoginStatus(boolean loginStatus) {

        if (loginStatus) {
            return "Welcome " + firstName + " " + lastName
                    + " it is great to see you.";
        }

        return "Username or password incorrect, please try again.";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCellPhoneNumber() {
        return cellPhoneNumber;
    }

    public void setCellPhoneNumber(String cellPhoneNumber) {
        this.cellPhoneNumber = cellPhoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        
        boolean isRegistered = false;
        while (!isRegistered) {
            
        System.out.println("=== Registration ===");

        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine();

        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine();

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        System.out.print("Enter cell phone number (+27...): ");
        String cellPhoneNumber = scanner.nextLine();

        Login user = new Login(
                username,
                password,
                cellPhoneNumber,
                firstName,
                lastName
          
                 ); (names)

        String registrationMessage = user.registerUser();
        System.out.println(registrationMessage);
        
        if (registrationMessage.equals("User registered successfully.")) {
            isRegistered = true;

            System.out.println();
            System.out.println("=== Login ===");

            System.out.print("Enter username: ");
            String loginUsername = scanner.nextLine();

            System.out.print("Enter password: ");
            String loginPassword = scanner.nextLine();

            boolean loginStatus =
                    user.loginUser(loginUsername, loginPassword);

            System.out.println(user.returnLoginStatus(loginStatus));
        }
        }
        scanner.close(); 
    }
}

