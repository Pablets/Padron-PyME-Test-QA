import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import static org.assertj.core.api.Assertions.*
import org.eclipse.jetty.client.api.Request as Request
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
import com.kms.katalon.core.testobject.*
import groovy.json.JsonSlurper as JsonSlurper
import com.kms.katalon.core.util.KeywordUtil as KeywordUtil
import com.kms.katalon.core.exception.StepFailedException as StepFailedException

ResponseObject response = GlobalVariable.RESPONSE

try {
    WS.verifyElementsCount(response, '', 4)
}
catch (StepFailedException e) {
    KeywordUtil.markFailedAndStop('Se esperaba un formato JSON con 4 propiedades')
} 

JsonSlurper parser = new JsonSlurper()

Map jsonResponse = parser.parseText(response.getResponseBodyContent())

//WS.comment(response.getResponseBodyContent())

if (jsonResponse.get('access_token') == null) {
    KeywordUtil.markFailedAndStop('No se encontro el campo \'access_token\' .')
}

if (jsonResponse.get('token_type') != 'Bearer') {
    KeywordUtil.markFailedAndStop('No se encontro el campo \'token_type\' O este dio un tipo de token distinto .')
}

if (jsonResponse.get('expires_in') == null) {
    KeywordUtil.markFailedAndStop('No se encontro el campo \'expires_in\' .')
}

if (jsonResponse.get('refresh_token') == null) {
    KeywordUtil.markFailedAndStop('No se encontro el campo \'refresh_token\' .')
}

GlobalVariable.TOKEN = jsonResponse.get('access_token').toString()

