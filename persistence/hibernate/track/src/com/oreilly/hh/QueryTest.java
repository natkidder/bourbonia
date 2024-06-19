package com.oreilly.hh;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.*;

import com.oreilly.hh.data.*;

import java.sql.Time;
import java.util.*;
import com.oreilly.hh.Utils;

/**
 * Retrieve data as objects
 */
public class QueryTest {

    /**
     * Retrieve any tracks that fit in the specified amount of time.
     *
     * @param length the maximum playing time for tracks to be returned.
     * @param session the Hibernate session that can retrieve data.
     * @return a list of {@link Track}s meeting the length restriction.
     */
    public static List tracksNoLongerThan(Time length, Session session) {
		// extract data using SQL embedded in the com.oreilly.hh.data.Track.hbm.xml file
        Query query = session.getNamedQuery("com.oreilly.hh.tracksNoLongerThan"); 
        query.setTime("length", length);
		return query.list();

		// -- extract data using the Criteria class --
        //Criteria criteria = session.createCriteria(Track.class);
		// combine the restrictions as a union (OR)
		//Disjunction any = Restrictions.disjunction(); // enables the OR
		//any.add(Restrictions.le("playTime", length));
		//any.add(Restrictions.like("title", "%A%"));
		//criteria.add(any);
		// the following sorts are in order of coding (ORDER title, playTime DESC)
		//criteria.addOrder(Order.asc("title").ignoreCase());
		//criteria.addOrder(Order.desc("playTime").ignoreCase());
        //return criteria.list();
    }   

	/** 
	* Generate summary information about all tracks for a given artist.
	*
	* @param artist the artist's full name
	* @param session the Hibernate session that can retrieve data.
	* @return an array, each element being a different query column value
	*/
	public static Object[] printTrackSummary(Artist artist, Session session)  {
		Query query = session.getNamedQuery("com.oreilly.hh.trackSummByArtist");
		query.setParameter("artist", artist);
		return (Object[])query.uniqueResult();
	}

	/**
	* Use a native SQL query to return tracks that end a certain seconds after their last whole minute
	* 
	* @param seconds, the number of seconds at which we want tracks to end.
	* @param session the Hibernate session that can retrieve data.
	*/
	public static List printTracksEndingAt(int seconds, Session session)  {
		Query query = session.getNamedQuery("com.oreilly.hh.tracksEndingAt");
		query.setInteger("seconds", seconds);
		return query.list();
	}

    /**
     * Build a parenthetical, comma-separated list of artist names.
     * @param artists the artists whose names are to be displayed.
     * @return the formatted list, or an empty string if the set was empty.
     */
    public static String listArtistNames(Set<Artist> artists) {
        StringBuilder result = new StringBuilder();
        for (Artist artist : artists) {
            result.append((result.length() == 0) ? "(" : ", ");
            result.append(artist.getName());
        }
        if (result.length() > 0) {
            result.append(") ");
        }
        return result.toString();
    }

	/**
	* Retrieve the titles of any tracks that contain a particular text string
	* @param text the text to be matched, ignoring case, anywhere in the title.
	* @param session the Hibernate session that can retrieve data.
	* @return the matching titles, as strings
	*/
	public static List titlesContainingText(String text, Session session) {
		Criteria criteria = session.createCriteria(Track.class);
		//criteria.add(Restrictions.like("title", "%" + text + "%").ignoreCase());
		criteria.add(Property.forName("title").like("%" + text + "%").ignoreCase());
		criteria.setProjection(Projections.projectionList().
			add(Projections.property("title")).
			add(Projections.property("playTime")));
		return criteria.list();
	}

	/**
	* Print statistics about various media types.
	* @param session the Hibernate session that can retrieve data.
	*/
	public static List printMediaStatistics(Session session)  {
		Criteria criteria = session.createCriteria(Track.class);
		criteria.setProjection(Projections.projectionList().
				add(Projections.groupProperty("sourceMedia").
				as("media")).    // alias for sourceMedia
				add(Projections.rowCount()).
				add(Projections.max("playTime")));
		criteria.addOrder(Order.asc("media"));
		return criteria.list();
	}
	
	/**
	* Retrieve any tracks associated with artists whose name matches a SQL string patterns.
	*
	* @param namePattern the pattern which an artist's name must match.
	* @param session the Hibernate session that can retrieve data.
	* @return a list of {@link Track}s meeting the artist name restriction.
	*/

	public static List tracksWithArtistsLike(String namePattern, Session session)  {
		Criteria criteria = session.createCriteria(Track.class);
		Criteria artistCriteria = criteria.createCriteria("artists");  // note it's the criteria that creating the criteria
		artistCriteria.add(Restrictions.like("name", namePattern).ignoreCase());
		artistCriteria.addOrder(Order.asc("name").ignoreCase());
		return criteria.list();
	}

