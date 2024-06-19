package com.oreilly.hh;

import java.util.*;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.oreilly.hh.dao.ArtistDAO;
import com.oreilly.hh.data.Artist;
import com.oreilly.hh.data.Track;

public class UpdateArtists  {

	public static void main(String[] args)  {
		// Identifier of Artist to load
		Integer id = 1;

		// Load an Artist object, return persistent Artist object
		Artist artist = getHibernateTemplate().load(Artist.class, id);

		// Populate the object passed in as a parameter, using the object's type to specify the class
		artist = new Artist();
		getHibernateTemplate().load(artist, id);

		// Persist a new instance to the database
		artist = new Artist();
		artist.setName("Fischerspooner");
		getHibernateTemplate().save(artist);

		// Load, modify, update a row in the database
		artist = getHibernateTemplate().load(Artist.class, Id);
		artist.setName("Milli Vanilli");
		getHibernateTemplate().update(artist);

		// Either insert or update depending on the identifier of the object; associate resulting object with Session
		artist = getHibernateTemplate().merge(artist);

	}
}


