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
package turnus.model.versioning.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.UUID;

import turnus.model.versioning.Version;
import turnus.model.versioning.Versioner;
import turnus.model.versioning.VersioningFactory;

/**
 * 
 * @author Simone Casale Brunet
 * @author Endri Bezati
 *
 */
public class FilePropertiesVersioner implements Versioner {

	private static String checksum(String filePath, String algorithm) {

        MessageDigest md;
        try {
            md = MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalArgumentException(e);
        }

        try (InputStream is = new FileInputStream(filePath);
             DigestInputStream dis = new DigestInputStream(is, md)) {
            while (dis.read() != -1) ; //empty loop to clear the data
            md = dis.getMessageDigest();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
        String output = String.format("%032X", new BigInteger(1, md.digest()));
        return output;
    }
	
	
	@Override
	public Version getVersion(File file) {
		Date date = new Date();
		Version v = VersioningFactory.eINSTANCE.createVersion();
		v.setVersionDate(date);

		if (file != null && file.exists()) {
			v.setLastModification(new Date(file.lastModified()));
			try {
				v.setId(checksum(file.getPath(), "SHA3-256"));
			} catch (Exception e) {
				v.setId(UUID.randomUUID().toString());
			}
		} else {
			v.setLastModification(date);
			v.setId(UUID.randomUUID().toString());
		}

		v.setAttribute("versioner", FilePropertiesVersioner.class.getName());

		return v;
	}

}
