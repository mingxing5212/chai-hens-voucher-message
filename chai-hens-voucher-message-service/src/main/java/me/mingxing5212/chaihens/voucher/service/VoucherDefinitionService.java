package me.mingxing5212.chaihens.voucher.service;

import me.mingxing5212.chaihens.component.VoucherSearchComponent;
import me.mingxing5212.chaihens.voucher.data.VoucherMapper;
import me.mingxing5212.chaihens.voucher.data.entity.VoucherEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 优惠券相关实现类
 *
 * @author Mingxing Li
 * @date 5/2/16
 */
@Service
public class VoucherDefinitionService {

    @Autowired
    protected VoucherMapper voucherMapper;

    /**
     * 增加优惠券
     * @param voucherEntity
     * @return
     */
    public Long addVoucher(VoucherEntity voucherEntity){
        return voucherMapper.addVoucher(voucherEntity);
    }

    /**
     * 修改优惠券
     * @param voucherEntity
     */
    public void modifyVoucher(VoucherEntity voucherEntity){
        voucherMapper.modifyVoucher(voucherEntity);
    }

    /**
     * 删除优惠券
     * @param voucherId
     */
    public void removeVoucher(Long voucherId){
        voucherMapper.removeVoucher(voucherId);
    }

    /**
     * 查询优惠券
     * @param voucherSearchComponent
     * @return
     */
    public List<VoucherEntity> getVouchers(VoucherSearchComponent voucherSearchComponent){
        return voucherMapper.findVouchers(voucherSearchComponent);
    }
}
