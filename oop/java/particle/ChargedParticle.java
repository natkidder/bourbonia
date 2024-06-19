// TG 12
public class ChargedParticle extends Particle4
{
	// magnitude of electron charge in coulombs
	public static final double ELQ = 1.602e-19;
	private double charge;

	public ChargedParticle(double x, double y, double mass, double charge)
	{
		super(x, y, mass);
		this.charge = charge;
	}

	public double getCharge()
	{
		return charge * ELQ;
	}

	public void setCharge(double newCharge)
	{
		charge = newCharge;
	}

	public static double netCharge(ChargedParticle a, ChargedParticle b)
	{
		return a.getCharge() + b.getCharge();
	}

	public static double netUnitCharge(ChargedParticle a, ChargedParticle b)
	{
		return a.charge + b.charge
	}

}
