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
package turnus.ui.tester;

import static turnus.common.TurnusExtensions.ARCHITECTURE;
import static turnus.common.TurnusExtensions.CAL;
import static turnus.common.TurnusExtensions.NETWORK;
import static turnus.common.TurnusExtensions.NL;
import static turnus.common.TurnusExtensions.PROFILING_CODE;
import static turnus.common.TurnusExtensions.PROFILING_DYNAMIC;
import static turnus.common.TurnusExtensions.TRACE;
import static turnus.common.TurnusExtensions.TRACEZ;
import static turnus.common.TurnusExtensions.TRACE_SIZE;
import static turnus.common.TurnusExtensions.XDF;
import static turnus.common.TurnusExtensions.INTER_PARTITION_COMM_MEM_REPORT;

import org.eclipse.core.expressions.PropertyTester;
import org.eclipse.core.resources.IFile;

/**
 * 
 * @author Simone Casale Brunet
 *
 */
public class FileExtensionTester extends PropertyTester {

	@Override
	public boolean test(Object receiver, String property, Object[] args, Object expectedValue) {
		if ("isTRACE".equals(property)) {
			if (receiver instanceof IFile) {
				IFile file = (IFile) receiver;
				return (TRACE.equals(file.getFileExtension()));
			}
		} else if ("isTRACEZ".equals(property)) {
			if (receiver instanceof IFile) {
				IFile file = (IFile) receiver;
				return (TRACEZ.equals(file.getFileExtension()));
			}
		} else if ("isDPROF".equals(property)) {
			if (receiver instanceof IFile) {
				IFile file = (IFile) receiver;
				return (PROFILING_DYNAMIC.equals(file.getFileExtension()));
			}
		} else if ("isCPROF".equals(property)) {
			if (receiver instanceof IFile) {
				IFile file = (IFile) receiver;
				return (PROFILING_CODE.equals(file.getFileExtension()));
			}
		} else if ("isNL".equals(property)) {
			if (receiver instanceof IFile) {
				IFile file = (IFile) receiver;
				return (NL.equals(file.getFileExtension()));
			}
		} else if ("isXDF".equals(property)) {
			if (receiver instanceof IFile) {
				IFile file = (IFile) receiver;
				return (XDF.equals(file.getFileExtension()));
			}
		} else if ("isARCH".equals(property)) {
			if (receiver instanceof IFile) {
				IFile file = (IFile) receiver;
				return (ARCHITECTURE.equals(file.getFileExtension()));
			}
		} else if ("isNET".equals(property)) {
			if (receiver instanceof IFile) {
				IFile file = (IFile) receiver;
				return (NETWORK.equals(file.getFileExtension()));
			}
		} else if ("isCAL".equals(property)) {
			if (receiver instanceof IFile) {
				IFile file = (IFile) receiver;
				return (CAL.equals(file.getFileExtension()));
			}
		} else if ("isTSIZE".equals(property)) {
			if (receiver instanceof IFile) {
				IFile file = (IFile) receiver;
				return (TRACE_SIZE.equals(file.getFileExtension()));
			}
		} else if ("isIPCOMM".equals(property)) {
			if (receiver instanceof IFile) {
				IFile file = (IFile) receiver;
				return (INTER_PARTITION_COMM_MEM_REPORT.equals(file.getFileExtension()));
			}
		}

		return false;
	}

}
