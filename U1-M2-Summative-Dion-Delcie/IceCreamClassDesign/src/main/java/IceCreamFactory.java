public class IceCreamFactory {

    /*
    Steps
    1. Add properties/ variables
    2. Add any necessary methods
    3. Generate getters
    4. Generate setters
    5. Make a default constructor
     */

    private int heavyCream;
    private int wholeMilk;
    private int eggs;
    private int sugar;
    private int salt;
    private int flavours; // umbrella term for all other flavouring ingredients

    private String suppliers;
    private String retailAddress;

    public void blendIngredients(int heavyCream, int wholeMilk, int eggs, int sugar, int salt) {
        // The milk fat source, nonfat solids, stabilizers and emulsifiers are blended to ensure complete mixing of liquid and dry ingredients.
    }

    public void addFlavourings(String blendedBase, int flavours ) {
        // flavoured ice cream
    }

    public void packageUp(String flavouredIc, String packageMaterials) {
        // package ice cream
    }

    public void shipOut(String packagedIc, String retailAddress) {
        // ship to ice cream store front
    }

    public IceCreamFactory() {
    }
}
