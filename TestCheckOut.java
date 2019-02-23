import java.util.Vector;
public class TestCheckOut {
    public static void main(String[]args){
        Checkout checkout=new Checkout();
        checkout.enterItem(new Candy("Peanut Butter Fudge",2.25f,399));
        checkout.enterItem(new IceCream("Vanilla Ice Cream",105));
        checkout.enterItem(new Sundae("Choc.Chip Ice Cream",145,"Hot Fudge",50));
        checkout.enterItem(new Cookie("Oatmeak Raisin Cookies",4,399));
        System.out.println("\nNumber of items: " + checkout.numberOfItems() + "\n");
        System.out.println("\nTotal cost: " + checkout.totalCost() + "\n");
        System.out.println("\nTotal tax: " + checkout.totalTax() + "\n");
        System.out.println("\nCost + Tax: " + (checkout.totalCost()+checkout.totalTax()) +" \n");
        System.out.println(checkout);

        checkout.clear();

        checkout.enterItem(new IceCream("Strawberry Ice Cream",145));
        checkout.enterItem(new Sundae("Vanilla Ice Cream",105,"Caramel",50));
        checkout.enterItem(new Candy("Gummy Worms",1.33f,89));
        checkout.enterItem(new Cookie("Chocolate Chip Cookie",4,399));
        checkout.enterItem(new Candy("Salt Water Taffy",1.5f,209));
        checkout.enterItem(new Candy("Candy Corn",3.0f,109));
        System.out.println("\nNumber of items: " + checkout.numberOfItems() + "\n");
        System.out.println("\nTotal cost: " + checkout.totalCost() + "\n");
        System.out.println("\nTotal tax: " + checkout.totalTax()+ "\n");
        System.out.println("\nCost + Tax: " + (checkout.totalCost()+checkout.totalTax()) + "\n");
        System.out.println(checkout);

    }
}


abstract class DessertItem{
    protected String name;

    //constructor
    public DessertItem(){

    }
    public DessertItem(String name) {
        if(name.length()<=DessertShoppe.maxSizeOfItemName){
            this.name=name;
        }else{
            this.name=name.substring(0,DessertShoppe.maxSizeOfItemName);

        }

    }
    public final String getName(){
        return name;
    }
    public abstract int getCost();


}

class Candy extends DessertItem{
    private float weight;
    private int pricePerPound;

    //constructor
    public Candy(String name,float weight,int pricePerPound){
        super(name);
        this.weight=weight;
        this.pricePerPound=pricePerPound;
    }
    //override
    public int getPricePerPound(){
        return pricePerPound;
    }
    public float getWeight(){
        return weight;

    }
    //cost should be rounded to the nearest cent
    public int getCost(){

        return Math.round(weight*pricePerPound);

    }
}

class Cookie extends DessertItem{
    private int number;
    private int pricePerDozen;
    //constructor
    public Cookie(String name,int number,int pricePerDozen){
        super(name);
        this.number=number;
        this.pricePerDozen=pricePerDozen;
    }
    //override
    public int getPricePerDozen(){
        return pricePerDozen;
    }
    public int getNumber(){
        return number;
    }
    public int getCost(){

        int cookieCost=Math.round(pricePerDozen*number/12);
        return cookieCost;
    }
}
class IceCream extends DessertItem{
    int cost;
    //constructor
    public IceCream(String name, int iceCreamPrice){
        super(name);
        this.cost=iceCreamPrice;
    }
    public int getCost(){
        return this.cost;

    }
}
class Sundae extends IceCream{
    private int ToppingPrice;
    private String name;

    //constructor
    public Sundae(String iceCreamName, int iceCreamPrice, String name,int ToppingPrice){
        super(name + "Sundae with\n" + iceCreamName, iceCreamPrice + ToppingPrice);

    }
    public int getCost(){

        return Math.round(super.getCost());
    }

}

class DessertShoppe{
    static final String storeName="M & M Dessert Shoppe";
    static final float taxrate=6.5f; //6.5%
    static final int maxSizeOfItemName=50;
    static final int maxWidthToDisplayCost=10;

