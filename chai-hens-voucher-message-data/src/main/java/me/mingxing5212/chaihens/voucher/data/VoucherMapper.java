package me.mingxing5212.chaihens.voucher.data;

import me.mingxing5212.chaihens.component.VoucherSearchComponent;
import me.mingxing5212.chaihens.domain.Store;
import me.mingxing5212.chaihens.voucher.data.entity.StoreEntity;
import me.mingxing5212.chaihens.voucher.data.entity.VoucherEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Voucher数据处理
 *
 * @author Mingxing Li
 * @date 23/1/16
 */
public interface VoucherMapper {

    @Select("SELECT * FROM tb_voucher WHERE id = #{voucherId}")
    VoucherEntity findById(@Param("voucherId") Long voucherId);

    @Insert("INSERT INTO tb_voucher(`name`,`type`,`status`,`merchant_id`,`denomination`,`description`,`avatar`,`color`,`effective_start_time`,`effective_end_time`) " +
            "VALUES (#{name}, #{type}, #{status}, #{merchantId}, #{denomination}, #{description}, #{avatar}, #{color}, #{effectiveStartTime}, #{effectiveEndTime})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    Long addVoucher(VoucherEntity voucherEntity);

    @UpdateProvider(type = VoucherDynaUpdateSqlProvider.class,
            method = "updateVoucher")
    void modifyVoucher(VoucherEntity voucherEntity);

    @Delete("DELETE FROM tb_voucher WHERE `id`=#{voucherId}")
    void removeVoucher(Long voucherId);

    @SelectProvider(type = VoucherDynaSelectSqlProvider.class,
            method = "selectVouchers")
    @Results({
        @Result(id=true, column="stud_id", property="studId"),
        @Result(column="name", property="name"),
        @Result(property="store", column="store_id",
                one=@One(select="me.mingxing5212.chaihens.voucher.data.VoucherMapper.findStoreById"))
    })
    List<VoucherEntity> findVouchers(VoucherSearchComponent voucherSearchComponent);

    @Select("SELECT * FROM tb_store WHERE `id`=#{storeId}")
    StoreEntity findStoreById(@Param("storeId") Long storeId);
}
