package lesson08.transport;

import javax.xml.crypto.Data;

public class Driver implements CarForDriver{
    private String driverName;
    private String driverSurname;
    private DriverLicence driverLicence;
    private String softSkills;

    public Driver(String driverName, String driverSurname,
                  DriverLicence driverLicence, String softSkills) {
        this.driverName = driverName;
        this.driverSurname = driverSurname;
        this.driverLicence = driverLicence;
        this.softSkills = softSkills;
    }

    @Override
    public DriverLicence getDriverLicence() {
        return driverLicence;
    }

    public String getDriverName() {
        return driverName;
    }

    public String getDriverSurname() {
        return driverSurname;
    }

    public String getSoftSkills() {
        return softSkills;
    }
}