    public static String cents2dollarsAndCentsmethod(int cents){
        int dollar=cents/100;
        double cent=cents%100;
        return String.valueOf(dollar+cent/100);

    }
}

class Checkout{
    public Vector<DessertItem> items;
    public Checkout(){
        this.items=new Vector<DessertItem>();
    }
    public int numberOfItems(){
        return this.items.size();
    }
    public void enterItem(DessertItem item){
        this.items.add(item);
    }
    public void clear(){
        this.items.clear();
    }
    public int totalCost(){
        int totalcost=0;
        for(DessertItem item:this.items){
            totalcost=totalcost+item.getCost();
        }
        return totalcost;
    }

    public int totalTax(){
        int totalTax=(int)Math.round(totalCost()*DessertShoppe.taxrate*0.01);
        return totalTax;
    }
    public String toString() {
        String str = "     " + DessertShoppe.storeName + "\n     ----------------------\n";
        //int length=DessertShoppe.maxSizeOfItemName;
        int leftLength=22;
        int rightLength=10;

        //display total tax of all items and verify the total tax is within maxWidth used to display cost
        String displayTax=DessertShoppe.cents2dollarsAndCentsmethod(totalTax());
        if(displayTax.length()>DessertShoppe.maxWidthToDisplayCost){
            displayTax=displayTax.substring(0,DessertShoppe.maxWidthToDisplayCost);
        }

        //display total cost of all items and verify the total cost is within maxWidth used to display cost
        String displayTotalCost=DessertShoppe.cents2dollarsAndCentsmethod(totalTax()+totalCost());
        if(displayTotalCost.length()>DessertShoppe.maxWidthToDisplayCost){
            displayTotalCost=displayTotalCost.substring(0,DessertShoppe.maxWidthToDisplayCost);
        }

        //display cost of every item and verify each cost is within maxWidth used to display cost
        for(DessertItem item: items) {
            String displayCost = DessertShoppe.cents2dollarsAndCentsmethod(item.getCost());
            if (displayCost.length() > DessertShoppe.maxWidthToDisplayCost) {
                displayCost = displayCost.substring(0, DessertShoppe.maxWidthToDisplayCost);
            }

            // sundae
            if (item instanceof Sundae) {
                str += "\n" + String.format("%-"+leftLength+"s",item.getName().split("\\n")[0]) + "\n"
                        + String.format("%-"+leftLength+"s",item.getName().split("\\n")[1])
                        + String.format("%"+rightLength+"s",displayCost);
            }
            // ice cream
            else if (item instanceof IceCream) {
                str += "\n" + String.format("%-"+leftLength+"s",item.getName())
                        + String.format("%"+rightLength+"s", displayCost);
            }
            // cookie
            else if (item instanceof Cookie) {
                str += "\n"
                        + String.format("%-"+leftLength+"s",((Cookie) item).getNumber() + " @ "
                        + DessertShoppe.cents2dollarsAndCentsmethod(((Cookie) item).getPricePerDozen()) + " /dz.")
                        + "\n" + String.format("%-"+leftLength+"s",item.getName())
                        + String.format("%"+rightLength+"s",displayCost );
            }
            //candy
            else {
                str += "\n"
                        + String.format("%-"+leftLength+"s",((Candy) item).getWeight() + " lbs. @ "
                        + DessertShoppe.cents2dollarsAndCentsmethod(((Candy) item).getPricePerPound()) + " /lb.")
                        + "\n"+String.format("%-"+leftLength+"s",item.getName())
                        + String.format("%"+rightLength+"s",displayCost);
            }
        }
        str += "\n\n" + String.format("%-"+leftLength+"s","Tax")
                + String.format("%"+rightLength+"s",displayTax) + "\n"
                + String.format("%-"+leftLength+"s","Total Cost")
                + String.format("%"+rightLength+"s", displayTotalCost) + "\n\n";
        return str;
    }
}






