package pruebas;



import com.learn.ws.mod.dao.DAOComentario;
import com.learn.ws.mod.dao.DAOLibro;
import com.learn.ws.rest.service.ServiceLibro;
import com.learn.ws.rest.vo.VOComentario;

public class p2 {

	public static void main(String[] args) throws Exception {
		
		/*
		DAOLibro dao = new DAOLibro();
		String lista=dao.obtenerLetra("a");
		System.out.println(lista);
		*/
		
		/*
		ServiceLibro li = new ServiceLibro();
		String a=li.Libro("Historia y Gramatica de la lengua de señas");
		System.out.println(a);
		*/
		
		DAOComentario comentario = new DAOComentario();
		String a = comentario.obtenerComen(2);
		System.out.println(a);
		
	}
	
}
