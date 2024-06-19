package com.oreilly.hh.data;

import java.sql.Time;
import java.util.*;
import javax.persistence.*;

import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.Index;

@Entity //mark the class as capable of persistence
@Table(name="Track")
@NamedQueries({@NamedQuery(name="com.oreilly.hh.data.tracksNoLongerThan", query="from Track as track where track.playTime <= :length")})

public class Track  {
	@Id
	@Column(name="TRACK_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(name="TITLE", nullable=false)
	@Index(name="TRACK_TITLE", columnNames={"TITLE"})
	private String title;

	@Column(nullable=false)
	private String filePath;

	@Temporal(TemporalType.TIME)  // Temporal refers to the fact that we are connecting this class variable to the SQL TIME datatype
	private Date playTime;

	@ManyToMany
	@JoinTable(name="TRACK_ARTISTS", joinColumns={@JoinColumn(name="ARTIST_ID")}, inverseJoinColumns={@JoinColumn(name="TRACK_ID")})
	private Set<Artist> artists;

	@Temporal(TemporalType.DATE)
	private Date added;

	@CollectionOfElements // a Hibernate-specific annotation
	@JoinTable(name="TRACK_COMMENTS", joinColumns=@JoinColumn(name="TRACK_ID"))
	@Column(name="COMMENT")
	private Set<String> comments;

	@Enumerated(EnumType.STRING) // much easier with annotations than with XML
	private SourceMedia sourceMedia;

	@Embedded // use embedded for a composite user type -- we must also make the StereoVolume class embeddable
	// the AttributeOverrides simply makes the column names VOL_LEFT and VOL_RIGHT, rather than the default LEFT and RIGHT
	@AttributeOverrides({
		@AttributeOverride(name="left", column=@Column(name="VOL_LEFT")), 
		@AttributeOverride(name="right", column=@Column(name="VOL_RIGHT"))  
		})
	StereoVolume volume;

	public Track() {}

	public Track(String Title, String filePath) {
		this.title = title;
		this.filePath = filePath;
	}

	public Track(String title, String filePath, Time playTime, Set<Artist> artists, Date added, StereoVolume volume, SourceMedia sourceMedia, Set<String> comments) {
		this.title = title;
		this.filePath = filePath;
		this.playTime = playTime;
		this.artists = artists;
		this.added = added;
		this.comments = comments;
		this.sourceMedia = sourceMedia;
		this.volume = volume;
	}
	
	public String getTitle() { return this.title; }
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getFilePath() { return this.filePath; }
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public Date getPlayTime() { return this.playTime; }
	public void setPlayTime(Date playTime) {
		this.playTime = playTime;
	}
	
	public Set<Artist> getArtists() { return this.artists; }
	public void setArtists(Set<Artist> artists) {
		this.artists = artists;
	}
	
	public Date getAdded() { return this.added; }
	public void setAdded(Date added) {
		this.added = added;
	}
	
	public Set<String> getComments() { return this.comments; }
	public void setComments(Set<String> comments) {
		this.comments = comments;
	}
	
	public SourceMedia getSourceMedia() { return this.sourceMedia; }
	public void setSourceMedia(SourceMedia sourceMedia) {
		this.sourceMedia = sourceMedia;
	}
	
	public StereoVolume getVolume() { return this.volume; }
	public void setVolume(StereoVolume volume) {
		this.volume = volume;
	}

	public String toString()  {
		StringBuffer sBuffer = new StringBuffer();
		sBuffer.append(getClass().getName()).append("@");
		sBuffer.append(Integer.toHexString(hashCode())).append(" [");
		sBuffer.append("title").append("='").append(getTitle()).append("' ");
		sBuffer.append("volume").append("='").append(getVolume()).append("' ");
		sBuffer.append("sourceMedia").append(" '").append(getSourceMedia());
		sBuffer.append("' ").append("]");
		return sBuffer.toString();
	}
}
