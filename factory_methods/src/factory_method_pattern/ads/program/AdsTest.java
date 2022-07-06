package factory_method_pattern.ads.program;

import factory_method_pattern.ads.generation.AdGenerator;
import factory_method_pattern.ads.generation.generators.FloridaAdGenerator;
import factory_method_pattern.ads.generation.generators.MontanaAdGenerator;

public class AdsTest
{
    public static void main(String[] args)
    {
        AdGenerator generator = new FloridaAdGenerator();
        for (int i = 0; i < 5; i++) {
            System.out.println(generator.showAd());
        }
        System.out.println();

        AdGenerator generatorM = new MontanaAdGenerator();
        for (int i = 0; i < 5; i++) {
            System.out.println(generatorM.showAd());
        }
    }
}



