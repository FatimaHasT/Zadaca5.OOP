package org.FatimaHasT.qamp.zadaci.zadaca9.FinalTask;

public class Owner {
    private final String firstName;
    private final String lastName;
    private final String address;

    public Owner(final String firstName,
                 final String lastName,
                 final String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    @Override
    public String toString() {
        return firstName + ", " + lastName + ", " + address;
    }
}

