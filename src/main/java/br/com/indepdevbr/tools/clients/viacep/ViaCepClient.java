package br.com.indepdevbr.tools.clients.viacep;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.net.Proxy;

import com.google.gson.Gson;

import br.com.indepdevbr.tools.clients.viacep.domain.EnderecoViaCep;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;

public class ViaCepClient {
	
	public static void main(String[] args) throws IOException {
		
		OkHttpClient client = new OkHttpClient.Builder()
									.proxy(new Proxy(Proxy.Type.HTTP, new InetSocketAddress("vbr008002-029.bbmapfre.corp", 80)))
									.build();
		Request request = new Request.Builder()
								.url("http://viacep.com.br/ws/01001000/json/")
								.build();
		ResponseBody response = client.newCall(request).execute().body();		
		Gson gson = new Gson();
		EnderecoViaCep endereco = gson.fromJson(new InputStreamReader(response.byteStream()), EnderecoViaCep.class);
		System.out.println(endereco);
	}
	

	
}
