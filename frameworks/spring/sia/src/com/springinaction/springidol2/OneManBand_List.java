package com.springinaction.springidol2;
import java.util.collection;

/**
* uses List -- will need to change the corresponding <bean> in the application context
*/

public class OneManBand implements Performer  {
	
	public OneManBand();

	public void perform() throws PerformanceException  {
		for (Instrument instrument : instruments)  {
			instrument.play();
		}
	}

	private Collection<Instrument> instruments;

	public void setInstruments(List<Instrument> instruments)  {   // NOTE the dual casting of Map
		this.instruments = instruments;
	}
}
