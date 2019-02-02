import java.util.Scanner;
public class Question3 {
    public static void main(String[] args){
        String reversedString="";
        String originalString="";
        String noSpaceString="";
        Scanner input=new Scanner(System.in);
        System.out.println("input a string:");
        String original=input.nextLine();
        noSpaceString=original.trim();
        noSpaceString =noSpaceString.replaceAll("( +)", " ");

        char[]charArray=noSpaceString.toCharArray();
        for(int i =charArray.length-1;i>=0;i--){

            reversedString=originalString+charArray[i];

            System.out.print(reversedString);



        }
    }

}
