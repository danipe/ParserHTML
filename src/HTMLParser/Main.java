package HTMLParser;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Main {

	public static void main(String[] args) {
		
		//Creamos un objeto Document al cual le asociamos el html de la pagina principal de PCComponentes
		
		Document htmlFile = null;
		try {
			htmlFile = Jsoup.connect("https://www.pccomponentes.com").get();
		} catch (IOException e) {
			e.printStackTrace();
		} 

		
		/*
		 * Guardamos el array de productos guiandonos por diferentes divs y fijandonos en sus clases. En este caso cada div con clase "article-block" está
		 * dentro de un div con clase "row" que a su vez lo podemos encontrar en el contenedor "listado-articulos"
		 */
		Elements productos = htmlFile.getElementsByClass("listado-articulos").get(0).getElementsByClass("row").get(0).getElementsByClass("article-block");

		/*
		 * Hacemos un foreach para sacar el nombre del producto y su precio 
		 */
		
		for(Element producto: productos) {
			System.out.println("Producto: "+producto.getElementsByClass("enlace-disimulado").text());
			System.out.println("Precio:\t\t"+producto.getElementsByClass("tarjeta-articulo__precio-actual").text());
			System.out.println("");
		}
		
	}

}
