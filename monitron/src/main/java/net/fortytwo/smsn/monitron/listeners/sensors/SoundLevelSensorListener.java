package net.fortytwo.smsn.monitron.listeners.sensors;

import net.fortytwo.smsn.monitron.Context;
import net.fortytwo.smsn.monitron.data.GaussianData;
import net.fortytwo.smsn.monitron.events.MonitronEvent;
import net.fortytwo.smsn.monitron.events.SoundLevelObservation;
import org.openrdf.model.IRI;

public class SoundLevelSensorListener extends GaussianSensorListener {

    public SoundLevelSensorListener(final Context context, final IRI sensor) {
        super(context, sensor);
    }

    protected MonitronEvent handleSample(final GaussianData data) {
            return new SoundLevelObservation(context, sensor, data);
    }
}
