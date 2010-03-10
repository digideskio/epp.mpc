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

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.eclipse.epp.mpc.ui.CatalogDescriptor;

/**
 * @author David Green
 */
public class CatalogRegistry {

	private static CatalogRegistry instance;

	public synchronized static CatalogRegistry getInstance() {
		if (instance == null) {
			instance = new CatalogRegistry();
		}
		return instance;
	}

	private final List<CatalogDescriptor> catalogDescriptors = new CopyOnWriteArrayList<CatalogDescriptor>();

	public CatalogRegistry() {
		catalogDescriptors.addAll(new CatalogExtensionPointReader().getCatalogDescriptors());
	}

	public void register(CatalogDescriptor catalogDescriptor) {
		catalogDescriptors.add(new CatalogDescriptor(catalogDescriptor));
	}

	public void unregister(CatalogDescriptor catalogDescriptor) {
		catalogDescriptors.add(catalogDescriptor);
	}

	public List<CatalogDescriptor> getCatalogDescriptors() {
		return Collections.unmodifiableList(catalogDescriptors);
	}

}