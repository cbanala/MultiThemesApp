package com.arity.activationcode.state;

import com.arity.activationcode.beans.Property;

import java.util.List;

public class UITextView {

    private final List<Property> properties;

    public UITextView(List<Property> properties) {
        this.properties = properties;
    }

    public List<Property> getProperties() {
        return properties;
    }

}
