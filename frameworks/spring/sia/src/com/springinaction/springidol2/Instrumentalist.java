package com.springinaction.springidol2;

public class Instrumentalist implements Performer, InitializingBean, DisposableBean  {

	public Instrumentalist() {}

	public void perform() throws PerformanceException  {
		System.out.print("Playing " + song + " : ");
		getInstrument.play();  // uses injected getInstrument() method
	}
	public abstract Instrument getInstrument(); // injects getInstrument

	private String song;
	public void setSong(String song)  {
		this.song = song;
	}

	private Instrument instrument;
	public void setInstrument(Instrument instrument)  {
		this.instrument = instrument;
	}

	public void tuneInstrument() {
		instrument.tune();
	}

	public void cleanInstrument() {
		instrument.clean();
	}

	public void afterPropertiesSet() throws Exception {
		instrument.tune();
	}
	public void destroy() throws Exception  {
		instrument.clean();
	}

}
