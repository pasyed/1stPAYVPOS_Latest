import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import org.openqa.selenium.WebElement as WebElement
import org.testng.Assert as Assert
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.common.WebUiCommonHelper as WebUiCommonHelper
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

/**
 *
 * Implemented By ZenQ
 * Tested on Chrome Version 76.0.3809.100
 * Tested on Firefox Version 68.0,70.0
 *
 *
 */
CustomKeywords.'utilities.SafeActions.openBrowser'(GlobalVariable.URL, (([GlobalVariable.delayForElement]) as int[]))

CustomKeywords.'pages.Login.login'(uName, password)

WebUI.callTestCase(findTestCase('FirstView/Login/TC_SendCode'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.callTestCase(findTestCase('FirstView/Login/TC_FirstView'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.switchToWindowTitle('Transcenter - VPOS')

WebUI.delay(GlobalVariable.delayForElement)

CustomKeywords.'pages.Sale.verifyIfEntryModeIsChecked'(tabName, entryModeCheckBox, GlobalVariable.delayBetweenTestSteps)

//CustomKeywords.'pages.Sale.verify1stPayVposPage'(findTestObject('Pages/Sale/img_1stPayVPOS'))
'Scroll down to Element inputAmount'
WebUI.scrollToElement(findTestObject('Pages/Sale/input_Amount'), GlobalVariable.delayBetweenTestSteps)

CustomKeywords.'utilities.SafeActions.safeTypeUsingJavascript'(findTestObject('Pages/Sale/input_Amount'), amountInput)

WebUI.delay(2)

CustomKeywords.'utilities.SafeActions.safeType'(findTestObject('Pages/Sale/input_Amount'), amountInput, 'Amount field', 
        (([GlobalVariable.delayForElement]) as int[]))

WebUI.scrollToElement(findTestObject('Pages/Sale/dropDown_ExpirationMonth'), GlobalVariable.delayBetweenTestSteps)

total_Amount = CustomKeywords.'utilities.SafeActions.safeGetText'(findTestObject('Pages/Sale/total_Amount'), GlobalVariable.delayBetweenTestSteps)

println(total_Amount)

CustomKeywords.'pages.Sale.verifyIfEntryModeIsChecked'(tabName, cardInformationCheckBox, GlobalVariable.delayBetweenTestSteps)

CustomKeywords.'utilities.SafeActions.safeType'(findTestObject('Pages/Sale/input_CardNumber'), GlobalVariable.visaCardNumber, 
    'Entering Card Number', (([GlobalVariable.delayBetweenTestSteps]) as int[]))

/*CustomKeywords.'utilities.SafeActions.safeSelectOptionInDropDownByVisibleText'(findTestObject('Pages/Sale/dropDown_ExpirationMonth'), 
    'May', 'Selecting Month', (([10]) as int[]))*/
WebUI.delay(GlobalVariable.delayBetweenTestSteps)

CustomKeywords.'utilities.SafeActions.safeSelectOptionInDropDownByVisibleText'(findTestObject('Pages/Sale/dropDown_ExpirationMonth'), 
    cardMonth, 'Enter Month', (([GlobalVariable.delayBetweenTestSteps]) as int[]))

CustomKeywords.'utilities.SafeActions.safeSelectOptionInDropDownByVisibleText'(findTestObject('Pages/Sale/dropDown_ExpirationYear'), 
    cardYear, 'Select Expiration Year', (([GlobalVariable.delayBetweenTestSteps]) as int[]))

CustomKeywords.'utilities.SafeActions.safeClickWithoutScrollOnLabel'(findTestObject('Pages/Sale/label_ExpirationYear'), 
    'Click on Exp Year label', (([GlobalVariable.PageLoadTime]) as int[]))

//CustomKeywords.'utilities.SafeActions.selectSeleniumCode'(findTestObject('Pages/Sale/dropDown_ExpirationMonth'), 'September')
//WebElement ele=WebUiCommonHelper.findWebElement(findTestObject('Pages/Sale/dropDown_ExpirationMonth'), 60)
//WebUI.executeJavaScript("arguments[0].className=arguments[1]",ele,"form-control parsley-success")
//WebUI.executeJavaScript("document.getElementById('select-expiration-month').className='form-control parsley-success'", null)
//CustomKeywords.'utilities.SafeActions.selectSeleniumCodeYear'(findTestObject('Pages/Sale/dropDown_ExpirationYear'), '2022')
WebUI.delay(GlobalVariable.delayBetweenTestSteps)

WebUI.scrollToElement(findTestObject('Pages/Sale/invoiceNumber'), GlobalVariable.delayBetweenTestSteps)

invoiceNumber = CustomKeywords.'utilities.SafeActions.safeGetText'(findTestObject('Pages/Sale/invoiceNumber'), GlobalVariable.delayBetweenTestSteps)

println(invoiceNumber)

//WebUI.executeJavaScript("document.getElementById('select-expiration-year').className='form-control parsley-success'", null)
/*CustomKeywords.'utilities.SafeActions.selectSeleniumCode'(findTestObject('Pages/Sale/dropDown_ExpirationMonth'), 'December')

WebUI.delay(4)*/
/*CustomKeywords.'utilities.SafeActions.safeSelectOptionInDropDownByVisibleText'(findTestObject('Pages/Sale/dropDown_ExpirationMonth'), 
    'December', 'Select by Value', (([20]) as int[]))*/
/*CustomKeywords.'utilities.SafeActions.safeClickWithoutScrollOnLabel'(findTestObject('Pages/Sale/label_ExpirationYear'), 
    'Click on Label', (([20]) as int[]))

CustomKeywords.'utilities.SafeActions.selectSeleniumCode'(findTestObject('Pages/Sale/dropDown_ExpirationMonth'), 'March')

WebUI.delay(4)

CustomKeywords.'utilities.SafeActions.selectSeleniumCode'(findTestObject('Pages/Sale/dropDown_ExpirationYear'), '2035')

WebUI.delay(4)

CustomKeywords.'utilities.SafeActions.selectSeleniumCode'(findTestObject('Pages/Sale/dropDown_ExpirationYear'), '2025')*/
CustomKeywords.'utilities.SafeActions.safeClickwithScroll'(findTestObject('Pages/Sale/button_Checkout'), 'Click on Checkout button', 
        (([GlobalVariable.delayBetweenTestSteps]) as int[]))

CustomKeywords.'pages.Sale.verifyTransactionCompletePage'(findTestObject('Pages/Sale/heading_TransactionComplete'))

transactionCompleteMessage = CustomKeywords.'utilities.SafeActions.safeGetText'(findTestObject('Pages/ForceTransactions/approved_TransactionMessage_TransactionComplete_Screen'), 
    GlobalVariable.delayForElement)

println(transactionCompleteMessage)

CustomKeywords.'pages.Force_Transaction.verifyStrings'(transactionCompleteMessage)

WebUI.delay(GlobalVariable.delayBetweenTestSteps)

CustomKeywords.'utilities.SafeActions.safeClickWithoutScroll'(findTestObject('Pages/Sale/button_ReturnToSale'), 'Click on Return To Sale', 
        (([GlobalVariable.delayBetweenTestSteps]) as int[]))

CustomKeywords.'utilities.SafeActions.safeClickWithoutScroll'(findTestObject('Pages/Transaction_Management/tab_TransactionManagement'), 
    'Transaction Management Tab', (([GlobalVariable.delayBetweenTestSteps]) as int[]))

CustomKeywords.'utilities.SafeActions.safeClickwithScroll'(findTestObject('Pages/Transaction_Management/button_Search'), 
    'Search', (([GlobalVariable.delayBetweenTestSteps]) as int[]))

WebUI.scrollToElement(findTestObject('Pages/Transaction_Management/invoice_ForTransaction'), GlobalVariable.delayBetweenTestSteps)

/*invoiceFromTable = CustomKeywords.'utilities.SafeActions.safeGetText'(findTestObject('Pages/Transaction_Management/invoice_ForTransaction'), 
    10)

Assert.assertEquals(invoiceFromTable.trim(), invoiceNumber.trim())*/
CustomKeywords.'pages.Transaction_Management.verifyInvoiceRecord'(findTestObject('Pages/Transaction_Management/footer_NextButton'), 
    findTestObject('Pages/Transaction_Management/page_Number'), invoiceNumber, total_Amount)

WebUI.closeBrowser()

