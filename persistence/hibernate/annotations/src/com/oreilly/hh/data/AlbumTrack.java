package com.oreilly.hh.data;

import java.io.Serializable;
import javax.persistence.*;

//@Embeddable // class is NOT an entity capable of standing on its own, thus the annotation.  Problem: cannot enforce cascading
@Entity //making the class an independent entity, allowing cascading
@Table(name="ALBUM_TRACKS")

public class AlbumTrack {

	// this section magically obviates the need for a separate class to handle the Album-Track pivot table
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	// cannot be included in SQL INSERT or UPDATE statements except through ALBUM, or can be null.  So allows adding the track to the Album object
	@ManyToOne
	@JoinColumn(name="ALBUM_ID", insertable=false, updatable=false, nullable=false)
	private Album album;

	// can be included in SQL INSERT or UPDATE statements without agency of TRACK
	@ManyToOne(cascade=CascadeType.ALL) 
	@JoinColumn(name="TRACK_ID", nullable=false)
	private Track track;

	// the below need no annotations--they have no constraints and we'll accept all the defaults (eg. column name of disc)
	private Integer disc;  
	private Integer positionOnDisc;

	public AlbumTrack() {}

	public AlbumTrack(Track track, Integer disc, Integer positionOnDisc)  {
		this.track = track;
		this.disc = disc;
		this.positionOnDisc = positionOnDisc;
	}

	public Integer getId() { return id; }
	public void setId(Integer id) {
		this.id = id;
	}

	public Album getAlbum() { return album; }
	// no need for setAlbum--that is done via the Album object

	public Track getTrack() { return track; }
	public void setTrack(Track track) {
		this.track = track;
	}

	public Integer getDisc() { return disc; }
	public void setDisc(Integer disc) {
		this.disc = disc;
	}

	public Integer getPositionOnDisc() { return positionOnDisc; }
	public void setPositionOnDisc(Integer positionOnDisc) {
		this.positionOnDisc = positionOnDisc;
	}

	public String toString()  {
		StringBuffer buffer = new StringBuffer();
		buffer.append(getClass().getName()).append("@");
		buffer.append(Integer.toHexString(hashCode())).append(" [");
		buffer.append("track").append("='").append(getTrack()).append("' ");
		buffer.append("]");
		return buffer.toString();
	}
}
