package org.qianrenxi.blog.utils.asciidoctor;

import java.util.HashMap;

import org.asciidoctor.Asciidoctor;
import org.asciidoctor.Asciidoctor.Factory;
import org.asciidoctor.Options;

public class AsciidoctorHelper {
	
	public static Asciidoctor getAsciidoctor(){
		Asciidoctor asciidoctor = Factory.create();
		return asciidoctor;
	}

	public static String convert(String theOriginal){
		return getAsciidoctor().convert(theOriginal, new HashMap<>());
	}
	
	public static Options getDefaultOptions(){
		return new Options();
	}
}
