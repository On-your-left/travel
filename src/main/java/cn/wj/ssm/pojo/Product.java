package cn.wj.ssm.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.text.SimpleDateFormat;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
    private String id;
    private String productNum;
    private String productName;
    private String cityName;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date departureTime;
    private String departureTimeStr;
    private Integer productPrice;
    private String productDesc;
    private Integer productStatus;
    private String productStatusStr;

    public String getDepartureTimeStr() {
        // 对日期格式化
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        if (null != departureTime) {
            departureTimeStr = dateFormat.format(departureTime);
        }
        return departureTimeStr;
    }

    public String getProductStatusStr() {

        if (productStatus == null) {
            return "";
        }

        if (productStatus == 0){
            productStatusStr = "关闭";
        } else if(productStatus == 1){
            productStatusStr = "开启";
        }

        return productStatusStr;
    }
}
