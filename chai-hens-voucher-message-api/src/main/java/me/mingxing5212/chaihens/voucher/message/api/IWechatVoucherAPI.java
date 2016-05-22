package me.mingxing5212.chaihens.voucher.message.api;

import me.mingxing5212.chaihens.domain.voucher.Voucher;
import me.mingxing5212.chaihens.exception.ServiceException;

import java.util.List;

/**
 * IWechatVoucherAPI
 *
 * @author Mingxing Li
 * @date 15/5/16
 */
public interface IWechatVoucherAPI {
    List<Voucher> getCashCards(Long merchantId) throws ServiceException;
}
