/**
 * Created by limingxing on 13/3/16.
 */
var CashPage = function () {

    var initButtons = function () {
        /* 创建按钮单击事件 */
        $("#btnCreateVoucher").bind("click", function(){
            CashPage.clearForm();
            CashPage.showForm();
        });
        /* 保存按钮单击事件 */
        $("#btnSave").bind("click", function(){
            var voucherId = $("#textVoucherId").val();
            var textVoucherName = $("#textVoucherName").val();
            var textVoucherDescription = $("#textVoucherDescription").val();
            var textDenomination = $("#textDenomination").val();
            var textVoucherEffectiveDays = $("#textVoucherEffectiveDays").val();
            var textMinimumConsumption = $("#textMinimumConsumption").val();
            var textLimit = $("#textLimit").val();
            CashPage.saveVoucher(voucherId, textVoucherName, textVoucherDescription, textDenomination, textVoucherEffectiveDays, textMinimumConsumption, textLimit);
        });
        /* 修改按钮单击事件 */
        $(".btnEdit").bind("click", function(e){
            var voucher = $(this).closest("tr");
            CashPage.clearForm();
            CashPage.initForm(voucher.attr("voucherId"), voucher.attr("voucherName"), voucher.attr("description"), voucher.attr("denomination"), voucher.attr("effectiveDays"), voucher.attr("minimumConsumption"), voucher.attr("orderLimit"));
            CashPage.showForm();
        });
        /* 移除按钮单击事件*/
        $(".btnRemove").bind("click", function(e){
            var voucher = $(this).closest("tr");
            CashPage.removeVoucher(voucher.attr("voucherId"));
        });
    }

    return {
        init: function () {
            initButtons();
        },

        clearForm: function(){
            $("#createVoucherModel .form-control").val('');
        },
        
        showForm: function () {
            $("#createVoucherModel").modal("show");
        },

        initForm : function (voucherId, voucherName, description, denomination, effectiveDays, minimumConsumption, orderLimit) {
            $("#textVoucherId").val(voucherId);
            $("#textVoucherName").val(voucherName);
            $("#textVoucherDescription").val(description);
            $("#textDenomination").val(denomination);
            $("#textVoucherEffectiveDays").val(effectiveDays);
            $("#textMinimumConsumption").val(minimumConsumption);
            $("#textLimit").val(orderLimit);
        },

        saveVoucher : function(voucherId, voucherName, description, denomination, effectiveDays, minimumConsumption, orderLimit){
            var voucher = {"name" : voucherName, "description" : description, "denomination" : denomination, "effectiveDays" : effectiveDays, "minimumConsumption" : minimumConsumption, "orderLimit" : orderLimit};
            var serverUrl = "/vouchers/cash/create";
            if(voucherId != null && voucherId != ""){
                voucher["id"] = voucherId;
                serverUrl = "/vouchers/cash/update";
            }
            $.ajax({
                method: "POST",
                dataType: "json",
                url: serverUrl,
                contentType: "application/json; charset=utf-8",
                data: JSON.stringify({"voucher" : voucher})
            })
            .done(function( msg ) {
                alert("保存成功!");
                CashPage.reloadPage();
            });
        },

        removeVoucher : function(voucherId){
            $.ajax({
                method: "POST",
                dataType: "json",
                url: "/vouchers/cash/delete?voucherId=" + voucherId,
                contentType: "application/json; charset=utf-8",
            })
            .done(function( msg ) {
                alert("移除成功!");
                CashPage.reloadPage();
            });
        },
        
        reloadPage : function() {
            window.location.reload();
        }
    };
}();

$(document).ready(function() {
    CashPage.init();
});