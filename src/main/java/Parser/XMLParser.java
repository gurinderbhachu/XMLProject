package Parser;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class XMLParser {
	
	public static String xmlNodes = "";
	private static DocumentBuilderFactory dBuilderFactory = DocumentBuilderFactory.newInstance();
	private static DocumentBuilder docBuilder = null;
	private static Document xmlFile = null;
	private static NodeList nodes = null;
	
	
	public void parse(File file) throws ParserConfigurationException, SAXException, IOException{
		dBuilderFactory.setIgnoringElementContentWhitespace(true);
		docBuilder = dBuilderFactory.newDocumentBuilder();
		xmlFile = docBuilder.parse(file);
		xmlFile.getDocumentElement().normalize();
	}
	
	public void parseString(){
		
	}
	
//	public void getAllNodes(){
//		Element element = xmlFile.getDocumentElement();
////		System.out.println("xmlfile:-" + xmlFile.getTextContent());
////		NodeList nodes = rootElement.getChildNodes();
////		for(int i = 0; i < rootElement.has.getLength();i++){
////			
////			System.out.println("node :- " + nodes.item(i));
////		}
//		
//		System.out.println("xmlFile :- " + xmlFile.getChildNodes().getClass());
//		
//		
//		
//		NodeList nodes = xmlFile.getChildNodes();
//		parseSubNode(nodes);
//	}
	
	public NodeList getAllNodes(){
		
		nodes = xmlFile.getChildNodes();
		return nodes;
		
		
	}
	
	private void parseSubNode(NodeList nodes){
		for(int i =0;i < nodes.getLength();i++){
			if(nodes.item(i).hasChildNodes()){
				System.out.println("node name :-" + nodes.item(i).getNodeName());
				parseSubNode(nodes.item(i).getChildNodes());
			}else{
				if(!nodes.item(i).getNodeValue().trim().isEmpty()){
					System.out.println("node value :-" + nodes.item(i).getNodeValue());
				}
			}
		}
		return;
	}
	
	/**
	 * returns parents elements under root node in provided NodeList
	 * @param nodes
	 * @return ArrayList
	 */
	
	public ArrayList<String> getParentElements(NodeList nodes){
		NodeList subNodes = nodes.item(0).getChildNodes();
		ArrayList<String> parents = new ArrayList<String>();
		for(int i =0 ; i<subNodes.getLength();i++){
			if(!parents.contains(subNodes.item(i).getNodeName())){
				if(subNodes.item(i) instanceof Element){
					parents.add(subNodes.item(i).getNodeName());
				}
			}
		}
		return parents;
	}
	
	/**
	 * returns parents elements under root node
	 * @param nodes
	 * @return ArrayList
	 */
	
	public ArrayList<String> getParentElements(){
		NodeList nodes = xmlFile.getChildNodes();
		return getParentElements(nodes);
	}
	
//	private static void removeNullTextNode(NodeList nodes){
//		for(int i =0;i < nodes.getLength();i++){
//			Node child = nodes.item(i);
//			if(child instanceof Element){
//				if(child.getChildNodes().getLength() > 0){
//					removeNullTextNode(child.getChildNodes());
//				}else{
//					if(child.getNodeType() == Node.TEXT_NODE && child.getNodeValue().trim().isEmpty()){
//						child.getParentNode().removeChild(child);
//					}
//				}
//			}
//		}
//	}	
	
	
	
	
	
} 

