package xyz.fusheng.code.springboot.model.tools.gdal;

import org.gdal.gdal.gdal;
import org.gdal.ogr.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc Gdal工具类
 * @date 2023-02-15 16:26:12
 */


@SpringBootTest
@RunWith(SpringRunner.class)
public class GdalTest {

    @Test
    public void convertCADToGeoJSON() {
        String cadFilePath;
        String geoJsonFilePath;
        // ogr.RegisterAll();
        System.out.println(gdal.GetDriverCount());
        // 打开 CAD 文件
        cadFilePath = "src/main/resources/temp/file/TEST_V1_P_WKS_LAYER_DOWN3.dxf";
        DataSource ds = ogr.Open(cadFilePath);
        // 获取第一个图层
        Layer layer = ds.GetLayer(0);
        Driver geoJsonDriver = ogr.GetDriverByName("GeoJSON");
    }

}

