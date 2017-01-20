package hemiy.qinghui.com.mytestdemo.util;

import java.io.InputStream;
import java.io.OutputStream;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Copyright &copy; 2013 广州市道一信息技术有限公司<br />
 * All rights reserved.<br />
 *
 * @author 施华 Anders See
 * @version 1.0
 * @since 2013-06-24
 */
public class AESEncryptUtil {

    /**
     * 初始化 AES Cipher
     *
     * @param password
     * @param isEncryptMode
     * @return
     */
    public static Cipher initAESCipher(String password, boolean isEncryptMode) {
        try {
            IvParameterSpec zeroIv = new IvParameterSpec(password.getBytes("utf-8"));
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            final SecretKeySpec secretKey = new SecretKeySpec(password.getBytes("utf-8"), "AES");
            if (isEncryptMode) {
                cipher.init(Cipher.ENCRYPT_MODE, secretKey, zeroIv);
            } else {
                cipher.init(Cipher.DECRYPT_MODE, secretKey, zeroIv);
            }
            return cipher;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 加密
     *
     * @param bytes    需要加密的内容
     * @param password 加密密码
     * @return
     */
    public static byte[] encrypt(byte[] bytes, String password) {
        try {
            Cipher cipher = initAESCipher(password, true);
            if (null == cipher) {
//                log.error("加密器初始化失败");
                return bytes;
            }
            return cipher.doFinal(bytes); // 加密
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null; //这个是我们改动
    }

    public static InputStream toInputStream(InputStream is, String password, boolean isEncryptMode) {
        try {
            return new CipherInputStream(is, initAESCipher(password, isEncryptMode));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return is;
    }

    /**
     * 解密
     *
     * @param content  待解密内容
     * @param password 解密密钥
     * @return
     */
    public static byte[] decrypt(byte[] content, String password) {
        try {
            Cipher cipher = initAESCipher(password, false);
            if (null == cipher) {
//                log.error("加密器初始化失败");
                return content;
            }
            return cipher.doFinal(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static OutputStream toOutputStream(OutputStream out, String password, boolean isEncryptMode) {
        try {
            return new CipherOutputStream(out, initAESCipher(password, isEncryptMode));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out;
    }
}
