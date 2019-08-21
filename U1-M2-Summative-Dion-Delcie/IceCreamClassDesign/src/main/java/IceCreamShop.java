public class IceCreamShop {

    /*
    Steps
    1. Add properties/ variables
    2. Add any necessary methods
    3. Generate getters
    4. Generate setters
    5. Make a default constructor
     */

    private String iceCreamStyle; // ice cream, frozen yogurt, sherbet/sorbet
    private String flavour; // or String[] with array of different flavours
    private boolean cone; // cup or cone
    private String coneType; // waffle, sugar

    private int amountPerFlavourAvailable; // for keeping track of inventory

    private int cost;
    private String paymentType; // cash or card
    private boolean coupons;

    public void restock(int amountPerFlavourAvailable) {
        // if less than x amount order more
    }

    public void discount(boolean coupons) {
        // if coupons true subtract discount from cost
    }

    public void whatWouldYouLike(String iceCreamStyle, String flavour, boolean cone, String coneType) {
        // System.out.println("You want a " + flavour + iceCreamStyle + " in a " + coneType + " cone");
    }

}
