package Parser;

import java.util.ArrayList;
import java.util.HashMap;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XML {
	HashMap<String,String> data = new HashMap<String,String>();
	ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String,String>>();
			
	public ArrayList<HashMap<String,String>> toList(NodeList nodes,ArrayList<String> parents){
		parseNodes(nodes,parents);
		return list;
	}

	private void setTempStroage(String key,String attribute,String value){
		int i = 1;
		String temp = key;
		if(!attribute.trim().isEmpty()){
			temp = key + "_" + attribute;
		}
		while(data.containsKey(temp)){
			temp += "-" + i++;
		}
		data.put(temp, value);
	}

	private HashMap<String,String> getTempStorage(){
		HashMap	<String,String> temp = new HashMap<String,String>();
		temp = data;
		data = new HashMap<String,String>();
		return temp;
	}
	
	private void parseNodes(NodeList nodes, ArrayList<String> parents){
		for(int i =0;i < nodes.getLength();i++){
			Node child = nodes.item(i);
			if(child instanceof Element){
				child = removeTextNode(child);
				if(child.getChildNodes().getLength() > 0){
					parseNodes(child.getChildNodes(),parents);
				}else{
					String att = "";
					if(child.hasAttributes()){
						att = child.getAttributes().item(0).getNodeName();
					}
					System.out.println("value:- " + child.getTextContent());
					setTempStroage(child.getNodeName(),att,child.getTextContent());
				}
					if(parents.contains(child.getParentNode().getNodeName()) && child.getNextSibling() == null){
						HashMap<String,String> temp = getTempStorage();
						 if(!temp.isEmpty())
							 list.add(temp);
					}
				
			}
		}
	}
	
	private static Node removeTextNode(Node node) {  
	    NodeList nlist=node.getChildNodes();  
	    for (int i=nlist.getLength()-1; i>-1; i--) {  
	        Node subNode=nlist.item(i);  
	        if (subNode.getNodeType()==Node.TEXT_NODE) {
	        	subNode.getParentNode().removeChild(subNode);  
	        }  
	    }
	    return node;
    }  
	
}
