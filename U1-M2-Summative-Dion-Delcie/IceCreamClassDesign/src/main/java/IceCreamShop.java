public class IceCreamShop {

    /*
    Steps
    1. Add properties/ variables
    2. Add any necessary methods
    3. Generate getters
    4. Generate setters
    5. Make a default constructor
     */


    //============== Properties ==============

    private String iceCreamStyle; // ice cream, frozen yogurt, sherbet/sorbet
    private String flavour; // or String[] with array of different flavours
    private boolean cone; // cup or cone
    private String coneType; // waffle, sugar

    private int amountPerFlavourAvailable; // for keeping track of inventory

    private int cost;
    private String paymentType; // cash or card
    private boolean coupons;

    //============== Methods ==============

    public void restock(int amountPerFlavourAvailable) {
        // if less than x amount order more
    }

    public void discount(boolean coupons) {
        // if coupons true subtract discount from cost
    }

    public void whatWouldYouLike(String iceCreamStyle, String flavour, boolean cone, String coneType) {
        // System.out.println("You want a " + flavour + iceCreamStyle + " in a " + coneType + " cone");
    }

    //============== Constructor ==============

    public IceCreamShop() {
    }


    //============== Getters & setters ==============

    public String getIceCreamStyle() {
        return iceCreamStyle;
    }

    public void setIceCreamStyle(String iceCreamStyle) {
        this.iceCreamStyle = iceCreamStyle;
    }

    public String getFlavour() {
        return flavour;
    }

    public void setFlavour(String flavour) {
        this.flavour = flavour;
    }

    public boolean isCone() {
        return cone;
    }

    public void setCone(boolean cone) {
        this.cone = cone;
    }

    public String getConeType() {
        return coneType;
    }

    public void setConeType(String coneType) {
        this.coneType = coneType;
    }

    public int getAmountPerFlavourAvailable() {
        return amountPerFlavourAvailable;
    }

    public void setAmountPerFlavourAvailable(int amountPerFlavourAvailable) {
        this.amountPerFlavourAvailable = amountPerFlavourAvailable;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public boolean isCoupons() {
        return coupons;
    }

    public void setCoupons(boolean coupons) {
        this.coupons = coupons;
    }
}
