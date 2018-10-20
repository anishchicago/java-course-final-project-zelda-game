package _03objects.P8_4;

//Implement a class Address. An address has a house number, a street, an optional apartment number, a city, a state, and a postal code.
// Supply two constructors: one with an apartment number and one without. Supply a print method that prints the address with the street
// on one line and the city, state, and zip code on the next line. Supply a method public­boolean­comesBefore(Address­other) that tests
// whether this address comes before another when the addresses are compared by postal code.

public class Address {

    private int houseNumber;
    private int apartmentNumber;
    private String street;
    private String city;
    private String state;
    private int postCode;

    public Address(int houseNumber, String street, String city, String state, int postCode) {
        this.houseNumber = houseNumber;
        this.street = street;
        this.city = city;
        this.state = state;
        this.postCode = postCode;
    }

    public Address(int houseNumber, String street, String city, String state, int postCode, int apartmentNumber) {
        this.houseNumber = houseNumber;
        this.apartmentNumber = apartmentNumber;
        this.street = street;
        this.city = city;
        this.state = state;
        this.postCode = postCode;
    }

    public void print() {
        if (apartmentNumber == 0) {
            System.out.println(houseNumber + " " + street);
        } else {
            System.out.println(houseNumber + " " + street+ " #" + apartmentNumber);
        }
        System.out.println(city + " " + state + " " + postCode);
    }

    public int getPostCode() {
        return postCode;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public int getApartmentNumber() {
        return apartmentNumber;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public boolean comesBefore(Address otherAddress) {
        if (this.postCode <= otherAddress.getPostCode()) {
            return true;
        } else {
            return false;
        }
    }

}
