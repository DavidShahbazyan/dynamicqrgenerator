package arm.davsoft.dynamicqrgenerator.model;

import java.time.LocalDate;

/**
 * @author David Shahbazyan
 * @since Mar 23, 2017
 */
public class Person {
    private Integer id;
    private String fName;
    private String lName;
    private LocalDate bDate;
    private String phone1;


    public Person(Integer id, String fName, String lName, LocalDate bDate, String phone1) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.bDate = bDate;
        this.phone1 = phone1;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public LocalDate getbDate() {
        return bDate;
    }

    public void setbDate(LocalDate bDate) {
        this.bDate = bDate;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }
}