	/**
	* Illustrates query by example
	* Retrieve any tracks that were obtained from a particular source media type.
	* 
	* @param media the media type of interest.
	* @param session the Hibernate session that can retrieve data.
	* @return a list of {@link Track}s meeting the media restriction.
	*/
	public static List tracksFromMedia(SourceMedia media, Session session)  {
		Track track = new Track();
		track.setSourceMedia(media);
		Example example = Example.create(track);  // note the Example class -- it will return all tracks whose media matches this one.

		Criteria criteria = session.createCriteria(Track.class);
		criteria.add(example);  
		criteria.addOrder(Order.asc("title"));  // sort by Track.title ascending
		return criteria.list();  // actually execute the query and return the results as a List
	}

    /**
     * Look up and print some tracks when invoked from the command line.
     */
    public static void main(String args[]) throws Exception {
		List tracks;
        // Create a configuration based on the XML file we've put
        // in the standard place.
        Configuration config = new Configuration();
        config.configure();

        // Get the session factory we can use for persistence
        SessionFactory sessionFactory = config.buildSessionFactory();

        // Ask for a session using the JDBC information we've configured
        Session session = sessionFactory.openSession();
        try {
			String mediaInfo;
			// Print the titles of tracks whose titles contain the letter "v"
			System.out.println("\nTRACKS WHOSE TITLES CONTAIN THE LETTER \"V\"\n");
			for (Object obj : titlesContainingText("v", session) ) {
				Object[] objArray = (Object[])obj;
				System.out.println(objArray[0] + ", " + objArray[1]);
			}

			// Print the number and longest playing time for each media
			System.out.println("\nCOUNT AND LONGEST PLAYING TIME FOR EACH MEDIA\n");
			for (Object obj : printMediaStatistics(session)) {
				Object[] objAry = (Object[])obj;
				System.out.println("Medium: " + objAry[0] + " track count: " + objAry[1] + ", longest time: " + objAry[2]);
			}

            // Print the the id & title properties of the tracks that will fit in five minutes
			System.out.println("\nTRACKS THAT WILL FIT IN 5 MINUTES\n");
            List titles = tracksNoLongerThan(Time.valueOf("00:05:00"), session);
			for (ListIterator iter = titles.listIterator() ; iter.hasNext() ; ) {
				Object[] row = (Object[])iter.next();
				Integer id = (Integer)row[0];
				String title = (String)row[1];
				System.out.println("Track: " + title + " [ID=" + id + ']');
                /* for (String comment : aTrack.getComments()) {
                    System.out.println("  Comment: " + comment);
                } */
            }

			// Print summary information about all the tracks
			System.out.println("\nSUMMARY INFORMATION ABOUT ALL THE TRACKS FOR A GIVEN ARTIST\n");
			Artist artist = CreateTest.getArtist("Samuel Barber", false, session);
			Object[] summary = printTrackSummary(artist, session);
			Utils.prtln("Summary of Tracks by " + artist.getName() + ":");
			Utils.prtln("     Track count: " + summary[0]);
			Utils.prtln("  Shortest track: " + summary[1]);
			Utils.prtln("   Longest track: " + summary[2]);

			// Print all artists whose name ends in 'n'
			System.out.println("\nTRACKS WHOSE ARTISTS NAMES END IN 'N'\n");
			List artists = tracksWithArtistsLike("%n", session);
			for (ListIterator iter = artists.listIterator() ; iter.hasNext() ; ) {
				Track artTrack = (Track)iter.next();
				if (artTrack.getSourceMedia() != null)  {
					mediaInfo = ", from " + artTrack.getSourceMedia().getDescription();
				} else {
					mediaInfo = "";
				}
				System.out.println("Track: '" + artTrack.getTitle() + "' " + listArtistNames(artTrack.getArtists()) + artTrack.getPlayTime() + mediaInfo);
			}

			// Print all tracks whose media is CD
			System.out.println("\nTRACKS FROM A CD MEDIUM\n");
			tracks = tracksFromMedia(SourceMedia.CD, session);
			for (ListIterator li = tracks.listIterator(); li.hasNext(); )  {  // the ListIterator is an Object collection
				Track track = (Track)li.next();
				mediaInfo = ", from" + track.getSourceMedia();  // we can assume the media will be non-null
				System.out.println("Track: '" + track.getTitle() + "' " + listArtistNames(track.getArtists()) + track.getPlayTime() + mediaInfo);
			}

			// Print all Tracks whose time ends 30 seconds after the last whole minute
			Utils.prtln("\nTRACKS THAT END AT THE HALF-MINUTE MARK\n");
			List results = printTracksEndingAt(30, session);
			for(ListIterator iter = results.listIterator(); iter.hasNext(); )  {
				Track track = (Track)iter.next();
				Utils.prtln("Track: " + track.getTitle() + ", length: " + track.getPlayTime());
			}

        } finally {
            // No matter what, close the session
            session.close();
        }

        // Clean up after ourselves
        sessionFactory.close();
    }
}
