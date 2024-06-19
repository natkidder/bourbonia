package com.oreilly.hh.dao.hibernate;

import java.util.HashSet;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.oreilly.hh.dao.ArtistDAO;
import com.oreilly.hh.data.Artist;
import com.oreilly.hh.data.Track;

/**
* Hibernate-specific implementation of the ArtistDAO interface;  This class extends the Spring-specific HibernateDaoSupport to
* provide access to the SessionFactory and the Hibernate Template.
*/
public class ArtistHibernateDAO extends HibernateDaoSupport implements ArtistDAO  {
	/* (non-Javadoc)
	* @see com.oreilly.hh.dao.ArtistDAO#persist(com.oreilly.hh.data.Artist)
	*/
	public Artist persist(Artist artist)  {
		return (Artist) getHibernateTemplate().merge(artist);
	}

	/* (non-Javadoc)
	* @see com.oreilly.hh.dao.ArtistDAO#delete(com.oreilly.hh.data.Artist)
	*/
	public void delete(Artist artist)  {
		getHibernateTemplate().delete(artist);
	}

	/* (non-Javadoc)
	* @see com.oreilly.hh.dao.ArtistDAO#uniqueByName(java.lang.String)
	*/
	public Artist uniqueByName(final String name)  {
		return (Artist) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)  {
				Query query = getSession().getNamedQuery("com.oreilly.hh.artistByName");
				query.setString("name", name);
				return (Artist) query.uniqueResult();
			}
		});
	}

	/* (non-Javadoc)
	* @see com.oreilly.hh.dao.ArtistDAO#getArtist(java.lang.String, boolean)
	*/
	public Artist getArtist(String name, boolean create)  {
		Artist found = uniqueByName(name);
		if (found == null && create)  {
			found = new Artist(name, new HashSet<Track>(), null);
			found = persist(found);
		}
		if (found != null && found.getActualArtist() != null)  {
			return found.getActualArtist();
		}
		return found;
	}
}
