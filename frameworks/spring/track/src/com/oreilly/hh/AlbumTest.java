package com.oreilly.hh;

import java.sql.Time;
import java.util.*;
import org.apache.log4j.Logger;

import com.oreilly.hh.dao.*;
import com.oreilly.hh.data.*;

/**
* Create sample album data, letting Hibernate persist it for us
*/
public class AlbumTest implements Test {

	private static Logger log = Logger.getLogger( AlbumTest.class );

	private AlbumDAO albumDAO;
	private ArtistDAO artistDAO;
	private TrackDAO trackDAO;

	public void run()  {
		// Retrieve (or create) an Artist matching this name
		Artist artist = artistDAO.getArtist("Martin L. Gore", true);

		// Create an instance of album, add the artist and persists it to the database
		Album album = new Album("Counterfeit e.p.", 1, new HashSet<Artist>(), new HashSet<String>(), new ArrayList<AlbumTrack>(5), new Date());
		album.getArtists().add(artist);
		album = albumDAO.persist(album);

		// Add two album tracks
		addAlbumTrack(album, "Compulsion", "vol1/album83/track01.mp3", Time.valueOf("00:05:29"), artist, 1, 1);
		addAlbumTrack(album, "In a Manner of Speaking", "vol1/album83/track02.mp3", Time.valueOf("00:04:21"), artist, 1, 2);

		// persist the album
		album = albumDAO.persist(album);

		log.info(album);
	}

	/**
	* Quick and dirty helper method to handle repetitive portion of creating album tracks;  A reall implementation would have more flexiblity
	*/
	private void addAlbumTrack(Album album, String title, String file, Time length, Artist artist, int disc, int positionOnDisc)  {

		// Create a new Track object and add the artist
		Track track = new Track(title, file, length, new HashSet<Artist>(), new Date(), new StereoVolume(), SourceMedia.CD, new HashSet<String>());
		track.getArtists().add(artist);

		// Persist the track to the database
		track = trackDAO.persist(track);

		// Add a new instance od AlbumTrack with the persisted album and track objects
		album.getTracks().add(new AlbumTrack(track, disc, positionOnDisc));
	}

	public AlbumDAO getAlbumDAO() { return albumDAO; }
	public void setAlbumDAO(AlbumDAO albumDAO)  {
		this.albumDAO = albumDAO;
	}

	public TrackDAO getTrackDAO() { return trackDAO; }
	public void setTrackDAO(TrackDAO trackDAO)  {
		this.trackDAO = trackDAO;
	}

	public ArtistDAO getArtistDAO() { return artistDAO; }
	public void setArtistDAO(ArtistDAO artistDAO)  {
		this.artistDAO = artistDAO;
	}

}
