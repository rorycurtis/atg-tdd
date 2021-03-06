package com.roanis.tdd.core.commerce.catalog;

import com.roanis.tdd.core.TestHelper;

import atg.commerce.catalog.CatalogTools;
import atg.commerce.dp.CatalogContext;
import atg.repository.RepositoryException;
import atg.repository.RepositoryItem;

public class CatalogTestHelper implements TestHelper {
	
	private CatalogTools mCatalogTools;
	private String mDefaultCatalogId;
	
	public void defaultCurrentCatalog() throws RepositoryException{
		setAsCurrent(getDefaultCatalogId());
	}
	
	public void setAsCurrent(String pId) throws RepositoryException {
		RepositoryItem catalog = getCatalogTools().getCatalog().getItem(pId, "catalog"); 
		CatalogContext.setCurrentCatalog(catalog); 
	}
	
	public void reset(){
		CatalogContext.setCurrentCatalog(null); 
	}

	public String getDefaultCatalogId() {
		return mDefaultCatalogId;
	}

	public void setDefaultCatalogId(String pDefaultCatalogId) {
		mDefaultCatalogId = pDefaultCatalogId;
	}
		
	public CatalogTools getCatalogTools() {
		return mCatalogTools;
	}

	public void setCatalogTools(CatalogTools pCatalogTools) {
		mCatalogTools = pCatalogTools;
	}

	@Override
	public String getName() {
		return getClass().getCanonicalName();
	}

}
