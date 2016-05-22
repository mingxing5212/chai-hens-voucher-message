package me.mingxing5212.chaihens.voucher.message.wechat.entity.card;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.sql.Timestamp;

/**
 * CardDetailEntity
 *
 * @author Mingxing Li
 * @date 15/5/16
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CardDetailEntity {

    private String card_type;
    private CashEntity cash;

    public String getCard_type() {
        return card_type;
    }

    public void setCard_type(String card_type) {
        this.card_type = card_type;
    }

    public CashEntity getCash() {
        return cash;
    }

    public void setCash(CashEntity cash) {
        this.cash = cash;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CashEntity {
        private BaseInfoEntity base_info;

        public BaseInfoEntity getBase_info() {
            return base_info;
        }

        public void setBase_info(BaseInfoEntity base_info) {
            this.base_info = base_info;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class BaseInfoEntity{
        private String id;
        private String logo_url;
        private String code_type;
        private String brand_name;
        private String title;
        private String sub_title;
        private DateInfo date_info;
        private String color;
        private String notice;
        private String description;
        private Integer get_limit;
        private Boolean can_share;
        private Boolean can_give_friend;
        private String status;
        private SkuInfo sku;
        private Timestamp create_time;
        private Timestamp update_time;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getLogo_url() {
            return logo_url;
        }

        public void setLogo_url(String logo_url) {
            this.logo_url = logo_url;
        }

        public String getCode_type() {
            return code_type;
        }

        public void setCode_type(String code_type) {
            this.code_type = code_type;
        }

        public String getBrand_name() {
            return brand_name;
        }

        public void setBrand_name(String brand_name) {
            this.brand_name = brand_name;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSub_title() {
            return sub_title;
        }

        public void setSub_title(String sub_title) {
            this.sub_title = sub_title;
        }

        public DateInfo getDate_info() {
            return date_info;
        }

        public void setDate_info(DateInfo date_info) {
            this.date_info = date_info;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public String getNotice() {
            return notice;
        }

        public void setNotice(String notice) {
            this.notice = notice;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Integer getGet_limit() {
            return get_limit;
        }

        public void setGet_limit(Integer get_limit) {
            this.get_limit = get_limit;
        }

        public Boolean getCan_share() {
            return can_share;
        }

        public void setCan_share(Boolean can_share) {
            this.can_share = can_share;
        }

        public Boolean getCan_give_friend() {
            return can_give_friend;
        }

        public void setCan_give_friend(Boolean can_give_friend) {
            this.can_give_friend = can_give_friend;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public SkuInfo getSku() {
            return sku;
        }

        public void setSku(SkuInfo sku) {
            this.sku = sku;
        }

        public Timestamp getCreate_time() {
            return create_time;
        }

        public void setCreate_time(Timestamp create_time) {
            this.create_time = create_time;
        }

        public Timestamp getUpdate_time() {
            return update_time;
        }

        public void setUpdate_time(Timestamp update_time) {
            this.update_time = update_time;
        }
    }

    public static class DateInfo{
        private String type;
        private Integer fixed_term;
        private Integer fixed_begin_term;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Integer getFixed_term() {
            return fixed_term;
        }

        public void setFixed_term(Integer fixed_term) {
            this.fixed_term = fixed_term;
        }

        public Integer getFixed_begin_term() {
            return fixed_begin_term;
        }

        public void setFixed_begin_term(Integer fixed_begin_term) {
            this.fixed_begin_term = fixed_begin_term;
        }
    }

    public static class SkuInfo{
        private Integer quantity;
        private Integer total_quantity;

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        public Integer getTotal_quantity() {
            return total_quantity;
        }

        public void setTotal_quantity(Integer total_quantity) {
            this.total_quantity = total_quantity;
        }
    }
}
