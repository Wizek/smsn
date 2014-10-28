package net.fortytwo.extendo.brain.rdf.classes;

import net.fortytwo.extendo.brain.rdf.SimpleAtomClass;

import java.util.regex.Pattern;

/**
 * @author Joshua Shinavier (http://fortytwo.net)
 */
public class ISBNReference extends SimpleAtomClass {
    public static final ISBNReference INSTANCE = new ISBNReference();

    public ISBNReference() {
        super(
                "isbn",
                Pattern.compile("ISBN: .+"),
                null,
                null
                );
    }
}