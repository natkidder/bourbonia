package com.oreilly.hh.data;

import java.util.*;
import javax.persistence.*;
import org.hibernate.annotations.Index;

@Entity
@Table(name="ARTIST")
@NamedQueries({@NamedQuery(name="com.oreilly.hh.data.artistByName", query="from Artist as artist where upper(artist.name)=upper(:name)")})

public class Artist {

	@Id
	@Column(name="ARTIST_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	@Column(name="NAME", nullable=false,unique=true)
	@Index(name="ARTIST_NAME", columnNames={"NAME"})
	private String name;

	@ManyToMany
	@JoinTable(name="TRACK_ARTISTS", joinColumns={@JoinColumn(name="TRACK_ID")}, inverseJoinColumns={@JoinColumn(name="ARTIST_ID")})
	private Set<Track> tracks;

	@ManyToOne
	@JoinColumn(name="actualArtist")
	private Artist actualArtist;

	public Artist()  {}

	public Artist(String name, Set<Track> tracks, Artist actualArtist) {
		this.name = name;
		this.tracks = tracks;
		this.actualArtist = actualArtist;
	}

	public Integer getId()  { return this.id; }
	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() { return this.name; }
	public void setName(String name) {
		this.name = name;
	}

	public Set<Track> getTracks() { return this.tracks; }
	public void setTracks(Set<Track> tracks) {
		this.tracks = tracks;
	}

	public Artist getActualArtist() { return this.actualArtist; }
	public void setActualArtist(Artist actualArtist)  {
		this.actualArtist = actualArtist;
	}

	/**
	* Produce a human-readable representation of the artist.
	* @return a textual description of the artist
	*/
	public String toString() {
		StringBuilder builder = new StringBuilder();
		
		builder.append(getClass().getName()).append("@");
		builder.append(Integer.toHexString(hashCode())).append(" [");
		builder.append("name").append("='").append(getName()).append("' ");
		builder.append("actualArtist").append("= '").append(getActualArtist());
		builder.append("' ").append("]");

		return builder.toString();
	}
}

