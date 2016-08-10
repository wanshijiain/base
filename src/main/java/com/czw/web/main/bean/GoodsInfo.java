package com.czw.web.main.bean;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 * 
 * @author ZeviChen
 * @Date 2016-08-10 12:52:23
 */
@Entity("goods_info")
public class GoodsInfo implements java.io.Serializable{

	private static final long serialVersionUID = 8565901588293456408L;
	@Id
	private String id;
	private Long goodsId;
	private String goodsName;
	private String goodsCode;
	private String goodsLogo;
	private Integer goodsNum;
	private String goodsWeight;
	private String goodsPics;
	private Double nowPrice;
	private String types;
	private String goodsContext;
	private String onTime;
	private String createTime;
	private Integer initNum;
	private Integer saleNum;
	private String offTime;
	private String note;
	private Integer packageNum;
	private Integer status;
	private Double nomalPrice;
	private String refeeStatus;
	private String attentions;
	private Double msgScore;
	private String belongPerson;
	private String belongPrice;
	private String beyondKind;
	private String belongWeight;
	private String sendCity;
	private String belongFunc;
	private String storageCit;
	private String sendTimeScope;
	private String goodsStatus;
	private String sourceCity;
	private Integer score;
	private Integer isFree;
	private Integer isSec;
	private String linkFree;
	private Integer goodsBuynumber;
	private Integer isSpecial;
	private Integer isTuan;
	private Double badScore;
	private Integer isPre;
	private Integer goodsBase;
	private Integer familyBuyNum;
	private String goodsDescribe;
	private Integer isFamily;
	private Integer rebateId;
	private Integer capacity;
	private Integer familyPackageItemId;
	private Integer goodsRandom;
	private String alcohol;
	private Double comScore;
	private String colorLustre;
	private Integer oakAging;
	private String threeStageType;
	private Integer particularYear;
	private String texture;
	private String soberUpTime;
	private String fragrance;
	private String temperature;
	private String levelType;
	private String storageMethod;
	private String advise;
	
	private String linkFreeName;
	private String adviseWords;
	private String goodsWebPic;
	private Integer isNewClient;
	public GoodsInfo() {
	}

	public GoodsInfo(Long goodsId) {
		this.goodsId = goodsId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getGoodsId() {
		return goodsId;
	}

	public void setGoodsId(Long goodsId) {
		this.goodsId = goodsId;
	}

	public String getGoodsName() {
		return goodsName;
	}

	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}

	public String getGoodsCode() {
		return goodsCode;
	}

	public void setGoodsCode(String goodsCode) {
		this.goodsCode = goodsCode;
	}

	public String getGoodsLogo() {
		return goodsLogo;
	}

	public void setGoodsLogo(String goodsLogo) {
		this.goodsLogo = goodsLogo;
	}

	public Integer getGoodsNum() {
		return goodsNum;
	}

	public void setGoodsNum(Integer goodsNum) {
		this.goodsNum = goodsNum;
	}

	public String getGoodsWeight() {
		return goodsWeight;
	}

	public void setGoodsWeight(String goodsWeight) {
		this.goodsWeight = goodsWeight;
	}

	public String getGoodsPics() {
		return goodsPics;
	}

	public void setGoodsPics(String goodsPics) {
		this.goodsPics = goodsPics;
	}

	public Double getNowPrice() {
		return nowPrice;
	}

	public void setNowPrice(Double nowPrice) {
		this.nowPrice = nowPrice;
	}

	public String getTypes() {
		return types;
	}

	public void setTypes(String types) {
		this.types = types;
	}

	public String getGoodsContext() {
		return goodsContext;
	}

	public void setGoodsContext(String goodsContext) {
		this.goodsContext = goodsContext;
	}

	public String getOnTime() {
		return onTime;
	}

