public class Person {
    private String name; //The name of the person.
    private String address;//The address of the person.
    private String phoneNumber;//The phone number of the person.
    private String email;//The email address of the person.
    /**
     * Default constructor, initializes a person with an empty name.
     */
    public Person() {
        this("");
    }
    /**
     * Constructor with a specified name, initializes a person with the given name and default values for other attributes.
     *
     * @param name The name of the person.
     */
    public Person(String name) {
        this(name, "", "", "");
    }
    /**
     * Constructor with specified name and address, initializes a person with the given name and address,
     * and default values for other attributes.
     *
     * @param name    The name of the person.
     * @param address The address of the person.
     */
    public Person(String name, String address) {
        this(name, address, "", "");
    }
    /**
     * Constructor with specified name, address, and phone number, initializes a person with the given name, address,
     * phone number, and default value for the email.
     *
     * @param name         The name of the person.
     * @param address      The address of the person.
     * @param phoneNumber  The phone number of the person.
     */
    public Person(String name, String address, String phoneNumber) {
        this(name, address, phoneNumber, "");
    }
     /**
     * Constructor with all attributes specified, initializes a person with the given values for name, address,
     * phone number, and email.
     *
     * @param name         The name of the person.
     * @param address      The address of the person.
     * @param phoneNumber  The phone number of the person.
     * @param email        The email address of the person.
     */
    public Person(String name, String address, String phoneNumber, String email) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    /**
     * Retrieves the name of the person.
     *
     * @return The name of the person.
     */
    public String getName() {
        return name;
    }
    /**
     * Sets the name of the person.
     *
     * @param name The new name of the person.
     */
    public void setName(String name) {
        this.name = name;
    }
     /**
     * Retrieves the address of the person.
     *
     * @return The address of the person.
     */
    public String getAddress() {
        return address;
    }
    /**
     * Sets the address of the person.
     *
     * @param address The new address of the person.
     */
    public void setAddress(String address) {
        this.address = address;
    }
    /**
     * Retrieves the phone number of the person.
     *
     * @return The phone number of the person.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
    /**
     * Sets the phone number of the person.
     *
     * @param phoneNumber The new phone number of the person.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    /**
     * Retrieves the email address of the person.
     *
     * @return The email address of the person.
     */
    public String getEmail() {
        return email;
    }
    /**
     * Sets the email address of the person.
     *
     * @param email The new email address of the person.
     */
    public void setEmail(String email) {
        this.email = email;
    }
     /**
     * @return A formatted string representing the person.
     */
    public String toString() {
        return String.format(" Name: %s%n Address: %s%n Phone: %s%n Email: %s", this.name, this.address, this.phoneNumber, this.email);
    }
}

