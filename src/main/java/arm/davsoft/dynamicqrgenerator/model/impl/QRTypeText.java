package arm.davsoft.dynamicqrgenerator.model.impl;

import arm.davsoft.dynamicqrgenerator.model.api.QRType;

/**
 * @author David Shahbazyan
 * @since Mar 04, 2017
 */
public class QRTypeText implements QRType {
    private String text;

    public QRTypeText setText(String text) {
        this.text = text;
        return this;
    }

    @Override
    public String getData() {
        return text;
    }
}
