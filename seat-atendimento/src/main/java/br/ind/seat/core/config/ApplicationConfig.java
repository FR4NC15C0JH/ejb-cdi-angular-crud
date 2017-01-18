package br.ind.seat.core.config;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 *	Classe responsável por ativar o contexto do RestEasy
 */
@ApplicationPath("rest")
public class ApplicationConfig extends Application {
	
	/**
	 * @author cledson.alves
	 *	
	 *	Método responsável por adicionar parametros de contexto
	 */
	@Override
	public Map<String, Object> getProperties() {
		Map<String, Object> properties = new HashMap<>();
		properties.put("resteasy.scan", true);
		properties.put("resteasy.scan.providers", true); 
        return properties;
    }
}
