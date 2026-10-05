//   Day 5  4th Question  Contact with validation

class Contact {
    private String name;
    private String email;
    private String phone;

    Contact(String name, String email, String phone) {
        this.name = name;
        setEmail(email);
        setPhone(phone);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email != null && email.contains("@") && email.contains(".")) {
            this.email = email;
        } else {
            System.out.println("Invalid email: " + email + ". Email must contain '@' and '.'.");
        }
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if (isTenDigits(phone)) {
            this.phone = phone;
        } else {
            System.out.println("Invalid phone: " + phone + ". Phone must be exactly 10 digits.");
        }
    }

    private boolean isTenDigits(String s) {
        if (s == null || s.length() != 10) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}

public class ContactDemo {
    public static void main(String[] args) {
        Contact c = new Contact("Deepak S R", "deepak@example.com", "9876543210");
        System.out.println("Name  : " + c.getName());
        System.out.println("Email : " + c.getEmail());
        System.out.println("Phone : " + c.getPhone());
        System.out.println();

        c.setEmail("raviexample.com");
        c.setPhone("12345");
        c.setPhone("98765abcde");

        System.out.println();
        System.out.println("Email after invalid updates : " + c.getEmail());
        System.out.println("Phone after invalid updates : " + c.getPhone());
    }
}