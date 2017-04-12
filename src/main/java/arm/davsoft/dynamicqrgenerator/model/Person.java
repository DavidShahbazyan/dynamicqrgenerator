package arm.davsoft.dynamicqrgenerator.model;

import java.time.LocalDate;

/**
 * @author David Shahbazyan
 * @since Mar 23, 2017
 */
public class Person {
    private Integer id;
    private String firstName;
    private String lastName;
    private String company;
    private LocalDate birthDate;
    private String phone;
    private String email;
    private String address;
    private String website;
    private String note;

    public Person(Integer id) {
        this.id = id;
    }


    public Integer getId() {
        return id;
    }
    public Person setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }
    public Person setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }
    public Person setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getCompany() {
        return company;
    }
    public Person setCompany(String company) {
        this.company = company;
        return this;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }
    public Person setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
        return this;
    }

    public String getPhone() {
        return phone;
    }
    public Person setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }
    public Person setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getAddress() {
        return address;
    }
    public Person setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getWebsite() {
        return website;
    }
    public Person setWebsite(String website) {
        this.website = website;
        return this;
    }

    public String getNote() {
        return note;
    }
    public Person setNote(String note) {
        this.note = note;
        return this;
    }
}
