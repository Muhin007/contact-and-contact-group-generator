package xmlGenerators;

import randomData.*;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class XMLFileForPerson {
    private RandomGUID randomGUID = new RandomGUID();
    private RandomNumberOfPhone randomNumberOfPhone = new RandomNumberOfPhone();
    private RandomAddress randomAddress = new RandomAddress();
    private RandomFullName randomFullName = new RandomFullName();
    private boolean sex = new RandomSex().randomSex();
    public void writeXMLFile() {
        try {

            DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
            DocumentBuilder build = dFact.newDocumentBuilder();
            Document doc = build.newDocument();

            Element root = doc.createElement("Person");
            doc.appendChild(root);

            Element fullName = doc.createElement("fullName");
            fullName.appendChild(doc.createTextNode(randomFullName.getFullName(sex)));
            root.appendChild(fullName);

            Element address = doc.createElement("address");
            address.appendChild(doc.createTextNode(randomAddress.getAddress()));
            root.appendChild(address);

            Element phoneNumber = doc.createElement("phoneNumber");
            phoneNumber.appendChild(doc.createTextNode(randomNumberOfPhone.getNumberOfPhone()));
            root.appendChild(phoneNumber);

            Element GUID = doc.createElement("GUID");
            GUID.appendChild(doc.createTextNode(String.valueOf(randomGUID.getGUID())));
            root.appendChild(GUID);

            TransformerFactory tranFactory = TransformerFactory.newInstance();
            Transformer aTransformer = tranFactory.newTransformer();
            aTransformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            aTransformer.setOutputProperty(
                    "{http://xml.apache.org/xslt}indent-amount", "4");
            aTransformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource(doc);
            Date date = new Date() ;
            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss") ;
            try {
                FileWriter fos = new FileWriter(dateFormat.format(date) + "_person.xml");
                StreamResult result = new StreamResult(fos);
                aTransformer.transform(source, result);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (TransformerException ex) {
            System.out.println("Error outputting document");
        } catch (ParserConfigurationException ex) {
            System.out.println("Error building document");
        }
        System.out.println("Файл сгенерирован");
    }
}
