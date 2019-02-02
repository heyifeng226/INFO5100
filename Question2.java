

public class Question2 {
	public static void main(String[]args) {
		PsychiatristObject psy=new PsychiatristObject();
		MoodyObject so=new SadObject();
		MoodyObject ho=new HappyObject();
		psy.examine(ho);
		psy.observe(ho);
		psy.examine(so);
		psy.observe(so);
		System.out.println("Press any key to continue...");
	}
}

class PsychiatristObject{
	public void examine(MoodyObject moodyObject) {
		System.out.println("How are you feeling today?");
		moodyObject.queryMood();
	}
	
	public void observe(MoodyObject moodyObject) {
		moodyObject.expressFeelings();
		System.out.println("Observation: "+moodyObject+"\n");
	}
}





abstract class MoodyObject{
	protected abstract String getMood();
	
	protected abstract void expressFeelings();
	
	public void queryMood(){
		System.out.println("I feel "+getMood()+" today!\n");
		
		
	}
}

class SadObject extends MoodyObject{
	protected String getMood() {
		return "sad";
		
	}
	public void expressFeelings() {
		System.out.println("'wah''boo hoo''weep''sob''weep'");
	}
	public String toString() {
		return"Subject cries a lot\n";
	}
}

class HappyObject extends MoodyObject{
	protected String getMood() {
		return "happy";
	}
	public void expressFeelings() {
		System.out.println("hehehe...hahahah...HAHAHAHAHA!");
	}
	public String toString() {
		return "Subject laughs a lot\n";
	}
}




