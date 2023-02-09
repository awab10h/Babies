
//SuperClass
public class Baby implements BabyInterface {

    //Static class member
    public static int babyNumbers = 0;
    private String name;
    private int age;

    public Baby(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //Superclass accessor and mutators
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     *
     * @return
     */
    @Override
    public String BabySound() {
        return "Baby Sound is Neutral";
    }

    //Method Overloading
    @Override
    public String BabySound(String message) {
        return message;
    }

    @Override
    public String toString() {
        return "Name: " + this.getName() + " Age: " + this.getAge();
    }

}
