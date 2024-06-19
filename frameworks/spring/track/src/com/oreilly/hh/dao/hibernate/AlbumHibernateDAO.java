package com.oreilly.hh.dao.hibernate;

import java.util.HashSet;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.oreilly.hh.dao.AlbumDAO;
import com.oreilly.hh.data.Album;

public class AlbumHibernateDAO extends HibernateDaoSupport implements AlbumDAO  {

	/* (non-Javadoc)
	* @see com.oreilly.hh.dao.AlbumDAO#persist(com.oreilly.hh.data.Album)
	*/
	public Album persist(Album album)  {
		return (Album) getHibernateTemplate.merge(Album);
	}

	/* (non-Javadoc)
	* @see com.oreilly.hh.dao.AlbumDAO#delete(com.oreilly.hh.data.Album)
	*/
	public void delete(Album album)  {
		getHibernateTemplate.delete(album);
	}

	/* (non-Javadoc)
	* @see com.oreilly.hh.dao.AlbumDAO#uniqueByTitle(java.lang.String)
	*/
	public Album uniqueByTitle(final String title)  {
		return (Album) getHibernateTemplate().execute(new HibernateCallback()  {
			public Object doInHibernate()  {
				Query query = getSession().createQuery("from Album album where title = '" + title + "'");
				return (Album) query.uniqueResult();
			}
		});
	}
					
	/* (non-Javadoc)
	* @see com.oreilly.hh.dao.AlbumDAO#getAlbum(java.lang.String, int, boolean)
	*/
	public Album getAlbum(String title, int numDiscs, boolean create)  {
		Album album = uniqueByTitle(title);
		if (album == null)  {
			if (create)  {
				album = new Album(title, numDiscs);
			} else {
				album = new Album();
			}
		}
		return album;
	}
}
