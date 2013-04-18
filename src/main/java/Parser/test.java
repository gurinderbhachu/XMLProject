package Parser;


import java.io.File;
 
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
 
public class test {
 
    private DocumentBuilderFactory docBF = null;
    private DocumentBuilder docB = null;
    private Document doc = null;
    public void DomParser(File file) {
 
  try {
        docBF = DocumentBuilderFactory.newInstance();
        docB = docBF.newDocumentBuilder();
        doc = docB.parse(file);
      } catch (Exception e) {
        e.printStackTrace();
      }
 
    }
 
    public void parse()
    {
      NodeList nodeList = doc.getElementsByTagName("*");
      int size = nodeList.getLength();
      System.out.println("Node Name : myaction and Total Node in XML : "+size);
 
      for(int i = 0 ; i < size ; i++)
      {
          System.out.println("---------------Node ("+i+")--------------------");
          Node node = nodeList.item(i);
          if(node.getNodeType() == Node.ELEMENT_NODE)
          {
              Element e = (Element) node;
              System.out.println("Name:"+e.getAttribute("name"));
              System.out.println("Class:"+e.getAttribute("class"));
              //System.out.println("No Attribute :"+e.getAttribute("aaa").length());
              NodeList resultNodeList = e.getElementsByTagName("*");
              int resultNodeListSize = resultNodeList.getLength();
              for(int j = 0 ; j < resultNodeListSize ; j++ )
              {
                  Node resultNode = resultNodeList.item(j);
                  if(resultNode.getNodeType() == Node.ELEMENT_NODE)
                  {
                      Element resultE = (Element) resultNode;
                      System.out.println("Result Name :"+resultE.getAttribute("name"));
                      System.out.println("Result Value :"+resultE.getTextContent());
                  }
              }
          }
      }
 
    }
 
}