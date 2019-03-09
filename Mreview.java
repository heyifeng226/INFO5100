import java.util.ArrayList;
public class Mreview extends java.lang.Object implements java.lang.Comparable<Mreview> {
    private String title;//title of the movie
    private ArrayList<Integer>ratings;//list of ratings stored in a Store object

    //three constructors
    public Mreview(){
        this.title="";
        this.ratings=new ArrayList<>();
    }
    public Mreview(java.lang.String ttl){
        this.title=ttl;
        this.ratings=new ArrayList<>();

    }
    public Mreview(java.lang.String ttl,int firstRating){
        this.title=ttl;
        this.ratings=new ArrayList<Integer>(firstRating);
    }

    //seven methods
    public void addRating(int r){
        ratings.add(r);
    }

    public double aveRating(){
        double sum=0;
        for(double i:this.ratings){
            sum=sum+i;
        }
        double avg=sum/this.ratings.size();
        return avg;
    }

    public int compareTo(Mreview obj){
        if(this.title.equals(obj.title))
            return 0;
        else
            return this.title.compareTo(obj.title);

    }

    public boolean equals(java.lang.Object obj){
        return this.title.equals(((Mreview)obj).title);

    }

    public java.lang.String getTitle(){
        return this.title;
    }

    public int numRatings(){
        return ratings.size();
    }

    public java.lang.String toString(){
        String s=this.getTitle()+" ,average "+this.aveRating()+ " out of "+this.numRatings();
        return s;
    }

    //main()
    public static void main(String[]args){
        Mreview m=new Mreview("Kill Bill");
        m.addRating(3);
        m.addRating(4);
        m.addRating(3);
        System.out.println(m.toString());
        System.out.println("The average rate is: "+m.aveRating());

    }

}
