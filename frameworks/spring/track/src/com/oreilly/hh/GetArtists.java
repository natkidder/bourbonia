package com.oreilly.hh;

import java.util.*;

import org.apache.log4j.Logger;
import org.hibernate.*;
import org.hibernate.criterion.*;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.oreilly.hh.dao.ArtistDAO;
import com.oreilly.hh.data.Artist;
import com.oreilly.hh.data.Track;

public class GetArtists  {

	public static void main(String[] args)  {

		// All of these lines find an Artist with the name 'Pavement'
		List artists = getHibernateTemplate().find("from com.oreilly.hh.data.Artist a where a.name = 'Pavement'");
		
		String name = "Pavement";
		artists = getHibernateTemplate().find("from com.oreilly.hh.data.Artist a where a.name = ?", name);

		artists = getHibernateTemplate().findByNamedParam("from com.oreilly.hh.data.Artist a where a.name = :name", "name", name);

		// ASSUMES there is a NamedQuery annotation 'artistByName' on the Artist class.  
		artists = getHibernateTemplate().findByNamedQuery("com.oreilly.hh.data.artistByName", name);

		Artist artist = new Artist();
		artist.setName("Pavement");
		artists = getHibernateTemplate().findByExample(artist);

		// If we want to iterate the result
		Iterator iterArtists = getHibernateTemplate().iterate("from com.oreilly.hh.data.Artist where a.name = ?", name); // does NOT accept named parameters

		// The following lines find all artists
		artists = getHibernateTemplate().find("from com.oreilly.hh.data.Artists");
		artists = getHibernateTemplate().loadAll(Artist.class);

		// get artist by name
		final String name2 = "Pavement";

		artist = (Artist) getHibernateTemplate().execute(new HibernateCallback()  {
			public Object doInHibernate(Session session)  {
				Criteria criteria = session.createCriteria(Artist.class);
				criteria.add(Restrictions.like("name", name2));
				return criteria.uniqueResult();
			}
		});
	}
}
