package br.com.indepdevbr.tools.clients.viacep;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;

import br.com.indepdevbr.tools.clients.viacep.domain.EnderecoViaCep;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;

@Component
public class ViaCepClient {
	
	private final String URL_VIA_CEP = "http://viacep.com.br/ws/";
	private final String COMPLEMENTO_URL_VIA_CEP = "/json";	

	public List<EnderecoViaCep> buscarPorCep(String cep) throws IOException {
		OkHttpClient client = new OkHttpClient.Builder()
									.proxy(
											new Proxy(Proxy.Type.HTTP, 
													new InetSocketAddress("vbr008002-029.bbmapfre.corp", 80)))
									.build();
		String url = String.format("%s%s%s",URL_VIA_CEP,cep,COMPLEMENTO_URL_VIA_CEP);
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
			String json = responseBody.string();
			List<EnderecoViaCep> enderecos;
			if(json.contains("[")) {
				EnderecoViaCep[] enderecosViaCep = gson.fromJson(json, EnderecoViaCep[].class);
				enderecos = new ArrayList<>();
				for(EnderecoViaCep enderecoViaCep: enderecosViaCep)
					enderecos.add(enderecoViaCep);
			} else {
				EnderecoViaCep enderecoViaCep = gson.fromJson(json, EnderecoViaCep.class);
				enderecos = Arrays.asList(enderecoViaCep);
			}
			return enderecos;
		} catch (IOException e) {
			throw e;
		}		
	}
	
	public List<EnderecoViaCep> buscarCepPorEndereco(String uf, String localidade, String logradouro) throws IOException  {
		OkHttpClient client = new OkHttpClient.Builder()
//				.proxy(
//						new Proxy(Proxy.Type.HTTP, 
//								new InetSocketAddress("", 80)))
									.build();
		String url = String.format("%s%s/%s/%s%s", 
									URL_VIA_CEP, 
									uf, 
									localidade, 
									logradouro, 
									COMPLEMENTO_URL_VIA_CEP);
		Request request= new Request.Builder()
									.url(url)
									.build();
		ResponseBody responseBody;
		try {
			responseBody = client
							.newCall(request)
							.execute()
							.body();
			Gson gson = new Gson();
			String json = responseBody.string();
			EnderecoViaCep[] enderecos = gson.fromJson(json, EnderecoViaCep[].class);
			if(enderecos.length > 0) {
				List<EnderecoViaCep> enderecoViaCepList = new ArrayList<>();
				for(EnderecoViaCep enderecoViaCepIterable: enderecos)
					enderecoViaCepList.add(enderecoViaCepIterable);
				return enderecoViaCepList;
			} else {
				return new ArrayList<>();
			}
		} catch (IOException e) {
			throw e;
		}
	}
	
}
