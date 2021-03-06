package net.fortytwo.smsn.server.actions;

import net.fortytwo.smsn.brain.model.Note;
import net.fortytwo.smsn.server.ActionContext;
import net.fortytwo.smsn.server.errors.BadRequestException;
import net.fortytwo.smsn.server.errors.RequestProcessingException;

import java.io.IOException;

/**
 * A service for finding root nodes of an Extend-o-Brain graph
 */
public class FindRoots extends BasicViewAction {

    @Override
    protected void performTransaction(final ActionContext context) throws RequestProcessingException, BadRequestException {
        Note n = context.getQueries().findRootAtoms(getFilter(), style, height - 1);
        try {
            addView(n, context);
        } catch (IOException e) {
            throw new RequestProcessingException(e);
        }

        context.getMap().put("title", "all roots");
    }

    @Override
    protected boolean doesRead() {
        return true;
    }

    @Override
    protected boolean doesWrite() {
        return false;
    }
}
