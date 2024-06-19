package com.oreilly.hh.dao;

import com.oreilly.hh.data.Album;

public interface AlbumDAO  {

	public Album persist(Album album);

	public void delete(Album album);

	public Album uniqueByTitle(String title);

	public Album getAlbum(String name, int numDiscs, boolean create);
}
