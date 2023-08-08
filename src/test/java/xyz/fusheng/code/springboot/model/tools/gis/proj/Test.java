// package xyz.fusheng.code.springboot.model.tools.gis.proj;
//
// import org.osgeo.proj4j.CRSFactory;
// import org.osgeo.proj4j.CoordinateReferenceSystem;
// import org.osgeo.proj4j.CoordinateTransform;
// import org.osgeo.proj4j.ProjCoordinate;
// import org.osgeo.proj4j.proj.Projection;
//
// /**
//  * @author code-fusheng <2561035977@qq.com>
//  * @desc Test
//  * @date 2023-05-30 9:13 PM:36
//  */
//
// public class Test {
//
//     public void WGS84ToECEF() {
//         // 创建WGS84和ECEF坐标系对象
//         CRSFactory factory = new CRSFactory();
//         CoordinateReferenceSystem crsWGS84 = factory.createFromName("EPSG:4326"); // WGS84 GPS经纬度坐标系
//         CoordinateReferenceSystem crsECEF = factory.createFromName("EPSG:4978"); // 地心笛卡尔坐标系
//
//         // 创建ProjCoordinate对象，并设置WGS84经纬度坐标
//         ProjCoordinate srcCoord = new ProjCoordinate(-74.0060, 40.7128);
//
//         // 对WGS84坐标执行坐标转换
//         Projection crsWGS84Projection = crsWGS84.getProjection();
//         Projection crsECEFProjection = crsECEF.getProjection();
//
//         CoordinateTransform transform = new CoordinateTransform(crsWGS84Projection, crsECEFProjection);
//
//         crsECEF.getProjection().transform(crsWGS84.getProjection(), srcCoord, dstCoord);
//
//         // 输出转换结果
//         System.out.println("ECEF X: " + dstCoord.x);
//         System.out.println("ECEF Y: " + dstCoord.y);
//         System.out.println("ECEF Z: " + dstCoord.z);
//     }
//
//     public void ECEFtoWGS84() {
//         // 创建WGS84和ECEF坐标系对象
//         CRSFactory factory = new CRSFactory();
//         CoordinateReferenceSystem crsWGS84 = factory.createFromName("EPSG:4326"); // WGS84 GPS经纬度坐标系
//         CoordinateReferenceSystem crsECEF = factory.createFromName("EPSG:4978"); // 地心笛卡尔坐标系
//
//         // 创建ProjCoordinate对象，并设置地心笛卡尔坐标
//         ProjCoordinate srcCoord = new ProjCoordinate(-823736.9685127269, -4905358.163474622, 3994973.223015074);
//
//         // 对地心笛卡尔坐标执行坐标转换
//         ProjCoordinate dstCoord = new ProjCoordinate();
//         crsWGS84.getProjection().transform(crsECEF.getProjection(), srcCoord, dstCoord);
//
//         // 输出转换结果
//         System.out.println("Latitude: " + dstCoord.y);
//         System.out.println("Longitude: " + dstCoord.x);
//         System.out.println("Altitude: " + dstCoord.z);
//     }
//
//     public static void main(String[] args) {
//
//     }
//
// }
//
