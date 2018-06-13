import booklet.Booklet;
import org.testng.Assert;
import org.testng.annotations.*;
//позволяет понять программе что происходит
// вид тестирования направленный на оценку корректности исходного кода программы
public class  TestiNG {
    // фиксация- методы, выполняющие подготовку к выполнению тестового метода и «уборку» после его выполнения.
    private Booklet bklt;

    // исполняются 1 раз до исполнения всех тестов
    @BeforeSuite
    public void testBeforeSuite() throws Exception {
        System.out.println("@BeforeSuite");
    }
//перед каждым тестом
    @BeforeTest
    public void testBeforeTest() throws Exception {
        System.out.println("@BeforeTest");
        bklt = new Booklet("BSTU", "Mishan", 2014, 13, 56);
    }

    //исполняются до первого теста принадлежащего к заданным группам
    @BeforeGroups
    public void testBeforeGroups() throws Exception {
        System.out.println("@BeforeGroups");
    }

    //метод будет выполнен после запуска тестового класса, но перед всеми тестовыми методами
    @BeforeClass
    public void testBeforeClass() throws Exception {
        System.out.println("@BeforeClass");
    }

    //будет выполняться перед каждым тестовым методом
    @BeforeMethod
    public void testBeforeMethod() throws Exception {
        System.out.println("@BeforeMethod");
    }

    //будет запускаться после всех методом тестового класса
    @AfterSuite
    public void testASuite() throws Exception {
        System.out.println("@AfterSuite");
    }
//запускается после каждого теста
    @AfterTest
    public void testATest() throws Exception {
        System.out.println("@AfterTest");
    }

    //будут выполняться после всех методом в любом из указанных групп
    @AfterGroups
    public void testAGroups() throws Exception {
        System.out.println("@AfterGroups");
    }


    //будет запущен после всех тестовых методов в текущем классе
    @AfterClass
    public void testAClass() throws Exception {
        System.out.println("@AfterClass");
    }


    //будет запускаться после каждого тестового метода
    @AfterMethod
    public void testAMethod() throws Exception {
        System.out.println("@AfterMethod");
    }


    // тест- метод выполнюящий проверку
    //класс assert проверяет правильность работы метода
    @Test(alwaysRun = false) //если установить в true, будет вызываться всегда независимо от того, к каким группам принадлежит
    public void testObject() throws Exception {
        try{
            if(bklt == null)
                throw new NullPointerException();
            Assert.assertEquals(bklt.getName(), "BSTU");//сравнивает 2 значение. проверка пройдена если значения равны
            Assert.assertEquals(bklt.getCost() , 56);
            System.out.println("@Test");
        }
        catch(NullPointerException e){
            System.out.println(e.getMessage());
        }
    }
//assertTrue()/assertFalse() проверяет, является ли переданный аргумент логически равным true.
//assertNull()/assertNotNull() проверяет, является ли переданный аргумент логически равным null
//assertSame()/assertNotSame() проверяет, ссылаются ли переданные аргументы на один и тот же объект
//assertArrayEquals()/ проверяет, являются ли массивы идентичными.

    //assert
    @Test(enabled = false) //можно временно отключить, установив значение в false//если тру то игнорируются
    public void ExTst() throws  Exception{
        Assert.fail();
    }

    //timeout ограничивает время проведения теста для определенного тестового метода
    @Test(timeOut = 1000)
    public void ignoredTest() throws InterruptedException {
//        Thread.sleep(20000);
        System.out.println("Time is out");
    }

    //groups
    @Test(groups = {"Group", "Group2"})
    public void test1Group(){
        System.out.println("method 1 test in groups");
    }
    @Test(groups = {"Group"})
    public void test2Group(){
        System.out.println("method 1 test in group");
    }
    @Test(groups = "Group2")
    public void testGroup(){
        System.out.println("method 2 test in group");
    }

    @Test
    public void testZach() throws Exception{
        bklt.setName("BSU");
        Assert.assertEquals("BSU",bklt.getName());
    }

}
