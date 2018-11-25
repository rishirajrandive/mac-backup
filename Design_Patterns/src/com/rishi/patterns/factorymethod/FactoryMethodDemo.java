package com.rishi.patterns.factorymethod;

/**
 * Similar to Abstract Factory however there is emphasis on families of objects
 * ImageReader is our general reader
 * Gif and Jpeg are concrete implementations
 *  
 * @author rishi
 *
 */
public class FactoryMethodDemo {
	public static void main(String[] args) {
		DecodedImage decodedImage;
		ImageReader reader = null;
		String image = "HelloWorld";
		String format = "gif";
		if (format.equals("gif")) {
			reader = new GifReader(image);
		}
		if (format.equals("jpeg")) {
			reader = new JpegReader(image);
		}
		assert reader != null;
		decodedImage = reader.getDecodeImage();
		System.out.println(decodedImage);
	}
}
