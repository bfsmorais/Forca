package jogodaforca;

import java.util.Random;
import java.util.Scanner;

import javax.swing.text.StyledEditorKit.BoldAction;

public class Hangman {


static String palavraAdivinhar;
static String sLetraATestar;
static String sLetrasUsadasCorrectamente;
static String sTodasLetrasUsadas;
static int iVidas;
static int iLetrasCertas;
static int iNumeroJogada;
public static void main(String[] args) 
{

String[] palavras = new String[] //{"teste"};
{"porto", "benfica", "sporting", "portugal", "europa", "gato", "tartaruga", "chave", "esfera", "cadeira",
      "ficha", "chefe", "empregado", "rosa", "papoila", "saco", "porta", "natal", "indiscutivelmente",
       "universalidades", "constitucionalmente"};
sLetraATestar="";
sLetrasUsadasCorrectamente = "";
iVidas = 6;
iLetrasCertas = 0;
iNumeroJogada = 0;
sTodasLetrasUsadas = "";
//---------------------------------------------------PALAVRA TIRAR A SORTE---------------------------------------------------------------*/
        
       Random aleatorio = new Random();
       palavraAdivinhar = palavras[aleatorio.nextInt(palavras.length)];
//--------------------------------------------CONTAR O NUMERO DE PALAVRAS--------------------------------------------------------
        
       
        int tamanhoDaPalavra = palavraAdivinhar.length();
        
        System.out.println("O tamanho da palavra é de " + tamanhoDaPalavra + " caracteres...");
actualizarTfForca();

do 
{
novajogada();
iNumeroJogada = iNumeroJogada + 1;
actualizarTfForca();
} while (iVidas >= 1);

if (iVidas == 0) 
{
 Perdeu();
 
}
}
      //--------------------------------------------PALAVRAS--------------------------------------------------------
      


/**
* 
*/
protected static void actualizarTfForca() 
    {  
    String s = "";
    Boolean bLetraEncontrada = false;
    String sLetraEncontrada = "";
   
    for(int i = 0; i < palavraAdivinhar.length(); i++)
    {
    char letra = palavraAdivinhar.charAt(i);
    if(sLetraATestar.equals(letra+""))
    {
    s = s + letra +" ";
    iLetrasCertas = iLetrasCertas +1;
    bLetraEncontrada = true;
    sLetraEncontrada = letra + "";
    VerificarSeGanhou();
    }
    else
    {    
    Boolean bLetraEncontrada2 = false;
    for(int k = 0; k < sLetrasUsadasCorrectamente.length(); k++)
        {
       
    if(sLetrasUsadasCorrectamente.charAt(k)==letra)
        {
        s = s + letra +" ";
        bLetraEncontrada2 = true;
        break;
        }
      
        }
   
    if (bLetraEncontrada2 == false)
    {
    s = s + "_ ";
    }
        
    }
   
    }
    if (bLetraEncontrada == false) 
    {
    if (iNumeroJogada == 0)
{
    System.out.println("Tem " + iVidas + " Vidas.");
}
    else 
    {
    iVidas = iVidas -1;
    if (iVidas > 0)
{
    System.out.println("Não acertou, ainda tem mais " + iVidas + " Vidas.");
}
    else 
    {
    System.out.println("Não acertou,e já não tem mais vidas.");
}
       
}
   
}
    else 
    {
    sLetrasUsadasCorrectamente = sLetrasUsadasCorrectamente + sLetraEncontrada;
}
   
    System.out.println(s);
   
   
    }
        
        private static void VerificarSeGanhou() 
        {
if (palavraAdivinhar.length() == iLetrasCertas) 
{
System.out.println("Muitos Parabens, acertou correctamente na palavra ("+palavraAdivinhar+")");
System.out.println("Quer Jogar novamente? (1-Sim, 2 ou qualquer outro caracter-Não)");
        
Scanner leia = new Scanner(System.in);
       
String Opcao = leia.nextLine();
       
if (Opcao.equals("1")) 
       
{
       
System.out.println("");
       
System.out.println("");
       
System.out.println("");
       
main(null);
}
       
else 
       
{
       
System.exit(0);
}
}
}
        
        private static void Perdeu() 
        {
        System.out.println("Perdeu, a palavra era " + palavraAdivinhar);
        System.out.println("Quer Jogar novamente? (1-Sim, 2 ou qualquer outro caracter-Não)");
        
Scanner leia = new Scanner(System.in);
        String Opcao = leia.nextLine();
        if (Opcao.equals("1")) 
        {
        System.out.println("");
        System.out.println("");
        System.out.println("");
        main(null);
}
        else 
        {
        System.exit(0);
}
   }

protected static void novajogada() 
        {
        int iIndiceTodasAsLetras = -1;
       
System.out.println("introduza uma letra:");
        Scanner leia = new Scanner(System.in);
        sLetraATestar = leia.nextLine();
       
        if (sLetraATestar.length() > 1) 
        {
        System.out.println("Erro, Mais do que um caracter intruduzido...");
        novajogada();
}
        if (sTodasLetrasUsadas.length() > 0)
{
        iIndiceTodasAsLetras = sTodasLetrasUsadas.indexOf(sLetraATestar.charAt(0));
}
       
       
        if (iIndiceTodasAsLetras >= 0) 
        {
        System.out.println("Erro, caracter ja testado...");
        novajogada();
}
              
        sTodasLetrasUsadas = sTodasLetrasUsadas + sLetraATestar;
       
        }
        
        
}