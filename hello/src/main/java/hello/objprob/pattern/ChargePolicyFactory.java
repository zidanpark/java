package hello.objprob.pattern;

import hello.objprob.charge.ChargePolicy;
import hello.objprob.charge.FlatRateChargePolicy;
import hello.objprob.charge.VoiceChargePolicy;

public class ChargePolicyFactory extends PolicyFactory {
    @Override
    public ChargePolicy createPolicy(String type) {
        switch ( type ) {
            case "FlatRate" : return new FlatRateChargePolicy();
            case "Voice" : return new VoiceChargePolicy();
        }

        return null;
    }
}
