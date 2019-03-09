package PetAssignment;

public class Dog extends Pet implements Boardable{
    private String size;
    public int startMonth, startDay,startYear,endMonth,endDay,endYear;

    public Dog(String name,String ownerName,String color,String size){
        super(name,ownerName,color);
        this.size=size;
    }

    String getSize(){
        return size;
    }

    public void setBoardStart(int month,int day, int year){
        this.startMonth=month;
        this.startDay=day;
        this.startYear=year;
    }
    public void setBoardEnd(int month, int day, int year){
        this.endMonth=month;
        this.endDay=day;
        this.endYear=year;
    }

    public boolean boarding(int month,int day,int year){
        //return true if the given data is between the start and end date, return false if else
        if(month>=this.startMonth&&month<=this.endMonth&&day>=this.startDay&&day<=this.endDay&&year>=this.startYear&&year<=this.endYear){
            return true;
        }else{
            return false;
        }
    }


    public String toString(){
        return "DOG :\n"+
                super.getPetName()+" ownered by "+super.getOwnerName()+
                "\nColor: "+super.getColor()+"\nSex: "+super.getSex()+
                "\nSize: "+this.getSize()+"\n";

    }
    public static void main(String[]args){
        Dog d=new Dog("Spot","Susan","White","medium");
        d.setSex(2);
        System.out.println(d);
    }
}
