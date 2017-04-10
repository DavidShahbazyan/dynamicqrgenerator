package arm.davsoft.dynamicqrgenerator.helpers.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * @author David Shahbazyan
 * @since Mar 24, 2017
 */
public class LocalDateTimeConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        return LocalDate.parse(value);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        LocalDate dateValue = (LocalDate) value;
        return dateValue.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }
}