	public void setOnTime(String onTime) {
		this.onTime = onTime;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public Integer getInitNum() {
		return initNum;
	}

	public void setInitNum(Integer initNum) {
		this.initNum = initNum;
	}

	public Integer getSaleNum() {
		return saleNum;
	}

	public void setSaleNum(Integer saleNum) {
		this.saleNum = saleNum;
	}

	public String getOffTime() {
		return offTime;
	}

	public void setOffTime(String offTime) {
		this.offTime = offTime;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Integer getPackageNum() {
		return packageNum;
	}

	public void setPackageNum(Integer packageNum) {
		this.packageNum = packageNum;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Double getNomalPrice() {
		return nomalPrice;
	}

	public void setNomalPrice(Double nomalPrice) {
		this.nomalPrice = nomalPrice;
	}

	public String getRefeeStatus() {
		return refeeStatus;
	}

	public void setRefeeStatus(String refeeStatus) {
		this.refeeStatus = refeeStatus;
	}

	public String getAttentions() {
		return attentions;
	}

	public void setAttentions(String attentions) {
		this.attentions = attentions;
	}

	public Double getMsgScore() {
		return msgScore;
	}

	public void setMsgScore(Double msgScore) {
		this.msgScore = msgScore;
	}

	public String getBelongPerson() {
		return belongPerson;
	}

	public void setBelongPerson(String belongPerson) {
		this.belongPerson = belongPerson;
	}

	public String getBelongPrice() {
		return belongPrice;
	}

	public void setBelongPrice(String belongPrice) {
		this.belongPrice = belongPrice;
	}

	public String getBeyondKind() {
		return beyondKind;
	}

	public void setBeyondKind(String beyondKind) {
		this.beyondKind = beyondKind;
	}

	public String getBelongWeight() {
		return belongWeight;
	}

	public void setBelongWeight(String belongWeight) {
		this.belongWeight = belongWeight;
	}

	public String getSendCity() {
		return sendCity;
	}

	public void setSendCity(String sendCity) {
		this.sendCity = sendCity;
	}

	public String getBelongFunc() {
		return belongFunc;
	}

	public void setBelongFunc(String belongFunc) {
		this.belongFunc = belongFunc;
	}

	public String getStorageCit() {
		return storageCit;
	}

	public void setStorageCit(String storageCit) {
		this.storageCit = storageCit;
	}

	public String getSendTimeScope() {
		return sendTimeScope;
	}

	public void setSendTimeScope(String sendTimeScope) {
		this.sendTimeScope = sendTimeScope;
	}

	public String getGoodsStatus() {
		return goodsStatus;
	}

	public void setGoodsStatus(String goodsStatus) {
		this.goodsStatus = goodsStatus;
	}

	public String getSourceCity() {
		return sourceCity;
	}

	public void setSourceCity(String sourceCity) {
		this.sourceCity = sourceCity;
	}

	public Integer getScore() {
		return score;
	}

	public void setScore(Integer score) {
		this.score = score;
	}

	public Integer getIsFree() {
		return isFree;
	}

	public void setIsFree(Integer isFree) {
		this.isFree = isFree;
	}

	public Integer getIsSec() {
		return isSec;
	}

	public void setIsSec(Integer isSec) {
		this.isSec = isSec;
	}

	public String getLinkFree() {
		return linkFree;
	}

	public void setLinkFree(String linkFree) {
		this.linkFree = linkFree;
	}

	public Integer getGoodsBuynumber() {
		return goodsBuynumber;
	}

	public void setGoodsBuynumber(Integer goodsBuynumber) {
		this.goodsBuynumber = goodsBuynumber;
	}

	public Integer getIsSpecial() {
		return isSpecial;
	}

	public void setIsSpecial(Integer isSpecial) {
		this.isSpecial = isSpecial;
	}

	public Integer getIsTuan() {
		return isTuan;
	}

	public void setIsTuan(Integer isTuan) {
		this.isTuan = isTuan;
	}

	public Double getBadScore() {
		return badScore;
	}

	public void setBadScore(Double badScore) {
		this.badScore = badScore;
	}

	public Integer getIsPre() {
		return isPre;
	}

	public void setIsPre(Integer isPre) {
		this.isPre = isPre;
	}

	public Integer getGoodsBase() {
		return goodsBase;
	}

	public void setGoodsBase(Integer goodsBase) {
		this.goodsBase = goodsBase;
	}

	public Integer getFamilyBuyNum() {
		return familyBuyNum;
	}

	public void setFamilyBuyNum(Integer familyBuyNum) {
		this.familyBuyNum = familyBuyNum;
	}

	public String getGoodsDescribe() {
		return goodsDescribe;
	}

	public void setGoodsDescribe(String goodsDescribe) {
		this.goodsDescribe = goodsDescribe;
	}

	public Integer getIsFamily() {
		return isFamily;
	}

	public void setIsFamily(Integer isFamily) {
		this.isFamily = isFamily;
	}

	public Integer getRebateId() {
		return rebateId;
	}

	public void setRebateId(Integer rebateId) {
		this.rebateId = rebateId;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public Integer getFamilyPackageItemId() {
		return familyPackageItemId;
	}

	public void setFamilyPackageItemId(Integer familyPackageItemId) {
		this.familyPackageItemId = familyPackageItemId;
	}

	public Integer getGoodsRandom() {
		return goodsRandom;
	}

	public void setGoodsRandom(Integer goodsRandom) {
		this.goodsRandom = goodsRandom;
	}

	public String getAlcohol() {
		return alcohol;
	}

	public void setAlcohol(String alcohol) {
		this.alcohol = alcohol;
	}

	public Double getComScore() {
		return comScore;
	}

	public void setComScore(Double comScore) {
		this.comScore = comScore;
	}

	public String getColorLustre() {
		return colorLustre;
	}

	public void setColorLustre(String colorLustre) {
		this.colorLustre = colorLustre;
	}

	public Integer getOakAging() {
		return oakAging;
	}

	public void setOakAging(Integer oakAging) {
		this.oakAging = oakAging;
	}

	public String getThreeStageType() {
		return threeStageType;
	}

	public void setThreeStageType(String threeStageType) {
		this.threeStageType = threeStageType;
	}

	public Integer getParticularYear() {
		return particularYear;
	}

	public void setParticularYear(Integer particularYear) {
		this.particularYear = particularYear;
	}

	public String getTexture() {
		return texture;
	}

	public void setTexture(String texture) {
		this.texture = texture;
	}

	public String getSoberUpTime() {
		return soberUpTime;
	}

	public void setSoberUpTime(String soberUpTime) {
		this.soberUpTime = soberUpTime;
	}

	public String getFragrance() {
		return fragrance;
	}

	public void setFragrance(String fragrance) {
		this.fragrance = fragrance;
	}

	public String getTemperature() {
		return temperature;
	}

	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	public String getLevelType() {
		return levelType;
	}

	public void setLevelType(String levelType) {
		this.levelType = levelType;
	}

	public String getStorageMethod() {
		return storageMethod;
	}

	public void setStorageMethod(String storageMethod) {
		this.storageMethod = storageMethod;
	}

	public String getAdvise() {
		return advise;
	}

	public void setAdvise(String advise) {
		this.advise = advise;
	}

	public String getLinkFreeName() {
		return linkFreeName;
	}

	public void setLinkFreeName(String linkFreeName) {
		this.linkFreeName = linkFreeName;
	}

	public String getAdviseWords() {
		return adviseWords;
	}

	public void setAdviseWords(String adviseWords) {
		this.adviseWords = adviseWords;
	}

	public String getGoodsWebPic() {
		return goodsWebPic;
	}

	public void setGoodsWebPic(String goodsWebPic) {
		this.goodsWebPic = goodsWebPic;
	}

	public Integer getIsNewClient() {
		return isNewClient;
	}

	public void setIsNewClient(Integer isNewClient) {
		this.isNewClient = isNewClient;
	}
	
}