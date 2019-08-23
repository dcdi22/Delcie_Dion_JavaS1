package com.company;

public class CustomerAccount {

    // Has-a relationship
    // Customer `has a`(n) Address

    /*
    Steps
    1. Add properties/ variables
    2. Add any necessary methods ~~~
    3. Generate getters
    4. Generate setters
    5. Make a default constructor
     */

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;

    private Address shippingAddress;
    private Address billingAddress;

    private RewardsCard rewardsCard;
    private boolean isRewardsMember; // is the customer a rewards member


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Address getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(Address shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Address getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(Address billingAddress) {
        this.billingAddress = billingAddress;
    }

    public RewardsCard getRewardsCard() {
        return rewardsCard;
    }

    public void setRewardsCard(RewardsCard rewardsCard) {
        this.rewardsCard = rewardsCard;
    }

    public boolean isRewardsMember() {
        return isRewardsMember;
    }

    public void setRewardsMember(boolean rewardsMember) {
        isRewardsMember = rewardsMember;
    }

    public CustomerAccount() {
    }
}
