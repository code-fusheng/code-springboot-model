package xyz.fusheng.code.springboot.model.tools.bank.bocd;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import com.bocd.api.util.BocdSignUtils;
import com.ruim.ifsp.utils.message.IfspJsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import xyz.fusheng.code.springboot.model.common.util.RestTemplateUtils;
import xyz.fusheng.code.springboot.model.plugin.bank.bocd.utils.HttpClientUtils;

public class Test100603 {

	private Logger logger = LoggerFactory.getLogger(Test100603.class);

	private String url = "http://winxintest.bocd.com.cn/ifsp-payweb/SOA/";
	
	private static String privateKey = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAKQPLWVvvxJ7qO4slr1wimYdCsAGHC2nhG3cXJ9KZkqmmCq+1X5/XN19jD6KzOXI1eo46bsg2IL/2TchkwIDi2Ndh+hFdWkVfHfhNGf6IvagRe4wuM/T440TycO3bVR/8ui8fdQYqDmD2LrO8on04bvFHcQuPLTLWFtoygZ/nU8pAgMBAAECgYAUlQre9PwFt5nj95gZwCq80NvuZ1XVrHSCy+ia21yl9OyWQEbMjfH6n6uelQ9LrLyZm/ZG0cIX/T0lG4Mz93nfE/fYv0QzJkyAKTu10yN7deczbcQemFBP5ac9nQVYLuoSm5ckcEQYxTfRRHL7I5Rtl+L2dd36YEDMjvE2aKZW2QJBANhBO59tMLKxOyieOzPIqvk2G2TeMmgbRShqxGVVfyYWziauCNrCZa0zAm9wQ87Mbpi24OkDb0JaWLsWX1+jJQ8CQQDCNiZq+AQ/rvOPTegP+tBfjZJAoMDHK1lbTPYYpgZpyx5U/o8q807owAvPJ55u1JB6yPSOYS4tCtAvHCpWEXhHAkAwqUUcU7qgiwbv1eMmfOIUH9u8L8+R44kFVjkJQFrTHFCZHZI6f4HXnmHO56kqcI/2Zzhm1nIDsUbEGn2tjI17AkAYt7WaBajcxhJ/maXAauacUrNbgFoovy6nPRtRNcg5LL3WiXOFPuQ7IT4fhmZWqr0cs3jUqi+rUeX/KPGGdMC/AkEAjQGgfRPAv6P9PD2THkziUslXCiRK2d9dvXGSP4BMBpNAVqfvFlKy1dgWu05Fnwt0wkosm57XIL3WJo9nXrhQ7w==";

	private static String bocdPublicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCkDy1lb78Se6juLJa9cIpmHQrABhwtp4Rt3FyfSmZKppgqvtV+f1zdfYw+iszlyNXqOOm7INiC/9k3IZMCA4tjXYfoRXVpFXx34TRn+iL2oEXuMLjP0+ONE8nDt21Uf/LovH3UGKg5g9i6zvKJ9OG7xR3ELjy0y1hbaMoGf51PKQIDAQAB";

	@Test
	public void xcxTest() throws Exception{
		
		Map<String,Object> map=new HashMap<String,Object>();
		
		map.put("encoding", "UTF-8");//编码
		map.put("signMethod", "01");//01-RSA 签名方式
		map.put("sdkAppId", "sdkAppId");//固定
		map.put("certId", "1492671841");//测试环境证书编号
		map.put("merId", "8202007070000001");//商户号
		map.put("backEndUrl", "http://183.215.31.180:10240/debug/pay/bocd/asyncNotify");//异步通知地址
		map.put("txnOrderId", "100000010006");//商户订单号
		map.put("txnOrderTime", "20190910120000");//商户订单时间
		map.put("txnSubType", "100601");//子交易码
		map.put("txnType", "1006");//交易码
		map.put("txnAccType", "02");//微信
		map.put("aesWay", "01");//固定01
		map.put("txnAmt", "1");//金额
		map.put("txnCcyType", "156");//币种
		map.put("txnOrderBody", "支付加油金额");//交易金额
		map.put("txnProductId", "PD0001");//产品ID
		// map.put("txnSubOpenid", "oUpF8uET8zFOPR42QWbCbdeIabxE");//subopenid 商户公众号对应openid
		// map.put("secMerAppId", "wxf814b9de69d4cfc0");//subappid 商户公众号
		map.put("txnAuthCode", "133032256834697689");
		// 加签名
		map=BocdSignUtils.bocdSign(map, privateKey);
		
		// 返回报文
		// String result = HttpClientUtils.send(map, "txnAccept", url, false);
		String url = this.url + "txnAccept";
		String result = RestTemplateUtils.exchange(url, HttpMethod.POST, null, null, map, String.class);
		logger.info("result:{}", result);
		Map resultMap = IfspJsonUtil.jsonTOmap(result);
		if (!BocdSignUtils.bocdCheckSign(resultMap, bocdPublicKey)) {
			System.out.println("商户签名验证失败");
		} else {
			System.out.println("验签成功");
		}

	}


}
