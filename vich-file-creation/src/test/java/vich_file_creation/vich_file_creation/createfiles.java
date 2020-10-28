package vich_file_creation.vich_file_creation;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.xpath.XPathExpressionException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.parser.ParseException;
import org.xml.sax.SAXException;

import Lib.ExcelReader;

public class createfiles {
	// static String ExcelFilePath = "Files/MandatoryRuleFile.xlsx";
	static String ExcelFilePath = "Files/MandatoryRuleFile.xlsx";
	static String validtemplatefile = "Files/VICH_TestFile.xml";
	public static void main(String args[]) throws EncryptedDocumentException, InvalidFormatException, IOException,
			XPathExpressionException, ParserConfigurationException, SAXException, TransformerException, ParseException {
		// ExcelReadin
		ExcelReader xlreader=new ExcelReader();
		System.out.println(xlreader.getDataRowCount(ExcelFilePath));
		System.out.println(xlreader.getcolindex(ExcelFilePath,"FILENAME"));
		InputStream inp = new FileInputStream(ExcelFilePath);
		Workbook wb = WorkbookFactory.create(inp);
		XpathSupport createFile = new XpathSupport();
		final int xmlField = 3;
		final int flagcheck = 0;
		final int filename = 4;
		Sheet sheet = wb.getSheetAt(0);
		
		
		
		try {
			for (int j = 1; j < 2; j++) {

				if (sheet.getRow(j).getCell(flagcheck).toString().equalsIgnoreCase("Y")
						|| sheet.getRow(j).getCell(flagcheck).toString() != null) {
					String jasonString = sheet.getRow(j).getCell(xmlField).toString();
					String newfilename = sheet.getRow(j).getCell(filename).toString();
					try {
						createFile.createfilefromtemplate1(validtemplatefile, jasonString,
								"Files/" + newfilename + ".xml");
					} catch (Exception e) {
						System.out.println("Error in creating file");
						e.printStackTrace();
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Excel rows completed");
		}
	}
}
