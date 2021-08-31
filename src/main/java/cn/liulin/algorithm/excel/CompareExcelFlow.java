package cn.liulin.algorithm.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * cn.liulin.algorithm.excel$
 *
 * @author ll
 * @date 2021-07-30 14:44:07
 **/
public class CompareExcelFlow {
    public static void main(String[] args) throws Exception {
        Map<String, BigDecimal> mapByFilePath1 = getMapByFilePath("D:\\compare1.xlsx");
        Map<String, BigDecimal> mapByFilePath2 = getMapByFilePath("D:\\compare2.xlsx");

        for (String key : mapByFilePath1.keySet()) {
            BigDecimal value1 = mapByFilePath1.get(key);
//            BigDecimal value2 = mapByFilePath2.get(key).multiply(new BigDecimal("1024")).setScale(0, BigDecimal.ROUND_HALF_UP);
            BigDecimal value2 = mapByFilePath2.get(key);
            if (value1 != null && value2 != null) {
                if (value1.compareTo(value2) > 0) {
                    System.out.println(value2 + ":" + key);
                }
            }
        }
    }

    private static Map<String, BigDecimal> getMapByFilePath(String path) throws Exception {
        InputStream is = new FileInputStream(path);
        Workbook wb = new XSSFWorkbook(is);
        Sheet sheet=wb.getSheetAt(0);
        int rowNum=sheet.getLastRowNum();//读取行数(从0计数)
        Map<String, BigDecimal> compareMap1 = new HashMap<>(rowNum);
        for(int i=0;i<=rowNum;i++){
            //获得行
            Row row=sheet.getRow(i);
            //获得当前行的列数
            int colNum=row.getLastCellNum();
            Cell key = row.getCell(0);
            Cell value = row.getCell(1);
            if (key != null && value != null) {
                try {
                    String s = value.toString().replaceAll(" ", "");
                    compareMap1.put(key.toString(), new BigDecimal(Double.valueOf(s).toString()));
                } catch (Exception e) {
                    System.out.println(key + ":" + value);
                    System.exit(0);
                    throw new Exception();
                }

            }
        }
        return compareMap1;
    }
}
