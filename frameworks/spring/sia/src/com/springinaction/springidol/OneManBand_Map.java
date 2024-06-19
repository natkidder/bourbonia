package com.springinaction.springidol;
import java.util.collection;

/**
* uses Map
*/

public class OneManBand implements Performer  {
	
	public OneManBand();

	public void perform() throws PerformanceException  {
		for (String key : instruments.keySet())  {
			System.out.print(key + " : ");
			Instrument instrument = instruments.get(key);
			instrument.play();
		}
	}

	private Collection<Instrument> instruments;

	public void setInstruments(Map<String,Instrument> instruments)  {   // NOTE the dual casting of Map
		this.instruments = instruments;
	}
}
