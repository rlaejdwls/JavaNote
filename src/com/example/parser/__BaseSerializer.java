package com.example.parser;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class __BaseSerializer {
	public static <T> boolean write(T settings, String path) {
        try {
        	Marshaller marshaller = JAXBContext.newInstance(settings.getClass()).createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_ENCODING, "utf-8");
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(settings, new FileOutputStream(path));
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }

    public static <T> T read(Class<T> klass, String path) {
    	T settings = null;
        try {
            settings = read(klass, new FileInputStream(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return settings;
    }
    
	@SuppressWarnings("unchecked")
	public static <T> T read(Class<T> klass, InputStream is) {
    	T settings = null;
    	
        try {
        	Unmarshaller unmarshaller = JAXBContext.newInstance(klass).createUnmarshaller();
            settings = (T) unmarshaller.unmarshal(is);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return settings;
    }
}
