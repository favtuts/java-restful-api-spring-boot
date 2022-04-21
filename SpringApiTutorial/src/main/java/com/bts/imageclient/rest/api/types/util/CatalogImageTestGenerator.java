package com.bts.imageclient.rest.api.types.util;

import java.util.ArrayList;
import java.util.List;

import com.bts.imageclient.rest.api.types.CatalogImage;
import com.bts.imageclient.rest.api.types.CatalogMetaDatum;

public class CatalogImageTestGenerator {

	public static List<CatalogImage> generateTestImages() {
		List<CatalogImage> images = new ArrayList<CatalogImage>();
		for (int i = 0; i < 20; i++) {
			CatalogImage image = new CatalogImage();
			List<CatalogMetaDatum> metaData = new ArrayList<CatalogMetaDatum>();
			for (int k = 0; k < 10; k++) {
				CatalogMetaDatum item = new CatalogMetaDatum();
				item.setName("name" + k);
				item.setValue("value" + k);
				metaData.add(item);
			}
			image.setImageId(Integer.toString(i));
			image.setMetaData(metaData);
			image.setImageFormat("png");
			image.setImagePath("http://www.nowhere.com/image-binary-url/image" + i + "." + image.getImageFormat());
			images.add(image);
		}
		return images;
	}

	public static CatalogImage generateTestImage(String imageId) {
		CatalogImage image = new CatalogImage();
		List<CatalogMetaDatum> metaData = new ArrayList<CatalogMetaDatum>();
		for (int k = 0; k < 10; k++) {
			CatalogMetaDatum item = new CatalogMetaDatum();
			item.setName("name" + k);
			item.setValue("value" + k);
			metaData.add(item);
		}

		image.setImageId(imageId.toString());
		image.setMetaData(metaData);
		image.setImageFormat("png");
		image.setImagePath("http://www.nowhere.com/image-binary-url/image" + imageId + ".png");
		return image;
	}
}