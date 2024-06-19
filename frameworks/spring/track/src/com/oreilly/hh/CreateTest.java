package com.oreilly.hh;

import java.sql.Time;
import java.util.*;
import com.oreilly.hh.dao.*;
import com.oreilly.hh.data.*;

/**
* Create sample data, letting Hibernate persist it for us.
*/
public class CreateTest implements Test  {
	private ArtistDAO artistDAO;
	private TrackDAO trackDAO;

	/**
	* Utility method to associate an artist with a track
	*/
	private static void addTrackArtist(Track track, Artist artist) {
		track.getArtists().add(artist);
	}

	/* (non-Javadoc)
	* @see com.oreilly.hh.Test#run()
	*/
	public void run()  {
		StereoVolume fullVolume = new StereoVolume();

		Track track = new Track("Russian Trance", "vol2/album610/track02.mp3", Time.valueOf("00:03:30"), new HashSet<Artist>(), new Date(), fullVolume,
								SourceMedia.CD, new HashSet<String>());
		addTrackArtist(track, artistDAO.getArtist("PPK", true));
		trackDAO.persist(track);
	}

	public ArtistDAO getArtistDAO() { return this.artistDAO; }
	public void setArtistDAO(ArtistDAO artistDAO)  {
		this.artistDAO = artistDAO;
	}

	public TrackDAO getTrackDAO() { return this.trackDAO; }
	public void setTrackDAO(TrackDAO trackDAO)   {
		this.trackDAO = trackDAO;
	}
}
