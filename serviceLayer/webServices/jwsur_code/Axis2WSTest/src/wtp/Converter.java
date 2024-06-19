package wtp;

public class Converter
{
	public float celsiusToFarenheit ( float celsius )
	{
		return (celsius * 9 / 5) + 32;
	}

	public float farenheitToCelsius ( float farenheit )
	{
		return (farenheit - 32) * 5 / 9;
	}
	
	public float cmToInch(float cm)   {
		return (cm / 2.54f);
	}
	
	public float inchToCm(float inch)  {
		return (inch * 2.54f);
	}
}
