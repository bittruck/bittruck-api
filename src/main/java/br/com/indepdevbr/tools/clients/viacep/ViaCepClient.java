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
	
	private final String URL_VIA_CEP = "http://viacep.com.br/ws/";
	private final String COMPLEMENTO_URL_VIA_CEP = "/json";	

	public EnderecoViaCep buscarPorCep(String cep) throws IOException {
		OkHttpClient client = new OkHttpClient.Builder()
//									.proxy(
//											new Proxy(Proxy.Type.HTTP, 
//													new InetSocketAddress("", 80)))
									.build();
		String url = URL_VIA_CEP + cep + COMPLEMENTO_URL_VIA_CEP;
		Request request = new Request.Builder()
									.url(url)
									.build();
		ResponseBody responseBody;
		try {
			responseBody  = client
					.newCall(request)
					.execute()
					.body();
			Gson gson = new Gson();
			EnderecoViaCep enderecoViaCep = gson.fromJson(new InputStreamReader(responseBody.byteStream()), EnderecoViaCep.class);
			return enderecoViaCep;
		} catch (IOException e) {
			throw e;
		}		
	}
	
}
