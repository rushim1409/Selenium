package Utility;

import java.util.Base64;

public class decodeUtility {

	public static String decodeSensitiveData(String encodeData) {
		byte[] decodeBytes = Base64.getDecoder().decode(encodeData.getBytes());
		return new String(decodeBytes);
	}
}
