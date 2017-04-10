package arm.davsoft.dynamicqrgenerator.model.impl;

import arm.davsoft.dynamicqrgenerator.model.api.QRType;

/**
 * @author David Shahbazyan
 * @since Mar 04, 2017
 */
public class QRTypeEmail implements QRType {
    private String email;

    public QRTypeEmail setEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public String getData() {
        return String.format("mailto:%s", email);
    }
}
