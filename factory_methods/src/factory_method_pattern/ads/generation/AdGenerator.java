package factory_method_pattern.ads.generation;

import factory_method_pattern.ads.entities.Advertisement;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public abstract class AdGenerator
{
    private Random random = new Random();
    private List<Advertisement> ads;
    
    public AdGenerator() { /* ... */ }
    
    public abstract IRegionalGenerator getGenerator();
    
    public Advertisement showAd()
    {
        //get our regional ads if not loaded
        if (ads == null)
        {
            ads = getGenerator().getAppropriateAds();
        }
        
        //pick a random advertisement to show
        return ads.get(random.nextInt(ads.size()));
    }
    
    public List<Advertisement> getAllAds()
    {
        //get our regional ads if not loaded
        if (ads == null)
        {
            ads = getGenerator().getAppropriateAds();
        }

        // this ensures encapsulation of the list
        return Collections.unmodifiableList(ads);
    }

    private void getAdsIfNotLoaded() {
        if (ads == null){
            IRegionalGenerator generator = getGenerator();
            ads = generator.getAppropriateAds();
        }
    }
}

