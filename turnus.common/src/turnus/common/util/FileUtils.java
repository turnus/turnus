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
package turnus.common.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.eclipse.core.filesystem.EFS;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.IPackageFragment;
import org.eclipse.jdt.core.JavaCore;

import com.google.common.io.CharStreams;

import turnus.common.TurnusConstants;
import turnus.common.TurnusException;
import turnus.common.TurnusOptions;
import turnus.common.configuration.Configuration;

/**
 * This class contains some utilities methods for {@link File}s, {@link IFile}s
 * and {@link URI}s.
 * 
 * @author Simone Casale Brunet
 *
 */
public class FileUtils {

	/**
	 * Change the file extension of a given file. Note that extensions like
	 * <code>".tar.bz"</code> will be changes as
	 * <code>".tar.newExtension"</code>
	 * 
	 * @param file
	 *            the base file
	 * @param newExtension
	 *            the new file extension (with or without <code>"."</code>)
	 * @return the file with the new extension
	 * @throws TurnusException
	 */
	public static File changeExtension(File file, String newExtension) throws TurnusException {
		try {
			Pattern suffix = Pattern.compile("\\.\\p{Alnum}+$");
			Matcher m = suffix.matcher(file.getAbsolutePath());
			String clearFilename = m.replaceAll("");
			newExtension = newExtension.startsWith(".") ? newExtension : "." + newExtension;
			return new File(clearFilename + newExtension);
		} catch (Exception e) {
			throw new TurnusException("Impossible to change the file extension of \"" + file + "\"");
		}
	}

	/**
	 * Copy recursively all the content of a directory to the destination
	 * directory
	 * 
	 * @param source
	 *            the source directory
	 * @param destination
	 *            the destination directory
	 * @throws TurnusException
	 *             is thrown if the copy cannot be performed
	 */
	public static void copyRecursively(File source, File destination) throws TurnusException {
		try {
			if (source.isDirectory()) {
				// A simple validation, if the destination is not exist then
				// create it
				if (!destination.exists()) {
					destination.mkdirs();
				}

				// Create list of files and directories on the current source
				// Note: with the recursion 'fSource' changed accordingly
				String[] fList = source.list();

				for (int index = 0; index < fList.length; index++) {
					File _dest = new File(destination, fList[index]);
					File _source = new File(source, fList[index]);

					// Recursion call take place here
					copyRecursively(_source, _dest);
				}
			} else {
				// Found a file. Copy it into the destination, which is already
				// created in 'if' condition above

				// Open a file for read and write (copy)
				FileInputStream fInStream = new FileInputStream(source);
				FileOutputStream fOutStream = new FileOutputStream(destination);

				// Read nK at a time from the file
				byte[] buffer = new byte[TurnusConstants.DEFAULT_STREAM_BUFFER_SIZE];
				int iBytesReads;

				// In each successful read, write back to the source
				while ((iBytesReads = fInStream.read(buffer)) >= 0) {
					fOutStream.write(buffer, 0, iBytesReads);
				}

				// Safe exit
				if (fInStream != null) {
					fInStream.close();
				}

				if (fOutStream != null) {
					fOutStream.close();
				}
			}

		} catch (Exception e) {
			throw new TurnusException(
					"Impossible to copy the source folder " + source + " to the destination " + destination, e);
		}
	}

	/**
	 * Makes a directory, including any necessary but nonexistent parent
	 * directories. If a file already exists with specified name but it is not a
	 * directory then an TurnusException is thrown. If the directory cannot be
	 * created (or does not already exist) then an TurnusException is thrown
	 * 
	 * @param directory
	 *            the directory to create
	 * @throws TurnusException
	 *             in case the creation is unsuccessful
	 */
	public static void createDirectory(File directory) throws TurnusException {
		try {
			org.apache.commons.io.FileUtils.forceMkdir(directory);
		} catch (Exception e) {
			throw new TurnusException("Impossible to create the directory " + directory, e);
		}
	}

