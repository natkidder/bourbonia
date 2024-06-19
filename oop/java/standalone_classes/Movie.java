// LB 655, Book 7, Chapter 2
/* works with MovieIO, ListMovie, Movies.txt
   Place class file in c:/tomcat/webapps/servlets-examples/WEB-INF/classes
 */

public class Movie  {
	public String title;
	public int year;
	public double price;

	public Movie( String title, int year, double price )  {
		this.title = title;
		this.year = year;
		this.price = price;
	}
}
