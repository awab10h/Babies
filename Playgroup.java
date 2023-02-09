
//Subclass
public class Playgroup extends Baby {

    public Playgroup(String name, int age) {
        super(name, age);
    }

    @Override
    public String BabySound() {
        return "Baby Sound is Happy";
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
        return this.getName().equals(((Playgroup) o).getName()) && this.getAge() == ((Playgroup) o).getAge();
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    @Override
    public String toString() {
        return "Name: " + this.getName() + " Age: " + this.getAge();
    }

}
