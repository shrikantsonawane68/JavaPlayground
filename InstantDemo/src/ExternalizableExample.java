import java.io.*;

class PersonExt implements Externalizable {
    private String name;
    private int age;
    private String password; // no transient here, externalizable gives full control

    public PersonExt() {
        // Default constructor is required for Externalizable
    }

    public PersonExt(String name, int age, String password) {
        this.name = name;
        this.age = age;
        this.password = password;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name); // Manually write the fields
        out.writeInt(age);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject(); // Manually read the fields
        age = in.readInt();
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + "}";
    }
}

public class ExternalizableExample {
    public static void main(String[] args) {
        PersonExt personext = new PersonExt("John Doe", 30, "secret");

        // Serialize the object
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person_ext.ser"))) {
            oos.writeObject(personext);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Deserialize the object
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person_ext.ser"))) {
            PersonExt deserializedPersonExt = (PersonExt) ois.readObject();
            System.out.println(deserializedPersonExt);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
