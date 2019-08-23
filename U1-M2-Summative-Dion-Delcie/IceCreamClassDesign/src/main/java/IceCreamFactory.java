public class IceCreamFactory {

    /*
    Steps
    1. Add properties/ variables
    2. Add any necessary methods
    3. Generate getters
    4. Generate setters
    5. Make a default constructor
     */

    //============== Properties ==============

    private int heavyCream;
    private int wholeMilk;
    private int eggs;
    private int sugar;
    private int salt;
    private int flavours; // umbrella term for all other flavouring ingredients

    private String suppliers;
    private String retailAddress;

    //============== Methods ==============

    public void blendIngredients(int heavyCream, int wholeMilk, int eggs, int sugar, int salt) {
        // The milk fat source, nonfat solids, stabilizers and emulsifiers
        // are blended to ensure complete mixing of liquid and dry ingredients.
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

    //============== Constructor ==============

    public IceCreamFactory() {
    }

    //============== Getters & setters ==============

    public int getHeavyCream() {
        return heavyCream;
    }

    public void setHeavyCream(int heavyCream) {
        this.heavyCream = heavyCream;
    }

    public int getWholeMilk() {
        return wholeMilk;
    }

    public void setWholeMilk(int wholeMilk) {
        this.wholeMilk = wholeMilk;
    }

    public int getEggs() {
        return eggs;
    }

    public void setEggs(int eggs) {
        this.eggs = eggs;
    }

    public int getSugar() {
        return sugar;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    public int getSalt() {
        return salt;
    }

    public void setSalt(int salt) {
        this.salt = salt;
    }

    public int getFlavours() {
        return flavours;
    }

    public void setFlavours(int flavours) {
        this.flavours = flavours;
    }

    public String getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(String suppliers) {
        this.suppliers = suppliers;
    }

    public String getRetailAddress() {
        return retailAddress;
    }

    public void setRetailAddress(String retailAddress) {
        this.retailAddress = retailAddress;
    }
}
