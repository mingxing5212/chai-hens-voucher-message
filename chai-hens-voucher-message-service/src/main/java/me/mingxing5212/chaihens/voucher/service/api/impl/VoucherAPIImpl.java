package me.mingxing5212.chaihens.voucher.service.api.impl;

import me.mingxing5212.chaihens.component.VoucherSearchComponent;
import me.mingxing5212.chaihens.domain.MerchantUser;
import me.mingxing5212.chaihens.domain.Platform;
import me.mingxing5212.chaihens.domain.Voucher;
import me.mingxing5212.chaihens.exception.ServiceException;
import me.mingxing5212.chaihens.voucher.api.IVoucherAPI;
import me.mingxing5212.chaihens.voucher.data.entity.VoucherEntity;
import me.mingxing5212.chaihens.voucher.service.VoucherDefinitionService;
import me.mingxing5212.chaihens.voucher.service.VoucherMarketService;
import me.mingxing5212.chaihens.voucher.service.api.impl.converter.VoucherConverter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

/**
 * 优惠券定义API实现
 *
 * @author Mingxing Li
 * @date 29/1/16
 */
public class VoucherAPIImpl implements IVoucherAPI {

    @Autowired
    private VoucherDefinitionService voucherDefinitionService;

    @Autowired
    private VoucherMarketService voucherMarketService;

    /**
     * 创建卡券
     * @param voucher 卡券信息
     * @param operator 操作员
     * @return 返回创建的卡券ID
     * @throws ServiceException
     */
    public Long addVoucher(Voucher voucher, MerchantUser operator) throws ServiceException {
        VoucherEntity voucherEntity = VoucherConverter.convertToVoucherEntity(voucher);
        //voucherEntity.setStoreJson(VoucherConverter.convertStoreString(voucher.getStore()));
        voucherEntity.setOperator(operator.getId());
        return voucherDefinitionService.addVoucher(voucherEntity);
    }

    /**
     * 修改卡券
     * @param voucher 修正的卡券信息
     * @param operator 操作员
     * @throws ServiceException
     */
    public void modifyVoucher(Voucher voucher, MerchantUser operator) throws ServiceException {
        VoucherEntity voucherEntity = VoucherConverter.convertToVoucherEntity(voucher);
        //voucherEntity.setStoreJson(VoucherConverter.convertStoreString(voucher.getStore()));
        voucherEntity.setOperator(operator.getId());
        voucherDefinitionService.modifyVoucher(voucherEntity);
    }

    /**
     * 删除卡券
     * @param voucherId 卡券ID
     * @param operator 操作员
     * @throws ServiceException
     */
    public void removeVoucher(Long voucherId, MerchantUser operator) throws ServiceException {
        voucherDefinitionService.removeVoucher(voucherId);
    }

    public void putOnMarket(Long voucherId, Set<Platform> platforms, MerchantUser operator) throws ServiceException {

    }

    public void withdrawMarket(Long voucherId, Set<Platform> platforms, MerchantUser operator) throws ServiceException {

    }

    /**
     * 获取优惠券
     * @param voucherSearchComponent 查询组件
     * @return
     * @throws ServiceException
     */
    public List<Voucher> getVouchers(VoucherSearchComponent voucherSearchComponent) throws ServiceException {
        List<VoucherEntity> voucherEntityList = voucherDefinitionService.getVouchers(voucherSearchComponent);
        return VoucherConverter.convertToVoucherList(voucherEntityList);
    }
}
