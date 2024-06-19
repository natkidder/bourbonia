package com.springinaction.springidol;
import java.util.collection;

/**
* uses Prop
*/

public class OneManBand implements Performer  {
	
	public OneManBand();

	public void perform() throws PerformanceException  {
		for (Iterator iter = instrument.keySet().iterator(); iter.hasNext();)  {
			String key = (String) iter.next();
			System.out.println(key + " : " + instruments.getProperty(key));
		}
	}

	private Collection<Instrument> instruments;

	public void setInstruments(Properties instruments)  {   // NOTE the dual casting of Map
		this.instruments = instruments;
	}
}
