import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import groovy.json.JsonSlurper as JsonSlurper
import com.kms.katalon.core.testobject.*
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import java.util.Map as Map
import java.util.HashMap as HashMap

ResponseObject response = GlobalVariable.RESPONSE

String[] string = response.getResponseBodyContent().split('[,\\r?\\n]')
int cantRegistros = string.length/3
//Calcular 1300000 lineas -> 28minutos

for (int i = 0;i<2400;i += 3) {

	CustomKeywords.'validaciones.ResponseValidation.ValidarCuit'(string[i])
	
	CustomKeywords.'validaciones.ResponseValidation.ValidarFecha'(string[i+1])
	
	CustomKeywords.'validaciones.ResponseValidation.ValidarFecha'(string[i+2])
}

if(cantRegistros > 0) {
	KeywordUtil.markPassed("Cantidad de registros: " + cantRegistros)
}else {
	KeywordUtil.markFailedAndStop("Se esperaba al menos un registro (linea). En total hay: " + cantRegistros)
}

//no descomentar
//KeywordUtil.markPassed(response.getResponseBodyContent().replace("\\r?\\n", "\n"))
