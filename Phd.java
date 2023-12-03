/**
 * The `Phd` class extends the `Student` class and represents a phd student.
 */
public class Phd extends Student {
    /**
     * Constructs an `Phd` object with the specified attributes.
     *
     * @param name        The name of the phd student.
     * @param address     The address of the phd student.
     * @param phoneNumber The phone number of the phd student.
     * @param email       The email address of the phd student.
     * @param idNumber    The ID number of the phd student.
     * @param program     The program of the phd student.
     */
    public Phd(String name, String address, String phoneNumber, String email, int idNumber, String program) {
        super(name, address, phoneNumber, email, idNumber, "Phd", program);
    }
}
