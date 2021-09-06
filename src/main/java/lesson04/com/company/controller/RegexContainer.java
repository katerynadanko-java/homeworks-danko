package lesson04.com.company.controller;

/**
 * Created by student on 03.09.2021.
 */
public interface RegexContainer {
    // Cyrillic name
    String REGEX_NAME_UKR = "^[А-ЩЬЮЯҐІЇЄ][а-щьюяґіїє']{1,20}$";
    // Latin name
    String REGEX_NAME_LAT = "^[A-Z][a-z]{1,20}$";
    // login
    String REGEX_LOGIN = "^[A-Za-z0-9_-]{8,20}$";

    String REGEX_SURNAME_UKR = "^[А-ЩЬЮЯҐІЇЄ][а-щьюяґіїє']{1,30}$";
    String REGEX_SURNAME_LAT = "^[A-Z][a-z]{1,30}$";
    String REGEX_LAST_NAME_UKR = "^[А-ЩЬЮЯҐІЇЄ][а-щьюяґіїє']{1,30}$";
    String REGEX_LAST_NAME_LAT = "^[A-Za-z]{1,30}$";
    String REGEX_NICKNAME = "^[A-Za-z_-]{1,30}$";
    String REGEX_COMMENT_UKR = "^[А-ЩЬЮЯҐІЇЄ][а-щьюяґіїє']{1,100}$";
    String REGEX_COMMENT_LAT = "[A-Z][a-z]{1,100}";

    String REGEX_DATE = "^((2000|2400|2800|(19|2[0-9](0[48]|[2468][048]|[13579][26])))-02-29)$"
            + "|^(((19|2[0-9])[0-9]{2})-02-(0[1-9]|1[0-9]|2[0-8]))$"
            + "|^(((19|2[0-9])[0-9]{2})-(0[13578]|10|12)-(0[1-9]|[12][0-9]|3[01]))$"
            + "|^(((19|2[0-9])[0-9]{2})-(0[469]|11)-(0[1-9]|[12][0-9]|30))$";
    String REGEX_GROUP = "^[A-Z]{1,20}$";
    String REGEX_PHONE = "^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$";
    String REGEX_EMAIL = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,6}$";
    String REGEX_SKYPE = "^[A-Z][a-z]{1,30}$";
    String REGEX_POST_CODE = "[0-9]{5}";
    String REGEX_CITY_LAT = "^[A-Za-z]+(?:[\\s'-]+[A-Za-z]+)*(?=\\s+[A-Z]{2}\\s+\\d+-\\d+)";
    String REGEX_CITY_UKR = "^[А-ЩЬЮЯҐІЇЄ][а-щьюяґіїє']+(?:[\\s'-]+[А-ЩЬЮЯҐІЇЄ][а-щьюяґіїє']+)*(?=\\s+[А-ЩЬЮЯҐІЇЄ][а-щьюяґіїє']{2}\\s+\\d+-\\d+)";
    String REGEX_STREET_LAT = "^[A-Za-z]+(?:[\\s'-]+[A-Za-z]+)*(?=\\s+[A-Z]{2}\\s+\\d+-\\d+)";
    String REGEX_STREET_UKR = "^[А-ЩЬЮЯҐІЇЄ][а-щьюяґіїє']+(?:[\\s'-]+[А-ЩЬЮЯҐІЇЄ][а-щьюяґіїє']+)*(?=\\s+[А-ЩЬЮЯҐІЇЄ][а-щьюяґіїє']{2}\\s+\\d+-\\d+)";
    String REGEX_HOSE_NUMBER = "[0-9_A-Za-zА-Яа-я]{1,4}";
    String REGEX_FLAT_NUMBER = "[0-9_A-Za-zА-Яа-я]{1,4}";
    String REGEX_ADDRESS_UKR = REGEX_POST_CODE + REGEX_CITY_UKR + REGEX_STREET_UKR + REGEX_HOSE_NUMBER + REGEX_FLAT_NUMBER;
    String REGEX_ADDRESS_LAT = REGEX_POST_CODE + REGEX_CITY_LAT + REGEX_STREET_LAT + REGEX_HOSE_NUMBER + REGEX_FLAT_NUMBER;

}
