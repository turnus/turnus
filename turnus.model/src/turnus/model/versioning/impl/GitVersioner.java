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
import java.util.Date;

import org.eclipse.jgit.lib.Constants;
import org.eclipse.jgit.lib.ObjectId;
import org.eclipse.jgit.lib.Repository;
import org.eclipse.jgit.revwalk.RevCommit;
import org.eclipse.jgit.revwalk.RevWalk;
import org.eclipse.jgit.storage.file.FileRepositoryBuilder;

import turnus.model.versioning.Version;
import turnus.model.versioning.Versioner;
import turnus.model.versioning.VersioningFactory;

/**
 * 
 * @author Simone Casale Brunet
 *
 */
public class GitVersioner implements Versioner {

	private Date getLastModifiedDate(File file, Repository repo, ObjectId revId) {
		if (file.exists()) {
			return new Date(file.lastModified());
		} else {
			try {
				RevWalk walk = new RevWalk(repo);
				RevCommit commit = walk.parseCommit(revId);
				Date date = commit.getAuthorIdent().getWhen();
				try {
					walk.close();
				} catch (Exception e) {
				}
				return date;
			} catch (Exception e) {
			}
		}
		return new Date();
	}

	private String getRevision(ObjectId revision) {
		String rev = revision.getName();
		return rev != null ? rev : "";
	}

	@Override
	public Version getVersion(File file) {
		if (file == null) {
			return new FilePropertiesVersioner().getVersion(file);
		}

		Repository repo = searchNearestRepository(file);
		if (repo != null) {
			try {
				ObjectId revId = repo.resolve(Constants.HEAD);
				Date mdofifDate = getLastModifiedDate(file, repo, revId);
				String revision = getRevision(revId);

				Version v = VersioningFactory.eINSTANCE.createVersion();
				v.setVersionDate(new Date());
				v.setLastModification(mdofifDate);
				v.setAttribute("versioner", GitVersioner.class.getName());
				v.setId(revision);
				return v;

			} catch (Exception e) {
			}
		}

		return new FilePropertiesVersioner().getVersion(file);
	}

	private Repository searchNearestRepository(File file) {
		if (file == null) {
			return null;
		} else if (file.exists()) {
			try {
				Repository repo = new FileRepositoryBuilder().findGitDir(file.getCanonicalFile()).build();
				ObjectId revision = repo.resolve(Constants.HEAD);
				if (revision != null) {
					return repo;
				}
			} catch (Exception e) {
			}
		}
		return searchNearestRepository(file.getParentFile());
	}

}
