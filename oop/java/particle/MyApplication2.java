// TG 8
public class MyApplication2 {
  public static void main(String[] args) {
    /* Need an instance of class ParticleN - a particle object;
       assign it to the variable a, which is of type ParticleN */
    Particle2 a = new Particle2(1.0,1.0);
    System.out.println("Distance of particle a from origin = " + a.distanceFromOrigin());
    System.out.println("Mass of particle a = " + a.mass);
    Particle2 b = new Particle2();
    b.x = 4.0;
    b.y = 3.0;
    b.mass = 3;
    System.out.println("Distance of particle b from origin = " + b.distanceFromOrigin());
    System.out.println("Mass of particle b = " + b.mass);
    System.out.println("Weight of particle b = " + b.getWeight());
  }
}
