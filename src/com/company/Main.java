package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("1 -Convert Decimal Number to Binary Number");
            System.out.println("2 -Convert Decimal Number to Hexadecimal Number");
            System.out.println("3 -Convert Decimal IP Address to Binary IP Address");
            System.out.println("4 -Convert Decimal MAC Address to Hexadecimal MAC Address");
            System.out.println("5 -Exit");


            System.out.println("");
            System.out.println("Enter choice: ");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.println();
                System.out.print("Enter Decimal Integer: ");
                int integer = sc.nextInt();
                String binary = decimal2Binary(integer);
                System.out.println("Decimal Number: " + integer);
                System.out.println("Binary Number: " + binary);
                System.out.println();
            } else if (choice == 2) {
                System.out.println();
                System.out.print("Enter Decimal Integer: ");
                int integer = sc.nextInt();
                String hexa = decimal2Hexadecimal(integer);
                System.out.println("Decimal Number: " + integer);
                System.out.println("HexaDecimal Number: " + hexa);
                System.out.println();
            } else if (choice == 3) {
                System.out.println();
                System.out.print("Enter decimal Address(i.e. 192.168.35.10): ");
                sc.nextLine();
                String s = sc.nextLine();
                String[] decimal = s.split("\\.");//splitting string input along "." and converting to String array.
                String binaryIP = convertIpAdress(decimal, 0);
                System.out.println("Decimal IP Address: " + s);
                System.out.println("Binary IP Address: " + binaryIP);
                System.out.println();
            } else if (choice == 4) {
                System.out.println();
                System.out.print("Enter MAC Address(i.e. 203:65:157:93:13:7): ");
                sc.nextLine();
                String s = sc.nextLine();
                String[] decimal = s.split(":");
                String hexaMAC = convertMacAdress(decimal, 0);
                System.out.println("Decimal MAC Address: " + s);
                System.out.println("Hexadecimal MAC Address: " + hexaMAC);
                System.out.println();
            } else if (choice == 5) {
                break;
            } else {
                System.out.println();
                System.out.println("Error : Please Enter Valid Input");
                System.out.println();


            }
        }
    }

    public static String decimal2Binary(int num) {
        if (num == 0) {
            return "";
        } else {
            int rem = (num % 2);
            return decimal2Binary(num / 2) + Integer.toString(rem);
        }
    }

    public static String decimal2Hexadecimal(int num) {

        int rem = num % 16;

        if (num != 0) {
            switch (rem) {
                case 10:
                    return decimal2Hexadecimal(num / 16) + "A";
                case 11:
                    return decimal2Hexadecimal(num / 16) + "B";
                case 12:
                    return decimal2Hexadecimal(num / 16) + "C";
                case 13:
                    return decimal2Hexadecimal(num / 16) + "D";
                case 14:
                    return decimal2Hexadecimal(num / 16) + "E";
                case 15:
                    return decimal2Hexadecimal(num / 16) + "F";
                default:
                    return decimal2Hexadecimal(num / 16) + rem;
            }
        } else {
            return "";
        }
    }

    public static String convertIpAdress(String[] str, int i) {

        if (i == str.length - 1)
            return decimal2Binary(Integer.parseInt(str[i]));

        return decimal2Binary(Integer.parseInt(str[i])) + "." + convertIpAdress(str, ++i);
    }
    public static String convertMacAdress(String[] str,int i) {


        if( i == str.length-1)return decimal2Hexadecimal(Integer.parseInt(str[i]));
        return decimal2Hexadecimal(Integer.parseInt(str[i])) + ":" + convertMacAdress(str,++i);
    }


}












    






