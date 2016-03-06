package me.mingxing5212.chaihens.voucher.web;

import me.mingxing5212.chaihens.component.VoucherSearchComponent;
import me.mingxing5212.chaihens.domain.Voucher;
import me.mingxing5212.chaihens.domain.VoucherStatus;
import me.mingxing5212.chaihens.voucher.data.entity.VoucherEntity;
import me.mingxing5212.chaihens.voucher.service.VoucherDefinitionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * TestController
 *
 * @author Mingxing Li
 * @date 5/2/16
 */
@RestController
@RequestMapping(value = "/test")
public class TestController {

    @Autowired
    protected VoucherDefinitionService voucherDefinitionService;

    @RequestMapping(method = RequestMethod.GET)
    public String test(){
        VoucherSearchComponent voucherSearchComponent = new VoucherSearchComponent();
        voucherSearchComponent.setMerchantId(1l);
        voucherSearchComponent.setVoucherStatus(Arrays.asList(VoucherStatus.CREATED));
        List<VoucherEntity> voucherList = voucherDefinitionService.getVouchers(voucherSearchComponent);
        return "";
    }
}
