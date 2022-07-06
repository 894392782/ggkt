package com.atguigu;
import com.alibaba.fastjson.JSON;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.exception.CosClientException;
import com.qcloud.cos.exception.CosServiceException;
import com.qcloud.cos.http.HttpProtocol;
import com.qcloud.cos.model.*;
import com.qcloud.cos.region.Region;

import java.io.File;

public class TestCos {

    public static void main(String[] args) {
        // 1 ��ʼ���û������Ϣ��secretId, secretKey����
        // SECRETID��SECRETKEY���¼���ʹ������̨ https://console.cloud.tencent.com/cam/capi ���в鿴�͹���
        String secretId = "AKIDgJm5D9uTpytiOw3kFubJe1W4dGxiWL93";
        String secretKey = "9Pg0FIJNQKTUJ1cz85tW0J4nQsAGPOJO";
        COSCredentials cred = new BasicCOSCredentials(secretId, secretKey);
        // 2 ���� bucket �ĵ���, COS ����ļ������� https://cloud.tencent.com/document/product/436/6224
        // clientConfig �а��������� region, https(Ĭ�� http), ��ʱ, ����� set ����, ʹ�ÿɲμ�Դ����߳������� Java SDK ���֡�
        Region region = new Region("ap-beijing");
        ClientConfig clientConfig = new ClientConfig(region);
        // ���ｨ������ʹ�� https Э��
        // �� 5.6.54 �汾��ʼ��Ĭ��ʹ���� https
        clientConfig.setHttpProtocol(HttpProtocol.https);
        // 3 ���� cos �ͻ��ˡ�
        COSClient cosClient = new COSClient(cred, clientConfig);

        try{
            // ָ��Ҫ�ϴ����ļ�
            File localFile = new File("C:\\Users\\89439\\Desktop\\0220618165111.jpg");
            // ָ���ļ���Ҫ��ŵĴ洢Ͱ
            String bucketName = "ggkt-hc-1312805044";
            // ָ���ļ��ϴ��� COS �ϵ�·���������������������Ϊfolder/picture.jpg�����ʾ���ļ� picture.jpg �ϴ��� folder ·����
            String key = "/2022/07/01.jpg";
            PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
            PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
            System.out.println(JSON.toJSONString(putObjectResult));
        } catch (Exception clientException) {
            clientException.printStackTrace();
        }

    }
}