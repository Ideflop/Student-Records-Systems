/**
     * Constructs a `Masters` object with the specified attributes.
     * @param name        The name of the masters student.
     * @param address     The address of the  student.
     * @param phoneNumber The phone number of the masters student.
     * @param email       The email address of the masters student.
     * @param idNumber    The ID number of the masters student.
     * @param program     The program of the masters student.
     */
public class Masters extends Student {
    public Masters(String name, String address, String phoneNumber, String email, int idNumber, String program) {
        super(name, address, phoneNumber, email, idNumber, "Masters", program);
    }
}
