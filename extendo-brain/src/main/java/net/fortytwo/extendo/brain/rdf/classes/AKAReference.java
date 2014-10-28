package net.fortytwo.extendo.brain.rdf.classes;

import net.fortytwo.extendo.brain.rdf.SimpleAtomClass;

import java.util.regex.Pattern;

/**
 * @author Joshua Shinavier (http://fortytwo.net)
 */
public class AKAReference extends SimpleAtomClass {
    public static final AKAReference INSTANCE = new AKAReference();

    public AKAReference() {
        super(
                "aka",
                Pattern.compile("aka \\\"[^\\\"]+\\\"(, \\\"[^\\\"]+\\\")*"),
                null,
                null
                );
    }

    public static String extractAlias(final String value) {
        int i = value.indexOf('\"');
        int j = value.lastIndexOf('\"');
        return value.substring(i + 1, j);
    }
}