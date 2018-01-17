package cn.com.pers.utils;


import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 * AES加密工具实现类(支持逆转算法)
 */
public class AESEncoder{

	/**
	 * 加密用的Key 可以用26个字母和数字组成，最好不要用保留字符
	 */
	private final static String KEY = "#5B.F2F0H_C0B$2/";

	public String decrypt(String password) {
		return decrypt(password, KEY);
	}
	
	public String decrypt(String password, String key) {
		if (null == key || "".equals(key) || key.length() != 16)
			return null;
		byte[] raw;
		try {
			raw = key.getBytes("ASCII");
			SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.DECRYPT_MODE, skeySpec);
			byte[] encrypted1 = hex2byte(password);
			byte[] original = cipher.doFinal(encrypted1);
			String originalString = new String(original);
			return originalString;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String encrypt(String password, String key) {
		return execute(password, key);

	}

	public String encrypt(String password) {
		return execute(password, KEY);
	}

	/**
	 * 加密逻辑
	 * 
	 * @param password
	 *            密码
	 * @param key
	 *            钥匙
	 * @return String
	 */
	private String execute(String password, String key) {
		if (null == password || "".equals(password))
			password = "888888";
		if (null == key || "".equals(key))
			return null;
		byte[] raw;
		try {
			raw = key.getBytes("ASCII");
			SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
			Cipher cipher = Cipher.getInstance("AES");
			cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
			byte[] encrypted = cipher.doFinal(password.trim().getBytes());
			return byte2hex(encrypted).toLowerCase();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			e.printStackTrace();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
		} catch (BadPaddingException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 16进制转byte
	 * 
	 * @param strhex
	 * @return byte[]
	 */
	private byte[] hex2byte(String strhex) {
		if (strhex == null) {
			return null;
		}
		int l = strhex.length();
		if (l % 2 == 1) {
			return null;
		}
		byte[] b = new byte[l / 2];
		for (int i = 0; i != l / 2; i++) {
			b[i] = (byte) Integer.parseInt(strhex.substring(i * 2, i * 2 + 2),
					16);
		}
		return b;
	}

	/**
	 * byte转16进制
	 * 
	 * @param b
	 *            字节数组
	 * @return String
	 */
	private String byte2hex(byte[] b) {
		String hs = "";
		String stmp = "";
		for (int n = 0; n < b.length; n++) {
			stmp = (java.lang.Integer.toHexString(b[n] & 0XFF));
			if (stmp.length() == 1) {
				hs = hs + "0" + stmp;
			} else {
				hs = hs + stmp;
			}
		}
		return hs.toUpperCase();
	}

	public static void main(String[] args) {
		String temp = new AESEncoder().encrypt("root");
		System.out.println(temp);
		System.out.println(new AESEncoder().decrypt(temp, KEY));
	}
}
