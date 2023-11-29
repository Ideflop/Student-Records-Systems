/**
     * Constructs an `Undergraduate` object with the specified attributes.
     *
     * @param name        The name of the undergraduate student.
     * @param address     The address of the undergraduate student.
     * @param phoneNumber The phone number of the undergraduate student.
     * @param email       The email address of the undergraduate student.
     * @param idNumber    The ID number of the undergraduate student.
     * @param program     The program of the undergraduate student.
     */
public class Undergraduate extends Student {
    public Undergraduate(String name, String address, String phoneNumber, String email, int idNumber, String program) {
        super(name, address, phoneNumber, email, idNumber, "Undergraduate", program);
    }
}
