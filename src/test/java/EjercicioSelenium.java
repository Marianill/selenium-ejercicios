import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by Marisel Villalovos on 28/08/2021
 */
public class EjercicioSelenium {
    @Test
    public void ejercicio1(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
    }

    @Test
    public void mostrarTituloTest(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");
        System.out.println("Título de la página: " + driver.getTitle());
    }

    @Test
    public void bbcMundoTest(){
        String  URL_BBC_MUNDO = "https://www.bbc.com/mundo";
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(URL_BBC_MUNDO);

        List<WebElement> listH1 = driver.findElements(By.tagName("h1"));
        System.out.println("Cantidad de H1 del sitio BBC: " + listH1.size());
        System.out.println("********Títulos H1s*******");
        for(WebElement elementoH1: listH1) {
            System.out.println((listH1.indexOf(elementoH1) + 1) + "° elemento H1: " + elementoH1.getText());
        }
        System.out.println("***************************");

        List<WebElement> listH2 = driver.findElements(By.tagName("h2"));
        System.out.println("Cantidad de H2 del sitio BBC: " + listH2.size());
        System.out.println("********Títulos H2s*******");
        for(WebElement elementoH2: listH2) {
            System.out.println((listH2.indexOf(elementoH2) + 1) + "° elemento H2: " + elementoH2.getText());
        }
        System.out.println("**************************");

        driver.close();
    }

    @Test
    public void bbcMundoLinks(){
        String  URL_BBC_MUNDO = "https://www.bbc.com/mundo";
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(URL_BBC_MUNDO);

        List<WebElement> listLinks = driver.findElements(By.tagName("a"));
        System.out.println("********Links*******");
        for(WebElement elementoA: listLinks) {
            if(elementoA.getText().isEmpty() == false) {
                System.out.println((listLinks.indexOf(elementoA) + 1) + "° link: " + elementoA.getText());
            }
        }
        System.out.println("***************************");

        driver.close();
    }

    @Test
    public void bbcMundoListas(){
        String  URL_BBC_MUNDO = "https://www.bbc.com/mundo";
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(URL_BBC_MUNDO);

        List<WebElement> listListas = driver.findElements(By.tagName("li"));
        System.out.println("********Listas*******");
        for(WebElement elementoLi: listListas) {
            if(elementoLi.getText().isEmpty() == false) {
                System.out.println((listListas.indexOf(elementoLi) + 1) + "° elemento lista: " + elementoLi.getText());
            }
        }
        System.out.println("***************************");

        driver.close();
    }

    @Test
    public void spotifyTitleTest(){
        String  URL_BBC_MUNDO = "https://spotify.com";
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(URL_BBC_MUNDO);

        String title = driver.getTitle();
        if(title == "Escuchar es todo - Spotify"){
            System.out.println("Test Passed!!");
        }else{
            System.out.println("Test failed");
        }

        driver.close();
    }

    @Test
    public void getWindowsSizeTest(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        int anchoPantalla = driver.manage().window().getSize().width;
        int altoPantalla = driver.manage().window().getSize().height;
        System.out.println("Ancho de la pantalla: " + anchoPantalla + "px");
        System.out.println("Alto de la pantalla: " + altoPantalla + "px");

        //Setear nuevas dimensiones de 1024 x 768
        driver.manage().window().setSize(new Dimension(1024,768));

        driver.close();
    }

    @Test
    public WebDriver getGoogleDriver(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        return driver;
    }

    @Test
    public WebDriver getDriver(String url){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        return driver;
    }

    @Test
    public void searchInGoogle(){
        WebDriver driver = getGoogleDriver();
        driver.findElement(By.name("q")).click();
        driver.findElement(By.name("q")).sendKeys("WebElement");
        driver.findElement(By.name("q")).submit();

        driver.close();
    }

    @Test
    public void searchInGoogleAndGoBack(){
        WebDriver driver = getGoogleDriver();
        System.out.println("Título de la página: " + driver.getTitle());
        driver.findElement(By.name("q")).click();
        driver.findElement(By.name("q")).sendKeys("WebElement");
        driver.findElement(By.name("q")).submit();
        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();

        driver.close();
    }

    @Test
    public void facebookPageTest(){
        WebDriver driver = getDriver("https://www.facebook.com");

        List<WebElement> listDivs = driver.findElements(By.tagName("div"));
        System.out.println("Cantidad de DIV del sitio Facebook: " + listDivs.size());
        System.out.println("***************************");

        List<WebElement> listLinks = driver.findElements(By.tagName("a"));
        System.out.println("********Links*******");
        for(WebElement elementoA: listLinks) {
            if(elementoA.getText().isEmpty() == false) {
                System.out.println("link: " + elementoA.getText());
            }
        }
        System.out.println("***************************");

        List<WebElement> listButtons = driver.findElements(By.tagName("button"));
        System.out.println("Cantidad de Botones del sitio Facebook: " + listButtons.size());
        System.out.println("********Botones*******");
        for(WebElement elementoButton: listButtons) {
            if(elementoButton.getText().isEmpty() == false) {
                System.out.println((listButtons.indexOf(elementoButton) + 1) + "° button: " + elementoButton.getText());
            }
        }
        System.out.println("***************************");

        driver.close();
    }

    @Test
    public void sendKeysToFacebook(){
        WebDriver driver = getDriver("https://www.facebook.com");
        driver.findElement(By.name("email")).click();
        driver.findElement(By.name("email")).sendKeys("test@test.com");
        driver.findElement(By.name("pass")).click();
        driver.findElement(By.name("pass")).sendKeys("holamundo");
        driver.findElement(By.name("login")).submit();

        //driver.close();
    }

    @Test
    public void mostrarNetflix(){
        String  URL_NETFLIX = "https://www.netflix.com/ar/";
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(URL_NETFLIX);

        List<WebElement> listH1 = driver.findElements(By.tagName("h1"));
        System.out.println("********Títulos H1s*******");
        for(WebElement elementoH1: listH1) {
            if(elementoH1.getText().isEmpty() == false) {
                System.out.println((listH1.indexOf(elementoH1) + 1) + "° elemento H1: " + elementoH1.getText());
            }
        }
        System.out.println("***************************");

        List<WebElement> listH2 = driver.findElements(By.tagName("h2"));
        System.out.println("********Títulos H2s*******");
        for(WebElement elementoH2: listH2) {
            if(elementoH2.getText().isEmpty() == false) {
                System.out.println((listH2.indexOf(elementoH2) + 1) + "° elemento H2: " + elementoH2.getText());
            }
        }
        System.out.println("**************************");

        driver.navigate().refresh();

        List<WebElement> listButtons = driver.findElements(By.tagName("button"));
        System.out.println("********Botones*******");
        for(WebElement elementoButton: listButtons) {
            if(elementoButton.getText().isEmpty() == false) {
                System.out.println((listButtons.indexOf(elementoButton) + 1) + "° button: " + elementoButton.getText());
            }
        }
        System.out.println("***************************");

        List<WebElement> listDivs = driver.findElements(By.tagName("div"));
        System.out.println("Cantidad de elementos DIV del sitio Netflix: " + listDivs.size());
        System.out.println("***************************");

        System.out.println("Título de la página: " + driver.getTitle());
        System.out.println("***************************");

        List<WebElement> listLinks = driver.findElements(By.tagName("a"));
        System.out.println("Cantidad de elementos links del sitio Netflix: " + listLinks.size());

        driver.close();
    }
}
