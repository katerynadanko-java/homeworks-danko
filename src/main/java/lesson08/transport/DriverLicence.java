package lesson08.transport;

import javax.xml.crypto.Data;

public class DriverLicence {

    private Category category;
    private String licenceNumber;

    public DriverLicence(Category category, String licenceNumber) {
        this.category = category;
        this.licenceNumber = licenceNumber;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getLicenceNumber() {
        return licenceNumber;
    }

    public void setLicenceNumber(String licenceNumber) {
        this.licenceNumber = licenceNumber;
    }
}
