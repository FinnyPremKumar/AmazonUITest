package Utils;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtils {
	public static Object[][] getScenariosData(String filePath, String sheetName, String ScenarioName){
		List<Map<String, String>> matchingRows = new ArrayList<>();
		try (FileInputStream fis=new FileInputStream(filePath)) {
			Workbook workbook = WorkbookFactory.create(fis);
			Sheet sheet=workbook.getSheet(sheetName);
			Row headerRow=sheet.getRow(0);
			int lastCellNum=headerRow.getLastCellNum();
			int lastRowNum = sheet.getLastRowNum();
			int scenarioColIndex = -1;
			for(int i=0;i<lastCellNum;i++) {
				if(headerRow.getCell(i).getStringCellValue().equalsIgnoreCase("Scenario Name")) {
					scenarioColIndex=i;
					break;
				}
				
			}
			if (scenarioColIndex == -1) {
	            throw new RuntimeException("Column 'Scenario' not found in Excel sheet!");
	        }
			for (int i = 1; i <= lastRowNum; i++) {
	            Row row = sheet.getRow(i);
	            if (row == null) continue;

	            // Get the value from the dynamic Scenario column index
	            DataFormatter formatter = new DataFormatter();
	            String currentScenarioValue = formatter.formatCellValue(row.getCell(scenarioColIndex));

	            // Compare and collect if it matches
	            if (currentScenarioValue.equalsIgnoreCase(ScenarioName)) {
	                Map<String, String> datamap = new HashMap<>();
	                for (int j = 0; j < lastCellNum; j++) {
	                    String key = headerRow.getCell(j).getStringCellValue();
	                    String value = formatter.formatCellValue(row.getCell(j));
	                    datamap.put(key, value);
	                }
	                matchingRows.add(datamap);
	            }
	        }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		// 3. Convert matches to Object[][] for DataProvider
	    Object[][] data = new Object[matchingRows.size()][1];
	    for (int i = 0; i < matchingRows.size(); i++) {
	        data[i][0] = matchingRows.get(i);
	    }
	    return data;
	}

}
