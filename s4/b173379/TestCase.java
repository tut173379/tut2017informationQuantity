//p bar
package s4.b173379; // Please modify to s4.Bnnnnnn, where nnnnnn is your student ID. 
import java.lang.*;
import s4.specification.*;
 
/*
interface FrequencerInterface {     // This interface provides the design for frequency counter.
    void setTarget(byte[]  target); // set the data to search.
    void setSpace(byte[]  space);  // set the data to be searched target from.
    int frequency(); //It return -1, when TARGET is not set or TARGET's length is zero
                    //Otherwise, it return 0, when SPACE is not set or Space's length is zero
                    //Otherwise, get the frequency of TAGET in SPACE
    int subByteFrequency(int start, int end);
    // get the frequency of subByte of taget, i.e target[start], taget[start+1], ... , target[end-1].
    // For the incorrect value of START or END, the behavior is undefined.
}
*/

/*
package s4.specification;
public interface InformationEstimatorInterface{
    void setTarget(byte target[]); // set the data for computing the information quantities
    void setSpace(byte space[]); // set data for sample space to computer probability
    double estimation(); // It returns 0.0 when the target is not set or Target's length is zero;
// It returns Double.MAX_VALUE, when the true value is infinite, or space is not set.
// The behavior is undefined, if the true value is finete but larger than Double.MAX_VALUE.
// Note that this happens only when the space is unreasonably large. We will encounter other problem anyway.
// Otherwise, estimation of information quantity, 
}                        
*/


public class TestCase {
    public static void main(String[] args) {

    /*Frequencer Interface*/
	try {
	    FrequencerInterface  myObject;
	    int freq;
	    System.out.println("\nchecking s4.b173379.Frequencer");
	    myObject = new s4.b173379.Frequencer();
	    myObject.setSpace("Hi Ho Hi Ho".getBytes());
	    myObject.setTarget("H".getBytes());
	    freq = myObject.frequency();
	    System.out.print("\"H\" in \"Hi Ho Hi Ho\" appears "+freq+" times. ");

	    if(4 == freq) { System.out.println("OK\n"); } else {System.out.println("WRONG\n"); }
	    myObject.setTarget("k".getBytes());
	    freq = myObject.frequency();

	    System.out.print("\"k\" in \"Hi Ho Hi Ho\" appears "+freq+" times. ");
	    if(0 == freq) { System.out.println("OK(TARGET's length is zero)"); } else {System.out.println("WRONG"); }
	}
	catch(Exception e) {
	    System.out.println("Exception occurred: STOP");
	}
	
	//SPACE's length is zero.
	try {
	    FrequencerInterface  myObject;
	    int freq;
	    System.out.println("\nchecking s4.b173379.Frequencer");
	    myObject = new s4.b173379.Frequencer();
	    myObject.setSpace("".getBytes());
	    myObject.setTarget("H".getBytes());
	    freq = myObject.frequency();
	    System.out.print("SPACE'S LENGTH IS 0: frequency() appears "+freq+" times. ");
	    if(0 == freq) { System.out.println("OK\n"); } else {System.out.println("WRONG\n"); }
	}
	catch(Exception e) {
	    System.out.println("Exception occurred: STOP");
	}

	//setspace is not set
 	try {
        FrequencerInterface  myObject;
        int freq;
        System.out.println("\nchecking s4.b173379.Frequencer");
        myObject = new s4.b173379.Frequencer();
        myObject.setTarget("l".getBytes());
        freq = myObject.frequency();
        System.out.println("SPACE is not set:int frequency()="+freq);
        if(0 == freq) { System.out.println("OK\n"); } else {System.out.println("WRONG\n"); }
    }
    catch(Exception e) {
        System.out.println("Exception occurred: STOP");
    }

	
	//Test When the TARGET's length is zero
	try {
	    FrequencerInterface  myObject;
	    int freq;
	    System.out.println("\nchecking s4.b173379.Frequencer");
	    myObject = new s4.b173379.Frequencer();
	    myObject.setSpace("Hi Ho Hi Ho".getBytes());
	    myObject.setTarget("".getBytes());
	    freq = myObject.frequency();
	    System.out.print("\"\" in \"Hi Ho Hi Ho\" appears "+freq+" times. ");
	    if(-1 == freq) { System.out.println("OK\n"); } else {System.out.println("WRONG\n"); }
	}
	catch(Exception e) {
	    System.out.println("Exception occurred: STOP");
	}
	
	//Target is not set
    try {
        FrequencerInterface  myObject;
        int freq;
        System.out.println("\nchecking s4.b173379.Frequencer");
        myObject = new s4.b173379.Frequencer();
        myObject.setSpace("Hello World".getBytes());
        myObject.setTarget("".getBytes());
        freq = myObject.frequency();
        System.out.println("TARGET is not set:int frequency()="+freq);
        if(-1 == freq) { System.out.println("OK\n"); } else {System.out.println("WRONG\n"); }
    }
    catch(Exception e) {
        System.out.println("Exception occurred: STOP");
    }

    /* Information Estimator Interface */
	try {
	    InformationEstimatorInterface myObject;
	    double value;
	    System.out.println("\nchecking s4.b173379.InformationEstimator");
	    System.out.println("SPACE:3210321001230123");
	    myObject = new s4.b173379.InformationEstimator();
	    myObject.setSpace("3210321001230123".getBytes());

	    myObject.setTarget("0".getBytes());
	    value = myObject.estimation();
	    System.out.println(">0 "+value);

	    myObject.setTarget("01".getBytes());
	    value = myObject.estimation();
	    System.out.println(">01 "+value);

	    myObject.setTarget("0123".getBytes());
	    value = myObject.estimation();
	    System.out.println(">0123 "+value);

	    myObject.setTarget("00".getBytes());
	    value = myObject.estimation();
	    System.out.println(">00 "+value);

	}
	catch(Exception e) {
	System.out.println("Exception occurred: STOP");
	}
	

	//target is not set
    try {
        InformationEstimatorInterface myObject;
        double value;
        myObject = new s4.b173379.InformationEstimator();
        myObject.setSpace("3210321001230123".getBytes());
        value = myObject.estimation();
        System.out.println("TARGET is not set:double estimation()="+value);
        if(0.0 == value) { System.out.println("OK\n"); } else {System.out.println("WRONG\n");}
    }
    catch(Exception e) {
        System.out.println("Exception occurred: STOP");
    }
        
    //target's length is 0
    try {
        InformationEstimatorInterface myObject;
        double value;
        myObject = new s4.b173379.InformationEstimator();
        myObject.setSpace("3210321001230123".getBytes());
        myObject.setTarget("".getBytes());
        value = myObject.estimation();
        System.out.println("TARGET'S length is 0: double estimation()="+value);
        if(0.0 == value) { System.out.println("OK\n"); } else {System.out.println("WRONG\n");}
    }
    catch(Exception e) {
        System.out.println("Exception occurred: STOP");
    }
        
    //space is not set
    try {
        InformationEstimatorInterface myObject;
        double value;
        myObject = new s4.b173379.InformationEstimator();
        myObject.setTarget("0".getBytes());
        value = myObject.estimation();
        System.out.println("SPACE is not set: double estimation()="+value);
        if(Double.MAX_VALUE == value) { System.out.println("OK\n"); } else {System.out.println("WRONG\n");}
    }
    catch(Exception e) {
        System.out.println("Exception occurred: STOP");
    }
    }
}
      
