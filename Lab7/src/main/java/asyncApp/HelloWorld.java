package asyncApp;

public class HelloWorld {

    private String name;
    private String familyName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFamilyName() {
        return familyName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public void say(String message) {
        System.out.println(message);
    }

    public void sayToPerson(String message, String name) {
        System.out.println(name + ", " + message);
    }
}