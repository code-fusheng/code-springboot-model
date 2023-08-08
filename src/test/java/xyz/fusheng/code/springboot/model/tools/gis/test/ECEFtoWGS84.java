package xyz.fusheng.code.springboot.model.tools.gis.test;

public class ECEFtoWGS84 {
    public static void main(String[] args) {
        double x = 1334000.5446860685; // 地心坐标系X分量，单位为米
        double y = -4654052.129206824; // 地心坐标系Y分量，单位为米
        double z = 4138306.7613728405; // 地心坐标系Z分量，单位为米

        double a = 6378137; // WGS84椭球体长半轴，单位为米
        double e = 1 / 298.257223563; // WGS84椭球体第一偏心率

        double lon = Math.atan2(y, x); // 经度，单位为弧度
        double p = Math.sqrt(x*x + y*y); // 平面投影距离
        double lat = Math.atan2(z, p / (1 - e*e)); // 纬度，单位为弧度
        double N = a / Math.sqrt(1 - e*e*Math.sin(lat)*Math.sin(lat)); // 卯酉圈曲率半径
        double h = p / Math.cos(lat) - N; // 椭球面上的高度

        System.out.println("Latitude: " + Math.toDegrees(lat));
        System.out.println("Longitude: " + Math.toDegrees(lon));
        System.out.println("Altitude: " + h);
    }
}