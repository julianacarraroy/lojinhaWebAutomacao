package modulos.produtos;

import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import paginas.LoginPage;

import java.time.Duration;

@DisplayName("Testes Web do módulo de produtos")
public class Produtostest {


    private WebDriver navegador;

    @BeforeEach
    public void beforeEach() {
        //abrir o navegador - dentro de aspas duplas, o \\ representa \
        System.setProperty("webdriver.chrome.driver", "C:\\Driverbrowser\\chromedriver_win32\\chromedriver.exe");
        this.navegador = new ChromeDriver();

        //Vou maximizar a tela
        this.navegador.manage().window().maximize();

        //Vou definir um tempo de espera padrão de 5 segundos
        this.navegador.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        //Navegar para página da Lojinha Web
        this.navegador.get("http://165.227.93.41/lojinha-web/v2/");

    }

    @Test
    @DisplayName("Não é permitido registrar um produto com valor igual a zero")
    public void testNaoEPermitidoRegistrarProdutoComValorIgualAZero(){

        //Fazer login
        String mensagemApresentada = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormulariodeLogin()
                .acessaroFormularioDeAdicaoDeNovoProduto()
                .informarNomeDoProduto("Macbook Pro")
                .informarValorDoProduto("000")
                .informarCoresDoProduto("preto,branco")
                .submeterFormularioDeAdicaoComErro()
                .capturarMensagemApresentada();

        Assertions. assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentada);

    }

    @Test
    @DisplayName("Não é permitido registrar um produto com valor acima de 7 mil")
    public void testNaoEPermitidoRegistrarProdutoComValorAcimaDe7Mil () {

        String mensagemApresentada2 = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormulariodeLogin()
                .acessaroFormularioDeAdicaoDeNovoProduto()
                .informarNomeDoProduto("Macbook Pro")
                .informarValorDoProduto("700001")
                .informarCoresDoProduto("preto,branco")
                .submeterFormularioDeAdicaoComErro()
                .capturarMensagemApresentada();

        Assertions.assertEquals("O valor do produto deve estar entre R$ 0,01 e R$ 7.000,00", mensagemApresentada2);
    }

    @Test
    @DisplayName("Posso adicionar produtos que estejam na faixa de 0,01 e 7.000,00")
    public void testPossoAdicionarProdutosComValorDeUmCentavoASeteMilReais () {
        String mensagemApresentada = new LoginPage(navegador)
                .informarOUsuario("admin")
                .informarASenha("admin")
                .submeterFormulariodeLogin()
                .acessaroFormularioDeAdicaoDeNovoProduto()
                .informarNomeDoProduto("Macbook Pro")
                .informarValorDoProduto("700000")
                .informarCoresDoProduto("preto,branco")
                .submeterFormularioDeAdicaoComSucesso()
                .capturarMensagemApresentada();

        //Produto adicionado com sucesso
        Assertions.assertEquals("Produto adicionado com sucesso", mensagemApresentada);
    }


    @AfterEach
    public void afterEach () {
        //Vou fechar o navegador
        //navegador.quit();

        }

}
