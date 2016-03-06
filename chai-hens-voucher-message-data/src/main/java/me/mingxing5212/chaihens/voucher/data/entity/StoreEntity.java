package me.mingxing5212.chaihens.voucher.data.entity;

/**
 * 实体店
 *
 * @author Mingxing Li
 * @date 21/2/16
 */
public class StoreEntity {
    private Long id;
    private String name;
    private String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
