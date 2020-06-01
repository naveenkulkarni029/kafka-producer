package org.nbk.demo.kafka.producer.model;

public class InternalProduct {

    private String productId;
    private String productName;
    private String productType;
    private String productDescription;
    private String productShortDesc;

    /**
     * @return the productDescription
     */
    public String getProductDescription() {
	return productDescription;
    }

    /**
     * @param productDescription
     *            the productDescription to set
     */
    public void setProductDescription(String productDescription) {
	this.productDescription = productDescription;
    }

    /**
     * @return the productId
     */
    public String getProductId() {
	return productId;
    }

    /**
     * @param productId
     *            the productId to set
     */
    public void setProductId(String productId) {
	this.productId = productId;
    }

    /**
     * @return the productName
     */
    public String getProductName() {
	return productName;
    }

    /**
     * @param productName
     *            the productName to set
     */
    public void setProductName(String productName) {
	this.productName = productName;
    }

    /**
     * @return the productType
     */
    public String getProductType() {
	return productType;
    }

    /**
     * @param productType
     *            the productType to set
     */
    public void setProductType(String productType) {
	this.productType = productType;
    }

    /**
     * @return the productShortDesc
     */
    public String getProductShortDesc() {
	return productShortDesc;
    }

    /**
     * @param productShortDesc
     *            the productShortDesc to set
     */
    public void setProductShortDesc(String productShortDesc) {
	this.productShortDesc = productShortDesc;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append("InternalProduct [productId=");
	builder.append(productId);
	builder.append(", productName=");
	builder.append(productName);
	builder.append(", productType=");
	builder.append(productType);
	builder.append(", productDescription=");
	builder.append(productDescription);
	builder.append(", productShortDesc=");
	builder.append(productShortDesc);
	builder.append("]");
	return builder.toString();
    }

}
