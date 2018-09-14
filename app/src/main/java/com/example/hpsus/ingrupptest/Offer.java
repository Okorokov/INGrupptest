package com.example.hpsus.ingrupptest;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Offer {
        /*id - порядковый номер оффера в базе, в принципе не имеет значения.
    name - наименование оффера
    des - краткое описание оффера
    logo - логотип оффера
    url - ссылка на оффер
    btn - текст на кнопке оффера на первом экране
    btn2 - текст на кнопке оффера на втором экране
    browser - true/false открывать ссылку на оффер в браузере по умолчанию или открывать ссылку внутри приложения Webview
    enabled - true/false отображать оффер или нет.
    desc_full - полное описание оффера*/


            @SerializedName("id")
            @Expose
            private Integer id;
            @SerializedName("name")
            @Expose
            private String name;
            @SerializedName("des")
            @Expose
            private String des;
            @SerializedName("logo")
            @Expose
            private String logo;
            @SerializedName("url")
            @Expose
            private String url;
            @SerializedName("btn")
            @Expose
            private String btn;
            @SerializedName("btn2")
            @Expose
            private String btn2;
            @SerializedName("browser")
            @Expose
            private Boolean browser;
            @SerializedName("enabled")
            @Expose
            private Boolean enabled;
            @SerializedName("desc_full")
            @Expose
            private String descFull;

    public Offer(Integer id, String name, String des, String logo, String url, String btn, String btn2, Boolean browser, Boolean enabled, String descFull) {
        this.id = id;
        this.name = name;
        this.des = des;
        this.logo = logo;
        this.url = url;
        this.btn = btn;
        this.btn2 = btn2;
        this.browser = browser;
        this.enabled = enabled;
        this.descFull = descFull;
    }
    public Offer() {

    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDes() {
        return des;
    }

    public String getLogo() {
        return logo;
    }

    public String getUrl() {
        return url;
    }

    public String getBtn() {
        return btn;
    }

    public String getBtn2() {
        return btn2;
    }

    public Boolean getBrowser() {
        return browser;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public String getDescFull() {
        return descFull;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setBtn(String btn) {
        this.btn = btn;
    }

    public void setBtn2(String btn2) {
        this.btn2 = btn2;
    }

    public void setBrowser(Boolean browser) {
        this.browser = browser;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public void setDescFull(String descFull) {
        this.descFull = descFull;
    }
}