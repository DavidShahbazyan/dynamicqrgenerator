package arm.davsoft.dynamicqrgenerator.model.impl;

import arm.davsoft.dynamicqrgenerator.model.api.QRType;

/**
 * @author David Shahbazyan
 * @since Mar 04, 2017
 */
public class QRTypePhoneNumber implements QRType {
    private String phone;

    public QRTypePhoneNumber setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    @Override
    public String getData() {
        return String.format("tel:%s", phone);
    }
}
