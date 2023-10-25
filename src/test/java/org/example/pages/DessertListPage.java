//package org.example.pages;
//
//import org.example.models.Dessert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class DessertListPage extends BasePage {
//    private WebElement table;
//    private List<WebElement> headers;
//    private List<WebElement> dataRows;
//
//    public DessertListPage(WebDriver driver){
//        super(driver);
//
//        table = driver.findElement(By.cssSelector("[aria-label='simple table']"));
//        dataRows  = driver.findElements(By.cssSelector("[aria-label='simple table'] tbody tr"));
//    }
//
//    private List<String> getColumnNames(){
//        List<String> columns = new ArrayList<String>();
//        for (WebElement headerElement: headers) {
//            columns.add(headerElement.getText());
//        }
//        return columns;
//    }
//
//    public List<Dessert> getDesserts(){
//        List<Dessert> desserts = new ArrayList<Dessert>();
//        for (WebElement dataRow: dataRows) {
//            List<String> values = getValuesFromRow(dataRow);
//
//            desserts.add(new Dessert(values.get(0),
//                    Integer.parseInt(values.get(1)),
//                    Float.parseFloat(values.get(2)),
//                    Float.parseFloat(values.get(3)),
//                    Float.parseFloat(values.get(4))));
//        }
//        return desserts;
//    }
//
//    private List<String> getValuesFromRow(WebElement row){
//        List<WebElement> dataElems = row.findElements(By.cssSelector("*"));
//        List<String> values = new ArrayList<>();
//        for (WebElement dataElem: dataElems
//        ) {
//            values.add(dataElem.getText());
//        }
//        return values;
//    }
//}
