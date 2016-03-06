package me.mingxing5212.chaihens.voucher.api;

import me.mingxing5212.chaihens.component.VoucherSearchComponent;
import me.mingxing5212.chaihens.domain.MerchantUser;
import me.mingxing5212.chaihens.domain.Platform;
import me.mingxing5212.chaihens.domain.Voucher;
import me.mingxing5212.chaihens.exception.ServiceException;

import java.util.List;
import java.util.Set;

/**
 * 卡券相关SOA接口
 *
 * @author Mingxing Li
 * @date 2/2/16
 */
public interface IVoucherAPI {

    /**
     * 创建卡券
     * @param voucher 卡券信息
     * @param operator 操作员
     * @return 返回创建的卡券ID
     * @throws ServiceException
     */
    Long addVoucher(Voucher voucher, MerchantUser operator) throws ServiceException;

    /**
     * 修改卡券
     * 差异修改, 修改字段标记非空
     * @param voucher 修正的卡券信息
     * @param operator 操作员
     * @throws ServiceException
     */
    void modifyVoucher(Voucher voucher, MerchantUser operator) throws ServiceException;

    /**
     * 删除卡券
     * @param voucherId 卡券ID
     * @param operator 操作员
     * @throws ServiceException
     */
    void removeVoucher(Long voucherId, MerchantUser operator) throws ServiceException;

    /**
     * 向市场投放卡券
     * @param voucherId 卡券ID
     * @param platforms 投放平台
     * @param operator 操作员
     * @throws ServiceException
     */
    void putOnMarket(Long voucherId, Set<Platform> platforms, MerchantUser operator) throws ServiceException;

    /**
     * 从市场撤回卡券
     * @param voucherId 卡券ID
     * @param platforms 投放平台
     * @param operator 操作员
     * @throws ServiceException
     */
    void withdrawMarket(Long voucherId, Set<Platform> platforms, MerchantUser operator) throws ServiceException;

    /**
     * 获取优惠券
     * @param voucherSearchComponent 查询条件
     * @return
     * @throws ServiceException
     */
    List<Voucher> getVouchers(VoucherSearchComponent voucherSearchComponent) throws ServiceException;
}
