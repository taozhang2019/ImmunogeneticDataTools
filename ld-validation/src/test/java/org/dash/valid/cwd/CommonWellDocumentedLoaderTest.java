/*

    Copyright (c) 2014-2015 National Marrow Donor Program (NMDP)

    This library is free software; you can redistribute it and/or modify it
    under the terms of the GNU Lesser General Public License as published
    by the Free Software Foundation; either version 3 of the License, or (at
    your option) any later version.

    This library is distributed in the hope that it will be useful, but WITHOUT
    ANY WARRANTY; with out even the implied warranty of MERCHANTABILITY or
    FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public
    License for more details.

    You should have received a copy of the GNU Lesser General Public License
    along with this library;  if not, write to the Free Software Foundation,
    Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307  USA.

    > http://www.gnu.org/licenses/lgpl.html

*/
package org.dash.valid.cwd;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.dash.valid.gl.GLStringConstants;
import org.junit.Test;

import junit.framework.TestCase;

public class CommonWellDocumentedLoaderTest extends TestCase {	
	private static final String DQA10111 = "HLA-DQA1*01:11";
	private static final String HLA08433 = "HLA08433";
	@Test
	public void test() {
		CommonWellDocumentedLoader cwdLoader = CommonWellDocumentedLoader.getInstance();
		assertNotNull(cwdLoader);
		assertTrue(cwdLoader.getCwdAlleles() != null && cwdLoader.getCwdAlleles().size() > 0);
	}

	@Test
	public void testLoadAllCWD() throws FileNotFoundException, IOException {
		System.setProperty(GLStringConstants.HLADB_PROPERTY, "3.25.0");
		CommonWellDocumentedLoader cwdLoader = CommonWellDocumentedLoader.getInstance();
		
		assertTrue(cwdLoader.getAccessionMap().containsKey(DQA10111));
		assertTrue(cwdLoader.getAccessionMap().get(DQA10111).equals(HLA08433));
	}
}
