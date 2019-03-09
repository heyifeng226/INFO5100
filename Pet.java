package PetAssignment;

public class Pet {

    private String name;
    private String ownerName;
    private String color;

    protected int sex;

    protected enum sex {
        MALE, FEMALE, SPAYED, NEUTERED
    }

    public static final int MALE = 0;
    public static final int FEMALE = 1;
    public static final int SPAYED = 2;
    public static final int NEUTERED = 3;

    //constructor
    public Pet(String name, String ownerName, String color) {
        this.name = name;
        this.ownerName = ownerName;
        this.color = color;
    }

    String getPetName() {
        return this.name;
    }

    String getOwnerName() {
        return this.ownerName;
    }

    String getColor() {
        return this.color;
    }

    void setSex(int sexid) {
        if (0 <= sexid && 3 >= sexid) {
            this.sex = sexid;
        } else {
            return;
        }
    }

    String getSex() {
        if (this.sex == MALE) {
            return "MALE";
        } else if (this.sex ==FEMALE) {
            return "FEMALE";
        } else if (this.sex == SPAYED) {
            return "SPAYED";
        } else if(this.sex==NEUTERED){
            return "NEUTERED";
        }else{
            return"no gender";
        }

    }

    public String toString() {
        return this.getPetName() + " owned by " + this.getOwnerName() + "\nColor: " + this.getColor()
                + "\nSex :" + this.getSex() + "\n";
    }

    public static void main(String[]args){
        Pet p=new Pet("Spot","Mary","Black and White");
        p.setSex(0);
        System.out.println(p);
    }
}
