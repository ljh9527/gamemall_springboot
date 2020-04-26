package com.gamemall.gamemall.config;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号,开发时使用沙箱提供的APPID，生产环境改成自己的APPID
    public static String APP_ID = "2016102200737577";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String APP_PRIVATE_KEY = "MIIEwAIBADANBgkqhkiG9w0BAQEFAASCBKowggSmAgEAAoIBAQCgOqgYRi9nEjC4+tGPjeNkOji//RCJnB2acFKmJ6PiNIfsnbW8CPPanQMHKrQtehfUvIo/YczQdnLDAbaO1sSFfSayy+61mMLH6Lj0SUQzmSpDUSOjeTzIJmH4srdK5vEk1jfU34we7gm3Z5OuJpeO+/Yjx3lb4+czq0iXk82sBjt4Nxv2hQxKfLPajYEz/YEAaoNQgHNYZDuSXdGeqeauy8XNK/D+eWsctDwXYG2Kyxu+nf2R2yuVDFlb6sTN3dpIvmiMKJ6nSGfYi9ET79qwb1j6VZfjpAOMOiB7qeG+2s45EnfZQBDTkkR0nLMHDwf7T8nvO2yy/l/05Dc8C3JHAgMBAAECggEBAJmDWWXYaLYx4Wh5Nqp5YPG4LoMTLPMLFfnPv//dXtDtT4VOHL6JPUmowSvuqC4iGg8CjNnpE9hug8l+LLBx6FuU6qzHYm+uaoAp4np6b9OX3bwdUy3ejHOfAqLKZ35mAYgvjdJwU8mWesyzefSSmQavNMZW6Vk2417Hroc7XwR+dhaLE5F+ibQAmyYtRYkNosBteqkaRXL6eyt/amCRbVf69UooZcYbUH7j2Oz56lxMk2V49rdoCvwMjPaZf7O4/uqWkYMsxU4BomE6t2bVg001RK38EbGMCUS41B2CMKD4lvtRp6/E+jYmduiaIqlk8Hcbi+Xq35aYQMxB/CmkxYECgYEA39ychJM35cdn1U7hBTy9yIIzQocNadn9BqmfRebrevKBrH93v+y65Whb7f4Gb+IvWf63OeMglocsYnCApoltSpFrfNfKs3sgBgNHmaWkBs3mHDf+cnaoKYnhKsM0lQN+SbsDzynfPbCWuhlc3WLO6JDBcHaU8ix6JSNzwm5Kw6cCgYEAtztpoAmB3Lsfs5YVvUeDg+PnzXflUMGNkDHzNLRo2fUwH2X2ut1O+qBPCu4IfiBp63lqVMBz8O1ClcQkZh3qpJer6jSKgO/WajheItO9Ch+bw5l15ZizCiw3/073bnX/QjD3Ftu78pdAA8rFBP6oRsSeZqR3t2xE1317Fmu4MGECgYEAmq9RQ9aKSG9aUy23FSxco0E8dFrnrN3hFgp9MQsYahNKAUzvDSJiHoTXCQN/pS3wtEnqh8hmyzzKMZc1fl31tBH56QEfYpfQj/cSMZwgVEdQGu2iF6vgFRveB/Ns0Q7h48ajIjH3vSPZcux1m9Bb0p273J9D2ndbS3BM2+vkI38CgYEAkUuLdlwTnfTELqPUmUMcBnmyVju8m0zf9HenYyOsASlr/3nbLFJRTmvQQdp+4YTSeObOamYxidqZ8iiWtGMErX+X0x/WtGd6nsAT5YoBXQWzfmcyFd4AGxD1Vn5Htk/bGaG6TWXwo21MVbV0hYFp7rP652mDhO9Vp4rZD+5bIAECgYEA3ZLTNFAL/gt4Jl0MRNWIk6F9EIJJUBh/KipQKgfT/Nvs4SkG88rJNjPpUjbJVrozSMgosOzKgvCHNv5vMeCVQnswTi8rBYylJjLl3AHp3SJ6SYfTQLdimksdiMkm0trpZqDwM7iQvZNwuVWIefvwEc91ihkAhqSkIyXRrLHukcE=";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEArt8lEQmIs3i/OjOY7gX9sM7eBH02QjMFkT2NQt7hY9lJc6G5+xojW2JU8aj3b48/peDZwo+B692uHNYjRdVvsK1b1uMpoeSAp0Ud1NiYlCN0X3rRntH+xrvu724S2WLb9CMo+V3seVsMA+VrB58HhwjirBeio4uEIs9ccb8TUvI/IVnCuq/d7Bk5zzpfm+JamttjAQfH2nsElJf9xOC1ej2Br/nes9Ixk1e3s1L6TzfWxTGyA05pzF7Qo4J7FFkx4294V+w66oS3OcegIBxbq+p3hmdR0tGnJoXWKmSYXTsUH3OB0w+m6bSJXq76OUOi4pXXoDGtCvF5ReR1ZlX30QIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://14.196.7.219/notify_url";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问(其实就是支付成功后返回的页面)
    public static String return_url = "http://localhost:3456/pay/success";

    // 签名方式
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String CHARSET = "utf-8";

    // 支付宝网关，这是沙箱的网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /**
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}