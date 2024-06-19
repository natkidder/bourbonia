// TG 13
public class MyApplication5
{
	public static void main(String[] args)
	{
		//particle charge is express in units of electron charge
		ChargedParticle a = new ChargedParticle(10.0, 0, 0, 1);
		System.out.println("distance of a from origin = " + a.distanceFromOrigin());
		System.out.println("charge of a = " + a.getCharge());
		System.out.println("charge of a in coulombs = " + ChargedParticle.ELQ * a.getCharge());
		ChargedParticle b = new ChargedParticle(-5.0, 0, 0, -1);
		System.out.println("distance of b from origin = " + b.distanceFromOrigin());
		System.out.println("charge of b = " + b.getCharge());
		b.setCharge(3);
		System.out.println("new charge of b = " + b.getCharge());
		System.out.println("net charge of a and b = " + ChargedParticle.netCharge(a, b));
	}
}
