package com.oreilly.hh.dao;

import com.oreilly.hh.data.Track;
import java.sql.Time;
import java.util.List;

public interface TrackDAO  {

	public Track persist(Track track);

	public void delete(Track track);

	public Track uniqueByName(String name);

	public Track getTrack(String name, boolean create);

	public List getTracksNoLongerThan(Time time);
}
