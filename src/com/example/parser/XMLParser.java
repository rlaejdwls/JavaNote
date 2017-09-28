package com.example.parser;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.example.parser.model.StringNode;
import com.example.parser.model.StringsRoot;
import com.example.util.Util;

public class XMLParser {
	private Map<String, StringsRoot> langs = new HashMap<>();
	
	public void formating(String path, String locale) throws IOException {
		StringsRoot model = __BaseSerializer.read(StringsRoot.class, path);
		FileWriter fw = new FileWriter(String.format(Util.getDevelopPath() + "com/example/parser/result/result_%s.txt", locale));
		
		for (StringNode node : model.getString()) {
			fw.write(
				"" 					+ "\t" + 
				node.getName() 		+ "\t" + 
				locale 				+ "\t" + 
				node.getValue() 	+ "\t" +
				new SimpleDateFormat("yyyy/MM/dd HH:mm").format(new Date()) + "\t" +
				"NO_TRANS" + "\t" +
				new SimpleDateFormat("yyyy/MM/dd HH:mm").format(new Date()) + "\t" +
				"NO_TRANS" + "\t" + 
				"\r\n");
			fw.flush();
		}
		fw.close();
	}
	
	public static void main(String[] args) {
		XMLParser parser = new XMLParser();
		File dir = new File(Util.getDevelopPath() + "com/example/parser/data");
		
		for (File lang : dir.listFiles()) {
			String locale = lang.getName().substring("strings_".length(), lang.getName().lastIndexOf(".xml"));
			try {
				parser.formating(String.format(Util.getDevelopPath() + "com/example/parser/data/strings_%s.xml", locale), locale);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
