// illustrates a singleton class
package com.springinaction.springidol;

public class Stage  {

	private Stage();   // NOTE the private default constructor--you may instantiate only through a factory

	private static class StageSingletonHolder  {
		static Stage instance = new Stage();  // making it static ensures only one instance of Stage
	}

	public static Stage getInstance()  {  // returns the same instance of Stage every time it's called
		return StageSingletonHolder.instance;
	}
}

