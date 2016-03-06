package me.mingxing5212.chaihens.voucher.data;

import me.mingxing5212.chaihens.component.VoucherSearchComponent;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.jdbc.SQL;

/**
 * 动态查询SQL构造
 *
 * @author Mingxing Li
 * @date 21/2/16
 */
public class VoucherDynaSelectSqlProvider {

    public String selectVouchers(final VoucherSearchComponent voucherSearchComponent){
        return new SQL(){{
            SELECT("*");
            FROM("tb_voucher");
            WHERE("1=1");
            if(voucherSearchComponent.getMerchantId() != null) {
                WHERE("`merchant_id`=" + voucherSearchComponent.getMerchantId());
            }

            if(voucherSearchComponent.getVoucherStatus() != null && !voucherSearchComponent.getVoucherStatus().isEmpty()) {
                WHERE("`status` in (" + StringUtils.join(voucherSearchComponent.getVoucherStatus().toArray(), ",") + ")");
            }
            if(voucherSearchComponent.getVoucherTypes() != null && !voucherSearchComponent.getVoucherTypes().isEmpty()) {
                WHERE("`type` in (" + StringUtils.join(voucherSearchComponent.getVoucherTypes().toArray(), ",") + ")");
            }
        }}.toString();
    }
}
