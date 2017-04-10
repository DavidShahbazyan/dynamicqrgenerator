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
        this.person = new Person(1, "Arman", "Petrosyan", LocalDate.now().minusYears(20), "+37496013366");
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getImage() throws IOException, WriterException {
//        return "data:image/png;base64,";
        QRTypeMeCard data = new QRTypeMeCard().setName(person.getfName() + ' ' + person.getlName()).setPhone(person.getPhone1());
        return "data:image/png;base64," + QRGenerator.generateImageAsBase64(data);
    }
}
