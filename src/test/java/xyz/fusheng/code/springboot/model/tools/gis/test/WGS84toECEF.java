package xyz.fusheng.code.springboot.model.tools.gis.test;

public class WGS84toECEF {
    public static void main(String[] args) {
        double lat = 40.7128; // 纬度，单位为度
        double lon = -74.0060; // 经度，单位为度
        double alt = 10; // 椭球面上的高度，单位为米

        double a = 6378137; // WGS84椭球体长半轴，单位为米
        double f = 1 / 298.257223563; // WGS84椭球体扁率

        double b = a * (1 - f); // WGS84椭球体短半轴，单位为米
        double e = Math.sqrt(1 - b*b/(a*a)); // WGS84椭球体第一偏心率
        double N = a / Math.sqrt(1 - e*e*Math.sin(Math.toRadians(lat))*Math.sin(Math.toRadians(lat))); // 子午线曲率半径
        double x = (N + alt) * Math.cos(Math.toRadians(lat)) * Math.cos(Math.toRadians(lon)); // 地心坐标系X分量，单位为米
        double y = (N + alt) * Math.cos(Math.toRadians(lat)) * Math.sin(Math.toRadians(lon)); // 地心坐标系Y分量，单位为米
        double z = (N*(1 - e*e) + alt) * Math.sin(Math.toRadians(lat)); // 地心坐标系Z分量，单位为米

        System.out.println("ECEF X: " + x);
        System.out.println("ECEF Y: " + y);
        System.out.println("ECEF Z: " + z);

        // 将地心笛卡尔坐标系转换为WGS84 GPS经纬度坐标
        double lon2 = Math.atan2(y, x); // 经度，单位为弧度
        double p = Math.sqrt(x*x + y*y); // 平面投影距离
        double lat2 = Math.atan2(z, p / (1 - e*e)); // 纬度，单位为弧度
        double N2 = a / Math.sqrt(1 - e*e*Math.sin(lat2)*Math.sin(lat2)); // 卯酉圈曲率半径
        double h2 = p / Math.cos(lat2) - N2; // 椭球面上的高度

        System.out.println("Latitude: " + Math.toDegrees(lat2));
        System.out.println("Longitude: " + Math.toDegrees(lon2));
        System.out.println("Altitude: " + h2);
    }
}