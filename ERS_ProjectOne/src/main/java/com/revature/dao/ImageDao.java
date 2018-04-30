package com.revature.dao;

import com.revature.model.Image;

public interface ImageDao {

	public boolean insertImage(Image inputImage);
	public Image getImage(int inputRequest);
}
