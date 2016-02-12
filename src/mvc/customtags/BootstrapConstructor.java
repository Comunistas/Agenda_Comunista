package mvc.customtags;

import java.util.ArrayList;

public abstract class BootstrapConstructor {

	/*
	 *  Contenedores
	 */
	public String div(String s){
		return div("",s);
	}
	
	public String div(String clase, String s){
		return "<div class=\""+clase+"\">"+s+"<div>";
	}
	
	
	public <E> String table(ArrayList<String> encabezados, ArrayList<E> contenido, int columnas){
		return table("", "", encabezados, contenido, columnas);
	}
	
	public <E> String table(String claseTabla, ArrayList<String> encabezados, ArrayList<E> contenido, int columnas){
		return table(claseTabla, "", encabezados, contenido, columnas);
	}
	
	public <E> String table(String claseTabla, String claseEncabezado, 
			ArrayList<String> encabezados, ArrayList<E> contenido, 
			int columnas){
		
		StringBuffer textoFinal = new StringBuffer("<table class=\""+claseTabla+"\">\n\t");
		
		
		//Encabezados
		textoFinal.append("<tr class=\""+claseEncabezado+"\">");
		
		encabezados.stream().forEach(s -> textoFinal.append("<td>"+s+"</td>"));
		
		textoFinal.append("</tr>");
		
		
		//Contenido
		int c = 0;
		int i = 0;
		while(c<columnas){
			
			if(i<contenido.size()==false){
				
				
				if(c==0)
					textoFinal.append("<tr>");
				
				textoFinal.append("<td>"+contenido.get(i)+"</td>");
				
				if(c==columnas-1){
					textoFinal.append("</tr>");
					c=0;
				}else
					c++;
				
				i++;
				
				
				
			}else{
				c = columnas;
			}
		}
		
		textoFinal.append("\n</table>");
		
		return textoFinal.toString();
		
	}
	
	
	public String img(String src){
		return img("",src);
	}
	
	public String img(String clase, String src){
		return "<img class=\""+clase+"\" src=\""+src+"\"/>";
	}
	
	
	
	/* 
	 *  Texto
	 */
	
	public String h1(String s){
		return h1("",s);
	}
	public String h1(String clase, String s){
		return "<h1 class=\""+clase+"\">"+s+"<h1>";
	}
	
	public String h2(String s){
		return h2("",s);
	}
	public String h2(String clase, String s){
		return "<h2 class=\""+clase+"\">"+s+"<h2>";
	}
	
	public String h3(String s){
		return h3("",s);
	}
	public String h3(String clase, String s){
		return "<h3 class=\""+clase+"\">"+s+"<h3>";
	}
	
	public String h4(String s){
		return h4("",s);
	}
	public String h4(String clase, String s){
		return "<h4 class=\""+clase+"\">"+s+"<h4>";
	}
	
	public String h5(String s){
		return h5("",s);
	}
	public String h5(String clase, String s){
		return "<h5 class=\""+clase+"\">"+s+"<h5>";
	}
	
	public String h6(String s){
		return h6("",s);
	}
	public String h6(String clase, String s){
		return "<h6 class=\""+clase+"\">"+s+"<h6>";
	}
	
	public String p(String s){
		return p("",s);
	}
	public String p(String clase, String s){
		return "<p class=\""+clase+"\">"+s+"<p>";
	}
	
}
