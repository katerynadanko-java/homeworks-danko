package lesson04.com.company.controller;

import lesson04.com.company.view.View;

import java.util.Scanner;

import static lesson04.com.company.controller.RegexContainer.*;
import static lesson04.com.company.view.TextConstant.*;


/**
 * Created by student on 03.09.2021.
 */
public class InputNoteNoteBook {
    private View view;
    private Scanner sc;

    private String firstName;
    private String login;
    private String surname;
    private String lastName;
    private String nickname;
    private String comment;
    private String personalData;
    private String enteredDate;
    private String group;
    private String homePhone;
    private String mobPhone;
    private String mob2Phone;
    private String email;
    private String skype;
    private String address;
    private String postCode;
    private String city;
    private String street;
    private String houseNumber;
    private String flatNumber;
    private String modificationDate;
    private String entryDate;

    public InputNoteNoteBook(View view, Scanner sc) {
        this.view = view;
        this.sc = sc;
    }

    public void inputNote() {
        UtilityController utilityController =
                new UtilityController(sc, view);
        String strFirstName = (String.valueOf(View.bundle.getLocale()).equals("ua"))
                ? REGEX_NAME_UKR : REGEX_NAME_LAT;

        String strSurname = (String.valueOf(View.bundle.getLocale()).equals("ua"))
                ? REGEX_SURNAME_UKR : REGEX_SURNAME_LAT;

        String strLastName = (String.valueOf(View.bundle.getLocale()).equals("ua"))
                ? REGEX_LAST_NAME_UKR : REGEX_LAST_NAME_LAT;

        String strComment = (String.valueOf(View.bundle.getLocale()).equals("ua"))
                ? REGEX_COMMENT_UKR : REGEX_COMMENT_LAT;

        String strCity = (String.valueOf(View.bundle.getLocale()).equals("ua"))
                ? REGEX_CITY_UKR : REGEX_CITY_LAT;
        String strStreet = (String.valueOf(View.bundle.getLocale()).equals("ua"))
                ? REGEX_STREET_UKR : REGEX_STREET_LAT;

        this.firstName =
                utilityController.inputStringValueWithScanner
                        (FIRST_NAME, strFirstName);
        this.login =
                utilityController.inputStringValueWithScanner
                        (LOGIN_DATA, REGEX_LOGIN);

        this.surname =
                utilityController.inputStringValueWithScanner
                        (SURNAME, strSurname);
        this.lastName =
                utilityController.inputStringValueWithScanner
                        (LAST_NAME, strLastName);
        this.nickname =
                utilityController.inputStringValueWithScanner
                        (NICKNAME, REGEX_NICKNAME);
        this.comment =
                utilityController.inputStringValueWithScanner
                        (COMMENT, strComment);
        this.personalData = this.surname + " " + this.firstName.substring(0, 1) + ".";

        this.enteredDate = utilityController.inputStringValueWithScanner
                (ENTRY_DATE, REGEX_DATE);

        this.group = utilityController.inputStringValueWithScanner
                (GROUP, REGEX_GROUP);

        this.homePhone =
                utilityController.inputStringValueWithScanner
                        (HOME_PHONE, REGEX_PHONE);
        this.mobPhone =
                utilityController.inputStringValueWithScanner
                        (MOB_PHONE, REGEX_PHONE);
        this.mob2Phone =
                utilityController.inputStringValueWithScanner
                        (MOB_2_PHONE, REGEX_PHONE);
        this.email =
                utilityController.inputStringValueWithScanner
                        (EMAIL, REGEX_EMAIL);
        this.skype =
                utilityController.inputStringValueWithScanner
                        (SKYPE, REGEX_SKYPE);
        this.postCode =
                utilityController.inputStringValueWithScanner
                        (POST_CODE, REGEX_POST_CODE);
        this.city =
                utilityController.inputStringValueWithScanner
                        (CITY, strCity);
        this.street =
                utilityController.inputStringValueWithScanner
                        (STREET, strStreet);
        this.houseNumber =
                utilityController.inputStringValueWithScanner
                        (HOSE_NUMBER, REGEX_HOSE_NUMBER);
        this.flatNumber =
                utilityController.inputStringValueWithScanner
                        (FLAT_NUMBER, REGEX_FLAT_NUMBER);

        this.address = postCode + city + street + houseNumber + flatNumber;

        this.modificationDate =
                utilityController.inputStringValueWithScanner
                        (MODIFICATION_DATE, REGEX_DATE);
        this.enteredDate =
                utilityController.inputStringValueWithScanner
                        (ENTRY_DATE, REGEX_DATE);

    }
}
