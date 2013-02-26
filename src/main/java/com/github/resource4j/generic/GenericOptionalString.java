package com.github.resource4j.generic;

import com.github.resource4j.MandatoryString;
import com.github.resource4j.MissingValueException;
import com.github.resource4j.OptionalString;
import com.github.resource4j.OptionalValue;
import com.github.resource4j.ResourceKey;

public class GenericOptionalString extends GenericResourceString implements OptionalString {

    public GenericOptionalString(ResourceKey key, String value) {
        super(key, value);
    }

    @Override
    public String orDefault(String defaultValue) {
        if (defaultValue == null) throw new IllegalArgumentException("defaultValue");
        if (value == null) return defaultValue;
        return value;
    }

    @Override
    public MandatoryString or(String defaultValue) {
        if (defaultValue == null) throw new IllegalArgumentException("defaultValue");
        return new GenericMandatoryString(key, value == null ? defaultValue : value);
    }

    @Override
    public MandatoryString notNull() throws MissingValueException {
        return new GenericMandatoryString(key, value);
    }

    @Override
    public <T> OptionalValue<T> ofType(Class<T> type) {
        return new GenericOptionalValue<T>(key, as(type));
    }

}
