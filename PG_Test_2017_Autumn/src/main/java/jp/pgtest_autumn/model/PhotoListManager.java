package jp.pgtest_autumn.model;

import java.util.ArrayList;
import java.util.List;

import jp.pgtest_autumn.bean.Photo;

public class PhotoListManager {

	private List<Photo> photoListManager;

	public PhotoListManager() {
		photoListManager = new ArrayList<>();
	}

	public void add(Photo photo) {
		photoListManager.add(photo);
	}

	public List<Photo> getPhotoList() {
		return photoListManager;
	}

	public boolean isEmpty() {
		return photoListManager.isEmpty();
	}
}
