package arm.davsoft.dynamicqrgenerator.controller;

import arm.davsoft.dynamicqrgenerator.helpers.util.QRGenerator;
import arm.davsoft.dynamicqrgenerator.model.Person;
import arm.davsoft.dynamicqrgenerator.model.impl.QRTypeMeCard;
import com.google.zxing.WriterException;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.time.LocalDate;

/**
 * @author David Shahbazyan
 * @since Mar 23, 2017
 */
public class MainController {
    private Person person;

    public MainController() {
    }

    @PostConstruct
    private void initPerson() {
        this.person = new Person(1)
                .setFirstName("Lusine")
                .setLastName("Shirinyan")
                .setCompany("Synergy International Systems")
                .setBirthDate(LocalDate.now().minusYears(23))
                .setPhone("+37494171106")
                .setEmail("lusine.shirinyan@arm.synisys.com")
                .setAddress("H.Nersisyan 6a shenq bn.9")
                .setWebsite("www.blah.com")
                .setNote("blah blah blah")
        ;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getImage() throws IOException, WriterException {
//        return "data:image/png;base64,";
        QRTypeMeCard data = new QRTypeMeCard()
                .setName(person.getFirstName() + ' ' + person.getLastName())
                .setPhone(person.getPhone())
                .setCompany(person.getCompany())
                .setPhone(person.getPhone())
                .setEmail(person.getEmail())
                .setAddress(person.getAddress())
                .setWebsite(person.getWebsite())
                .setNote(person.getNote());
        return "data:image/png;base64," + QRGenerator.generateImageAsBase64(data);
    }
}
