package me.mingxing5212.chaihens.voucher.data;

import me.mingxing5212.chaihens.voucher.data.entity.VoucherEntity;
import org.apache.ibatis.jdbc.SQL;

/**
 * 动态修改SQL
 *
 * @author Mingxing Li
 * @date 6/2/16
 */
public class VoucherDynaUpdateSqlProvider {

    public String updateVoucher(final VoucherEntity voucherEntity)
    {
        return new SQL() {{
            UPDATE("tb_voucher");
            if (voucherEntity.getName() != null) {
                SET("`name` = #{name}");
            }
            if (voucherEntity.getStatus() != null) {
                SET("`status` = #{status}");
            }
            if (voucherEntity.getType() != null) {
                SET("`type` = #{type}");
            }
            if (voucherEntity.getAvatar() != null) {
                SET("`avatar` = #{avatar}");
            }
            if (voucherEntity.getDenomination() != null) {
                SET("`denomination` = #{denomination}");
            }
            if (voucherEntity.getDescription() != null) {
                SET("`description` = #{description}");
            }
            if (voucherEntity.getColor() != null) {
                SET("`color` = #{color}");
            }
            if (voucherEntity.getEffectiveStartTime() != null) {
                SET("`effective_start_time` = #{effectiveStartTime}");
            }
            if (voucherEntity.getEffectiveEndTime() != null) {
                SET("`effective_end_time` = #{effectiveEndTime}");
            }
            if (voucherEntity.getOperator() != null) {
                SET("`operator` = #{operator}");
            }
            if (voucherEntity.getMerchantId() != null) {
                SET("`merchant_id` = #{merchantId}");
            }
            if (voucherEntity.getStore() != null) {
                SET("`store_id` = #{store.id}");
            }
            WHERE("id = #{id}");
        }}.toString();
    }
}