	/**
	 * Get a directory with a time stamp <code>yyyyMMddHHmmss</code> as name
	 * from the given parent directory. The directory is not fisically created.
	 * 
	 * @param directory
	 * @return
	 * @throws TurnusException
	 */
	public static File createDirectoryWithTimeStamp(File parent) throws TurnusException {
		if (parent.exists() && parent.isFile()) {
			throw new TurnusException("Impossible to create a directory in \"" + parent + "\" since this is a file.");
		}

		String dirName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		return new File(parent, dirName);
	}

	/**
	 * Create a file with a given name and extension in the given parent path.
	 * The extension can be with or without <code>"."</code>.
	 * 
	 * @param path
	 *            the parent path
	 * @param name
	 *            the file name
	 * @param extension
	 *            the file extension
	 * @return the file
	 * @throws TurnusException
	 */
	public static File createFile(File path, String name, String extension) throws TurnusException {
		try {
			if (!extension.startsWith(".")) {
				extension = "." + extension;
			}
			name = name.replaceAll("/", "_");
			return new File(path, name + extension);
		} catch (Exception e) {
			throw new TurnusException("Impossible to create a file in \"" + path + "\"  with name \"" + name
					+ "\" and extension \"" + extension + "\"");
		}
	}

	/**
	 * Create an {@link URI} of the given {@link File} (i.e. see
	 * {@link URI#createFileURI(String)}).
	 * 
	 * @param file
	 *            the file
	 * @return the URI
	 * @throws TurnusException
	 */
	public static URI createFileURI(File file) throws TurnusException {
		try {
			return URI.createFileURI(file.getAbsolutePath());
		} catch (Exception e) {
			throw new TurnusException("Impossible to obtain an URI of \"" + file + "\"");
		}
	}

	/**
	 * Create an {@link URI} of the given {@link IFile} (i.e. see
	 * {@link URI#createFileURI(String)}).
	 * 
	 * @param file
	 *            the iFile
	 * @return the URI
	 * @throws TurnusException
	 */
	public static URI createFileURI(IFile file) throws TurnusException {
		try {
			String path = file.getFullPath().toString();
			return URI.createPlatformResourceURI(path, true);
		} catch (Exception e) {
			throw new TurnusException("Impossible to obtain an URI of \"" + file + "\"");
		}
	}

	/**
	 * Get a file name with a time stamp <code>yyyyMMddHHmmss</code> as name
	 * from the given parent directory and extension. The file is not fisically
	 * created.
	 * 
	 * @param parent
	 *            the parent directory
	 * @param extension
	 *            the file extension (with or without <code>"."</code>)
	 * @return
	 */
	public static File createFileWithTimeStamp(File parent, String extension) {
		if (!extension.startsWith(".")) {
			extension = "." + extension;
		}
		String fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + extension;
		return new File(parent, fileName);

	}

