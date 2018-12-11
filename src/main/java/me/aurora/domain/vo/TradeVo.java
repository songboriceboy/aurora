package me.aurora.domain.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * 交易详情，实际应用应该存入数据库，这里就不记录到数据库了，仅供临时测试
 * @author zhengjie
 * @date 2018/09/30 13:58:32
 */
@Data
public class TradeVo {

    /**
     * （必填）商品描述
     */
    @NotBlank(groups = {New.class})
    private String body;

    /**
     * （必填）商品名称
     */
    @NotBlank(groups = {New.class})
    private String subject;

    /**
     * （必填）商户订单号，应该由后台生成
     */
    @ApiModelProperty(hidden = true)
    private String outTradeNo;

    /**
     * （必填）第三方订单号，微信，支付宝
     */
    @ApiModelProperty(hidden = true)
    private String tradeNo;

    /**
     * （必填）价格
     */
    @NotBlank(groups = {New.class})
    private String totalAmount;

    /**
     * 订单状态,已支付，未支付，作废
     */
    @ApiModelProperty(hidden = true)
    private String state;

    /**
     * 创建时间，存入数据库时需要
     */
    @ApiModelProperty(hidden = true)
    private Timestamp createTime;

    /**
     * 作废时间，存入数据库时需要
     */
    @ApiModelProperty(hidden = true)
    private Date cancelTime;

    public interface New{};
}
