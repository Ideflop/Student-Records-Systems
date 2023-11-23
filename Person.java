public class Person {
    private String name;
    private String address;
    private String phoneNumber;
    private String email;

    public Person() {
        this("");
    }

    public Person(String name) {
        this(name, "", "", "");
    }

    public Person(String name, String address) {
        this(name, address, "", "");
    }

    public Person(String name, String address, String phoneNumber) {
        this(name, address, phoneNumber, "");
    }

    public Person(String name, String address, String phoneNumber, String email) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String toString() {
        return String.format(" Name: %s%n Address: %s%n Phone: %s%n Email: %s", this.name, this.address, this.phoneNumber, this.email);
    }
}

