/* 
 * TURNUS - www.turnus.co
 * 
 * Copyright (C) 2010-2016 EPFL SCI STI MM
 *
 * This file is part of TURNUS.
 *
 * TURNUS is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * TURNUS is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with TURNUS.  If not, see <http://www.gnu.org/licenses/>.
 * 
 * Additional permission under GNU GPL version 3 section 7
 * 
 * If you modify this Program, or any covered work, by linking or combining it
 * with Eclipse (or a modified version of Eclipse or an Eclipse plugin or 
 * an Eclipse library), containing parts covered by the terms of the 
 * Eclipse Public License (EPL), the licensors of this Program grant you 
 * additional permission to convey the resulting work.  Corresponding Source 
 * for a non-source form of such a combination shall include the source code 
 * for the parts of Eclipse libraries used as well as that of the  covered work.
 * 
 */
package turnus.ui.util;

import org.eclipse.jface.resource.CompositeImageDescriptor;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Point;

/**
 * 
 * @author Simone Casale Brunet
 *
 */
public class OverlayImageIcon extends CompositeImageDescriptor {

	/** Constant for overlaying icon in top left corner. */
	public static final int TOP_LEFT = 0;
	/** Constant for overlaying icon in top right corner. */
	public static final int TOP_RIGHT = 1;
	/** Constant for overlaying icon in bottom left corner. */
	public static final int BOTTOM_LEFT = 2;
	/** Constant for overlaying icon in bottom right corner. */
	public static final int BOTTOM_RIGHT = 3;

	private Image baseImage;
	private Image overlayImage;
	private int location;
	private Point imgSize;

	/**
	 * Constructor.
	 * 
	 * @param baseImage
	 *            background image
	 * @param overlayImage
	 *            the image to put on top of background image
	 * @param location
	 *            in which corner to put the icon
	 */
	public OverlayImageIcon(Image baseImage, Image overlayImage, int location) {
		super();
		this.baseImage = baseImage;
		this.overlayImage = overlayImage;
		this.location = location;
		this.imgSize = new Point(baseImage.getImageData().width, baseImage.getImageData().height);
	}

	@Override
	protected void drawCompositeImage(int width, int height) {
		// Draw the base image
		drawImage(baseImage.getImageData(), 0, 0);
		ImageData imageData = overlayImage.getImageData();
		switch (location) {
		// Draw on the top left corner
		case TOP_LEFT:
			drawImage(imageData, 0, 0);
			break;

		// Draw on top right corner
		case TOP_RIGHT:
			drawImage(imageData, imgSize.x - imageData.width, 0);
			break;

		// Draw on bottom left
		case BOTTOM_LEFT:
			drawImage(imageData, 0, imgSize.y - imageData.height);
			break;

		// Draw on bottom right corner
		case BOTTOM_RIGHT:
			drawImage(imageData, imgSize.x - imageData.width, imgSize.y - imageData.height);
			break;

		}
	}

	@Override
	protected Point getSize() {
		return imgSize;
	}
	
	public Image getImage(){
		return createImage();
	}

}
