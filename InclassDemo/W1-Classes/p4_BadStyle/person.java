package ca.cmpt213.p4_BadStyle;

public class person {
private final static int maxAge = 101;
	
	String m_name;
	String birthDayYYYYMMDD;
	
	public person (String n,int a) 
	{
		m_name= n;
	Age = a;
	}
	
	/**
	 * Get the person's name.
	 * @return The person's name.
	 */
	public 
	String 
	GetPersonName () 
	{
		return m_name;
	}
	
	int Age;
	public void setAge(int theNewAgeForThePerson) {
		boolean check =theNewAgeForThePerson>maxAge||theNewAgeForThePerson<0&&theNewAgeForThePerson!=42; 
		if (check) throw new RuntimeException("Invalid age");  
			theNewAgeForThePerson = 0;

			
		Age    =theNewAgeForThePerson;
	}
	
	public String toString() {
		return "Person '"     +m_name+"' is " +   Age;
		
	}

}
