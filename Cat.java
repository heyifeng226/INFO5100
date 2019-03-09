package PetAssignment;

public class Cat extends Pet implements Boardable{
    private String hairLength;
    public int startMonth,startDay,startYear,endMonth,endDay,endYear;

    public Cat(String name,String ownerName,String color,String hairLength){
        super(name,ownerName,color);
        this.hairLength=hairLength;
    }

    String getHairLength(){
        return this.hairLength;
    }

    public void setBoardStart(int month,int day,int year){
        this.startMonth=month;
        this.startDay=day;
        this.startYear=year;

    }
    public void setBoardEnd(int month,int day, int year){
        this.endMonth=month;
        this.endDay=day;
        this.endYear=year;
    }

    public boolean boarding (int month,int day,int year){
        //return true if the given data is between the start and end date, return false if else
        if (month>=this.startMonth&&month<=this.endMonth) {
            if (day >= this.startDay && day <= this.endDay) {
                if (year >= this.startYear && year <= this.endYear) {
                    return true;
                }
            }
        }
        return false;

    }

    public String toString(){
        return "CAT :\n"+
                super.getPetName()+" ownered by "+super.getOwnerName()+
                "\nColor: "+super.getColor()+"\nSex: "+super.getSex()+
                "\nHair: "+this.getHairLength()+"\n";

    }

    public static void main(String[]args){
        Cat c=new Cat("Tom","Bob","black","short");
        c.setSex(2);
        System.out.println(c);
    }
}
