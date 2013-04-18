import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import javax.xml.parsers.ParserConfigurationException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.xml.sax.SAXException;

import Parser.XMLParser;
import Transformed.XML;


public class XMlParserTest {

//	@BeforeClass
//	public static void setUpBeforeClass() throws Exception {
//	}
//
//	@AfterClass
//	public static void tearDownAfterClass() throws Exception {
//	}
//
//	@Before
//	public void setUp() throws Exception {
//	}
//
//	@After
//	public void tearDown() throws Exception {
//	}

	@Test
	public void test() {
		XMLParser xmlParser = new XMLParser();
		XML xml = new XML();
		try {
			xmlParser.parse(new File("SampleImport.xml"));
//			System.out.println(xml.toList(xmlParser.getAllNodes()));
//			xml.printSubLinks(xmlParser.getAllNodes());
			System.out.println("Parent :-" + xmlParser.getParentElements());
			ArrayList<HashMap<String, String>> list = xml.toList(xmlParser.getAllNodes(), xmlParser.getParentElements());
			System.out.println("element:-" + list);
			System.out.println("size:-" + list.size());
			
			
//			xml.next(xmlParser.getAllNodes());
//			for(HashMap<String,String> item : list){
//				System.out.println("genre value:-" + item.get("genre"));
//				for(Entry<String, String> entry : item.entrySet()){
//					System.out.println("entrySet:-" + entry);
//				}
//			}
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
