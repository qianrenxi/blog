package org.qianrenxi.blog.parser;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;

import org.asciidoctor.Asciidoctor;
import org.asciidoctor.Options;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AsciidoctorjTests {
	Asciidoctor asciidoctor = Asciidoctor.Factory.create();

	@Test
	public void converString() {
		String html = asciidoctor.convert("Writing AsciiDoc is _easy_!", new HashMap<String, Object>());
		System.out.println(html);
	}

	@Test
	public void convertFile() {
		Options options = new Options();
		options.setToFile(false);
		String html = asciidoctor.convertFile(new File("src/test/resources/adocs/README.adoc"), options);
		System.out.println(html);
	}

	//@Test
	public void convertFiles() {
		String[] result = asciidoctor.convertFiles(Arrays.asList(new File("simple.adoc")),
				new HashMap<String, Object>());

		for (String html : result) {
			System.out.println(html);
		}
	}
}
