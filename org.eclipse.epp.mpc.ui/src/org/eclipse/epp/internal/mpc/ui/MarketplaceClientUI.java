/*******************************************************************************
 * Copyright (c) 2010 The Eclipse Foundation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 	The Eclipse Foundation - initial API and implementation
 *******************************************************************************/
package org.eclipse.epp.internal.mpc.ui;

import org.eclipse.core.runtime.ILog;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Status;
import org.eclipse.osgi.util.NLS;

public class MarketplaceClientUI {

	public static final String BUNDLE_ID = "org.eclipse.epp.mpc.ui";

	public static ILog getLog() {
		return Platform.getLog(Platform.getBundle(BUNDLE_ID));
	}

	public static void error(String message, Throwable exception) {
		if (message == null) {
			message = NLS.bind("Unexpected exception: {0}", exception.getMessage());
		}
		getLog().log(new Status(IStatus.ERROR, BUNDLE_ID, IStatus.ERROR, message, exception));
	}

	public static void error(Throwable exception) {
		error(null, exception);
	}
}