import com.kms.katalon.core.main.TestCaseMain
import com.kms.katalon.core.logging.KeywordLogger
import com.kms.katalon.core.testcase.TestCaseBinding
import com.kms.katalon.core.driver.internal.DriverCleanerCollector
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.configuration.RunConfiguration
import com.kms.katalon.core.webui.contribution.WebUiDriverCleaner
import com.kms.katalon.core.mobile.contribution.MobileDriverCleaner
import com.kms.katalon.core.cucumber.keyword.internal.CucumberDriverCleaner


DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.webui.contribution.WebUiDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.mobile.contribution.MobileDriverCleaner())
DriverCleanerCollector.getInstance().addDriverCleaner(new com.kms.katalon.core.cucumber.keyword.internal.CucumberDriverCleaner())


RunConfiguration.setExecutionSettingFile('C:\\Users\\VENKAT~1.ANN\\AppData\\Local\\Temp\\Katalon\\Test Cases\\FirstView\\FirstPayVault\\VPOS_1stPayVault_Search_Vault_By_Date_Retail\\20191101_093645\\execution.properties')

TestCaseMain.beforeStart()

        TestCaseMain.runTestCase('Test Cases/FirstView/FirstPayVault/VPOS_1stPayVault_Search_Vault_By_Date_Retail', new TestCaseBinding('Test Cases/FirstView/FirstPayVault/VPOS_1stPayVault_Search_Vault_By_Date_Retail',[:]), FailureHandling.STOP_ON_FAILURE , false)
    