package com.mygdx.conectarmysql;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Net;
import com.badlogic.gdx.Net.HttpRequest;
import com.badlogic.gdx.Net.HttpResponse;
import com.badlogic.gdx.Net.HttpResponseListener;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class conectarmysql extends ApplicationAdapter implements HttpResponseListener {
BitmapFont font;
SpriteBatch batch;	
	

String url, mensaje="Registrando Puntaje.. espere";
String httpMethod = Net.HttpMethods.GET;
String solicitud_variables = null;	
HttpRequest httpsolicitud;

	@Override
	public void create () {
			batch = new SpriteBatch();		
			font = new BitmapFont();
			
			
			url = "http://www.compartiendoconocimiento.com/pruebas/index.php?";
			solicitud_variables = "&nombre=asderss&puntaje=145";			
			httpsolicitud = new HttpRequest(httpMethod);
			httpsolicitud.setUrl(url);
			httpsolicitud.setContent(solicitud_variables);
			Gdx.net.sendHttpRequest(httpsolicitud, conectarmysql.this);		

			
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		
		batch.begin();
		font.draw(batch, mensaje, 10, 50);
		batch.end();
	}

	@Override
	public void handleHttpResponse(HttpResponse httpResponse) {
				
		Gdx.app.postRunnable(new Runnable() {
			@Override
			public void run () {
				mensaje= "HTTP Procesado con exito :D ";
			}
		});		
		
	}

	@Override
	public void failed(Throwable t) {

		
	}

	@Override
	public void cancelled() {

		
	}
}
