
//Subclass
public class Patient extends Baby {

    private int id;

    public Patient(String name, int age, int id) {
        super(name, age);
        this.id = id;
    }

    @Override
    public String BabySound() {
        return "Baby Sound is Sick";
    }

    //Subclass Accessor and mutator
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        return this.getId() == ((Patient) o).getId();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public String toString() {
        return "Name: " + this.getName() + " Age: " + this.getAge() + " ID: " + this.getId();
    }

}
