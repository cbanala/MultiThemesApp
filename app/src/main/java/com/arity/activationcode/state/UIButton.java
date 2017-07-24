package com.arity.activationcode.state;

import com.arity.activationcode.beans.Property;

import java.util.List;

public class UIButton {
    private final List<Property> properties;

    public UIButton(List<Property> properties) {
        this.properties=properties;
    }

    public List<Property> getProperties() {
        return properties;
    }

}
