package factory_method_pattern.ads.generation.regions;

import factory_method_pattern.ads.entities.Advertisement;
import factory_method_pattern.ads.generation.IRegionalGenerator;

import java.util.List;

public class MontanaAds implements IRegionalGenerator {
    @Override
    public List<Advertisement> getAppropriateAds() {
        return List.of(
                new Advertisement("Mountainee Montana"),
                new Advertisement("I got the horses in the back"),
                new Advertisement("Yee Haw")
        );
    }
}
