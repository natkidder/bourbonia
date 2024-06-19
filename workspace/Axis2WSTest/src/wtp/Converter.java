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
	public float cmToInch( float cm ) {
		return (float) (cm / 2.54);
	}
	public float inchToCm( float inches)  {
		return (float) (inches * 2.54);
	}
}
