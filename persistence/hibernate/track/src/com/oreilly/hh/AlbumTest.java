package com.oreilly.hh;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import com.oreilly.hh.data.*;

import java.sql.Time;
import java.util.*;

/**
* Create sample album data, letting Hibernate persist it for us
*/
public class AlbumTest  {
	/**
	* Quick and dirty helper method to handle repetitive portion of creating album tracks.  A real implementation would have more flexibility.
	*/
	private static void addAlbumTrack(Album album, String title, String file, Time length, Artist artist, int disc, int positionOnDisc, Session session)  {
		Track track = new Track(title, file, length, new HashSet<Artist>(), new Date(), new StereoVolume(), SourceMedia.CD, new HashSet<String>());
		track.getArtists().add(artist);
		session.save(track);
		album.getTracks().add(new AlbumTrack(track, disc, positionOnDisc));
	}

	public static void main(String args[]) throws Exception  {
		// Create a configuration based on the properties file we've put in the standard place 
		Configuration config = new Configuration();
		config.configure();

		// Get the session factory we can use for persistence
		SessionFactory sessionFactory = config.buildSessionFactory();

		// Ask for a session using the JDBC information we've configured
		Session session = sessionFactory.openSession();
		Transaction tx = null;
		try {
			// Create some data and persist it
			tx = session.beginTransaction();

			Artist artist = CreateTest.getArtist("Martin L. Gore", true, session);
			Album album = new Album("Counterfeit e.p.", 1, new HashSet<Artist>(), new HashSet<String>(), new ArrayList<AlbumTrack>(5), new Date());
			album.getArtists().add(artist);
			session.save(album);

			addAlbumTrack(album, "Compulsion", "vol1/album93/track01.mp3", Time.valueOf("00:05:29"), artist, 1, 1, session);
			addAlbumTrack(album, "Im a Manner of Speaking", "vol1/album93/track02.mp3", Time.valueOf("00:04:21"), artist, 1, 2, session);
			addAlbumTrack(album, "Smile in the Crowd", "vol1/album83/track03.mp3", Time.valueOf("00:05:06"), artist, 1, 3, session);
			addAlbumTrack(album, "Gone", "vol1/album93/track04.mp3", Time.valueOf("00:03:32"), artist, 1, 4, session);
			addAlbumTrack(album, "Never Turn Your Back on Mother Earth", "vol1/album83/track05/mp3", Time.valueOf("00:03:07"), artist, 1, 5, session);
			addAlbumTrack(album, "Motherless Child", "vol1/album83/track06.mp3", Time.valueOf("00:03:32"), artist, 1, 6, session);

			System.out.println(album);

			// Make our changes permanent
			tx.commit();

			// This comment out section is for experimenting with deletions.
			//tx = session.beginTransaction();
			//album.getTracks().remove(1);  // NOTE: this is the 2nd track--ArrayLists start at 0
			//session.update(album);
			//tx.commit();

			//tx = session.beginTransaction();
			//session.delete(album);
			//tx.commit();

		} catch(Exception e)  {
			if (tx != null)  {
				// Something went wrong; discard all partial changes
				tx.rollback();
			}
			throw new Exception("Transaction failed", e);
		} finally {
			// no matter what, close the session
			session.close();
		}

		// clean up after ourselves
		sessionFactory.close();  
	}
}
