package com.company.openclose_ex;

import java.io.IOException;
import java.util.stream.Stream;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.company.singleresp_ex.dto.WorldTimeResponseDTO;

public class TimeApiTextClient {

	private static final String URL = "http://worldtimeapi.org/api/timezone/UTC.txt";

	private String getResponse(String url) {

		HttpGet get = new HttpGet(url);

		try (CloseableHttpClient httpClient = HttpClients.createDefault();
				CloseableHttpResponse timeResponse = httpClient.execute(get)) {

			return EntityUtils.toString(timeResponse.getEntity());

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	private WorldTimeResponseDTO parseResponse(String response) {

		WorldTimeResponseDTO timeResponseDTO = new WorldTimeResponseDTO();
		String lines[] = response.split("\n");
		Stream.of(lines).forEach(s -> parseFields(s, timeResponseDTO));
		return timeResponseDTO;
	}

	private void parseFields(String line, WorldTimeResponseDTO dto) {
		if (line.startsWith("datetime")) {
			dto.setDatetime(line.replace("datetime: ", ""));
		} else if (line.startsWith("unixtime")) {
			dto.setUnixtime(Long.valueOf((line.replace("unixtime: ", ""))));
		}
	}

	public long getCurrentUnixtimeUTC() {
		String response = getResponse(URL);
		if (response != null) {
			WorldTimeResponseDTO dto = parseResponse(response);
			if (dto != null) {
				return dto.getUnixtime();
			}
		}
		return 0;
	}

}
