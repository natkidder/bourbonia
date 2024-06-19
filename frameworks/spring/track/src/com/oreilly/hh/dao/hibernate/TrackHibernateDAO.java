package com.oreilly.hh.dao.hibernate;

import java.util.HashSet;
import java.sql.Time;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.oreilly.hh.dao.TrackDAO;
import com.oreilly.hh.data.Track;
import com.oreilly.hh.dao.ArtistDAO;
import com.oreilly.hh.data.Artist;
import com.oreilly.hh.dao.AlbumDAO;
import com.oreilly.hh.data.Album;

public class TrackHibernateDAO extends HibernateDaoSupport implements TrackDAO  {
	/* (non-Javadoc)
	* @see com.oreilly.hh.dao.TrackDAO#persist(com.oreilly.hh.data.Track)
	*/
	public Track persist(Track track)  {
		return (Track) getHibernateTemplate().merge(track);
	}

	/* (non-Javadoc)
	* @see com.oreilly.hh.dao.TrackDAO#delete(com.oreilly.hh.data.Track)
	*/
	public void delete(Track track)  {
		getHibernateTemplate().delete(track);
	}

	/* (non-Javadoc)
	* @see com.oreilly.hh.dao.TrackDAO#uniqueByName(java.lang.String)
	*/
	public Track uniqueByName(final String name)  {
		return (Track) getHibernateTemplate().execute(new HibernateCallback() {
			public Object doInHibernate(Session session)  {
				Query query = getSession.getNamedQuery("com.oreilly.hh.trackByName");
				query.setString("name", name);
				return (Track) query.uniqueResult();
			}
		});
	}

	/* (non-Javadoc)
	* @see com.oreilly.hh.dao.TrackDAO#getTrack(java.lang.String, boolean)
	*/
	public Track getTrack(String name, boolean create)  {
		Track located = uniqueByName(name);
		if (located == null && create)  {
			located = new Track(name, "");
			located = persist(located);
		} else if (located == null) {
			located = new Track();
		}
		return located;
	}

	/* (non-Javadoc)
	* @see com.oreilly.hh.dao.TrackDAO#getTracksNoLongerThan(java.sql.Time)
	*/
	public List getTracksNoLongerThan(final Time length)  {
		return (List) getHibernateTemplate().execute(new HibernateCallback()  {
			public Object doInHibernate(Session session)  {
				Query query = session.getNamedQuery("com.oreilly.hh.data.tracksNoLongerThan");
				query.setTime("length", length);
				return query.list();
			}
		});
	}

}
