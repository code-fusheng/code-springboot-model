package xyz.fusheng.code.springboot.model.tools.gis.proj;

/**
 * @author code-fusheng <2561035977@qq.com>
 * @desc HeadingAngleCalculation
 * @date 2023-05-31 8:59 AM:33
 */

public class HeadingAngleCalculation {

    public static double getHeading(double lon1, double lat1, double lon2, double lat2, double heading) {
        // 将经纬度转换为弧度制
        double radLat1 = Math.toRadians(lat1);
        double radLon1 = Math.toRadians(lon1);
        double radLat2 = Math.toRadians(lat2);
        double radLon2 = Math.toRadians(lon2);

        // 计算AB线段水平和垂直方向上的增量
        double deltaLon = radLon2 - radLon1;
        double deltaLat = radLat2 - radLat1;

        // 计算AB线段的中心点纬度
        double lat = (radLat1 + radLat2) / 2;

        // 计算地球周长
        double earthCircumference = 40075016.68;

        // 计算AB线段在水平方向上的距离（单位：米）
        double dx = deltaLon * earthCircumference * Math.cos(lat) / 360;

        // 计算AB线段在垂直方向上的距离（单位：米）
        double dy = deltaLat * earthCircumference / 360;

        // 计算小车的行驶方向（单位：弧度）
        double theta = Math.atan2(dy, dx);

        // 将theta转换为以正北方向为0度的角度（逆时针旋转）
        double alpha = Math.toDegrees(Math.PI / 2 - theta);

        // 计算小车的航向角（单位：度数）
        alpha -= heading;

        // 将alpha控制在0-360度之间
        if (alpha < 0) {
            alpha += 360;
        } else if (alpha >= 360) {
            alpha -= 360;
        }

        return alpha;
    }

    public static void main(String[] args) {
        // 117.3582378,39.1335729
        // 117.3582267,39.1335514
        String point1 = "117.3573130,39.1337932";
        String point2 = "117.3573003,39.1337728";
        Double lon1 = Double.valueOf(point1.split(",")[0]);
        Double lat1 = Double.valueOf(point1.split(",")[1]);
        Double lon2 = Double.valueOf(point2.split(",")[0]);
        Double lat2 = Double.valueOf(point2.split(",")[1]);
        // double alpha = getHeading(117.3562659, 39.1347490, 117.3562691, 39.1347389, 0);
        double alpha = getHeading(lon1, lat1, lon2, lat2, 0);
        System.out.println(alpha);

    }

}

