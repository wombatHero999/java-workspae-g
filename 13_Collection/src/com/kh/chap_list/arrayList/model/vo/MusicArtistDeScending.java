package com.kh.chap_list.arrayList.model.vo;

import java.util.Comparator;

public class MusicArtistDeScending implements Comparator<Music> {
	
	@Override
	public int compare(Music o1, Music o2) {
		return o1.getArtist().compareTo(o2.getArtist());
	}
}















