package org.openmrs.module.initializer.api.loaders;

import java.io.File;
import java.util.zip.ZipFile;

import org.openmrs.annotation.OpenmrsProfile;
import org.openmrs.api.context.Context;
import org.openmrs.module.initializer.Domain;
import org.openmrs.module.openconceptlab.importer.Importer;

@OpenmrsProfile(modules = { "openconceptlab:1.2.9" })
public class OpenConceptLabLoader extends BaseFileLoader {
	
	@Override
	protected Domain getDomain() {
		System.out.println("Zip===================================");
		return Domain.OCL;
	}
	
	@Override
	protected String getFileExtension() {
		return "zip";
	}
	
	@Override
	protected void load(File file) throws Exception {
		System.out.println("Zip===================================33333");
		
		ZipFile zip = new ZipFile(file);
		Importer importer = Context.getRegisteredComponent("openconceptlab.importer", Importer.class);
		System.out.println("Zip===================================22222");
		
		importer.run(zip);
	}
	
}
