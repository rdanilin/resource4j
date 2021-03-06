package com.github.resource4j.files;

import java.io.IOException;

import com.github.resource4j.ResourceException;
import com.github.resource4j.ResourceKey;

public class MissingResourceFileException extends ResourceException {

    private static final long serialVersionUID = 1L;

    private ResourceKey key;

    public MissingResourceFileException(ResourceKey key) {
        super(key.toString());
        this.key = key;
    }

    public MissingResourceFileException(ResourceKey key, String actualFileName) {
        super(key.toString() + " -> " + actualFileName);
        this.key = key;
    }

    public MissingResourceFileException(ResourceKey key, IOException reason) {
        super(key.toString(), reason);
        this.key = key;
    }

    public ResourceKey getResourceKey() {
        return key;
    }


}