	public static boolean createIFile(IFile file) {
		if (file == null || file.exists()) {
			return false;
		}
		try {
			byte[] bytes = "".getBytes();
			file.create(new ByteArrayInputStream(bytes), IResource.NONE, null);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Create a TURNUS output directory given a TURNUS configuration. The
	 * configuration should contain the {@link TurnusOptions.TRACE_FILE} option
	 * otherwise a TurnusException is thrown. Starting from the parent path of
	 * the trace file, the output directory is created (if it does not yet
	 * exists) such that:
	 * 
	 * <pre>
	 *  &lttrace-file-parent-path&gt/analysis/&ltanalysis-name&gt/
	 * </pre>
	 * 
	 * If the directory creation is successful, then the directory is stored in
	 * the given configuration as the {@link TurnusOptions.OUTPUT_DIRECTORY}
	 * option value
	 * 
	 * @param analysisName
	 *            the analysis name
	 * @param configuration
	 *            the configuration
	 * @return the output directory
	 * @throws TurnusException
	 *             in case the creation is unsuccessful
	 */
	public static File createOutputDirectory(String analysisName, Configuration configuration) throws TurnusException {
		if (!configuration.hasValue(TurnusOptions.TRACE_FILE)) {
			throw new TurnusException("The output directory cannot be created since the configuration \""
					+ configuration.getName() + "\" does not have any trace file defined");
		}

		File dir = configuration.getValue(TurnusOptions.TRACE_FILE);
		dir = new File(dir.getParentFile(), "analysis");
		dir = new File(dir, analysisName);
		if (!dir.exists()) {
			try {
				createDirectory(dir);
			} catch (Exception e) {
				throw new TurnusException("The output directory \"" + dir + "\" cannot be created", e);
			}
		}

		configuration.setValue(TurnusOptions.OUTPUT_DIRECTORY, dir);
		return dir;
	}

	/**
	 * Create a temporary file
	 * 
	 * @param prefix
	 *            the prefix
	 * @param suffix
	 *            the suffix
	 * @param deleteOnExit
	 *            true if the file should be deleted on exit of JVM
	 * @return the temporary file
	 * @throws TurnusException
	 *             if the file cannot be created
	 */
	public static File createTempFile(String prefix, String suffix, boolean deleteOnExit) throws TurnusException {
		try {
			File file = Files.createTempFile(prefix, suffix).toFile();
			if (deleteOnExit) {
				file.deleteOnExit();
			}
			return file;
		} catch (Exception e) {
			throw new TurnusException("The temp file cannot be created", e);
		}
	}

	/**
	 * Deletes a directory recursively
	 * 
	 * @param directory
	 *            the directory to delete
	 * @throws TurnusException
	 *             in case deletion is unsuccessful
	 */
	public static void deleteDirectory(File directory) throws TurnusException {
		try {
			org.apache.commons.io.FileUtils.deleteDirectory(directory);
		} catch (Exception e) {
			throw new TurnusException("Impossible to delete recursively the directory " + directory, e);
		}
	}

	/**
	 * Format a file extension: it returns the extension as {@code
	 * *.extension}
	 * 
	 * @param extension
	 * @return
	 */
	public static String formatFileExtension(String extension) {
		String result = "";
		for (String e : extension.split(";")) {
			if (!e.startsWith("*.")) {
				e = "*." + e;
			}
			result = ";" + e + result;
		}

		return result.replaceFirst(";", "");
	}

	/**
	 * Format a file extension list: it returns the extension as {@code
	 * *.extension}
	 * 
	 * @param extensions
	 * @return
	 */
	public static String[] formatFileExtension(String[] fileExtensions) {
		String[] collection = new String[fileExtensions.length];
		for (int i = 0; i < fileExtensions.length; i++) {
			collection[i] = formatFileExtension(fileExtensions[i]);
		}
		return collection;
	}

	/**
	 * Get the file extension (e.g. "java", "jpg").
	 * 
	 * @param file
	 *            the input file
	 * @return the file extension
	 * @throws TurnusException
	 */
	public static String getExtension(File file) throws TurnusException {
		try {
			if (!file.getName().isEmpty()) {
				String fileName = file.getName();
				int mid = fileName.lastIndexOf(".");
				return fileName.substring(mid + 1, fileName.length());
			} else {
				throw new TurnusException(
						"Impossible to obtain the file extension of \"" + file + "\": the file name is empty");
			}
		} catch (Exception e) {
			throw new TurnusException("Impossible to obtain the file extension of \"" + file + "\"");
		}
	}

	/**
	 * Get a {@link File} from {@link IFile}.
	 * 
	 * @param file
	 *            the iFile
	 * @return the iFile
	 * @throws TurnusException
	 */
	public static File getFile(IFile file) throws TurnusException {
		try {
			java.net.URI uri = file.getLocationURI();

			if (file.isLinked()) {
				uri = file.getRawLocationURI();
			}

			File jfile = EFS.getStore(uri).toLocalFile(0, new NullProgressMonitor());
			return jfile;
		} catch (Exception e) {
			throw new TurnusException("Impossible to obtain the File from \"" + file + "\"");

		}
	}

	/**
	 * Get the {@link IFile} from a <code>portablePath</code> (i.e. see
	 * {@link EcoreUtils#getPortablePath(IFile)}).
	 * 
	 * @param portablePath
	 *            the portable path
	 * @return the iFile
	 * @throws TurnusException
	 */
	public static IFile getIFile(String portablePath) throws TurnusException {
		try {
			Path path = new Path(portablePath);
			IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
			return file;
		} catch (Exception e) {
			throw new TurnusException("Impossible to obtain the IFile from \"" + portablePath + "\"");
		}

	}

	/**
	 * Get the name of the file file without any extension (e.g. for the file
	 * "/tmp/myFile.ext" the result is "myFile").
	 * 
	 * @param file
	 *            the file
	 * @return the file name
	 * @throws TurnusException
	 */
	public static String getNameWithoutExtension(File file) throws TurnusException {
		try {
			String s = file.getName();
			String separator = System.getProperty("file.separator");
			String filename;

			// Remove the path upto the filename.
			int lastSeparatorIndex = s.lastIndexOf(separator);
			if (lastSeparatorIndex == -1) {
				filename = s;
			} else {
				filename = s.substring(lastSeparatorIndex + 1);
			}

			// Remove the extension.
			int extensionIndex = filename.lastIndexOf(".");
			if (extensionIndex == -1)
				return filename;

			return filename.substring(0, extensionIndex);
		} catch (Exception e) {
			throw new TurnusException("Impossible to obtain the name without extension of \"" + file + "\"");
		}

	}

	/**
	 * Get the name of the file file without any extension (e.g. for the file
	 * "/tmp/myFile.ext" the result is "myFile").
	 * 
	 * @param file
	 *            the file
	 * @return the file name without extension
	 * @throws TurnusException
	 */
	public static String getNameWithoutExtension(IFile file) throws TurnusException {
		try {
			File f = getFile(file);
			return getNameWithoutExtension(f);
		} catch (Exception e) {
			throw new TurnusException("Impossible to obtain the name without extension of \"" + file + "\"");
		}
	}

	/**
	 * Return a platform-neutral string representation of the given
	 * {@link IFile}.
	 * 
	 * @param file
	 *            the iFile
	 * @return the portable path
	 * @throws TurnusException
	 */
	public static String getPortablePath(IFile file) throws TurnusException {
		try {
			return file.getFullPath().toPortableString();
		} catch (Exception e) {
			throw new TurnusException("Impossible to obtain a portable path of \"" + file + "\"");

		}
	}

	/**
	 * Returns the qualified name of the given file, i.e. qualified.name.of.File
	 * for <code>/project/sourceFolder/qualified/name/of/File.fileExt</code> or
	 * <code>/project/outputFolder/qualified/name/of/File.fileExt</code>.
	 * 
	 * @param file
	 *            a file
	 * @return a qualified name source folder
	 * @throws TurnusException
	 */
	public static String getQualifiedName(IFile file) throws TurnusException {
		try {
			IProject project = file.getProject();
			IJavaProject javaProject = JavaCore.create(project);
			if (!javaProject.exists()) {
				throw new TurnusException(
						"Impossible to obtainthe qualified name of \"" + file + "\": the project does not exist");
			}

			IPath path = file.getParent().getFullPath();
			IPackageFragment fragment = null;
			if (javaProject.getOutputLocation().isPrefixOf(path)) {
				// create relative path
				int count = path.matchingFirstSegments(javaProject.getOutputLocation());
				IPath relPath = path.removeFirstSegments(count);

				// creates full path to source
				for (IFolder folder : EcoreUtils.getSourceFolders(project)) {
					path = folder.getFullPath().append(relPath);
					fragment = javaProject.findPackageFragment(path);
					if (fragment != null) {
						break;
					}
				}
			} else {
				fragment = javaProject.findPackageFragment(path);
			}

			if (fragment == null) {
				throw new TurnusException("Impossible to obtainthe qualified name of \"" + file
						+ "\": the package fragment is not valid");
			}

			String name = file.getFullPath().removeFileExtension().lastSegment();
			if (fragment.isDefaultPackage()) {
				// handles the default package case
				return name;
			}
			return fragment.getElementName() + "." + name;
		} catch (Exception e) {
			throw new TurnusException("Impossible to obtainthe qualified name of \"" + file + "\"");
		}
	}

	/**
	 * Return the path of the file without the project name<br/>
	 * Example: <i>[projectName]/dir1/dir2/dir3</i>, [projectName] is removed
	 * 
	 * @param file
	 * @return
	 * @throws TurnusException
	 */
	public static String getRelativePath(IFile file) throws TurnusException {
		try {
			String fullPath = file.getFullPath().toString();
			return fullPath.replaceFirst("/".concat(file.getProject().getName()).concat("/"), "");
		} catch (Exception e) {
			throw new TurnusException("Impossible to obtainthe the relative path of \"" + file + "\"");
		}
	}

	/**
	 * Get the content {@link String} representation of the given file. A
	 * default encoding is supposed (i.e. {@link StandardCharsets.UTF_8}).
	 * 
	 * @param file
	 *            the file
	 * @return the file content as a string
	 * @throws TurnusException
	 */
	public static String toString(File file) throws TurnusException {
		return toString(file, StandardCharsets.UTF_8);
	}

	/**
	 * Get the content {@link String} representation of the given file
	 * 
	 * @param file
	 *            the file
	 * @param encoding
	 *            the file encoding format
	 * @return the file content as a string
	 * @throws TurnusException
	 */
	public static String toString(File file, Charset encoding) throws TurnusException {
		try {
			byte[] encoded = Files.readAllBytes(file.toPath());
			return new String(encoded, encoding);
		} catch (Exception e) {
			throw new TurnusException("Impossible to convert the file content of \"" + file + "\" to a string", e);
		}
	}

	/**
	 * Get the content of the given input stream as a {@link String}. A default
	 * encoding is supposed (i.e. {@link StandardCharsets.UTF_8}).
	 * 
	 * @param is
	 *            the input stream
	 * @return the content as a string
	 * @throws TurnusException
	 */
	public static String toString(InputStream is) throws TurnusException {
		return toString(is, StandardCharsets.UTF_8);
	}

	/**
	 * Get the content of the given input stream as a {@link String}.
	 * 
	 * @param is
	 *            the input stream
	 * @param encoding
	 *            the encoding
	 * @return the content as a string
	 * @throws TurnusException
	 */
	public static String toString(InputStream is, Charset encoding) throws TurnusException {
		try {
			return CharStreams.toString(new InputStreamReader(is, encoding));
		} catch (Exception e) {
			throw new TurnusException("Impossible to convert the input stream to a string", e);
		}
	}

	/**
	 * Write the content {@link String} representation to the given file. A
	 * default encoding is supposed (i.e. {@link StandardCharsets.UTF_8}).
	 * 
	 * @param file
	 *            the file
	 * @param content
	 *            the content
	 * @return the writing status
	 * @throws TurnusException
	 */
	public static Boolean writeStringToFile(File file, String content) throws TurnusException {
		return writeStringToFile(file, content, StandardCharsets.UTF_8);
	}

	/**
	 * Write the content {@link String} representation to the given file. A
	 * default encoding is supposed (i.e. {@link StandardCharsets.UTF_8}).
	 * 
	 * @param file
	 *            the file
	 * @param content
	 *            the content
	 * @param encoding
	 *            the encoding
	 * @return the writing status
	 * @throws TurnusException
	 */
	public static Boolean writeStringToFile(File file, String content, Charset encoding) throws TurnusException {
		try {
			if (Files.write(Paths.get(file.getAbsolutePath()), content.getBytes(encoding)) != null)
				return true;
			else
				return false;

		} catch (Exception e) {
			throw new TurnusException("Impossible to write the string content to file \"" + file + "\"", e);
		}
	}
}
