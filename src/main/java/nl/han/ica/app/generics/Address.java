package nl.han.ica.app.generics;

public class Address implements Comparable<Address>{

    private String street;
    private int houseNumber;

    public Address(String street, int houseNumber) {
        this.street = street;
        this.houseNumber = houseNumber;
    }

    @Override
    public int compareTo(Address other) {
        if(this.street.compareTo(other.street) == 0) {
            return this.houseNumber - other.houseNumber;
        }
        return this.street.compareTo(other.street);
    }

    @Override
    public String toString() {
        return street + " " + houseNumber;
    }
}
