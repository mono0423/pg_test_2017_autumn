package jp.pgtest_autumn.model;

import java.util.ArrayList;
import java.util.List;

import jp.pgtest_autumn.bean.Photo;

public class PhotoList {

	private List<Photo> photoList;

	public PhotoList() {
		photoList = new ArrayList<>();
	}

	public void add(Photo photo) {
		photoList.add(photo);
	}

	public List<Photo> getPhotoList() {
		return photoList;
	}

	public boolean isEmpty() {
		return photoList.isEmpty();
	}
}
