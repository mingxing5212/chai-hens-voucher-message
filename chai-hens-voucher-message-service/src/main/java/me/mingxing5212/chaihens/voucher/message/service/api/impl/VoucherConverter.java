package me.mingxing5212.chaihens.voucher.message.service.api.impl;

import me.mingxing5212.chaihens.domain.voucher.Voucher;
import me.mingxing5212.chaihens.voucher.message.wechat.entity.card.CardDetailEntity;

/**
 * CashCardConverter
 *
 * @author Mingxing Li
 * @date 15/5/16
 */
public class VoucherConverter {
    public static Voucher convertToVoucher(CardDetailEntity cardDetailEntity){
        Voucher voucher = new Voucher();
        voucher.setId(cardDetailEntity.getCash().getBase_info().getId());
        voucher.setName(cardDetailEntity.getCash().getBase_info().getTitle());
        return voucher;
    }
}
