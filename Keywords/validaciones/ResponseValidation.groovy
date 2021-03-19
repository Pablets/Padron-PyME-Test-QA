package validaciones

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;
import com.kms.katalon.core.util.KeywordUtil
import internal.GlobalVariable

public class ResponseValidation {

	@Keyword
	def Boolean ValidarFecha(String fecha) {

		SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date javaDate = formatoFecha.parse(fecha);
		}
		catch (ParseException e) {
			KeywordUtil.markFailedAndStop("La fecha "+ fecha +" no es valida.");
			return false;
		}
		KeywordUtil.markPassed("Fecha " + fecha + " valida.")
		return true;
	}

	def Boolean ValidarCuit(String cuitString) {

		double cuit = 0
		try {
			cuit = Double.parseDouble(cuitString);
		} catch (NumberFormatException e) {
			KeywordUtil.markFailedAndStop("CUIT no valido : " + e.printStackTrace())
			return false;
		}

		if(cuit < 10000000000 || cuit > 99000000000) {
			KeywordUtil.markFailedAndStop("CUIT no valido")
		}
		KeywordUtil.markPassed("CUIT " + cuitString + " valido.")
		return true;
	}
}
