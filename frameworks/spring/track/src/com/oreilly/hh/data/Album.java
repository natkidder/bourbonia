package com.oreilly.hh.data;

import java.util.*;
import javax.persistence.*;
import org.hibernate.annotations.CollectionOfElements;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.IndexColumn;

@Entity
@Table(name="Album")
public class Album  {

	@Id
	@Column(name="ALBUM_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(name="TITLE", nullable=false)
	@Index(name="ALBUM_TITLE", columnNames={"TITLE"})
	private String title;

	@Column(nullable=false)
	private Integer numDiscs;

	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="ALBUM_ARTISTS", joinColumns=@JoinColumn(name="ARTIST_ID"), inverseJoinColumns=@JoinColumn(name="ALBUM_ID"))
	private Set<Artist> artists;

	@CollectionOfElements
	@JoinTable(name="ALBUM_COMMENTS", joinColumns=@JoinColumn(name="ALBUM_ID")) // note you're using your own primary key, NOT the other tbls foreign key
	@Column(name="COMMENT")
	private Set<String> comments;

	@Temporal(TemporalType.DATE)
	private Date added;

	// Use the two comm'd out lines if ALBUM_TRACKS is not an entity.  @OneToMany and @JoinColumn are used when it's an entity (facilitates cascading).
	//@CollectionOfElements // ALBUM_TRACKS is NOT an entity (can be ref's only through Album, so we must use @CollectionOfElements rather than @OneToMany
	@OneToMany(cascade=CascadeType.ALL)
	@IndexColumn(name="LIST_POS") // we want to easily sort the tracks, hence an index column
	@JoinColumn(name="ALBUM_ID", nullable=false)
	//@JoinTable(name="ALBUM_TRACKS", joinColumns=@JoinColumn(name="ALBUM_ID")) // note you're using your own primary key, NOT the other tbls foreign key
	private List<AlbumTrack> tracks;

	public Album() {}

	public Album(String title, int numDiscs) {
		this.title = title;
		this.numDiscs = numDiscs;
	}
		
	public Album(String title, int numDiscs, Set<Artist> artists, Set<String> comments, List<AlbumTrack> tracks, Date added) {
		this.title = title;
		this.numDiscs = numDiscs;
		this.artists = artists;
		this.comments = comments;
		this.tracks = tracks;
		this.added = added;
	}

	public String getTitle() { return this.title; }
	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getNumDiscs() { return this.numDiscs; }
	public void setNumDiscs(int numDiscs) {
		this.numDiscs = numDiscs;
	}
	
	public Set<Artist> getArtists() { return this.artists; }
	public void setArtists(Set<Artist> artists) {
		this.artists = artists;
	}
	
	public Set<String> getComments() { return this.comments; }
	public void setComments(Set<String> comments) {
		this.comments = comments;
	}
	
	public List<AlbumTrack> getTracks() { return this.tracks; }
	public void setTracks(List<AlbumTrack> tracks) {
		this.tracks = tracks;
	}
	
	public Date getAdded() { return this.added; }
	public void setAdded(Date added) {
		this.added = added;
	}

	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append(getClass().getName()).append("@");
		buffer.append(Integer.toHexString(hashCode())).append(" [");
		buffer.append("title").append("='").append(getTitle()).append("' ");
		buffer.append("tracks").append("='").append(getTracks()).append("' ");
		buffer.append("]");
		return buffer.toString();
	}
}

