package net.fortytwo.smsn.monitron.listeners.sensors;

import com.illposed.osc.OSCMessage;
import net.fortytwo.smsn.monitron.Context;
import net.fortytwo.smsn.monitron.data.BooleanData;
import net.fortytwo.smsn.monitron.events.MonitronEvent;
import net.fortytwo.smsn.monitron.events.MotionObservation;
import org.openrdf.model.IRI;

public class PassiveInfraredSensorListener extends SensorListener {

    public PassiveInfraredSensorListener(final Context context,
                                         final IRI sensor) {
        super(context, sensor);
    }

    protected MonitronEvent handleMessage(final OSCMessage m) throws MessageParseException {
        BooleanData s = new BooleanData();

        int i = 0;

        s.setSampleIntervalBeginning(timeArg(m, i++));
        s.setSampleIntervalEnd(timeArg(m, i++));
        s.setTotalMeasurements(longArg(m, i++));
        s.setResult(booleanArg(m, i));

        return handleSample(s);
    }

    protected MonitronEvent handleSample(final BooleanData data) {
        return new MotionObservation(context, sensor, data);
    }
}
