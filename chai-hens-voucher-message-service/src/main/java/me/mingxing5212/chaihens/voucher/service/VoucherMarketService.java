package me.mingxing5212.chaihens.voucher.service;

import me.mingxing5212.chaihens.domain.MerchantUser;
import me.mingxing5212.chaihens.domain.Platform;
import me.mingxing5212.chaihens.domain.Voucher;
import me.mingxing5212.chaihens.voucher.data.entity.VoucherEntity;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * 卡券市场服务
 *
 * @author Mingxing Li
 * @date 6/2/16
 */
@Service
public class VoucherMarketService {

    /**
     * 将优惠券投放市场
     * @param voucher
     * @param platforms
     * @param operator
     */
    public void putOnTheMarket(Voucher voucher, Set<Platform> platforms, MerchantUser operator){

    }

    /**
     * 将优惠券从市场里撤销
     * @param voucher
     * @param platforms
     * @param operator
     */
    public void withdrawFromMarket(Voucher voucher, Set<Platform> platforms, MerchantUser operator){

    }
}
