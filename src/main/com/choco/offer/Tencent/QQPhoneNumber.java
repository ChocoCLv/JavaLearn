package com.choco.offer.Tencent;


import java.util.Scanner;

/**
 * TestCase
 * 2
 * 11
 * 88888888888
 * 3
 * 000
 */
public class QQPhoneNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCaseNum = scanner.nextInt();
        while (testCaseNum > 0) {
            int phoneNumberLength = scanner.nextInt();
            String phoneNumber = scanner.next();
            if (validateQQPhoneNumber(phoneNumber)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
            testCaseNum--;
        }
    }

    private static boolean validateQQPhoneNumber(String phone) {
        if(phone == null || phone.length() < 11){
            return false;
        }
        if(phone.length() == 11 && phone.charAt(0) == '8'){
            return true;
        }
        int indexOf8 = phone.indexOf('8');
        if(indexOf8 == -1){
            return false;
        }
        if(phone.length() - indexOf8 >= 11){
            return true;
        }
        return false;
    }
}
