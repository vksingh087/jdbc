package demo;

public class StringInstrument extends Instrument {
	// TODO: Declare private fields: numStrings, numFrets
	private int numStrings;
	private int numFrets;
	
	

	// TODO: Define mutator methods -
	// setNumOfStrings(), setNumOfFrets()
	
	public void setNumOfStrings(int numStrings)
	{
		this.numStrings=numStrings;
	}
	public void setNumOfFrets(int numFrets)
	{
	   this.numFrets=numFrets;
	}
	

	// TODO: Define accessor methods -
	// getNumOfStrings(), getNumOfFrets()
	public int getNumOfStrings()
	{
		return this.numStrings;
	}
	public int getNumOfFrets()
	{
		return  this.numFrets;
	}

	}
